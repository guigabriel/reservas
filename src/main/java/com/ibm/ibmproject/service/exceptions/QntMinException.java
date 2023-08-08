package com.ibm.ibmproject.service.exceptions;

public class QntMinException extends RuntimeException {
    public QntMinException(String message) {
        super(message);
    }

    public QntMinException(String message, Throwable cause) {
        super(message, cause);
    }
}
