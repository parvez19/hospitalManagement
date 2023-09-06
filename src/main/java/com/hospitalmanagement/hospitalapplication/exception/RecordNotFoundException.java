package com.hospitalmanagement.hospitalapplication.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String errorMessage) {

        super(errorMessage);
    }


}
