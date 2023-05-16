package me.day14.logging.custom;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomLogger {
    private Logger logger = Logger.getLogger(CustomLogger.class.getName()); // root logger
    private static CustomLogger customLogger;
    private FileHandler infoFileHandler;
    private FileHandler warnFileHandler;
    private FileHandler severeFileHandler;

    //private static final String path = CustomLogger.class.getResource("").getPath();
    private static final String infoFileName = LocalDateTime.now() + "_info.log";
    private static final String warnFileName = LocalDateTime.now() + "_warn.log";
    private static final String severeFileName = LocalDateTime.now() + "_severe.log";

    public static CustomLogger getInstance() {
        if (customLogger == null) {
            customLogger = new CustomLogger();
        }
        return customLogger;
    }

    public CustomLogger() {
        try {
            logger.setUseParentHandlers(false);

            infoFileHandler = new FileHandler(infoFileName, false); // append mode: true
            warnFileHandler = new FileHandler(warnFileName, false); // append mode: true
            severeFileHandler = new FileHandler(severeFileName, false); // append mode: true

            infoFileHandler.setFormatter(new SimpleFormatter());
            warnFileHandler.setFormatter(new SimpleFormatter());
            severeFileHandler.setFormatter(new SimpleFormatter());


            logger.setLevel(Level.INFO); // root logger
//            infoFileHandler.setLevel(Level.INFO); // >= Level.INFO
//            warnFileHandler.setLevel(Level.WARNING); // >= Level.WARNING
//            severeFileHandler.setLevel(Level.SEVERE); // >= Level.SEVERE

            infoFileHandler.setFilter((record) -> record.getLevel() == Level.INFO); // == Level.INFO
            warnFileHandler.setFilter((record) -> record.getLevel() == Level.WARNING); // == Level.WARNING
            severeFileHandler.setFilter((record) -> record.getLevel() == Level.SEVERE); // == LEVEL.SEVERE

            logger.addHandler(infoFileHandler);
            logger.addHandler(warnFileHandler);
            logger.addHandler(severeFileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void log(String msg) {
        logger.finest(msg);
        logger.finer(msg);
        logger.fine(msg);
        logger.config(msg);
        logger.info(msg);
        logger.warning(msg);
        logger.severe(msg);
    }
}
