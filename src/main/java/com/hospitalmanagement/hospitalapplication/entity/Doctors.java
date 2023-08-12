package com.hospitalmanagement.hospitalapplication.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Doctors {

    @Id
    @GeneratedValue
    private String doctorName;
    private String specialization;
    private String Days;
    private String address;

}
