package com.freebitcoin.app.control;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CapMonsterControl {

    String res;

    public String Tokenizer() {

        try {
            String urlString = "http://127.0.0.3/in.php?"
                    + "key=6bb66728c813db2c10301d064aea5fea"
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

                String urlString2 = "http://127.0.0.3/res.php?key=6bb66728c813db2c10301d064aea5fea&action=get&id=" + id;
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
