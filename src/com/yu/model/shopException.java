package com.yu.model;

/**
 * Created by lenovo on 2016/4/7.
 */
public class shopException extends RuntimeException {
    public shopException() {
        super();
    }

    public shopException(String message) {
        super(message);
    }

    public shopException(String message, Throwable cause) {
        super(message, cause);
    }

    public shopException(Throwable cause) {
        super(cause);
    }
}
