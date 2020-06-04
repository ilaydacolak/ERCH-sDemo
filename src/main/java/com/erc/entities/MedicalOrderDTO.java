package com.erc.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "medicalorder")
public class MedicalOrderDTO {
	@Id
	@Column(name = "medicalorderid")
	private String medicalOrderID;
	@Column(name = "module")
	private String module;
	@ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="admissionid")
	private AdmissionDTO admissionDTO;
	@Column(name = "orderno")
	private String orderNo;
	@ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="organizationid")
	private OrganizationDTO organizationDTO;
	@Column(name = "datecreated")
	private Date dateCreated;
	@Column(name = "dateupdated")
	private Date dateUpdated;
	@ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="usercreated")
	private StaffDTO userCreated;
	@ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="userupdated")
	private StaffDTO userUpdated;
	
	public String getMedicalOrderID() {
		return medicalOrderID;
	}
	public void setMedicalOrderID(String medicalOrderID) {
		this.medicalOrderID = medicalOrderID;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public AdmissionDTO getAdmissionDTO() {
		return admissionDTO;
	}
	public void setAdmissionDTO(AdmissionDTO admissionDTO) {
		this.admissionDTO = admissionDTO;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public OrganizationDTO getOrganizationDTO() {
		return organizationDTO;
	}
	public void setOrganizationDTO(OrganizationDTO organizationDTO) {
		this.organizationDTO = organizationDTO;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public StaffDTO getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(StaffDTO userCreated) {
		this.userCreated = userCreated;
	}
	public StaffDTO getUserUpdated() {
		return userUpdated;
	}
	public void setUserUpdated(StaffDTO userUpdated) {
		this.userUpdated = userUpdated;
	}
	

}
