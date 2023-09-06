package com.hospitalmanagement.hospitalapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestApiError {

     private HttpStatus status;
     private String message;
     private String error;
}
