// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.net.HttpURLConnection;

public class BtcPrice
{
    String retornaPrecio;
    HttpURLConnection huc;
    
    public BtcPrice() {
        this.Connection();
    }
    
    private void Connection() {
        try {
            final URL url = new URL("https://api.coinmarketcap.com/v1/ticker/bitcoin/");
            final HttpURLConnection huc = this.connect(url);
            huc.connect();
            final String str = this.readBody(huc);
            huc.disconnect();
        }
        catch (UnknownHostException e) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, e);
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex2) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }
    
    private String readBody(final HttpURLConnection huc) {
        try {
            final InputStream is = huc.getInputStream();
            final BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            final StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }
            rd.close();
            this.retornaPrecio = response.substring(132, 138);
            if (response.substring(132, 138).endsWith(".")) {
                this.retornaPrecio = response.substring(132, 138).concat("0");
            }
            return this.retornaPrecio;
        }
        catch (IOException ex) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, ex);
            return this.retornaPrecio = "      ";
        }
    }
    
    private HttpURLConnection connect(final URL url) {
        try {
            (this.huc = (HttpURLConnection)url.openConnection()).setReadTimeout(15000);
            this.huc.setConnectTimeout(15000);
            this.huc.setUseCaches(false);
            HttpURLConnection.setFollowRedirects(true);
            this.huc.addRequestProperty("Host", "api.coinmarketcap.com");
            this.huc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36");
            return this.huc;
        }
        catch (IOException ex) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, ex);
            return this.huc;
        }
    }
    
    public String getRetornaPrecio() {
        return this.retornaPrecio;
    }
}
