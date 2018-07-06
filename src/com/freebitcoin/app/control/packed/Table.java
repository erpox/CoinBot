// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control.packed;

import java.time.chrono.ChronoLocalDateTime;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.Icon;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.freebitcoin.app.vistas.JComponentTableCellRenderer;
import javax.swing.JTable;

public class Table
{
    public void normalTable(final JTable jTable1) {
        final TableCellRenderer renderer = new JComponentTableCellRenderer();
        final TableColumnModel col = jTable1.getColumnModel();
        final Icon listicon0 = new ImageIcon(this.getClass().getClassLoader().getResource("vistas/icons8_Numeric_20px_1.png"));
        final JLabel iconLabel0 = new JLabel(listicon0);
        final TableColumn col2 = col.getColumn(0);
        col2.setHeaderValue(iconLabel0);
        col2.setHeaderRenderer(renderer);
        final TableColumn col3 = col.getColumn(1);
        col.getColumn(2).setHeaderValue("Balance");
        col.getColumn(3).setHeaderValue("Puntos");
        col.getColumn(5).setHeaderValue("<html><center>Roll<br>BTC</center></html>");
        col.getColumn(8).setHeaderValue("<html><center>Bono<br>RP</center></html>");
        col.getColumn(9).setHeaderValue("<html><center>Bono RP<br>FIN</center></html>");
        col.getColumn(12).setHeaderValue("<html><center>Bono BTC<br>FIN</center></html>");
        col.getColumn(14).setHeaderValue("Estado");
        col.getColumn(0).setPreferredWidth(30);
        col.getColumn(0).setWidth(30);
        col.getColumn(0).setMaxWidth(30);
        col.getColumn(1).setPreferredWidth(100);
        col.getColumn(1).setWidth(100);
        col.getColumn(1).setMaxWidth(100);
        col.getColumn(2).setPreferredWidth(80);
        col.getColumn(2).setWidth(80);
        col.getColumn(2).setMaxWidth(80);
        col.getColumn(3).setPreferredWidth(60);
        col.getColumn(3).setWidth(60);
        col.getColumn(3).setMaxWidth(60);
        col.getColumn(5).setPreferredWidth(50);
        col.getColumn(5).setWidth(50);
        col.getColumn(5).setMaxWidth(50);
        col.getColumn(5).setMinWidth(50);
        col.getColumn(6).setPreferredWidth(50);
        col.getColumn(6).setWidth(50);
        col.getColumn(6).setMaxWidth(50);
        col.getColumn(8).setPreferredWidth(60);
        col.getColumn(8).setWidth(60);
        col.getColumn(8).setMaxWidth(60);
        col.getColumn(9).setPreferredWidth(60);
        col.getColumn(9).setWidth(60);
        col.getColumn(9).setMaxWidth(60);
        col.getColumn(11).setPreferredWidth(60);
        col.getColumn(11).setWidth(60);
        col.getColumn(11).setMaxWidth(60);
        col.getColumn(12).setPreferredWidth(65);
        col.getColumn(12).setWidth(65);
        col.getColumn(12).setMaxWidth(65);
        col.getColumn(13).setPreferredWidth(70);
        col.getColumn(13).setWidth(70);
        col.getColumn(13).setMaxWidth(70);
        col.getColumn(14).setPreferredWidth(260);
        col.getColumn(14).setWidth(260);
        col.getColumn(14).setMaxWidth(260);
        col.getColumn(7).setPreferredWidth(0);
        col.getColumn(7).setMinWidth(0);
        col.getColumn(7).setWidth(0);
        col.getColumn(7).setMaxWidth(0);
        col.getColumn(10).setPreferredWidth(0);
        col.getColumn(10).setMinWidth(0);
        col.getColumn(10).setWidth(0);
        col.getColumn(10).setMaxWidth(0);
        col.getColumn(4).setPreferredWidth(0);
        col.getColumn(4).setMinWidth(0);
        col.getColumn(4).setWidth(0);
        col.getColumn(4).setMaxWidth(0);
    }
    
