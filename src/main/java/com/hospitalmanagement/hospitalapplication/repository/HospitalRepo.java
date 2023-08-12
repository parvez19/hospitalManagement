package com.hospitalmanagement.hospitalapplication.repository;

import com.hospitalmanagement.hospitalapplication.entity.Pateint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface HospitalRepo extends JpaRepository <Pateint,Integer> {
}
