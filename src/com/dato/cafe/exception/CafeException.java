package com.dato.cafe.exception;

public class CafeException extends Exception {
    public CafeException(String message) {
        super(message);
    }

    public CafeException(String message, Throwable cause) {
        super(message, cause);
    }
}
