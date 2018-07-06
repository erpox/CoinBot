// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control;

import java.util.Iterator;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.ArrayList;

public class SaveBalances
{
    public void agregarBalance(final ArrayList<Balances> arraylist, final File fichero) {
        try {
            final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, false));
            oos.writeObject(arraylist);
            oos.close();
        }
        catch (IOException ex) {
            Logger.getLogger(SaveBalances.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Balances> retornaBalances(final File fichero) throws IOException, ClassNotFoundException {
        final ArrayList<Balances> estesi = new ArrayList<Balances>();
        ArrayList<Balances> arraylist2 = new ArrayList<Balances>();
        final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        try {
            while (true) {
                arraylist2 = (ArrayList<Balances>)ois.readObject();
                for (final Balances b : arraylist2) {
                    estesi.add(new Balances(b.getPerfil(), b.getBalance()));
                }
            }
        }
        catch (EOFException e) {
            ois.close();
            return estesi;
        }
    }
}
