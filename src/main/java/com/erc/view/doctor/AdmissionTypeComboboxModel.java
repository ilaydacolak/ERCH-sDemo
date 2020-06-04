package com.erc.view.doctor;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class AdmissionTypeComboboxModel extends AbstractListModel implements ComboBoxModel {
	private ArrayList <String> admissionTypeList = new ArrayList<>(Arrays.asList("Ayakta", "Yatan"));
	private Object selection = null ;
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return admissionTypeList.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return admissionTypeList.size();
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
 

}
