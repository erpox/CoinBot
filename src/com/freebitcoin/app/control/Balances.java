// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control;

import java.io.Serializable;

public class Balances implements Serializable
{
    private static final long serialVersionUID = 1185940963547149254L;
    private String perfil;
    private int balance;
    
    public Balances(final String perfil, final int balance) {
        this.perfil = perfil;
        this.balance = balance;
    }
    
    public String getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(final String perfil) {
        this.perfil = perfil;
    }
    
    public int getBalance() {
        return this.balance;
    }
    
    public void setBalance(final int balance) {
        this.balance = balance;
    }
}
