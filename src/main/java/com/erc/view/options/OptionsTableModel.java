package com.erc.view.options;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.OptionsDTO;
import com.erc.entities.PersonnelDTO;

public class OptionsTableModel extends AbstractTableModel{
	
	private List<OptionsDTO> list = new ArrayList<OptionsDTO>();
	private String columnNames[] = { "ORGANIZATION ID", "ORGANIZATION NAME"};
	
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
		OptionsDTO option = list.get(row);
		
		switch(col) {
	
			case 0 :
				return option.getoptionsID();
			case 1:
				return option.getoptionsName();
			
			}
		
		return null;
	}
	public List<OptionsDTO> getDataList() {
		return list;
	}

	public void setDataList(List<OptionsDTO> list) {
		this.list = list;
	}
	

}
