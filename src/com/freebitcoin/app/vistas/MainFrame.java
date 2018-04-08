package com.freebitcoin.app.vistas;

import com.freebitcoin.app.control.BtcPrice;
import com.freebitcoin.app.miners.Worker;
import com.freebitcoin.app.miners.Worker2;
import com.freebitcoin.app.miners.Worker3;
import com.freebitcoin.app.miners.Worker4;
import com.freebitcoin.app.miners.Worker5;
import com.freebitcoin.app.miners.Worker6;
import com.freebitcoin.app.miners.Worker7;
import com.freebitcoin.app.control.Proxies;
import com.freebitcoin.app.miners.Worker8;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import static org.openqa.selenium.io.FileHandler.delete;

public class MainFrame extends javax.swing.JFrame {

    private int w1 = 0,
            w2 = 0,
            w3 = 0,
            w4 = 0,
            w5 = 0,
            w6 = 0,
            w7 = 0,
            w8 = 0;

    private int dia = 0;
    private int procesando = 0,
            terminadas = 0;
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
    private volatile Worker8 worker8;
    private boolean semaforoWorker3 = false,
            semaforoWorker2 = false,
            semaforoWorker1 = false,
            semaforoWorker4 = false,
            semaforoWorker5 = false,
            semaforoWorker6 = false,
            semaforoWorker7 = false,
            semaforoWorker8 = false;
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
    private boolean checkBonusRP,
            checkBonusBTC,
            backGroundStatus,
            openPopUp = false;
    private int workerStatus;
    private String activeCaptchastatus;
    private String btcPriceStr;

    public MainFrame(String user, String pass) throws IOException {
        laf();
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        loadPerfiles();
        BotonResume.setVisible(false);
        loadArrays();
        loadProxies();
        properties();
        sheduleSaldos();
        this.user = user;
        this.pass = pass;
        Icon listicon = new ImageIcon(getClass().getClassLoader().getResource("Vistas/icons8_Numeric_25px.png"));
        JLabel iconLabel = new JLabel(listicon);
        TableCellRenderer renderer = new JComponentTableCellRenderer();
        TableColumnModel col = jTable1.getColumnModel();
        TableColumn col0 = col.getColumn(0);
        col0.setHeaderValue(iconLabel);
        col0.setHeaderRenderer(renderer);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Vistas/iconoCoinBOT.png"));
        return retValue;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        EstadoInfo = new javax.swing.JLabel();
        botonBorrarPerfil = new javax.swing.JButton();
        botonIniciar = new javax.swing.JButton();
        labelBalancetotal = new javax.swing.JLabel();
        LogoLabel = new javax.swing.JLabel();
        BotonPause = new javax.swing.JButton();
        BotonResume = new javax.swing.JButton();
        labelSesion1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 =  jTable1 = new MiRenderer();
        jPanel2 = new javax.swing.JPanel();
        btcPriiceLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalPerfilesLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        terminadasLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        procesandoLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        esperaLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        relojLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Firefox_15px.png"))); // NOI18N
        jMenuItem1.setText("Abir perfil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CoinBot v1.0");
        setIconImage(getIconImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 120, 215));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EstadoInfo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        EstadoInfo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(EstadoInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        botonBorrarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_1_1.png"))); // NOI18N
        botonBorrarPerfil.setBorder(null);
        botonBorrarPerfil.setBorderPainted(false);
        botonBorrarPerfil.setContentAreaFilled(false);
        botonBorrarPerfil.setFocusable(false);
        botonBorrarPerfil.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png"))); // NOI18N
        botonBorrarPerfil.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png"))); // NOI18N
        botonBorrarPerfil.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png"))); // NOI18N
        botonBorrarPerfil.setVerifyInputWhenFocusTarget(false);
        botonBorrarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(botonBorrarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 86, -1, -1));

        botonIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_1.png"))); // NOI18N
        botonIniciar.setBorder(null);
        botonIniciar.setContentAreaFilled(false);
        botonIniciar.setFocusable(false);
        botonIniciar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(botonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 86, -1, -1));

        labelBalancetotal.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        labelBalancetotal.setForeground(new java.awt.Color(255, 255, 255));
        labelBalancetotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Refund_20px.png"))); // NOI18N
        labelBalancetotal.setText("Balance: 0 Sat ~ $ 0");
        jPanel1.add(labelBalancetotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 100, -1, -1));

        LogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/LogoCoinBOT (1).png"))); // NOI18N
        jPanel1.add(LogoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 0, -1, 120));

        BotonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2_1.png"))); // NOI18N
        BotonPause.setBorder(null);
        BotonPause.setBorderPainted(false);
        BotonPause.setContentAreaFilled(false);
        BotonPause.setFocusable(false);
        BotonPause.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPauseActionPerformed(evt);
            }
        });
        jPanel1.add(BotonPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 86, 30, 30));

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

        labelSesion1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        labelSesion1.setForeground(new java.awt.Color(255, 255, 255));
        labelSesion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Payment_History_20px_2.png"))); // NOI18N
        labelSesion1.setText("Sesion: 0 Sat ~$ 0");
        jPanel1.add(labelSesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, -1, -1));

        jScrollPane2.setBorder(null);

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#","Perfil", "Balance", "Puntos", "<html><center>Roll<br>BTC</center></html>", "<html><center>Roll<br>Puntos</center></html>", "<html><center>Bono<br>RP</center></html>",
                "<html><center>Bono RP<br>FIN</center></html>","<html><center>Bono<br>BTC</center></html>","<html><center>Bono BTC<br>FIN</center></html>", "<html><center>Prox.<br>Roll</center></html>", "Estado"
            }
        ) {
            Class[] types = new Class [] {

                java.lang.Object.class

                , java.lang.String.class

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
                false,false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableHeader header=jTable1.getTableHeader();
        jTable1.getTableHeader().setReorderingAllowed(false);

        TableCellRenderer rendererFromHeader = jTable1.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
        TableColumnModel columnModel=jTable1.getColumnModel();

        columnModel.getColumn(0).setMinWidth(1);
        columnModel.getColumn(0).setMaxWidth(50);
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(30);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(25);
        columnModel.getColumn(4).setPreferredWidth(20);
        columnModel.getColumn(5).setPreferredWidth(20);
        columnModel.getColumn(6).setPreferredWidth(25);
        columnModel.getColumn(7).setPreferredWidth(35);
        columnModel.getColumn(8).setPreferredWidth(30);
        columnModel.getColumn(9).setPreferredWidth(35);
        columnModel.getColumn(10).setPreferredWidth(35);
        columnModel.getColumn(11).setPreferredWidth(230);
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jTable1.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(255, 179, 0));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setSortable(false);
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 122, 880, 530));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btcPriiceLabel.setBackground(new java.awt.Color(74, 76, 72));
        btcPriiceLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btcPriiceLabel.setForeground(new java.awt.Color(255, 255, 255));
        btcPriiceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Bitcoin_25px_2.png"))); // NOI18N
        btcPriiceLabel.setText("10000");
        jPanel2.add(btcPriiceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 670, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Workers_20px.png"))); // NOI18N
        jLabel2.setText("1");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("|");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 3, -1, -1));

        totalPerfilesLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        totalPerfilesLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalPerfilesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Firefox_20px.png"))); // NOI18N
        totalPerfilesLabel.setText("Total: 154 ");
        jPanel2.add(totalPerfilesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 7, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("|");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 3, -1, -1));

        terminadasLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        terminadasLabel.setForeground(new java.awt.Color(255, 255, 255));
        terminadasLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checkmark_20px.png"))); // NOI18N
        terminadasLabel.setText("Terminadas: 0");
        jPanel2.add(terminadasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 7, 120, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("|");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 3, -1, -1));

        procesandoLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        procesandoLabel.setForeground(new java.awt.Color(255, 255, 255));
        procesandoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Spinner_20px.png"))); // NOI18N
        procesandoLabel.setText("Procesando: 6");
        jPanel2.add(procesandoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 7, 120, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("|");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 3, -1, -1));

        esperaLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        esperaLabel.setForeground(new java.awt.Color(255, 255, 255));
        esperaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cafe_20px.png"))); // NOI18N
        esperaLabel.setText("En Espera: 120");
        jPanel2.add(esperaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 7, 110, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("|");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 3, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Settings_25px.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Settings_25px_1_1.png"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Settings_25px_1_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(845, 4, -1, -1));

        relojLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        relojLabel.setForeground(new java.awt.Color(255, 255, 255));
        relojLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        relojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Watch_20px.png"))); // NOI18N
        relojLabel.setText("0 dias");
        jPanel2.add(relojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 7, 70, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("|");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 3, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("|");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 3, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("00:00:00");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 7, -1, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Bitcoin_20px.png"))); // NOI18N
        jLabel6.setText("1 BTC ~ 6852.1 $");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 7, 130, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 656, 878, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("CoinBot v1.2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            int select = jTable1.getSelectedRow();
            String perfil = (String) model.getValueAt(select, 1);
            Runtime.getRuntime().exec("cmd.exe /c start firefox.exe -p " + perfil + " https://freebitco.in");
            openPopUp = true;
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ConfigFrame().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonResumeActionPerformed
        pause = true;
        BotonResume.setVisible(false);
        BotonResume.setEnabled(false);
        BotonPause.setVisible(true);
        BotonPause.setEnabled(true);
    }//GEN-LAST:event_BotonResumeActionPerformed

    private void BotonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPauseActionPerformed
        pause = false;
        BotonResume.setVisible(true);
        BotonResume.setEnabled(true);
        BotonPause.setVisible(false);
        BotonPause.setEnabled(false);
    }//GEN-LAST:event_BotonPauseActionPerformed

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
        properties();

        try {
            switch (workerStatus) {
                case 1:
                    runWorker1();
                    break;
                case 2:
                    runWorker1();
                    runWorker2();
                    break;
                case 3:
                    runWorker1();
                    runWorker2();
                    runWorker3();
                    break;
                case 4:
                    runWorker1();
                    runWorker2();
                    runWorker3();
                    runWorker4();
                    break;
                case 5:
                    runWorker1();
                    runWorker2();
                    runWorker3();
                    runWorker4();
                    runWorker5();
                    break;
                case 6:
                    runWorker1();
                    runWorker2();
                    runWorker3();
                    runWorker4();
                    runWorker5();
                    runWorker6();
                    break;
                case 7:
                    runWorker1();
                    runWorker2();
                    runWorker3();
                    runWorker4();
                    runWorker5();
                    runWorker6();
                    runWorker7();
                    break;
                case 8:
                    runWorker1();
                    runWorker2();
                    runWorker3();
                    runWorker4();
                    runWorker5();
                    runWorker6();
                    runWorker7();
                    runWorker8();
            }

            Thread.sleep(1000);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Sesionreloj();
        botonBorrarPerfil.setEnabled(false);
        botonIniciar.setEnabled(false);
    }//GEN-LAST:event_botonIniciarActionPerformed

    private void botonBorrarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarPerfilActionPerformed
        int n = jTable1.getSelectedRow();
        while (n != -1) {
            model.removeRow(n);
            proxies.remove(n);
            n = jTable1.getSelectedRow();
        }
        int newNum = 1;
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(newNum, i, 0);
            newNum++;
        }
        nextRollArray[model.getRowCount()] = LocalDateTime.of(2020, Month.MARCH, 5, 6, 5);
    }//GEN-LAST:event_botonBorrarPerfilActionPerformed

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
    private javax.swing.JButton BotonPause;
    private javax.swing.JButton BotonResume;
    public javax.swing.JLabel EstadoInfo;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JButton botonBorrarPerfil;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JLabel btcPriiceLabel;
    private javax.swing.JLabel esperaLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JLabel labelBalancetotal;
    private javax.swing.JLabel labelSesion1;
    private javax.swing.JLabel procesandoLabel;
    private javax.swing.JLabel relojLabel;
    private javax.swing.JLabel terminadasLabel;
    private javax.swing.JLabel totalPerfilesLabel;
    // End of variables declaration//GEN-END:variables

    private void sumarRoll() {
        int sumatoriaRoll2 = 0;
        int sumatoriaBalance = 0;
        float btcPrice = Float.parseFloat(btcPriceStr);
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
                                String estado = (String) jTable1.getValueAt(x, 11);

                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.equals("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")
                                        || estado.equals("CAPTCHA_TIMEOUT")) {

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
                            String perfil = (String) jTable1.getValueAt(w1, 1);
                            nextRollArray[w1] = LocalDateTime.now().plusMinutes(15);
                            worker = new Worker(perfil, w1, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, activeCaptchastatus);
                            procesando++;
                            worker.execute();
                            Rectangle cellRect = jTable1.getCellRect(w1, 1, true);
                            jTable1.scrollRectToVisible(cellRect);
                            semaforoWorker1 = worker.get();
                            if (nextRollArray[w1].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminadas++;
                            }
                            procesando--;

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
                                String estado = (String) jTable1.getValueAt(c, 11);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.equals("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")
                                        || estado.equals("CAPTCHA_TIMEOUT")) {

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
                            String perfil2 = (String) jTable1.getValueAt(w2, 1);
                            nextRollArray[w2] = LocalDateTime.now().plusMinutes(15);
                            worker2 = new Worker2(perfil2, w2, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, activeCaptchastatus);
                            Rectangle cellRect = jTable1.getCellRect(w2, 1, true);
                            jTable1.scrollRectToVisible(cellRect);
                            procesando++;
                            worker2.execute();

                            semaforoWorker2 = worker2.get();

                            if (nextRollArray[w2].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminadas++;
                            }
                            procesando--;

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
                                String estado = (String) jTable1.getValueAt(q, 11);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.equals("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")
                                        || estado.equals("CAPTCHA_TIMEOUT")) {

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
                            String perfil2 = (String) jTable1.getValueAt(w3, 1);
                            nextRollArray[w3] = LocalDateTime.now().plusMinutes(15);
                            worker3 = new Worker3(perfil2, w3, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, activeCaptchastatus);
                            Rectangle cellRect = jTable1.getCellRect(w3, 1, true);
                            jTable1.scrollRectToVisible(cellRect);
                            procesando++;
                            worker3.execute();

                            semaforoWorker3 = worker3.get();

                            if (nextRollArray[w3].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminadas++;
                            }
                            procesando--;
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
                                String estado = (String) jTable1.getValueAt(q, 11);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.equals("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")
                                        || estado.equals("CAPTCHA_TIMEOUT")) {

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
                            String perfil4 = (String) jTable1.getValueAt(w4, 1);
                            nextRollArray[w4] = LocalDateTime.now().plusMinutes(15);
                            worker4 = new Worker4(perfil4, w4, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, activeCaptchastatus);
                            Rectangle cellRect = jTable1.getCellRect(w4, 1, true);
                            jTable1.scrollRectToVisible(cellRect);
                            procesando++;
                            worker4.execute();

                            semaforoWorker4 = worker4.get();

                            if (nextRollArray[w4].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminadas++;
                            }
                            procesando--;
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
                                String estado = (String) jTable1.getValueAt(c, 11);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.equals("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")
                                        || estado.equals("CAPTCHA_TIMEOUT")) {

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
                            String perfil2 = (String) jTable1.getValueAt(w5, 1);
                            nextRollArray[w5] = LocalDateTime.now().plusMinutes(15);
                            worker5 = new Worker5(perfil2, w5, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, activeCaptchastatus);
                            procesando++;
                            worker5.execute();

                            semaforoWorker5 = worker5.get();

                            if (nextRollArray[w5].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminadas++;
                            }
                            procesando--;
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
                                String estado = (String) jTable1.getValueAt(c, 11);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.equals("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")
                                        || estado.equals("CAPTCHA_TIMEOUT")) {

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
                            String perfil2 = (String) jTable1.getValueAt(w6, 1);
                            nextRollArray[w6] = LocalDateTime.now().plusMinutes(15);
                            worker6 = new Worker6(perfil2, w6, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, activeCaptchastatus);
                            procesando++;
                            worker6.execute();

                            semaforoWorker6 = worker6.get();

                            if (nextRollArray[w6].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminadas++;
                            }
                            procesando--;
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
                                String estado = (String) jTable1.getValueAt(c, 11);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.equals("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")
                                        || estado.equals("CAPTCHA_TIMEOUT")) {

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
                            String perfil2 = (String) jTable1.getValueAt(w7, 1);
                            nextRollArray[w7] = LocalDateTime.now().plusMinutes(15);
                            worker7 = new Worker7(perfil2, w7, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, activeCaptchastatus);
                            procesando++;
                            worker7.execute();
                            semaforoWorker7 = worker7.get();

                            if (nextRollArray[w7].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminadas++;
                            }
                            procesando--;
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

    private void runWorker8() throws FileNotFoundException, IOException {
        timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {

                    for (int x = 0; x < model.getRowCount(); x++) {
                        if (nextRollArray[x].isBefore(nextRollArray[x + 1])
                                || nextRollArray[x].isEqual(nextRollArray[x + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[x])) {
                                String estado = (String) jTable1.getValueAt(x, 11);

                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.equals("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.equals("Ha ocurrido un error")
                                        || estado.equals("CAPTCHA_TIMEOUT")) {

                                    w8 = x;
                                    semaforoWorker8 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker8 = false;
                        }
                    }
                    if (semaforoWorker8) {
                        try {
                            semaforoWorker8 = false;
                            String perfil = (String) jTable1.getValueAt(w8, 1);
                            nextRollArray[w8] = LocalDateTime.now().plusMinutes(15);
                            worker8 = new Worker8(perfil, w8, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, activeCaptchastatus);
                            procesando++;
                            worker8.execute();
                            semaforoWorker8 = worker8.get();
                            if (nextRollArray[w8].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminadas++;
                            }
                            procesando--;

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
                4500, 1000);
    }

    private void Sesionreloj() {
        Timer timerReloj = new Timer();
        TimerTask ttReloj = new TimerTask() {
            @Override
            public void run() {

                if (pause) {

                    reloj = reloj.plusSeconds(1);
                    jLabel4.setText(reloj.toString());
                    if (reloj.isAfter(LocalTime.of(23, 59, 58))) {
                        dia++;
                        relojLabel.setText(dia + " dia");
                    }
                    procesandoLabel.setText("Procesando: " + procesando);
                    terminadasLabel.setText("Terminadas: " + terminadas);

                    esperaLabel.setText("En Espera: " + (model.getRowCount() - terminadas));
                    if (terminadas >= model.getRowCount()) {
                        terminadas = 0;
                    }
                    if (procesando == 0 && !openPopUp) {
                        try {
                            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
                            Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            }
        ;
        };
timerReloj.schedule(ttReloj, 1000, 1000);
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
            int perfilNumber = 1;
            for (int j = 0; j < perfiles.size(); j++) {
                String perfil = perfiles.get(j);
                Object[] rowData = {(int) perfilNumber, perfil, "", "", (int) 0, (int) 0, "", "", "", "", "", ""};
                model.addRow(rowData);
                perfilNumber++;
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
                    openPopUp = false;
                    btcPriceStr = new BtcPrice().getRetornaPrecio();
                    jLabel6.setText("1 BTC ~ " + btcPriceStr + "$");

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
        totalPerfilesLabel.setText("Total: " + model.getRowCount());
        esperaLabel.setText("En Espera: " + model.getRowCount());
        procesandoLabel.setText("Procesando: " + procesando);

        try {
            PROP.load(new FileReader(PROP_PATH));
            checkBonusRP = Boolean.valueOf(PROP.getProperty("bonoRpelectStatus"));
            checkBonusBTC = Boolean.valueOf(PROP.getProperty("bonoBtcSelectStatus"));
            backGroundStatus = Boolean.valueOf(PROP.getProperty("backGroundSelectSatatus"));
            workerStatus = Integer.parseInt(PROP.getProperty("activeWorkers"));
            activeCaptchastatus = PROP.getProperty("activeCaptcha");

            this.setAlwaysOnTop(Boolean.valueOf(PROP.getProperty("alwaysTop")));

            switch (workerStatus) {
                case 1:
                    jLabel2.setText("1");
                    break;
                case 2:
                    jLabel2.setText("2");
                    break;
                case 3:
                    jLabel2.setText("3");
                    break;
                case 4:
                    jLabel2.setText("4");
                    break;
                case 5:
                    jLabel2.setText("5");
                    break;
                case 6:
                    jLabel2.setText("6");
                    break;
                case 7:
                    jLabel2.setText("7");
                    break;
                case 8:
                    jLabel2.setText("8");
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
        }

    }

    private void laf() {
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
}
