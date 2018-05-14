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

public class Worker11 {

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
    private int[] procesando;
    private int[] tipoBono;
    private int[] ticketCount;
    private boolean comprarTicke;

    public Worker11(int selector, DefaultTableModel model,
            boolean backGroundStatus, LocalDateTime[] nextRollArray,
            ArrayList<Integer> balanceRollArray, int[] balanceTotalArray,
            ArrayList<Proxies> proxies, int[] procesando, int[] tipoBono, int[] ticketCount) throws IOException {

        this.perfil = (String) model.getValueAt(selector, 1);
        this.selector = selector;
        this.proxySelector = selector;
        this.model = model;
        this.BackGroundStatus = backGroundStatus;
        this.nextRollArray = nextRollArray;
        this.balanceRollArray = balanceRollArray;
        this.balanceTotalArray = balanceTotalArray;
        this.checkBonusRP = (Boolean) model.getValueAt(selector, 7);
        this.checkBonusBTC = (Boolean) model.getValueAt(selector, 10);
        this.proxies = proxies;
        this.procesando = procesando;
        this.file = new File("C:\\Program Files\\GT Tools\\geckodriver.exe");
        this.tipoBono = tipoBono;
        this.comprarTicke = (boolean) model.getValueAt(selector, 15);
        this.ticketCount = ticketCount;
        procesando[10] = 1;
    }

    public Boolean run() throws Exception {

        try {

            Inicializar(perfil);
            loadSite();
            if (comprarTicke) {
                compraTickets();
            }
            checkBonusPoint();
            checkBonusFreeBTC();
            freeRollPlay();
            postear();
            procesando[10] = 0;
        } catch (NoSuchSessionException ex) {
            procesando[10] = 0;
        } catch (WebDriverException ex) {
            procesando[10] = 0;
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            model.setValueAt(" Ha ocurrido un error", selector, 14);
            now = LocalDateTime.now().plusMinutes(1);
            nextRollArray[selector] = now;
            driver.quit();
        } catch (Exception e) {
            procesando[10] = 0;
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            model.setValueAt(" Ha ocurrido un error", selector, 14);
            now = LocalDateTime.now().plusMinutes(1);
            nextRollArray[selector] = now;
            driver.quit();
        }
        return false;
    }

    protected void compraTickets() {
        if (ticketCount[selector] == 0) {
            String cantidadTickets = String.valueOf(tipoBono[2]);
            driver.findElement(By.linkText("LOTTERY")).click();
            driver.findElement(By.id("lottery_tickets_purchase_count")).clear();
            driver.findElement(By.id("lottery_tickets_purchase_count")).sendKeys(cantidadTickets);
            try {
                driver.findElement(By.linkText("Got it!")).click();
            } catch (NoSuchElementException e) {

                System.out.println("El banner no esta activo");
            }
            driver.findElement(By.id("purchase_lottery_tickets_button")).click();
            driver.findElement(By.linkText("FREE BTC")).click();
            ticketCount[selector] = 1;
        }
    }

