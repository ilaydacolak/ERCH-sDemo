package com.erc.view.appointment;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.OrganizationDTO;

public class AppointmentOrganizationTableModel extends AbstractTableModel {
	private ArrayList<OrganizationDTO> optionList = new ArrayList<OrganizationDTO>();
	private String columnName[] = { "Poliklinikler" };

	@Override
	public String getColumnName(int index) {
		return columnName[index];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return optionList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		OrganizationDTO option = optionList.get(row);
		switch (col) {

		case 0:
			return option.getoptionsName();
		}
		return null;
	}

	public List<OrganizationDTO> getDataList() {
		return optionList;
	}
	public void setDataList(ArrayList<OrganizationDTO> optionList) {
		this.optionList = optionList;
	}

}
