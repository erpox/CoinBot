// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.miners;

import java.util.function.Function;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import com.freebitcoin.app.control.TwoCaptchaFreeBTC;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ChronoUnit;
import java.time.LocalTime;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.TimeoutException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.NoSuchSessionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import com.freebitcoin.app.control.packed.Proxies;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import org.openqa.selenium.WebDriver;
import javax.swing.SwingWorker;

public class SilentWorker extends SwingWorker<Boolean, String>
{
    private static String bonusRewarP;
    private static String bonusFreeBTC;
    private static String balancePuntos;
    private static int balancePuntosParse;
    private static String balanceBTC;
    private static String bonoRPFin;
    private static String bonoBTCFin;
    private static String postRoll;
    private static String rewardPointRoll;
    private static WebDriver driver;
    private final String perfil;
    private final int selector;
    private final DefaultTableModel model;
    private final File file;
    private final boolean BackGroundStatus;
    private final boolean checkBonusRP;
    private final boolean checkBonusBTC;
    private static String responseToken;
    private String balanceRoll;
    private LocalDateTime now;
    private LocalDateTime[] nextRollArray;
    private ArrayList<Integer> balanceRollArray;
    private int[] balanceTotalArray;
    private int finalPuntos;
    private final ArrayList<Proxies> proxies;
    private int captchaCount;
    private int proxySelector;
    private int[] procesando;
    private int[] tipoBono;
    private int[] ticketCount;
    private boolean comprarTicke;
    
