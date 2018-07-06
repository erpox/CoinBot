// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.vistas;

import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Writer;
import java.io.FileWriter;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.LayoutManager;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.util.Properties;
import java.sql.Connection;
import javax.swing.JFrame;

public class LoginFrame extends JFrame implements Runnable
{
    private final String[] systemInfo;
    private final String[] systemInfoDB;
    private static String user;
    private static String password;
    private static String ID_BOT;
    private static String ID_BOT_DB;
    private boolean active;
    private Connection connection;
    private final Properties PROP;
    private final String PROP_PATH = "C:\\Program Files\\GT Tools\\CoinBot FreeBitcoin\\config.properties";
    private JButton jButton1;
    private JButton jButton2;
    private JCheckBox jCheckBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPasswordField jPasswordField1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextField jTextField1;
    
    public LoginFrame(final String[] systemInfo) {
        this.systemInfoDB = new String[5];
        this.PROP = new Properties();
        this.laf();
        this.initComponents();
        this.jLabel8.setVisible(false);
        this.systemInfo = systemInfo;
        this.proper();
    }
    
    @Override
    public Image getIconImage() {
        final Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("vistas/iconoCoinBOT.png"));
        return retValue;
    }
    
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.jTextField1 = new JTextField();
        this.jButton1 = new JButton();
        this.jSeparator1 = new JSeparator();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jSeparator2 = new JSeparator();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jCheckBox1 = new JCheckBox();
        this.jButton2 = new JButton();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jPasswordField1 = new JPasswordField();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.setTitle("CoinBot Mini v2.2.13");
        this.setBackground(new Color(250, 250, 250));
        this.setIconImage(this.getIconImage());
        this.setUndecorated(true);
        this.setResizable(false);
        this.getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
        this.jPanel2.setBackground(new Color(250, 250, 250));
        this.jPanel2.setLayout((LayoutManager)new AbsoluteLayout());
        this.jTextField1.setBackground(new Color(250, 250, 250));
        this.jTextField1.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.jTextField1.setBorder(null);
        this.jPanel2.add(this.jTextField1, new AbsoluteConstraints(100, 90, 180, 30));
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/inicioclaro.png")));
        this.jButton1.setBorder(null);
        this.jButton1.setContentAreaFilled(false);
        this.jButton1.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/iniciooscuro.png")));
        this.jButton1.setSelected(true);
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                LoginFrame.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton1, new AbsoluteConstraints(90, 299, -1, 40));
        this.jSeparator1.setBackground(new Color(0, 120, 215));
        this.jSeparator1.setForeground(new Color(0, 120, 215));
        this.jPanel2.add(this.jSeparator1, new AbsoluteConstraints(60, 120, 223, 1));
        this.jLabel2.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.jLabel2.setForeground(new Color(0, 120, 215));
        this.jLabel2.setText("Usuario");
        this.jPanel2.add(this.jLabel2, new AbsoluteConstraints(60, 60, -1, -1));
        this.jLabel3.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.jLabel3.setForeground(new Color(0, 120, 215));
        this.jLabel3.setText("Contrase\u00f1a");
        this.jPanel2.add(this.jLabel3, new AbsoluteConstraints(60, 140, -1, -1));
        this.jSeparator2.setBackground(new Color(0, 120, 215));
        this.jSeparator2.setForeground(new Color(0, 120, 215));
        this.jPanel2.add(this.jSeparator2, new AbsoluteConstraints(60, 200, 223, 1));
        this.jLabel4.setForeground(new Color(51, 102, 255));
        this.jLabel4.setText("¿Has olvidado tu contrasena?");
        this.jLabel4.setCursor(new Cursor(12));
        this.jPanel2.add(this.jLabel4, new AbsoluteConstraints(103, 360, -1, -1));
        this.jLabel5.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_User_25px.png")));
        this.jPanel2.add(this.jLabel5, new AbsoluteConstraints(61, 90, -1, 30));
        this.jLabel6.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Password_1_22px.png")));
        this.jPanel2.add(this.jLabel6, new AbsoluteConstraints(60, 173, -1, -1));
        this.jCheckBox1.setBackground(new Color(250, 250, 250));
        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("Guardar contrase\u00f1a");
        this.jPanel2.add(this.jCheckBox1, new AbsoluteConstraints(60, 210, -1, -1));
        this.jButton2.setBackground(new Color(250, 250, 250));
        this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px.png")));
        this.jButton2.setBorder(null);
        this.jButton2.setBorderPainted(false);
        this.jButton2.setContentAreaFilled(false);
        this.jButton2.setFocusable(false);
        this.jButton2.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px_1.png")));
        this.jButton2.setSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Cancel_25px_1.png")));
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                LoginFrame.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton2, new AbsoluteConstraints(316, 0, -1, -1));
        this.jLabel8.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/7YQl.gif")));
        this.jPanel2.add(this.jLabel8, new AbsoluteConstraints(250, 245, -1, -1));
        this.jLabel9.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel9.setHorizontalAlignment(0);
        this.jPanel2.add(this.jLabel9, new AbsoluteConstraints(90, 250, 150, 20));
        this.jPasswordField1.setBackground(new Color(250, 250, 250));
        this.jPasswordField1.setBorder(null);
        this.jPanel2.add(this.jPasswordField1, new AbsoluteConstraints(100, 170, 170, 30));
        this.getContentPane().add(this.jPanel2, new AbsoluteConstraints(264, 0, 340, 400));
        this.jPanel1.setBackground(new Color(245, 245, 245));
        this.jPanel1.setLayout((LayoutManager)new AbsoluteLayout());
        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/InicioSesion(1).png")));
        this.jLabel1.setLabelFor(this.jPanel1);
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 0, -1, -1));
        this.getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 260, -1));
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        if (this.jCheckBox1.isSelected()) {
            try {
                this.PROP.setProperty("user", this.jTextField1.getText());
                this.PROP.setProperty("pass", this.jPasswordField1.getText());
                this.PROP.store(new FileWriter(PROP_PATH), "CoinBot");
            }
            catch (IOException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        new Thread(this).start();
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        System.exit(0);
    }
    
    private boolean dbConnection() {
        try {
            final String connectionURl = "jdbc:sqlserver://45.77.112.89:1433;database=licenceDB;user=" + LoginFrame.user + ";password=" + LoginFrame.password + ";";
            this.connection = DriverManager.getConnection(connectionURl);
            return true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            if (e.getMessage().contains("No se pudo realizar la conexi\u00f3n")) {
                this.jLabel9.setText("");
                this.jLabel8.setVisible(false);
                JOptionPane.showMessageDialog(this, "No se pudo conectar con el servidor", "Error de conexion", 0);
                this.jButton1.setEnabled(true);
            }
            else if (e.getMessage().contains("Error de inicio de sesi\u00f3n ") || e.getMessage().contains("Login failed for user")) {
                this.jLabel9.setText("");
                this.jLabel8.setVisible(false);
                JOptionPane.showMessageDialog(this, "Usuario o clave invalida", "Error de inicio de sesion", 0);
                this.jButton1.setEnabled(true);
            }
            else if (e.getMessage().contains("ejecuci\u00f3n del desencadenador") || e.getMessage().contains("trigger execution")) {
                this.jLabel9.setText("");
                this.jLabel8.setVisible(false);
                JOptionPane.showMessageDialog(this, "Ha superado el limite de sesiones activas", "Error de inicio de sesion", 0);
                this.jButton1.setEnabled(true);
            }
            return false;
        }
    }
    
    private void resulSetLicencia() throws SQLException {
        final Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("select id_bot from licenceUsuarios where id_usuario='" + LoginFrame.user + "';");
        while (rs.next()) {
            LoginFrame.ID_BOT_DB = rs.getString("id_bot");
        }
        if (LoginFrame.ID_BOT_DB.contains(LoginFrame.ID_BOT)) {
            rs = stmt.executeQuery("select active_licence from licenceUsuarios where id_usuario='" + LoginFrame.user + "';");
            while (rs.next()) {
                this.active = rs.getBoolean("active_licence");
            }
            if (this.active) {
                rs = stmt.executeQuery("select * from licenceUsuarios where id_usuario='" + LoginFrame.user + "';");
                while (rs.next()) {
                    this.systemInfoDB[0] = rs.getString("id_Cpu");
                    this.systemInfoDB[1] = rs.getString("id_HDD");
                    this.systemInfoDB[2] = rs.getString("id_Bios");
                    this.systemInfoDB[3] = rs.getString("id_UUID");
                    this.systemInfoDB[4] = rs.getString("id_baseboard");
                }
            }
            else {
                stmt.executeUpdate("UPDATE licenceUsuarios SET active_licence='true',id_Cpu='" + this.systemInfo[0] + "', id_HDD='" + this.systemInfo[1] + "', id_Bios='" + this.systemInfo[2] + "', id_UUID='" + this.systemInfo[3] + "', id_baseboard='" + this.systemInfo[4] + "' WHERE id_usuario='" + LoginFrame.user + "';");
                rs = stmt.executeQuery("select * from licenceUsuarios where id_usuario='" + LoginFrame.user + "';");
                while (rs.next()) {
                    this.systemInfoDB[0] = rs.getString("id_Cpu");
                    this.systemInfoDB[1] = rs.getString("id_HDD");
                    this.systemInfoDB[2] = rs.getString("id_Bios");
                    this.systemInfoDB[3] = rs.getString("id_UUID");
                    this.systemInfoDB[4] = rs.getString("id_baseboard");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(this.rootPane, "Esta versi\u00f3n de coinBOT no es compatible con tu licencia", "Error de version ", 0);
        }
    }
    
    @Override
    public void run() {
        int f = 0;
        LoginFrame.user = this.jTextField1.getText();
        LoginFrame.password = this.jPasswordField1.getText();
        this.jLabel9.setText("Iniciando sesi\u00f3n");
        this.jLabel8.setVisible(true);
        this.jButton1.setEnabled(false);
        if (this.dbConnection()) {
            try {
                this.resulSetLicencia();
            }
            catch (SQLException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < 5; ++i) {
                if (this.systemInfo[i].equals(this.systemInfoDB[i])) {
                    ++f;
                }
            }
            if (f == 5) {
                try {
                    this.jLabel9.setText("Cargando Perfiles..");
                    new MainFrame(LoginFrame.user, LoginFrame.password).setVisible(true);
                    this.jLabel9.setText("Inicio de sesi\u00f3n exitoso.");
                    this.dispose();
                }
                catch (IOException ex2) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex2);
                }
            }
            else {
                this.jLabel9.setText("");
                this.jLabel8.setVisible(false);
                JOptionPane.showMessageDialog(this.rootPane, "Este equipo no esta autorizado para el uso de este programa", "Error de activacion", 0);
                System.exit(0);
            }
        }
    }
    
    public final void proper() {
        try {
            this.PROP.load(new FileReader(PROP_PATH));
            this.jTextField1.setText(this.PROP.getProperty("user"));
            this.jPasswordField1.setText(this.PROP.getProperty("pass"));
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex2) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }
    
    public final void laf() {
        try {
            for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static {
        LoginFrame.ID_BOT = "Mini";
    }
}
