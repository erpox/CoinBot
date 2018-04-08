package com.freebitcoin.app.control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaloCaptchas {

    private String activeCaptch2;
    private final Properties prop = new Properties();
    private final String PROP_PATH = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Roaming\\GT Tools\\config.properties";

    public String getCaptchaBalance() {

        try {
            prop.load(new FileReader(PROP_PATH));
            activeCaptch2 = prop.getProperty("activeCaptcha");

            switch (activeCaptch2) {
                case "0":
                    return twoCaptcha();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaloCaptchas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaloCaptchas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String twoCaptcha() {
        String saldo;
        try {
            String ApiKey = prop.getProperty("TwoCaptchaKey");;
            String urlString = "http://2captcha.com/res.php?key=" + ApiKey + "&action=getbalance";
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            Scanner sc = new Scanner(is);
            //System.out.println(sc.next());
            saldo = sc.next().substring(0, 5);
            System.out.println(saldo);

            return saldo;

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
            return saldo = "ERROR";

        } catch (MalformedURLException ex) {
            Logger.getLogger(SaloCaptchas.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger
                    .getLogger(SaloCaptchas.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return saldo = "ERROR";
    }
}
