package com.hospitalmanagement.hospitalapplication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DoctorsDetails {

    @Id
    @GeneratedValue
    private String doctorName;
    private String doctorSpeciality;

}
