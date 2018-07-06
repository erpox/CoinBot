// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.vistas;

import javax.swing.SwingUtilities;
import javax.swing.MenuSelectionManager;
import javax.swing.MenuElement;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableColumnModelEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.table.TableColumn;
import java.util.List;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import java.beans.PropertyChangeListener;
import javax.swing.event.TableColumnModelListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TableColumnManager implements MouseListener, ActionListener, TableColumnModelListener, PropertyChangeListener
{
    private JTable table;
    private TableColumnModel tcm;
    private boolean menuPopup;
    private List<TableColumn> allColumns;
    
    public TableColumnManager(final JTable table) {
        this(table, true);
    }
    
    public TableColumnManager(final JTable table, final boolean menuPopup) {
        this.table = table;
        this.setMenuPopup(menuPopup);
        table.addPropertyChangeListener(this);
        this.reset();
    }
    
    public void reset() {
        this.table.getColumnModel().removeColumnModelListener(this);
        (this.tcm = this.table.getColumnModel()).addColumnModelListener(this);
        final int count = this.tcm.getColumnCount();
        this.allColumns = new ArrayList<TableColumn>(count);
        for (int i = 0; i < count; ++i) {
            this.allColumns.add(this.tcm.getColumn(i));
        }
    }
    
    public boolean isMenuPopup() {
        return this.menuPopup;
    }
    
    public void setMenuPopup(final boolean menuPopup) {
        this.table.getTableHeader().removeMouseListener(this);
        if (menuPopup) {
            this.table.getTableHeader().addMouseListener(this);
        }
        this.menuPopup = menuPopup;
    }
    
    public void hideColumn(final int modelColumn) {
        final int viewColumn = this.table.convertColumnIndexToView(modelColumn);
        if (viewColumn != -1) {
            final TableColumn column = this.tcm.getColumn(viewColumn);
            this.hideColumn(column);
        }
    }
    
    public void hideColumn(final Object columnName) {
        if (columnName == null) {
            return;
        }
        for (int i = 0; i < this.tcm.getColumnCount(); ++i) {
            final TableColumn column = this.tcm.getColumn(i);
            if (columnName.equals(column.getHeaderValue())) {
                this.hideColumn(column);
                break;
            }
        }
    }
    
    public void hideColumn(final TableColumn column) {
        if (this.tcm.getColumnCount() == 1) {
            return;
        }
        this.tcm.removeColumnModelListener(this);
        this.tcm.removeColumn(column);
        this.tcm.addColumnModelListener(this);
    }
    
    public void showColumn(final int modelColumn) {
        for (final TableColumn column : this.allColumns) {
            if (column.getModelIndex() == modelColumn) {
                this.showColumn(column);
                break;
            }
        }
    }
    
    public void showColumn(final Object columnName) {
        for (final TableColumn column : this.allColumns) {
            if (column.getHeaderValue().equals(columnName)) {
                this.showColumn(column);
                break;
            }
        }
    }
    
    private void showColumn(final TableColumn column) {
        this.tcm.removeColumnModelListener(this);
        this.tcm.addColumn(column);
        final int position = this.allColumns.indexOf(column);
        final int from = this.tcm.getColumnCount() - 1;
        int to = 0;
        int i = position - 1;
        while (i > -1) {
            try {
                final TableColumn visibleColumn = this.allColumns.get(i);
                to = this.tcm.getColumnIndex(visibleColumn.getHeaderValue()) + 1;
            }
            catch (IllegalArgumentException ex) {
                --i;
                continue;
            }
            break;
        }
        this.tcm.moveColumn(from, to);
        this.tcm.addColumnModelListener(this);
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        this.checkForPopup(e);
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
        this.checkForPopup(e);
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
    
    private void checkForPopup(final MouseEvent e) {
        if (e.isPopupTrigger()) {
            final JTableHeader header = (JTableHeader)e.getComponent();
            final int column = header.columnAtPoint(e.getPoint());
            this.showPopup(column);
        }
    }
    
    private void showPopup(final int index) {
        final Object headerValue = this.tcm.getColumn(index).getHeaderValue();
        final int columnCount = this.tcm.getColumnCount();
        final JPopupMenu popup = new SelectPopupMenu();
        for (final TableColumn tableColumn : this.allColumns) {
            final Object value = tableColumn.getHeaderValue();
            final JCheckBoxMenuItem item = new JCheckBoxMenuItem(value.toString());
            item.addActionListener(this);
            try {
                this.tcm.getColumnIndex(value);
                item.setSelected(true);
                if (columnCount == 1) {
                    item.setEnabled(false);
                }
            }
            catch (IllegalArgumentException e) {
                item.setSelected(false);
            }
            popup.add(item);
            if (value == headerValue) {
                popup.setSelected(item);
            }
        }
        final JTableHeader header = this.table.getTableHeader();
        final Rectangle r = header.getHeaderRect(index);
        popup.show(header, r.x, r.height);
    }
    
    @Override
    public void actionPerformed(final ActionEvent event) {
        final JMenuItem item = (JMenuItem)event.getSource();
        if (item.isSelected()) {
            this.showColumn(item.getText());
        }
        else {
            this.hideColumn(item.getText());
        }
    }
    
    @Override
    public void columnAdded(final TableColumnModelEvent e) {
        final TableColumn column = this.tcm.getColumn(e.getToIndex());
        if (this.allColumns.contains(column)) {
            return;
        }
        this.allColumns.add(column);
    }
    
    @Override
    public void columnMoved(final TableColumnModelEvent e) {
        if (e.getFromIndex() == e.getToIndex()) {
            return;
        }
        int index = e.getToIndex();
        final TableColumn column = this.tcm.getColumn(index);
        this.allColumns.remove(column);
        if (index == 0) {
            this.allColumns.add(0, column);
        }
        else {
            --index;
            final TableColumn visibleColumn = this.tcm.getColumn(index);
            final int insertionColumn = this.allColumns.indexOf(visibleColumn);
            this.allColumns.add(insertionColumn + 1, column);
        }
    }
    
    @Override
    public void columnMarginChanged(final ChangeEvent e) {
    }
    
    @Override
    public void columnRemoved(final TableColumnModelEvent e) {
    }
    
    @Override
    public void columnSelectionChanged(final ListSelectionEvent e) {
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent e) {
        if ("model".equals(e.getPropertyName()) && this.table.getAutoCreateColumnsFromModel()) {
            this.reset();
        }
    }
    
    class SelectPopupMenu extends JPopupMenu
    {
        @Override
        public void setSelected(final Component sel) {
            final int index = this.getComponentIndex(sel);
            this.getSelectionModel().setSelectedIndex(index);
            final MenuElement[] me = { this, this.getSubElements()[index] };
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MenuSelectionManager.defaultManager().setSelectedPath(me);
                }
            });
        }
    }
}
