package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Patient;

public interface PatientService {

	List<Patient> findAll();

	Patient findByPname(String name);

	Patient findById(int id);

	Patient update(Patient patient);

}
