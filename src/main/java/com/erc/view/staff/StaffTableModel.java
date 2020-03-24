package com.erc.view.staff;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.PersonnelDTO;
import com.erc.entities.StaffTypeDTO;

public class StaffTableModel extends AbstractTableModel{
	
	private List<StaffTypeDTO> list = new ArrayList<StaffTypeDTO>();
	private String columnNames[] = { "Staff Name", "Staff Code"};
	
	@Override
	public String getColumnName(int index) {
		return columnNames[index];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		StaffTypeDTO staff = list.get(row);
		switch(col){
		case 0:
			return staff.getName();
		case 1:
			return staff.getCode();
		}
		return null;
	}
	public List<StaffTypeDTO> getDataList() {
		return list;
	}

	public void setDataList(List<StaffTypeDTO> list) {
		this.list = list;
	}
	

}
