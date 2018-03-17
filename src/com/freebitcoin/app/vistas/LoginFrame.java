package com.freebitcoin.app.vistas;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame implements Runnable {

    private final String[] systemInfo;
    private String[] systemInfoDB = new String[5];
    private static String user;
    private static String password;
    private Connection connection;

    public LoginFrame(String[] systemInfo) {
        initComponents();
        jLabel8.setVisible(false);
        this.systemInfo = systemInfo;

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Vistas/iconoCoinBOT.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CoinBot v1.0");
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jTextField1.setBorder(null);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 180, 30));

        jTextField2.setBackground(new java.awt.Color(240, 240, 240));
        jTextField2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jTextField2.setBorder(null);
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 170, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/inicioclaro.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/iniciooscuro.png"))); // NOI18N
        jButton1.setSelected(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 299, -1, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 120, 215));
        jSeparator1.setForeground(new java.awt.Color(0, 120, 215));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 223, 1));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 120, 215));
        jLabel2.setText("Usuario");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 120, 215));
        jLabel3.setText("Contraseña");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 120, 215));
        jSeparator2.setForeground(new java.awt.Color(0, 120, 215));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 223, 1));

        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("¿Has olvidado tu contraseña?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 360, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_User_25px.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 90, -1, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Password_1_22px.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 173, -1, -1));

        jCheckBox1.setText("Guardar contraseña");
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px_1.png"))); // NOI18N
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 0, -1, -1));

        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 285, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/7YQl.gif"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 245, -1, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 150, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 0, 340, 400));

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/InicioSesion(1).png"))); // NOI18N
        jLabel1.setLabelFor(jPanel1);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Thread(this).start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
 private boolean dbConnection() {
        try {
            String connectionURl = "jdbc:sqlserver://localhost;"
                    + "database=LicenceDB;"
                    + "user=" + user + ";"
                    + "password=" + password + ";";
            connection = DriverManager.getConnection(connectionURl);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if (e.getMessage().contains("No se pudo realizar la conexión")) {
                jLabel9.setText("");
                jLabel8.setVisible(false);
                JOptionPane.showMessageDialog(this, "No se pudo conectar con el servidor", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                jButton1.setEnabled(true);
            } else if (e.getMessage().contains("Error de inicio de sesión ") || e.getMessage().contains("Login failed for user")) {
                jLabel9.setText("");
                jLabel8.setVisible(false);
                JOptionPane.showMessageDialog(this, "Usuario o clave invalida", "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);
                jButton1.setEnabled(true);
            } else if (e.getMessage().contains("ejecución del desencadenador")) {
                jLabel9.setText("");
                jLabel8.setVisible(false);
                JOptionPane.showMessageDialog(this, "Ha superado el limite de sesiones activas", "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);
                jButton1.setEnabled(true);
            }

            return false;
        }
    }

    @SuppressWarnings("empty-statement")
    private void resulSetLicencia() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from licenceUsuarios where id_usuario='" + user + "'");
            while (rs.next()) {
                systemInfoDB[0] = rs.getString("id_Cpu");
                systemInfoDB[1] = rs.getString("id_HDD");
                systemInfoDB[2] = rs.getString("id_Bios");
                systemInfoDB[3] = rs.getString("id_UUID");
                systemInfoDB[4] = rs.getString("id_baseboard");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        int f = 0;
        user = jTextField1.getText();
        password = jTextField2.getText();

        jLabel9.setText("Iniciando sesión");
        jLabel8.setVisible(true);
        jButton1.setEnabled(false);
        if (dbConnection()) {
            resulSetLicencia();
            for (int i = 0; i < 5; i++) {
                if (systemInfo[i].equals(systemInfoDB[i])) {
                    f++;
                }
            }
            if (f == 5) {
                try {
                    jLabel9.setText("");
                    jLabel8.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Inicio de sesion satisfactorio", "Let's Make Money", 1);

                    new MainFrame().setVisible(true);
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                jLabel9.setText("");
                jLabel8.setVisible(false);
                JOptionPane.showMessageDialog(rootPane, "Este equipo no esta "
                        + "autorizado para el uso de este programa", "Error de activacion", JOptionPane.ERROR_MESSAGE);

                System.exit(0);
            }
        }
    }
}
