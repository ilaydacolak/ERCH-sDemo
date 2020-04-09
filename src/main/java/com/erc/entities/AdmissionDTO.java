package com.erc.entities;




import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.toedter.calendar.JDateChooser;
@Entity
@Table(name = "admission")
public class AdmissionDTO {
	@Id
	@Column(name = "admissionid")
	private int admissionID;
	@Column(name = "admissionno")
	private String admissionNo;
	@Column(name = "patientid")
	private int patientID;
	@Column(name = "admissiontype")
	private String admissionType;
	@Column(name = "organizationid")
	private String organizationID;
	@Column(name = "doctorid")
	private String doctorID;
	@Column(name = "admissiondate")
	private Date admissionDate;
	@Column(name = "admissioncreate")
	private Date admissionCreate;
	@Column(name = "admissionupdate")
	private Date admissionUpdate;
	@Column(name = "status")
	private String status;
	
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Date getAdmissionCreate() {
		return admissionCreate;
	}
	public void setAdmissionCreate(Date admissionCreate) {
		this.admissionCreate = admissionCreate;
	}
	public Date getAdmissionUpdate() {
		return admissionUpdate;
	}
	public void setAdmissionUpdate(Date admissionUpdate) {
		this.admissionUpdate = admissionUpdate;
	}

	public int getAdmissionID() {
		return admissionID;
	}
	public void setAdmissionID(int admissionID) {
		this.admissionID = admissionID;
	}
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getAdmissionType() {
		return admissionType;
	}
	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}
	public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	

}
