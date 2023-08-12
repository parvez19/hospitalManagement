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
 import org.springframework.web.bind.annotation.RequestParam;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.stream.Collectors;

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

         List<Doctors> doctorsList = new ArrayList<>();

         List<Doctors> finalDoctors = doctorsList.stream().filter(e -> "dr.jaweed".equals(e.getDoctorName()) && "dentist" == e.getSpecialization()).collect(Collectors.toList());


         return  doctorRepo.findAll();


     }






     public String enrollPateint(Pateint pateint) {


         try {
             hospitalRepo.save(pateint);
         } catch (Exception e) {
             log.info("exception in HospitalService" + e.getMessage());
         }
         return "added successfully";
     }

     public List<DoctorsDetails> getDoctorsDetails(@RequestParam String name) {

         List<DoctorsDetails> doctorsDetailsResult = new ArrayList<>();

         List<DoctorsDetails> FinalList =  doctorsDetailsResult.stream().filter(e-> "dr.jaweed".equals(e.getDoctorName())).collect(Collectors.toList());
          doctorDetailsRepo.findById(name);

          return FinalList;
     }
 }

//     public Optional<Doctors> getDoctorsName(String name) {
//
//         return doctorRepo.findByName(name);
//     }
// }