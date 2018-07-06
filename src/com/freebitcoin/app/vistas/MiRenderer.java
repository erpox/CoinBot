// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.vistas;

import java.awt.Color;
import java.awt.Component;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.JXTable;

public class MiRenderer extends JXTable
{
    public Component prepareRenderer(final TableCellRenderer renderer, final int rowIndex, final int columnIndex) {
        final Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);
        if (String.class.equals(this.getColumnClass(columnIndex)) && this.getValueAt(rowIndex, columnIndex) != null) {
            final String val = String.valueOf(this.getValueAt(rowIndex, columnIndex));
            if (val.equals(" ¡Aun no es la hora del Roll!")) {
                component.setForeground(new Color(9, 142, 255));
                component.setFont(component.getFont().deriveFont(1));
            }
        }
        if (String.class.equals(this.getColumnClass(columnIndex)) && this.getValueAt(rowIndex, columnIndex) != null) {
            final String val = String.valueOf(this.getValueAt(rowIndex, columnIndex));
            if (val.equals(" Cargando perfil... ") 
                    || val.equals(" Abriendo navegador...") 
                    || val.equals(" Cargando https://freebitco.in/") 
                    || val.equals(" Verificando bonos...") 
                    || val.equals(" Bonos activados...") 
                    || val.equals(" Resolviendo Captcha...") 
                    || val.equals(" Cerrando Perfil...") 
                    || val.contains(" Resolviendo Captcha... Intento") 
                    || val.contains(" Intentando Roll gratis")) {
                component.setForeground(new Color(3, 155, 229));
                component.setFont(component.getFont().deriveFont(1));
            }
            if (val.contains("error") 
                    || val.equals(" Necesita verificar email") 
                    || val.contains(" 2Captcha API Key Incorrecto") 
                    || val.contains(" Sesión no iniciada") 
                    || val.contains(" IP Compartida") 
                    || val.contains(" Balance insuficiente") 
                    || val.contains(" IP Baneada")) {
                component.setForeground(new Color(198, 40, 40));
            }
            if (val.equals(" Esperando siguiente ronda") || val.contains("Retiro Exitoso")) {
                component.setForeground(new Color(255, 140, 0));
            }
            if (val.equals(" Cargando perfil.. ") 
                    || val.equals(" Abriendo navegador..") 
                    || val.equals(" Cargando https://freebitco.in/.") 
                    || val.equals(" Verificando bonos..") 
                    || val.equals(" Bonos activados..") 
                    || val.equals(" Resolviendo Captcha..") 
                    || val.equals(" Cerrando Perfil..") 
                    || val.contains(" Resolviendo Captcha.. Intento") 
                    || val.contains(" Intentando Roll gratis")) {
                component.setForeground(new Color(1, 87, 155));
                component.setFont(component.getFont().deriveFont(1));
            }
        }
        if (Integer.class.equals(this.getColumnClass(columnIndex)) && this.getValueAt(rowIndex, columnIndex) != null) {
            final int val2 = Integer.parseInt(this.getValueAt(rowIndex, columnIndex).toString());
            if (val2 > 0) {
                component.setForeground(new Color(255, 140, 0));
            }
            else {
                component.setForeground(new Color(51, 51, 51));
            }
        }
        return component;
    }
}
