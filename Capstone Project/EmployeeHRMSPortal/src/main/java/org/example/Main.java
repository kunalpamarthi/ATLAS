package org.example;

import org.example.Portal.*;
import org.example.Util.TableInitializer;

public class Main {
    public static void main(String[] args) {
        // Initialize tables first
        TableInitializer initializer = new TableInitializer();
        initializer.initializeTables();

        // Start the main application
        MainPortal.main(args);
    }
}