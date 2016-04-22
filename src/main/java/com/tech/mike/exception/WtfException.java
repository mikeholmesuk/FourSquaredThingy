package com.tech.mike.exception;

public class WtfException extends RuntimeException {

    private Integer errorCode;

    public WtfException(String message) {
        super(message);
    }

    public WtfException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public WtfException(Throwable throwable) {
        super(throwable);
    }

    public WtfException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public WtfException(String message, Throwable throwable, Integer errorCode) {
        super(message, throwable);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }
}