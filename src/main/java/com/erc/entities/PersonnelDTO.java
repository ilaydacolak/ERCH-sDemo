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
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.CascadeType;

@Entity
@Table(name = "personel")
public class PersonnelDTO {
	@Id
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

	@ManyToOne
	@JoinColumn(name="personeltypeid")
//	@OnDelete(action=OnDeleteAction.CASCADE)
	private StaffTypeDTO personelTypeNumber;

	public StaffTypeDTO getPersonelTypeNumber() {
		return personelTypeNumber;
	}


	public void setPersonelTypeNumber(StaffTypeDTO personelTypeNumber) {
		this.personelTypeNumber = personelTypeNumber;
	}


	public String getGender() {
		return gender;
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
