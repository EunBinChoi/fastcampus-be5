package me.day09.exception_practice.practice03.exception;

public class NonPositiveException extends BankingException {
    public NonPositiveException() {
    }

    public NonPositiveException(String message) {
        super(message);
    }

    public NonPositiveException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonPositiveException(Throwable cause) {
        super(cause);
    }

    public NonPositiveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
