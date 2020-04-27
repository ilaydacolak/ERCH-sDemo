package com.erc.view.patient;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class BloodComboboxModel extends AbstractListModel implements ComboBoxModel{

	private ArrayList<String> bloodList = new ArrayList<>(Arrays.asList("0Rh+","0Rh-","ARh+","ARh-","BRh+","BRh-","ABRh+","ABRh-"));
	private Object selection = null;
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return bloodList.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return bloodList.size();
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
