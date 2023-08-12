package com.hospitalmanagement.hospitalapplication.hospitalcontroller;


import com.hospitalmanagement.hospitalapplication.entity.Doctors;
import com.hospitalmanagement.hospitalapplication.entity.DoctorsDetails;
import com.hospitalmanagement.hospitalapplication.entity.Pateint;
import com.hospitalmanagement.hospitalapplication.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    HospitalService hospitalService;




    @GetMapping("hospital/patients")

    public List<Pateint> getPatients () {

        return  hospitalService.getPatientsInfo();
    }

    @GetMapping("hospital/getdoctors")

    public List<Doctors> getDoctor () {

        return  hospitalService.getDoctorsInfo();
    }

   // @PostMapping("hospital/addpatients")

    //public List<Pateint> addPatients(@RequestBody Pateint pateint) {

      //  return hospitalService.enrollPateint(pateint);


        @GetMapping("hospital/getdoctorsDetails")

        public List<DoctorsDetails> getDoctorDetails(@RequestParam  String name) {

            return  hospitalService.getDoctorsDetails(name);
        }



    }
