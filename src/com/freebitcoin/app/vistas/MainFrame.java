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
import java.time.format.DateTimeFormatter;
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

    private int w1 = 0, w2 = 1, w3 = 2, w4 = 3, w5 = 4, w6 = 5, w7 = 6, w8 = 7,
            w9 = 8, w10 = 9, w11 = 10, w12 = 11, pauseN = 0, silentSelector = 0,
            silentSelector2 = 0;
    private int dia = 0;
    private final int[] procesando = new int[15];
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

    private boolean[] pause = new boolean[14];
    private LocalDateTime[] nextRollArray;
    private final ArrayList<Integer> balanceRoll = new ArrayList<>();
    private int[] balanceTotal;
    private int[] ticketCount;
    private LocalTime reloj = LocalTime.of(00, 00, 00);
    private LocalDateTime horaPause;
    private LocalDateTime buyTicket;
    private LocalDateTime minHora;
    private final ArrayList<String> proxyRuta = new ArrayList<>();
    private final ArrayList<Proxies> proxies = new ArrayList<>();
    private int[] terminada;
    private final int[] tipoBono = new int[3];
    private String[] newProfile;
    private String montoResidual, porcentajeRetirar;

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
            terminadaCheck = 0,
            totalTicket = 0;
    private String btcPriceStr;
    private boolean clean = true;
    private int nextStop, stopDuring;

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

        tablaRetiros();
        ticketCount = new int[model.getRowCount()];
        jDialog1.setLocationRelativeTo(this);
        jTable1.getColumn(15).setPreferredWidth(0);
        jTable1.getColumn(15).setMinWidth(0);
        jTable1.getColumn(15).setWidth(0);
        jTable1.getColumn(15).setMaxWidth(0);
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
        configPane = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        monsterIP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        captchaKey1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        proxyUser = new javax.swing.JTextField();
        proxyPass = new javax.swing.JTextField();
        sendProxy = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        backgroundStatus = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        AlwaysOnTop = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        activeWorkers = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        bonusRP = new javax.swing.JCheckBox();
        bonoBTC = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        activePause = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        limiteRP = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        limiteBTC = new javax.swing.JComboBox<>();
        nextPause = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        ticketMonto = new javax.swing.JSpinner();
        jLabel29 = new javax.swing.JLabel();
        ticketDia = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        modoAvanzado = new javax.swing.JCheckBox();
        detenerDurante = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        retiroAutoCheck = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        residualTextFiel = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
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

        configPane.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        configPane.setTitle("Configuración");
        configPane.setBackground(new java.awt.Color(51, 102, 255));
        configPane.setLocation(new java.awt.Point(0, 0));
        configPane.setMinimumSize(new java.awt.Dimension(350, 114));
        configPane.setModalityType(java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
        configPane.setName("Configuracón"); // NOI18N
        configPane.setPreferredSize(new java.awt.Dimension(590, 590));
        configPane.setResizable(false);
        configPane.setSize(new java.awt.Dimension(590, 590));
        configPane.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 120, 215));
        jPanel3.setPreferredSize(new java.awt.Dimension(560, 455));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(570, 610));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/capmonsterminipng.png"))); // NOI18N
        jLabel12.setText("Software IP:");
        jLabel12.setToolTipText("<html>IP del servidor donde esta corriendo CapMonster.<br> Si CapMonster esta en el mismo computador no modifiques este campo.</html>");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 51, -1, -1));

        monsterIP.setBackground(new java.awt.Color(51, 51, 51));
        monsterIP.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        monsterIP.setForeground(new java.awt.Color(220, 220, 220));
        monsterIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        monsterIP.setText("127.0.0.3");
        monsterIP.setToolTipText("");
        monsterIP.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel5.add(monsterIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 50, -1, -1));

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Key_20px.png"))); // NOI18N
        jLabel14.setText("Software Key:");
        jLabel14.setToolTipText("Si activas la protección en CapMonster, coloca tu clave aqui");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 51, 130, -1));

        captchaKey1.setBackground(new java.awt.Color(51, 51, 51));
        captchaKey1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        captchaKey1.setForeground(new java.awt.Color(220, 220, 220));
        captchaKey1.setText("1234567890aAbBcC");
        captchaKey1.setToolTipText("");
        jPanel5.add(captchaKey1, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 50, 130, -1));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Firewall_20px.png"))); // NOI18N
        jLabel15.setText("Proxy:");
        jLabel15.setToolTipText("Si tu servicio usa Autenticación por IP no modifiques estos campos");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 91, -1, -1));

        proxyUser.setBackground(new java.awt.Color(51, 51, 51));
        proxyUser.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        proxyUser.setForeground(new java.awt.Color(220, 220, 220));
        proxyUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proxyUser.setText("Usuario");
        proxyUser.setToolTipText("<html>Usuario de tu servicio de proxy.<br> Asegurate de que no contenga espacios.</html>");
        jPanel5.add(proxyUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 91, 90, -1));

        proxyPass.setBackground(new java.awt.Color(51, 51, 51));
        proxyPass.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        proxyPass.setForeground(new java.awt.Color(220, 220, 220));
        proxyPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proxyPass.setText("Contraseña");
        proxyPass.setToolTipText("<html>Contraseña de tu servicio de proxy.<br> Asegurate de que no contenga espacios.</html>");
        jPanel5.add(proxyPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 92, 90, -1));

        sendProxy.setBackground(new java.awt.Color(51, 51, 51));
        sendProxy.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        sendProxy.setForeground(new java.awt.Color(255, 255, 255));
        sendProxy.setText("Enviar Proxy al Software");
        sendProxy.setToolTipText("<html>Enviar los proxy directamente a CapMonster.<br> Si desactivas esta opción asegurare de indicar tu lista de proxy a CapMonster</html>");
        jPanel5.add(sendProxy, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 91, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Hide_20px.png"))); // NOI18N
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 330, -1, -1));

        backgroundStatus.setBackground(new java.awt.Color(51, 51, 51));
        backgroundStatus.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        backgroundStatus.setForeground(new java.awt.Color(255, 255, 255));
        backgroundStatus.setText("Segundo Plano");
        backgroundStatus.setToolTipText("Oculta las ventanas de Firefox");
        jPanel5.add(backgroundStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 330, -1, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_iMac_20px.png"))); // NOI18N
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 330, -1, -1));

        AlwaysOnTop.setBackground(new java.awt.Color(51, 51, 51));
        AlwaysOnTop.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        AlwaysOnTop.setForeground(new java.awt.Color(255, 255, 255));
        AlwaysOnTop.setText("Fijar ventana");
        AlwaysOnTop.setToolTipText("Fija la ventana de CoinBOT sobre todas las demas.");
        AlwaysOnTop.setBorder(null);
        jPanel5.add(AlwaysOnTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Workers_20px.png"))); // NOI18N
        jLabel18.setText("Mineros:");
        jLabel18.setToolTipText("Selecciona la cantidad de Mineros que usaras.");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 330, 80, -1));

        activeWorkers.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        activeWorkers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));
        activeWorkers.setToolTipText("");
        jPanel5.add(activeWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 330, -1, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Star_Filled_20px.png"))); // NOI18N
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 172, -1, -1));

        bonusRP.setBackground(new java.awt.Color(51, 51, 51));
        bonusRP.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        bonusRP.setForeground(new java.awt.Color(255, 255, 255));
        bonusRP.setText("Reward Point");
        jPanel5.add(bonusRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 172, -1, 20));

        bonoBTC.setBackground(new java.awt.Color(51, 51, 51));
        bonoBTC.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        bonoBTC.setForeground(new java.awt.Color(255, 255, 255));
        bonoBTC.setText("Bono BTC");
        jPanel5.add(bonoBTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 172, 90, 20));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Loyalty_Card_20px.png"))); // NOI18N
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 172, -1, -1));

        activePause.setBackground(new java.awt.Color(51, 51, 51));
        activePause.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        activePause.setForeground(new java.awt.Color(255, 255, 255));
        activePause.setText("Pausar automaticamente cada");
        activePause.setToolTipText("Pausa CoinBOT durante un tiempo determinado para sincronizar las horas");
        activePause.setActionCommand("Habilitar");
        activePause.setPreferredSize(new java.awt.Dimension(119, 17));
        jPanel5.add(activePause, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 369, 208, -1));

        jLabel21.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Limite Reward Point: ");
        jLabel21.setToolTipText("<html>Establece un limite de bonos RP.<br> Se activaran todos los bonos por debajo de este limite, incluyendo el que indiques</html>");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 211, -1, -1));

        limiteRP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100 RP", "50 RP", "10 RP", "1 RP" }));
        limiteRP.setToolTipText("");
        jPanel5.add(limiteRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 210, 60, -1));

        jLabel22.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Limite Bono BTC: ");
        jLabel22.setToolTipText("<html>Establece un limite de bonos BTC.<br> Se activaran todos los bonos por debajo de este limite, incluyendo el que indiques</html>");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 211, -1, -1));

        limiteBTC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1000%", "500%", "100%", "50%", "10%" }));
        jPanel5.add(limiteBTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 210, -1, -1));

        nextPause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 Horas", "6 Horas", "12 Horas", "24 Horas" }));
        jPanel5.add(nextPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 368, -1, -1));

        jLabel24.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Durante:");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 369, -1, -1));

        jLabel27.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Buy_20px.png"))); // NOI18N
        jLabel27.setText("Automprar");
        jLabel27.setToolTipText("Si deseas compprar Tickets periodicamente indica la cantidad y el tiempo entre compras. De lo contrario dejalo en 0");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 254, -1, -1));

        ticketMonto.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 25));
        jPanel5.add(ticketMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 254, 60, -1));

        jLabel29.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Tickets cada");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 255, -1, -1));

        ticketDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Dia", "2 Dias", "3 Dias", "7 Dias" }));
        jPanel5.add(ticketDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 254, 60, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png"))); // NOI18N
        jButton4.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 517, -1, -1));
        jPanel5.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, 210, 10));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Servicio Captcha");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 12, -1, -1));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 144, 210, 10));

        jLabel28.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText(" Bonos y Tickets");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 134, 114, -1));
        jPanel5.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 144, 210, 10));
        jPanel5.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 21, 210, 11));
        jPanel5.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 302, 176, 10));

        jLabel30.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText(" Configuraciones Generales");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 292, -1, -1));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 302, 176, 10));

        modoAvanzado.setBackground(new java.awt.Color(51, 51, 51));
        modoAvanzado.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        modoAvanzado.setForeground(new java.awt.Color(255, 255, 255));
        modoAvanzado.setText("Tabla Avanzada");
        modoAvanzado.setToolTipText("Muestra 3 Columnas extras en la tabla.");
        modoAvanzado.setPreferredSize(new java.awt.Dimension(119, 17));
        jPanel5.add(modoAvanzado, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 174, 130, -1));

        detenerDurante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10 Minutos", "20 Minutos", "30 Minutos", "40 Minutos", "50 Minutos", "60 Minutos" }));
        jPanel5.add(detenerDurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 368, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Private_20px.png"))); // NOI18N
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 368, -1, -1));
        jPanel5.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 416, 205, 10));

        jLabel31.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Retiro Automático");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 406, -1, -1));
        jPanel5.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 416, 206, 10));

        jRadioButton1.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Lento");
        jRadioButton1.setToolTipText(" Duración: 6-24 Horas");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 463, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Instantaneo");
        jRadioButton2.setToolTipText("Duración: ~15 Minutos");
        jPanel5.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 490, -1, -1));

        jRadioButton3.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Todo");
        jRadioButton3.setToolTipText("Retira Todo el balance de tus cuentas");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 465, 77, -1));

        jRadioButton4.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Porcentual");
        jRadioButton4.setToolTipText("Establece el porcentaje del Saldo que deseas retirar de tu cuenta");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 492, -1, -1));

        jRadioButton5.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Residual");
        jRadioButton5.setToolTipText("Establece la cantidad que deseas mantener en tu cuenta. El resto será retirado a la cartera que indiques");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 517, 77, -1));

        jLabel23.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Tipo de Retiro");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 444, -1, -1));

        jLabel26.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Cantidad ");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 444, -1, -1));

        retiroAutoCheck.setBackground(new java.awt.Color(51, 51, 51));
        retiroAutoCheck.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        retiroAutoCheck.setForeground(new java.awt.Color(255, 255, 255));
        retiroAutoCheck.setText("Habilitar Retiro");
        retiroAutoCheck.setToolTipText("");
        retiroAutoCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retiroAutoCheckActionPerformed(evt);
            }
        });
        jPanel5.add(retiroAutoCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 444, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Initiate_Money_Transfer_20px.png"))); // NOI18N
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 444, -1, -1));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Turtle_20px.png"))); // NOI18N
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 468, -1, -1));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Quick_Mode_On_20px.png"))); // NOI18N
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 495, -1, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Full_Battery_20px.png"))); // NOI18N
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 470, -1, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Charged_Battery_20px.png"))); // NOI18N
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 491, -1, -1));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Low_Battery_20px.png"))); // NOI18N
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 517, -1, -1));

        residualTextFiel.setBackground(new java.awt.Color(51, 51, 51));
        residualTextFiel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        residualTextFiel.setForeground(new java.awt.Color(255, 255, 255));
        residualTextFiel.setText("ej. 3000");
        jPanel5.add(residualTextFiel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 70, -1));

        jTextField2.setBackground(new java.awt.Color(51, 51, 51));
        jTextField2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("ej. 95%");
        jPanel5.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 487, 70, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 573, 550));

        configPane.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 585, 564));

        configPane.getAccessibleContext().setAccessibleParent(this);

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setAlwaysOnTop(true);
        jDialog1.setMinimumSize(new java.awt.Dimension(330, 79));
        jDialog1.setUndecorated(true);
        jDialog1.setPreferredSize(new java.awt.Dimension(330, 79));
        jDialog1.setSize(new java.awt.Dimension(330, 79));
        jDialog1.setType(java.awt.Window.Type.POPUP);

        jPanel6.setBackground(new java.awt.Color(0, 120, 215));
        jPanel6.setMinimumSize(new java.awt.Dimension(348, 78));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CoinBOT se ha pausado. ");

        jLabel38.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Se renaudara a las");

        jLabel39.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("08:30PM");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freebitcoin/app/images/icons8_Notification_54px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 330, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDialog1.getAccessibleContext().setAccessibleParent(this);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
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
                "Estado",
                "Tickets",
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
                ,
                java.lang.Boolean.class

            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false, false, true, false, false, false, false,false
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelBalancetotal)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelSesion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstadoInfo)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(labelSesion1))
                                .addComponent(LogoLabel))
                            .addGap(0, 0, 0)
                            .addComponent(labelBalancetotal)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        configPane.setLocationRelativeTo(this);
        configPane.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPauseActionPerformed
        if (pauseN == 0) {

            for (int i = 0; i < pause.length; i++) {
                pause[i] = false;

            }
            pauseN = 1;
            BotonPause.setSelected(true);
        } else {
            for (int i = 0; i < pause.length; i++) {
                pause[i] = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pauseN = 0;
            BotonPause.setSelected(false);
        }
    }//GEN-LAST:event_BotonPauseActionPerformed

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed

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
        horaPause = LocalDateTime.now().plusHours(nextStop);
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        configPane.dispose();
        saveProperties();
        properties();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jDialog1.setLocationRelativeTo(this);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jTextField2.setVisible(false);
        residualTextFiel.setVisible(true);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void retiroAutoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retiroAutoCheckActionPerformed
        if (retiroAutoCheck.isSelected()) {
            jRadioButton1.setEnabled(true);
            jRadioButton2.setEnabled(true);
            jRadioButton3.setEnabled(true);
            jRadioButton4.setEnabled(true);
            jRadioButton5.setEnabled(true);
            jLabel33.setEnabled(true);
            jLabel34.setEnabled(true);
            jLabel35.setEnabled(true);
            jLabel36.setEnabled(true);
            jLabel37.setEnabled(true);
        } else {
            jRadioButton1.setEnabled(false);
            jRadioButton2.setEnabled(false);
            jRadioButton3.setEnabled(false);
            jRadioButton4.setEnabled(false);
            jRadioButton5.setEnabled(false);
            jLabel33.setEnabled(false);
            jLabel34.setEnabled(false);
            jLabel35.setEnabled(false);
            jLabel36.setEnabled(false);
            jLabel37.setEnabled(false);
        }
    }//GEN-LAST:event_retiroAutoCheckActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jTextField2.setVisible(true);
        residualTextFiel.setVisible(false);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jTextField2.setVisible(false);
        residualTextFiel.setVisible(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

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
    private javax.swing.JCheckBox AlwaysOnTop;
    private javax.swing.JButton BotonPause;
    public javax.swing.JLabel EstadoInfo;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JCheckBox activePause;
    private javax.swing.JComboBox<String> activeWorkers;
    private javax.swing.JCheckBox backgroundStatus;
    private javax.swing.JCheckBox bonoBTC;
    private javax.swing.JCheckBox bonusRP;
    private javax.swing.JButton botonBorrarPerfil;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JLabel btcPriiceLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField captchaKey1;
    private javax.swing.JDialog configPane;
    private javax.swing.JComboBox<String> detenerDurante;
    private javax.swing.JLabel esperaLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelBalancetotal;
    private javax.swing.JLabel labelSesion1;
    private javax.swing.JComboBox<String> limiteBTC;
    private javax.swing.JComboBox<String> limiteRP;
    private javax.swing.JCheckBox modoAvanzado;
    private javax.swing.JTextField monsterIP;
    private javax.swing.JComboBox<String> nextPause;
    private javax.swing.JLabel procesandoLabel;
    private javax.swing.JTextField proxyPass;
    private javax.swing.JTextField proxyUser;
    private javax.swing.JLabel relojLabel;
    private javax.swing.JTextField residualTextFiel;
    private javax.swing.JCheckBox retiroAutoCheck;
    private javax.swing.JCheckBox sendProxy;
    private javax.swing.JLabel terminadasLabel;
    private javax.swing.JComboBox<String> ticketDia;
    private javax.swing.JSpinner ticketMonto;
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

                reloj = reloj.plusSeconds(1);
                jLabel4.setText(reloj.toString());
                if (reloj.isAfter(LocalTime.of(23, 59, 58))) {
                    dia++;
                    relojLabel.setText(dia + " dia");
                }
                if (activePause.isSelected()) {
                    //Pausa periodica del bot
                    if (LocalDateTime.now().isAfter(horaPause)) {
                        try {
                            for (int i = 0; i < pause.length; i++) {
                                pause[i] = false;
                            }

                            jLabel39.setText(LocalDateTime.now().plusMinutes(stopDuring / 60000).format(DateTimeFormatter.ofPattern("hh:mm a")));
                            horaPause = LocalDateTime.now().plusHours(nextStop);
                            jDialog1.setVisible(true);
                            Thread.sleep(stopDuring);
                            jDialog1.setVisible(false);
                            for (int i = 0; i < pause.length; i++) {
                                pause[i] = true;
                                Thread.sleep(500);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                //Auto compra de tickets
                if (LocalDateTime.now().isAfter(buyTicket)) {
                    for (int i = 0; i < model.getRowCount(); i++) {
                        model.setValueAt(true, i, 15);
                        totalTicket = totalTicket + ticketCount[i];
                    }
                    if (totalTicket >= model.getRowCount()) {
                        //se actualiza la hora de compra de tikects y se desactiva
                        for (int i = 0; i < model.getRowCount(); i++) {
                            model.setValueAt(false, i, 15);
                        }
                    }
                }
            }

        ;
        }
            ;
            timerReloj.schedule(ttReloj,
                1000, 1000);
    }

    private void statusBar() {
        Timer bar = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {

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
                minHora = nextRollArray[0];
                if (terminadaCheck >= model.getRowCount() || LocalDateTime.now().isAfter(minHora.minusMinutes(3))) {
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

                    for (int i = 1; i < nextRollArray.length; i++) {
                        if (nextRollArray[i].isBefore(minHora)) {
                            minHora = nextRollArray[i];
                        }
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

        TableColumn col1 = col.getColumn(1);

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
                Object[] rowData = {(int) perfilNumber, perfil, "38g3Qrcr4vCR49uTL1VAa1Cf1u4zfaL2Vf", "", "", (int) 0, (int) 0, true, "", "", true, "", "", "", ""};
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
        pause = new boolean[13];
        for (int i = 0; i < pause.length; i++) {
            pause[i] = true;

        }
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
        jTextField2.setVisible(false);
        residualTextFiel.setVisible(false);

        try {
            proxyUser.setText(PROP.getProperty("proxyUser"));
            proxyPass.setText(PROP.getProperty("proxyPass"));

            PROP.load(new FileReader(PROP_PATH));
            checkBonusRP = Boolean.valueOf(PROP.getProperty("bonoRpelectStatus"));
            bonusRP.setSelected(true);
            checkBonusBTC = Boolean.valueOf(PROP.getProperty("bonoBtcSelectStatus"));
            bonoBTC.setSelected(checkBonusBTC);
            backGroundStatus = Boolean.valueOf(PROP.getProperty("backGroundSelectSatatus"));
            backgroundStatus.setSelected(backGroundStatus);
            workerStatus = Integer.parseInt(PROP.getProperty("activeWorkers"));
            activeWorkers.setSelectedItem(String.valueOf(workerStatus));
            sendProxy.setSelected(Boolean.valueOf(PROP.getProperty("sendProxy")));
            boolean advanced = Boolean.valueOf(PROP.getProperty("advancedMode"));
            modoAvanzado.setSelected(advanced);
            captchaKey1.setText(PROP.getProperty("TwoCaptchaKey"));
            tipoBono[0] = Integer.parseInt(PROP.getProperty("limiteBonoRP"));
            limiteRP.setSelectedIndex(tipoBono[0]);
            tipoBono[1] = Integer.parseInt(PROP.getProperty("limiteBonoBtC"));
            limiteBTC.setSelectedIndex(tipoBono[1]);
            this.setAlwaysOnTop(Boolean.valueOf(PROP.getProperty("alwaysTop")));
            AlwaysOnTop.setSelected(Boolean.valueOf(PROP.getProperty("alwaysTop")));
            monsterIP.setText(PROP.getProperty("capMonsterIP"));

            activePause.setSelected(Boolean.parseBoolean(PROP.getProperty("activarPausa")));
            if (PROP.getProperty("stopDuring").equals("10 Minutos")) {
                stopDuring = 10 * 60000;
            } else if (PROP.getProperty("stopDuring").equals("20 Minutos")) {
                stopDuring = 20 * 60000;
            } else if (PROP.getProperty("stopDuring").equals("30 Minutos")) {
                stopDuring = 30 * 60000;
            } else if (PROP.getProperty("stopDuring").equals("40 Minutos")) {
                stopDuring = 40 * 60000;
            } else if (PROP.getProperty("stopDuring").equals("50 Minutos")) {
                stopDuring = 50 * 60000;
            } else if (PROP.getProperty("stopDuring").equals("60 Minutos")) {
                stopDuring = 60 * 60000;
            }

            detenerDurante.setSelectedItem(PROP.getProperty("stopDuring"));

            tipoBono[2] = Integer.parseInt(PROP.getProperty("montoTicket"));
            ticketMonto.setValue(tipoBono[2]);

            if (PROP.getProperty("buyTicket").equals("1 Dia")) {
                buyTicket = LocalDateTime.now().plusHours(24);
            } else if (PROP.getProperty("buyTicket").equals("2 Dias")) {
                buyTicket = LocalDateTime.now().plusHours(48);
            } else if (PROP.getProperty("buyTicket").equals("3 Dias")) {
                buyTicket = LocalDateTime.now().plusHours(72);
            } else if (PROP.getProperty("buyTicket").equals("7 Dias")) {
                buyTicket = LocalDateTime.now().plusHours(168);
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(false, i, 15);
            }

            String horaPausa = PROP.getProperty("nextStop");
            nextPause.setSelectedItem(horaPausa);
            switch (horaPausa) {
                case "3 Horas":
                    nextStop = 3;
                    break;
                case "6 Horas":
                    nextStop = 6;
                    break;
                case "12 Horas":
                    nextStop = 12;
                    break;
                case "24 Horas":
                    nextStop = 24;
                    break;
                default:
                    break;
            }
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
            jLabel2.setText(String.valueOf(workerStatus));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveProperties() {
        PROP.setProperty("activeWorkers", activeWorkers.getSelectedItem().toString());
        PROP.setProperty("proxyUser", proxyUser.getText());
        PROP.setProperty("backGroundSelectSatatus", String.valueOf(backgroundStatus.isSelected()));
        PROP.setProperty("bonoBtcSelectStatus", String.valueOf(bonoBTC.isSelected()));
        PROP.setProperty("proxyPass", proxyPass.getText());
        PROP.setProperty("bonoRpelectStatus", String.valueOf(bonusRP.isSelected()));
        PROP.setProperty("TwoCaptchaKey", captchaKey1.getText());
        PROP.setProperty("capMonsterIP", monsterIP.getText());
        PROP.setProperty("alwaysTop", String.valueOf(AlwaysOnTop.isSelected()));
        PROP.setProperty("advancedMode", String.valueOf(modoAvanzado.isSelected()));
        PROP.setProperty("limiteBonoRP", String.valueOf(limiteRP.getSelectedIndex()));
        PROP.setProperty("limiteBonoBtC", String.valueOf(limiteBTC.getSelectedIndex()));
        PROP.setProperty("sendProxy", String.valueOf(sendProxy.isSelected()));
        PROP.setProperty("nextStop", nextPause.getSelectedItem().toString());
        PROP.setProperty("stopDuring", detenerDurante.getSelectedItem().toString());
        PROP.setProperty("montoTicket", String.valueOf(ticketMonto.getValue()));
        PROP.setProperty("buyTicket", ticketDia.getSelectedItem().toString());
        PROP.setProperty("activarPausa", String.valueOf(activePause.isSelected()));

        porcentajeRetirar = jTextField2.getText();
        montoResidual = residualTextFiel.getText();

        try {
            PROP.store(new FileWriter(PROP_PATH), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void runWorker1() {
        Timer timer1 = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (pause[0]) {

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
                            nextRollArray[w1] = LocalDateTime.now().plusMinutes(15);
                            worker = new Worker(w1, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[1]) {
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
                            nextRollArray[w2] = LocalDateTime.now().plusMinutes(15);
                            worker2 = new Worker2(w2, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[2]) {
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
                            nextRollArray[w3] = LocalDateTime.now().plusMinutes(15);
                            worker3 = new Worker3(w3, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[3]) {
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
                            nextRollArray[w4] = LocalDateTime.now().plusMinutes(15);
                            worker4 = new Worker4(w4, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[4]) {
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
                            nextRollArray[w5] = LocalDateTime.now().plusMinutes(15);
                            worker5 = new Worker5(w5, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[5]) {
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
                            nextRollArray[w6] = LocalDateTime.now().plusMinutes(15);
                            worker6 = new Worker6(w6, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[6]) {
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
                            nextRollArray[w7] = LocalDateTime.now().plusMinutes(15);
                            worker7 = new Worker7(w7, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[7]) {
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
                            nextRollArray[w8] = LocalDateTime.now().plusMinutes(15);
                            worker8 = new Worker8(w8, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[8]) {
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
                            nextRollArray[w9] = LocalDateTime.now().plusMinutes(15);
                            worker9 = new Worker9(w9, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
                            semaforoWorker9 = worker9.run();
                            if (nextRollArray[w9].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w9] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
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
                if (pause[9]) {
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
                            nextRollArray[w10] = LocalDateTime.now().plusMinutes(15);
                            worker10 = new Worker10(w10, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
                            semaforoWorker10 = worker10.run();
                            if (nextRollArray[w10].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w10] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
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
                if (pause[10]) {
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
                            nextRollArray[w11] = LocalDateTime.now().plusMinutes(15);
                            worker11 = new Worker11(w11, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
                            semaforoWorker11 = worker11.run();
                            if (nextRollArray[w11].isAfter(LocalDateTime.now().plusMinutes(5))) {
                                terminada[w11] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
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
                if (pause[11]) {
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
                            nextRollArray[silentSelector] = LocalDateTime.now().plusMinutes(15);
                            silent = new SilentWorker(silentSelector, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
                if (pause[12]) {
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
                            nextRollArray[silentSelector2] = LocalDateTime.now().plusMinutes(15);
                            silent2 = new SilentWorker2(silentSelector2, model, backGroundStatus, nextRollArray,
                                    balanceRoll, balanceTotal, proxies, procesando, tipoBono, ticketCount);
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
            model.setValueAt(" Esperando siguiente ronda", i, 14);

        }
    }

    private void tablaRetiros() {

        TableColumnModel col = jTable1.getColumnModel();
        col.getColumn(2).setHeaderValue("Wallet");
        col.getColumn(3).setHeaderValue("Balance");
        col.getColumn(5).setHeaderValue("<html>Cantidad<br>Retirada</html>");
        col.getColumn(8).setHeaderValue("<html>Balance<br>Disponible<html>");
        col.getColumn(9).setHeaderValue("Estado"); 

        jTable1.getColumn(0).setPreferredWidth(30);
        jTable1.getColumn(0).setWidth(30);
        jTable1.getColumn(0).setMaxWidth(30);
        jTable1.getColumn(1).setPreferredWidth(150);
        jTable1.getColumn(1).setWidth(150);
        jTable1.getColumn(1).setMaxWidth(300);
        jTable1.getColumn(2).setPreferredWidth(250);
        jTable1.getColumn(2).setWidth(250);
        jTable1.getColumn(2).setMaxWidth(350);
        //Columna de balance
        jTable1.getColumn(3).setPreferredWidth(80);
        jTable1.getColumn(3).setWidth(80);
        jTable1.getColumn(3).setMaxWidth(170);
        jTable1.getColumn(5).setPreferredWidth(80);
        jTable1.getColumn(5).setWidth(80);
        jTable1.getColumn(5).setMaxWidth(120);
        jTable1.getColumn(5).setMinWidth(80);
        jTable1.getColumn(8).setPreferredWidth(80);
        jTable1.getColumn(8).setWidth(80);
        jTable1.getColumn(8).setMaxWidth(170);

        //Estas lineas ocultan el resto de las columnas en la tabla
        jTable1.getColumn(4).setPreferredWidth(0);
        jTable1.getColumn(4).setMinWidth(0);
        jTable1.getColumn(4).setWidth(0);
        jTable1.getColumn(4).setMaxWidth(0);
        jTable1.getColumn(6).setPreferredWidth(0);
        jTable1.getColumn(6).setMinWidth(0);
        jTable1.getColumn(6).setWidth(0);
        jTable1.getColumn(6).setMaxWidth(0);
        jTable1.getColumn(7).setPreferredWidth(0);
        jTable1.getColumn(7).setMinWidth(0);
        jTable1.getColumn(7).setWidth(0);
        jTable1.getColumn(7).setMaxWidth(0);
        jTable1.getColumn(10).setPreferredWidth(0);
        jTable1.getColumn(10).setMinWidth(0);
        jTable1.getColumn(10).setWidth(0);
        jTable1.getColumn(10).setMaxWidth(0);
        jTable1.getColumn(11).setPreferredWidth(0);
        jTable1.getColumn(11).setMinWidth(0);
        jTable1.getColumn(11).setWidth(0);
        jTable1.getColumn(11).setMaxWidth(0);

        jTable1.getColumn(12).setPreferredWidth(0);
        jTable1.getColumn(12).setMinWidth(0);
        jTable1.getColumn(12).setWidth(0);
        jTable1.getColumn(12).setMaxWidth(0);

        jTable1.getColumn(13).setPreferredWidth(0);
        jTable1.getColumn(13).setMinWidth(0);
        jTable1.getColumn(13).setWidth(0);
        jTable1.getColumn(13).setMaxWidth(0);

        jTable1.getColumn(14).setPreferredWidth(0);
        jTable1.getColumn(14).setMinWidth(0);
        jTable1.getColumn(14).setWidth(0);
        jTable1.getColumn(14).setMaxWidth(0);
    }
    
    private void retiros(){
       
    }
}
