package me.day09.exception_practice.practice03.exception;

public class BankingException extends RuntimeException {
    public BankingException() {
    }

    public BankingException(String message) {
        super(message);
    }

    public BankingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankingException(Throwable cause) {
        super(cause);
    }

    public BankingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
