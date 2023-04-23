package me.day09.exception.java_examples.inheritance;

public class ExceptionA extends Exception { // unchecked exception
    private final static String MESSAGE = "ExceptionA";
    public ExceptionA() {
        super(MESSAGE);
    }

    public ExceptionA(String message) {
        super(message);
    }

    public ExceptionA(String message, Throwable cause) {
        super(message, cause);
    }
}
