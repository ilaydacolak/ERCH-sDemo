package com.erc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class StaffTypeDTO {
	@Id
	@Column(name="staffid")
	private String staffTypeID;
	@Column(name="staffname", unique=true)
	private String name;
	@Column(name="staffcode")
	private String code;
//	@Id
//	@GeneratedValue
//	@Column(name="staffid")
	
	public String getStaffTypeID() {
		return staffTypeID;
	}
	public void setStaffTypeID(String staffTypeID) {
		this.staffTypeID = staffTypeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
