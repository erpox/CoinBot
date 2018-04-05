package com.freebitcoin.app.vistas;

import com.freebitcoin.app.control.BtcPrice;
import com.freebitcoin.app.control.SaloCaptchas;
import com.freebitcoin.app.miners.Worker;
import com.freebitcoin.app.miners.Worker2;
import com.freebitcoin.app.miners.Worker3;
import com.freebitcoin.app.miners.Worker4;
import com.freebitcoin.app.miners.Worker5;
import com.freebitcoin.app.miners.Worker6;
import com.freebitcoin.app.miners.Worker7;
import com.freebitcoin.app.control.Proxies;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.ExecutionException;
import java.util.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import static org.openqa.selenium.io.FileHandler.delete;

public class MainFrame extends javax.swing.JFrame {

    private int w1 = 0;
    private int w2 = 0;
    private int w3 = 0;
    private int w4 = 0;
    private int w5 = 0;
    private int w6 = 0;
    private int w7 = 0;
    private int dia = 0;
    private Timer timer;
    private File ficheroPerfil2;
    private final DefaultTableModel model;
    private volatile Worker worker;
    private volatile Worker2 worker2;
    private volatile Worker3 worker3;
    private volatile Worker4 worker4;
    private volatile Worker5 worker5;
    private volatile Worker6 worker6;
    private volatile Worker7 worker7;
    private boolean semaforoWorker3 = false,
            semaforoWorker2 = false,
            semaforoWorker1 = false,
            semaforoWorker4 = false,
            semaforoWorker5 = false,
            semaforoWorker6 = false,
            semaforoWorker7 = false;
    private LocalDateTime[] nextRollArray;
    private ArrayList<Integer> balanceRoll = new ArrayList<>();
    private int[] balanceTotal;
    private boolean pause = true;
    private LocalTime reloj = LocalTime.of(00, 00, 00);
    private final ArrayList<String> proxyRuta = new ArrayList<>();
    private final ArrayList<Proxies> proxies = new ArrayList<>();
    private final Properties PROP = new Properties();
    private final String PROP_PATH = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Roaming\\GT Tools\\config.properties";
    private int saldoToken;
    private String saldo;
    private final String user;
    private final String pass;
    private String captchaStr;

