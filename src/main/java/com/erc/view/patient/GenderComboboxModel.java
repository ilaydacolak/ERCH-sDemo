package com.erc.view.patient;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class GenderComboboxModel extends AbstractListModel implements ComboBoxModel{

	private ArrayList<String> genderList = new ArrayList<>(Arrays.asList("Woman", "Man"));
	private Object selection = null;
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return genderList.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return genderList.size();
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
