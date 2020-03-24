package com.erc.view.personel;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class PersonelTypeComboboxModel extends AbstractListModel implements ComboBoxModel{
	String [] PersonelType = {"Nurse","Doctor"};
	String selection = null;
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return PersonelType[index];
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return PersonelType.length;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selection;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		selection = (String) anItem; 
	}

}
