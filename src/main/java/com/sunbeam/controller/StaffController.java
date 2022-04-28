package com.sunbeam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Login;
import com.sunbeam.entities.Staff;
import com.sunbeam.services.StaffServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffServiceImpl stService;

	@PostMapping("/register/doctor")
	public ResponseEntity<?> addDoctorDetails(@RequestBody Login doctorDetails) {
		System.out.println(doctorDetails);

		try {
			return new ResponseEntity<>(stService.addDoctor(doctorDetails), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> addStaffDetails(@RequestBody Login staffDetails) {
		System.out.println(staffDetails);

		try {
			return new ResponseEntity<>(stService.addStaff(staffDetails), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("")
	public ResponseEntity<List<Staff>> findAll() {
		List<Staff> list = stService.findAll();
		if (list == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Staff> findById(@PathVariable("id") int id) {
		Staff staff = stService.findById(id);
		if (staff == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(staff);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Staff> updateStaff(@PathVariable("id") int id, @RequestBody Staff staff) {
		staff.setSid(id);
		Staff newStaff = stService.updateStaff(staff);
		return ResponseEntity.ok(newStaff);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStaffDetails(@PathVariable int id) {
		stService.deleteStaff(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
