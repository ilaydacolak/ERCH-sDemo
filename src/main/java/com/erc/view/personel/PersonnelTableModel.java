package com.erc.view.personel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;


public class PersonnelTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private List<PersonnelDTO> list = new ArrayList<PersonnelDTO>();
	private String columnNames[] = { "IDENTIFICATION NO", "NAME", "SURNAME", "USERNAME"};

	@Override
	public String getColumnName(int index) {
		return columnNames[index];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
 		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
			PersonnelDTO person = list.get(row);
		
			switch(col) {
		
				case 0 :
					return person.getIdentificationno();
				case 1:
					return person.getName();
				case 2:
					return person.getLastname();
				case 3:
					return person.getUsername();
				}
		
		
		return null;
	}
	public List<PersonnelDTO> getDataList() {
		return list;
	}

	public void setDataList(List<PersonnelDTO> list) {
		this.list = list;
	}

}