    public void advancedTable(final JTable jTable1) {
        final TableCellRenderer renderer = new JComponentTableCellRenderer();
        final TableColumnModel col = jTable1.getColumnModel();
        final Icon listicon0 = new ImageIcon(this.getClass().getClassLoader().getResource("vistas/icons8_Numeric_20px_1.png"));
        final JLabel iconLabel0 = new JLabel(listicon0);
        final TableColumn col2 = col.getColumn(0);
        col2.setHeaderValue(iconLabel0);
        col2.setHeaderRenderer(renderer);
        final TableColumn col3 = col.getColumn(1);
        col.getColumn(0).setPreferredWidth(30);
        col.getColumn(0).setMinWidth(30);
        col.getColumn(0).setWidth(30);
        col.getColumn(0).setMaxWidth(30);
        col.getColumn(1).setPreferredWidth(100);
        col.getColumn(1).setMinWidth(30);
        col.getColumn(1).setWidth(100);
        col.getColumn(1).setMaxWidth(150);
        col.getColumn(2).setPreferredWidth(70);
        col.getColumn(2).setMinWidth(30);
        col.getColumn(2).setWidth(70);
        col.getColumn(2).setMaxWidth(100);
        col.getColumn(3).setPreferredWidth(60);
        col.getColumn(3).setMinWidth(30);
        col.getColumn(3).setWidth(60);
        col.getColumn(3).setMaxWidth(60);
        col.getColumn(4).setPreferredWidth(60);
        col.getColumn(4).setMinWidth(40);
        col.getColumn(4).setWidth(60);
        col.getColumn(4).setMaxWidth(60);
        col.getColumn(5).setPreferredWidth(50);
        col.getColumn(5).setMinWidth(30);
        col.getColumn(5).setWidth(50);
        col.getColumn(5).setMaxWidth(50);
        col.getColumn(6).setPreferredWidth(50);
        col.getColumn(6).setMinWidth(30);
        col.getColumn(6).setWidth(50);
        col.getColumn(6).setMaxWidth(50);
        col.getColumn(7).setPreferredWidth(35);
        col.getColumn(7).setMinWidth(35);
        col.getColumn(7).setWidth(35);
        col.getColumn(7).setMaxWidth(35);
        col.getColumn(8).setPreferredWidth(70);
        col.getColumn(8).setMinWidth(70);
        col.getColumn(8).setWidth(70);
        col.getColumn(8).setMaxWidth(100);
        col.getColumn(9).setPreferredWidth(70);
        col.getColumn(9).setMinWidth(70);
        col.getColumn(9).setWidth(70);
        col.getColumn(9).setMaxWidth(100);
        col.getColumn(10).setPreferredWidth(35);
        col.getColumn(10).setMinWidth(35);
        col.getColumn(10).setWidth(35);
        col.getColumn(10).setMaxWidth(35);
    }
    
