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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunbeam.entities.Appointment;
import com.sunbeam.services.AppointmentServiceImpl;
import com.sunbeam.services.MailServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	AppointmentServiceImpl aService;
	
	@Autowired
	MailServiceImpl mailService;

	@GetMapping("")
	public ResponseEntity<List<Appointment>> findAllPatientWhoHaveAppointment() {
		List<Appointment> list = aService.findAll();
		if (list == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(list);
	}

	@PostMapping("/add/{pid}/{did}")
	public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment, @PathVariable("pid") int pid,
			@PathVariable("did") int did) {
		try {
			Appointment app = aService.addAppointment(appointment, pid, did);
			mailService.sendEmail(app);
			return new ResponseEntity<>(app, HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/patient/{pid}")
	public ResponseEntity<List<Appointment>> findByPatient(@PathVariable("pid") int pid) {
		List<Appointment> appList = aService.findByPatient(pid);
		if (appList == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(appList);
	}

	@GetMapping("/doctor/{did}")
	public ResponseEntity<List<Appointment>> findByDoctor(@PathVariable("did") int did) {
		List<Appointment> appList = aService.findByDoctor(did);
		if (appList == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(appList);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAppointment(@PathVariable int id) {
		Appointment app = aService.findById(id);
		aService.deleteAppointment(id);
		mailService.sendEmailforDeletion(app);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
