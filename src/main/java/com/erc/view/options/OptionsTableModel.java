package com.erc.view.options;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.OrganizationDTO;
import com.erc.entities.StaffDTO;

public class OptionsTableModel extends AbstractTableModel{
	
	private List<OrganizationDTO> list = new ArrayList<OrganizationDTO>();
	private String columnNames[] = {"ORGANIZATION NAME"};
	
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
		// TODO Auto-generated method stub
		OrganizationDTO option = list.get(row);
		
		switch(col) {
	
			case 0 :
				return option.getoptionsName();
			
			
			}
		
		return null;
	}
	public List<OrganizationDTO> getDataList() {
		return list;
	}

	public void setDataList(List<OrganizationDTO> list) {
		this.list = list;
	}
	

}
