package com.erc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="options")
public class OrganizationDTO {
	
	@Id
	@Column(name="optionsid")
	private String optionsID;
	@Column(name="optname")
	private String optionsName;
	@Column(name="isactive")
	private boolean isActive;
	
	public String getoptionsID() {
		return optionsID;
	}
	public void setoptionsID(String optionsID) {
		this.optionsID = optionsID;
	}
	public String getoptionsName() {
		return optionsName;
	}
	public void setoptionsName(String optionsName) {
		this.optionsName = optionsName;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	

}
