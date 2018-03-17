/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freebitcoin.app.control;

import com.anti_captcha.Api.NoCaptcha;
import com.anti_captcha.helper.DebugHelper;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class AntiCaptchaControl {

    private String responseToken;
    private static String apiKey;
    private static String proxyUser;
    private static String proxyPass;
    private String proxy;
    private int puerto;
    private String puertoStr;
    private Properties prop = new Properties();
    private final String PROP_PATH = "C:\\Users\\" + System.getProperty("user.name")
            + "\\AppData\\Roaming\\GT Tools\\config.properties";

    public AntiCaptchaControl(String proxy, String puertoStr) {
        this.proxy = proxy;
        this.puertoStr = puertoStr;
        loadProp();

    }

    public String captchaProxy() {
        try {
            DebugHelper.setVerboseMode(true);

            NoCaptcha api = new NoCaptcha();
            api.setClientKey(apiKey);
            api.setWebsiteUrl(new URL("https://freebitco.in/"));
            api.setWebsiteKey("6Lc6zQQTAAAAAD8TgxgC59CXtm1G56QLu8G7Q53K");
            api.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0");

            api.setProxyType(NoCaptcha.ProxyTypeOption.HTTP);
            api.setProxyAddress(proxy);
            api.setProxyPort(puerto);
            api.setProxyLogin(proxyUser);
            api.setProxyPassword(proxyPass);

            if (!api.createTask()) {
                DebugHelper.out(
                        "API v2 send failed. " + api.getErrorMessage(),
                        DebugHelper.Type.ERROR
                );
            } else if (!api.waitForResult()) {
                responseToken = "Could not solve the captcha.";
            } else {
                responseToken = api.getTaskSolution().getGRecaptchaResponse();
            }
        } catch (MalformedURLException | InterruptedException ex) {
            Logger.getLogger(AntiCaptchaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responseToken;

    }

    private void loadProp() {
        try {
            prop.load(new FileReader(PROP_PATH));
            apiKey = prop.getProperty("AntiCaptchaKey");;
            proxyUser = prop.getProperty("proxyUser");
            proxyPass = prop.getProperty("proxyPass");
            puerto = Integer.parseInt(puertoStr);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AntiCaptchaControl.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(AntiCaptchaControl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
