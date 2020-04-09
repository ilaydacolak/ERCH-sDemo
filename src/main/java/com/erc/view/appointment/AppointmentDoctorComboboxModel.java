package com.erc.view.appointment;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import com.erc.entities.StaffDTO;

public class AppointmentDoctorComboboxModel extends AbstractListModel implements ComboBoxModel {


	private ArrayList<StaffDTO> staffTypes = new ArrayList<StaffDTO>();	
	private Object selection = null;
	private ArrayList<String> DoctorList= new ArrayList<String>();
	
	public ArrayList<String> DrList(ArrayList<StaffDTO> staffTypes) {
		for(StaffDTO staffDTO : staffTypes) {
			if(staffDTO.getStaffTypeDTO().getStaffTypeID().equals("34289ffd-1fbf-4f5e-8f9c-00f8559ba9c4")) {
				DoctorList.add(staffDTO.getName()+ " " + staffDTO.getLastname());
			}
		}
		return DoctorList ;
	}
	
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return DoctorList.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return DoctorList.size();
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selection;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		selection = anItem;
	}

	public ArrayList<StaffDTO> getStaffTypes() {
		return staffTypes;
	}

	public void setStaffTypes(ArrayList<StaffDTO> staffTypes) {
		DrList(staffTypes);
		this.staffTypes = staffTypes;
	}
	

}