    public MainFrame(String user, String pass) throws IOException {

        initComponents();
        properties();
        model = (DefaultTableModel) jTable1.getModel();
        loadPerfiles();
        BotonResume.setVisible(false);
        loadArrays();
        loadProxies();
        sheduleSaldos();
        this.user = user;
        this.pass = pass;

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Vistas/iconoCoinBOT.png"));
        return retValue;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupMiners = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        proxyCredentials = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        proxyUser = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        imageTyper = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        imageUser = new javax.swing.JTextField();
        buttonGroupCaptcha = new javax.swing.ButtonGroup();
        antiCaptcheKey = new javax.swing.JPanel();
        antiCaptchaKey = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        twoCaptchaPane = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        twoCaptchaKey = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        EstadoInfo = new javax.swing.JLabel();
        captchaSaldo = new javax.swing.JLabel();
        botonBorrarPerfil = new javax.swing.JButton();
        botonIniciar = new javax.swing.JButton();
        labelBalancetotal = new javax.swing.JLabel();
        LogoLabel = new javax.swing.JLabel();
        BotonPause = new javax.swing.JButton();
        labelBackGroundStatus = new javax.swing.JLabel();
        labelBonoRP = new javax.swing.JLabel();
        separator = new javax.swing.JLabel();
        separator2 = new javax.swing.JLabel();
        separato3 = new javax.swing.JLabel();
        btcPriiceLabel = new javax.swing.JLabel();
        BotonResume = new javax.swing.JButton();
        activeWorkerLabel = new javax.swing.JLabel();
        acticeWorlerLabel1 = new javax.swing.JLabel();
        separator4 = new javax.swing.JLabel();
        labelBonoBTC = new javax.swing.JLabel();
        relojLabel = new javax.swing.JLabel();
        separator5 = new javax.swing.JLabel();
        labelSesion1 = new javax.swing.JLabel();
        separator6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 =  jTable1 = new MiRenderer();
        relojLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        CaptchaKey = new javax.swing.JMenuItem();
        antCaptchaKey = new javax.swing.JMenuItem();
        proxyAuth = new javax.swing.JMenuItem();
        activarMenu = new javax.swing.JMenu();
        checkBonusRP = new javax.swing.JCheckBoxMenuItem();
        checkBonusBTC = new javax.swing.JCheckBoxMenuItem();
        BackGroundStatus = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        checkWorker1 = new javax.swing.JRadioButtonMenuItem();
        checkWorker2 = new javax.swing.JRadioButtonMenuItem();
        checkWorker3 = new javax.swing.JRadioButtonMenuItem();
        checkWorker4 = new javax.swing.JRadioButtonMenuItem();
        checkWorker5 = new javax.swing.JRadioButtonMenuItem();
        checkWorker6 = new javax.swing.JRadioButtonMenuItem();
        checkWorker7 = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();

        jPopupMenu1.setToolTipText("");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Firefox_15px.png"))); // NOI18N
        jMenuItem1.setText("Abrir perfil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jLabel3.setText("Usuario");

        jLabel9.setText("Contraseña");

        javax.swing.GroupLayout proxyCredentialsLayout = new javax.swing.GroupLayout(proxyCredentials);
        proxyCredentials.setLayout(proxyCredentialsLayout);
        proxyCredentialsLayout.setHorizontalGroup(
            proxyCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proxyCredentialsLayout.createSequentialGroup()
                .addGroup(proxyCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGap(0, 207, Short.MAX_VALUE))
            .addGroup(proxyCredentialsLayout.createSequentialGroup()
                .addGroup(proxyCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(proxyUser, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addContainerGap())
        );
        proxyCredentialsLayout.setVerticalGroup(
            proxyCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proxyCredentialsLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(proxyUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("ImageTypers API Key");

        javax.swing.GroupLayout imageTyperLayout = new javax.swing.GroupLayout(imageTyper);
        imageTyper.setLayout(imageTyperLayout);
        imageTyperLayout.setHorizontalGroup(
            imageTyperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageUser)
            .addGroup(imageTyperLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 149, Short.MAX_VALUE))
        );
        imageTyperLayout.setVerticalGroup(
            imageTyperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageTyperLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(imageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setText("CapMonster IP");

        javax.swing.GroupLayout antiCaptcheKeyLayout = new javax.swing.GroupLayout(antiCaptcheKey);
        antiCaptcheKey.setLayout(antiCaptcheKeyLayout);
        antiCaptcheKeyLayout.setHorizontalGroup(
            antiCaptcheKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(antiCaptchaKey, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel15)
        );
        antiCaptcheKeyLayout.setVerticalGroup(
            antiCaptcheKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(antiCaptcheKeyLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(antiCaptchaKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        twoCaptchaPane.setPreferredSize(new java.awt.Dimension(253, 49));

        jLabel12.setText("2Captcha API Key");

        javax.swing.GroupLayout twoCaptchaPaneLayout = new javax.swing.GroupLayout(twoCaptchaPane);
        twoCaptchaPane.setLayout(twoCaptchaPaneLayout);
        twoCaptchaPaneLayout.setHorizontalGroup(
            twoCaptchaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(twoCaptchaKey)
            .addGroup(twoCaptchaPaneLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 166, Short.MAX_VALUE))
        );
        twoCaptchaPaneLayout.setVerticalGroup(
            twoCaptchaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(twoCaptchaPaneLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(4, 4, 4)
                .addComponent(twoCaptchaKey, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CoinBot v1.0");
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 120, 215));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EstadoInfo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        EstadoInfo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(EstadoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        captchaSaldo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        captchaSaldo.setForeground(new java.awt.Color(255, 255, 255));
        captchaSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        captchaSaldo.setText("Saldo Captcha");
        captchaSaldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                captchaSaldoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                captchaSaldoMouseExited(evt);
            }
        });
        jPanel1.add(captchaSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 673, 140, -1));

        botonBorrarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_1.png"))); // NOI18N
        botonBorrarPerfil.setBorder(null);
        botonBorrarPerfil.setBorderPainted(false);
        botonBorrarPerfil.setContentAreaFilled(false);
        botonBorrarPerfil.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png"))); // NOI18N
        botonBorrarPerfil.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png"))); // NOI18N
        botonBorrarPerfil.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png"))); // NOI18N
        botonBorrarPerfil.setVerifyInputWhenFocusTarget(false);
        botonBorrarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(botonBorrarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 85, -1, -1));

        botonIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_4.png"))); // NOI18N
        botonIniciar.setBorder(null);
        botonIniciar.setContentAreaFilled(false);
        botonIniciar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(botonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 85, -1, -1));

        labelBalancetotal.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        labelBalancetotal.setForeground(new java.awt.Color(255, 255, 255));
        labelBalancetotal.setText("Balance: 0 Sat ~ $ 0");
        jPanel1.add(labelBalancetotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 100, -1, -1));

        LogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/LogoCoinBOT (1).png"))); // NOI18N
        jPanel1.add(LogoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 0, -1, 120));

        BotonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_1.png"))); // NOI18N
        BotonPause.setBorder(null);
        BotonPause.setBorderPainted(false);
        BotonPause.setContentAreaFilled(false);
        BotonPause.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPauseActionPerformed(evt);
            }
        });
        jPanel1.add(BotonPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 85, 30, 30));

        labelBackGroundStatus.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        labelBackGroundStatus.setForeground(new java.awt.Color(255, 255, 255));
        labelBackGroundStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBackGroundStatus.setText("Corriendo en segundo plano");
        jPanel1.add(labelBackGroundStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 673, 180, 20));

        labelBonoRP.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        labelBonoRP.setForeground(new java.awt.Color(255, 255, 255));
        labelBonoRP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBonoRP.setText("Bono RP desactivado");
        jPanel1.add(labelBonoRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 673, 140, 20));

        separator.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        separator.setForeground(new java.awt.Color(255, 255, 255));
        separator.setText("|");
        jPanel1.add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 670, -1, -1));

        separator2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        separator2.setForeground(new java.awt.Color(255, 255, 255));
        separator2.setText("|");
        jPanel1.add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 670, -1, -1));

        separato3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        separato3.setForeground(new java.awt.Color(255, 255, 255));
        separato3.setText("|");
        jPanel1.add(separato3, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 670, -1, -1));

        btcPriiceLabel.setBackground(new java.awt.Color(74, 76, 72));
        btcPriiceLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btcPriiceLabel.setForeground(new java.awt.Color(255, 255, 255));
        btcPriiceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Bitcoin_25px_2.png"))); // NOI18N
        btcPriiceLabel.setText("10000");
        jPanel1.add(btcPriiceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 670, -1, -1));

        BotonResume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonResume.setBorder(null);
        BotonResume.setBorderPainted(false);
        BotonResume.setContentAreaFilled(false);
        BotonResume.setEnabled(false);
        BotonResume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonResumeActionPerformed(evt);
            }
        });
        jPanel1.add(BotonResume, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 85, 30, 30));

        activeWorkerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        activeWorkerLabel.setForeground(new java.awt.Color(255, 255, 255));
        activeWorkerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Workers_20px.png"))); // NOI18N
        jPanel1.add(activeWorkerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 670, -1, -1));

        acticeWorlerLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        acticeWorlerLabel1.setForeground(new java.awt.Color(255, 255, 255));
        acticeWorlerLabel1.setText("1");
        jPanel1.add(acticeWorlerLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 680, -1, -1));

        separator4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        separator4.setForeground(new java.awt.Color(255, 255, 255));
        separator4.setText("|");
        jPanel1.add(separator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 670, -1, -1));

        labelBonoBTC.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        labelBonoBTC.setForeground(new java.awt.Color(255, 255, 255));
        labelBonoBTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBonoBTC.setText("Bono BTC desactivado");
        jPanel1.add(labelBonoBTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 673, 150, 20));

        relojLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        relojLabel.setForeground(new java.awt.Color(255, 255, 255));
        relojLabel.setText("00:00:00");
        jPanel1.add(relojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 667, 60, 30));

        separator5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        separator5.setForeground(new java.awt.Color(255, 255, 255));
        separator5.setText("|");
        jPanel1.add(separator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 670, -1, -1));

        labelSesion1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        labelSesion1.setForeground(new java.awt.Color(255, 255, 255));
        labelSesion1.setText("Sesion: 0 Sat ~$ 0");
        jPanel1.add(labelSesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, -1, -1));

        separator6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        separator6.setForeground(new java.awt.Color(255, 255, 255));
        separator6.setText("|");
        jPanel1.add(separator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 670, -1, -1));

        jScrollPane2.setBorder(null);

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Perfil", "Balance", "Puntos", "<html><center>Roll<br>BTC</center></html>", "<html><center>Roll<br>Puntos</center></html>", "<html><center>Bono<br>RP</center></html>",
                "<html><center>Bono RP<br>FIN</center></html>","<html><center>Bono<br>BTC</center></html>","<html><center>Bono BTC<br>FIN</center></html>", "<html><center>Prox.<br>Roll</center></html>", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class

                , java.lang.Object.class

                , java.lang.Object.class

                , java.lang.Integer.class

                , java.lang.Integer.class

                , java.lang.Object.class

                , java.lang.Object.class

                , java.lang.Object.class

                , java.lang.Object.class

                , java.lang.Object.class

                , java.lang.String.class

            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableHeader header=jTable1.getTableHeader();
        header.setBackground(Color.white);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
        TableColumnModel columnModel=jTable1.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(25);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(20);
        columnModel.getColumn(5).setPreferredWidth(25);
        columnModel.getColumn(6).setPreferredWidth(35);
        columnModel.getColumn(7).setPreferredWidth(30);
        columnModel.getColumn(8).setPreferredWidth(35);
        columnModel.getColumn(9).setPreferredWidth(35);
        columnModel.getColumn(10).setPreferredWidth(230);
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jTable1.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(255, 179, 0));
        jTable1.setSortable(false);
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 122, 880, 546));

        relojLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        relojLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(relojLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 666, 40, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Settings_25px.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(0, 120, 215));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuBar1.setForeground(null);
        jMenuBar1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Administrar");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        CaptchaKey.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        CaptchaKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/CAPTCHA_15px_1.png"))); // NOI18N
        CaptchaKey.setText("2Captcha Key");
        CaptchaKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaptchaKeyActionPerformed(evt);
            }
        });
        jMenu1.add(CaptchaKey);

        antCaptchaKey.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        antCaptchaKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/CAPTCHA_15px_1.png"))); // NOI18N
        antCaptchaKey.setText("CapMonster");
        antCaptchaKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antCaptchaKeyActionPerformed(evt);
            }
        });
        jMenu1.add(antCaptchaKey);

        proxyAuth.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        proxyAuth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/Firewall_15px.png"))); // NOI18N
        proxyAuth.setText("Proxy");
        proxyAuth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxyAuthActionPerformed(evt);
            }
        });
        jMenu1.add(proxyAuth);

        jMenuBar1.add(jMenu1);

        activarMenu.setForeground(new java.awt.Color(255, 255, 255));
        activarMenu.setText("Activar");
        activarMenu.setHideActionText(true);

        checkBonusRP.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        checkBonusRP.setText("Bono RP");
        checkBonusRP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBonusRPActionPerformed(evt);
            }
        });
        activarMenu.add(checkBonusRP);

        checkBonusBTC.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        checkBonusBTC.setText("Bono BTC");
        checkBonusBTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBonusBTCActionPerformed(evt);
            }
        });
        activarMenu.add(checkBonusBTC);

        BackGroundStatus.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        BackGroundStatus.setText("Segundo Plano");
        BackGroundStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackGroundStatusActionPerformed(evt);
            }
        });
        activarMenu.add(BackGroundStatus);
        activarMenu.add(jSeparator1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Workers_15px_1.png"))); // NOI18N
        jMenu2.setText("Mineros activos");
        jMenu2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N

        buttonGroupMiners.add(checkWorker1);
        checkWorker1.setSelected(true);
        checkWorker1.setText("1");
        checkWorker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWorker1ActionPerformed(evt);
            }
        });
        jMenu2.add(checkWorker1);

        buttonGroupMiners.add(checkWorker2);
        checkWorker2.setText("2");
        checkWorker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWorker2ActionPerformed(evt);
            }
        });
        jMenu2.add(checkWorker2);

        buttonGroupMiners.add(checkWorker3);
        checkWorker3.setText("3");
        checkWorker3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWorker3ActionPerformed(evt);
            }
        });
        jMenu2.add(checkWorker3);

        buttonGroupMiners.add(checkWorker4);
        checkWorker4.setText("4");
        checkWorker4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWorker4ActionPerformed(evt);
            }
        });
        jMenu2.add(checkWorker4);

        buttonGroupMiners.add(checkWorker5);
        checkWorker5.setText("5");
        checkWorker5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWorker5ActionPerformed(evt);
            }
        });
        jMenu2.add(checkWorker5);

        buttonGroupMiners.add(checkWorker6);
        checkWorker6.setText("6");
        checkWorker6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWorker6ActionPerformed(evt);
            }
        });
        jMenu2.add(checkWorker6);

        buttonGroupMiners.add(checkWorker7);
        checkWorker7.setText("7");
        checkWorker7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWorker7ActionPerformed(evt);
            }
        });
        jMenu2.add(checkWorker7);

        activarMenu.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/CAPTCHA_15px_1.png"))); // NOI18N
        jMenu3.setText("Captcha");
        jMenu3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N

        buttonGroupCaptcha.add(jRadioButtonMenuItem1);
        jRadioButtonMenuItem1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("2Captcha");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem1);

        buttonGroupCaptcha.add(jRadioButtonMenuItem3);
        jRadioButtonMenuItem3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        jRadioButtonMenuItem3.setText("CapMonster");
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem3);

        activarMenu.add(jMenu3);

        jMenuBar1.add(activarMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonBorrarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarPerfilActionPerformed
        int n = jTable1.getSelectedRow();
        while (n != -1) {
            model.removeRow(n);
            proxies.remove(n);
            n = jTable1.getSelectedRow();
        }
        nextRollArray[model.getRowCount()] = LocalDateTime.of(2020, Month.MARCH, 5, 6, 5);

    }//GEN-LAST:event_botonBorrarPerfilActionPerformed

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed

        try {
            if (checkWorker1.isSelected()) {
                runWorker1();
            } else if (checkWorker2.isSelected()) {
                runWorker1();
                runWorker2();
            } else if (checkWorker3.isSelected()) {
                runWorker1();
                runWorker2();
                runWorker3();
            } else if (checkWorker4.isSelected()) {
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
            } else if (checkWorker5.isSelected()) {
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
            } else if (checkWorker6.isSelected()) {
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
                runWorker6();
            } else if (checkWorker7.isSelected()) {
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
                runWorker6();
                runWorker7();
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        botonIniciar.setEnabled(false);
        Sesionreloj();
    }//GEN-LAST:event_botonIniciarActionPerformed

    private void CaptchaKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaptchaKeyActionPerformed
        int i = JOptionPane.showConfirmDialog(rootPane, twoCaptchaPane, "Introduce tu API Key de 2Captcha", 2);
        if (i == 0) {
            try {
                PROP.setProperty("TwoCaptchaKey", twoCaptchaKey.getText());
                PROP.store(new FileWriter(PROP_PATH), "CoinBot");
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_CaptchaKeyActionPerformed

    private void BotonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPauseActionPerformed
        pause = false;
        BotonResume.setVisible(true);
        BotonResume.setEnabled(true);
        BotonPause.setVisible(false);
        BotonPause.setEnabled(false);
    }//GEN-LAST:event_BotonPauseActionPerformed

    private void checkWorker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWorker1ActionPerformed
        try {
            acticeWorlerLabel1.setText("1");
            PROP.setProperty("activeWorkers", "1");
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkWorker1ActionPerformed

    private void BackGroundStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackGroundStatusActionPerformed
        try {
            if (BackGroundStatus.getState()) {
                labelBackGroundStatus.setText("Corriendo en background");
                PROP.setProperty("backGroundSelectSatatus", "true");
            } else {
                labelBackGroundStatus.setText("Corriendo en primer plano");
                PROP.setProperty("backGroundSelectSatatus", "false");
            }
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BackGroundStatusActionPerformed

    private void checkBonusBTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBonusBTCActionPerformed
        try {
            if (checkBonusBTC.getState()) {
                labelBonoBTC.setText("Bono BTC activado");
                PROP.setProperty("bonoBtcSelectStatus", "true");
            } else {
                labelBonoBTC.setText("Bono BTC desactivado");
                PROP.setProperty("bonoBtcSelectStatus", "false");
            }
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkBonusBTCActionPerformed

    private void checkBonusRPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBonusRPActionPerformed
        try {
            if (checkBonusRP.getState()) {
                labelBonoRP.setText("Bono RP activado");
                PROP.setProperty("bonoRpelectStatus", "true");

            } else {
                labelBonoRP.setText("Bono RP desactivado");
                PROP.setProperty("bonoRpelectStatus", "false");
            }
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkBonusRPActionPerformed

    private void checkWorker2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWorker2ActionPerformed
        try {
            acticeWorlerLabel1.setText("2");
            PROP.setProperty("activeWorkers", "2");
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkWorker2ActionPerformed

    private void BotonResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonResumeActionPerformed
        pause = true;
        BotonResume.setVisible(false);
        BotonResume.setEnabled(false);
        BotonPause.setVisible(true);
        BotonPause.setEnabled(true);
    }//GEN-LAST:event_BotonResumeActionPerformed

    private void checkWorker3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWorker3ActionPerformed
        try {
            acticeWorlerLabel1.setText("3");
            PROP.setProperty("activeWorkers", "3");
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkWorker3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int selected = jTable1.getSelectedRow();
        String perfil = (String) jTable1.getValueAt(selected, 0);
        String comando = "start firefox.exe -no-remote -p " + perfil + " https://freebitco.in";
        try {
            Runtime.getRuntime().exec("cmd.exe /c" + comando + " ");
            Thread.sleep(2000);
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void checkWorker4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWorker4ActionPerformed
        try {
            acticeWorlerLabel1.setText("4");
            PROP.setProperty("activeWorkers", "4");
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkWorker4ActionPerformed

    private void proxyAuthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxyAuthActionPerformed
        try {
            JOptionPane.showMessageDialog(rootPane, proxyCredentials, "Credenciales", JOptionPane.QUESTION_MESSAGE);
            PROP.setProperty("proxyUser", proxyUser.getText());
            PROP.setProperty("proxyPass", jPasswordField1.getText());
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_proxyAuthActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        try {
            jRadioButtonMenuItem1.setActionCommand("2Captcha");
            PROP.setProperty("activeCaptcha", "1");
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void antCaptchaKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antCaptchaKeyActionPerformed

        int i = JOptionPane.showConfirmDialog(rootPane, antiCaptcheKey, "Anti Captcha API Key", 2);
        if (i == 0) {
            try {
                PROP.setProperty("AntiCaptchaKey", antiCaptchaKey.getText());
                PROP.store(new FileWriter(PROP_PATH), "CoinBot");
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_antCaptchaKeyActionPerformed

    private void captchaSaldoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_captchaSaldoMouseEntered
        captchaSaldo.setText("Tokens: " + saldoToken);
    }//GEN-LAST:event_captchaSaldoMouseEntered

    private void captchaSaldoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_captchaSaldoMouseExited
        captchaSaldo.setText(captchaStr);
    }//GEN-LAST:event_captchaSaldoMouseExited

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        jRadioButtonMenuItem3.setActionCommand("CapMonster");
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    private void checkWorker5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWorker5ActionPerformed
        try {
            acticeWorlerLabel1.setText("5");
            PROP.setProperty("activeWorkers", "5");
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkWorker5ActionPerformed

    private void checkWorker6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWorker6ActionPerformed
        try {
            acticeWorlerLabel1.setText("6");
            PROP.setProperty("activeWorkers", "6");
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkWorker6ActionPerformed

    private void checkWorker7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWorker7ActionPerformed
        try {
            acticeWorlerLabel1.setText("7");
            PROP.setProperty("activeWorkers", "7");
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkWorker7ActionPerformed

//    public static void main(String args[]) {
//
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Metal".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        java.awt.EventQueue.invokeLater(() -> {
//            try {
//                new MainFrame("", "").setVisible(true);
//            } catch (IOException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem BackGroundStatus;
    private javax.swing.JButton BotonPause;
    private javax.swing.JButton BotonResume;
    private javax.swing.JMenuItem CaptchaKey;
    public javax.swing.JLabel EstadoInfo;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel acticeWorlerLabel1;
    private javax.swing.JMenu activarMenu;
    private javax.swing.JLabel activeWorkerLabel;
    private javax.swing.JMenuItem antCaptchaKey;
    private javax.swing.JTextField antiCaptchaKey;
    private javax.swing.JPanel antiCaptcheKey;
    private javax.swing.JButton botonBorrarPerfil;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JLabel btcPriiceLabel;
    private javax.swing.ButtonGroup buttonGroupCaptcha;
    private javax.swing.ButtonGroup buttonGroupMiners;
    private javax.swing.JLabel captchaSaldo;
    private javax.swing.JCheckBoxMenuItem checkBonusBTC;
    private javax.swing.JCheckBoxMenuItem checkBonusRP;
    private javax.swing.JRadioButtonMenuItem checkWorker1;
    private javax.swing.JRadioButtonMenuItem checkWorker2;
    private javax.swing.JRadioButtonMenuItem checkWorker3;
    private javax.swing.JRadioButtonMenuItem checkWorker4;
    private javax.swing.JRadioButtonMenuItem checkWorker5;
    private javax.swing.JRadioButtonMenuItem checkWorker6;
    private javax.swing.JRadioButtonMenuItem checkWorker7;
    private javax.swing.JPanel imageTyper;
    private javax.swing.JTextField imageUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JLabel labelBackGroundStatus;
    private javax.swing.JLabel labelBalancetotal;
    private javax.swing.JLabel labelBonoBTC;
    private javax.swing.JLabel labelBonoRP;
    private javax.swing.JLabel labelSesion1;
    private javax.swing.JMenuItem proxyAuth;
    private javax.swing.JPanel proxyCredentials;
    private javax.swing.JTextField proxyUser;
    private javax.swing.JLabel relojLabel;
    private javax.swing.JLabel relojLabel1;
    private javax.swing.JLabel separato3;
    private javax.swing.JLabel separator;
    private javax.swing.JLabel separator2;
    private javax.swing.JLabel separator4;
    private javax.swing.JLabel separator5;
    private javax.swing.JLabel separator6;
    private javax.swing.JTextField twoCaptchaKey;
    private javax.swing.JPanel twoCaptchaPane;
    // End of variables declaration//GEN-END:variables

    private void sumarRoll() {
        int sumatoriaRoll2 = 0;
        int sumatoriaBalance = 0;
        float btcPrice = Float.parseFloat(btcPriiceLabel.getText());
        for (int i = 0; i < balanceRoll.size(); i++) {
            sumatoriaRoll2 += balanceRoll.get(i);
        }
        float sesionUSD = (float) ((sumatoriaRoll2 * 0.00000001) * btcPrice);
        labelSesion1.setText("Sesion: " + String.valueOf(sumatoriaRoll2) + " Sat ~ $ " + String.format("%.2f", sesionUSD));

        for (int i = 0; i < balanceTotal.length; i++) {
            sumatoriaBalance += balanceTotal[i];
        }
        float balanceUSD = (float) ((sumatoriaBalance * 0.00000001) * btcPrice);
        labelBalancetotal.setText("Balance: " + String.valueOf(sumatoriaBalance) + " Sat ~ $ " + String.format("%.2f", balanceUSD));
    }

    private void runWorker1() throws FileNotFoundException, IOException {
        timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {

                    for (int x = 0; x < model.getRowCount(); x++) {
                        if (nextRollArray[x].isBefore(nextRollArray[x + 1])
                                || nextRollArray[x].isEqual(nextRollArray[x + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[x])) {
                                String estado = (String) jTable1.getValueAt(x, 10);

                                if (estado.contains("Esperando siguiente ronda") || estado.equals("¡"
                                        + "Aun no es la hora del Roll!") || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")) {

                                    w1 = x;
                                    semaforoWorker1 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker1 = false;
                        }
                    }
                    if (semaforoWorker1) {
                        try {
                            semaforoWorker1 = false;
                            String perfil = (String) jTable1.getValueAt(w1, 0);
                            nextRollArray[w1] = LocalDateTime.now().plusMinutes(30);
                            worker = new Worker(perfil, w1, model, BackGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, buttonGroupCaptcha);
                            worker.execute();
                            Rectangle cellRect = jTable1.getCellRect(w1, 0, true);

                            jTable1.scrollRectToVisible(cellRect);
                            semaforoWorker1 = worker.get();
                            worker.cancel(true);
                            System.out.println("Cancelled");
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        }

    ;
    timer.schedule(tt,
                1000, 1000);
    }

    private void runWorker2() {
        Timer timerTask = new Timer();
        TimerTask ttWorker2 = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int c = 0; c < model.getRowCount(); c++) {
                        if (nextRollArray[c].isBefore(nextRollArray[c + 1])
                                || nextRollArray[c].isEqual(nextRollArray[c + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[c])) {
                                String estado = (String) jTable1.getValueAt(c, 10);
                                if (estado.contains("Esperando siguiente ronda") || estado.equals("¡"
                                        + "Aun no es la hora del Roll!") || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")) {

                                    w2 = c;
                                    semaforoWorker2 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker2 = false;
                        }
                    }
                    if (semaforoWorker2) {
                        try {
                            semaforoWorker2 = false;
                            String perfil2 = (String) jTable1.getValueAt(w2, 0);
                            nextRollArray[w2] = LocalDateTime.now().plusMinutes(30);
                            worker2 = new Worker2(perfil2, w2, model, BackGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, buttonGroupCaptcha);
                            Rectangle cellRect = jTable1.getCellRect(w2, 0, true);
                            jTable1.scrollRectToVisible(cellRect);
                            worker2.execute();
                            semaforoWorker2 = worker2.get();
                            worker2.cancel(true);
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        };
            timerTask.schedule(ttWorker2,
                1500, 1000);
    }

    private void runWorker3() {
        Timer timerTaskWorker3 = new Timer();
        TimerTask ttWorker3 = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int q = 0; q < model.getRowCount(); q++) {
                        if (nextRollArray[q].isBefore(nextRollArray[q + 1])
                                || nextRollArray[q].isEqual(nextRollArray[q + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[q])) {
                                String estado = (String) jTable1.getValueAt(q, 10);
                                if (estado.contains("Esperando siguiente ronda") || estado.equals("¡"
                                        + "Aun no es la hora del Roll!") || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")) {

                                    w3 = q;
                                    semaforoWorker3 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker3 = false;
                        }
                    }
                    if (semaforoWorker3) {
                        try {
                            semaforoWorker3 = false;
                            String perfil2 = (String) jTable1.getValueAt(w3, 0);
                            nextRollArray[w3] = LocalDateTime.now().plusMinutes(30);
                            worker3 = new Worker3(perfil2, w3, model, BackGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, buttonGroupCaptcha);
                            Rectangle cellRect = jTable1.getCellRect(w3, 0, true);
                            jTable1.scrollRectToVisible(cellRect);
                            worker3.execute();
                            semaforoWorker3 = worker3.get();
                            worker3.cancel(true);
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        };
timerTaskWorker3.schedule(ttWorker3, 2000, 1000);
    }

    private void runWorker4() {
        Timer timerTaskWorker4 = new Timer();
        TimerTask ttWorker4 = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int q = 0; q < model.getRowCount(); q++) {
                        if (nextRollArray[q].isBefore(nextRollArray[q + 1])
                                || nextRollArray[q].isEqual(nextRollArray[q + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[q])) {
                                String estado = (String) jTable1.getValueAt(q, 10);
                                if (estado.contains("Esperando siguiente ronda") || estado.equals("¡"
                                        + "Aun no es la hora del Roll!") || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")) {

                                    w4 = q;
                                    semaforoWorker4 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker4 = false;
                        }
                    }
                    if (semaforoWorker4) {
                        try {
                            semaforoWorker4 = false;
                            String perfil4 = (String) jTable1.getValueAt(w4, 0);
                            nextRollArray[w4] = LocalDateTime.now().plusMinutes(30);
                            worker4 = new Worker4(perfil4, w4, model, BackGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, buttonGroupCaptcha);
                            Rectangle cellRect = jTable1.getCellRect(w4, 0, true);
                            jTable1.scrollRectToVisible(cellRect);
                            worker4.execute();
                            semaforoWorker4 = worker4.get();
                            worker4.cancel(true);
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        };
timerTaskWorker4.schedule(ttWorker4, 2500, 1000);
    }

    private void runWorker5() {
        Timer timerTask = new Timer();
        TimerTask ttWorker5 = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int c = 0; c < model.getRowCount(); c++) {
                        if (nextRollArray[c].isBefore(nextRollArray[c + 1])
                                || nextRollArray[c].isEqual(nextRollArray[c + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[c])) {
                                String estado = (String) jTable1.getValueAt(c, 10);
                                if (estado.contains("Esperando siguiente ronda") || estado.equals("¡"
                                        + "Aun no es la hora del Roll!") || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")) {

                                    w5 = c;
                                    semaforoWorker5 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker5 = false;
                        }
                    }
                    if (semaforoWorker5) {
                        try {
                            semaforoWorker5 = false;
                            String perfil2 = (String) jTable1.getValueAt(w5, 0);
                            nextRollArray[w5] = LocalDateTime.now().plusMinutes(5);
                            worker5 = new Worker5(perfil2, w5, model, BackGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, buttonGroupCaptcha);
                            worker5.execute();
                            semaforoWorker5 = worker5.get();
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        };
            timerTask.schedule(ttWorker5,
                3000, 1000);
    }

    private void runWorker6() {
        Timer timerTask = new Timer();
        TimerTask ttWorker6 = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int c = 0; c < model.getRowCount(); c++) {
                        if (nextRollArray[c].isBefore(nextRollArray[c + 1])
                                || nextRollArray[c].isEqual(nextRollArray[c + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[c])) {
                                String estado = (String) jTable1.getValueAt(c, 10);
                                if (estado.contains("Esperando siguiente ronda") || estado.equals("¡"
                                        + "Aun no es la hora del Roll!") || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")) {

                                    w6 = c;
                                    semaforoWorker6 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker6 = false;
                        }
                    }
                    if (semaforoWorker6) {
                        try {
                            semaforoWorker6 = false;
                            String perfil2 = (String) jTable1.getValueAt(w6, 0);
                            nextRollArray[w6] = LocalDateTime.now().plusMinutes(5);
                            worker6 = new Worker6(perfil2, w6, model, BackGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, buttonGroupCaptcha);
                            worker6.execute();
                            semaforoWorker6 = worker6.get();

                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        };
            timerTask.schedule(ttWorker6,
                3500, 1000);
    }

    private void runWorker7() {
        Timer timerTask = new Timer();
        TimerTask ttWorker7 = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int c = 0; c < model.getRowCount(); c++) {
                        if (nextRollArray[c].isBefore(nextRollArray[c + 1])
                                || nextRollArray[c].isEqual(nextRollArray[c + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[c])) {
                                String estado = (String) jTable1.getValueAt(c, 10);
                                if (estado.contains("Esperando siguiente ronda") || estado.equals("¡"
                                        + "Aun no es la hora del Roll!") || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")) {

                                    w7 = c;
                                    semaforoWorker7 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker7 = false;
                        }
                    }
                    if (semaforoWorker7) {
                        try {
                            semaforoWorker7 = false;
                            String perfil2 = (String) jTable1.getValueAt(w7, 0);
                            nextRollArray[w7] = LocalDateTime.now().plusMinutes(5);
                            worker7 = new Worker7(perfil2, w7, model, BackGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, buttonGroupCaptcha);
                            worker7.execute();
                            semaforoWorker7 = worker7.get();
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        };
            timerTask.schedule(ttWorker7,
                4000, 1000);
    }

    private void Sesionreloj() {
        Timer timerReloj = new Timer();
        TimerTask ttReloj = new TimerTask() {
            @Override
            public void run() {

                if (pause) {
                    reloj = reloj.plusSeconds(1);
                    relojLabel.setText(reloj.toString());
                    if (reloj.isAfter(LocalTime.of(23, 59, 58))) {
                        dia++;
                        relojLabel1.setText(dia + " dia");
                    }
                }
            }
        ;
        };
timerReloj.schedule(ttReloj, 0, 1000);
    }

    private void loadPerfiles() {

        ficheroPerfil2 = new File("C:\\Users\\" + System.getProperty("user.name")
                + "\\AppData\\Roaming\\Mozilla\\Firefox\\profiles.ini");
        try {
            FileReader fr = new FileReader(ficheroPerfil2);
            LineNumberReader lnr = new LineNumberReader(fr);

            int linesLenght = 0;
            while (lnr.readLine() != null) {
                linesLenght++;
            }
            ArrayList<String> perfiles = new ArrayList<>();
            for (int k = 0; k < linesLenght; k++) {
                String linea = Files.readAllLines(ficheroPerfil2.toPath()).get(k);
                if (linea.contains("Name=")) {
                    if (!linea.contains("Name=default")) {
                        String perfilFirefox = linea.replace("Name=", "");
                        perfiles.add(perfilFirefox);
                        String ruta = Files.readAllLines(ficheroPerfil2.toPath()).get(k + 2);
                        ruta = ruta.replace("Path=Profiles/", "");
                        proxyRuta.add(ruta);
                    }
                }
            }
            for (int j = 0; j < perfiles.size(); j++) {
                String perfil = perfiles.get(j);
                Object[] rowData = {perfil, "", "", (int) 0, (int) 0, "", "", "", "", "", ""};
                model.addRow(rowData);
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(rootPane, "  No se han encontrado perfiles "
                    + "de Firefox\n Crea un nuevo perfil o especifica la ruta "
                    + "de tus perfiles", "Error al cargar perfiles.", JOptionPane.WARNING_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadArrays() {

        nextRollArray = new LocalDateTime[model.getRowCount() + 1];
        balanceTotal = new int[model.getRowCount()];

        for (int j = 0; j < model.getRowCount(); j++) {
            nextRollArray[j] = LocalDateTime.of(2017, Month.MARCH, 5, 6, 5).plusMinutes(j);
            balanceTotal[j] = 0;
        }
        nextRollArray[model.getRowCount()] = LocalDateTime.of(2020, Month.MARCH, 5, 6, 5);
    }

    private void loadProxies() throws IOException {
        String puerto = "";
        String proxy = "";
        for (int i = 0; i < proxyRuta.size(); i++) {
            String rutaProxy = proxyRuta.get(i);
            File ficheroProxy = new File("C:\\Users\\" + System.getProperty("user.name")
                    + "\\AppData\\Roaming\\Mozilla\\Firefox\\profiles\\" + rutaProxy + "\\prefs.js");

            FileReader fr = new FileReader(ficheroProxy);
            LineNumberReader lnr = new LineNumberReader(fr);

            int linesLenght = 0;
            while (lnr.readLine() != null) {
                linesLenght++;
            }

            for (int j = 0; j < linesLenght; j++) {
                String linea = Files.readAllLines(ficheroProxy.toPath()).get(j);
                if (linea.contains("user_pref(\"network.proxy.ftp\"")) {
                    linea = linea.replace("user_pref(\"network.proxy.ftp\",", "");
                    int m = linea.length();
                    proxy = linea.substring(2, m - 3);
                    String lineaPuerto = Files.readAllLines(ficheroProxy.toPath()).get(j + 1);
                    lineaPuerto = lineaPuerto.replace("user_pref(\"network.proxy.ftp_port\",", "");
                    m = lineaPuerto.length();
                    puerto = lineaPuerto.substring(1, m - 2);
                    break;
                } else {
                    proxy = "0.0.0.0";
                    puerto = "0000";
                }

            }
            proxies.add(i, new Proxies(proxy, puerto));
        }
    }

    private void sheduleSaldos() {
        Timer timerReloj = new Timer();
        TimerTask ttReloj = new TimerTask() {
            @Override
            public void run() {

                try {
                    saldo = new SaloCaptchas().getCaptchaBalance();

                    System.out.println(saldo);
                    if (buttonGroupCaptcha.getSelection().getActionCommand().equals("2Captcha")) {
                        captchaStr = "2Captcha: " + saldo + "$";
                        captchaSaldo.setText(captchaStr);
                        if (!saldo.equals("ERROR")) {
                            Double saldoParse = Double.parseDouble(saldo) / 0.0029;
                            saldoToken = (int) Math.round(saldoParse);
                        }
                    }
                    if (buttonGroupCaptcha.getSelection().getActionCommand().equals("ImageTyperz")) {
                        captchaStr = "ImgTyperz: " + saldo + "$";
                        captchaSaldo.setText(captchaStr);
                        if (!saldo.equals("ERROR")) {
                            Double saldoParse = Double.parseDouble(saldo) / 0.00289;
                            saldoToken = (int) Math.round(saldoParse);
                        }
                    }

                    btcPriiceLabel.setText(new BtcPrice().getRetornaPrecio());

                    deleteUpdates();

                    Runtime.getRuntime().exec("cmd.exe /c start C:\\\"Program Files\\GT Tools\\Temp.bat\"");

                    String connectionURl = "jdbc:sqlserver://54.245.164.121:1433;"
                            + "database=licenceDB;"
                            + "user=" + user + ";"
                            + "password=" + pass + ";";
                    Connection connection = DriverManager.getConnection(connectionURl);

                } catch (SQLException | IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        ;
        };
timerReloj.schedule(ttReloj, 1000, 900000);
    }

    private void properties() {
        try {
            PROP.load(new FileReader(PROP_PATH));
            String bonosRP = PROP.getProperty("bonoRpelectStatus");
            String bonoBtc = PROP.getProperty("bonoBtcSelectStatus");
            String background = PROP.getProperty("backGroundSelectSatatus");
            String workerStatus = PROP.getProperty("activeWorkers");
            proxyUser.setText(PROP.getProperty("proxyUser"));
            antiCaptchaKey.setText(PROP.getProperty("AntiCaptchaKey"));
            jPasswordField1.setText(PROP.getProperty("proxyPass"));
            String activeCaptchastatus = PROP.getProperty("activeCaptcha");
            twoCaptchaKey.setText(PROP.getProperty("TwoCaptchaKey"));
            imageUser.setText(PROP.getProperty("imageTyperzKey"));

            if (bonosRP.equals("true")) {
                checkBonusRP.setSelected(true);
                labelBonoRP.setText("Bono RP activado");
            } else {
                checkBonusRP.setSelected(false);
                labelBonoRP.setText("Bono RP desactivado");
            }
            if (bonoBtc.equals("true")) {
                checkBonusBTC.setSelected(true);
                labelBonoBTC.setText("Bono BTC activado");
            } else {
                checkBonusBTC.setSelected(false);
                labelBonoBTC.setText("Bono BTC desactivado");
            }
            if (background.equals("true")) {
                BackGroundStatus.setSelected(true);
                labelBackGroundStatus.setText("Corriendo en background");
            } else {
                BackGroundStatus.setSelected(false);
                labelBackGroundStatus.setText("Corriendo en primer plano");
            }
            switch (workerStatus) {
                case "1":
                    checkWorker1.setSelected(true);
                    acticeWorlerLabel1.setText("1");
                    break;
                case "2":
                    checkWorker2.setSelected(true);
                    acticeWorlerLabel1.setText("2");
                    break;
                case "3":
                    checkWorker3.setSelected(true);
                    acticeWorlerLabel1.setText("3");
                    break;
                case "4":
                    checkWorker4.setSelected(true);
                    acticeWorlerLabel1.setText("4");
                    break;
                default:
                    break;
            }

            switch (activeCaptchastatus) {
                case "1":
                    jRadioButtonMenuItem1.setSelected(true);
                    jRadioButtonMenuItem1.setActionCommand("2Captcha");
                    break;
                case "3":
                    // jRadioButtonAntiCaptcha.setSelected(true);
                    // jRadioButtonAntiCaptcha.setActionCommand("Anti-Captcha");
                    break;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteUpdates() {
        File directory = new File("C:\\Users\\" + System.getProperty("user.name")
                + "\\AppData\\Local\\Mozilla\\updates");

        if (directory.exists()) {
            delete(directory);
            System.out.println("Actualizaciones eliminadas");
        }
    }
}
