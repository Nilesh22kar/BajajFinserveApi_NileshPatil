package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Login;
import com.sunbeam.entities.Staff;

public interface StaffService {

	Staff findById(int id);

	String addDoctor(Login doctorDetails);

	String addStaff(Login staffDetails);

	List<Staff> findAll();

	void deleteStaff(int id);

	Staff updateStaff(Staff staff);

}
