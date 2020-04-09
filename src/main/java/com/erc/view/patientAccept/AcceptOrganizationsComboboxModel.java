package com.erc.view.patientAccept;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.erc.entities.OptionsDTO;


public class AcceptOrganizationsComboboxModel extends AbstractListModel implements ComboBoxModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<OptionsDTO> options = new ArrayList<OptionsDTO>();
	private ArrayList<String> optionsName = new ArrayList<String>();
	private Object selection = null;
	
	public ArrayList<String> optionsList (ArrayList<OptionsDTO> options){
		for(OptionsDTO optionsDTO : options) {
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

	public ArrayList<OptionsDTO> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<OptionsDTO> options) {
		optionsList(options);
		this.options = options;
	}
	

}
