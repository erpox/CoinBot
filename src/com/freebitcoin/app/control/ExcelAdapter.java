// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control;

import java.util.StringTokenizer;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.KeyStroke;
import javax.swing.JTable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionListener;

public class ExcelAdapter implements ActionListener
{
    private String rowstring;
    private String value;
    private Clipboard system;
    private StringSelection stsel;
    private JTable jTable1;
    
    public ExcelAdapter(final JTable myJTable) {
        this.jTable1 = myJTable;
        final KeyStroke copy = KeyStroke.getKeyStroke(67, 2, false);
        final KeyStroke paste = KeyStroke.getKeyStroke(86, 2, false);
        this.jTable1.registerKeyboardAction(this, "Copy", copy, 0);
        this.jTable1.registerKeyboardAction(this, "Paste", paste, 0);
        this.system = Toolkit.getDefaultToolkit().getSystemClipboard();
    }
    
    public JTable getJTable() {
        return this.jTable1;
    }
    
    public void setJTable(final JTable jTable1) {
        this.jTable1 = jTable1;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getActionCommand().compareTo("Copy") == 0) {
            final StringBuffer sbf = new StringBuffer();
            final int numcols = this.jTable1.getSelectedColumnCount();
            final int numrows = this.jTable1.getSelectedRowCount();
            final int[] rowsselected = this.jTable1.getSelectedRows();
            final int[] colsselected = this.jTable1.getSelectedColumns();
            if (numrows - 1 != rowsselected[rowsselected.length - 1] - rowsselected[0] || numrows != rowsselected.length || numcols - 1 != colsselected[colsselected.length - 1] - colsselected[0] || numcols != colsselected.length) {
                JOptionPane.showMessageDialog(null, "Invalid Copy Selection", "Invalid Copy Selection", 0);
                return;
            }
            for (int i = 0; i < numrows; ++i) {
                for (int j = 0; j < numcols; ++j) {
                    sbf.append(this.jTable1.getValueAt(rowsselected[i], colsselected[j]));
                    if (j < numcols - 1) {
                        sbf.append("\t");
                    }
                }
                sbf.append("\n");
            }
            this.stsel = new StringSelection(sbf.toString());
            (this.system = Toolkit.getDefaultToolkit().getSystemClipboard()).setContents(this.stsel, this.stsel);
        }
        if (e.getActionCommand().compareTo("Paste") == 0) {
            final int startRow = this.jTable1.getSelectedRows()[0];
            final int startCol = this.jTable1.getSelectedColumns()[0];
            try {
                final String trstring = (String)this.system.getContents(this).getTransferData(DataFlavor.stringFlavor);
                final StringTokenizer st1 = new StringTokenizer(trstring, "\n");
                int k = 0;
                while (st1.hasMoreTokens()) {
                    this.rowstring = st1.nextToken();
                    final StringTokenizer st2 = new StringTokenizer(this.rowstring, "\t");
                    int j = 0;
                    while (st2.hasMoreTokens()) {
                        this.value = st2.nextToken();
                        if (startRow + k < this.jTable1.getRowCount() && startCol + j < this.jTable1.getColumnCount()) {
                            this.jTable1.setValueAt(this.value, startRow + k, startCol + j);
                        }
                        ++j;
                    }
                    ++k;
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
