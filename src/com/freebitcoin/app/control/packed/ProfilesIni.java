// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control.packed;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.io.Reader;
import java.io.LineNumberReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;

public class ProfilesIni
{
    private ArrayList<String> proxyRuta;
    private File profilesIni;
    
    public ProfilesIni() {
        this.proxyRuta = new ArrayList<String>();
        this.profilesIni = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Mozilla\\Firefox\\profiles.ini");
    }
    
    public void readProfiles(final ArrayList<String> perfiles) {
        FileReader fr = null;
        try {
            fr = new FileReader(this.profilesIni);
            final LineNumberReader lnr = new LineNumberReader(fr);
            int linesLenght = 0;
            while (lnr.readLine() != null) {
                ++linesLenght;
            }
            for (int k = 0; k < linesLenght; ++k) {
                final String linea = Files.readAllLines(this.profilesIni.toPath()).get(k);
                if (linea.contains("Name=") && !linea.contains("Name=default")) {
                    final String perfilFirefox = linea.replace("Name=", "");
                    perfiles.add(perfilFirefox);
                    String ruta = Files.readAllLines(this.profilesIni.toPath()).get(k + 2);
                    ruta = ruta.replace("Path=Profiles/", "");
                    this.proxyRuta.add(ruta);
                }
            }
        }
        catch (FileNotFoundException e) {
            Logger.getLogger(ProfilesIni.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "  No se han encontrado perfiles de Firefox", "Error al cargar perfiles.", 2);
        }
        catch (IOException ex) {
            Logger.getLogger(ProfilesIni.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                fr.close();
            }
            catch (IOException ex2) {
                Logger.getLogger(ProfilesIni.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }
    }
    
    public void readProxies(final ArrayList<Proxies> proxies) {
        System.out.println("-- Cargando proxies");
        try {
            String puerto = "";
            String proxy = "";
            for (int i = 0; i < this.proxyRuta.size(); ++i) {
                final String rutaProxy = this.proxyRuta.get(i);
                final File ficheroProxy = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Mozilla\\Firefox\\profiles\\" + rutaProxy + "\\prefs.js");
                final FileReader fr = new FileReader(ficheroProxy);
                final LineNumberReader lnr = new LineNumberReader(fr);
                int linesLenght = 0;
                while (lnr.readLine() != null) {
                    ++linesLenght;
                }
                for (int j = 0; j < linesLenght; ++j) {
                    String linea = Files.readAllLines(ficheroProxy.toPath()).get(j);
                    if (linea.contains("user_pref(\"network.proxy.ftp\"")) {
                        linea = linea.replace("user_pref(\"network.proxy.ftp\",", "");
                        int m = linea.length();
                        proxy = linea.substring(2, m - 3);
                        String lineaPuerto = Files.readAllLines(ficheroProxy.toPath()).get(j + 1);
                        lineaPuerto = lineaPuerto.replace("user_pref(\"network.proxy.ftp_port\",", "");
                        m = lineaPuerto.length();
                        puerto = lineaPuerto.substring(1, m - 2);
                        break;
                    }
                    proxy = "0.0.0.0";
                    puerto = "0000";
                }
                proxies.add(i, new Proxies(proxy, puerto));
            }
        }
        catch (IOException e) {
            Logger.getLogger(ProfilesIni.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ha ocurrido un error al cargar un perfil", 0);
            System.exit(0);
        }
    }
}
