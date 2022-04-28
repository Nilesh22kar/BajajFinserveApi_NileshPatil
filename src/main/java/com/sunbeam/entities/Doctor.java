package com.sunbeam.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int did;
	String deducation;
	String dspeciality;
	

	@JsonIgnore
	@OneToMany(mappedBy = "doctor")	
	private List<Appointment> apList;

	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "sid")
	private Staff staff;

	@JsonManagedReference(value="user-doctor")
	@OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Appointment> getApList() {
		return apList;
	}

	public void setApList(List<Appointment> apList) {
		this.apList = apList;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDeducation() {
		return deducation;
	}

	public void setDeducation(String dname) {
		this.deducation = dname;
	}

	public String getDspeciality() {
		return dspeciality;
	}

	public void setDspeciality(String dspeciality) {
		this.dspeciality = dspeciality;
	}

	
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", deducation=" + deducation + ", dspeciality=" + dspeciality 
				  ;
	}

}
