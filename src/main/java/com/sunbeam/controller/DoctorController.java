package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Doctor;
import com.sunbeam.entities.Staff;
import com.sunbeam.services.DoctorServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorServiceImpl drService;

	@GetMapping("")
	public ResponseEntity<List<Doctor>> findAll() {
		List<Doctor> list = drService.findAll();
		if (list == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> findById(@PathVariable("id") int id) {
		Doctor doctor = drService.findById(id);
		if (doctor == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(doctor);
	}

	@GetMapping("/aid/{aid}")
	public ResponseEntity<Staff> findByAid(@PathVariable("aid") int aid) {
		Staff staff = drService.findByAid(aid);
		if (staff == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(staff);
	}

}
