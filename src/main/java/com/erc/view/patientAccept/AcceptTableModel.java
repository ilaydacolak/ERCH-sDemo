package com.erc.view.patientAccept;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.AdmissionDTO;

public class AcceptTableModel extends AbstractTableModel {

	private List<AdmissionDTO> admissionList = new ArrayList<AdmissionDTO>();
	private String columnNames[] = { "Kabul No", "Organizasyon", "Doktor", "Kabul Tarihi" };

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
		return admissionList == null ? 0 : admissionList.size();
	}
	
	public void setRowCount(String size) {
		admissionList=null;
	}


	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		AdmissionDTO admission = admissionList.get(row);
		switch (col) {

		case 0:
			return admission.getAdmissionNo();
		case 1:
			return admission.getOrganizationID();
		case 2:
			return admission.getDoctorID();
		case 3:
			return admission.getAdmissionDate();

		}
		return null;
	}

	public List<AdmissionDTO> getAdmissionList() {
		return admissionList;
	}

	public void setAdmissionList(List<AdmissionDTO> admissionList) {
		this.admissionList = admissionList;
	}

}
