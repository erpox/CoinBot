// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.miners;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.TimeoutException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.NoSuchSessionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import org.openqa.selenium.WebDriver;
import javax.swing.SwingWorker;

public class MineroRetiros extends SwingWorker<Boolean, String>
{
    private static WebDriver driver;
    private final String perfil;
    private final int selector;
    private final DefaultTableModel model;
    private final File file;
    private final boolean BackGroundStatus;
    private int[] balanceTotalArray;
    private int[] procesando;
    private String tipoRetiro;
    private String balanceBTC;
    private String modoRetiro;
    private int rawRetiro;
    private int montoRetiro;
    private String wallet;
    ArrayList<Integer> arrayFees;
    
    public MineroRetiros(final int selector, final DefaultTableModel model, final boolean backGroundStatus, final int[] balanceTotalArray, final ArrayList<Integer> arrayFees, final int[] procesando, final String tipoRetiro, final String modoRetiro, final int rawRetiro) {
        this.perfil = (String)model.getValueAt(selector, 1);
        this.wallet = (String)model.getValueAt(selector, 2);
        this.selector = selector;
        this.model = model;
        this.BackGroundStatus = backGroundStatus;
        this.balanceTotalArray = balanceTotalArray;
        this.arrayFees = arrayFees;
        this.procesando = procesando;
        this.tipoRetiro = tipoRetiro;
        this.modoRetiro = modoRetiro;
        this.rawRetiro = rawRetiro;
        this.file = new File("C:\\Program Files\\GT Tools\\CoinBot FreeBitcoin\\geckodriver.exe");
        procesando[3] = 1;
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
        try {
            this.loadDriver();
            this.getBalance();
        }
        catch (NoSuchSessionException ex) {
            Logger.getLogger(MineroRetiros.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
        }
        catch (WebDriverException ex2) {
            this.model.setValueAt("Ocurrio un error al retirar", this.selector, 14);
            Logger.getLogger(MineroRetiros.class.getName()).log(Level.SEVERE, null, (Throwable)ex2);
            MineroRetiros.driver.quit();
        }
        catch (Exception e) {
            this.model.setValueAt("Ocurrio un error al retirar", this.selector, 14);
            Logger.getLogger(MineroRetiros.class.getName()).log(Level.SEVERE, null, e);
            MineroRetiros.driver.quit();
        }
        this.procesando[3] = 0;
        return false;
    }
    
    private void loadDriver() throws WebDriverException, InterruptedException {
        this.model.setValueAt(" Cargando perfil... ", this.selector, 14);
        System.setProperty("webdriver.gecko.driver", this.file.getAbsolutePath());
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        final ProfilesIni profile = new ProfilesIni();
        final FirefoxProfile myprofile = profile.getProfile(this.perfil);
        final FirefoxOptions options = new FirefoxOptions().setProfile(myprofile);
        options.addPreference("signon.autologin.proxy", true);
        if (this.BackGroundStatus) {
            options.addArguments(new String[] { "--headless" });
        }
        this.model.setValueAt(" Abriendo navegador...", this.selector, 14);
        MineroRetiros.driver = (WebDriver)new FirefoxDriver(options);
        MineroRetiros.driver.manage().window().maximize();
        this.model.setValueAt(" Cargando https://freedoge.co.in", this.selector, 14);
        try {
            MineroRetiros.driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
            MineroRetiros.driver.get("https://freedoge.co.in");
        }
        catch (TimeoutException ex) {
            MineroRetiros.driver.quit();
            this.loadDriver();
        }
    }
    
    private void getBalance() {
        this.balanceBTC = MineroRetiros.driver.findElement(By.id("balance")).getText();
        final double balanceParse = Double.parseDouble(this.balanceBTC);
        final int balance = (int)(balanceParse * 1.0E8);
        this.model.setValueAt(String.format("%,d", balance), this.selector, 3);
        System.out.println("Balance: " + balance);
        final String modoRetiro = this.modoRetiro;
        switch (modoRetiro) {
            case "porcentual": {
                this.montoRetiro = balance * this.rawRetiro / 100;
                System.out.println("montoRetiro porcentual: " + this.montoRetiro);
                break;
            }
            case "Residual": {
                this.montoRetiro = balance - this.rawRetiro;
                System.out.println("montoRetiro Residual: " + this.montoRetiro);
                break;
            }
            case "Todo": {
                this.montoRetiro = balance;
                System.out.println("montoRetiro Todo: " + this.montoRetiro);
                break;
            }
        }
    }
    
    private void retiroLento() throws InterruptedException {
        MineroRetiros.driver.findElement(By.xpath("//div[@id='deposit_withdraw_container']/div/div/div[2]")).click();
        MineroRetiros.driver.switchTo().activeElement();
        Thread.sleep(2000L);
        MineroRetiros.driver.findElement(By.id("manual_withdraw_option_link")).click();
        final String slowFees = MineroRetiros.driver.findElement(By.xpath("//div[@id='manual_withdraw_option']/div/div[2]/div[8]/span")).getText();
        final double feesParse = Double.parseDouble(slowFees) * 1.0E8;
        final int fees = (int)feesParse;
        final double monto = (this.montoRetiro - fees) / 1.0E8;
        System.out.println(monto);
        if (monto > 3.0E-4) {
            String cantidadRetiro = String.format("%.8f", monto);
            if (cantidadRetiro.contains(",")) {
                cantidadRetiro = cantidadRetiro.replace(",", ".");
            }
            System.out.println(cantidadRetiro);
            MineroRetiros.driver.findElement(By.id("withdrawal_amount")).sendKeys(new CharSequence[] { cantidadRetiro });
            MineroRetiros.driver.findElement(By.id("manual_withdraw_btc_add")).sendKeys(new CharSequence[] { this.wallet });
            try {
                MineroRetiros.driver.findElement(By.linkText("Got it!")).click();
            }
            catch (NoSuchElementException e) {
                System.out.println("El banner no esta activo");
            }
            MineroRetiros.driver.findElement(By.id("withdrawal_button")).click();
            Thread.sleep(5000L);
            final int montoRetParse = (int)(monto * 1.0E8);
            this.balanceTotalArray[this.selector] = montoRetParse;
            this.model.setValueAt(montoRetParse, this.selector, 5);
            this.arrayFees.add(fees);
            this.balanceBTC = MineroRetiros.driver.findElement(By.id("balance")).getText();
            final double balanceParse = Double.parseDouble(this.balanceBTC);
            final int balance = (int)(balanceParse * 1.0E8);
            this.model.setValueAt(balance, this.selector, 8);
            MineroRetiros.driver.quit();
            this.model.setValueAt(" Retiro Exitoso", this.selector, 14);
        }
        else {
            MineroRetiros.driver.quit();
            this.model.setValueAt(" Balance insuficiente", this.selector, 14);
        }
    }
    
    private void retiroRapido() throws InterruptedException {
        MineroRetiros.driver.findElement(By.xpath("//div[@id='deposit_withdraw_container']/div/div/div[2]")).click();
        MineroRetiros.driver.switchTo().activeElement();
        Thread.sleep(2000L);
        MineroRetiros.driver.findElement(By.id("instant_withdraw_option_link")).click();
        final String instantFees = MineroRetiros.driver.findElement(By.xpath("//div[@id='instant_withdraw_option']/div/div[2]/div[8]/span")).getText();
        final double feesParse = Double.parseDouble(instantFees) * 1.0E8;
        final int fees = (int)feesParse;
        final double monto = (this.montoRetiro - fees) / 1.0E8;
        if (monto > 3.0E-4) {
            String cantidadRetiro = String.format("%.8f", monto);
            if (cantidadRetiro.contains(",")) {
                cantidadRetiro = cantidadRetiro.replace(",", ".");
            }
            MineroRetiros.driver.findElement(By.id("withdrawal_amount")).sendKeys(new CharSequence[] { cantidadRetiro });
            MineroRetiros.driver.findElement(By.id("instant_withdraw_btc_add")).sendKeys(new CharSequence[] { this.wallet });
            try {
                MineroRetiros.driver.findElement(By.linkText("Got it!")).click();
            }
            catch (NoSuchElementException e) {
                System.out.println("El banner no esta activo");
            }
            MineroRetiros.driver.findElement(By.id("instant_withdrawal_button")).click();
            Thread.sleep(5000L);
            final int montoRetParse = (int)(monto * 1.0E8);
            this.balanceTotalArray[this.selector] = montoRetParse;
            this.model.setValueAt(montoRetParse, this.selector, 5);
            this.arrayFees.add(fees);
            this.balanceBTC = MineroRetiros.driver.findElement(By.id("balance")).getText();
            final double balanceParse = Double.parseDouble(this.balanceBTC);
            final int balance = (int)(balanceParse * 1.0E8);
            this.model.setValueAt(balance, this.selector, 8);
            MineroRetiros.driver.quit();
            this.model.setValueAt(" Retiro Exitoso", this.selector, 14);
            return;
        }
        MineroRetiros.driver.quit();
        this.model.setValueAt(" Balance insuficiente", this.selector, 14);
        throw new NoSuchSessionException(" Saldo insuficiente");
    }
}
