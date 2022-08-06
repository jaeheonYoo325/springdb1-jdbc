package com.springdb1.springdb1jdbc.repository.ex;

public class MyduplicateKeyException extends MyDbException {

    public MyduplicateKeyException() {
    }

    public MyduplicateKeyException(String message) {
        super(message);
    }

    public MyduplicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyduplicateKeyException(Throwable cause) {
        super(cause);
    }
}
