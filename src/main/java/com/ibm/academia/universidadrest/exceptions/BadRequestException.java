package com.ibm.academia.universidadrest.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException (String messsage) {
        super(messsage);
    }
    private static final long serialVersionUID = 3387993293039828607L;
}
