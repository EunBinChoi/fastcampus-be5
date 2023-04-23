package me.day09.exception.java_examples.inheritance;

public class ExceptionB extends ExceptionA {
    private final static String MESSAGE = "ExceptionB";

    public ExceptionB() {
        super(MESSAGE);
    }

    public ExceptionB(String message) {
        super(message);
    }

    public ExceptionB(String message, Throwable cause) {
        super(message, cause);
    }
}
