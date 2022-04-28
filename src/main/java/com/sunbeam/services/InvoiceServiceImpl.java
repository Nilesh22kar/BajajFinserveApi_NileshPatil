package com.sunbeam.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.AppointmentDao;
import com.sunbeam.daos.InvoiceDao;
import com.sunbeam.entities.Appointment;
import com.sunbeam.entities.Invoice;

@Transactional
@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceDao idao;

	@Autowired
	private AppointmentDao adao;

	@Override
	public String addInvoice(Invoice invoice, int aid) {
		Optional<Appointment> appointment = adao.findById(aid);
		Appointment app = appointment.orElse(null);

		Invoice inv = idao.save(invoice);
		inv.setAppointment(app);

		return "Invoice created";
	}

	@Override
	public Invoice findInvoiceDetailsByAppointment(int aid) {
		Optional<Appointment> appointment = adao.findById(aid);
		Appointment app = appointment.orElse(null);

		Invoice invoice = app.getInvoice();
		return invoice;
	}

}
