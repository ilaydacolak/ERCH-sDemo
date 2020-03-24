package com.erc.view.personel;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class GenderComboboxModel extends AbstractListModel implements ComboBoxModel{
	String [] gender = {"Woman","Man"};
	String selection = null;


	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return gender[index];
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return gender.length;
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

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

}
