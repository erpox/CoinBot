// 
// Decompiled by Procyon v0.5.30
// 

package com.freebitcoin.app.control;

import java.io.OutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MiObjectOutputStream extends ObjectOutputStream
{
    @Override
    protected void writeStreamHeader() throws IOException {
    }
    
    public MiObjectOutputStream() throws IOException {
    }
    
    public MiObjectOutputStream(final OutputStream out) throws IOException {
        super(out);
    }
}
