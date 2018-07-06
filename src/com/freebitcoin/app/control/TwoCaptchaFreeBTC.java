// 
// Decompiled by Procyon v0.5.30
// 
package com.freebitcoin.app.control;

import com.twocaptcha.api.ProxyType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Reader;
import java.io.FileReader;
import java.util.Properties;
import com.twocaptcha.api.TwoCaptchaService;

public class TwoCaptchaFreeBTC {

    private static String responseToken;
    private static String apiKey;
    private static String googleKey;
    private static String pageUrl;
    private static TwoCaptchaService service;
    private static String proxyUser;
    private static String proxyPass;
    private static String proxy;
    private static String puerto;
    private static String puertoProp;
    private Properties prop;
    private final String PROP_PATH = "C:\\Program Files\\GT Tools\\CoinBot FreeBitcoin\\config.properties";
    private static boolean sendProxy;
    Boolean invi;

    public TwoCaptchaFreeBTC(final String proxy, final String puerto, final Boolean invi) throws FileNotFoundException {
        this.prop = new Properties();
        TwoCaptchaFreeBTC.googleKey = "6LeGfGIUAAAAAEyUovGUehv82L-IdNRusaYFEm5b";        
        TwoCaptchaFreeBTC.pageUrl = "https://freebitco.in/";
        TwoCaptchaFreeBTC.proxy = proxy.trim();
        TwoCaptchaFreeBTC.puerto = puerto.trim();

        try {
            this.prop.load(new FileReader("C:\\Program Files\\GT Tools\\CoinBot FreeBitcoin\\config.properties"));
            TwoCaptchaFreeBTC.apiKey = this.prop.getProperty("TwoCaptchaKey");
            TwoCaptchaFreeBTC.proxyUser = this.prop.getProperty("proxyUser");
            TwoCaptchaFreeBTC.proxyPass = this.prop.getProperty("proxyPass");
            TwoCaptchaFreeBTC.sendProxy = Boolean.valueOf(this.prop.getProperty("sendProxy"));
            TwoCaptchaFreeBTC.puertoProp = this.prop.getProperty("proxyPuerto");
        } catch (IOException ex) {
            Logger.getLogger(TwoCaptchaFreeBTC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String Tokenizer() {
        
        if (TwoCaptchaFreeBTC.sendProxy) {
            
            if (TwoCaptchaFreeBTC.proxyUser.equals("Usuario") && !TwoCaptchaFreeBTC.puertoProp.equals(TwoCaptchaFreeBTC.puerto)) {
                TwoCaptchaFreeBTC.service = new TwoCaptchaService(TwoCaptchaFreeBTC.apiKey, TwoCaptchaFreeBTC.googleKey, TwoCaptchaFreeBTC.pageUrl, TwoCaptchaFreeBTC.proxy, TwoCaptchaFreeBTC.puerto, ProxyType.HTTP);
            } else if (TwoCaptchaFreeBTC.proxy.contains("0.0.0.0")) {
                TwoCaptchaFreeBTC.service = new TwoCaptchaService(TwoCaptchaFreeBTC.apiKey, TwoCaptchaFreeBTC.googleKey, TwoCaptchaFreeBTC.pageUrl);
            } else if (!TwoCaptchaFreeBTC.proxyUser.equals("Usuario") && TwoCaptchaFreeBTC.puertoProp.equals(TwoCaptchaFreeBTC.puerto)) {
                TwoCaptchaFreeBTC.service = new TwoCaptchaService(TwoCaptchaFreeBTC.apiKey, TwoCaptchaFreeBTC.googleKey, TwoCaptchaFreeBTC.pageUrl, TwoCaptchaFreeBTC.proxy, TwoCaptchaFreeBTC.puerto, TwoCaptchaFreeBTC.proxyUser, TwoCaptchaFreeBTC.proxyPass, ProxyType.HTTP);
            }
        } else {
            TwoCaptchaFreeBTC.service = new TwoCaptchaService(TwoCaptchaFreeBTC.apiKey, TwoCaptchaFreeBTC.googleKey, TwoCaptchaFreeBTC.pageUrl);
        }
        try {
            return TwoCaptchaFreeBTC.responseToken = TwoCaptchaFreeBTC.service.solveCaptcha();
        } catch (InterruptedException e) {
            System.out.println("ERROR case 1");
            e.printStackTrace();
            return TwoCaptchaFreeBTC.responseToken;
        } catch (IOException e2) {
            System.out.println("ERROR case 2");
            e2.printStackTrace();
            return TwoCaptchaFreeBTC.responseToken;
        } catch (Exception e3) {
            return TwoCaptchaFreeBTC.responseToken;
        }
    }
}
