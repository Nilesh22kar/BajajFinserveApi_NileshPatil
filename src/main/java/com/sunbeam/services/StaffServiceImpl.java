package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.DoctorDao;
import com.sunbeam.daos.LoginDao;
import com.sunbeam.daos.StaffDao;
import com.sunbeam.entities.Login;
import com.sunbeam.entities.Staff;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao sDao;

	@Autowired
	private LoginDao logDao;

	@Autowired
	private DoctorDao drDao;

	@Override
	public Staff findById(int id) {
		Optional<Staff> staff = sDao.findById(id);
		return staff.orElse(null);
	}

	@Override
	public String addDoctor(Login doctorDetails) {
		PasswordEncoder pEncoder = new BCryptPasswordEncoder();
		String encodedPassword = pEncoder.encode(doctorDetails.getPassword());
		doctorDetails.setPassword(encodedPassword);
		sDao.save(doctorDetails.getDoctor().getStaff());
		drDao.save(doctorDetails.getDoctor());
		logDao.save(doctorDetails);
		
		return "Doctor details added";
	}

	@Override
	public String addStaff(Login staffDetails) {
		PasswordEncoder pEncoder = new BCryptPasswordEncoder();
		String encodedPassword = pEncoder.encode(staffDetails.getPassword());
		staffDetails.setPassword(encodedPassword);
		sDao.save(staffDetails.getStaff());
		logDao.save(staffDetails);

		return "Staff details added";
	}

	@Override
	public List<Staff> findAll() {
		return sDao.findAll();
	}

	@Override
	public Staff updateStaff(Staff staff) {
		return sDao.save(staff);
	}

	@Override
	public void deleteStaff(int id) {
		sDao.deleteById(id);
	}

}
