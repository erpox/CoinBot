package com.freebitcoin.app.vistas;

import com.freebitcoin.app.control.BtcPrice;
import com.freebitcoin.app.miners.Worker;
import com.freebitcoin.app.miners.Worker2;
import com.freebitcoin.app.miners.Worker3;
import com.freebitcoin.app.miners.Worker4;
import com.freebitcoin.app.miners.Worker5;
import com.freebitcoin.app.miners.Worker6;
import com.freebitcoin.app.miners.Worker7;
import com.freebitcoin.app.miners.Worker8;
import com.freebitcoin.app.miners.Worker9;
import com.freebitcoin.app.miners.Worker10;
import com.freebitcoin.app.miners.Worker11;
import com.freebitcoin.app.control.Proxies;
import com.freebitcoin.app.miners.SilentWorker;
import com.freebitcoin.app.miners.SilentWorker2;
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
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
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

    private int w1 = 0, w2 = 1, w3 = 2, w4 = 3, w5 = 4, w6 = 5, w7 = 6, w8 = 7,
            w9 = 8, w10 = 9, w11 = 10, w12 = 11, pauseN = 0, silentSelector = 0,
            silentSelector2 = 0;
    private int dia = 0;
    private int[] procesando = new int[14];
    private int procesada = 0;
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
    private volatile Worker9 worker9;
    private volatile Worker10 worker10;
    private volatile Worker11 worker11;
    private volatile SilentWorker silent;
    private volatile SilentWorker2 silent2;

    private boolean semaforoWorker3 = false, semaforoWorker2 = false, semaforoWorker1 = false,
            semaforoWorker4 = false, semaforoWorker5 = false, semaforoWorker6 = false,
            semaforoWorker7 = false, semaforoWorker8 = false, semaforoSilentWorker = false,
            semaforoSilentWorker2 = false, semaforoWorker9 = false, semaforoWorker10 = false, semaforoWorker11 = false;

    private LocalDateTime[] nextRollArray;
    private ArrayList<Integer> balanceRoll = new ArrayList<>();
    private int[] balanceTotal;
    private boolean pause = true;
    private LocalTime reloj = LocalTime.of(00, 00, 00);
    private final ArrayList<String> proxyRuta = new ArrayList<>();
    private final ArrayList<Proxies> proxies = new ArrayList<>();
    private int[] terminada;
    private final int[] tipoBono = new int[2];
    private String[] newProfile;

    private final Properties PROP = new Properties();
    private final String PROP_PATH = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Roaming\\GT Tools\\config.properties";
    private final String user;
    private final String pass;
    private boolean checkBonusRP,
            checkBonusBTC,
            backGroundStatus,
            openPopUp = false;
    private int workerStatus,
            terminadas = 0,
            terminadaCheck = 0;
    private String btcPriceStr;
    private boolean clean = true;
    final int corePoolSize = 100;
    final int maximumPoolSize = 100;
    final long keepAliveTime = 100000;
    final TimeUnit unit = TimeUnit.SECONDS;
    final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(maximumPoolSize);

    public MainFrame(String user, String pass) throws IOException {
        laf();
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        loadPerfiles();
        loadArrays();
        loadProxies();
        properties();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        LogoLabel = new javax.swing.JLabel();
        EstadoInfo = new javax.swing.JLabel();
        labelBalancetotal = new javax.swing.JLabel();
        labelSesion1 = new javax.swing.JLabel();
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
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new MiRenderer();
        jPanel4 = new javax.swing.JPanel();
        BotonPause = new javax.swing.JButton();
        botonBorrarPerfil = new javax.swing.JButton();
        botonIniciar = new javax.swing.JButton();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Firefox_15px.png"))); // NOI18N
        jMenuItem1.setText("Abrir perfil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CoinBot v1.4");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(975, 300));
        setPreferredSize(new java.awt.Dimension(975, 699));
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 120, 215));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);

        LogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/LogoCoinBOT (1).png"))); // NOI18N

        EstadoInfo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        EstadoInfo.setForeground(new java.awt.Color(255, 255, 255));

        labelBalancetotal.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        labelBalancetotal.setForeground(new java.awt.Color(255, 255, 255));
        labelBalancetotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Coins_20px_1.png"))); // NOI18N
        labelBalancetotal.setText("Balance: 0 Sat ~ $ 0");

        labelSesion1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        labelSesion1.setForeground(new java.awt.Color(255, 255, 255));
        labelSesion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Payment_History_20px_2.png"))); // NOI18N
        labelSesion1.setText("Sesion: 0 Sat ~$ 0");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        btcPriiceLabel.setBackground(new java.awt.Color(74, 76, 72));
        btcPriiceLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btcPriiceLabel.setForeground(new java.awt.Color(255, 255, 255));
        btcPriiceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Bitcoin_25px_2.png"))); // NOI18N
        btcPriiceLabel.setText("10000");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Workers_20px.png"))); // NOI18N
        jLabel2.setText("1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("|");

        totalPerfilesLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        totalPerfilesLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalPerfilesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Firefox_20px.png"))); // NOI18N
        totalPerfilesLabel.setText("Total: 0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("|");

        terminadasLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        terminadasLabel.setForeground(new java.awt.Color(255, 255, 255));
        terminadasLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checkmark_20px.png"))); // NOI18N
        terminadasLabel.setText("Terminadas: 0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("|");

        procesandoLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        procesandoLabel.setForeground(new java.awt.Color(255, 255, 255));
        procesandoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Spinner_20px.png"))); // NOI18N
        procesandoLabel.setText("Procesando: 0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("|");

        esperaLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        esperaLabel.setForeground(new java.awt.Color(255, 255, 255));
        esperaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Cafe_20px.png"))); // NOI18N
        esperaLabel.setText("En Espera: 0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("|");

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

        relojLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        relojLabel.setForeground(new java.awt.Color(255, 255, 255));
        relojLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        relojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Watch_20px.png"))); // NOI18N
        relojLabel.setText("0 dias");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("|");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("|");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("00:00:00");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Bitcoin_20px.png"))); // NOI18N
        jLabel6.setText("1 BTC ~ 0 $");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Refresh_25px.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Refresh_25px_1.png"))); // NOI18N
        jButton3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Refresh_25px_1.png"))); // NOI18N
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Refresh_25px_1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btcPriiceLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(totalPerfilesLabel)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel9))
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(procesandoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(terminadasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(esperaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel10)
                .addGap(1, 1, 1)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(relojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jButton3)
                    .addComponent(jLabel7)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(totalPerfilesLabel)
                            .addComponent(procesandoLabel)
                            .addComponent(terminadasLabel)
                            .addComponent(esperaLabel)
                            .addComponent(jLabel6)
                            .addComponent(relojLabel)
                            .addComponent(jLabel4))))
                .addGap(639, 639, 639)
                .addComponent(btcPriiceLabel))
        );

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "#",
                "Perfil",
                "Balance",
                "Puntos",
                "%",
                "<html><center>Roll<br>BTC</center></html>",
                "<html><center>Roll<br>Puntos</center></html>",
                "<html><center>RP<br>Activ.</center></html>",
                "<html><center>Bono<br>RP</center></html>",
                "<html><center>Bono RP<br>FIN</center></html>",
                "<html><center>BTC<br>Activ.</center></html>",
                "<html><center>Bono<br>BTC</center></html>",
                "<html><center>Bono BTC<br>FIN</center></html>",
                "<html><center>Prox.<br>Roll</center></html>",
                "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class

                ,
                java.lang.Object.class

                ,
                java.lang.Object.class

                ,
                java.lang.Object.class

                ,
                java.lang.Object.class

                ,
                java.lang.Integer.class

                ,
                java.lang.Integer.class

                ,
                java.lang.Boolean.class

                ,
                java.lang.Object.class

                ,
                java.lang.Object.class

                ,
                java.lang.Boolean.class

                ,
                java.lang.Object.class

                ,
                java.lang.Object.class

                ,
                java.lang.Object.class

                ,
                java.lang.String.class

            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false, false, true, false, false, false, false
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
        jTable1.getTableHeader().setResizingAllowed(true);
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
        jTable1.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(9).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(11).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(12).setCellRenderer( centerRenderer );
        jTable1.getColumnModel().getColumn(13).setCellRenderer( centerRenderer );
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jTable1.setRowHeight(22);
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 51));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setSortable(false);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(10).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(11).setResizable(false);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(12).setResizable(false);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(13).setResizable(false);
            jTable1.getColumnModel().getColumn(13).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(14).setPreferredWidth(200);
        }

        jPanel4.setBackground(new java.awt.Color(0, 120, 215));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30-1px.png"))); // NOI18N
        BotonPause.setBorder(null);
        BotonPause.setBorderPainted(false);
        BotonPause.setContentAreaFilled(false);
        BotonPause.setFocusable(false);
        BotonPause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonPause.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png"))); // NOI18N
        BotonPause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPauseActionPerformed(evt);
            }
        });
        jPanel4.add(BotonPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 11, 30, 30));

        botonBorrarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px-1.png"))); // NOI18N
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
        jPanel4.add(botonBorrarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        botonIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30Blancopx.png"))); // NOI18N
        botonIniciar.setBorder(null);
        botonIniciar.setBorderPainted(false);
        botonIniciar.setContentAreaFilled(false);
        botonIniciar.setFocusPainted(false);
        botonIniciar.setFocusable(false);
        botonIniciar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png"))); // NOI18N
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });
        jPanel4.add(botonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 11, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(EstadoInfo)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSesion1)
                    .addComponent(labelBalancetotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EstadoInfo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(labelSesion1)
                                .addGap(0, 0, 0)
                                .addComponent(labelBalancetotal)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LogoLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void BotonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPauseActionPerformed
        if (pauseN == 0) {
            pause = false;
            pauseN = 1;
            BotonPause.setSelected(true);
        } else {
            pause = true;
            pauseN = 0;
            BotonPause.setSelected(false);
        }
    }//GEN-LAST:event_BotonPauseActionPerformed

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed

        System.out.println(workerStatus);
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
                hiddenWorker();
                break;
            case 5:
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
                hiddenWorker();
                hiddenWorker2();
                break;
            case 6:
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
                runWorker6();
                hiddenWorker();
                hiddenWorker2();
                break;
            case 7:
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
                runWorker6();
                runWorker7();
                hiddenWorker();
                hiddenWorker2();
                break;

            case 9:
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
                runWorker6();
                runWorker7();
                runWorker8();
                runWorker9();
                hiddenWorker();
                hiddenWorker2();
                break;
            case 10:
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
                runWorker6();
                runWorker7();
                runWorker8();
                runWorker9();
                runWorker10();
                hiddenWorker2();
                break;
            case 11:
                runWorker1();
                runWorker2();
                runWorker3();
                runWorker4();
                runWorker5();
                runWorker6();
                runWorker7();
                runWorker8();
                runWorker9();
                runWorker10();
                runWorker11();
                hiddenWorker();
                hiddenWorker2();
                break;
        }
        
        Sesionreloj();
        statusBar();
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
        totalPerfilesLabel.setText("Total: " + model.getRowCount());
        nextRollArray[model.getRowCount()] = LocalDateTime.of(2020, Month.MARCH, 5, 6, 5);
    }//GEN-LAST:event_botonBorrarPerfilActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int n = JOptionPane.showOptionDialog(rootPane,
                "¿Esta seguro que desea cerrar el programa?",
                "Cerrar sesión",
                JOptionPane.CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Minimizar", "Cerrar"},
                "minimizar");
        if (n == 0) {
            setState(MainFrame.ICONIFIED);
        } else {
            try {
                Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
                Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        properties();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainFrame("", "").setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonPause;
    public javax.swing.JLabel EstadoInfo;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JButton botonBorrarPerfil;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JLabel btcPriiceLabel;
    private javax.swing.JLabel esperaLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
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
        labelSesion1.setText("Sesion: " + String.format("%,d", sumatoriaRoll2) + " Sat ~ $ " + String.format("%.2f", sesionUSD));

        for (int i = 0; i < balanceTotal.length; i++) {
            sumatoriaBalance += balanceTotal[i];
        }
        float balanceUSD = (float) ((sumatoriaBalance * 0.00000001) * btcPrice);
        labelBalancetotal.setText("Balance: " + String.format("%,d", sumatoriaBalance) + " Sat ~ $ " + String.format("%.2f", balanceUSD));
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

                }
            }
        ;
        };
