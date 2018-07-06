// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.vistas;

import javax.swing.JComponent;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JComponentTableCellRenderer implements TableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        return (JComponent)value;
    }
}
