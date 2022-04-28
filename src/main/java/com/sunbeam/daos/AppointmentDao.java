package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Appointment;
import com.sunbeam.entities.Invoice;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer>{

	void save(Invoice invoice);

	
}
