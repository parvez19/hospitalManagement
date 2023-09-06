package com.hospitalmanagement.hospitalapplication.hospitalcontroller;


import com.hospitalmanagement.hospitalapplication.entity.*;
import com.hospitalmanagement.hospitalapplication.exception.RecordNotFoundException;
import com.hospitalmanagement.hospitalapplication.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

   @GetMapping("get/allpateints")
   public ResponseEntity<List<Pateint>> getPateint() throws RecordNotFoundException {

       return hospitalService.getPatientsInfo();
   }

    @PostMapping("hospital/add/patients")
    public ResponseEntity<Pateint> createPatients(@RequestBody Pateint pateint) throws RecordNotFoundException {

        return hospitalService.addPatientsInfo(pateint);
    }

//    @GetMapping("hospital/appointment")
//    public AppointmentDetails bookAppointment() {
//
//        return hospitalService.bookAppointmentInfo();
//    }


    @GetMapping("hospital/getdoctors")
    public ResponseEntity<List<Doctors>> getDoctor() throws RecordNotFoundException {

        return hospitalService.getDoctorsInfo();
    }

    @GetMapping("hospital/getDoctorsDetails")

    public ResponseEntity<DoctorsDetails> getDoctorDetails(@RequestParam("doctor") String doctorName) throws RecordNotFoundException {

        return hospitalService.getDoctorsDetailsInfo(doctorName);
    }

    @PostMapping("hospital/book/appointment")
    public ResponseEntity<String> addAppointment(@RequestBody BookingAppointment bookAppointment) throws RecordNotFoundException {

        return hospitalService.getAppointmentInfo(bookAppointment);
    }


}

