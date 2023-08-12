package com.hospitalmanagement.hospitalapplication.repository;

import com.hospitalmanagement.hospitalapplication.entity.DoctorsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDetailsRepo extends JpaRepository<DoctorsDetails,String>{

}
