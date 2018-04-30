package com.freebitcoin.app.control;

import com.freebitcoin.app.vistas.LoginFrame;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.NoSuchElementException;

public class Activacion {

    private static String cpuIDsN;
    private static String hddSN;
    private static String biosIDsN;
    private static String uddIDsN;
    private static String motherIDsN;

    private void cpuID() {

        try {
            Process processCpuID = Runtime.getRuntime().exec(new String[]{"wmic", "cpu", "get", "ProcessorId"});
            processCpuID.getOutputStream().close();
            Scanner sc = new Scanner(processCpuID.getInputStream());
            sc.next();
            cpuIDsN = sc.next();
        } catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NoSuchElementException ex) {
            cpuIDsN = "No hay CPU";
        }
        System.out.println(cpuIDsN);
    }

    private void hardDiskDriveID() {

        try {
            Process processHDD = Runtime.getRuntime().exec(new String[]{"wmic", "DISKDRIVE", "get", "SerialNumber"});
            processHDD.getOutputStream().close();
            Scanner sc = new Scanner(processHDD.getInputStream());
            sc.next();
            hddSN = sc.next();
        } catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchElementException ex) {
           hddSN = "No hay HDD";
        }
        System.out.println(hddSN);
    }

    private void biosID() {

        try {
            Process processBIOS = Runtime.getRuntime().exec(new String[]{"wmic", "bios", "get", "SerialNumber"});
            processBIOS.getOutputStream().close();
            Scanner sc = new Scanner(processBIOS.getInputStream());
            sc.next();
            biosIDsN = sc.next();
        } catch (NoSuchElementException ex) {
            biosIDsN = "No hay serial BIOS";
        } catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(biosIDsN);
    }

    private void uddID() {

        try {
            Process processBIOS = Runtime.getRuntime().exec(new String[]{"wmic", "csproduct", "get", "UUID"});
            processBIOS.getOutputStream().close();
            Scanner sc = new Scanner(processBIOS.getInputStream());
            sc.next();
            uddIDsN = sc.next();

        } catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NoSuchElementException ex) {
            uddIDsN = "No hay UUID";
        }
        System.out.println(uddIDsN);

    }

    private void motherID() {
        try {
            Process processMotherID = Runtime.getRuntime().exec(new String[]{"wmic", "baseboard", "get", "SerialNumber"});
            processMotherID.getOutputStream().close();
            Scanner sc = new Scanner(processMotherID.getInputStream());
            try {
                sc.next();
                motherIDsN = sc.next();

            } catch (NoSuchElementException ex) {
                motherIDsN = "No hay serial MB";

            }
        } catch (IOException ex) {
            Logger.getLogger(Activacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(motherIDsN);
    }

//    public static void main(String[] args) throws IOException, InterruptedException {
//        Activacion acti = new Activacion();
//        acti.cpuID();
//        acti.hardDiskDriveID();
//        acti.biosID();
//        acti.uddID();
//        acti.motherID();
//        String[] systemInfo = {cpuIDsN, hddSN, biosIDsN, uddIDsN, motherIDsN};
//
//        Thread.sleep(8000);
//        new LoginFrame(systemInfo).setVisible(true);
//    }
}
