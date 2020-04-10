package com.erc.entities;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class AppointmentDTO {
@Id
@Column(name="appointmentid")	
private String appointmentID;
@Column(name="patientname")	
private String patientName;
@Column(name="organizationname")	
private String organizationName;
@Column(name="doctorname")	
private String doctorName;
@Column(name="appointmentdate")	
private Date appointmentDate;
@Column(name="appointmentcreatedate")	
private Date appointmentCreate;
@Column(name="appointmentupdatedate")	
private Date appointmentUpdate;

@Column(name="note")
private String note;
@Column (name="stringsaat")
private String stringSaat;

@Column(name="hour")
private Date date;



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
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getOrganizationName() {
	return organizationName;
}
public void setOrganizationName(String organizationName) {
	this.organizationName = organizationName;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
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
