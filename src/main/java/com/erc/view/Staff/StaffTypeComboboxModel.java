package com.erc.view.Staff;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


import com.erc.entities.StaffTypeDTO;

public class StaffTypeComboboxModel extends AbstractListModel implements ComboBoxModel {
	private static final long serialVersionUID = 1L;
	private ArrayList<StaffTypeDTO> staffTypes = new ArrayList<StaffTypeDTO>();
	private Object selection = null;

	@Override
	public Object getElementAt(int index) {
		return staffTypes.get(index);		
	}

	@Override
	public int getSize() {
		return staffTypes.size();
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = anItem;
	}

	public ArrayList<StaffTypeDTO> getStaffTypes() {
		return staffTypes;
	}

	public void setStaffTypes(ArrayList<StaffTypeDTO> staffTypes) {
		this.staffTypes = staffTypes;
	}

}
