package me.day14.logging;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.*;

public class LoggingExample5 {

    private static Logger logger = Logger.getLogger(LoggingExample5.class.getName());

    public static void main(String[] args) {
        // remove default log handler
        logger.setUseParentHandlers(false);

        // add new log handler
        Handler handler = null; // append mode
        try {
            handler = new FileHandler(LocalDateTime.now() + ".log", true); // 1개의 파일에 로그 append
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });
        logger.addHandler(handler);
        logger.setLevel(Level.CONFIG);

        // logging
        logger.warning("Warning logging");
        logger.info("Info logging");
        logger.config("Config logging");
    }
}