    public void withdrawTable(final JTable jTable1) {
        final TableColumnModel col = jTable1.getColumnModel();
        col.getColumn(2).setHeaderValue("Wallet");
        col.getColumn(3).setHeaderValue("Balance");
        col.getColumn(5).setHeaderValue("<html>Cantidad<br>Retirada</html>");
        col.getColumn(8).setHeaderValue("<html>Balance<br>Disponible<html>");
        col.getColumn(0).setPreferredWidth(30);
        col.getColumn(0).setWidth(30);
        col.getColumn(0).setMaxWidth(30);
        col.getColumn(1).setMaxWidth(150);
        col.getColumn(1).setMinWidth(50);
        col.getColumn(1).setPreferredWidth(150);
        col.getColumn(1).setWidth(150);
        col.getColumn(2).setPreferredWidth(270);
        col.getColumn(2).setWidth(270);
        col.getColumn(2).setMaxWidth(270);
        col.getColumn(3).setPreferredWidth(80);
        col.getColumn(3).setWidth(80);
        col.getColumn(3).setMaxWidth(80);
        col.getColumn(5).setPreferredWidth(80);
        col.getColumn(5).setWidth(80);
        col.getColumn(5).setMaxWidth(80);
        col.getColumn(5).setMinWidth(80);
        col.getColumn(8).setPreferredWidth(80);
        col.getColumn(8).setWidth(80);
        col.getColumn(8).setMaxWidth(80);
        col.getColumn(14).setPreferredWidth(80);
        col.getColumn(14).setWidth(80);
        col.getColumn(14).setMaxWidth(250);
        col.getColumn(4).setPreferredWidth(0);
        col.getColumn(4).setMinWidth(0);
        col.getColumn(4).setWidth(0);
        col.getColumn(4).setMaxWidth(0);
        col.getColumn(6).setPreferredWidth(0);
        col.getColumn(6).setMinWidth(0);
        col.getColumn(6).setWidth(0);
        col.getColumn(6).setMaxWidth(0);
        col.getColumn(7).setPreferredWidth(0);
        col.getColumn(7).setMinWidth(0);
        col.getColumn(7).setWidth(0);
        col.getColumn(7).setMaxWidth(0);
        col.getColumn(10).setPreferredWidth(0);
        col.getColumn(10).setMinWidth(0);
        col.getColumn(10).setWidth(0);
        col.getColumn(10).setMaxWidth(0);
        col.getColumn(11).setPreferredWidth(0);
        col.getColumn(11).setMinWidth(0);
        col.getColumn(11).setWidth(0);
        col.getColumn(11).setMaxWidth(0);
        col.getColumn(12).setPreferredWidth(0);
        col.getColumn(12).setMinWidth(0);
        col.getColumn(12).setWidth(0);
        col.getColumn(12).setMaxWidth(0);
        col.getColumn(13).setPreferredWidth(0);
        col.getColumn(13).setMinWidth(0);
        col.getColumn(13).setWidth(0);
        col.getColumn(13).setMaxWidth(0);
        col.getColumn(9).setPreferredWidth(0);
        col.getColumn(9).setMinWidth(0);
        col.getColumn(9).setWidth(0);
        col.getColumn(9).setMaxWidth(0);
    }
    
