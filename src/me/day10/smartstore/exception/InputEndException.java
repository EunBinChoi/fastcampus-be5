package me.day10.smartstore.exception;

import me.day10.smartstore.util.Message;

public class InputEndException extends RuntimeException {
    public InputEndException() {
        super(Message.ERR_MSG_INPUT_END);
    }

    public InputEndException(String message) {
        super(message);
    }
}
