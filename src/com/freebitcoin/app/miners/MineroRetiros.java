/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freebitcoin.app.miners;

import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class MineroRetiros {

    private static WebDriver driver;
    private final String perfil;
    private final int selector;
    private final DefaultTableModel model;
    private final File file;
    private final boolean BackGroundStatus;

    private LocalDateTime now;
    private LocalDateTime[] nextRollArray;
    private int[] balanceTotalArray;
    private int[] procesando;
    private String tipoRetiro;
    private String balanceBTC;
    private String modoRetiro;
    private int rawRetiro;
    private int montoRetiro;
    private String wallet;

    public MineroRetiros(int selector, DefaultTableModel model,
            boolean backGroundStatus, LocalDateTime[] nextRollArray, int[] balanceTotalArray,
            int[] procesando, String tipoRetiro, String modoRetiro, int rawRetiro) {

        this.perfil = (String) model.getValueAt(selector, 1);
        this.wallet = (String) model.getValueAt(selector, 2);
        this.selector = selector;
        this.model = model;
        this.BackGroundStatus = backGroundStatus;
        this.nextRollArray = nextRollArray;
        this.balanceTotalArray = balanceTotalArray;
        this.procesando = procesando;
        this.tipoRetiro = tipoRetiro;
        this.file = new File("C:\\Program Files\\GT Tools\\geckodriver.exe");
        procesando[3] = 1;
    }

    public boolean run() {
        try {
            getBalance();
            switch (tipoRetiro) {
                case "Slow":
                    retiroLento();
                    break;
                case "Instant":
                    retiroRapido();
                    break;
            }

        } catch (NoSuchSessionException ex) {

        } catch (WebDriverException ex) {

        } catch (Exception e) {

        }
        return false;
    }

    private void loadDriver() throws WebDriverException, InterruptedException {

        model.setValueAt(" Cargando perfil... ", selector, 14);
        System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile(perfil);

        FirefoxOptions options = new FirefoxOptions().setProfile(myprofile);

        options.addPreference("signon.autologin.proxy", true);
        if (BackGroundStatus) {
            options.addArguments("--headless");
        }
        model.setValueAt(" Abriendo navegador...", selector, 14);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        model.setValueAt(" Cargando https://freebitco.in/", selector, 14);
        try {
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.get("https://freebitco.in");
        } catch (TimeoutException ex) {
            // Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            driver.quit();
            loadDriver();
        }
    }

    private void getBalance() {
        balanceBTC = driver.findElement(By.id("balance")).getText();
        double balanceParse = Double.parseDouble(balanceBTC);
        int balance = (int) balanceParse * 100000000;
        model.setValueAt(String.format("%,d", balance), selector, 3);

        switch (modoRetiro) {
            case "porcentual":
                montoRetiro = (balance * rawRetiro) / 100;
                break;
            case "Residual":
                montoRetiro = balance - rawRetiro;
                break;
            case "Todo":
                montoRetiro = balance;
        }

    }

    private void retiroLento() {
        driver.findElement(By.xpath("//div[@id='deposit_withdraw_container']/div/div/div[2]")).click();
        driver.findElement(By.id("manual_withdraw_option_link")).click();
        String slowFees = driver.findElement(By.className("manual_withdraw_fee")).getText();
        double feesParse = Double.parseDouble(slowFees) * 100000000;
        int fees = (int) feesParse;
        double monto = (montoRetiro - fees) / 100000000;
        if (monto > 0.00030000) {
            driver.findElement(By.className("withdrawal_amount")).sendKeys(String.valueOf(monto));
            driver.findElement(By.className("withdraw_btc_address")).sendKeys(wallet);
            driver.findElement(By.id("withdrawal_button")).click();
        } else {
            driver.quit();
            model.setValueAt("Balance insuficiente", selector, 9);
            throw new NoSuchSessionException("Saldo insuficiente");
        }
    }

    private void retiroRapido() {
        driver.findElement(By.xpath("//div[@id='deposit_withdraw_container']/div/div/div[2]")).click();
        driver.findElement(By.id("instant_withdraw_option_link")).click();
        String slowFees = driver.findElement(By.className("instant_withdraw_fee")).getText();
        double feesParse = Double.parseDouble(slowFees) * 100000000;
        int fees = (int) feesParse;
        double monto = (montoRetiro - fees) / 100000000;
        if (monto > 0.00030000) {
            driver.findElement(By.className("instant_withdrawal_amount")).sendKeys(String.valueOf(monto));
            driver.findElement(By.className("withdraw_btc_address")).sendKeys(wallet);
            driver.findElement(By.id("instant_withdrawal_button")).click();
        } else {
            driver.quit();
            model.setValueAt("Balance insuficiente", selector, 9);
            throw new NoSuchSessionException("Saldo insuficiente");
        }
    }
}
