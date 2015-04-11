package org.arithmetic.exception;

import java.lang.Exception;
import java.lang.String;
import java.lang.Throwable;

public class AppException extends Exception {
    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
