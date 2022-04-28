package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.AppointmentDao;
import com.sunbeam.daos.DoctorDao;
import com.sunbeam.daos.PatientDao;
import com.sunbeam.entities.Appointment;
import com.sunbeam.entities.Doctor;
import com.sunbeam.entities.Patient;

@Transactional
@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDao aDao;

	@Autowired
	private DoctorDao dDao;

	@Autowired
	private PatientDao pDao;

	@Override
	public Appointment findById(int aid) {
		Optional<Appointment> appointment = aDao.findById(aid);
		return appointment.orElse(null);
	}

	@Override
	public Appointment addAppointment(Appointment appointment, int pid, int did) {

		Optional<Patient> pat = pDao.findById(pid);
		Patient patient = pat.orElse(null);
		Optional<Doctor> doc = dDao.findById(did);
		Doctor doctor = doc.orElse(null);

		Appointment app = aDao.save(appointment);
		app.setDoctor(doctor);
		app.setPatient(patient);
		return app;
	}

	@Override
	public void deleteAppointment(int id) {
		aDao.deleteById(id);
	}

	@Override
	public List<Appointment> findByPatient(int pid) {
		Optional<Patient> pat = pDao.findById(pid);
		Patient patient = pat.orElse(null);

		List<Appointment> appList = patient.getApList();
		return appList;
	}

	@Override
	public List<Appointment> findByDoctor(int did) {
		Optional<Doctor> doc = dDao.findById(did);
		Doctor doctor = doc.orElse(null);

		List<Appointment> appList = doctor.getApList();
		return appList;
	}

	@Override
	public List<Appointment> findAll() {
		return aDao.findAll();
	}
}
