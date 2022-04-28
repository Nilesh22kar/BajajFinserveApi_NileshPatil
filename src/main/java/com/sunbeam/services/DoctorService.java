package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Doctor;
import com.sunbeam.entities.Staff;

public interface DoctorService {

	List<Doctor> findAll();

	Doctor findById(int id);

	Staff findByAid(int aid);

}
