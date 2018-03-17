/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freebitcoin.app.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class BtcPrice {

    String retornaPrecio;
     HttpURLConnection huc;
    public BtcPrice() {
        Connection();
    }

    private void Connection() {
        try {
            URL url = new URL("https://api.coinmarketcap.com/v1/ticker/bitcoin/"); //The URL
            HttpURLConnection huc = connect(url); //Connects to the website
            huc.connect(); //Opens the connection
            String str = readBody(huc); //Reads the response
            huc.disconnect(); //Closes
        } catch (UnknownHostException e) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException ex) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String readBody(HttpURLConnection huc) {
        try {
            InputStream is = huc.getInputStream(); //Inputstream
            BufferedReader rd = new BufferedReader(new InputStreamReader(is)); //BufferedReader
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                response.append(line); //Append the line
                response.append('\n'); //and a new line

            }
            rd.close();
            retornaPrecio = response.substring(132, 138);

            if (response.substring(132, 138).endsWith(".")) {
                retornaPrecio = response.substring(132, 138).concat("0");
            }
            return retornaPrecio;
        } catch (IOException ex) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, ex);
            return retornaPrecio = "      ";
        }
    }

    private HttpURLConnection connect(URL url) //Connect to the URL
    {
        try //Connect to the URL
        {
            huc = (HttpURLConnection) url.openConnection(); //Opens connection to the website
            huc.setReadTimeout(15000); //Read timeout - 15 seconds
            huc.setConnectTimeout(15000); //Connecting timeout - 15 seconds
            huc.setUseCaches(false); //Don't use cache
            HttpURLConnection.setFollowRedirects(true); //Follow redirects if there are any
            huc.addRequestProperty("Host", "api.coinmarketcap.com"); //www.fetagracollege.org is the host
            huc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36"); //Chrome user agent
            return huc;
        } catch (IOException ex) {
            Logger.getLogger(BtcPrice.class.getName()).log(Level.SEVERE, null, ex);
            return huc;
        }
    }

    public String getRetornaPrecio() {
        return retornaPrecio;
    }

}
