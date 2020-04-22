package com.erc.login;

import java.util.ArrayList;

import com.erc.entities.StaffDTO;
import com.erc.user.service.StaffService;

public class AuthService {

	public static StaffDTO staffDTO;

	public static StaffDTO getStaffDTO() {
		return staffDTO;
	}

	public static void setStaffDTO(StaffDTO staffDTO) {
		AuthService.staffDTO = staffDTO;
	}

	public static StaffDTO loginInformation(String name) {

		StaffService staffService = new StaffService();
		ArrayList<StaffDTO> staffList = staffService.getAllStaff();
		for (StaffDTO staff : staffList) {
			if (staff.getUsername().equals(name)) {
				return staff;
			}
		}
		return null;
	}

}
