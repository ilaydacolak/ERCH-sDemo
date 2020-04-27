package com.erc.view.doctor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.AppointmentDTO;



public class AppointmentPatientListTableModel extends AbstractTableModel {
	
	private List <AppointmentDTO> appointmentList = new ArrayList<AppointmentDTO>();
	private String columnNames[] = {"HASTA NO","HASTA L�STES�"};
	
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
		return appointmentList == null ? 0 : appointmentList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		AppointmentDTO appointment = appointmentList.get(row);
		switch (col) {
		case 0:
			return appointment.getPatientName().getPatientNo() ;		
		case 1:
			return  appointment.getPatientName().getName() + " " + appointment.getPatientName().getSurname();
		}
		return null;
	}

	public List<AppointmentDTO> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<AppointmentDTO> appointmentList) {
		this.appointmentList = appointmentList;
	}

}