    public void tableReOrder(final DefaultTableModel model, final LocalDateTime[] nextRollArray, final int[] balanceTotal) {
        final String[] puntosReward = new String[model.getRowCount()];
        final String[] porcen = new String[model.getRowCount()];
        final int[] rollbtc = new int[model.getRowCount()];
        final int[] rollPuntos = new int[model.getRowCount()];
        final Boolean[] rpActi = new Boolean[model.getRowCount()];
        final String[] bonoRP = new String[model.getRowCount()];
        final String[] bonoRPFin = new String[model.getRowCount()];
        final Boolean[] btcActi = new Boolean[model.getRowCount()];
        final String[] bonoBTC = new String[model.getRowCount()];
        final String[] bonoBTCFin = new String[model.getRowCount()];
        final String[] proxRoll = new String[model.getRowCount()];
        final String[] status = new String[model.getRowCount()];
        final String[] newProfile = new String[model.getRowCount()];
        for (int i = 0; i < model.getRowCount(); ++i) {
            newProfile[i] = (String)model.getValueAt(i, 1);
            puntosReward[i] = (String)model.getValueAt(i, 3);
            rollbtc[i] = (int)model.getValueAt(i, 5);
            rollPuntos[i] = (int)model.getValueAt(i, 5);
            rpActi[i] = (Boolean)model.getValueAt(i, 7);
            bonoRP[i] = (String)model.getValueAt(i, 8);
            bonoRPFin[i] = (String)model.getValueAt(i, 9);
            btcActi[i] = (Boolean)model.getValueAt(i, 10);
            bonoBTC[i] = (String)model.getValueAt(i, 11);
            bonoBTCFin[i] = (String)model.getValueAt(i, 12);
            proxRoll[i] = (String)model.getValueAt(i, 13);
            status[i] = (String)model.getValueAt(i, 14);
        }
        int cuentaintercambios = 0;
        boolean ordenado = false;
        while (!ordenado) {
            for (int j = 0; j < model.getRowCount() - 1; ++j) {
                if (nextRollArray[j].isAfter(nextRollArray[j + 1])) {
                    final LocalDateTime horaAux = nextRollArray[j];
                    nextRollArray[j] = nextRollArray[j + 1];
                    nextRollArray[j + 1] = horaAux;
                    final String perfilAux = newProfile[j];
                    newProfile[j] = newProfile[j + 1];
                    newProfile[j + 1] = perfilAux;
                    final int balanceAux = balanceTotal[j];
                    balanceTotal[j] = balanceTotal[j + 1];
                    balanceTotal[j + 1] = balanceAux;
                    final String puntosAux = puntosReward[j];
                    puntosReward[j] = puntosReward[j + 1];
                    puntosReward[j + 1] = puntosAux;
                    final int rollBTCAux = rollbtc[j];
                    rollbtc[j] = rollbtc[j + 1];
                    rollbtc[j + 1] = rollBTCAux;
                    final int rollPuntosAux = rollPuntos[j];
                    rollPuntos[j] = rollPuntos[j + 1];
                    rollPuntos[j + 1] = rollPuntosAux;
                    final String porcentajeAux = porcen[j];
                    porcen[j] = porcen[j + 1];
                    porcen[j + 1] = porcentajeAux;
                    final boolean rpActiAux = rpActi[j];
                    rpActi[j] = rpActi[j + 1];
                    rpActi[j + 1] = rpActiAux;
                    final String bonoRPAux = bonoRP[j];
                    bonoRP[j] = bonoRP[j + 1];
                    bonoRP[j + 1] = bonoRPAux;
                    final String bonoRPFinAux = bonoRPFin[j];
                    bonoRPFin[j] = bonoRPFin[j + 1];
                    bonoRPFin[j + 1] = bonoRPFinAux;
                    final boolean btcActiAux = btcActi[j];
                    btcActi[j] = btcActi[j + 1];
                    btcActi[j + 1] = btcActiAux;
                    final String bonoBTCAux = bonoBTC[j];
                    bonoBTC[j] = bonoBTC[j + 1];
                    bonoBTC[j + 1] = bonoBTCAux;
                    final String bonoBTCFinAux = bonoBTCFin[j];
                    bonoBTCFin[j] = bonoBTCFin[j + 1];
                    bonoBTCFin[j + 1] = bonoBTCFinAux;
                    final String proxRollAux = proxRoll[j];
                    proxRoll[j] = proxRoll[j + 1];
                    proxRoll[j + 1] = proxRollAux;
                    final String statusAux = status[j];
                    status[j] = status[j + 1];
                    status[j + 1] = statusAux;
                }
            }
            if (cuentaintercambios == 0) {
                ordenado = true;
            }
            cuentaintercambios = 0;
        }
        for (int k = 0; k < model.getRowCount(); ++k) {
            model.setValueAt(newProfile[k], k, 1);
            model.setValueAt(String.format("%,d", balanceTotal[k]), k, 2);
            model.setValueAt(puntosReward[k], k, 3);
            model.setValueAt(0, k, 5);
            model.setValueAt(0, k, 6);
            model.setValueAt(rpActi[k], k, 7);
            model.setValueAt(bonoRP[k], k, 8);
            model.setValueAt(bonoRPFin[k], k, 9);
            model.setValueAt(btcActi[k], k, 10);
            model.setValueAt(bonoBTC[k], k, 11);
            model.setValueAt(bonoBTCFin[k], k, 12);
            model.setValueAt(proxRoll[k], k, 13);
            if (status[k].contains("Abriendo navegador") || status[k].contains("Cargando")) {
                model.setValueAt(" Esperando siguiente ronda", k, 14);
            }
            else {
                model.setValueAt(status[k], k, 14);
            }
        }
    }
}
