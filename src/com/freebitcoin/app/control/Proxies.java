/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freebitcoin.app.control;

public class Proxies {
    
    String proxy;
    String puerto;

    public Proxies(String proxy, String puerto) {
        this.proxy = proxy;
        this.puerto = puerto;
    }

    public String getProxy() {
        return proxy;
    }

    public String getPuerto() {
        return puerto;
    }

    @Override
    public String toString() {
        return "Proxies{" + "proxy=" + proxy + ", puerto=" + puerto + '}';
    }
    
}