    public SilentWorker(final int selector, final DefaultTableModel model, final boolean backGroundStatus, final LocalDateTime[] nextRollArray, final ArrayList<Integer> balanceRollArray, final int[] balanceTotalArray, final ArrayList<Proxies> proxies, final int[] procesando, final int[] tipoBono, final int[] ticketCount) throws IOException {
        this.captchaCount = 1;
        this.perfil = (String)model.getValueAt(selector, 1);
        this.selector = selector;
        this.proxySelector = selector;
        this.model = model;
        this.BackGroundStatus = backGroundStatus;
        this.nextRollArray = nextRollArray;
        this.balanceRollArray = balanceRollArray;
        this.balanceTotalArray = balanceTotalArray;
        this.checkBonusRP = (boolean)model.getValueAt(selector, 7);
        this.checkBonusBTC = (boolean)model.getValueAt(selector, 10);
        this.proxies = proxies;
        this.procesando = procesando;
        this.file = new File("C:\\Program Files\\GT Tools\\CoinBot FreeBitcoin\\geckodriver.exe");
        this.tipoBono = tipoBono;
        this.comprarTicke = (boolean)model.getValueAt(selector, 15);
        this.ticketCount = ticketCount;
        procesando[11] = 1;
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
        try {
            this.Inicializar(this.perfil);
            this.loadSite();
            if (this.comprarTicke) {
                this.compraTickets();
            }
            this.checkBonusPoint();
            this.checkBonusFreeBTC();
            this.rollAction();
            this.postear();
        }
        catch (NoSuchSessionException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
        }
        catch (WebDriverException ex2) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, (Throwable)ex2);
            this.model.setValueAt(" Ha ocurrido un error", this.selector, 14);
            this.now = LocalDateTime.now().plusMinutes(1L);
            this.nextRollArray[this.selector] = this.now;
            SilentWorker.driver.quit();
        }
        catch (Exception e) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            this.model.setValueAt(" Ha ocurrido un error", this.selector, 14);
            this.now = LocalDateTime.now().plusMinutes(1L);
            this.nextRollArray[this.selector] = this.now;
            SilentWorker.driver.quit();
        }
        finally {
            this.procesando[11] = 0;
            return false;
        }
    }
    
    @Override
    protected void done() {
    }
    
    protected void compraTickets() {
        if (this.ticketCount[this.selector] == 0) {
            final String cantidadTickets = String.valueOf(this.tipoBono[2]);
            SilentWorker.driver.findElement(By.linkText("LOTTERY")).click();
            SilentWorker.driver.findElement(By.id("lottery_tickets_purchase_count")).clear();
            SilentWorker.driver.findElement(By.id("lottery_tickets_purchase_count")).sendKeys(new CharSequence[] { cantidadTickets });
            try {
                SilentWorker.driver.findElement(By.linkText("Got it!")).click();
            }
            catch (NoSuchElementException ex) {}
            SilentWorker.driver.findElement(By.id("purchase_lottery_tickets_button")).click();
            SilentWorker.driver.findElement(By.linkText("FREE BTC")).click();
            this.ticketCount[this.selector] = 1;
        }
    }
    
    protected void Inicializar(final String Perfil) throws WebDriverException, InterruptedException {
        this.model.setValueAt(" Cargando perfil... ", this.selector, 14);
        System.setProperty("webdriver.gecko.driver", this.file.getAbsolutePath());
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        final ProfilesIni profile = new ProfilesIni();
        final FirefoxProfile myprofile = profile.getProfile(Perfil);
        final FirefoxOptions options = new FirefoxOptions().setProfile(myprofile);
        options.addPreference("signon.autologin.proxy", true);
        options.addPreference("browser.tabs.remote.autostart", false);
        options.addPreference("browser.tabs.remote.autostart.2", false);
        if (this.BackGroundStatus) {
            options.addArguments(new String[] { "--headless" });
        }
        this.model.setValueAt(" Abriendo navegador...", this.selector, 14);
        SilentWorker.driver = (WebDriver)new FirefoxDriver(options);
        SilentWorker.driver.manage().window().maximize();
        this.model.setValueAt(" Cargando https://freebitco.in/", this.selector, 14);
        try {
            SilentWorker.driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
            SilentWorker.driver.get("https://freebitco.in");
        }
        catch (TimeoutException ex) {
            SilentWorker.driver.quit();
            this.Inicializar(this.perfil);
        }
    }
    
    protected void loadSite() throws InterruptedException, NoSuchSessionException, WebDriverException {
        try {
            SilentWorker.balanceBTC = SilentWorker.driver.findElement(By.id("balance")).getText();
        }
        catch (NoSuchElementException e) {
            SilentWorker.driver.quit();
            this.model.setValueAt(" Sesi\u00f3n no iniciada", this.selector, 14);
            throw new NoSuchSessionException("No inicio");
        }
        final String porcentaje = SilentWorker.driver.findElement(By.id("fp_bonus_req_completed")).getText().substring(0, 6);
        this.model.setValueAt(porcentaje, this.selector, 4);
        SilentWorker.driver.findElement(By.linkText("REWARDS")).click();
        SilentWorker.balancePuntos = SilentWorker.driver.findElement(By.xpath("//div[@id='rewards_tab']/div[2]/div/div[2]")).getText();
        final String newStr = SilentWorker.balancePuntos.replace(",", "").trim();
        try {
            SilentWorker.balancePuntosParse = Integer.parseInt(newStr);
        }
        catch (NumberFormatException e2) {
            SilentWorker.balancePuntosParse = 1000;
        }
        this.finalPuntos = SilentWorker.balancePuntosParse;
        SilentWorker.driver.findElement(By.linkText("FREE BTC")).click();
        if (SilentWorker.driver.findElement(By.id("time_remaining")).isDisplayed()) {
            final String timeRemaining = SilentWorker.driver.findElement(By.id("time_remaining")).getText();
            String hora = "";
            try {
                final int minutos = Integer.parseInt(timeRemaining.substring(0, 2).trim());
                hora = LocalTime.now().plus((long)minutos, (TemporalUnit)ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("hh:mm a"));
                this.now = LocalDateTime.now().plus((long)minutos, (TemporalUnit)ChronoUnit.MINUTES);
            }
            catch (NumberFormatException e3) {
                hora = LocalTime.now().plus(5L, (TemporalUnit)ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("hh:mm a"));
                this.now = LocalDateTime.now().plus(5L, (TemporalUnit)ChronoUnit.MINUTES);
            }
            this.nextRollArray[this.selector] = this.now;
            try {
                final String bonu = SilentWorker.driver.findElement(By.xpath("//div[@id='bonus_container_free_points']/p/span")).getText().substring(0, 3).trim();
                SilentWorker.bonoRPFin = SilentWorker.driver.findElement(By.id("bonus_span_free_points")).getText().substring(0, 2) + " Hrs";
                if (bonu.contains("e")) {
                    SilentWorker.bonusRewarP = bonu.replace("e", "") + "RP";
                }
                else {
                    SilentWorker.bonusRewarP = bonu + " RP";
                }
            }
            catch (NoSuchElementException ex) {
                SilentWorker.bonusRewarP = "No";
            }
            catch (StringIndexOutOfBoundsException ex2) {
                SilentWorker.bonusRewarP = "No";
                SilentWorker.bonoRPFin = " - ";
            }
            try {
                final String bonuBTC = SilentWorker.driver.findElement(By.id("bonus_container_fp_bonus")).getText().substring(13, 17);
                SilentWorker.bonoBTCFin = SilentWorker.driver.findElement(By.id("bonus_span_fp_bonus")).getText().substring(0, 2) + " Hrs";
                if (bonuBTC.contains("F")) {
                    SilentWorker.bonusFreeBTC = bonuBTC.replace("F", "");
                }
                else if (bonuBTC.contains("1000")) {
                    SilentWorker.bonusFreeBTC = bonuBTC + "%";
                }
                else {
                    SilentWorker.bonusFreeBTC = bonuBTC;
                }
            }
            catch (NoSuchElementException ex) {
                SilentWorker.bonusFreeBTC = "No";
                SilentWorker.bonoBTCFin = " - ";
            }
            final double balanceParse = Double.parseDouble(SilentWorker.balanceBTC) * 1.0E8;
            final int balance2 = (int)balanceParse;
            this.model.setValueAt(String.format("%,d", balance2), this.selector, 2);
            this.balanceRollArray.add(0);
            this.model.setValueAt(String.format("%,d", SilentWorker.balancePuntosParse), this.selector, 3);
            this.model.setValueAt(0, this.selector, 5);
            this.model.setValueAt(0, this.selector, 6);
            this.model.setValueAt(SilentWorker.bonusRewarP, this.selector, 8);
            this.model.setValueAt(SilentWorker.bonoRPFin, this.selector, 9);
            this.model.setValueAt(SilentWorker.bonusFreeBTC, this.selector, 11);
            this.model.setValueAt(SilentWorker.bonoBTCFin, this.selector, 12);
            this.model.setValueAt(hora, this.selector, 13);
            if (SilentWorker.driver.findElement(By.id("multi_acct_same_ip")).isDisplayed()) {
                this.model.setValueAt(" IP Compartida", this.selector, 14);
            }
            else {
                this.model.setValueAt(" Esperando siguiente ronda", this.selector, 14);
            }
            this.balanceTotalArray[this.selector] = (int)balanceParse;
            SilentWorker.driver.quit();
            SilentWorker.driver.findElement(By.linkText("REWARDS")).click();
        }
    }
    
    protected void checkBonusPoint() throws InterruptedException {
        this.model.setValueAt(" Verificando bonos...", this.selector, 14);
        SilentWorker.driver.findElement(By.linkText("FREE BTC")).click();
        try {
            final String bonu = SilentWorker.driver.findElement(By.xpath("//div[@id='bonus_container_free_points']/p/span")).getText().substring(0, 3).trim();
            SilentWorker.bonoRPFin = SilentWorker.driver.findElement(By.id("bonus_span_free_points")).getText().substring(0, 2) + " Hrs";
            if (bonu.contains("e")) {
                SilentWorker.bonusRewarP = bonu.replace("e", "") + "RP";
            }
            else {
                SilentWorker.bonusRewarP = bonu + " RP";
            }
        }
        catch (NoSuchElementException e) {
            if (this.checkBonusRP) {
                this.activarBonusPuntos();
            }
            else {
                SilentWorker.bonusRewarP = "No";
                SilentWorker.bonoRPFin = " - ";
            }
        }
        catch (StringIndexOutOfBoundsException e2) {
            SilentWorker.bonusRewarP = " - ";
            SilentWorker.bonoRPFin = " - ";
        }
    }
    
    protected String checkBonusFreeBTC() throws InterruptedException {
        SilentWorker.driver.findElement(By.linkText("FREE BTC")).click();
        try {
            final String bonuBTC = SilentWorker.driver.findElement(By.id("bonus_container_fp_bonus")).getText().substring(13, 17);
            SilentWorker.bonoBTCFin = SilentWorker.driver.findElement(By.id("bonus_span_fp_bonus")).getText().substring(0, 2) + " Hrs";
            if (bonuBTC.contains("F")) {
                SilentWorker.bonusFreeBTC = bonuBTC.replace("F", "");
            }
            else if (bonuBTC.contains("1000")) {
                SilentWorker.bonusFreeBTC = bonuBTC + "%";
            }
            else {
                SilentWorker.bonusFreeBTC = bonuBTC;
            }
        }
        catch (NoSuchElementException e) {
            if (this.checkBonusBTC) {
                this.activarBonusFreeBTC();
            }
            else {
                SilentWorker.bonusFreeBTC = "No";
                SilentWorker.bonoBTCFin = " - ";
            }
        }
        catch (StringIndexOutOfBoundsException e2) {
            SilentWorker.bonusFreeBTC = " - ";
            SilentWorker.bonoBTCFin = " - ";
        }
        return SilentWorker.bonusFreeBTC;
    }
    
    protected void activarBonusPuntos() throws InterruptedException {
        Thread.sleep(2000L);
        try {
            SilentWorker.driver.findElement(By.linkText("Got it!")).click();
        }
        catch (NoSuchElementException ex) {}
        if (this.finalPuntos >= 12 && this.finalPuntos < 120) {
            this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_1')\"]", SilentWorker.bonoRPFin);
            this.finalPuntos -= 12;
            SilentWorker.bonusRewarP = "1 RP";
        }
        Label_0466: {
            switch (this.tipoBono[0]) {
                case 0: {
                    if (this.finalPuntos >= 1200) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_100')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 1200;
                        SilentWorker.bonusRewarP = "100 RP";
                        break;
                    }
                    if (this.finalPuntos >= 600) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_50')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 600;
                        SilentWorker.bonusRewarP = "50 RP";
                        break;
                    }
                    if (this.finalPuntos >= 300) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_25')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 300;
                        SilentWorker.bonusRewarP = "25 RP";
                        break;
                    }
                    if (this.finalPuntos >= 120) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_10')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 120;
                        SilentWorker.bonusRewarP = "10 RP";
                        break;
                    }
                    SilentWorker.bonoRPFin = " - ";
                    SilentWorker.bonusRewarP = "No";
                    break;
                }
                case 1: {
                    if (this.finalPuntos >= 600) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_50')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 600;
                        SilentWorker.bonusRewarP = "50 RP";
                        break;
                    }
                    if (this.finalPuntos >= 120) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_10')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 120;
                        SilentWorker.bonusRewarP = "10 RP";
                        break;
                    }
                    SilentWorker.bonoRPFin = " - ";
                    SilentWorker.bonusRewarP = "No";
                    break;
                }
                case 2: {
                    if (this.finalPuntos >= 300) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_25')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 300;
                        SilentWorker.bonusRewarP = "25 RP";
                        break Label_0466;
                    }
                    if (this.finalPuntos >= 120) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_10')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 120;
                        SilentWorker.bonusRewarP = "10 RP";
                        break Label_0466;
                    }
                    SilentWorker.bonoRPFin = " - ";
                    SilentWorker.bonusRewarP = "No";
                    break Label_0466;
                }
                case 3: {
                    if (this.finalPuntos >= 120) {
                        this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div", "//button[@onclick=\"RedeemRPProduct('free_points_10')\"]", SilentWorker.bonoRPFin);
                        this.finalPuntos -= 120;
                        SilentWorker.bonusRewarP = "10 RP";
                        break;
                    }
                    SilentWorker.bonoRPFin = " - ";
                    SilentWorker.bonusRewarP = "No";
                    break;
                }
            }
        }
    }
    
    protected void activarBonusFreeBTC() throws InterruptedException {
        this.model.setValueAt(" Activando bonos", this.selector, 14);
        Thread.sleep(2000L);
        try {
            SilentWorker.driver.findElement(By.linkText("Got it!")).click();
        }
        catch (NoSuchElementException ex) {}
        if (this.finalPuntos >= 32 && this.finalPuntos < 160) {
            this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_10')\"]", SilentWorker.bonoBTCFin);
            this.finalPuntos -= 32;
            SilentWorker.bonusFreeBTC = "10%";
        }
        switch (this.tipoBono[1]) {
            case 0: {
                if (this.finalPuntos >= 3200) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_1000')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 3200;
                    SilentWorker.bonusFreeBTC = "1000%";
                    break;
                }
                if (this.finalPuntos >= 1600) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_500')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 1600;
                    SilentWorker.bonusFreeBTC = "500%";
                    break;
                }
                if (this.finalPuntos >= 320) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_100')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 320;
                    SilentWorker.bonusFreeBTC = "100%";
                    break;
                }
                if (this.finalPuntos >= 160) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 160;
                    SilentWorker.bonusFreeBTC = "50%";
                    break;
                }
                SilentWorker.bonoBTCFin = " - ";
                SilentWorker.bonusFreeBTC = "No";
                break;
            }
            case 1: {
                if (this.finalPuntos >= 1600) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_500')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 1600;
                    SilentWorker.bonusFreeBTC = "500%";
                    break;
                }
                if (this.finalPuntos >= 320) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_100')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 320;
                    SilentWorker.bonusFreeBTC = "100%";
                    break;
                }
                if (this.finalPuntos >= 160) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 160;
                    SilentWorker.bonusFreeBTC = "50%";
                    break;
                }
                SilentWorker.bonoBTCFin = " - ";
                SilentWorker.bonusFreeBTC = "No";
                break;
            }
            case 2: {
                if (this.finalPuntos >= 320) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_100')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 320;
                    SilentWorker.bonusFreeBTC = "100%";
                    break;
                }
                if (this.finalPuntos >= 160) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 160;
                    SilentWorker.bonusFreeBTC = "50%";
                    break;
                }
                SilentWorker.bonoBTCFin = " - ";
                SilentWorker.bonusFreeBTC = "No";
                break;
            }
            case 3: {
                if (this.finalPuntos >= 160) {
                    this.activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div", "//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]", SilentWorker.bonoBTCFin);
                    this.finalPuntos -= 160;
                    SilentWorker.bonusFreeBTC = "50%";
                    break;
                }
                SilentWorker.bonoBTCFin = " - ";
                SilentWorker.bonusFreeBTC = "No";
                break;
            }
        }
    }
    
    protected void rollAction() throws IOException, InterruptedException, NoSuchSessionException {
        SilentWorker.driver.findElement(By.linkText("FREE BTC")).click();
        this.model.setValueAt(" Resolviendo Captcha... Intento " + this.captchaCount, this.selector, 14);
        if (this.captchaCount == 4) {
            this.model.setValueAt("CAPTCHA_TIMEOUT", this.selector, 14);
            this.now = LocalDateTime.now().plusMinutes(1L);
            this.nextRollArray[this.selector] = this.now;
            SilentWorker.driver.quit();
        }
        boolean invi;
        try {
            invi = SilentWorker.driver.findElement(By.className("grecaptcha-badge")).isDisplayed();
        }
        catch (NoSuchElementException e2) {
            invi = false;
        }
        System.out.println(invi);
        final TwoCaptchaFreeBTC prueba = new TwoCaptchaFreeBTC(this.proxies.get(this.proxySelector).getProxy(), this.proxies.get(this.proxySelector).getPuerto(), invi);
        SilentWorker.responseToken = TwoCaptchaFreeBTC.Tokenizer();
        System.out.println(SilentWorker.responseToken);
        if (SilentWorker.responseToken.contains("ERROR_WRONG_USER_KEY")) {
            this.model.setValueAt(" 2Captcha API Key invalido", this.selector, 14);
            this.killDriver();
        }
        else if (SilentWorker.responseToken.contains("ERROR_RECAPTCHA_TIMEOUT") & this.captchaCount >= 1) {
            do {
                final int range = this.model.getRowCount() - 0 + 1;
                this.proxySelector = (int)(Math.random() * range + 0.0);
            } while (this.proxySelector == this.selector);
            ++this.captchaCount;
            this.rollAction();
        }
        else if (SilentWorker.responseToken.contains("ERROR_PROXY_BANNED")) {
            do {
                final int range = this.model.getRowCount() - 0 + 1;
                this.proxySelector = (int)(Math.random() * range + 0.0);
            } while (this.proxySelector == this.selector);
            ++this.captchaCount;
            this.rollAction();
        }
        final JavascriptExecutor jse = (JavascriptExecutor)SilentWorker.driver;
        if (invi) {
            System.out.println("Captcha invisible");
            jse.executeScript("document.getElementById('g-recaptcha-response').innerHTML='" + SilentWorker.responseToken + "';", new Object[0]);
            jse.executeScript("window.submit_fp_rec_inv();", new Object[0]);
        }
        else {
            jse.executeScript("document.getElementById('g-recaptcha-response').value='" + SilentWorker.responseToken + "';", new Object[0]);
            try {
                SilentWorker.driver.findElement(By.linkText("Got it!")).click();
            }
            catch (NoSuchElementException ex) {}
            try {
                SilentWorker.driver.findElement(By.id("free_play_form_button")).click();
            }
            catch (ElementNotInteractableException ex2) {}
        }
        SilentWorker.balanceBTC = SilentWorker.driver.findElement(By.id("balance")).getText();
        Thread.sleep(2000L);
        if (SilentWorker.driver.findElement(By.id("free_play_error")).isDisplayed()) {
            if (SilentWorker.driver.findElement(By.id("free_play_error")).getText().equals("Sorry, this IP address has been blocked. If you are using a proxy, VPN or anonymization service, please turn it off before claiming free bitcoins.")) {
                this.ipBaned();
            }
            else if (SilentWorker.driver.findElement(By.id("free_play_error")).getText().equals("Captcha is incorrect or has expired. Please try again.")) {
                ++this.captchaCount;
                this.rollAction();
            }
            else if (SilentWorker.driver.findElement(By.id("free_play_error")).getText().contains("You need to verify your email before you can play the FREE BTC game.")) {
                this.model.setValueAt(" Necesita verificar email", this.selector, 14);
                this.nextRollArray[this.selector] = LocalDateTime.now().plusDays(2L);
                SilentWorker.driver.quit();
            }
        }
        try {
            final WebDriverWait wait = new WebDriverWait(SilentWorker.driver, 5L);
            final WebElement webElement = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(By.id("free_play_result")));
        }
        catch (Exception e) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            SilentWorker.driver.navigate().refresh();
            this.rollAction();
        }
        SilentWorker.postRoll = SilentWorker.driver.findElement(By.id("winnings")).getText();
        SilentWorker.rewardPointRoll = SilentWorker.driver.findElement(By.id("fp_reward_points_won")).getText();
        final int rp = Integer.parseInt(SilentWorker.rewardPointRoll);
        this.finalPuntos += rp;
        this.model.setValueAt("¡Roll listo!", this.selector, 14);
        this.model.setValueAt(" Esperando siguiente ronda", this.selector, 14);
    }
    
    protected void postear() throws InterruptedException, NoSuchSessionException {
        this.now = LocalDateTime.now().plus(1L, (TemporalUnit)ChronoUnit.HOURS);
        final String hora = this.now.format(DateTimeFormatter.ofPattern("hh:mm a"));
        double finall = 0.0;
        final double balanceParse = Double.parseDouble(SilentWorker.balanceBTC);
        if (!SilentWorker.postRoll.isEmpty()) {
            final double balroll = Double.parseDouble(SilentWorker.postRoll);
            finall = (balanceParse + balroll) * 1.0E8;
            final int balance2 = (int)finall;
            this.model.setValueAt(String.format("%,d", balance2), this.selector, 2);
            this.balanceRoll = SilentWorker.postRoll.replace(".", "0");
            this.model.setValueAt(Integer.parseInt(this.balanceRoll), this.selector, 5);
        }
        else {
            finall = balanceParse * 1.0E8;
            this.model.setValueAt(0, this.selector, 5);
        }
        this.model.setValueAt(String.format("%,d", this.finalPuntos), this.selector, 3);
        this.model.setValueAt(SilentWorker.rewardPointRoll, this.selector, 6);
        this.model.setValueAt(SilentWorker.bonoRPFin, this.selector, 9);
        this.model.setValueAt(SilentWorker.bonoBTCFin, this.selector, 12);
        this.model.setValueAt(SilentWorker.bonusRewarP, this.selector, 8);
        this.model.setValueAt(SilentWorker.bonusFreeBTC, this.selector, 11);
        this.model.setValueAt(hora, this.selector, 13);
        this.balanceRollArray.add(Integer.parseInt(this.balanceRoll));
        this.nextRollArray[this.selector] = this.now;
        this.balanceTotalArray[this.selector] = (int)finall;
        this.killDriver();
    }
    
    protected void ipBaned() throws NoSuchSessionException {
        int balance2;
        if (!SilentWorker.balanceBTC.isEmpty()) {
            final double balanceParse = Double.parseDouble(SilentWorker.balanceBTC) * 1.0E8;
            balance2 = (int)balanceParse;
            this.balanceTotalArray[this.selector] = (int)balanceParse;
            this.model.setValueAt(String.format("%,d", balance2), this.selector, 2);
        }
        else {
            final double balanceParse = 0.0;
            balance2 = (int)balanceParse;
            this.balanceTotalArray[this.selector] = (int)balanceParse;
            this.model.setValueAt(0, this.selector, 2);
        }
        this.now = LocalDateTime.now().plus(2L, (TemporalUnit)ChronoUnit.DAYS);
        this.balanceRollArray.add(0);
        this.model.setValueAt(String.format("%,d", balance2), this.selector, 2);
        this.model.setValueAt(String.valueOf(this.finalPuntos), this.selector, 3);
        this.model.setValueAt("0", this.selector, 4);
        this.model.setValueAt(0, this.selector, 5);
        this.model.setValueAt(0, this.selector, 6);
        this.model.setValueAt("-", this.selector, 8);
        this.model.setValueAt("-", this.selector, 9);
        this.model.setValueAt("-", this.selector, 13);
        this.model.setValueAt(" IP Baneada", this.selector, 14);
        this.nextRollArray[this.selector] = this.now;
        SilentWorker.driver.quit();
        SilentWorker.driver.findElement(By.id("free_play_form_button")).click();
    }
    
    protected void freeRollPlay() throws NoSuchSessionException, InterruptedException, IOException {
        SilentWorker.driver.findElement(By.linkText("FREE BTC")).click();
        this.model.setValueAt(" Intentando Roll gratis", this.selector, 14);
        try {
            SilentWorker.driver.findElement(By.className("g-recaptcha"));
            this.rollAction();
        }
        catch (NoSuchElementException e) {
            this.sinCaptpcha();
        }
    }
    
    private void sinCaptpcha() throws NoSuchSessionException, InterruptedException, IOException {
        try {
            SilentWorker.driver.findElement(By.linkText("Got it!")).click();
        }
        catch (NoSuchElementException ex) {}
        SilentWorker.driver.findElement(By.id("free_play_form_button")).click();
        try {
            final WebDriverWait wait = new WebDriverWait(SilentWorker.driver, 5L);
            final WebElement webElement = (WebElement)wait.until((Function)ExpectedConditions.visibilityOfElementLocated(By.id("free_play_result")));
        }
        catch (Exception e) {
            SilentWorker.driver.navigate().refresh();
            this.rollAction();
        }
        SilentWorker.postRoll = SilentWorker.driver.findElement(By.id("winnings")).getText();
        SilentWorker.rewardPointRoll = SilentWorker.driver.findElement(By.id("fp_reward_points_won")).getText();
        final int rp = Integer.parseInt(SilentWorker.rewardPointRoll);
        this.finalPuntos += rp;
        this.model.setValueAt(" �Roll listo!", this.selector, 14);
        this.model.setValueAt(" Esperando siguiente ronda.", this.selector, 14);
        this.postear();
    }
    
    public void killDriver() throws InterruptedException, NoSuchSessionException {
        SilentWorker.driver.quit();
    }
    
    public void activarBonos(final String banner, final String bono, String tipoBono) {
        SilentWorker.driver.findElement(By.linkText("REWARDS")).click();
        SilentWorker.driver.findElement(By.xpath(banner)).click();
        SilentWorker.driver.findElement(By.xpath(bono)).click();
        tipoBono = "24 Hrs";
    }
    
    static {
        SilentWorker.balancePuntos = "";
        SilentWorker.balancePuntosParse = 0;
        SilentWorker.balanceBTC = "";
        SilentWorker.bonoRPFin = " - ";
        SilentWorker.bonoBTCFin = " - ";
        SilentWorker.postRoll = "";
        SilentWorker.rewardPointRoll = "";
    }
}
