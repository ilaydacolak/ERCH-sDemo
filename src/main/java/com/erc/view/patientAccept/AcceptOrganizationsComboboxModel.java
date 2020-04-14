package com.erc.view.patientAccept;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.erc.entities.OrganizationDTO;


public class AcceptOrganizationsComboboxModel extends AbstractListModel implements ComboBoxModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<OrganizationDTO> options = new ArrayList<OrganizationDTO>();
	private ArrayList<String> optionsName = new ArrayList<String>();
	private Object selection = null;
	
	public ArrayList<String> optionsList (ArrayList<OrganizationDTO> options){
		for(OrganizationDTO optionsDTO : options) {
			optionsName.add(optionsDTO.getoptionsName());
		}
		return optionsName;
	}
	

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return optionsName.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return optionsName.size();
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

	public ArrayList<OrganizationDTO> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<OrganizationDTO> options) {
		optionsList(options);
		this.options = options;
	}
	

}
