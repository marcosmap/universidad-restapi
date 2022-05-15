package com.ibm.academia.universidadrest.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    private static final long serialVersionUID = -5804715121912765217L;
}
