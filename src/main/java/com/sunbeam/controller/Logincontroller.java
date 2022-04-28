package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Doctor;
import com.sunbeam.entities.Login;
import com.sunbeam.services.LoginServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class Logincontroller {

	@Autowired
	private LoginServiceImpl logService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody Login request) {
		System.out.println("in auth " + request);
		Login user = logService.authenticate(request.getEmail(), request.getPassword());
		if (user != null)
			return new ResponseEntity<>(user, HttpStatus.OK);
		else
			return new ResponseEntity<>("invalid credentials!!!", HttpStatus.UNAUTHORIZED);
	}

	@PutMapping("/{email}/{dob}/{password}/{role}")
	public ResponseEntity<?> resetPassword(@PathVariable("email") String email, @PathVariable("dob") String dob,
			@PathVariable("password") String password, @PathVariable("role") String role) {
		Login updatedDetails = logService.resetPassword(email, dob, password, role);
		if (updatedDetails == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(updatedDetails);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<Login> findByEmail(@PathVariable("email") String email) {
		Login login = logService.findByEmail(email);
		if (login == null)
			return null;
		return ResponseEntity.ok(login);
	}

	@GetMapping("/dremail/{email}")
	public ResponseEntity<Doctor> findDoctorByEmail(@PathVariable("email") String email) {
		Doctor doctor = logService.findDoctorByEmail(email);
		if (doctor == null)
			return null;
		return ResponseEntity.ok(doctor);
	}
}
