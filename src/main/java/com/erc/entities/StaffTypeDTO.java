package com.erc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="stafftype")
public class StaffTypeDTO {
	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "book_generator")
//	@GenericGenerator(name="GenerationType.SEQUENCE",  strategy = "guid", parameters = {})
	@Column(name="stafftypeid")
//	@GeneratedValue(generator = "stafftypeid")
//	@GenericGenerator(name="stafftypeid",  strategy = "guid", parameters = {}),
	private String staffTypeID;
	@Column(name="stafftypename", unique=true)
	private String name;
	@Column(name="stafftypecode")
	private String code;

	
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return code+"-"+name;
	}

}
