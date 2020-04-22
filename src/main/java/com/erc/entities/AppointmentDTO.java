package com.erc.entities;

import java.time.LocalTime;
import java.util.Date;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class AppointmentDTO {
	@Id
	@Column(name = "appointmentid")
	private String appointmentID;
//	@Column(name = "patientname")
	@ManyToOne(cascade= CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="patientname")
	private PatientDTO patientDTO;
	@Column(name = "organizationname")
	private String organizationName;
	@Column(name = "organizationid")
	private String organizationID;
public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
public PatientDTO getPatientDTO() {
		return patientDTO;
	}
	public void setPatientDTO(PatientDTO patientDTO) {
		this.patientDTO = patientDTO;
	}
	public StaffDTO getStaffDTO() {
		return staffDTO;
	}
	public void setStaffDTO(StaffDTO staffDTO) {
		this.staffDTO = staffDTO;
	}

	//	@Column(name = "doctorname")
	@ManyToOne(cascade= CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="doctorname")
	private StaffDTO staffDTO;
	@Column(name = "appointmentdate")
	private Date appointmentDate;
	@Column(name = "appointmentcreatedate")
	private Date appointmentCreate;
	@Column(name = "appointmentupdatedate")
	private Date appointmentUpdate;
	@Column(name = "note")
	private String note;
	@Column(name = "stringsaat")
	private String stringSaat;
	@Column(name = "hour")
	private Date date;
	@Column(name = "admissionnumber")
	private String admissionýd;
	public String getAdmissionýd() {
		return admissionýd;
	}
	public void setAdmissionýd(String admissionýd) {
		this.admissionýd = admissionýd;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	@Column(name = "patientid")
	private String patientID;
	@Column(name = "doctorid")
	private String doctorID;
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStringSaat() {
		return stringSaat;
	}

	public void setStringSaat(String stringSaat) {
		this.stringSaat = stringSaat;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public PatientDTO getPatientName() {
		return patientDTO;
	}

	public void setPatientName(PatientDTO patientName) {
		this.patientDTO = patientName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public StaffDTO getDoctorName() {
		return staffDTO;
	}

	public void setDoctorName(StaffDTO doctorName) {
		this.staffDTO = doctorName;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Date getAppointmentCreate() {
		return appointmentCreate;
	}

	public void setAppointmentCreate(Date appointmentCreate) {
		this.appointmentCreate = appointmentCreate;
	}

	public Date getAppointmentUpdate() {
		return appointmentUpdate;
	}

	public void setAppointmentUpdate(Date appointmentUpdate) {
		this.appointmentUpdate = appointmentUpdate;
	}

}
