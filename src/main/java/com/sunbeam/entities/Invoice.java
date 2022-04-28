package com.sunbeam.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int iid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	Date idate;
	double imedicinefees;
	double idoctorfees;
	double ilabtestfees;
	double iotherfees;
	String description;

	@OneToOne
	@JoinColumn(name = "aid")
	private Appointment appointment;

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public Date getIdate() {
		return idate;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public double getImedicinefees() {
		return imedicinefees;
	}

	public void setImedicinefees(double imedicinefees) {
		this.imedicinefees = imedicinefees;
	}

	public double getIdoctorfees() {
		return idoctorfees;
	}

	public void setIdoctorfees(double idoctorfees) {
		this.idoctorfees = idoctorfees;
	}

	public double getIlabtestfees() {
		return ilabtestfees;
	}

	public void setIlabtestfees(double ilabtestfees) {
		this.ilabtestfees = ilabtestfees;
	}

	public double getIotherfees() {
		return iotherfees;
	}

	public void setIotherfees(double iotherfees) {
		this.iotherfees = iotherfees;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Invoice [iid=" + iid + ", idate=" + idate + ", imedicinefees=" + imedicinefees + ", idoctorfees="
				+ idoctorfees + ", ilabtestfees=" + ilabtestfees + ", iotherfees=" + iotherfees + ", description=" + description + ", appointment=" + appointment + "]";
	}
}
