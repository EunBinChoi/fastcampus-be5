package me.day09.exception_practice.practice05.exception;

public class EmptyArrayException extends RuntimeException {
    public EmptyArrayException() {
    }

    public EmptyArrayException(String message) {
        super(message);
    }

    public EmptyArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyArrayException(Throwable cause) {
        super(cause);
    }

    public EmptyArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
