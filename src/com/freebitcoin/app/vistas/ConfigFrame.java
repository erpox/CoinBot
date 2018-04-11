/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freebitcoin.app.vistas;

import static java.awt.Color.white;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class ConfigFrame extends javax.swing.JFrame {

    private final String PROP_PATH = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Roaming\\GT Tools\\config.properties";
    private final Properties PROP = new Properties();
    public JOptionPane pane;

    public ConfigFrame() {
        laf();
        initComponents();
        loadProps();
        monsterIP.setCaretColor(white);
        captchaKey.setCaretColor(white);
        proxyUser.setCaretColor(white);
        proxyPass.setCaretColor(white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        monsterIP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        captchaKey = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bonusRP = new javax.swing.JCheckBox();
        bonoBTC = new javax.swing.JCheckBox();
        backgroundStatus = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        proxyPass = new javax.swing.JTextField();
        proxyUser = new javax.swing.JTextField();
        AlwaysOnTop = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        activeWorkers = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 120, 215));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/capmonsterminipng.png"))); // NOI18N
        jLabel2.setText("CapMonster IP:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 120, 215));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Configuración");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px_2.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px_1.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px_1.png"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px_1.png"))); // NOI18N
        jButton1.setSelected(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 3, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 525, 30));

        monsterIP.setBackground(new java.awt.Color(51, 51, 51));
        monsterIP.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        monsterIP.setForeground(new java.awt.Color(220, 220, 220));
        monsterIP.setText("127.0.0.3");
        jPanel1.add(monsterIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 98, 145, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Key_20px.png"))); // NOI18N
        jLabel3.setText("Captcha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 53, -1, -1));

        captchaKey.setBackground(new java.awt.Color(51, 51, 51));
        captchaKey.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        captchaKey.setForeground(new java.awt.Color(220, 220, 220));
        captchaKey.setText("6bb66728c813db2c10301d064aea5fea");
        jPanel1.add(captchaKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 50, 200, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Workers_20px.png"))); // NOI18N
        jLabel5.setText("Mineros:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 80, 20));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        bonusRP.setBackground(new java.awt.Color(51, 51, 51));
        bonusRP.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        bonusRP.setForeground(new java.awt.Color(255, 255, 255));
        bonusRP.setText("Bonos Reward Point");
        jPanel1.add(bonusRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 140, -1));

        bonoBTC.setBackground(new java.awt.Color(51, 51, 51));
        bonoBTC.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        bonoBTC.setForeground(new java.awt.Color(255, 255, 255));
        bonoBTC.setText("Bonos BTC");
        jPanel1.add(bonoBTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 110, -1));

        backgroundStatus.setBackground(new java.awt.Color(51, 51, 51));
        backgroundStatus.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        backgroundStatus.setForeground(new java.awt.Color(255, 255, 255));
        backgroundStatus.setText("Segundo Plano");
        jPanel1.add(backgroundStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, 490, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png"))); // NOI18N
        jButton2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 261, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Star_Filled_20px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 202, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Loyalty_Card_20px.png"))); // NOI18N
        jLabel8.setLabelFor(bonoBTC);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 202, 30, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Hide_20px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 202, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Firewall_20px.png"))); // NOI18N
        jLabel10.setText("Proxy:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 145, -1, -1));

        proxyPass.setBackground(new java.awt.Color(51, 51, 51));
        proxyPass.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        proxyPass.setForeground(new java.awt.Color(220, 220, 220));
        proxyPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proxyPass.setText("Contraseña");
        jPanel1.add(proxyPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 143, 90, -1));

        proxyUser.setBackground(new java.awt.Color(51, 51, 51));
        proxyUser.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        proxyUser.setForeground(new java.awt.Color(220, 220, 220));
        proxyUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proxyUser.setText("Usuario");
        jPanel1.add(proxyUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 143, 90, -1));

        AlwaysOnTop.setBackground(new java.awt.Color(51, 51, 51));
        AlwaysOnTop.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        AlwaysOnTop.setForeground(new java.awt.Color(255, 255, 255));
        AlwaysOnTop.setText("Fijar ventana");
        AlwaysOnTop.setBorder(null);
        jPanel1.add(AlwaysOnTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 240, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_iMac_20px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        activeWorkers.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        activeWorkers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        jPanel1.add(activeWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 60, 20));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, -1, 290));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int n = JOptionPane.showConfirmDialog(rootPane, "Los cambios surtiran efecto cuando presiones \"Iniciar\" o reinicies la aplicación.", "Guardar", 2, 2);
        
        if (n == 0) {
            saveProp();
            this.dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AlwaysOnTop;
    private javax.swing.JComboBox<String> activeWorkers;
    private javax.swing.JCheckBox backgroundStatus;
    private javax.swing.JCheckBox bonoBTC;
    private javax.swing.JCheckBox bonusRP;
    private javax.swing.JTextField captchaKey;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField monsterIP;
    private javax.swing.JTextField proxyPass;
    private javax.swing.JTextField proxyUser;
    // End of variables declaration//GEN-END:variables

    public void saveProp() {
        PROP.setProperty("activeWorkers", activeWorkers.getSelectedItem().toString());
        PROP.setProperty("proxyUser", proxyUser.getText());
        PROP.setProperty("backGroundSelectSatatus", String.valueOf(backgroundStatus.isSelected()));
        PROP.setProperty("bonoBtcSelectStatus", String.valueOf(bonoBTC.isSelected()));
        PROP.setProperty("proxyPass", proxyPass.getText());
        PROP.setProperty("bonoRpelectStatus", String.valueOf(bonusRP.isSelected()));
        PROP.setProperty("TwoCaptchaKey", captchaKey.getText());
        PROP.setProperty("capMonsterIP", monsterIP.getText());
        PROP.setProperty("alwaysTop", String.valueOf(AlwaysOnTop.isSelected()));

        try {
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(ConfigFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void laf() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public final void loadProps() {
        try {
            PROP.load(new FileReader(PROP_PATH));
            captchaKey.setText(PROP.getProperty("TwoCaptchaKey"));
            monsterIP.setText(PROP.getProperty("capMonsterIP"));
            proxyUser.setText(PROP.getProperty("proxyUser"));
            proxyPass.setText(PROP.getProperty("proxyPass"));

            activeWorkers.setSelectedItem(PROP.getProperty("activeWorkers"));
            AlwaysOnTop.setSelected(Boolean.valueOf(PROP.getProperty("alwaysTop")));
            bonusRP.setSelected(Boolean.valueOf(PROP.getProperty("bonoRpelectStatus")));
            bonoBTC.setSelected(Boolean.valueOf(PROP.getProperty("bonoBtcSelectStatus")));
            backgroundStatus.setSelected(Boolean.valueOf(PROP.getProperty("backGroundSelectSatatus")));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
