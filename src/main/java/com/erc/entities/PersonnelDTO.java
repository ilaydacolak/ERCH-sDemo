package com.erc.entities;

import java.util.Date;

import javax.persistence.*;
import javax.swing.JComboBox;
import com.erc.entities.StaffTypeDTO;

@Entity
@Table(name = "personel")
public class PersonnelDTO {
	@Id
	@GeneratedValue
	@Column(name = "personelid")
	private String personid;

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

	@Column(name = "personeltype")
	private String personelType;
//	@Column(name = "personeltypeid")
//	private String personelTypeNumber;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personeltypeid")
	private StaffTypeDTO personelTypeID;
//
//	public String getPersonelTypeNumber() {
//		personelTypeNumber = personelTypeID.getStaffTypeID();
//		return personelTypeNumber;
//	}
//
//	public void setPersonelTypeNumber(String personelTypeNumber) {
//		this.personelTypeNumber = personelTypeNumber;
//	}

	public String getGender() {
		return gender;
	}
//	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name="personeltypeid")
	public StaffTypeDTO getPersonelTypeID() {
		return personelTypeID;
	}


	public void setPersonelTypeID(StaffTypeDTO personelTypeID) {
		this.personelTypeID = personelTypeID;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPersonelType() {
		return personelType;
	}

	public void setPersonelType(String personelType) {
		this.personelType = personelType;
	}
//	@Id
//	@GeneratedValue
	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
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
