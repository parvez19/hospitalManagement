 package com.hospitalmanagement.hospitalapplication.service;

 import com.hospitalmanagement.hospitalapplication.entity.Doctors;
 import com.hospitalmanagement.hospitalapplication.entity.DoctorsDetails;
 import com.hospitalmanagement.hospitalapplication.entity.Pateint;
 import com.hospitalmanagement.hospitalapplication.repository.DoctorDetailsRepo;
 import com.hospitalmanagement.hospitalapplication.repository.DoctorRepo;
 import com.hospitalmanagement.hospitalapplication.repository.HospitalRepo;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

 @Service
 @Slf4j
public class HospitalService {
     @Autowired
     HospitalRepo hospitalRepo;
     @Autowired
     DoctorRepo doctorRepo;
     @Autowired
     DoctorDetailsRepo doctorDetailsRepo;
     public List<Pateint> getPatientsInfo() {
         List<Pateint> patients = hospitalRepo.findAll();
         return patients;
     }

     public List<Doctors> getDoctorsInfo() {
         return doctorRepo.findAll();
     }


     public String enrollPateint(Pateint pateint) {


         try {
             hospitalRepo.save(pateint);
         } catch (Exception e) {
             log.info("exception in HospitalService" + e.getMessage());
         }
         return "added successfully";
     }


     public DoctorsDetails getDoctorsDetailsInfo(String name) {

         List<DoctorsDetails> DoctorList = doctorDetailsRepo.findAll();
         for (DoctorsDetails doctor : DoctorList) {
             if (name.equals(doctor.getDoctorName())) {
                 return doctor;
             }

         }
         return null;
     }
 }
