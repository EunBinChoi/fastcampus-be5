package me.day09.exception_practice.practice05.exception;

public class NullArgumentException extends RuntimeException {
    public NullArgumentException() {
    }

    public NullArgumentException(String message) {
        super(message);
    }

    public NullArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullArgumentException(Throwable cause) {
        super(cause);
    }

    public NullArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
