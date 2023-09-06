package com.hospitalmanagement.hospitalapplication.entity;

import lombok.Data;

@Data
public class BookingAppointment {

    private int appointmentId;
    private int patientId;
    private String drName;
    private String dayOfAppointments;
    private String illness;
}
