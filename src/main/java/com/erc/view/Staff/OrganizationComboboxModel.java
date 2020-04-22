package com.erc.view.Staff;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import com.erc.entities.OrganizationDTO;

public class OrganizationComboboxModel extends AbstractListModel implements ComboBoxModel {

	private ArrayList<OrganizationDTO> organizationList = new ArrayList<OrganizationDTO>();
	private Object selection = null;
	private ArrayList<String> organizationNameList = new ArrayList<String>();
	
	public ArrayList<String> organizationList (ArrayList<OrganizationDTO> organizationList){
		for(OrganizationDTO organization : organizationList ) {
			organizationNameList.add(organization.getoptionsName());
		}		
		return organizationNameList;
	}
	
	
	
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return organizationNameList.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return organizationNameList.size();
	}

	public ArrayList<OrganizationDTO> getOrganizationList() {
		return organizationList;
	}

	public void setOrganizationList(ArrayList<OrganizationDTO> organizationList) {
		organizationList(organizationList);
		this.organizationList = organizationList;
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
