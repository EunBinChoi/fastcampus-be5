package me.day14.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample1 {
    private static Logger rootLogger = Logger.getLogger(""); // root logger (INFO level)
    private static Logger globalLogger = Logger.getGlobal(); // 하나의 application 에서 공유하는 Global Logger
    private static Logger logger = Logger.getLogger(LoggingExample1.class.getName());
    // 등록된 로거가 없어서 rootLogger를 가지고 옴
    public static void main(String[] args) {
        // Logger#log(level, message)
        logger.log(Level.WARNING, "Warning Logging");
        logger.log(Level.INFO, "Info Logging");
        logger.log(Level.SEVERE, "Severe Logging");
        logger.log(Level.CONFIG, "Config Logging"); // 실행이 안됨

        // level 인자 없이 로그 출력
        // warning(), info() 등의 메소드를 이용하여 로그 출력
        logger.warning("Warning Logging");
        logger.info("Info Logging");
        logger.severe("Severe Logging");
        logger.config("Config Logging"); // 실행이 안됨
    }
}
