package com.hospitalmanagement.hospitalapplication.repository;

import com.hospitalmanagement.hospitalapplication.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepo  extends JpaRepository<Doctors,String> {

//    Optional<Doctors> findByName(String DoctorName);

}
