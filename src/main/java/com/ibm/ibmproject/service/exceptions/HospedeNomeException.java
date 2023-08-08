package com.ibm.ibmproject.service.exceptions;

public class HospedeNomeException extends RuntimeException{
    public HospedeNomeException(String message) {
        super(message);
    }

    public HospedeNomeException(String message, Throwable cause) {
        super(message, cause);
    }
}
