package com.erc.entities;

import java.util.Date;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.*;
import javax.swing.JComboBox;
import com.erc.entities.StaffTypeDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;

@Entity
@Table(name = "staff")
public class StaffDTO {
	@Id
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(name="UUID",  strategy = "guid", parameters = {})
	@Column(name = "staffid")
	private String staffid;

	@Column(name = "tcno")
	private String identificationno;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String lastname;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "isactive")
	private boolean isActive;

	@Column(name = "bdate")
	private Date bDate;

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "active")
	private String aktif;

	public String getAktif() {
		return aktif;
	}
	public void setAktif(String aktif) {
		this.aktif = aktif;
	}
	@ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="staffnumber")
	private StaffTypeDTO staffTypeDTO;
	@Column(name = "personeltype")
	private String personelType;
	

	public String getPersonelType() {
		return personelType;
	}
	public void setPersonelType(String personelType) {
		this.personelType = personelType;
	}
	public StaffTypeDTO getStaffTypeDTO() {
		return staffTypeDTO;
	}

	public void setStaffTypeDTO(StaffTypeDTO staffTypeDTO) {
		this.staffTypeDTO = staffTypeDTO;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPersonid() {
		return staffid;
	}

	public void setPersonid(String staffid) {
		this.staffid = staffid;
	}

	public String getIdentificationno() {
		return identificationno;
	}

	public void setIdentificationno(String identificationno) {
		this.identificationno = identificationno;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
