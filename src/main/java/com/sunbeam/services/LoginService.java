package com.sunbeam.services;

import com.sunbeam.entities.Doctor;
import com.sunbeam.entities.Login;

public interface LoginService {

	Login authenticate(String email, String password);

	Login findByEmail(String email);
	
	Login findByRole(String role);

	String addPatientDetails(Login loginBody);

	Login resetPassword(String email, String dob, String password, String role);

	Doctor findDoctorByEmail(String email);

}
