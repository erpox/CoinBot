package com.freebitcoin.app.vistas;

import java.awt.Component;
import java.awt.Font;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.JXTable;

public class MiRenderer extends JXTable {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
        Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);

        if ((String.class.equals(this.getColumnClass(columnIndex))) && (getValueAt(rowIndex, columnIndex) != null)) {
            String val = String.valueOf(getValueAt(rowIndex, columnIndex));
            if (val.equals(" ¡Aun no es la hora del Roll!")) {
                component.setForeground(new java.awt.Color(9, 142, 255));
                component.setFont(component.getFont().deriveFont(Font.BOLD));
            }
        }
        if ((String.class.equals(this.getColumnClass(columnIndex))) && (getValueAt(rowIndex, columnIndex) != null)) {
            String val = String.valueOf(getValueAt(rowIndex, columnIndex));
            if (val.equals(" Cargando perfil... ") || val.equals(" Abriendo navegador...")
                    || val.equals(" Cargando https://freebitco.in/")
                    || val.equals(" Verificando bonos...")
                    || val.equals(" Bonos activados...") || val.equals(" Resolviendo Captcha...")
                    || val.equals(" ¡Roll listo!") || val.equals(" Cerrando Perfil...")
                    || val.contains(" Resolviendo Captcha... Intento")
                    || val.contains(" Intentando Roll gratis")) {
                component.setForeground(new java.awt.Color(9, 142, 255));
                component.setFont(component.getFont().deriveFont(Font.BOLD));

            }
            if (val.equals(" Ha ocurrido un error")
                    || val.equals(" Necesita verificar email")
                    || val.contains(" 2Captcha API Key Incorrecto")
                    || val.contains(" Sesión no iniciada")
                    || val.contains(" IP Compartida")) {
                component.setForeground(new java.awt.Color(198,40,40));
            }

            if (val.equals(" Esperando siguiente ronda")) {
                component.setForeground(new java.awt.Color(255, 140, 0));                
            }
            if (val.equals(" Cargando perfil.. ") || val.equals(" Abriendo navegador..")
                    || val.equals(" Cargando https://freebitco.in/.")
                    || val.equals(" Verificando bonos..")
                    || val.equals(" Bonos activados..") || val.equals(" Resolviendo Captcha..")
                    || val.equals(" ¡Roll listo!") || val.equals(" Cerrando Perfil..")
                    || val.contains(" Resolviendo Captcha.. Intento")
                    || val.contains(" Intentando Roll gratis")) {
                component.setForeground(new java.awt.Color(0, 200, 83));
                component.setFont(component.getFont().deriveFont(Font.BOLD));

            }
            
        }
        if ((Integer.class.equals(this.getColumnClass(columnIndex))) && (getValueAt(rowIndex, columnIndex) != null)) {
            int val2 = Integer.parseInt(getValueAt(rowIndex, columnIndex).toString());
            if (val2 > 0) {
                component.setForeground(new java.awt.Color(255, 140, 0));
            } else {
                component.setForeground(new java.awt.Color(51, 51, 51));
            }
        }

        return component;
    }
}
