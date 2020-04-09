package com.erc.view.appointment;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.AppointmentDTO;

public class AppointmentTableModel2 extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<AppointmentRow> appointmentList = new ArrayList<AppointmentRow>();

	private String columnNames[] = { "Randevu Saati", "Hasta Adý Soyadý", "Doktor", "Randevu Oluþturulma Tarihi",
			"Randevu Güncellenme Tarihi" };

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
		return appointmentList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		AppointmentRow appointmentRow = appointmentList.get(row);
		appointmentRow.getDate();
		AppointmentDTO appointmentDTO = appointmentRow.getAppointment();
		switch (col) {
		case 0:
			return appointmentRow.getDate();
		case 1:
			return appointmentDTO.getPatientName();
		case 2:
			return appointmentDTO.getDoctorName();
		case 3:
			return appointmentDTO.getAppointmentCreate();
		case 4:
			return appointmentDTO.getAppointmentUpdate();

		}
		return null;
	}

	public ArrayList<AppointmentRow> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(ArrayList<AppointmentRow> appointmentList) {
		this.appointmentList = appointmentList;
	}

}
