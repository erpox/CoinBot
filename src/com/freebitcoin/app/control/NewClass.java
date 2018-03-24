package com.freebitcoin.app.control;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class NewClass {

    String res;
    String proxy;
    String puerto;

    public NewClass(String proxy, String puerto) {
        this.proxy = proxy;
        this.puerto = puerto;
    }

    public void Tokenizer() throws IOException {

        String urlString = "http://127.0.0.3:8888/in.php?"
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
        int n = idStr.length();
        String id = idStr.substring(3, n);
        System.out.println(id);
        int c = 0;
        for (int i = 0; i < 4000; i++) {

            String urlString2 = "http://127.0.0.3:8888/res.php?key=6bb66728c813db2c10301d064aea5fea&action=get&id=" + id;
            URL url2 = new URL(urlString2);
            URLConnection conn2 = url2.openConnection();
            InputStream is2 = conn2.getInputStream();
            Scanner sc2 = new Scanner(is2);
            String token = sc2.next();

            System.out.println(token);

            System.out.println(token);
            res = token.substring(3, token.length());
            if(token.contains("03A")){
                System.exit(0);
            }
            if(token.contains("ERROR_RECAPTCHA_TIMEOUT")){
                Tokenizer();
            }
        }
    }

}