timerReloj.schedule(ttReloj, 1000, 1000);
    }

    private void statusBar() {
        Timer bar = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {

                    for (int i = 0; i < model.getRowCount(); i++) {
                        terminadas = terminadas + terminada[i];
                    }

                    for (int i = 0; i < procesando.length; i++) {
                        procesada = procesada + procesando[i];

                    }
                    terminadaCheck = terminadas;

                    procesandoLabel.setText("Procesando: " + procesada);
                    terminadasLabel.setText("Terminadas: " + terminadaCheck);

                    esperaLabel.setText("En Espera: " + (model.getRowCount() - terminadas));

                    if (terminadaCheck >= model.getRowCount() || nextRollArray[0].equals(LocalDateTime.now())) {
                        System.out.println("Terminado" + terminadaCheck);
                        terminadaCheck = 0;
                        esperaLabel.setText("En Espera: " + model.getRowCount());

                        for (int i = 0; i < model.getRowCount(); i++) {
                            terminada[i] = 0;
                        }
                    }
                    terminadas = 0;

                    if (procesada == 0 && !openPopUp) {
                        if (terminadaCheck == 0) {
                            reOrder();
                        }
                        if (clean) {
                            try {
                                Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
                                Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
                                Runtime.getRuntime().exec("cmd.exe /c start C:\\\"Program Files\\GT Tools\\Temp.bat\"");

                            } catch (IOException ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            clean = false;
                        }
                    }
                    procesada = 0;

                }
            }
        ;
        }
    ;
    bar.schedule(tt,
                5000, 1000);
    }

    private void loadPerfiles() {
        TableCellRenderer renderer = new JComponentTableCellRenderer();
        TableColumnModel col = jTable1.getColumnModel();

        Icon listicon0 = new ImageIcon(getClass().getClassLoader().getResource("Vistas/icons8_Numeric_20px_1.png"));
        JLabel iconLabel0 = new JLabel(listicon0);
        TableColumn col0 = col.getColumn(0);
        col0.setHeaderValue(iconLabel0);
        col0.setHeaderRenderer(renderer);

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
                Object[] rowData = {(int) perfilNumber, perfil, "", "", "", (int) 0, (int) 0, true, "", "", true, "", "", "", ""};
                model.addRow(rowData);
                perfilNumber++;
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(rootPane, "  No se han encontrado perfiles "
                    + "de Firefox", "Error al cargar perfiles.", JOptionPane.WARNING_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadArrays() {

        nextRollArray = new LocalDateTime[model.getRowCount() + 1];
        balanceTotal = new int[model.getRowCount()];
        terminada = new int[model.getRowCount()];

        for (int j = 0; j < model.getRowCount(); j++) {
            nextRollArray[j] = LocalDateTime.of(2017, Month.MARCH, 5, 6, 5).plusMinutes(j);
            balanceTotal[j] = 0;
            terminada[j] = 0;
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

                openPopUp = false;
                btcPriceStr = new BtcPrice().getRetornaPrecio();
                jLabel6.setText("1 BTC ~ " + btcPriceStr + "$");

                deleteUpdates();
                clean = true;
                String connectionURl = "jdbc:sqlserver://140.82.49.125:1433;"
                        + "database=licenceDB;"
                        + "user=" + user + ";"
                        + "password=" + pass + ";";
                try {
                    Connection connection = DriverManager.getConnection(connectionURl);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        ;
        };
timerReloj.schedule(ttReloj, 1000, 420000);
    }

    private void properties() {

        totalPerfilesLabel.setText("Total: " + model.getRowCount());
        esperaLabel.setText("En Espera: " + model.getRowCount());
        procesandoLabel.setText("Procesando: " + procesada);

        try {
            PROP.load(new FileReader(PROP_PATH));
            checkBonusRP = Boolean.valueOf(PROP.getProperty("bonoRpelectStatus"));
            checkBonusBTC = Boolean.valueOf(PROP.getProperty("bonoBtcSelectStatus"));
            backGroundStatus = Boolean.valueOf(PROP.getProperty("backGroundSelectSatatus"));
            workerStatus = Integer.parseInt(PROP.getProperty("activeWorkers"));
            boolean advanced = Boolean.valueOf(PROP.getProperty("advancedMode"));
            tipoBono[0] = Integer.parseInt(PROP.getProperty("limiteBonoRP"));
            tipoBono[1] = Integer.parseInt(PROP.getProperty("limiteBonoBtC"));
            this.setAlwaysOnTop(Boolean.valueOf(PROP.getProperty("alwaysTop")));
            System.out.println(workerStatus);
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(checkBonusRP, i, 7);
                model.setValueAt(checkBonusBTC, i, 10);

            }

            if (!advanced) {
                tablaNormal();
            } else {
                jTable1.getColumn(7).setPreferredWidth(35);
                jTable1.getColumn(7).setMinWidth(35);
                jTable1.getColumn(7).setWidth(35);
                jTable1.getColumn(7).setMaxWidth(35);
                jTable1.getColumn(10).setPreferredWidth(35);
                jTable1.getColumn(10).setMinWidth(35);
                jTable1.getColumn(10).setWidth(35);
                jTable1.getColumn(10).setMaxWidth(35);
                jTable1.getColumn(4).setPreferredWidth(50);
                jTable1.getColumn(4).setMinWidth(50);
                jTable1.getColumn(4).setWidth(50);
                jTable1.getColumn(4).setMaxWidth(50);
            }

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

    private void runWorker1() {
        Timer timer1 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {

                    for (int x = 0; x < model.getRowCount(); x++) {
                        if (nextRollArray[x].isBefore(nextRollArray[x + 1])
                                || nextRollArray[x].isEqual(nextRollArray[x + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[x])) {
                                String estado = (String) jTable1.getValueAt(x, 14);

                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

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
                            checkBonusRP = (Boolean) jTable1.getValueAt(w1, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w1, 10);
                            nextRollArray[w1] = LocalDateTime.now().plusMinutes(15);
                            worker = new Worker(perfil, w1, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);

                            worker.execute();
                            Rectangle cellRect = jTable1.getCellRect(w1, 1, true);
                            jTable1.scrollRectToVisible(cellRect);
                            semaforoWorker1 = worker.get();
                            if (nextRollArray[w1].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w1] = 1;
                            }

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
    timer1.schedule(tt,
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
                                String estado = (String) jTable1.getValueAt(c, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

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
                            checkBonusRP = (Boolean) jTable1.getValueAt(w2, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w2, 10);
                            worker2 = new Worker2(perfil2, w2, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            Rectangle cellRect = jTable1.getCellRect(w2, 1, true);
                            jTable1.scrollRectToVisible(cellRect);
                            worker2.execute();
                            semaforoWorker2 = worker2.get();

                            if (nextRollArray[w2].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w2] = 1;
                            }

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
                                String estado = (String) jTable1.getValueAt(q, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
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
                            checkBonusRP = (Boolean) jTable1.getValueAt(w3, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w3, 10);
                            worker3 = new Worker3(perfil2, w3, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            Rectangle cellRect = jTable1.getCellRect(w3, 1, true);
                            jTable1.scrollRectToVisible(cellRect);
                            worker3.execute();

                            semaforoWorker3 = worker3.get();

                            if (nextRollArray[w3].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w3] = 1;
                            }
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
                                String estado = (String) jTable1.getValueAt(q, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

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
                            checkBonusRP = (Boolean) jTable1.getValueAt(w4, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w4, 10);
                            worker4 = new Worker4(perfil4, w4, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            Rectangle cellRect = jTable1.getCellRect(w4, 1, true);
                            jTable1.scrollRectToVisible(cellRect);
                            worker4.execute();

                            semaforoWorker4 = worker4.get();

                            if (nextRollArray[w4].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w4] = 1;
                            }
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
                                String estado = (String) jTable1.getValueAt(c, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

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
                            checkBonusRP = (Boolean) jTable1.getValueAt(w5, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w5, 10);
                            worker5 = new Worker5(perfil2, w5, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            worker5.execute();

                            semaforoWorker5 = worker5.get();

                            if (nextRollArray[w5].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w5] = 1;
                            }
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
                                String estado = (String) jTable1.getValueAt(c, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

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
                            checkBonusRP = (Boolean) jTable1.getValueAt(w6, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w6, 10);
                            worker6 = new Worker6(perfil2, w6, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            worker6.execute();

                            semaforoWorker6 = worker6.get();

                            if (nextRollArray[w6].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w6] = 1;
                            }
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
                                String estado = (String) jTable1.getValueAt(c, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

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
                            checkBonusRP = (Boolean) jTable1.getValueAt(w7, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w7, 10);
                            worker7 = new Worker7(perfil2, w7, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            worker7.execute();
                            semaforoWorker7 = worker7.get();

                            if (nextRollArray[w7].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w7] = 1;
                            }
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

    private void runWorker8() {
        Timer timer8 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int x = 0; x < model.getRowCount(); x++) {
                        if (nextRollArray[x].isBefore(nextRollArray[x + 1])
                                || nextRollArray[x].isEqual(nextRollArray[x + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[x])) {
                                String estado = (String) jTable1.getValueAt(x, 14);

                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

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
                            checkBonusRP = (Boolean) jTable1.getValueAt(w8, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w8, 10);
                            worker8 = new Worker8(perfil, w8, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            worker8.execute();
                            semaforoWorker8 = worker8.get();
                            if (nextRollArray[w8].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w8] = 1;
                            }

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
    timer8.schedule(tt,
                4500, 1000);
    }

    private void runWorker9() {
        Timer timer8 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int x = 0; x < model.getRowCount(); x++) {
                        if (nextRollArray[x].isBefore(nextRollArray[x + 1])
                                || nextRollArray[x].isEqual(nextRollArray[x + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[x])) {
                                String estado = (String) jTable1.getValueAt(x, 14);

                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

                                    w9 = x;
                                    semaforoWorker9 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker9 = false;
                        }
                    }
                    if (semaforoWorker9) {
                        try {
                            semaforoWorker9 = false;
                            String perfil = (String) jTable1.getValueAt(w9, 1);
                            nextRollArray[w9] = LocalDateTime.now().plusMinutes(15);
                            checkBonusRP = (Boolean) jTable1.getValueAt(w9, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w9, 10);
                            worker9 = new Worker9(perfil, w9, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            semaforoWorker9 = worker9.run();
                            if (nextRollArray[w9].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w9] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        }
    ;
    timer8.schedule(tt,
                5000, 1000);
    }

    private void runWorker10() {
        Timer timer8 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int x = 0; x < model.getRowCount(); x++) {
                        if (nextRollArray[x].isBefore(nextRollArray[x + 1])
                                || nextRollArray[x].isEqual(nextRollArray[x + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[x])) {
                                String estado = (String) jTable1.getValueAt(x, 14);

                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

                                    w10 = x;
                                    semaforoWorker10 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker10 = false;
                        }
                    }
                    if (semaforoWorker10) {
                        try {
                            semaforoWorker10 = false;
                            String perfil = (String) jTable1.getValueAt(w10, 1);
                            nextRollArray[w10] = LocalDateTime.now().plusMinutes(15);
                            checkBonusRP = (Boolean) jTable1.getValueAt(w10, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w10, 10);
                            worker10 = new Worker10(perfil, w10, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            semaforoWorker10 = worker10.run();
                            if (nextRollArray[w10].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w10] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        }
    ;
    timer8.schedule(tt,
                5500, 1000);
    }

    private void runWorker11() {
        Timer timer8 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int x = 0; x < model.getRowCount(); x++) {
                        if (nextRollArray[x].isBefore(nextRollArray[x + 1])
                                || nextRollArray[x].isEqual(nextRollArray[x + 1])) {

                            if (LocalDateTime.now().isAfter(nextRollArray[x])) {
                                String estado = (String) jTable1.getValueAt(x, 14);

                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {

                                    w11 = x;
                                    semaforoWorker11 = true;
                                    break;
                                }
                            }
                        } else {
                            semaforoWorker11 = false;
                        }
                    }
                    if (semaforoWorker11) {
                        try {
                            semaforoWorker11 = false;
                            String perfil = (String) jTable1.getValueAt(w11, 1);
                            nextRollArray[w11] = LocalDateTime.now().plusMinutes(15);
                            checkBonusRP = (Boolean) jTable1.getValueAt(w11, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(w11, 10);
                            worker11 = new Worker11(perfil, w11, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            semaforoWorker11 = worker11.run();
                            if (nextRollArray[w11].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w11] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    sumarRoll();
                }
            }
        ;
        }
    ;
    timer8.schedule(tt,
                6000, 1000);
    }

    private void hiddenWorker() {
        Timer hidden1 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int x = 0; x < model.getRowCount(); x++) {

                        String estado = (String) jTable1.getValueAt(x, 14);

                        if (estado.contains("Ha ocurrido un error")
                                || estado.contains("CAPTCHA_TIMEOUT")) {

                            silentSelector = x;
                            semaforoSilentWorker = true;
                            break;
                        } else {
                            semaforoSilentWorker = false;
                        }
                    }
                    if (semaforoSilentWorker) {
                        try {
                            semaforoSilentWorker = false;
                            String perfil = (String) jTable1.getValueAt(silentSelector, 1);
                            nextRollArray[silentSelector] = LocalDateTime.now().plusMinutes(15);
                            checkBonusRP = (Boolean) jTable1.getValueAt(silentSelector, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(silentSelector, 10);
                            silent = new SilentWorker(perfil, silentSelector, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            silent.execute();
                            semaforoSilentWorker = silent.get();
                            if (nextRollArray[silentSelector].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[silentSelector] = 1;
                            }

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
    hidden1.schedule(tt,
                8000, 1000);
    }

    private void hiddenWorker2() {
        Timer hidden2 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause) {
                    for (int x = 0; x < model.getRowCount(); x++) {

                        String estado = (String) jTable1.getValueAt(x, 14);

                        if (estado.contains("Ha ocurrido un error")
                                || estado.contains("CAPTCHA_TIMEOUT")) {

                            silentSelector2 = x;
                            semaforoSilentWorker2 = true;
                            break;
                        } else {
                            semaforoSilentWorker2 = false;
                        }
                    }
                    if (semaforoSilentWorker2) {
                        try {
                            semaforoSilentWorker2 = false;
                            String perfil = (String) jTable1.getValueAt(silentSelector2, 1);
                            nextRollArray[silentSelector2] = LocalDateTime.now().plusMinutes(15);
                            checkBonusRP = (Boolean) jTable1.getValueAt(silentSelector2, 7);
                            checkBonusBTC = (Boolean) jTable1.getValueAt(silentSelector2, 10);
                            silent2 = new SilentWorker2(perfil, silentSelector2, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, checkBonusRP, checkBonusBTC, proxies, procesando, tipoBono);
                            silent2.execute();
                            semaforoSilentWorker2 = silent2.get();
                            if (nextRollArray[silentSelector2].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[silentSelector2] = 1;
                            }

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
    hidden2.schedule(tt,
                8500, 1000);
    }

    private void tablaNormal() {
        jTable1.getColumn(0).setPreferredWidth(30);
        jTable1.getColumn(0).setWidth(30);
        jTable1.getColumn(0).setMaxWidth(30);

        jTable1.getColumn(1).setPreferredWidth(100);
        jTable1.getColumn(1).setWidth(100);
        jTable1.getColumn(1).setMaxWidth(100);

        jTable1.getColumn(2).setPreferredWidth(80);
        jTable1.getColumn(2).setWidth(80);
        jTable1.getColumn(2).setMaxWidth(80);

        jTable1.getColumn(3).setPreferredWidth(60);
        jTable1.getColumn(3).setWidth(60);
        jTable1.getColumn(3).setMaxWidth(60);

        jTable1.getColumn(5).setPreferredWidth(50);
        jTable1.getColumn(5).setWidth(50);
        jTable1.getColumn(5).setMaxWidth(50);

        jTable1.getColumn(6).setPreferredWidth(50);
        jTable1.getColumn(6).setWidth(50);
        jTable1.getColumn(6).setMaxWidth(50);

        jTable1.getColumn(8).setPreferredWidth(60);
        jTable1.getColumn(8).setWidth(60);
        jTable1.getColumn(8).setMaxWidth(60);

        jTable1.getColumn(9).setPreferredWidth(60);
        jTable1.getColumn(9).setWidth(60);
        jTable1.getColumn(9).setMaxWidth(60);

        jTable1.getColumn(11).setPreferredWidth(60);
        jTable1.getColumn(11).setWidth(60);
        jTable1.getColumn(11).setMaxWidth(60);

        jTable1.getColumn(12).setPreferredWidth(60);
        jTable1.getColumn(12).setWidth(60);
        jTable1.getColumn(12).setMaxWidth(60);

        jTable1.getColumn(13).setPreferredWidth(70);
        jTable1.getColumn(13).setWidth(70);
        jTable1.getColumn(13).setMaxWidth(70);

        jTable1.getColumn(7).setPreferredWidth(0);
        jTable1.getColumn(7).setMinWidth(0);
        jTable1.getColumn(7).setWidth(0);
        jTable1.getColumn(7).setMaxWidth(0);

        jTable1.getColumn(10).setPreferredWidth(0);
        jTable1.getColumn(10).setMinWidth(0);
        jTable1.getColumn(10).setWidth(0);
        jTable1.getColumn(10).setMaxWidth(0);

        jTable1.getColumn(4).setPreferredWidth(0);
        jTable1.getColumn(4).setMinWidth(0);
        jTable1.getColumn(4).setWidth(0);
        jTable1.getColumn(4).setMaxWidth(0);

    }

    private void reOrder() {
        String[] puntosReward = new String[model.getRowCount()];
        String[] porcen = new String[model.getRowCount()];
        int[] rollbtc = new int[model.getRowCount()];
        int[] rollPuntos = new int[model.getRowCount()];
        Boolean[] rpActi = new Boolean[model.getRowCount()];
        String[] bonoRP = new String[model.getRowCount()];
        String[] bonoRPFin = new String[model.getRowCount()];
        Boolean[] btcActi = new Boolean[model.getRowCount()];
        String[] bonoBTC = new String[model.getRowCount()];
        String[] bonoBTCFin = new String[model.getRowCount()];
        String[] proxRoll = new String[model.getRowCount()];
        String[] status = new String[model.getRowCount()];
        newProfile = new String[model.getRowCount()];

        for (int i = 0; i < model.getRowCount(); i++) {
            newProfile[i] = (String) model.getValueAt(i, 1);
            puntosReward[i] = (String) model.getValueAt(i, 3);
            porcen[i] = (String) model.getValueAt(i, 4);
            rollbtc[i] = (int) model.getValueAt(i, 5);
            rollPuntos[i] = (int) model.getValueAt(i, 5);
            rpActi[i] = (Boolean) model.getValueAt(i, 7);
            bonoRP[i] = (String) model.getValueAt(i, 8);
            bonoRPFin[i] = (String) model.getValueAt(i, 9);
            btcActi[i] = (Boolean) model.getValueAt(i, 10);
            bonoBTC[i] = (String) model.getValueAt(i, 11);
            bonoBTCFin[i] = (String) model.getValueAt(i, 12);
            proxRoll[i] = (String) model.getValueAt(i, 13);
            status[i] = (String) model.getValueAt(i, 14);

        }

        int cuentaintercambios = 0; //Variable que cuenta los intercambios que hacemos
        for (boolean ordenado = false; !ordenado;) {
            for (int i = 0; i < model.getRowCount() - 1; i++) {

                if (nextRollArray[i].isAfter(nextRollArray[i + 1])) {

                    LocalDateTime horaAux = nextRollArray[i];
                    nextRollArray[i] = nextRollArray[i + 1];
                    nextRollArray[i + 1] = horaAux;

                    String perfilAux = newProfile[i];
                    newProfile[i] = newProfile[i + 1];
                    newProfile[i + 1] = perfilAux;

                    int balanceAux = balanceTotal[i];
                    balanceTotal[i] = balanceTotal[i + 1];
                    balanceTotal[i + 1] = balanceAux;

                    String puntosAux = puntosReward[i];
                    puntosReward[i] = puntosReward[i + 1];
                    puntosReward[i + 1] = puntosAux;

                    int rollBTCAux = rollbtc[i];
                    rollbtc[i] = rollbtc[i + 1];
                    rollbtc[i + 1] = rollBTCAux;

                    int rollPuntosAux = rollPuntos[i];
                    rollPuntos[i] = rollPuntos[i + 1];
                    rollPuntos[i + 1] = rollPuntosAux;

                    String porcentajeAux = porcen[i];
                    porcen[i] = porcen[i + 1];
                    porcen[i + 1] = porcentajeAux;

                    boolean rpActiAux = rpActi[i];
                    rpActi[i] = rpActi[i + 1];
                    rpActi[i + 1] = rpActiAux;

                    String bonoRPAux = bonoRP[i];
                    bonoRP[i] = bonoRP[i + 1];
                    bonoRP[i + 1] = bonoRPAux;

                    String bonoRPFinAux = bonoRPFin[i];
                    bonoRPFin[i] = bonoRPFin[i + 1];
                    bonoRPFin[i + 1] = bonoRPFinAux;

                    boolean btcActiAux = btcActi[i];
                    btcActi[i] = btcActi[i + 1];
                    btcActi[i + 1] = btcActiAux;

                    String bonoBTCAux = bonoBTC[i];
                    bonoBTC[i] = bonoBTC[i + 1];
                    bonoBTC[i + 1] = bonoBTCAux;

                    String bonoBTCFinAux = bonoBTCFin[i];
                    bonoBTCFin[i] = bonoBTCFin[i + 1];
                    bonoBTCFin[i + 1] = bonoBTCFinAux;

                    String proxRollAux = proxRoll[i];
                    proxRoll[i] = proxRoll[i + 1];
                    proxRoll[i + 1] = proxRollAux;

                    String statusAux = status[i];
                    status[i] = status[i + 1];
                    status[i + 1] = statusAux;

                    int terminadaAux = terminada[i];
                    terminada[i] = terminada[i + 1];
                    terminada[i + 1] = terminadaAux;
                }
            }
            if (cuentaintercambios == 0) {
                ordenado = true;
            }
            cuentaintercambios = 0;
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(newProfile[i], i, 1);
            model.setValueAt(String.format("%,d", balanceTotal[i]), i, 2);
            model.setValueAt(puntosReward[i], i, 3);
            model.setValueAt(porcen[i], i, 4);
            model.setValueAt((int) 0, i, 5);
            model.setValueAt((int) 0, i, 6);
            model.setValueAt(rpActi[i], i, 7);
            model.setValueAt(bonoRP[i], i, 8);
            model.setValueAt(bonoRPFin[i], i, 9);
            model.setValueAt(btcActi[i], i, 10);
            model.setValueAt(bonoBTC[i], i, 11);
            model.setValueAt(bonoBTCFin[i], i, 12);
            model.setValueAt(proxRoll[i], i, 13);
            model.setValueAt(status[i], i, 14);

        }
    }
}
