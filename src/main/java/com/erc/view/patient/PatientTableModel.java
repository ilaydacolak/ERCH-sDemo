package com.erc.view.patient;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;


public class PatientTableModel extends AbstractTableModel {
	private List<PatientDTO> dataList = new ArrayList <PatientDTO>();
	private static final long serialVersionUID = 1L;

	
	private String columnNames[] = { "PATIENT NO","TC","NAME", "SURNAME" 

	};

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
 		return dataList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		PatientDTO patient = dataList.get(row);
		
		switch(col) {
		
			case 0:
				return patient.getTc();
			case 1 :			
				return patient.getName();
			case 2:
				return patient.getSurname();
			case 3:
				return patient.getUsername();
			
			}
		
		
		
		return null;
	}
	public List<PatientDTO> getDataList() {
		return dataList;
	}

	public void setDataList(List<PatientDTO> dataList) {
		this.dataList = dataList;
	}

}
