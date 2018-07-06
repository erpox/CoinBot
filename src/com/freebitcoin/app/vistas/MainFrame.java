// 
// Decompiled by Procyon v0.5.30
// 
package com.freebitcoin.app.vistas;

import javax.swing.SwingWorker;
import java.awt.Rectangle;
import com.freebitcoin.app.control.Balances;
import com.freebitcoin.app.control.SaveBalances;
import java.util.concurrent.ExecutionException;
import com.freebitcoin.app.miners.MineroRetiros;
import org.openqa.selenium.io.FileHandler;
import java.io.Reader;
import java.io.FileReader;
import com.freebitcoin.app.control.packed.ProfilesIni;
import java.time.format.DateTimeFormatter;
import java.time.chrono.ChronoLocalDateTime;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import com.freebitcoin.app.control.BtcPrice;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.Cursor;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.LayoutStyle;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.Window;
import javax.accessibility.Accessible;
import javax.swing.AbstractButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.Border;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import java.awt.Font;
import java.awt.LayoutManager;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Image;
import java.io.IOException;
import javax.swing.JTable;
import com.freebitcoin.app.control.ExcelAdapter;
import java.awt.Component;
import javax.swing.JSpinner;
import org.jdesktop.swingx.JXTable;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JPopupMenu;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JMenuItem;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import com.freebitcoin.app.control.packed.Table;
import java.io.File;
import java.util.Properties;
import java.time.LocalTime;
import java.time.LocalDateTime;
import com.freebitcoin.app.control.packed.Proxies;
import java.util.ArrayList;
import com.freebitcoin.app.miners.SilentWorker2;
import com.freebitcoin.app.miners.SilentWorker;
import com.freebitcoin.app.miners.Worker12;
import com.freebitcoin.app.miners.Worker11;
import com.freebitcoin.app.miners.Worker10;
import com.freebitcoin.app.miners.Worker9;
import com.freebitcoin.app.miners.Worker8;
import com.freebitcoin.app.miners.Worker7;
import com.freebitcoin.app.miners.Worker6;
import com.freebitcoin.app.miners.Worker5;
import com.freebitcoin.app.miners.Worker4;
import com.freebitcoin.app.miners.Worker3;
import com.freebitcoin.app.miners.Worker2;
import com.freebitcoin.app.miners.Worker;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private int w1;
    private int w2;
    private int w3;
    private int w4;
    private int w5;
    private int w6;
    private int w7;
    private int w8;
    private int w9;
    private int w10;
    private int w11;
    private int w12;
    private int pauseN;
    private int silentSelector;
    private int silentSelector2;
    private int dia;
    private int procesada;
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
    private volatile Worker12 worker12;
    private volatile SilentWorker silent;
    private volatile SilentWorker2 silent2;
    private final ArrayList<Integer> balanceRoll;
    private final ArrayList<Proxies> proxies;
    private ArrayList<String> perfiles;
    private ArrayList<String> paquete1;
    private ArrayList<String> paquete2;
    private int[] balanceTotal;
    private int[] ticketCount;
    private int[] terminada;
    private int[] pack1Balance;
    private int[] pack2Balance;
    private boolean[] workerFlag;
    private boolean[] pause;
    private final int[] tipoBono;
    private final int[] procesando;
    private LocalDateTime[] nextRollArray;
    private LocalTime reloj;
    private LocalDateTime horaPause;
    private LocalDateTime buyTicket;
    private LocalDateTime minHora;
    private final Properties PROP;
    private final String PROP_PATH = "C:\\Program Files\\GT Tools\\CoinBot FreeBitcoin\\config.properties";
    private File fichero;
    private File fichero2;
    private final String user;
    private final String pass;
    private boolean checkBonusRP;
    private boolean checkBonusBTC;
    private boolean backGroundStatus;
    private boolean openPopUp;
    private int workerStatus;
    private int terminadas;
    private int terminadaCheck;
    private int totalTicket;
    private String btcPriceStr;
    private boolean clean;
    private int nextStop;
    private int stopDuring;
    private String modoRetiro;
    private String tipoRetiro;
    private String balanceStr;
    private String sesionStr;
    private boolean botStatus;
    private boolean packAct1;
    private String proxyCant;
    private int profilesCount;
    private float sesionUSD;
    private float balanceUSD;
    private Table table;
    private int balance1;
    private int balance2;
    private JCheckBox AlwaysOnTop;
    private JButton BotonPause;
    public JLabel EstadoInfo;
    private JLabel LogoLabel;
    private JCheckBox activePause;
    private JComboBox<String> activeWorkers;
    private JCheckBox backgroundStatus;
    private JCheckBox bonoBTC;
    private JCheckBox bonusRP;
    private JButton botonBorrarPerfil;
    private JButton botonIniciar;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JTextField captchaKey1;
    private JDialog configPane;
    private JComboBox<String> detenerDurante;
    private JLabel esperaLabel;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JCheckBox jCheckBox1;
    private JDialog jDialog1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JOptionPane jOptionPane1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPopupMenu jPopupMenu1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JRadioButton jRadioButton5;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator10;
    private JSeparator jSeparator11;
    private JSeparator jSeparator12;
    private JSeparator jSeparator3;
    private JSeparator jSeparator6;
    private JSeparator jSeparator7;
    private JSeparator jSeparator8;
    private JSeparator jSeparator9;
    private JXTable jTable1;
    private JTextField jTextField2;
    private JLabel labelBalancetotal;
    private JLabel labelSesion1;
    private JComboBox<String> limiteBTC;
    private JComboBox<String> limiteRP;
    private JCheckBox modoAvanzado;
    private JTextField monsterIP;
    private JComboBox<String> nextPause;
    private JLabel procesandoLabel;
    private JTextField proxyPass;
    private JTextField proxyPuerto;
    private JTextField proxyPuerto1;
    private JTextField proxyUser;
    private JLabel relojLabel;
    private JCheckBox retiroAutoCheck;
    private JCheckBox sendProxy;
    private JLabel terminadasLabel;
    private JComboBox<String> ticketDia;
    private JSpinner ticketMonto;
    private JLabel totalPerfilesLabel;

    public MainFrame(final String user, final String pass) throws IOException {
        this.w1 = 0;
        this.w2 = 1;
        this.w3 = 2;
        this.w4 = 3;
        this.w5 = 4;
        this.w6 = 5;
        this.w7 = 6;
        this.w8 = 7;
        this.w9 = 8;
        this.w10 = 9;
        this.w11 = 10;
        this.w12 = 11;
        this.pauseN = 0;
        this.silentSelector = 0;
        this.silentSelector2 = 0;
        this.dia = 0;
        this.procesada = 0;
        this.balanceRoll = new ArrayList<>();
        this.proxies = new ArrayList<>();
        this.perfiles = new ArrayList<>();
        this.paquete1 = new ArrayList<>();
        this.paquete2 = new ArrayList<>();
        this.tipoBono = new int[3];
        this.procesando = new int[15];
        this.reloj = LocalTime.of(0, 0, 0);
        this.PROP = new Properties();
        this.fichero = new File("C:\\ProgramData\\pack1.dat");
        this.fichero2 = new File("C:\\ProgramData\\pack2.dat");
        this.openPopUp = false;
        this.terminadas = 0;
        this.terminadaCheck = 0;
        this.totalTicket = 0;
        this.clean = true;
        this.balanceStr = "Balance";
        this.sesionStr = "Sesi\u00f3n";
        this.botStatus = true;
        this.packAct1 = true;
        this.sesionUSD = 0.0f;
        this.balanceUSD = 0.0f;
        this.table = new Table();
        this.balance1 = 0;
        this.balance2 = 0;
        this.laf();
        this.initComponents();
        this.model = (DefaultTableModel) this.jTable1.getModel();
        this.loadPerfiles();
        this.properties();
        this.loadArrays();
        this.cargarBalances();
        this.activarPerfiles();
        this.jDialog1.setLocationRelativeTo(this);
        final ExcelAdapter myAd = new ExcelAdapter((JTable) this.jTable1);
        this.user = user;
        this.pass = pass;
        this.sheduleSaldos();
    }

    @Override
    public Image getIconImage() {
        final Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("vistas/iconoCoinBOT.png"));
        return retValue;
    }

    private void initComponents() {
        this.jPopupMenu1 = new JPopupMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.configPane = new JDialog();
        this.jPanel3 = new JPanel();
        this.jPanel5 = new JPanel();
        this.jLabel12 = new JLabel();
        this.monsterIP = new JTextField();
        this.jLabel14 = new JLabel();
        this.captchaKey1 = new JTextField();
        this.jLabel15 = new JLabel();
        this.proxyUser = new JTextField();
        this.proxyPass = new JTextField();
        this.sendProxy = new JCheckBox();
        this.jLabel16 = new JLabel();
        this.backgroundStatus = new JCheckBox();
        this.jLabel17 = new JLabel();
        this.AlwaysOnTop = new JCheckBox();
        this.jLabel18 = new JLabel();
        this.activeWorkers = new JComboBox<>();
        this.jLabel19 = new JLabel();
        this.bonusRP = new JCheckBox();
        this.bonoBTC = new JCheckBox();
        this.jLabel20 = new JLabel();
        this.activePause = new JCheckBox();
        this.jLabel21 = new JLabel();
        this.limiteRP = new JComboBox<>();
        this.jLabel22 = new JLabel();
        this.limiteBTC = new JComboBox<String>();
        this.nextPause = new JComboBox<String>();
        this.jLabel24 = new JLabel();
        this.jLabel27 = new JLabel();
        this.ticketMonto = new JSpinner();
        this.jLabel29 = new JLabel();
        this.ticketDia = new JComboBox<String>();
        this.jButton4 = new JButton();
        this.jSeparator3 = new JSeparator();
        this.jLabel1 = new JLabel();
        this.jSeparator6 = new JSeparator();
        this.jLabel28 = new JLabel();
        this.jSeparator7 = new JSeparator();
        this.jSeparator8 = new JSeparator();
        this.jSeparator9 = new JSeparator();
        this.jLabel30 = new JLabel();
        this.jSeparator10 = new JSeparator();
        this.modoAvanzado = new JCheckBox();
        this.detenerDurante = new JComboBox<String>();
        this.jLabel25 = new JLabel();
        this.jSeparator11 = new JSeparator();
        this.jLabel31 = new JLabel();
        this.jSeparator12 = new JSeparator();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        this.jRadioButton3 = new JRadioButton();
        this.jRadioButton4 = new JRadioButton();
        this.jRadioButton5 = new JRadioButton();
        this.jLabel23 = new JLabel();
        this.jLabel26 = new JLabel();
        this.retiroAutoCheck = new JCheckBox();
        this.jLabel32 = new JLabel();
        this.jLabel33 = new JLabel();
        this.jLabel34 = new JLabel();
        this.jLabel35 = new JLabel();
        this.jLabel36 = new JLabel();
        this.jLabel37 = new JLabel();
        this.jTextField2 = new JTextField();
        this.proxyPuerto = new JTextField();
        this.jLabel42 = new JLabel();
        this.proxyPuerto1 = new JTextField();
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jDialog1 = new JDialog();
        this.jPanel6 = new JPanel();
        this.jLabel13 = new JLabel();
        this.jLabel38 = new JLabel();
        this.jLabel39 = new JLabel();
        this.jLabel40 = new JLabel();
        this.jCheckBox1 = new JCheckBox();
        this.jLabel41 = new JLabel();
        this.jOptionPane1 = new JOptionPane();
        this.jPanel1 = new JPanel();
        this.LogoLabel = new JLabel();
        this.EstadoInfo = new JLabel();
        this.labelBalancetotal = new JLabel();
        this.labelSesion1 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jButton2 = new JButton();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.totalPerfilesLabel = new JLabel();
        this.jLabel5 = new JLabel();
        this.terminadasLabel = new JLabel();
        this.jLabel7 = new JLabel();
        this.procesandoLabel = new JLabel();
        this.jLabel9 = new JLabel();
        this.esperaLabel = new JLabel();
        this.jLabel11 = new JLabel();
        this.jButton1 = new JButton();
        this.relojLabel = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jButton3 = new JButton();
        this.jScrollPane3 = new JScrollPane();
        this.jTable1 = new MiRenderer();
        this.jPanel4 = new JPanel();
        this.BotonPause = new JButton();
        this.botonBorrarPerfil = new JButton();
        this.botonIniciar = new JButton();
        this.jMenuItem1.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Firefox_15px.png")));
        this.jMenuItem1.setText("FreeBitco.in");
        this.jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jPopupMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Whois_15px_1.png")));
        this.jMenuItem2.setText("Whoer.net");
        this.jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jPopupMenu1.add(this.jMenuItem2);
        this.configPane.setDefaultCloseOperation(2);
        this.configPane.setTitle("Configuraci\u00f3n");
        this.configPane.setBackground(new Color(52, 152, 219));
        this.configPane.setLocation(new Point(0, 0));
        this.configPane.setMinimumSize(new Dimension(350, 114));
        this.configPane.setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
        this.configPane.setName("Configurac\u00f3n");
        this.configPane.setPreferredSize(new Dimension(590, 620));
        this.configPane.setResizable(false);
        this.configPane.setSize(new Dimension(590, 620));
        this.configPane.getContentPane().setLayout((LayoutManager) new AbsoluteLayout());
        this.jPanel3.setBackground(new Color(52, 152, 219));
        this.jPanel3.setPreferredSize(new Dimension(560, 455));
        this.jPanel3.setLayout((LayoutManager) new AbsoluteLayout());
        this.jPanel5.setBackground(new Color(51, 51, 51));
        this.jPanel5.setPreferredSize(new Dimension(570, 610));
        this.jPanel5.setLayout((LayoutManager) new AbsoluteLayout());
        this.jLabel12.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel12.setForeground(new Color(255, 255, 255));
        this.jLabel12.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/capmonsterminipng.png")));
        this.jLabel12.setText("CapMonster IP:");
        this.jLabel12.setToolTipText("<html>IP del servidor donde esta corriendo CapMonster.<br> Si CapMonster esta en el mismo computador no modifiques este campo.</html>");
        this.jPanel5.add(this.jLabel12, new AbsoluteConstraints(19, 51, -1, -1));
        this.monsterIP.setBackground(new Color(51, 51, 51));
        this.monsterIP.setFont(new Font("Microsoft JhengHei", 0, 12));
        this.monsterIP.setForeground(new Color(220, 220, 220));
        this.monsterIP.setHorizontalAlignment(0);
        this.monsterIP.setText("127.0.0.3");
        this.monsterIP.setToolTipText("");
        this.monsterIP.setPreferredSize(new Dimension(120, 23));
        this.monsterIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.monsterIPActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.monsterIP, new AbsoluteConstraints(139, 50, -1, -1));
        this.jLabel14.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel14.setForeground(new Color(255, 255, 255));
        this.jLabel14.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Key_20px.png")));
        this.jLabel14.setText("CapMonster Key:");
        this.jLabel14.setToolTipText("Si activas la protecci\u00f3n en CapMonster, coloca tu clave aqui");
        this.jPanel5.add(this.jLabel14, new AbsoluteConstraints(294, 51, 130, -1));
        this.captchaKey1.setBackground(new Color(51, 51, 51));
        this.captchaKey1.setFont(new Font("Microsoft JhengHei", 0, 12));
        this.captchaKey1.setForeground(new Color(220, 220, 220));
        this.captchaKey1.setText("1234567890aAbBcC");
        this.captchaKey1.setToolTipText("");
        this.jPanel5.add(this.captchaKey1, new AbsoluteConstraints(428, 50, 130, -1));
        this.jLabel15.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel15.setForeground(new Color(255, 255, 255));
        this.jLabel15.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Firewall_20px.png")));
        this.jLabel15.setText("Proxy:");
        this.jLabel15.setToolTipText("Si tu servicio usa Autenticaci\u00f3n por IP no modifiques estos campos");
        this.jPanel5.add(this.jLabel15, new AbsoluteConstraints(19, 91, -1, -1));
        this.proxyUser.setBackground(new Color(51, 51, 51));
        this.proxyUser.setFont(new Font("Microsoft JhengHei", 0, 12));
        this.proxyUser.setForeground(new Color(220, 220, 220));
        this.proxyUser.setHorizontalAlignment(0);
        this.proxyUser.setText("Usuario");
        this.proxyUser.setToolTipText("<html>Usuario de tu servicio de proxy.<br> Asegurate de que no contenga espacios.</html>");
        this.jPanel5.add(this.proxyUser, new AbsoluteConstraints(89, 91, 90, -1));
        this.proxyPass.setBackground(new Color(51, 51, 51));
        this.proxyPass.setFont(new Font("Microsoft JhengHei", 0, 12));
        this.proxyPass.setForeground(new Color(220, 220, 220));
        this.proxyPass.setHorizontalAlignment(0);
        this.proxyPass.setText("Contrase\u00f1a");
        this.proxyPass.setToolTipText("<html>Contrase\u00f1a de tu servicio de proxy.<br> Asegurate de que no contenga espacios.</html>");
        this.jPanel5.add(this.proxyPass, new AbsoluteConstraints(190, 90, 90, -1));
        this.sendProxy.setBackground(new Color(51, 51, 51));
        this.sendProxy.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.sendProxy.setForeground(new Color(255, 255, 255));
        this.sendProxy.setText("Enviar Proxy a CapMonster");
        this.sendProxy.setToolTipText("<html>Enviar los proxy directamente a CapMonster.<br> Si desactivas esta opci\u00f3n asegurare de indicar tu lista de proxy a CapMonster</html>");
        this.jPanel5.add(this.sendProxy, new AbsoluteConstraints(370, 90, -1, -1));
        this.jLabel16.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Hide_20px.png")));
        this.jPanel5.add(this.jLabel16, new AbsoluteConstraints(225, 330, -1, -1));
        this.backgroundStatus.setBackground(new Color(51, 51, 51));
        this.backgroundStatus.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.backgroundStatus.setForeground(new Color(255, 255, 255));
        this.backgroundStatus.setText("Segundo Plano");
        this.backgroundStatus.setToolTipText("Oculta las ventanas de Firefox");
        this.jPanel5.add(this.backgroundStatus, new AbsoluteConstraints(245, 330, -1, 20));
        this.jLabel17.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_iMac_20px.png")));
        this.jPanel5.add(this.jLabel17, new AbsoluteConstraints(429, 330, -1, -1));
        this.AlwaysOnTop.setBackground(new Color(51, 51, 51));
        this.AlwaysOnTop.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.AlwaysOnTop.setForeground(new Color(255, 255, 255));
        this.AlwaysOnTop.setText("Fijar ventana");
        this.AlwaysOnTop.setToolTipText("Fija la ventana de CoinBOT sobre todas las demas.");
        this.AlwaysOnTop.setBorder(null);
        this.jPanel5.add(this.AlwaysOnTop, new AbsoluteConstraints(450, 330, -1, -1));
        this.jLabel18.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel18.setForeground(new Color(255, 255, 255));
        this.jLabel18.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Workers_20px.png")));
        this.jLabel18.setText("Mineros:");
        this.jLabel18.setToolTipText("Selecciona la cantidad de Mineros que usaras.");
        this.jPanel5.add(this.jLabel18, new AbsoluteConstraints(19, 330, 80, -1));
        this.activeWorkers.setFont(new Font("Microsoft JhengHei", 0, 12));
        this.activeWorkers.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4"}));
        this.activeWorkers.setToolTipText("");
        this.jPanel5.add(this.activeWorkers, new AbsoluteConstraints(122, 330, 40, 20));
        this.jLabel19.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Star_Filled_20px.png")));
        this.jPanel5.add(this.jLabel19, new AbsoluteConstraints(21, 172, -1, -1));
        this.bonusRP.setBackground(new Color(51, 51, 51));
        this.bonusRP.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.bonusRP.setForeground(new Color(255, 255, 255));
        this.bonusRP.setText("Reward Point");
        this.jPanel5.add(this.bonusRP, new AbsoluteConstraints(43, 172, -1, 20));
        this.bonoBTC.setBackground(new Color(51, 51, 51));
        this.bonoBTC.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.bonoBTC.setForeground(new Color(255, 255, 255));
        this.bonoBTC.setText("Bono BTC");
        this.jPanel5.add(this.bonoBTC, new AbsoluteConstraints(254, 172, 90, 20));
        this.jLabel20.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Loyalty_Card_20px.png")));
        this.jPanel5.add(this.jLabel20, new AbsoluteConstraints(234, 172, -1, -1));
        this.activePause.setBackground(new Color(51, 51, 51));
        this.activePause.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.activePause.setForeground(new Color(255, 255, 255));
        this.activePause.setText("Pausar automaticamente cada");
        this.activePause.setToolTipText("Pausa CoinBOT durante un tiempo determinado para sincronizar las horas");
        this.activePause.setActionCommand("Habilitar");
        this.activePause.setPreferredSize(new Dimension(119, 17));
        this.jPanel5.add(this.activePause, new AbsoluteConstraints(39, 369, 208, -1));
        this.jLabel21.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel21.setForeground(new Color(255, 255, 255));
        this.jLabel21.setText("Limite Reward Point: ");
        this.jLabel21.setToolTipText("<html>Establece un limite de bonos RP.<br> Se activaran todos los bonos por debajo de este limite, incluyendo el que indiques</html>");
        this.jPanel5.add(this.jLabel21, new AbsoluteConstraints(21, 211, -1, -1));
        this.limiteRP.setModel(new DefaultComboBoxModel<String>(new String[]{"100 RP", "50 RP", "25 RP", "10 RP", "1 RP"}));
        this.limiteRP.setSelectedIndex(2);
        this.limiteRP.setToolTipText("");
        this.jPanel5.add(this.limiteRP, new AbsoluteConstraints(149, 210, 60, -1));
        this.jLabel22.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel22.setForeground(new Color(255, 255, 255));
        this.jLabel22.setText("Limite Bono BTC: ");
        this.jLabel22.setToolTipText("<html>Establece un limite de bonos BTC.<br> Se activaran todos los bonos por debajo de este limite, incluyendo el que indiques</html>");
        this.jPanel5.add(this.jLabel22, new AbsoluteConstraints(227, 211, -1, -1));
        this.limiteBTC.setModel(new DefaultComboBoxModel<String>(new String[]{"1000%", "500%", "100%", "50%", "10%"}));
        this.limiteBTC.setSelectedIndex(2);
        this.jPanel5.add(this.limiteBTC, new AbsoluteConstraints(334, 210, -1, -1));
        this.nextPause.setModel(new DefaultComboBoxModel<String>(new String[]{"3 Horas", "6 Horas", "12 Horas", "24 Horas"}));
        this.jPanel5.add(this.nextPause, new AbsoluteConstraints(249, 368, -1, -1));
        this.jLabel24.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel24.setForeground(new Color(255, 255, 255));
        this.jLabel24.setText("Durante:");
        this.jPanel5.add(this.jLabel24, new AbsoluteConstraints(327, 369, -1, -1));
        this.jLabel27.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel27.setForeground(new Color(255, 255, 255));
        this.jLabel27.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Buy_20px.png")));
        this.jLabel27.setText("Automprar");
        this.jLabel27.setToolTipText("Si deseas compprar Tickets periodicamente indica la cantidad y el tiempo entre compras. De lo contrario dejalo en 0");
        this.jPanel5.add(this.jLabel27, new AbsoluteConstraints(21, 254, -1, -1));
        this.ticketMonto.setModel(new SpinnerNumberModel(0, null, null, 25));
        this.jPanel5.add(this.ticketMonto, new AbsoluteConstraints(149, 254, 60, -1));
        this.jLabel29.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel29.setForeground(new Color(255, 255, 255));
        this.jLabel29.setText("Tickets cada");
        this.jPanel5.add(this.jLabel29, new AbsoluteConstraints(227, 255, -1, -1));
        this.ticketDia.setModel(new DefaultComboBoxModel<String>(new String[]{"1 Dia", "2 Dias", "3 Dias", "7 Dias"}));
        this.jPanel5.add(this.ticketDia, new AbsoluteConstraints(334, 254, 60, -1));
        this.jButton4.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px.png")));
        this.jButton4.setBorder(null);
        this.jButton4.setBorderPainted(false);
        this.jButton4.setContentAreaFilled(false);
        this.jButton4.setFocusable(false);
        this.jButton4.setPressedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png")));
        this.jButton4.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png")));
        this.jButton4.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Checked_25px_1.png")));
        this.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jButton4, new AbsoluteConstraints(540, 550, -1, -1));
        this.jPanel5.add(this.jSeparator3, new AbsoluteConstraints(10, 22, 210, 10));
        this.jLabel1.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setText("Servicio Captcha");
        this.jPanel5.add(this.jLabel1, new AbsoluteConstraints(230, 12, -1, -1));
        this.jPanel5.add(this.jSeparator6, new AbsoluteConstraints(353, 144, 210, 10));
        this.jLabel28.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.jLabel28.setForeground(new Color(255, 255, 255));
        this.jLabel28.setText(" Bonos y Tickets");
        this.jPanel5.add(this.jLabel28, new AbsoluteConstraints(230, 134, 114, -1));
        this.jPanel5.add(this.jSeparator7, new AbsoluteConstraints(10, 144, 210, 10));
        this.jPanel5.add(this.jSeparator8, new AbsoluteConstraints(353, 21, 210, 11));
        this.jPanel5.add(this.jSeparator9, new AbsoluteConstraints(10, 302, 176, 10));
        this.jLabel30.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.jLabel30.setForeground(new Color(255, 255, 255));
        this.jLabel30.setText(" Configuraciones Generales");
        this.jPanel5.add(this.jLabel30, new AbsoluteConstraints(190, 292, -1, -1));
        this.jPanel5.add(this.jSeparator10, new AbsoluteConstraints(389, 302, 176, 10));
        this.modoAvanzado.setBackground(new Color(51, 51, 51));
        this.modoAvanzado.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.modoAvanzado.setForeground(new Color(255, 255, 255));
        this.modoAvanzado.setText("Tabla Avanzada");
        this.modoAvanzado.setToolTipText("Muestra 3 Columnas extras en la tabla.");
        this.modoAvanzado.setPreferredSize(new Dimension(119, 17));
        this.jPanel5.add(this.modoAvanzado, new AbsoluteConstraints(418, 174, 130, -1));
        this.detenerDurante.setModel(new DefaultComboBoxModel<String>(new String[]{"10 Minutos", "20 Minutos", "30 Minutos", "40 Minutos", "50 Minutos", "60 Minutos"}));
        this.jPanel5.add(this.detenerDurante, new AbsoluteConstraints(383, 368, -1, -1));
        this.jLabel25.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Private_20px.png")));
        this.jPanel5.add(this.jLabel25, new AbsoluteConstraints(19, 368, -1, -1));
        this.jPanel5.add(this.jSeparator11, new AbsoluteConstraints(10, 420, 205, 10));
        this.jLabel31.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.jLabel31.setForeground(new Color(255, 255, 255));
        this.jLabel31.setText("Retiro Autom\u00e1tico");
        this.jPanel5.add(this.jLabel31, new AbsoluteConstraints(230, 410, -1, -1));
        this.jPanel5.add(this.jSeparator12, new AbsoluteConstraints(360, 420, 206, 10));
        this.jRadioButton1.setBackground(new Color(51, 51, 51));
        this.buttonGroup1.add(this.jRadioButton1);
        this.jRadioButton1.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jRadioButton1.setForeground(new Color(255, 255, 255));
        this.jRadioButton1.setText("Lento");
        this.jRadioButton1.setToolTipText(" Duraci\u00f3n: 6-24 Horas");
        this.jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jRadioButton1ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jRadioButton1, new AbsoluteConstraints(210, 480, -1, -1));
        this.jRadioButton2.setBackground(new Color(51, 51, 51));
        this.buttonGroup1.add(this.jRadioButton2);
        this.jRadioButton2.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jRadioButton2.setForeground(new Color(255, 255, 255));
        this.jRadioButton2.setText("Instantaneo");
        this.jRadioButton2.setToolTipText("Duraci\u00f3n: ~15 Minutos");
        this.jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jRadioButton2ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jRadioButton2, new AbsoluteConstraints(210, 510, -1, -1));
        this.jRadioButton3.setBackground(new Color(51, 51, 51));
        this.buttonGroup2.add(this.jRadioButton3);
        this.jRadioButton3.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jRadioButton3.setForeground(new Color(255, 255, 255));
        this.jRadioButton3.setText("Todo");
        this.jRadioButton3.setToolTipText("Retira Todo el balance de tus cuentas");
        this.jRadioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jRadioButton3ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jRadioButton3, new AbsoluteConstraints(360, 480, 77, -1));
        this.jRadioButton4.setBackground(new Color(51, 51, 51));
        this.buttonGroup2.add(this.jRadioButton4);
        this.jRadioButton4.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jRadioButton4.setForeground(new Color(255, 255, 255));
        this.jRadioButton4.setText("Porcentual");
        this.jRadioButton4.setToolTipText("Establece el porcentaje del Saldo que deseas retirar de tu cuenta");
        this.jRadioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jRadioButton4ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jRadioButton4, new AbsoluteConstraints(360, 510, -1, -1));
        this.jRadioButton5.setBackground(new Color(51, 51, 51));
        this.buttonGroup2.add(this.jRadioButton5);
        this.jRadioButton5.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jRadioButton5.setForeground(new Color(255, 255, 255));
        this.jRadioButton5.setText("Residual");
        this.jRadioButton5.setToolTipText("Establece la cantidad que deseas mantener en tu cuenta. El resto ser\u00e1 retirado a la cartera que indiques");
        this.jRadioButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jRadioButton5ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jRadioButton5, new AbsoluteConstraints(360, 540, 77, -1));
        this.jLabel23.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel23.setForeground(new Color(255, 255, 255));
        this.jLabel23.setText("Tipo de Retiro");
        this.jPanel5.add(this.jLabel23, new AbsoluteConstraints(210, 450, -1, 20));
        this.jLabel26.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel26.setForeground(new Color(255, 255, 255));
        this.jLabel26.setText("Cantidad ");
        this.jPanel5.add(this.jLabel26, new AbsoluteConstraints(380, 450, -1, -1));
        this.retiroAutoCheck.setBackground(new Color(51, 51, 51));
        this.retiroAutoCheck.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.retiroAutoCheck.setForeground(new Color(255, 255, 255));
        this.retiroAutoCheck.setText("Habilitar Retiro");
        this.retiroAutoCheck.setToolTipText("");
        this.jPanel5.add(this.retiroAutoCheck, new AbsoluteConstraints(40, 450, -1, -1));
        this.jLabel32.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Initiate_Money_Transfer_20px.png")));
        this.jPanel5.add(this.jLabel32, new AbsoluteConstraints(20, 450, -1, -1));
        this.jLabel33.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Turtle_20px.png")));
        this.jPanel5.add(this.jLabel33, new AbsoluteConstraints(190, 480, -1, -1));
        this.jLabel34.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Quick_Mode_On_20px.png")));
        this.jPanel5.add(this.jLabel34, new AbsoluteConstraints(190, 510, -1, -1));
        this.jLabel35.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Full_Battery_20px.png")));
        this.jPanel5.add(this.jLabel35, new AbsoluteConstraints(340, 480, -1, -1));
        this.jLabel36.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Charged_Battery_20px.png")));
        this.jPanel5.add(this.jLabel36, new AbsoluteConstraints(340, 510, -1, -1));
        this.jLabel37.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Low_Battery_20px.png")));
        this.jPanel5.add(this.jLabel37, new AbsoluteConstraints(340, 540, -1, -1));
        this.jTextField2.setBackground(new Color(51, 51, 51));
        this.jTextField2.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jTextField2.setForeground(new Color(255, 255, 255));
        this.jTextField2.setText("ej. 95%");
        this.jPanel5.add(this.jTextField2, new AbsoluteConstraints(470, 480, 70, -1));
        this.proxyPuerto.setBackground(new Color(51, 51, 51));
        this.proxyPuerto.setFont(new Font("Microsoft JhengHei", 0, 12));
        this.proxyPuerto.setForeground(new Color(220, 220, 220));
        this.proxyPuerto.setHorizontalAlignment(0);
        this.proxyPuerto.setText("Puerto");
        this.proxyPuerto.setToolTipText("<html>Contrase\u00f1a de tu servicio de proxy.<br> Asegurate de que no contenga espacios.</html>");
        this.jPanel5.add(this.proxyPuerto, new AbsoluteConstraints(290, 90, 60, -1));
        this.jLabel42.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel42.setForeground(new Color(255, 255, 255));
        this.jLabel42.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Numeric_20px.png")));
        this.jLabel42.setText("Perfiles activos");
        this.jPanel5.add(this.jLabel42, new AbsoluteConstraints(400, 210, -1, -1));
        this.proxyPuerto1.setBackground(new Color(51, 51, 51));
        this.proxyPuerto1.setFont(new Font("Microsoft JhengHei", 0, 12));
        this.proxyPuerto1.setForeground(new Color(220, 220, 220));
        this.proxyPuerto1.setHorizontalAlignment(0);
        this.proxyPuerto1.setText("130");
        this.proxyPuerto1.setToolTipText("<html>Contrase\u00f1a de tu servicio de proxy.<br> Asegurate de que no contenga espacios.</html>");
        this.jPanel5.add(this.proxyPuerto1, new AbsoluteConstraints(520, 210, 40, -1));
        this.jPanel3.add(this.jPanel5, new AbsoluteConstraints(5, 5, 573, 580));
        this.configPane.getContentPane().add(this.jPanel3, new AbsoluteConstraints(0, 0, 585, 590));
        this.configPane.getAccessibleContext().setAccessibleParent(this);
        this.jDialog1.setDefaultCloseOperation(2);
        this.jDialog1.setAlwaysOnTop(true);
        this.jDialog1.setMinimumSize(new Dimension(330, 79));
        this.jDialog1.setUndecorated(true);
        this.jDialog1.setPreferredSize(new Dimension(330, 79));
        this.jDialog1.setSize(new Dimension(330, 79));
        this.jDialog1.setType(Type.POPUP);
        this.jPanel6.setBackground(new Color(0, 120, 215));
        this.jPanel6.setMinimumSize(new Dimension(348, 78));
        this.jLabel13.setFont(new Font("Microsoft JhengHei", 1, 16));
        this.jLabel13.setForeground(new Color(255, 255, 255));
        this.jLabel13.setText("CoinBOT se ha pausado. ");
        this.jLabel38.setFont(new Font("Microsoft JhengHei", 1, 16));
        this.jLabel38.setForeground(new Color(255, 255, 255));
        this.jLabel38.setText("Se renaudara a las");
        this.jLabel39.setFont(new Font("Microsoft JhengHei", 1, 16));
        this.jLabel39.setForeground(new Color(255, 255, 255));
        this.jLabel39.setText("08:30PM");
        this.jLabel40.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Notification_54px_1.png")));
        final GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel40).addGap(18, 18, 18).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel13).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel38).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel39)))));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel40).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel38).addComponent(this.jLabel39)))).addGap(14, 14, 14)));
        final GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
        this.jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -2, 330, 32767));
        jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -2, -1, -2));
        this.jDialog1.getAccessibleContext().setAccessibleParent(this);
        this.jCheckBox1.setBackground(new Color(51, 51, 51));
        this.jCheckBox1.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jCheckBox1.setForeground(new Color(255, 255, 255));
        this.jCheckBox1.setText("Cambiar Perfiles diariamente");
        this.jLabel41.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Switch_20px.png")));
        this.setDefaultCloseOperation(0);
        this.setTitle("CoinBot Mini v2.2.13");
        this.setIconImage(this.getIconImage());
        this.setMinimumSize(new Dimension(975, 300));
        this.setPreferredSize(new Dimension(975, 705));
        this.setSize(new Dimension(0, 0));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent evt) {
                MainFrame.this.formWindowClosing(evt);
            }
        });
        this.jPanel1.setBackground(new Color(52, 152, 219));
        this.jPanel1.setForeground(new Color(255, 255, 255));
        this.jPanel1.setEnabled(false);
        this.LogoLabel.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/LogoCoinBOT (1).png")));
        this.EstadoInfo.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.EstadoInfo.setForeground(new Color(255, 255, 255));
        this.labelBalancetotal.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.labelBalancetotal.setForeground(new Color(255, 255, 255));
        this.labelBalancetotal.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Coins_20px_1.png")));
        this.labelBalancetotal.setText("Balance: 0 Sat ~ $ 0");
        this.labelSesion1.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.labelSesion1.setForeground(new Color(255, 255, 255));
        this.labelSesion1.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Payment_History_20px_2.png")));
        this.labelSesion1.setText("Sesi\u00f3n: 0 Sat ~$ 0");
        this.jPanel2.setBackground(new Color(51, 51, 51));
        this.jPanel2.setLayout((LayoutManager) new AbsoluteLayout());
        this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Refresh_25px.png")));
        this.jButton2.setToolTipText("Cambia el paquete de cuentas activo.");
        this.jButton2.setBorder(null);
        this.jButton2.setBorderPainted(false);
        this.jButton2.setContentAreaFilled(false);
        this.jButton2.setCursor(new Cursor(3));
        this.jButton2.setFocusPainted(false);
        this.jButton2.setFocusable(false);
        this.jButton2.setPressedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Refresh_25px_1.png")));
        this.jButton2.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Refresh_25px_1.png")));
        this.jButton2.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Refresh_25px_1.png")));
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton2, new AbsoluteConstraints(889, 3, -1, -1));
        this.jLabel2.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel2.setForeground(new Color(255, 255, 255));
        this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Workers_20px.png")));
        this.jLabel2.setText("1");
        this.jPanel2.add(this.jLabel2, new AbsoluteConstraints(10, 7, -1, -1));
        this.jLabel3.setFont(new Font("Tahoma", 1, 20));
        this.jLabel3.setForeground(new Color(255, 255, 255));
        this.jLabel3.setText("|");
        this.jPanel2.add(this.jLabel3, new AbsoluteConstraints(410, 3, -1, -1));
        this.totalPerfilesLabel.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.totalPerfilesLabel.setForeground(new Color(255, 255, 255));
        this.totalPerfilesLabel.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Firefox_20px.png")));
        this.totalPerfilesLabel.setText("Total: 0");
        this.jPanel2.add(this.totalPerfilesLabel, new AbsoluteConstraints(64, 7, -1, -1));
        this.jLabel5.setFont(new Font("Tahoma", 1, 20));
        this.jLabel5.setForeground(new Color(255, 255, 255));
        this.jLabel5.setText("|");
        this.jPanel2.add(this.jLabel5, new AbsoluteConstraints(50, 3, -1, -1));
        this.terminadasLabel.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.terminadasLabel.setForeground(new Color(255, 255, 255));
        this.terminadasLabel.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Checkmark_20px.png")));
        this.terminadasLabel.setText("Terminadas: 0");
        this.jPanel2.add(this.terminadasLabel, new AbsoluteConstraints(287, 7, 120, -1));
        this.jLabel7.setFont(new Font("Tahoma", 1, 20));
        this.jLabel7.setForeground(new Color(255, 255, 255));
        this.jLabel7.setText("|");
        this.jPanel2.add(this.jLabel7, new AbsoluteConstraints(841, 3, -1, -1));
        this.procesandoLabel.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.procesandoLabel.setForeground(new Color(255, 255, 255));
        this.procesandoLabel.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Spinner_20px.png")));
        this.procesandoLabel.setText("Procesando: 0");
        this.jPanel2.add(this.procesandoLabel, new AbsoluteConstraints(160, 7, 120, -1));
        this.jLabel9.setFont(new Font("Tahoma", 1, 20));
        this.jLabel9.setForeground(new Color(255, 255, 255));
        this.jLabel9.setText("|");
        this.jPanel2.add(this.jLabel9, new AbsoluteConstraints(272, 3, -1, -1));
        this.esperaLabel.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.esperaLabel.setForeground(new Color(255, 255, 255));
        this.esperaLabel.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Cafe_20px.png")));
        this.esperaLabel.setText("En Espera: 0");
        this.jPanel2.add(this.esperaLabel, new AbsoluteConstraints(425, 7, 110, -1));
        this.jLabel11.setFont(new Font("Tahoma", 1, 20));
        this.jLabel11.setForeground(new Color(255, 255, 255));
        this.jLabel11.setText("|");
        this.jPanel2.add(this.jLabel11, new AbsoluteConstraints(150, 3, -1, -1));
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Settings_25px.png")));
        this.jButton1.setBorder(null);
        this.jButton1.setBorderPainted(false);
        this.jButton1.setContentAreaFilled(false);
        this.jButton1.setFocusable(false);
        this.jButton1.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Settings_25px_1_1.png")));
        this.jButton1.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Settings_25px_1_1.png")));
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton1, new AbsoluteConstraints(920, 3, 30, -1));
        this.relojLabel.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.relojLabel.setForeground(new Color(255, 255, 255));
        this.relojLabel.setHorizontalAlignment(0);
        this.relojLabel.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Watch_20px.png")));
        this.relojLabel.setText("0 dias");
        this.jPanel2.add(this.relojLabel, new AbsoluteConstraints(694, 7, 70, -1));
        this.jLabel8.setFont(new Font("Tahoma", 1, 20));
        this.jLabel8.setForeground(new Color(255, 255, 255));
        this.jLabel8.setText("|");
        this.jPanel2.add(this.jLabel8, new AbsoluteConstraints(680, 3, -1, -1));
        this.jLabel10.setFont(new Font("Tahoma", 1, 20));
        this.jLabel10.setForeground(new Color(255, 255, 255));
        this.jLabel10.setText("|");
        this.jPanel2.add(this.jLabel10, new AbsoluteConstraints(536, 3, -1, -1));
        this.jLabel4.setFont(new Font("Microsoft JhengHei", 1, 14));
        this.jLabel4.setForeground(new Color(255, 255, 255));
        this.jLabel4.setText("00:00:00");
        this.jPanel2.add(this.jLabel4, new AbsoluteConstraints(770, 7, 65, -1));
        this.jLabel6.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jLabel6.setForeground(new Color(255, 255, 255));
        this.jLabel6.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Bitcoin_20px.png")));
        this.jLabel6.setText("1 BTC ~ 0 $");
        this.jPanel2.add(this.jLabel6, new AbsoluteConstraints(550, 7, 130, -1));
        this.jButton3.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Up_Down_Arrow__25px_2.png")));
        this.jButton3.setToolTipText("<html>Ordena los perfiles de menor a mayor,<br>tomando la hora del siguiente reclamo como referencia.</html> ");
        this.jButton3.setBorder(null);
        this.jButton3.setContentAreaFilled(false);
        this.jButton3.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Up_Down_Arrow__25px_3.png")));
        this.jButton3.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Up_Down_Arrow__25px_3.png")));
        this.jButton3.setSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Up_Down_Arrow__25px_3.png")));
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton3, new AbsoluteConstraints(858, 3, -1, -1));
        this.jTable1.setBackground(new Color(51, 51, 51));
        this.jTable1.setForeground(new Color(255, 255, 255));
        this.jTable1.setModel((TableModel) new DefaultTableModel(new Object[0][], new String[]{"#", "Perfil", "Balance", "Puntos", "%", "<html><center>Roll<br>BTC</center></html>", "<html><center>Roll<br>Puntos</center></html>", "<html><center>RP<br>Activ.</center></html>", "<html><center>Bono<br>RP</center></html>", "<html><center>Bono RP<br>FIN</center></html>", "<html><center>BTC<br>Activ.</center></html>", "<html><center>Bono<br>BTC</center></html>", "<html><center>Bono BTC<br>FIN</center></html>", "<html><center>Prox.<br>Roll</center></html>", "Estado", "Tickets"}) {
            Class[] types = {Object.class, Object.class, Object.class, Object.class, Object.class, Integer.class, Integer.class, Boolean.class, Object.class, Object.class, Boolean.class, Object.class, Object.class, Object.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false};

            @Override
            public Class getColumnClass(final int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public boolean isCellEditable(final int rowIndex, final int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        final JTableHeader header = this.jTable1.getTableHeader();
        this.jTable1.getTableHeader().setReorderingAllowed(false);
        this.jTable1.getTableHeader().setResizingAllowed(true);
        final TableCellRenderer rendererFromHeader = this.jTable1.getTableHeader().getDefaultRenderer();
        final JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(0);
        final DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(0);
        this.jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(11).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(12).setCellRenderer(centerRenderer);
        this.jTable1.getColumnModel().getColumn(13).setCellRenderer(centerRenderer);
        this.jTable1.setComponentPopupMenu(this.jPopupMenu1);
        this.jTable1.setFont(new Font("Microsoft JhengHei", 1, 12));
        this.jTable1.setRowHeight(22);
        this.jTable1.setSelectionBackground(new Color(255, 153, 51));
        this.jTable1.setSelectionForeground(new Color(0, 0, 0));
        this.jTable1.setSortable(false);
        this.jScrollPane3.setViewportView((Component) this.jTable1);
        this.jPanel4.setBackground(new Color(52, 152, 219));
        this.jPanel4.setLayout((LayoutManager) new AbsoluteLayout());
        this.BotonPause.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30-1px.png")));
        this.BotonPause.setBorder(null);
        this.BotonPause.setBorderPainted(false);
        this.BotonPause.setContentAreaFilled(false);
        this.BotonPause.setFocusable(false);
        this.BotonPause.setHorizontalTextPosition(0);
        this.BotonPause.setPressedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png")));
        this.BotonPause.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png")));
        this.BotonPause.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png")));
        this.BotonPause.setSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Pause_Button_30px_2.png")));
        this.BotonPause.setVerticalTextPosition(3);
        this.BotonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.BotonPauseActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.BotonPause, new AbsoluteConstraints(80, 11, 30, 30));
        this.botonBorrarPerfil.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px-1.png")));
        this.botonBorrarPerfil.setBorder(null);
        this.botonBorrarPerfil.setBorderPainted(false);
        this.botonBorrarPerfil.setContentAreaFilled(false);
        this.botonBorrarPerfil.setFocusable(false);
        this.botonBorrarPerfil.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png")));
        this.botonBorrarPerfil.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png")));
        this.botonBorrarPerfil.setSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Denied_30px_3.png")));
        this.botonBorrarPerfil.setVerifyInputWhenFocusTarget(false);
        this.botonBorrarPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.botonBorrarPerfilActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.botonBorrarPerfil, new AbsoluteConstraints(10, 11, -1, -1));
        this.botonIniciar.setIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30Blancopx.png")));
        this.botonIniciar.setBorder(null);
        this.botonIniciar.setBorderPainted(false);
        this.botonIniciar.setContentAreaFilled(false);
        this.botonIniciar.setFocusPainted(false);
        this.botonIniciar.setFocusable(false);
        this.botonIniciar.setRolloverIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png")));
        this.botonIniciar.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png")));
        this.botonIniciar.setSelectedIcon(new ImageIcon(this.getClass().getResource("/com/freebitcoin/app/images/icons8_Circled_Play_30px_2.png")));
        this.botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                MainFrame.this.botonIniciarActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.botonIniciar, new AbsoluteConstraints(45, 11, -1, -1));
        final GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.EstadoInfo).addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.labelBalancetotal).addComponent(this.labelSesion1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.LogoLabel, -2, 296, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel4, -2, -1, -2).addContainerGap()).addComponent(this.jScrollPane3));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.EstadoInfo).addGroup(jPanel1Layout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.labelSesion1).addGap(0, 0, 0).addComponent(this.labelBalancetotal))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, 44, -2))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.LogoLabel))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 535, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 33, -2).addGap(5, 5, 5)));
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        this.getAccessibleContext().setAccessibleName("CoinBot v1.2");
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void jMenuItem1ActionPerformed(final ActionEvent evt) {
        try {
            final int select = this.jTable1.getSelectedRow();
            final String perfil = (String) this.model.getValueAt(select, 1);
            Runtime.getRuntime().exec("cmd.exe /c start firefox.exe -p " + perfil + " https://freebitco.in");
            this.openPopUp = true;
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton1ActionPerformed(final ActionEvent evt) {
        this.configPane.setLocationRelativeTo(this);
        this.configPane.setVisible(true);
    }

    private void BotonPauseActionPerformed(final ActionEvent evt) {
        if (this.pauseN == 0) {
            for (int i = 0; i < this.pause.length; ++i) {
                this.pause[i] = false;
            }
            this.pauseN = 1;
            this.BotonPause.setSelected(true);
        } else {
            for (int i = 0; i < this.pause.length; ++i) {
                this.pause[i] = true;
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.pauseN = 0;
            this.BotonPause.setSelected(false);
        }
    }

    private void botonIniciarActionPerformed(final ActionEvent evt) {
        if (this.retiroAutoCheck.isSelected()) {
            this.retiros();
        } else {
            switch (this.workerStatus) {
                case 1: {
                    this.runWorker1();
                    break;
                }
                case 2: {
                    this.runWorker1();
                    this.runWorker2();
                    break;
                }
                case 3: {
                    this.runWorker1();
                    this.runWorker2();
                    this.runWorker3();
                    break;
                }
                case 4: {
                    this.runWorker1();
                    this.runWorker2();
                    this.runWorker3();
                    this.runWorker4();
                    this.hiddenWorker();
                    break;
                }
//                case 5: {
//                    this.runWorker1();
//                    this.runWorker2();
//                    this.runWorker3();
//                    this.runWorker4();
//                    this.runWorker5();
//                    this.hiddenWorker();
//                }
//                case 6: {
//                    this.runWorker1();
//                    this.runWorker2();
//                    this.runWorker3();
//                    this.runWorker4();
//                    this.runWorker5();
//                    this.runWorker6();
//                    this.hiddenWorker();
//                }
//                case 7: {
//                    this.runWorker1();
//                    this.runWorker2();
//                    this.runWorker3();
//                    this.runWorker4();
//                    this.runWorker5();
//                    this.runWorker6();
//                    this.runWorker7();
//                    this.hiddenWorker();
//                }
//                case 8: {
//                    this.runWorker1();
//                    this.runWorker2();
//                    this.runWorker3();
//                    this.runWorker4();
//                    this.runWorker5();
//                    this.runWorker6();
//                    this.runWorker7();
//                    this.runWorker8();
//                    this.hiddenWorker();
//                    this.hiddenWorker2();
//                }
//                case 9: {
//                    this.runWorker1();
//                    this.runWorker2();
//                    this.runWorker3();
//                    this.runWorker4();
//                    this.runWorker5();
//                    this.runWorker6();
//                    this.runWorker7();
//                    this.runWorker8();
//                    this.runWorker9();
//                    this.hiddenWorker();
//                    this.hiddenWorker2();
//                }
//                case 10: {
//                    this.runWorker1();
//                    this.runWorker2();
//                    this.runWorker3();
//                    this.runWorker4();
//                    this.runWorker5();
//                    this.runWorker6();
//                    this.runWorker7();
//                    this.runWorker8();
//                    this.runWorker9();
//                    this.runWorker10();
//                    this.hiddenWorker();
//                    this.hiddenWorker2();
//                }
//                case 11: {
//                    this.runWorker1();
//                    this.runWorker2();
//                    this.runWorker3();
//                    this.runWorker4();
//                    this.runWorker5();
//                    this.runWorker6();
//                    this.runWorker7();
//                    this.runWorker8();
//                    this.runWorker9();
//                    this.runWorker10();
//                    this.runWorker11();
//                    this.hiddenWorker();
//                    this.hiddenWorker2();
//                }
            }
        }
        this.horaPause = LocalDateTime.now().plusHours(this.nextStop);
        this.Sesionreloj();
        this.statusBar();
        this.botonBorrarPerfil.setEnabled(false);
        this.botonIniciar.setEnabled(false);
        this.retiroAutoCheck.setEnabled(false);
    }

    private void botonBorrarPerfilActionPerformed(final ActionEvent evt) {
        for (int n = this.jTable1.getSelectedRow(); n != -1; n = this.jTable1.getSelectedRow()) {
            this.model.removeRow(n);
            this.proxies.remove(n);
        }
        int newNum = 1;
        for (int i = 0; i < this.model.getRowCount(); ++i) {
            this.model.setValueAt(newNum, i, 0);
            ++newNum;
        }
        this.totalPerfilesLabel.setText("Total: " + this.model.getRowCount());
        this.nextRollArray[this.model.getRowCount()] = LocalDateTime.of(2020, Month.MARCH, 5, 6, 5);
    }

    private void formWindowClosing(final WindowEvent evt) {
        final int n = JOptionPane.showOptionDialog(this.rootPane, "�Esta seguro que desea cerrar el programa?", "Cerrar sesi\u00f3n", 2, 3, null, new Object[]{"Minimizar", "Cerrar"}, "minimizar");
        if (n == 0) {
            this.setState(1);
        } else {
            try {
                this.guardarBalances();
                Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
                Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
                final FileWriter fstream = new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts", false);
                try (final BufferedWriter out = new BufferedWriter(fstream)) {
                    out.write("");
                    out.newLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }

    private void jButton4ActionPerformed(final ActionEvent evt) {
        this.configPane.dispose();
        this.saveProperties();
        this.properties();
    }

    private void jRadioButton1ActionPerformed(final ActionEvent evt) {
        this.tipoRetiro = "Slow";
    }

    private void jRadioButton5ActionPerformed(final ActionEvent evt) {
        this.modoRetiro = "Residual";
        this.jTextField2.setVisible(true);
        this.jTextField2.setText("ej. 3000");
    }

    private void jRadioButton4ActionPerformed(final ActionEvent evt) {
        this.modoRetiro = "porcentual";
        this.jTextField2.setVisible(true);
        this.jTextField2.setText("ej. 95%");
    }

    private void jRadioButton3ActionPerformed(final ActionEvent evt) {
        this.modoRetiro = "Todo";
        this.jTextField2.setVisible(false);
        this.jTextField2.setText("0");
    }

    private void jRadioButton2ActionPerformed(final ActionEvent evt) {
        this.tipoRetiro = "Instant";
    }

    private void monsterIPActionPerformed(final ActionEvent evt) {
        System.out.println("LOL");
    }

    private void jButton2ActionPerformed(final ActionEvent evt) {
        this.activarPerfiles();
    }

    private void jMenuItem2ActionPerformed(final ActionEvent evt) {
        try {
            final int select = this.jTable1.getSelectedRow();
            final String perfil = (String) this.model.getValueAt(select, 1);
            Runtime.getRuntime().exec("cmd.exe /c start firefox.exe -p " + perfil + " https://Whoer.net");
            this.openPopUp = true;
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton3ActionPerformed(final ActionEvent evt) {
        int proceso = 0;
        for (int i = 0; i < this.procesando.length; ++i) {
            proceso += this.procesando[i];
        }
        if (proceso == 0) {
             this.reOrder();
        } else {
            JOptionPane.showMessageDialog(this.rootPane, "Funci\u00f3n no permitida mientras se procesan perfiles.", "Error ordenamiento", 0);
        }
    }

    public static void main(final String[] args) {
        try {
            for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> {
            try {
                new MainFrame("", "").setVisible(true);
            } catch (IOException ex2) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex2);
            }
        });
    }

    private void laf() {
        System.out.println("-- Cargando estilo de ventana");
        try {
            for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sumarRoll() {
        int sumatoriaRoll2 = 0;
        int sumatoriaBalance = 0;
        final float btcPrice = Float.parseFloat(this.btcPriceStr);
        for (int i = 0; i < this.balanceRoll.size(); ++i) {
            sumatoriaRoll2 += this.balanceRoll.get(i);
        }
        this.sesionUSD = (float) (sumatoriaRoll2 * 1.0E-8 * btcPrice);
        this.labelSesion1.setText(this.sesionStr + ": " + String.format("%,d", sumatoriaRoll2) + " Sat ~ $ " + String.format("%.2f", this.sesionUSD));
        for (int i = 0; i < this.balanceTotal.length; ++i) {
            sumatoriaBalance += this.balanceTotal[i];
        }
        if (this.packAct1) {
            sumatoriaBalance += this.balance1;
        } else {
            sumatoriaBalance += this.balance2;
        }
        this.balanceUSD = (float) (sumatoriaBalance * 1.0E-8 * btcPrice);
        this.labelBalancetotal.setText(this.balanceStr + ": " + String.format("%,d", sumatoriaBalance) + " Sat ~ $ " + String.format("%.2f", this.balanceUSD));
    }

    private void sheduleSaldos() {
        System.out.println("-- Cargando saldos");
        final Timer timerReloj = new Timer();
        final TimerTask ttReloj = new TimerTask() {
            @Override
            public void run() {
                MainFrame.this.openPopUp = false;
                MainFrame.this.btcPriceStr = new BtcPrice().getRetornaPrecio();
                MainFrame.this.jLabel6.setText("1 BTC ~ " + MainFrame.this.btcPriceStr + "$");
                MainFrame.this.clean = true;
                MainFrame.this.deleteUpdates();
                MainFrame.this.sumarRoll();
                try {
                    final String connectionURl = "jdbc:sqlserver://45.77.112.89:1433;database=balances;user=" + MainFrame.this.user + ";password=" + MainFrame.this.pass + ";";
                    final Connection connection = DriverManager.getConnection(connectionURl);
                    final Statement stmt = connection.createStatement();
                    stmt.executeUpdate("UPDATE dbo.balances SET BalanceSato='" + MainFrame.this.balanceUSD + "' WHERE usuario='" + MainFrame.this.user + "';");
                    System.out.println(MainFrame.this.balanceUSD);
                } catch (SQLException ex) {
                }
            }
        };
        timerReloj.schedule(ttReloj, 1000L, 240000L);
    }

    private void Sesionreloj() {
        final Timer timerReloj = new Timer();
        final TimerTask ttReloj = new TimerTask() {
            @Override
            public void run() {
                MainFrame.this.reloj = MainFrame.this.reloj.plusSeconds(1L);
                MainFrame.this.jLabel4.setText(MainFrame.this.reloj.toString());
                if (MainFrame.this.reloj.isAfter(LocalTime.of(23, 59, 58))) {
                    MainFrame.this.dia++;
                    MainFrame.this.relojLabel.setText(MainFrame.this.dia + " dia");
                }
                if (MainFrame.this.activePause.isSelected() && LocalDateTime.now().isAfter(MainFrame.this.horaPause)) {
                    try {
                        for (int i = 0; i < MainFrame.this.pause.length; ++i) {
                            MainFrame.this.pause[i] = false;
                        }
                        MainFrame.this.jLabel39.setText(LocalDateTime.now().plusMinutes(MainFrame.this.stopDuring / 60000).format(DateTimeFormatter.ofPattern("hh:mm a")));
                        MainFrame.this.horaPause = LocalDateTime.now().plusHours(MainFrame.this.nextStop);
                        MainFrame.this.jDialog1.setVisible(true);
                        Thread.sleep(MainFrame.this.stopDuring);
                        MainFrame.this.jDialog1.setVisible(false);
                        for (int i = 0; i < MainFrame.this.pause.length; ++i) {
                            MainFrame.this.pause[i] = true;
                            Thread.sleep(500L);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (LocalDateTime.now().isAfter(MainFrame.this.buyTicket)) {
                    for (int i = 0; i < MainFrame.this.model.getRowCount(); ++i) {
                        MainFrame.this.model.setValueAt(true, i, 15);
                        MainFrame.this.totalTicket += MainFrame.this.ticketCount[i];
                    }
                    if (MainFrame.this.totalTicket >= MainFrame.this.model.getRowCount()) {
                        for (int i = 0; i < MainFrame.this.model.getRowCount(); ++i) {
                            MainFrame.this.model.setValueAt(false, i, 15);
                        }
                    }
                }
            }
        };
        timerReloj.schedule(ttReloj, 1000L, 1000L);
    }

    private void statusBar() {
        final Timer bar = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < MainFrame.this.model.getRowCount(); ++i) {
                    MainFrame.this.terminadas += MainFrame.this.terminada[i];
                }
                for (int i = 0; i < MainFrame.this.procesando.length; ++i) {
                    MainFrame.this.procesada += MainFrame.this.procesando[i];
                }
                MainFrame.this.terminadaCheck = MainFrame.this.terminadas;
                MainFrame.this.procesandoLabel.setText("Procesando: " + MainFrame.this.procesada);
                MainFrame.this.terminadasLabel.setText("Terminadas: " + MainFrame.this.terminadaCheck);
                MainFrame.this.esperaLabel.setText("En Espera: " + (MainFrame.this.model.getRowCount() - MainFrame.this.terminadas));
                MainFrame.this.minHora = MainFrame.this.nextRollArray[0];
                if (MainFrame.this.terminadaCheck >= MainFrame.this.model.getRowCount() || LocalDateTime.now().isAfter(MainFrame.this.minHora.minusMinutes(3L))) {
                    MainFrame.this.terminadaCheck = 0;
                    MainFrame.this.esperaLabel.setText("En Espera: " + MainFrame.this.model.getRowCount());
                    for (int i = 0; i < MainFrame.this.model.getRowCount(); ++i) {
                        MainFrame.this.terminada[i] = 0;
                    }
                }
                if (MainFrame.this.procesada == 0 && !MainFrame.this.openPopUp) {
                    if (MainFrame.this.terminadaCheck == 0) {
                         MainFrame.this.reOrder();
                    }
                    for (int i = 1; i < MainFrame.this.nextRollArray.length; ++i) {
                        if (MainFrame.this.nextRollArray[i].isBefore(MainFrame.this.minHora)) {
                            MainFrame.this.minHora = MainFrame.this.nextRollArray[i];
                        }
                    }
                    if (MainFrame.this.clean) {
                        try {
                            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
                            Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
                            Runtime.getRuntime().exec("cmd.exe /c start C:\\\"Program Files\\GT Tools\\CoinBot FreeBitcoin\\Temp.bat\"");
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        MainFrame.this.clean = false;
                    }
                }
                MainFrame.this.terminadas = 0;
                MainFrame.this.procesada = 0;
            }
        };
        bar.schedule(tt, 5000L, 1000L);
    }

    private void loadPerfiles() {
        System.out.println("-- Cargando Perfiles");
        final ProfilesIni profilesIni = new ProfilesIni();
        profilesIni.readProfiles(this.perfiles);
        profilesIni.readProxies(this.proxies);
    }

    private void writeToTable(final ArrayList<String> packPerfiles) {
        int perfilNumber = 1;
        for (int j = 0; j < packPerfiles.size(); ++j) {
            final String perfil = packPerfiles.get(j);
            final Object[] rowData = {perfilNumber, perfil, "", "", "", 0, 0, true, "", "", true, "", "", "", "", false};
            this.model.addRow(rowData);
            ++perfilNumber;
        }
        this.totalPerfilesLabel.setText("Total: " + this.model.getRowCount());
        this.esperaLabel.setText("En Espera: " + this.model.getRowCount());
        this.procesandoLabel.setText("Procesando: " + this.procesada);
    }

    private void activarPerfiles() {
        System.out.println("-- Cargando paquetes");
        final int rowCount = this.model.getRowCount();
        for (int i = rowCount - 1; i >= 0; --i) {
            this.model.removeRow(i);
        }
        if (this.packAct1) {
            this.writeToTable(this.paquete1);
            this.packAct1 = false;
            this.pack2Balance = this.balanceTotal;
            this.balanceTotal = this.pack1Balance;
        } else {
            this.writeToTable(this.paquete2);
            this.packAct1 = true;
            this.pack1Balance = this.balanceTotal;
            this.balanceTotal = this.pack2Balance;
        }
    }

    private void loadArrays() {
        System.out.println("-- Cargando horas y saldos");
        this.ticketCount = new int[this.profilesCount];
        this.pause = new boolean[14];
        this.workerFlag = new boolean[14];
        this.nextRollArray = new LocalDateTime[this.profilesCount + 1];
        this.balanceTotal = new int[this.profilesCount];
        this.terminada = new int[this.profilesCount];
        for (int i = 0; i < this.pause.length; ++i) {
            this.pause[i] = true;
            this.workerFlag[i] = false;
        }
        for (int j = 0; j < this.profilesCount; ++j) {
            this.nextRollArray[j] = LocalDateTime.of(2017, Month.MARCH, 5, 6, 5).plusMinutes(j);
            this.balanceTotal[j] = 0;
            this.terminada[j] = 0;
        }
        this.nextRollArray[this.profilesCount] = LocalDateTime.of(2020, Month.MARCH, 5, 6, 5);
    }

    private void properties() {
        System.out.println("-- Cargando propiedades");
        this.jTextField2.setVisible(false);
        this.jTable1.getColumn(15).setPreferredWidth(0);
        this.jTable1.getColumn(15).setMinWidth(0);
        this.jTable1.getColumn(15).setWidth(0);
        this.jTable1.getColumn(15).setMaxWidth(0);
        try {
            this.PROP.load(new FileReader("C:\\Program Files\\GT Tools\\CoinBot FreeBitcoin\\config.properties"));
            this.proxyUser.setText(this.PROP.getProperty("proxyUser"));
            this.proxyPass.setText(this.PROP.getProperty("proxyPass"));
            this.checkBonusRP = Boolean.valueOf(this.PROP.getProperty("bonoRpelectStatus"));
            this.bonusRP.setSelected(this.checkBonusRP);
            this.checkBonusBTC = Boolean.valueOf(this.PROP.getProperty("bonoBtcSelectStatus"));
            this.bonoBTC.setSelected(this.checkBonusBTC);
            this.backGroundStatus = Boolean.valueOf(this.PROP.getProperty("backGroundSelectSatatus"));
            this.backgroundStatus.setSelected(this.backGroundStatus);
            this.workerStatus = Integer.parseInt(this.PROP.getProperty("activeWorkers"));
            this.activeWorkers.setSelectedItem(String.valueOf(this.workerStatus));
            this.sendProxy.setSelected(Boolean.valueOf(this.PROP.getProperty("sendProxy")));
            final boolean advanced = Boolean.valueOf(this.PROP.getProperty("advancedMode"));
            this.modoAvanzado.setSelected(advanced);
            this.captchaKey1.setText(this.PROP.getProperty("TwoCaptchaKey"));
            this.tipoBono[0] = Integer.parseInt(this.PROP.getProperty("limiteBonoRP"));
            this.limiteRP.setSelectedIndex(this.tipoBono[0]);
            this.tipoBono[1] = Integer.parseInt(this.PROP.getProperty("limiteBonoBtC"));
            this.limiteBTC.setSelectedIndex(this.tipoBono[1]);
            this.setAlwaysOnTop(Boolean.valueOf(this.PROP.getProperty("alwaysTop")));
            this.AlwaysOnTop.setSelected(Boolean.valueOf(this.PROP.getProperty("alwaysTop")));
            this.monsterIP.setText(this.PROP.getProperty("capMonsterIP"));
            this.proxyPuerto.setText(this.PROP.getProperty("proxyPuerto"));
            this.detenerDurante.setSelectedItem(this.PROP.getProperty("stopDuring"));
            this.tipoBono[2] = Integer.parseInt(this.PROP.getProperty("montoTicket"));
            this.ticketMonto.setValue(this.tipoBono[2]);
            this.jLabel2.setText(String.valueOf(this.workerStatus));
            this.activePause.setSelected(Boolean.parseBoolean(this.PROP.getProperty("activarPausa")));
            if (this.PROP.getProperty("stopDuring").equals("10 Minutos")) {
                this.stopDuring = 600000;
            } else if (this.PROP.getProperty("stopDuring").equals("20 Minutos")) {
                this.stopDuring = 1200000;
            } else if (this.PROP.getProperty("stopDuring").equals("30 Minutos")) {
                this.stopDuring = 1800000;
            } else if (this.PROP.getProperty("stopDuring").equals("40 Minutos")) {
                this.stopDuring = 2400000;
            } else if (this.PROP.getProperty("stopDuring").equals("50 Minutos")) {
                this.stopDuring = 3000000;
            } else if (this.PROP.getProperty("stopDuring").equals("60 Minutos")) {
                this.stopDuring = 3600000;
            }
            if (this.PROP.getProperty("buyTicket").equals("1 Dia")) {
                this.buyTicket = LocalDateTime.now().plusHours(24L);
            } else if (this.PROP.getProperty("buyTicket").equals("2 Dias")) {
                this.buyTicket = LocalDateTime.now().plusHours(48L);
            } else if (this.PROP.getProperty("buyTicket").equals("3 Dias")) {
                this.buyTicket = LocalDateTime.now().plusHours(72L);
            } else if (this.PROP.getProperty("buyTicket").equals("7 Dias")) {
                this.buyTicket = LocalDateTime.now().plusHours(168L);
            }
            for (int i = 0; i < this.model.getRowCount(); ++i) {
                this.model.setValueAt(false, i, 15);
            }
            final String horaPausa = this.PROP.getProperty("nextStop");
            this.nextPause.setSelectedItem(horaPausa);
            final String s = horaPausa;
            switch (s) {
                case "3 Horas": {
                    this.nextStop = 3;
                    break;
                }
                case "6 Horas": {
                    this.nextStop = 6;
                    break;
                }
                case "12 Horas": {
                    this.nextStop = 12;
                    break;
                }
                case "24 Horas": {
                    this.nextStop = 24;
                    break;
                }
            }
            for (int j = 0; j < this.model.getRowCount(); ++j) {
                this.model.setValueAt(this.checkBonusRP, j, 7);
                this.model.setValueAt(this.checkBonusBTC, j, 10);
            }
            if (!advanced) {
                this.table.normalTable((JTable) this.jTable1);
            } else {
                this.table.advancedTable((JTable) this.jTable1);
            }
            if (this.retiroAutoCheck.isSelected()) {
                this.balanceStr = "Retirado";
                this.sesionStr = "Fees";
                this.labelSesion1.setText("Fees: 0 Sat ~$ 0");
                this.labelBalancetotal.setText("Retirado: 0 Sat ~ $ 0");
                this.table.withdrawTable((JTable) this.jTable1);
                this.retiroAutoCheck.setSelected(true);
            } else if (!advanced) {
                this.table.normalTable((JTable) this.jTable1);
                this.balanceStr = "Balance";
                this.sesionStr = "Sesi\u00f3n";
                this.labelSesion1.setText("Sesi\u00f3n: 0 Sat ~$ 0");
                this.labelBalancetotal.setText("Balance: 0 Sat ~ $ 0");
            } else {
                this.table.advancedTable((JTable) this.jTable1);
                this.balanceStr = "Balance";
                this.sesionStr = "Sesi\u00f3n";
                this.labelSesion1.setText("Sesi\u00f3n: 0 Sat ~$ 0");
                this.labelBalancetotal.setText("Balance: 0 Sat ~ $ 0");
            }
            final FileWriter fstream = new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts", false);
            try (final BufferedWriter out = new BufferedWriter(fstream)) {
                out.write(this.monsterIP.getText() + " 2Captcha.com");
                out.newLine();
            }
            this.proxyPuerto1.setText(this.PROP.getProperty("perfilesActivos"));
            final int perfilesActivos = Integer.parseInt(this.proxyPuerto1.getText());
            if (perfilesActivos == 0) {
                if (this.botStatus) {
                    this.proxyCant = JOptionPane.showInputDialog(this.rootPane, "�Cuantas cuentas deseas cargar al primer paquete?", "Configuraci\u00f3n de perfiles", 3);
                    this.profilesCount = Integer.parseInt(this.proxyCant);
                    this.botStatus = false;
                    this.proxyPuerto1.setText(String.valueOf(this.profilesCount));
                    this.cargarPaquetes(this.profilesCount);
                    this.saveProperties();
                } else {
                    JOptionPane.showMessageDialog(this.rootPane, "Has cambiado la cantidad de perdiles activos. \n Debes reinicar el bot para que esta opcion surta efecto", this.user, 2);
                }
            } else {
                this.cargarPaquetes(this.profilesCount = perfilesActivos);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveProperties() {
        this.PROP.setProperty("activeWorkers", this.activeWorkers.getSelectedItem().toString());
        this.PROP.setProperty("proxyUser", this.proxyUser.getText());
        this.PROP.setProperty("backGroundSelectSatatus", String.valueOf(this.backgroundStatus.isSelected()));
        this.PROP.setProperty("bonoBtcSelectStatus", String.valueOf(this.bonoBTC.isSelected()));
        this.PROP.setProperty("proxyPass", this.proxyPass.getText());
        this.PROP.setProperty("bonoRpelectStatus", String.valueOf(this.bonusRP.isSelected()));
        this.PROP.setProperty("TwoCaptchaKey", this.captchaKey1.getText());
        this.PROP.setProperty("capMonsterIP", this.monsterIP.getText());
        this.PROP.setProperty("alwaysTop", String.valueOf(this.AlwaysOnTop.isSelected()));
        this.PROP.setProperty("advancedMode", String.valueOf(this.modoAvanzado.isSelected()));
        this.PROP.setProperty("limiteBonoRP", String.valueOf(this.limiteRP.getSelectedIndex()));
        this.PROP.setProperty("limiteBonoBtC", String.valueOf(this.limiteBTC.getSelectedIndex()));
        this.PROP.setProperty("sendProxy", String.valueOf(this.sendProxy.isSelected()));
        this.PROP.setProperty("nextStop", this.nextPause.getSelectedItem().toString());
        this.PROP.setProperty("stopDuring", this.detenerDurante.getSelectedItem().toString());
        this.PROP.setProperty("montoTicket", String.valueOf(this.ticketMonto.getValue()));
        this.PROP.setProperty("buyTicket", this.ticketDia.getSelectedItem().toString());
        this.PROP.setProperty("activarPausa", String.valueOf(this.activePause.isSelected()));
        this.PROP.setProperty("proxyPuerto", this.proxyPuerto.getText());
        this.PROP.setProperty("perfilesActivos", this.proxyPuerto1.getText());
        try {
            this.PROP.store(new FileWriter("C:\\Program Files\\GT Tools\\CoinBot FreeBitcoin\\config.properties"), "CoinBot");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarPaquetes(final int profileCount) {
        this.pack1Balance = new int[profileCount];
        for (int i = 0; i < profileCount; ++i) {
            this.paquete1.add(this.perfiles.get(i));
            this.pack1Balance[i] = 0;
        }
        for (int i = profileCount; i < this.perfiles.size(); ++i) {
            this.paquete2.add(this.perfiles.get(i));
        }
        this.pack2Balance = new int[this.paquete2.size()];
        for (int i = 0; i < this.pack2Balance.length; ++i) {
            this.pack2Balance[i] = 0;
        }
    }

    private void deleteUpdates() {
        final File directory = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Mozilla\\updates");
        if (directory.exists()) {
            FileHandler.delete(directory);
        }
    }

    private void retiros() {
        final Timer timer8 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                final int rawRetiro = Integer.parseInt(MainFrame.this.jTextField2.getText());
                for (int i = 0; i < MainFrame.this.model.getRowCount(); ++i) {
                    try {
                        final MineroRetiros ret = new MineroRetiros(i, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.balanceTotal, MainFrame.this.balanceRoll, MainFrame.this.procesando, MainFrame.this.tipoRetiro, MainFrame.this.modoRetiro, rawRetiro);
                        ret.execute();
                        final boolean redLight = ret.get();
                        MainFrame.this.sumarRoll();
                    } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        timer8.schedule(tt, 1000L, 10000000L);
    }

    private void cargarBalances() {
        try {
            if (this.fichero.exists()) {
                final ArrayList<Balances> balancePack1 = new SaveBalances().retornaBalances(this.fichero);
                for (int k = 0; k < this.paquete1.size(); ++k) {
                    for (int i = 0; i < balancePack1.size(); ++i) {
                        if (balancePack1.get(i).getPerfil().equals(this.paquete1.get(k))) {
                            this.pack1Balance[k] = balancePack1.get(i).getBalance();
                            this.balance1 += this.pack1Balance[k];
                        }
                    }
                }
            }
            if (this.fichero2.exists()) {
                final ArrayList<Balances> balancePack2 = new SaveBalances().retornaBalances(this.fichero2);
                for (int k = 0; k < this.paquete2.size(); ++k) {
                    for (int i = 0; i < balancePack2.size(); ++i) {
                        if (balancePack2.get(i).getPerfil().equals(this.paquete2.get(k))) {
                            this.pack2Balance[k] = balancePack2.get(i).getBalance();
                            this.balance2 += this.pack2Balance[k];
                        }
                    }
                }
                this.balanceTotal = this.pack2Balance;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarBalances() {
        final ArrayList<Balances> arrPack1 = new ArrayList<>();
        final ArrayList<Balances> arrPack2 = new ArrayList<>();
        if (!this.packAct1) {
            System.out.println(" IF");
            for (int i = 0; i < this.model.getRowCount(); ++i) {
                final String perfil = (String) this.model.getValueAt(i, 1);
                arrPack1.add(new Balances(perfil, this.balanceTotal[i]));
            }
            new SaveBalances().agregarBalance(arrPack1, this.fichero);
        } else {
            System.out.println(" ELSE");
            for (int i = 0; i < this.model.getRowCount(); ++i) {
                final String perfil = (String) this.model.getValueAt(i, 1);
                arrPack2.add(new Balances(perfil, this.balanceTotal[i]));
            }
            new SaveBalances().agregarBalance(arrPack2, this.fichero2);
        }
    }

    private void reOrder() {
        this.table.tableReOrder(this.model, this.nextRollArray, this.balanceTotal);
    }

    private void runWorker1() {
        final Timer timer1 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[0]) {
                    for (int x = 0; x < MainFrame.this.model.getRowCount(); ++x) {
                        if (MainFrame.this.nextRollArray[x].isBefore(MainFrame.this.nextRollArray[x + 1]) || MainFrame.this.nextRollArray[x].isEqual(MainFrame.this.nextRollArray[x + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[x])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(x, 14);
                                if (estado.contains("Esperando siguiente ronda") || estado.contains("�Aun no es la hora del Roll!") || estado.equals("") || estado.contains("Ha ocurrido un error") || estado.contains("CAPTCHA_TIMEOUT") || estado.contains("IP Compartida") || estado.contains("Sesi\u00f3n no iniciada")) {
                                    MainFrame.this.w1 = x;
                                    MainFrame.this.workerFlag[0] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[0] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[0]) {
                        try {
                            MainFrame.this.workerFlag[0] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w1] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker = new Worker(MainFrame.this.w1, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.worker.execute();
                            final Rectangle cellRect = MainFrame.this.jTable1.getCellRect(MainFrame.this.w1, 1, true);
                            MainFrame.this.jTable1.scrollRectToVisible(cellRect);
                            MainFrame.this.workerFlag[0] = MainFrame.this.worker.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w1].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w1] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timer1.schedule(tt, 1000L, 1000L);
    }

    private void runWorker2() {
        final Timer timerTask = new Timer();
        final TimerTask ttWorker2 = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[1]) {
                    for (int c = 0; c < MainFrame.this.model.getRowCount(); ++c) {
                        if (MainFrame.this.nextRollArray[c].isBefore(MainFrame.this.nextRollArray[c + 1]) || MainFrame.this.nextRollArray[c].isEqual(MainFrame.this.nextRollArray[c + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[c])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(c, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("�Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w2 = c;
                                    MainFrame.this.workerFlag[1] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[1] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[1]) {
                        try {
                            MainFrame.this.workerFlag[1] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w2] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker2 = new Worker2(MainFrame.this.w2, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            final Rectangle cellRect = MainFrame.this.jTable1.getCellRect(MainFrame.this.w2, 1, true);
                            MainFrame.this.jTable1.scrollRectToVisible(cellRect);
                            MainFrame.this.worker2.execute();
                            MainFrame.this.workerFlag[1] = MainFrame.this.worker2.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w2].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w2] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {

                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timerTask.schedule(ttWorker2, 1500L, 1000L);
    }

    private void runWorker3() {
        final Timer timerTaskWorker3 = new Timer();
        final TimerTask ttWorker3 = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[2]) {
                    for (int q = 0; q < MainFrame.this.model.getRowCount(); ++q) {
                        if (MainFrame.this.nextRollArray[q].isBefore(MainFrame.this.nextRollArray[q + 1]) || MainFrame.this.nextRollArray[q].isEqual(MainFrame.this.nextRollArray[q + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[q])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(q, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("�Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w3 = q;
                                    MainFrame.this.workerFlag[2] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[2] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[2]) {
                        try {
                            MainFrame.this.workerFlag[2] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w3] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker3 = new Worker3(MainFrame.this.w3, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            final Rectangle cellRect = MainFrame.this.jTable1.getCellRect(MainFrame.this.w3, 1, true);
                            MainFrame.this.jTable1.scrollRectToVisible(cellRect);
                            MainFrame.this.worker3.execute();
                            MainFrame.this.workerFlag[2] = MainFrame.this.worker3.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w3].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w3] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timerTaskWorker3.schedule(ttWorker3, 2000L, 1000L);
    }

    private void runWorker4() {
        final Timer timerTaskWorker4 = new Timer();
        final TimerTask ttWorker4 = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[3]) {
                    for (int q = 0; q < MainFrame.this.model.getRowCount(); ++q) {
                        if (MainFrame.this.nextRollArray[q].isBefore(MainFrame.this.nextRollArray[q + 1]) || MainFrame.this.nextRollArray[q].isEqual(MainFrame.this.nextRollArray[q + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[q])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(q, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w4 = q;
                                    MainFrame.this.workerFlag[3] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[3] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[3]) {
                        try {
                            MainFrame.this.workerFlag[3] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w4] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker4 = new Worker4(MainFrame.this.w4, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            final Rectangle cellRect = MainFrame.this.jTable1.getCellRect(MainFrame.this.w4, 1, true);
                            MainFrame.this.jTable1.scrollRectToVisible(cellRect);
                            MainFrame.this.worker4.execute();
                            MainFrame.this.workerFlag[3] = MainFrame.this.worker4.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w4].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w4] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timerTaskWorker4.schedule(ttWorker4, 2500L, 1000L);
    }

    private void runWorker5() {
        final Timer timerTask = new Timer();
        final TimerTask ttWorker5 = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[4]) {
                    for (int c = 0; c < MainFrame.this.model.getRowCount(); ++c) {
                        if (MainFrame.this.nextRollArray[c].isBefore(MainFrame.this.nextRollArray[c + 1]) || MainFrame.this.nextRollArray[c].isEqual(MainFrame.this.nextRollArray[c + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[c])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(c, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w5 = c;
                                    MainFrame.this.workerFlag[4] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[4] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[4]) {
                        try {
                            MainFrame.this.workerFlag[4] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w5] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker5 = new Worker5(MainFrame.this.w5, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.worker5.execute();
                            MainFrame.this.workerFlag[4] = MainFrame.this.worker5.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w5].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w5] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timerTask.schedule(ttWorker5, 3000L, 1000L);
    }

    private void runWorker6() {
        final Timer timerTask = new Timer();
        final TimerTask ttWorker6 = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[5]) {
                    for (int c = 0; c < MainFrame.this.model.getRowCount(); ++c) {
                        if (MainFrame.this.nextRollArray[c].isBefore(MainFrame.this.nextRollArray[c + 1]) || MainFrame.this.nextRollArray[c].isEqual(MainFrame.this.nextRollArray[c + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[c])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(c, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w6 = c;
                                    MainFrame.this.workerFlag[5] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[5] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[5]) {
                        try {
                            MainFrame.this.workerFlag[5] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w6] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker6 = new Worker6(MainFrame.this.w6, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.worker6.execute();
                            MainFrame.this.workerFlag[5] = MainFrame.this.worker6.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w6].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w6] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timerTask.schedule(ttWorker6, 3500L, 1000L);
    }

    private void runWorker7() {
        final Timer timerTask = new Timer();
        final TimerTask ttWorker7 = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[6]) {
                    for (int c = 0; c < MainFrame.this.model.getRowCount(); ++c) {
                        if (MainFrame.this.nextRollArray[c].isBefore(MainFrame.this.nextRollArray[c + 1]) || MainFrame.this.nextRollArray[c].isEqual(MainFrame.this.nextRollArray[c + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[c])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(c, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w7 = c;
                                    MainFrame.this.workerFlag[6] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[6] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[6]) {
                        try {
                            MainFrame.this.workerFlag[6] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w7] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker7 = new Worker7(MainFrame.this.w7, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.worker7.execute();
                            MainFrame.this.workerFlag[6] = MainFrame.this.worker7.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w7].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w7] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timerTask.schedule(ttWorker7, 4000L, 1000L);
    }

    private void runWorker8() {
        final Timer timer8 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[7]) {
                    for (int x = 0; x < MainFrame.this.model.getRowCount(); ++x) {
                        if (MainFrame.this.nextRollArray[x].isBefore(MainFrame.this.nextRollArray[x + 1]) || MainFrame.this.nextRollArray[x].isEqual(MainFrame.this.nextRollArray[x + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[x])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(x, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w8 = x;
                                    MainFrame.this.workerFlag[7] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[7] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[7]) {
                        try {
                            MainFrame.this.workerFlag[7] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w8] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker8 = new Worker8(MainFrame.this.w8, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.worker8.execute();
                            MainFrame.this.workerFlag[7] = MainFrame.this.worker8.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w8].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w8] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timer8.schedule(tt, 4500L, 1000L);
    }

    private void runWorker9() {
        final Timer timer8 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[8]) {
                    for (int x = 0; x < MainFrame.this.model.getRowCount(); ++x) {
                        if (MainFrame.this.nextRollArray[x].isBefore(MainFrame.this.nextRollArray[x + 1]) || MainFrame.this.nextRollArray[x].isEqual(MainFrame.this.nextRollArray[x + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[x])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(x, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w9 = x;
                                    MainFrame.this.workerFlag[8] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[8] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[8]) {
                        try {
                            MainFrame.this.workerFlag[8] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w9] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker9 = new Worker9(MainFrame.this.w9, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.workerFlag[8] = MainFrame.this.worker9.run();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w9].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w9] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex2) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex2);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timer8.schedule(tt, 5000L, 1000L);
    }

    private void runWorker10() {
        final Timer timer8 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[9]) {
                    for (int x = 0; x < MainFrame.this.model.getRowCount(); ++x) {
                        if (MainFrame.this.nextRollArray[x].isBefore(MainFrame.this.nextRollArray[x + 1]) || MainFrame.this.nextRollArray[x].isEqual(MainFrame.this.nextRollArray[x + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[x])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(x, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w10 = x;
                                    MainFrame.this.workerFlag[9] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[9] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[9]) {
                        try {
                            MainFrame.this.workerFlag[9] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w10] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker10 = new Worker10(MainFrame.this.w10, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.workerFlag[9] = MainFrame.this.worker10.run();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w10].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w10] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex2) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex2);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timer8.schedule(tt, 5500L, 1000L);
    }

    private void runWorker11() {
        final Timer timer8 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[10]) {
                    for (int x = 0; x < MainFrame.this.model.getRowCount(); ++x) {
                        if (MainFrame.this.nextRollArray[x].isBefore(MainFrame.this.nextRollArray[x + 1]) || MainFrame.this.nextRollArray[x].isEqual(MainFrame.this.nextRollArray[x + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[x])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(x, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w11 = x;
                                    MainFrame.this.workerFlag[10] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[10] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[10]) {
                        try {
                            MainFrame.this.workerFlag[10] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w11] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker11 = new Worker11(MainFrame.this.w11, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.workerFlag[10] = MainFrame.this.worker11.run();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w11].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w11] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex2) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex2);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timer8.schedule(tt, 6000L, 1000L);
    }

    private void runWorker12() {
        final Timer timer8 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[11]) {
                    for (int x = 0; x < MainFrame.this.model.getRowCount(); ++x) {
                        if (MainFrame.this.nextRollArray[x].isBefore(MainFrame.this.nextRollArray[x + 1]) || MainFrame.this.nextRollArray[x].isEqual(MainFrame.this.nextRollArray[x + 1])) {
                            if (LocalDateTime.now().isAfter(MainFrame.this.nextRollArray[x])) {
                                final String estado = (String) MainFrame.this.jTable1.getValueAt(x, 14);
                                if (estado.contains("Esperando siguiente ronda")
                                        || estado.contains("¡Aun no es la hora del Roll!")
                                        || estado.equals("")
                                        || estado.contains("Ha ocurrido un error")
                                        || estado.contains("CAPTCHA_TIMEOUT")
                                        || estado.contains("IP Compartida")
                                        || estado.contains("Sesión no iniciada")) {
                                    MainFrame.this.w12 = x;
                                    MainFrame.this.workerFlag[11] = true;
                                    break;
                                }
                            }
                        } else {
                            MainFrame.this.workerFlag[11] = false;
                        }
                    }
                    if (MainFrame.this.workerFlag[11]) {
                        try {
                            MainFrame.this.workerFlag[11] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.w12] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.worker12 = new Worker12();
                            MainFrame.this.workerFlag[11] = MainFrame.this.worker11.run();
                            if (MainFrame.this.nextRollArray[MainFrame.this.w12].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.w12] = 1;
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex2) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex2);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        timer8.schedule(tt, 6000L, 1000L);
    }

    private void hiddenWorker() {
        final Timer hidden1 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[12]) {
                    for (int x = 0; x < MainFrame.this.model.getRowCount(); ++x) {
                        final String estado = (String) MainFrame.this.jTable1.getValueAt(x, 14);
                        if (estado.contains("Ha ocurrido un error") || estado.contains("CAPTCHA_TIMEOUT")) {
                            MainFrame.this.silentSelector = x;
                            MainFrame.this.workerFlag[12] = true;
                            break;
                        }
                        MainFrame.this.workerFlag[12] = false;
                    }
                    if (MainFrame.this.workerFlag[12]) {
                        try {
                            MainFrame.this.workerFlag[12] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.silentSelector] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.silent = new SilentWorker(MainFrame.this.silentSelector, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.silent.execute();
                            MainFrame.this.workerFlag[12] = MainFrame.this.silent.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.silentSelector].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.silentSelector] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        hidden1.schedule(tt, 8000L, 1000L);
    }

    private void hiddenWorker2() {
        final Timer hidden2 = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (MainFrame.this.pause[13]) {
                    for (int x = 0; x < MainFrame.this.model.getRowCount(); ++x) {
                        final String estado = (String) MainFrame.this.jTable1.getValueAt(x, 14);
                        if (estado.contains("Ha ocurrido un error") || estado.contains("CAPTCHA_TIMEOUT")) {
                            MainFrame.this.silentSelector2 = x;
                            MainFrame.this.workerFlag[13] = true;
                            break;
                        }
                        MainFrame.this.workerFlag[13] = false;
                    }
                    if (MainFrame.this.workerFlag[13]) {
                        try {
                            MainFrame.this.workerFlag[13] = false;
                            MainFrame.this.nextRollArray[MainFrame.this.silentSelector2] = LocalDateTime.now().plusMinutes(15L);
                            MainFrame.this.silent2 = new SilentWorker2(MainFrame.this.silentSelector2, MainFrame.this.model, MainFrame.this.backGroundStatus, MainFrame.this.nextRollArray, MainFrame.this.balanceRoll, MainFrame.this.balanceTotal, MainFrame.this.proxies, MainFrame.this.procesando, MainFrame.this.tipoBono, MainFrame.this.ticketCount);
                            MainFrame.this.silent2.execute();
                            MainFrame.this.workerFlag[13] = MainFrame.this.silent2.get();
                            if (MainFrame.this.nextRollArray[MainFrame.this.silentSelector2].isAfter(LocalDateTime.now().plusMinutes(5L))) {
                                MainFrame.this.terminada[MainFrame.this.silentSelector2] = 1;
                            }
                        } catch (InterruptedException | ExecutionException | IOException ex) {

                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    MainFrame.this.sumarRoll();
                }
            }
        };
        hidden2.schedule(tt, 8500L, 1000L);
    }
}
