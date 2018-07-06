// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control.packed;

public class Proxies
{
    String proxy;
    String puerto;
    
    public Proxies(final String proxy, final String puerto) {
        this.proxy = proxy;
        this.puerto = puerto;
    }
    
    public String getProxy() {
        return this.proxy;
    }
    
    public String getPuerto() {
        return this.puerto;
    }
    
    @Override
    public String toString() {
        return "Proxies{proxy=" + this.proxy + ", puerto=" + this.puerto + '}';
    }
}