    protected void Inicializar(String Perfil) throws WebDriverException, InterruptedException {

        model.setValueAt(" Cargando perfil... ", selector, 14);
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
            Inicializar(perfil);
        }
    }

    protected void loadSite() throws InterruptedException, NoSuchSessionException, WebDriverException {
        try {
            balanceBTC = driver.findElement(By.id("balance")).getText();
        } catch (NoSuchElementException e) {
            driver.quit();
            model.setValueAt(" Sesión no iniciada", selector, 14);
            throw new NoSuchSessionException("No inicio");
        }
        String porcentaje = driver.findElement(By.id("fp_bonus_req_completed")).getText().substring(0, 6);
        model.setValueAt(porcentaje, selector, 4);
        driver.findElement(By.linkText("REWARDS")).click();
        balancePuntos = driver.findElement(By.xpath("//div[@id='rewards_tab']/div[2]/div/div[2]")).getText();
        String newStr = balancePuntos.replace(",", "").trim();
        try {
            balancePuntosParse = Integer.parseInt(newStr);
        } catch (NumberFormatException e) {
            balancePuntosParse = 1000;
        }
        finalPuntos = balancePuntosParse;
        driver.findElement(By.linkText("FREE BTC")).click();

        if (driver.findElement(By.id("time_remaining")).isDisplayed()) {

            String timeRemaining = driver.findElement(By.id("time_remaining")).getText();
            String hora = "";
            try {
                int minutos = Integer.parseInt(timeRemaining.substring(0, 2).trim());
                hora = LocalTime.now().plus(minutos, ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("hh:mm a"));
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
            int balance2 = (int) balanceParse;
            model.setValueAt(String.format("%,d", balance2), selector, 2);

            balanceRollArray.add(0);
            model.setValueAt(String.format("%,d", balancePuntosParse), selector, 3);
            model.setValueAt(0, selector, 5);
            model.setValueAt(0, selector, 6);
            model.setValueAt(bonusRewarP, selector, 8);
            model.setValueAt(bonoRPFin, selector, 9);
            model.setValueAt(bonusFreeBTC, selector, 11);
            model.setValueAt(bonoBTCFin, selector, 12);
            model.setValueAt(hora, selector, 13);
            if (driver.findElement(By.id("multi_acct_same_ip")).isDisplayed()) {

                model.setValueAt(" IP Compartida", selector, 14);
            } else {
                model.setValueAt(" Esperando siguiente ronda", selector, 14);
            }

            balanceTotalArray[selector] = (int) balanceParse;
            driver.quit();
            driver.findElement(By.linkText("REWARDS")).click();
        }
    }

    protected void checkBonusPoint() throws InterruptedException {
        model.setValueAt(" Verificando bonos...", selector, 14);

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
        } catch (StringIndexOutOfBoundsException e) {
            bonusRewarP = " - ";
            bonoRPFin = " - ";
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
            System.out.println(bonusRewarP);
            System.out.println(checkBonusBTC);
            if (checkBonusBTC && bonusRewarP.contains("100")) {
                activarBonusFreeBTC();
            } else {
                bonusFreeBTC = "No";
                bonoBTCFin = " - ";
            }
        } catch (StringIndexOutOfBoundsException e) {
            bonusFreeBTC = " - ";
            bonoBTCFin = " - ";
        }
        return bonusFreeBTC;
    }

    protected void activarBonusPuntos() throws InterruptedException {
        System.out.println(" Activando puntos");
        Thread.sleep(2000);
        try {
            driver.findElement(By.linkText("Got it!")).click();
        } catch (NoSuchElementException e) {

            System.out.println("El banner no esta activo");
        }

        if (finalPuntos >= 12 && finalPuntos < 120) {
            activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div",
                    "//button[@onclick=\"RedeemRPProduct('free_points_1')\"]", bonoRPFin);
            finalPuntos = finalPuntos - 12;
            bonusRewarP = "1 RP";
        }

        switch (tipoBono[0]) {

            case 0:

                if (finalPuntos >= 1200) {

                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div",
                            "//button[@onclick=\"RedeemRPProduct('free_points_100')\"]", bonoRPFin);
                    finalPuntos = finalPuntos - 1200;
                    bonusRewarP = "100 RP";

                } else if (finalPuntos >= 600) {
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div",
                            "//button[@onclick=\"RedeemRPProduct('free_points_50')\"]", bonoRPFin);
                    finalPuntos = finalPuntos - 600;
                    bonusRewarP = "50 RP";

                } else if (finalPuntos >= 120) {
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div",
                            "//button[@onclick=\"RedeemRPProduct('free_points_10')\"]", bonoRPFin);
                    finalPuntos = finalPuntos - 120;
                    bonusRewarP = "10 RP";

                } else {
                    bonoRPFin = " - ";
                    bonusRewarP = "No";
                }

                break;

            case 1:

                if (finalPuntos >= 600) {
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div",
                            "//button[@onclick=\"RedeemRPProduct('free_points_50')\"]", bonoRPFin);
                    finalPuntos = finalPuntos - 600;
                    bonusRewarP = "50 RP";
                } else if (finalPuntos >= 120) {
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div",
                            "//button[@onclick=\"RedeemRPProduct('free_points_10')\"]", bonoRPFin);
                    finalPuntos = finalPuntos - 120;
                    bonusRewarP = "10 RP";

                } else {
                    bonoRPFin = " - ";
                    bonusRewarP = "No";
                }
                break;

            case 2:

                if (finalPuntos >= 120) {
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[6]/div",
                            "//button[@onclick=\"RedeemRPProduct('free_points_10')\"]", bonoRPFin);
                    finalPuntos = finalPuntos - 120;
                    bonusRewarP = "10 RP";
                } else {
                    bonoRPFin = " - ";
                    bonusRewarP = "No";
                }
        }
    }

    protected void activarBonusFreeBTC() throws InterruptedException {
        model.setValueAt(" Activando bonos", selector, 14);

        Thread.sleep(2000);
        try {
            driver.findElement(By.linkText("Got it!")).click();
        } catch (NoSuchElementException e) {

            System.out.println("El banner no esta activo");
        }

        if (finalPuntos >= 32 && finalPuntos < 160) { //Bonus de 10%
            activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                    "//button[@onclick=\"RedeemRPProduct('fp_bonus_10')\"]", bonoBTCFin);
            finalPuntos = finalPuntos - 32;
            bonusFreeBTC = "10%";
        }

        switch (tipoBono[1]) {

            case 0:

                if (finalPuntos >= 3200) {
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_1000')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 3200;
                    bonusFreeBTC = "1000%";
                } else if (finalPuntos >= 1600) {
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_500')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 1600;
                    bonusFreeBTC = "500%";

                } else if (finalPuntos >= 320) {//Bonus100%
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_100')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 320;
                    bonusFreeBTC = "100%";

                } else if (finalPuntos >= 160) {//Bonus de 50%
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 160;
                    bonusFreeBTC = "50%";

                } else {
                    bonoBTCFin = " - ";
                    bonusFreeBTC = "No";
                }
                break;

            case 1:
                if (finalPuntos >= 1600) {
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_500')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 1600;
                    bonusFreeBTC = "500%";

                } else if (finalPuntos >= 320) {//Bonus100%
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_100')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 320;
                    bonusFreeBTC = "100%";

                } else if (finalPuntos >= 160) {//Bonus de 50%
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 160;
                    bonusFreeBTC = "50%";

                } else {
                    bonoBTCFin = " - ";
                    bonusFreeBTC = "No";
                }
                break;

            case 2:

                if (finalPuntos >= 320) {//Bonus100%
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_100')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 320;
                    bonusFreeBTC = "100%";

                } else if (finalPuntos >= 160) {//Bonus de 50%
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 160;
                    bonusFreeBTC = "50%";

                } else {
                    bonoBTCFin = " - ";
                    bonusFreeBTC = "No";
                }
                break;

            case 3:
                if (finalPuntos >= 160) {//Bonus de 50%
                    activarBonos("//div[@id='rewards_tab']/div[4]/div/div[4]/div",
                            "//button[@onclick=\"RedeemRPProduct('fp_bonus_50')\"]", bonoBTCFin);
                    finalPuntos = finalPuntos - 160;
                    bonusFreeBTC = "50%";

                } else {
                    bonoBTCFin = " - ";
                    bonusFreeBTC = "No";
                }
                break;
        }

    }

    protected void rollAction() throws IOException, InterruptedException, NoSuchSessionException {
        model.setValueAt(" Resolviendo Captcha... Intento " + captchaCount, selector, 14);

        if (captchaCount == 4) {
            model.setValueAt("CAPTCHA_TIMEOUT", selector, 14);
            now = LocalDateTime.now().plusMinutes(1);
            nextRollArray[selector] = now;
            driver.quit();
        }

        driver.findElement(By.linkText("FREE BTC")).click();

        TwoCaptchaFreeBTC prueba = new TwoCaptchaFreeBTC(proxies.get(proxySelector).getProxy(), proxies.get(proxySelector).getPuerto());
        responseToken = prueba.Tokenizer();

        if (responseToken.contains("ERROR_WRONG_USER_KEY")) {
            model.setValueAt(" 2Captcha API Key invalido", selector, 14);
            killDriver();
        } else if (responseToken.contains("ERROR_RECAPTCHA_TIMEOUT") & captchaCount >= 1) {

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
        try {
            driver.findElement(By.id("free_play_form_button")).click(); // Roll
        } catch (ElementNotInteractableException e) {
            System.out.println("EL boton de roll no esta interactuable");
        }
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
                model.setValueAt(" Necesita verificar email", selector, 14);
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
        model.setValueAt("¡Roll listo!", selector, 14);
        model.setValueAt(" Esperando siguiente ronda", selector, 14);
    }

    protected void postear() throws InterruptedException, NoSuchSessionException {

        now = LocalDateTime.now().plus(1, ChronoUnit.HOURS);
        String hora = now.format(DateTimeFormatter.ofPattern("hh:mm a"));
        double finall = 0.0;
        double balanceParse = Double.parseDouble(balanceBTC);
        if (!postRoll.isEmpty()) {
            double balroll = Double.parseDouble(postRoll);
            finall = (balanceParse + balroll) * 100000000;
            int balance2 = (int) finall;
            model.setValueAt(String.format("%,d", balance2), selector, 2);
            balanceRoll = postRoll.replace(".", "0");
            model.setValueAt(Integer.parseInt(balanceRoll), selector, 5);

        } else {
            finall = balanceParse * 100000000;
            model.setValueAt(0, selector, 5);
        }

        model.setValueAt(String.format("%,d", finalPuntos), selector, 3);
        model.setValueAt(rewardPointRoll, selector, 6);
        model.setValueAt(bonoRPFin, selector, 9);
        model.setValueAt(bonoBTCFin, selector, 12);
        model.setValueAt(bonusRewarP, selector, 8);
        model.setValueAt(bonusFreeBTC, selector, 11);

        model.setValueAt(hora, selector, 13);

        balanceRollArray.add(Integer.parseInt(balanceRoll));
        nextRollArray[selector] = now;
        balanceTotalArray[selector] = (int) finall;

        killDriver();
    }

    protected void ipBaned() throws NoSuchSessionException {

        double balanceParse;
        int balance2;
        if (!balanceBTC.isEmpty()) {
            balanceParse = Double.parseDouble(balanceBTC) * 100000000;
            balance2 = (int) balanceParse;
            balanceTotalArray[selector] = (int) balanceParse;
            model.setValueAt(String.format("%,d", balance2), selector, 2);
        } else {
            balanceParse = 0;
            balance2 = (int) balanceParse;
            balanceTotalArray[selector] = (int) balanceParse;
            model.setValueAt(0, selector, 2);
        }
        now = LocalDateTime.now().plus(2, ChronoUnit.DAYS);
        balanceRollArray.add(0);

        model.setValueAt(String.format("%,d", balance2), selector, 2);
        model.setValueAt("0", selector, 3);
        model.setValueAt(0, selector, 4);
        model.setValueAt(0, selector, 5);
        model.setValueAt("-", selector, 6);
        model.setValueAt("-", selector, 8);
        model.setValueAt("-", selector, 9);
        model.setValueAt("-", selector, 13);
        model.setValueAt(" IP Baneada", selector, 14);
        nextRollArray[selector] = now;
        driver.quit();
        driver.findElement(By.id("free_play_form_button")).click();
    }

    protected void freeRollPlay() throws NoSuchSessionException, InterruptedException, IOException {
        driver.findElement(By.linkText("FREE BTC")).click();
        model.setValueAt(" Intentando Roll gratis", selector, 14);
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
        model.setValueAt(" ¡Roll listo!", selector, 14);
        model.setValueAt(" Esperando siguiente ronda.", selector, 14);
        postear();
    }

    public void killDriver() throws InterruptedException, NoSuchSessionException {
        driver.quit();
    }

    public void activarBonos(String banner, String bono, String tipoBono) {
        driver.findElement(By.linkText("REWARDS")).click();
        driver.findElement(By.xpath(banner)).click();//Pestaña Reward Points
        driver.findElement(By.xpath(bono)).click();
        tipoBono = "24 Hrs";
    }
}
