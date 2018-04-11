package com.freebitcoin.app.control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CapMonsterControl {

    private final Properties PROP = new Properties();
    private final String PROP_PATH = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Roaming\\GT Tools\\config.properties";
    String res;
    String ipCapmosnter;
    String User;
    String pass;
    String proxy;
    String puerto;

    public CapMonsterControl(String proxy, String puerto) {
        try {
            PROP.load(new FileReader(PROP_PATH));
            this.User=PROP.getProperty("proxyUser");
            this.pass=PROP.getProperty("proxyPass");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CapMonsterControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CapMonsterControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String Tokenizer() {

        try {
            String urlString = "http://2captcha.com/in.php?"
                    + "key=e09197c6b1439facc9b8d28ca5f99b4e"
                    + "&proxy="+User+":"+pass+"@"+proxy+":"+puerto+";"
                    + "&method=userrecaptcha"
                    + "&googlekey=6Lc6zQQTAAAAAD8TgxgC59CXtm1G56QLu8G7Q53K"
                    + "&pageurl=https://freebitco.in/";

            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            Scanner sc = new Scanner(is);
            String idStr = sc.next();
            System.out.println(idStr);
            String id = idStr.substring(3, idStr.length());

            while (true) {

                String urlString2 = "http://2captcha.com/res.php?key=6bb66728c813db2c10301d064aea5fea&action=get&id=" + id;
                URL url2 = new URL(urlString2);
                URLConnection conn2 = url2.openConnection();
                InputStream is2 = conn2.getInputStream();
                Scanner sc2 = new Scanner(is2);
                String token = sc2.next();
                res = token.substring(3, token.length());

                if (token.contains("READY")) {
                    System.out.println("Waiting for captcha to be solved...");

                } else if (token.contains("03A")) {
                    System.out.println("Response token is:" + res);
                    return res;

                } else if (token.contains("ERROR_RECAPTCHA_TIMEOUT")) {
                    System.out.println("Captcha has timeout");
                    return res;
                }
                Thread.sleep(3000);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CapMonsterControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(CapMonsterControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res = "ERROR";
    }
}
