package com.infernumvii;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class NativeConsole {
    static {
        if (!System.getProperty("os.name").startsWith("Windows")) {
            throw new UnsupportedOperationException("Windows only");
        }

        try {
            Path tempDll = Files.createTempFile("nativeconsole", ".dll");
            try (var dllStream = NativeConsole.class.getResourceAsStream("/native/nativeconsole.dll")) {
                Files.copy(dllStream, tempDll, StandardCopyOption.REPLACE_EXISTING);
            }
            System.load(tempDll.toString());
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Failed to load native library", e);
        }
    }
    public native static int readCharImmediately(); 
    private NativeConsole(){
    }

    public static void main(String[] args) {
        while (true) {
            int ch = readCharImmediately();
            if (ch != -1){
                System.out.println((char)ch);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
}
