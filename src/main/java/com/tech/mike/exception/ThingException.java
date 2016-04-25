package com.tech.mike.exception;

public class ThingException extends RuntimeException {

    private Integer errorCode;

    public ThingException(String message) {
        super(message);
    }

    public ThingException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ThingException(Throwable throwable) {
        super(throwable);
    }

    public ThingException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ThingException(String message, Throwable throwable, Integer errorCode) {
        super(message, throwable);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }
}