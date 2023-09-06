package com.hospitalmanagement.hospitalapplication.exception;

import com.hospitalmanagement.hospitalapplication.entity.RestApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class HospitalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {RecordNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
  protected ResponseEntity<Object> handleConflict2 (RuntimeException ex, WebRequest request) {

        RestApiError restApiError = new RestApiError();
        restApiError.setStatus(HttpStatus.NOT_FOUND);
        restApiError.setMessage(ex.getMessage());

        return handleExceptionInternal(ex,restApiError,new HttpHeaders(),HttpStatus.NOT_FOUND,request);
  }

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    protected ResponseEntity<Object> handleConflict3 (RuntimeException ex, WebRequest request) {

        RestApiError restApiError = new RestApiError();
        restApiError.setStatus(HttpStatus.BAD_REQUEST);
        restApiError.setMessage(ex.getMessage());

        return handleExceptionInternal(ex,restApiError,new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }


}
