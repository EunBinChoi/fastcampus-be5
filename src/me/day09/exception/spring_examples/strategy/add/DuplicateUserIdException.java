package me.day09.exception.spring_examples.strategy.add;

import java.sql.SQLException;

public class DuplicateUserIdException extends RuntimeException {
    public DuplicateUserIdException() {
    }


    public DuplicateUserIdException(String message) {
        super(message);
    }


    public DuplicateUserIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateUserIdException(SQLException e) {

    }
}
