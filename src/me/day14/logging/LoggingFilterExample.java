package me.day14.logging;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggingFilterExample {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggingFilterExample.class.getName());
        // logger.setFilter(new CustomFilter());
        logger.setFilter((logRecord) -> logRecord.getLevel() == Level.INFO);
        logger.info("INFO message");
        logger.warning("WARNING message");
    }
}
class CustomFilter implements Filter {
    public boolean isLoggable(LogRecord logRecord) {
        return logRecord.getLevel() == Level.INFO;
    }
}
