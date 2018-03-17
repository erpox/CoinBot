/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freebitcoin.app.control;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Eduardo
 */
public class MyUncaughtExceptionHandler implements
        Thread.UncaughtExceptionHandler {

    Logger log = Logger.getLogger("UncaughtExceptionHandler");
    FileHandler handler;
    public MyUncaughtExceptionHandler() {
        try {
            
            handler = new FileHandler("uncaught_exception%u.log", true);
            handler.setFormatter(new SimpleFormatter());
            log.addHandler(handler);
            log.setUseParentHandlers(false);
        } catch (IOException | SecurityException e) {
        }
    }

    @Override
    public void uncaughtException(final Thread t,
            final Throwable e) {
        String msg = String.format("Thread %s: %s", t.getName(),
                e.getMessage());
        LogRecord lr = new LogRecord(Level.SEVERE, msg);
        lr.setThrown(e);
        log.log(lr);
        handler.close();

    }
}
