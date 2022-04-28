package com.sunbeam.services;

import org.springframework.mail.MailException;

import com.sunbeam.entities.Appointment;

public interface MailService {

	void sendEmail(Appointment app) throws MailException;

	void sendEmailforDeletion(Appointment app) throws MailException;

}
