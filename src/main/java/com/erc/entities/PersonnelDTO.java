package com.erc.entities;

import java.util.Date;


import javax.persistence.*;

@Entity
@Table(name="personel")
public class PersonnelDTO {
	@Id
	@Column(name="personelid")
	private String personid;
	@Column(name="tcno")
	private String identificationno;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String lastname;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="isactive")
	private boolean isActive;
	@Column(name="bdate")
	private Date bDate;


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
