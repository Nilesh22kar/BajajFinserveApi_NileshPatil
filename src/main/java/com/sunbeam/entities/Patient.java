package com.sunbeam.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	String pname;
	String pgender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	Date pdob;
	long pphone;
	String paddress;

	@JsonIgnore
	@OneToMany(mappedBy = "patient")
	private List<Appointment> apList;

	@JsonIgnore
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Login login;

	public List<Appointment> getApList() {
		return apList;
	}

	public void setApList(List<Appointment> apList) {
		this.apList = apList;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPgender() {
		return pgender;
	}

	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public Date getPdob() {
		return pdob;
	}

	public void setPdob(Date pdob) {
		this.pdob = pdob;
	}

	public long getPphone() {
		return pphone;
	}

	public void setPphone(long pphone) {
		this.pphone = pphone;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", pgender=" + pgender + ", pdob=" + pdob + ", pphone="
				+ pphone + ", paddress=" + paddress + "]";
	}

}
