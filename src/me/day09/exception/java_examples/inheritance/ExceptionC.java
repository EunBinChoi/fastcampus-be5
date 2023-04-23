package me.day09.exception.java_examples.inheritance;

public class ExceptionC extends ExceptionB {
    private final static String MESSAGE = "ExceptionC";

    public ExceptionC() {
        super(MESSAGE);
    }

    public ExceptionC(String message) {
        super(message);
    }

    public ExceptionC(String message, Throwable cause) {
        super(message, cause);
    }
}
