package me.day09.exception_practice.practice04.exception;

public class ProgramExitException extends RuntimeException {
    public ProgramExitException() {
    }

    public ProgramExitException(String message) {
        super(message);
    }

    public ProgramExitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProgramExitException(Throwable cause) {
        super(cause);
    }

    public ProgramExitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
