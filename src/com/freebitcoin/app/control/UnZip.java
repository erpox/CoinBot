// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control;

import java.util.zip.ZipEntry;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.List;

public class UnZip
{
    List<String> fileList;
    private static final String INPUT_ZIP_FILE;
    private static final String OUTPUT_FOLDER;
    
    public static void main(final String[] args) {
        final UnZip unZip = new UnZip();
        unZip.unZipIt(UnZip.INPUT_ZIP_FILE, UnZip.OUTPUT_FOLDER);
    }
    
    public void unZipIt(final String zipFile, final String outputFolder) {
        final byte[] buffer = new byte[1024];
        try {
            final File folder = new File(UnZip.OUTPUT_FOLDER);
            if (!folder.exists()) {
                folder.mkdir();
            }
            final ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            for (ZipEntry ze = zis.getNextEntry(); ze != null; ze = zis.getNextEntry()) {
                final String fileName = ze.getName();
                final File newFile = new File(outputFolder + File.separator + fileName);
                System.out.println("file unzip : " + newFile.getAbsoluteFile());
                new File(newFile.getParent()).mkdirs();
                final FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zis.closeEntry();
            zis.close();
            System.out.println("Done");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    static {
        INPUT_ZIP_FILE = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\prueva.zip";
        OUTPUT_FOLDER = "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Mozilla\\";
    }
}
