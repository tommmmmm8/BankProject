package com.bank.logger;

import com.google.inject.Singleton;

@Singleton
public class FileSystemLogger implements Logger {

    @Override
    public void log(String message) {
        try (java.io.FileWriter writer = new java.io.FileWriter("application.log", true)) {
            writer.write("[FILE] " + message + System.lineSeparator());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
