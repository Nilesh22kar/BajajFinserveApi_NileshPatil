package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.entities.Appointment;

@Transactional
@Service
public class MailServiceImpl implements MailService{

	private JavaMailSender javaMailSender;

	@Autowired
	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	@Override
	public void sendEmail(Appointment app) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		String email = app.getPatient().getLogin().getEmail();
		mail.setTo(email);
		mail.setSubject("Appointment booking status");
		mail.setText("Dear  "+app.getPatient().getPname()+"\n This email is to inform you that your appointment has been booked for date : "+app.getAdate()+"\n Timeslot : "+app.getAtimeslot()+"\n The doctor appointd to you is : Dr. "+app.getDoctor().getStaff().getSname()+"\n Please be present on time for your appointment.\n Thank you");

		javaMailSender.send(mail);
	}
	
	@Override
	public void sendEmailforDeletion(Appointment app) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		String email = app.getPatient().getLogin().getEmail();
		mail.setTo(email);
		mail.setSubject("Appointment booking status");
		mail.setText("Dear  "+app.getPatient().getPname()+"\n This email is to inform you that your appointment has been cancelled.\n\n Thank you");

		javaMailSender.send(mail);
	}
}
