package com.erc.view.appointment;

import java.awt.Color;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.AppointmentDTO;
import com.erc.user.service.AppointmentService;

public class AppointmentTableModel extends AbstractTableModel {
	private ArrayList<AppointmentDTO> appointmentList = new ArrayList<AppointmentDTO>();
	private String columnNames[] = { "Randevu Saati", "Hasta Adý Soyadý", "Doktor", "Randevu Oluþturulma Tarihi",
			"Randevu Güncellenme Tarihi" };
	private Date date;
	public Calendar calendar = Calendar.getInstance();
	public LocalTime time = LocalTime.of(8, 00);
	public LocalTime time2 = LocalTime.of(17, 00);
	private AppointmentDTO appointmentDTO = new AppointmentDTO();
	private List<Color> rowColours = Arrays.asList(Color.RED, Color.GREEN);

	public void setRowColour(int row, Color c) {
		rowColours.set(row, c);
		fireTableRowsUpdated(row, row);
	}

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
		return appointmentList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		AppointmentDTO appointment = appointmentList.get(row);
		switch (col) {

		case 1:
			return appointment.getPatientName();
		case 2:
			return appointment.getDoctorName();
		case 3:
			return appointment.getAppointmentCreate();
		case 4:
			return appointment.getAppointmentUpdate();

		}
		return null;
	}

	public AppointmentDTO getAppointmentDTO() {

		return appointmentDTO;
	}

	public void setAppointmentDTO(AppointmentDTO appointmentDTO) {
		this.appointmentDTO = appointmentDTO;
		appointmentList.add(appointmentDTO);

	}

	public ArrayList<AppointmentDTO> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(ArrayList<AppointmentDTO> appointmentList) {
//		while (!(time.equals(Time.valueOf(LocalTime.of(17, 00))))) {
//
//		ArrayList<AppointmentDTO> appointmentlist = new ArrayList<AppointmentDTO>();
//		for (AppointmentDTO appointment : appointmentlist) {
//		AppointmentDTO appointment = new AppointmentDTO();
//			while (time.compareTo(time2)<0) {
//				appointment.setSaat(time);
//				appointmentList.add(appointment);				
//				time = time.plusMinutes(15);			
//		}
		this.appointmentList = appointmentList;
	}

}
