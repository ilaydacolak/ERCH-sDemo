package com.erc.view.Staff;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;


public class StaffTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private List<StaffDTO> list = new ArrayList<StaffDTO>();
	private String columnNames[] = {"TC","Name","Surname","Active"};

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
 		return list==null?0:list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
			StaffDTO person = list.get(row);
		
			switch(col) {
		
				case 0 :
					return person.getIdentificationno();
				case 1:
					return person.getName();
				case 2:
					return person.getLastname();
				case 3:
					return person.getAktif();

				}
		
		
		return null;
	}
	public List<StaffDTO> getDataList() {
		return list;
	}

	public void setDataList(List<StaffDTO> list) {
		this.list = list;
	}

}
