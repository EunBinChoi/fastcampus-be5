package me.day10.smartstore.exception;

import me.day10.smartstore.util.Message;

public class ArrayEmptyException extends RuntimeException {

    public ArrayEmptyException() {
        super(Message.ERR_MSG_INVALID_ARR_EMPTY);
    }

    public ArrayEmptyException(String message) {
        super(message);
    }
}
