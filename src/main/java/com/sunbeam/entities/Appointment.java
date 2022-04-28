package com.sunbeam.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int aid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	Date adate;
	String atimeslot;
	String asymptoms;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "did")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "pid")
	private Patient patient;

	@JsonIgnore
	@OneToOne(mappedBy = "appointment")
	private Invoice invoice;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Appointment() {
		super();
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public String getAtimeslot() {
		return atimeslot;
	}

	public void setAtimeslot(String atimeslot) {
		this.atimeslot = atimeslot;
	}

	public String getAsymptoms() {
		return asymptoms;
	}

	public void setAsymptoms(String asymptoms) {
		this.asymptoms = asymptoms;
	}

	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", adate=" + adate + ", atimeslot=" + atimeslot + ", asymptoms=" + asymptoms
				+ "]";
	}

}
