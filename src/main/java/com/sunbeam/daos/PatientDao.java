package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Login;
import com.sunbeam.entities.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer>{

	void save(Login loginAfter);

	Patient findByPname(String name);

}
