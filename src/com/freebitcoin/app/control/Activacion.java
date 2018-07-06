// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control;

import com.freebitcoin.app.vistas.LoginFrame;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Activacion
{
    private static String cpuIDsN;
    private static String hddSN;
    private static String biosIDsN;
    private static String uddIDsN;
    private static String motherIDsN;
    
    private void cpuID() {
        try {
            final Process processCpuID = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
            processCpuID.getOutputStream().close();
            final Scanner sc = new Scanner(processCpuID.getInputStream());
            sc.next();
            Activacion.cpuIDsN = sc.next();
        }
        catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NoSuchElementException ex2) {
            Activacion.cpuIDsN = "No hay CPU";
        }
    }
    
    private void hardDiskDriveID() {
        try {
            final Process processHDD = Runtime.getRuntime().exec(new String[] { "wmic", "DISKDRIVE", "get", "SerialNumber" });
            processHDD.getOutputStream().close();
            final Scanner sc = new Scanner(processHDD.getInputStream());
            sc.next();
            Activacion.hddSN = sc.next();
        }
        catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NoSuchElementException ex2) {
            Activacion.hddSN = "No hay HDD";
        }
    }
    
    private void biosID() {
        try {
            final Process processBIOS = Runtime.getRuntime().exec(new String[] { "wmic", "bios", "get", "SerialNumber" });
            processBIOS.getOutputStream().close();
            final Scanner sc = new Scanner(processBIOS.getInputStream());
            sc.next();
            Activacion.biosIDsN = sc.next();
        }
        catch (NoSuchElementException ex2) {
            Activacion.biosIDsN = "No hay serial BIOS";
        }
        catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void uddID() {
        try {
            final Process processBIOS = Runtime.getRuntime().exec(new String[] { "wmic", "csproduct", "get", "UUID" });
            processBIOS.getOutputStream().close();
            final Scanner sc = new Scanner(processBIOS.getInputStream());
            sc.next();
            Activacion.uddIDsN = sc.next();
        }
        catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NoSuchElementException ex2) {
            Activacion.uddIDsN = "No hay UUID";
        }
    }
    
    private void motherID() {
        try {
            final Process processMotherID = Runtime.getRuntime().exec(new String[] { "wmic", "baseboard", "get", "SerialNumber" });
            processMotherID.getOutputStream().close();
            final Scanner sc = new Scanner(processMotherID.getInputStream());
            try {
                sc.next();
                Activacion.motherIDsN = sc.next();
            }
            catch (NoSuchElementException ex2) {
                Activacion.motherIDsN = "No hay serial MB";
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(final String[] args) throws IOException, InterruptedException {
        final Activacion acti = new Activacion();
        acti.cpuID();
        acti.hardDiskDriveID();
        acti.biosID();
        acti.uddID();
        acti.motherID();
        final String[] systemInfo = { Activacion.cpuIDsN, Activacion.hddSN, Activacion.biosIDsN, Activacion.uddIDsN, Activacion.motherIDsN };
        Thread.sleep(8000L);
        new LoginFrame(systemInfo).setVisible(true);
    }
}
