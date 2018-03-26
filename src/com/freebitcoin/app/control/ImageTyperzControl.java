package com.freebitcoin.app.control;

import com.imagetyperzapi.ImageTyperzAPI;
import com.twocaptcha.api.ProxyType;
import com.twocaptcha.api.TwoCaptchaService;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageTyperzControl {

    private static String responseToken;
    private String captchaId;
    private String apiKey;
    private final String googleKey;
    private final String pageUrl;
    private static ImageTyperzAPI typerz;
    private static String proxyUser;
    private static String proxyPass;
    private static String proxy;
    private Properties prop = new Properties();
    private final String PROP_PATH = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Roaming\\GT Tools\\config.properties";

    public ImageTyperzControl(String proxy, String puerto) {

        googleKey = "6Lc6zQQTAAAAAD8TgxgC59CXtm1G56QLu8G7Q53K";
        pageUrl = "https://freebitco.in/";
        ImageTyperzControl.proxy = proxy.trim() + ":" + puerto.trim();

        try {
            prop.load(new FileReader(PROP_PATH));
            apiKey = prop.getProperty("imageTyperzKey");
            ImageTyperzControl.proxyUser = prop.getProperty("proxyUser");
            ImageTyperzControl.proxyPass = prop.getProperty("proxyPass");
        } catch (IOException ex) {
            Logger.getLogger(TwoCaptchaFreeBTC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String tokenizer() {
        typerz = new ImageTyperzAPI(apiKey);
        try {
            if (proxyUser.equals("") && proxyPass.equals("")) {

                captchaId = typerz.submit_recaptcha(pageUrl, googleKey, proxy);

            } else if (proxy.contains("0.0.0.0")) {
                captchaId = typerz.submit_recaptcha(pageUrl, googleKey);
            } else {
                System.out.println("usnado proxy con auth");
                captchaId = typerz.submit_recaptcha(pageUrl, googleKey, proxy + ":" + proxyUser + ":" + proxyPass);
            }

            System.out.println("Waiting for recaptcha to be solved ...");
            while (typerz.in_progress(captchaId)) {
                TimeUnit.SECONDS.sleep(5);     // sleep for 10 seconds
            }

            responseToken = typerz.retrieve_captcha(captchaId);
            System.out.println(responseToken);
            return responseToken;

        } catch (Exception ex) {
            Logger.getLogger(ImageTyperzControl.class.getName()).log(Level.SEVERE, null, ex);
            responseToken = "error";
        }
        
        System.out.println(responseToken);
        return responseToken;
    }
}
