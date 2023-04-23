package me.day09.exception_practice.practice04.exception;

public class OutOfBoundsPossibleTriesException extends RuntimeException {
    public OutOfBoundsPossibleTriesException() {
    }

    public OutOfBoundsPossibleTriesException(String message) {
        super(message);
    }

    public OutOfBoundsPossibleTriesException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfBoundsPossibleTriesException(Throwable cause) {
        super(cause);
    }

    public OutOfBoundsPossibleTriesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
