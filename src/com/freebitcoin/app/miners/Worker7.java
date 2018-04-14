package com.freebitcoin.app.miners;

import com.freebitcoin.app.control.Proxies;
import com.freebitcoin.app.control.TwoCaptchaFreeBTC;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Worker7 extends SwingWorker<Boolean, String> {

    private static String bonusRewarP;
    private static String bonusFreeBTC;
    private static String balancePuntos = "";
    private static int balancePuntosParse = 0;
    private static String balanceBTC = "";
    private static String bonoRPFin = " - ";
    private static String bonoBTCFin = " - ";
    private static String postRoll = "";
    private static String rewardPointRoll = "";
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
    private int captchaCount = 1,
            proxySelector;
    private final String activeCaptchastatus;

    public Worker7(String perfil, int selector, DefaultTableModel model,
            boolean backGroundStatus, LocalDateTime[] nextRollArray,
            ArrayList<Integer> balanceRollArray, int[] balanceTotalArray,
            boolean checkBonusRP, boolean checkBonusBTC, ArrayList<Proxies> proxies, String activeCaptchastatus) throws IOException {

        this.perfil = perfil;
        this.selector = selector;
        this.proxySelector = selector;
        this.model = model;
        this.BackGroundStatus = backGroundStatus;
        this.nextRollArray = nextRollArray;
        this.balanceRollArray = balanceRollArray;
        this.balanceTotalArray = balanceTotalArray;
        this.checkBonusRP = checkBonusRP;
        this.checkBonusBTC = checkBonusBTC;
        this.proxies = proxies;
        this.activeCaptchastatus = activeCaptchastatus;
        this.file = new File("C:\\Program Files\\GT Tools\\geckodriver.exe");
    }

    @Override
    protected Boolean doInBackground() throws Exception {

        try {

            Inicializar(perfil);
            loadSite();
            checkBonusPoint();
            checkBonusFreeBTC();
            //rollAction();
            freeRollPlay();
            postear();

            return false;
        } catch (NoSuchSessionException ex) {
            return false;
        } catch (WebDriverException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            model.setValueAt("Ha ocurrido un error", selector, 11);
            now = LocalDateTime.now().plusMinutes(2);
            nextRollArray[selector] = now;
            driver.quit();
            return false;
        } catch (Exception e) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            model.setValueAt("Ha ocurrido un error", selector, 11);
            now = LocalDateTime.now().plusMinutes(2);
            nextRollArray[selector] = now;
            driver.quit();
            return false;
        }
    }

    @Override
    protected void done() {
    }

    protected void Inicializar(String Perfil) throws WebDriverException, InterruptedException {
        model.setValueAt("Cargando perfil... ", selector, 11);
        System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile(Perfil);

        FirefoxOptions options = new FirefoxOptions().setProfile(myprofile);

        options.addPreference("signon.autologin.proxy", true);
        if (BackGroundStatus) {
            options.addArguments("--headless");
        }
        model.setValueAt("Abriendo navegador...", selector, 11);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        model.setValueAt("Cargando https://freebitco.in/", selector, 11);
        try {
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.get("https://freebitco.in");
        } catch (TimeoutException ex) {
            // Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            driver.quit();
            Inicializar(perfil);
        }
    }

    protected void loadSite() throws InterruptedException, NoSuchSessionException, WebDriverException {
        balanceBTC = driver.findElement(By.id("balance")).getText();
        driver.findElement(By.linkText("REWARDS")).click();
        balancePuntos = driver.findElement(By.xpath("//div[@id='rewards_tab']/div[2]/div/div[2]")).getText();
        String newStr = balancePuntos.replace(",", "").trim();
        balancePuntosParse = Integer.parseInt(newStr);
        finalPuntos = balancePuntosParse;
        driver.findElement(By.linkText("FREE BTC")).click();

        if (driver.findElement(By.id("time_remaining")).isDisplayed()) {

            String timeRemaining = driver.findElement(By.id("time_remaining")).getText();
            String hora = "";
            try {
                int minutos = Integer.parseInt(timeRemaining.substring(0, 2).trim());
                hora = LocalTime.now().plus(minutos + 2, ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("hh:mm a"));
                now = LocalDateTime.now().plus(minutos, ChronoUnit.MINUTES);
            } catch (NumberFormatException e) {
                hora = LocalTime.now().plus(5, ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("hh:mm a"));
                now = LocalDateTime.now().plus(5, ChronoUnit.MINUTES);
            }
            nextRollArray[selector] = now;
            try {
                String bonu = driver.findElement(By.xpath("//div[@id='bonus_container_free_points']/p/span")).getText().substring(0, 3).trim(); //bonus de puntos
                bonoRPFin = driver.findElement(By.id("bonus_span_free_points")).getText().substring(0, 2) + " Hrs";
                if (bonu.contains("e")) {
                    bonusRewarP = bonu.replace("e", "") + "RP";
                } else {
                    bonusRewarP = bonu + " RP";
                }

            } catch (NoSuchElementException ex) {
                //Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                bonusRewarP = "No";
            } catch (StringIndexOutOfBoundsException ex) {
                bonusRewarP = "No";
                bonoRPFin = " - ";
            }

            try {
                String bonuBTC = driver.findElement(By.id("bonus_container_fp_bonus")).getText().substring(13, 17);
                bonoBTCFin = driver.findElement(By.id("bonus_span_fp_bonus")).getText().substring(0, 2) + " Hrs";
                if (bonuBTC.contains("F")) {
                    bonusFreeBTC = bonuBTC.replace("F", "");
                } else if (bonuBTC.contains("1000")) {
                    bonusFreeBTC = bonuBTC + "%";
                } else {
                    bonusFreeBTC = bonuBTC;
                }

            } catch (NoSuchElementException ex) {
                // Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                bonusFreeBTC = "No";
                bonoBTCFin = " - ";
            }

            double balanceParse = Double.parseDouble(balanceBTC) * 100000000;
            model.setValueAt((int) balanceParse, selector, 2);

            balanceRollArray.add(0);
            model.setValueAt(balancePuntosParse, selector, 3);
            model.setValueAt(0, selector, 4);
            model.setValueAt(0, selector, 5);
            model.setValueAt(bonusRewarP, selector, 6);
            model.setValueAt(bonoRPFin, selector, 7);
            model.setValueAt(bonusFreeBTC, selector, 8);
            model.setValueAt(bonoBTCFin, selector, 9);
            model.setValueAt(hora, selector, 10);
            model.setValueAt("¡Aun no es la hora del Roll!", selector, 11);

            balanceTotalArray[selector] = (int) balanceParse;
            driver.quit();
            driver.findElement(By.linkText("REWARDS")).click();
        }
    }

    protected void checkBonusPoint() throws InterruptedException {
        model.setValueAt("Verificando bonos...", selector, 11);
        driver.findElement(By.linkText("FREE BTC")).click();
        try {
            String bonu = driver.findElement(By.xpath("//div[@id='bonus_container_free_points']/p/span")).getText().substring(0, 3).trim(); //bonus de puntos
            bonoRPFin = driver.findElement(By.id("bonus_span_free_points")).getText().substring(0, 2) + " Hrs";
            if (bonu.contains("e")) {
                bonusRewarP = bonu.replace("e", "") + "RP";
            } else {
                bonusRewarP = bonu + " RP";
            }
        } catch (NoSuchElementException e) {
            //    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            if (checkBonusRP) {
                activarBonusPuntos();
            } else {
                bonusRewarP = "No";
                bonoRPFin = " - ";
            }
        }
    }

    protected String checkBonusFreeBTC() throws InterruptedException {
        driver.findElement(By.linkText("FREE BTC")).click();
        try {
            String bonuBTC = driver.findElement(By.id("bonus_container_fp_bonus")).getText().substring(13, 17);
            bonoBTCFin = driver.findElement(By.id("bonus_span_fp_bonus")).getText().substring(0, 2) + " Hrs";
            if (bonuBTC.contains("F")) {
                bonusFreeBTC = bonuBTC.replace("F", "");
            } else if (bonuBTC.contains("1000")) {
                bonusFreeBTC = bonuBTC + "%";
            } else {
                bonusFreeBTC = bonuBTC;
            }
        } catch (NoSuchElementException e) {
            //     Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            if (checkBonusBTC && bonusRewarP.contains("100")) {
                activarBonusFreeBTC();
            } else {
                bonusFreeBTC = "No";
                bonoBTCFin = " - ";
            }
        }
        return bonusFreeBTC;
    }

    protected String activarBonusPuntos() throws InterruptedException {
        System.out.println("Activando puntos");
        Thread.sleep(2000);
        try {
            driver.findElement(By.linkText("Got it!")).click();
        } catch (NoSuchElementException e) {

            System.out.println("El banner no esta activo");
        }
        if (finalPuntos >= 12 && finalPuntos < 120) {
            model.setValueAt("Activando Bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[6]/div")).click();//Pestaña Reward Points
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('free_points_1')\"]")).click();
            finalPuntos = finalPuntos - 12;
            bonoRPFin = "24 Hrs";
            return bonusRewarP = "1 RP";

        } else if (finalPuntos >= 120 && finalPuntos < 600) {
            model.setValueAt("Activando Bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[6]/div")).click();
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('free_points_10')\"]")).click();
            finalPuntos = finalPuntos - 120;
            bonoRPFin = "24 Hrs";
            return bonusRewarP = "10 RP";

        } else if (finalPuntos >= 600 && finalPuntos < 1200) {
            model.setValueAt("Activando Bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[6]/div")).click();
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('free_points_50')\"]")).click();
            finalPuntos = finalPuntos - 600;
            bonoRPFin = "24 Hrs";
            return bonusRewarP = "50 RP";

        } else if (finalPuntos >= 1200) {
            model.setValueAt("Activando Bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[6]/div")).click();
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('free_points_100')\"]")).click();
            finalPuntos = finalPuntos - 1200;
            bonoRPFin = "24 Hrs";
            return bonusRewarP = "100 RP";
        } else {
            bonoRPFin = " - ";
            return bonusRewarP = "No";
        }
    }

    protected String activarBonusFreeBTC() throws InterruptedException {

        Thread.sleep(2000);
        try {
            driver.findElement(By.linkText("Got it!")).click();
        } catch (NoSuchElementException e) {

            System.out.println("El banner no esta activo");
        }

        if (finalPuntos >= 32 && finalPuntos < 160) { //Bonus de 10%
            model.setValueAt("Activando bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[4]/div")).click();//Pestaña Free BTC bonus
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('fp_bonus_10')\"]")).click();
            finalPuntos = finalPuntos - 32;
            bonoBTCFin = "24 Hrs";
            return bonusFreeBTC = "10%";

        } else if (finalPuntos >= 160 && finalPuntos < 320) {//Bonus de 50%
            model.setValueAt("Activando bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[4]/div")).click();//Pestaña Free BTC bonus
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]")).click();
            finalPuntos = finalPuntos - 160;
            bonoBTCFin = "24 Hrs";
            return bonusFreeBTC = "50%";

        } else if (finalPuntos >= 320 && finalPuntos < 1600) {//Bonus100%
            model.setValueAt("Activando bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[4]/div")).click();//Pestaña Free BTC bonus
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('fp_bonus_100')\"]")).click();
            finalPuntos = finalPuntos - 320;
            bonoBTCFin = "24 Hrs";
            return bonusFreeBTC = "100%";

        } else if (finalPuntos >= 1600 && finalPuntos < 3200) {
            model.setValueAt("Activando bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[4]/div")).click();//Pestaña Free BTC bonus
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('fp_bonus_500')\"]")).click();
            finalPuntos = finalPuntos - 1600;
            bonoBTCFin = "24 Hrs";
            return bonusFreeBTC = "500%";
        } else if (finalPuntos >= 3200) {
            model.setValueAt("Activando bonos", selector, 11);
            driver.findElement(By.linkText("REWARDS")).click();
            driver.findElement(By.xpath("//div[@id='rewards_tab']/div[4]/div/div[4]/div")).click();//Pestaña Free BTC bonus
            driver.findElement(By.xpath("//button[@onclick=\"RedeemRPProduct('fp_bonus_1000')\"]")).click();
            finalPuntos = finalPuntos - 3200;
            bonoBTCFin = "24 Hrs";
            return bonusFreeBTC = "1000%";
        }
        bonoBTCFin = " - ";
        return bonusFreeBTC = "No";
    }

    protected void rollAction() throws IOException, InterruptedException, NoSuchSessionException {
        model.setValueAt("Resolviendo Captcha... Intento " + captchaCount, selector, 11);

        if (captchaCount == 4) {
            model.setValueAt("CAPTCHA_TIMEOUT", selector, 11);
            now = LocalDateTime.now().plusMinutes(2);
            nextRollArray[selector] = now;
            driver.quit();
        }

        driver.findElement(By.linkText("FREE BTC")).click();

        TwoCaptchaFreeBTC prueba = new TwoCaptchaFreeBTC(proxies.get(proxySelector).getProxy(), proxies.get(proxySelector).getPuerto());
        responseToken = prueba.Tokenizer();
        if (responseToken.contains("ERROR_WRONG_USER_KEY")) {
            model.setValueAt("2Captcha API Key invalido", selector, 11);
            killDriver();
        } else if (responseToken.contains("ERROR_RECAPTCHA_TIMEOUT") & captchaCount >= 2) {
            do {
                int range = (model.getRowCount() - 0) + 1;
                proxySelector = (int) (Math.random() * range + 0);
                System.out.println("Muchos intentos usando proxy en: " + proxySelector);
            } while (proxySelector == selector);
            captchaCount++;
            rollAction();
        } else if (responseToken.contains("ERROR_PROXY_BANNED")) {
            do {
                int range = (model.getRowCount() - 0) + 1;
                proxySelector = (int) (Math.random() * range + 0);
                System.out.println("Usando proxy en: " + proxySelector);
            } while (proxySelector == selector);
            captchaCount++;
            rollAction();
        }

        System.out.println(responseToken);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('g-recaptcha-response').value='" + responseToken + "';");

        try {
            driver.findElement(By.linkText("Got it!")).click();
        } catch (NoSuchElementException e) {

            System.out.println("El banner no esta activo");
        }

        driver.findElement(By.id("free_play_form_button")).click(); // Roll
        balanceBTC = driver.findElement(By.id("balance")).getText();
        Thread.sleep(2000);
        if (driver.findElement(By.id("free_play_error")).isDisplayed()) {
            if (driver.findElement(By.id("free_play_error")).getText().
                    equals("Sorry, this IP address has been blocked. If"
                            + " you are using a proxy, VPN or anonymization "
                            + "service, please turn it off before claiming "
                            + "free bitcoins.")) {
                ipBaned();
            } else if (driver.findElement(By.id("free_play_error")).getText().
                    equals("Captcha is incorrect or has expired. Please try again.")) {
                System.out.print("Captcha incorrecto");
                captchaCount++;
                rollAction();
            } else if (driver.findElement(By.id("free_play_error")).getText().contains("You "
                    + "need to verify your email before you can play the FREE BTC game.")) {
                model.setValueAt("Necesita verificar email", selector, 11);
                nextRollArray[selector] = LocalDateTime.now().plusDays(2);
                driver.quit();
            }
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("free_play_result")));
        } catch (Exception e) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            driver.navigate().refresh();
            rollAction();
        }
        postRoll = driver.findElement(By.id("winnings")).getText();
        rewardPointRoll = driver.findElement(By.id("fp_reward_points_won")).getText();
        int rp = Integer.parseInt(rewardPointRoll);
        finalPuntos = finalPuntos + rp;
        model.setValueAt("¡Roll listo!", selector, 11);
        model.setValueAt("Esperando siguiente ronda", selector, 11);
        postear();
    }

    protected void postear() throws InterruptedException, NoSuchSessionException {

        now = LocalDateTime.now().plus(1, ChronoUnit.HOURS);
        String hora = now.format(DateTimeFormatter.ofPattern("hh:mm a"));
        double finall = 0.0;
        double balanceParse = Double.parseDouble(balanceBTC);
        if (!postRoll.isEmpty()) {
            double balroll = Double.parseDouble(postRoll);
            finall = (balanceParse + balroll) * 100000000;
            model.setValueAt((int) finall, selector, 2);
            balanceRoll = postRoll.replace(".", "0");
            model.setValueAt(Integer.parseInt(balanceRoll), selector, 4);

        } else {
            finall = balanceParse * 100000000;
            model.setValueAt(0, selector, 4);
        }

        model.setValueAt(finalPuntos, selector, 3);
        model.setValueAt(rewardPointRoll, selector, 5);
        model.setValueAt(bonoRPFin, selector, 7);
        model.setValueAt(bonoBTCFin, selector, 9);
        model.setValueAt(bonusRewarP, selector, 6);
        model.setValueAt(bonusFreeBTC, selector, 8);

        model.setValueAt(hora, selector, 10);

        balanceRollArray.add(Integer.parseInt(balanceRoll));
        nextRollArray[selector] = now;
        balanceTotalArray[selector] = (int) finall;

        killDriver();
    }

    protected void ipBaned() throws NoSuchSessionException {

        double balanceParse;
        if (!balanceBTC.isEmpty()) {
            balanceParse = Double.parseDouble(balanceBTC) * 100000000;
            balanceTotalArray[selector] = (int) balanceParse;
            model.setValueAt((int) balanceParse, selector, 2);
        } else {
            balanceParse = 0;
            balanceTotalArray[selector] = (int) balanceParse;
            model.setValueAt(0, selector, 2);
        }
        now = LocalDateTime.now().plus(2, ChronoUnit.DAYS);
        balanceRollArray.add(0);
        model.setValueAt((int) balanceParse, selector, 2);
        model.setValueAt(0, selector, 3);
        model.setValueAt(0, selector, 4);
        model.setValueAt(0, selector, 5);
        model.setValueAt(bonusRewarP, selector, 6);
        model.setValueAt(bonoRPFin, selector, 7);
        model.setValueAt(bonusFreeBTC, selector, 8);
        model.setValueAt(bonoBTCFin, selector, 9);
        model.setValueAt("-", selector, 10);
        model.setValueAt("IP Baneada", selector, 11);
        nextRollArray[selector] = now;
        driver.quit();
        driver.findElement(By.id("free_play_form_button")).click();
    }

    protected void freeRollPlay() throws NoSuchSessionException, InterruptedException, IOException {
        driver.findElement(By.linkText("FREE BTC")).click();
        model.setValueAt("Intentando Roll gratis", selector, 11);
        try {
            driver.findElement(By.className("g-recaptcha"));
            rollAction();
            //  Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchElementException e) {
            // Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            sinCaptpcha();

        }
    }

    private void sinCaptpcha() throws NoSuchSessionException, InterruptedException, IOException {

        try {
            driver.findElement(By.linkText("Got it!")).click();
        } catch (NoSuchElementException e) {

            System.out.println("El banner no esta activo");
        }

        driver.findElement(By.id("free_play_form_button")).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("free_play_result")));
        } catch (Exception e) {
            // Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            driver.navigate().refresh();
            rollAction();
        }
        postRoll = driver.findElement(By.id("winnings")).getText();
        rewardPointRoll = driver.findElement(By.id("fp_reward_points_won")).getText();
        int rp = Integer.parseInt(rewardPointRoll);
        finalPuntos = finalPuntos + rp;
        model.setValueAt("¡Roll listo!", selector, 11);
        model.setValueAt("Esperando siguiente ronda. Roll gratis.", selector, 11);
        postear();
    }

    public void killDriver() throws InterruptedException, NoSuchSessionException {
        driver.quit();
    }
}
