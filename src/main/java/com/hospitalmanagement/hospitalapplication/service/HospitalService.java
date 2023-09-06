package com.hospitalmanagement.hospitalapplication.service;

import com.hospitalmanagement.hospitalapplication.entity.BookingAppointment;
import com.hospitalmanagement.hospitalapplication.entity.Doctors;
import com.hospitalmanagement.hospitalapplication.entity.DoctorsDetails;
import com.hospitalmanagement.hospitalapplication.entity.Pateint;
import com.hospitalmanagement.hospitalapplication.exception.RecordNotFoundException;
import com.hospitalmanagement.hospitalapplication.repository.DoctorDetailsRepo;
import com.hospitalmanagement.hospitalapplication.repository.DoctorRepo;
import com.hospitalmanagement.hospitalapplication.repository.HospitalRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class HospitalService {
    @Autowired
   HospitalRepo hospitalRepo;
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    DoctorDetailsRepo doctorDetailsRepo;





    public ResponseEntity<List<Pateint>> getPatientsInfo() throws RecordNotFoundException {


        List<Pateint> pateintList = hospitalRepo.findAll();
        if (Objects.isNull(pateintList)) {
            throw new RecordNotFoundException("pateints list not found");
        }
        ResponseEntity<List<Pateint>> responseEntity = new ResponseEntity<>(pateintList,HttpStatus.OK);
        return responseEntity;
    }
    public ResponseEntity<Pateint> addPatientsInfo(Pateint pateint) throws RecordNotFoundException {

            Pateint pateintList = hospitalRepo.save(pateint);

            if (Objects.isNull(pateintList)) {
                throw new RecordNotFoundException("pateint details couldn't be save");
            }


        ResponseEntity<Pateint> responseEntity = new ResponseEntity<>(pateintList,HttpStatus.OK);
            return responseEntity;
    }

    public ResponseEntity<List<Doctors>> getDoctorsInfo() throws RecordNotFoundException {

              List<Doctors> doctorsList =  doctorRepo.findAll();
              if (Objects.isNull(doctorsList)) {
                  throw new RecordNotFoundException(("No record found"));
              }
            ResponseEntity<List<Doctors>> responseEntity = new ResponseEntity<>(doctorsList,HttpStatus.OK);

            return responseEntity;

    }



    public ResponseEntity<DoctorsDetails> getDoctorsDetailsInfo (String name) throws RecordNotFoundException {

              DoctorsDetails doctordetails = null;
              name.toLowerCase();
        List<DoctorsDetails> DoctorList = doctorDetailsRepo.findAll();
        for (DoctorsDetails doctor : DoctorList) {
            if (name.equals(doctor.getDoctorName())) {
                doctordetails = doctor;
            }
        }
        if(Objects.isNull(doctordetails)) {
            throw new RecordNotFoundException("Given Dr Name doesnot Exist");
        }
        ResponseEntity<DoctorsDetails> responseEntity = new ResponseEntity<>(doctordetails,HttpStatus.OK);

        return responseEntity;
    }


    public ResponseEntity<String> getAppointmentInfo(BookingAppointment bookAppointment) throws RecordNotFoundException {

        Doctors doctor = null;

        List<Doctors> doctorsList = doctorRepo.findAll();
        for (Doctors doc : doctorsList) {

            if (bookAppointment.getDrName().equalsIgnoreCase(doc.getDoctorName())) {

                doctor = doc;

             }
//            else {
//                throw new RecordNotFoundException("Given doctor is not available in records");
//            }
        }
            String DaysOfAppointment = doctor.getDays();

            String[] arrOfStr = DaysOfAppointment.split(",", 5);

            List<String> daysList = Arrays.asList(arrOfStr);
            log.info("doc available on :"+daysList);
        String appointmentId = null;
            if (daysList.contains(bookAppointment.getDayOfAppointments())) {
                 appointmentId = getNewAppointmentInfo(bookAppointment);

            }
            else {
                throw new RecordNotFoundException("appointment not available on given day");
            }
           // return "appointment not available";

            ResponseEntity<String> responseEntity = new ResponseEntity<>("your appointment id is"+" "+appointmentId,HttpStatus.OK);

            return responseEntity;

    }

    public String getNewAppointmentInfo(BookingAppointment bookAppointment)  {

         RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> res = restTemplate.postForEntity("http://localhost:8088/add/appointment", bookAppointment, String.class);
        String response = res.getBody();

        return response;
    }

}
