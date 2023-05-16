package me.day14.logging;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample1 {
    private static Logger rootLogger = Logger.getLogger(""); // root logger (INFO level)
    private static Logger globalLogger = Logger.getGlobal();
    // 하나의 application 에서 공유하는 Global Logger
    // Global Logger의 부모는 root logger
    // Global Logger는 모든 클래스와 패키지를 하나의 로거를 통해 관리함으로 좋지 않은 선택

    private static Logger logger = Logger.getLogger(LoggingExample1.class.getName());
    // me.day14.logging.LoggingExample1
    // 등록된 로거가 없어서 rootLogger를 가지고 옴

    private static Logger logger2 = Logger.getLogger("LoggingExample1");
    private static Logger logger3 = Logger.getLogger("me.day14.logging.LoggingExample1");
    private static Logger xyzLogger = Logger.getLogger("com.xyz.foo");
    private static Logger xyzLogger2 = Logger.getLogger("com.xyz");
    private static Logger xyzLogger3 = Logger.getLogger("com");
    public static void main(String[] args) throws IOException {
        System.out.println(xyzLogger2.getParent() == xyzLogger3); // true
        System.out.println(xyzLogger2 == xyzLogger.getParent()); // true

        System.out.println(logger == logger2);
        System.out.println(logger == logger3);
        System.out.println();

        System.out.println(rootLogger);
        System.out.println(Arrays.toString(rootLogger.getHandlers()));
        System.out.println(rootLogger.getLevel());
        System.out.println();

        System.out.println(globalLogger);
        System.out.println(globalLogger.getParent());
        System.out.println(Arrays.toString(globalLogger.getHandlers()));
        System.out.println(globalLogger.getLevel());
        System.out.println();

        System.out.println(xyzLogger);
        System.out.println(xyzLogger.getParent());
        System.out.println(Arrays.toString(xyzLogger.getHandlers()));
        System.out.println(xyzLogger.getLevel());
        System.out.println();

        globalLogger.setUseParentHandlers(false);
        globalLogger.setLevel(Level.ALL);
        globalLogger.addHandler(new ConsoleHandler()); // LEVEL.INFO
        globalLogger.addHandler(new FileHandler(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd_HH")) + ".log", true));

        globalLogger.log(Level.FINE, "FINE Logging");
        globalLogger.log(Level.INFO, "INFO Logging");
        globalLogger.log(Level.WARNING, "WARNING Logging");
        globalLogger.log(Level.SEVERE, "SEVERE Logging");

        // Logger#log(level, message)
        // logger.setUseParentHandlers(false);
        logger.log(Level.WARNING, "Warning Logging");
        logger.log(Level.INFO, "Info Logging");
        logger.log(Level.SEVERE, "Severe Logging");
        logger.log(Level.CONFIG, "Config Logging"); // 실행이 안됨

//        // level 인자 없이 로그 출력
//        // warning(), info() 등의 메소드를 이용하여 로그 출력
        logger.warning("Warning Logging");
        logger.info("Info Logging");
        logger.severe("Severe Logging");
        logger.config("Config Logging"); // 실행이 안됨
    }
}
