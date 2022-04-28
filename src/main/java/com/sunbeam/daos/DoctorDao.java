package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {

}
