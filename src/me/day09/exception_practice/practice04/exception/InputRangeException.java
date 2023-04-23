package me.day09.exception_practice.practice04.exception;

public class InputRangeException extends RuntimeException {
    public InputRangeException() {
    }

    public InputRangeException(String message) {
        super(message);
    }

    public InputRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputRangeException(Throwable cause) {
        super(cause);
    }

    public InputRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
