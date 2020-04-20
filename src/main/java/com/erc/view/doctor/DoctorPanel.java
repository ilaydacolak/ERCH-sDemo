package com.erc.view.doctor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.erc.entities.AppointmentDTO;
import com.erc.user.service.AppointmentService;
import com.toedter.calendar.JDateChooser;

public class DoctorPanel extends JPanel{
	private JTable appointmentPatientTable = new JTable();
	private AppointmentPatientListTableModel appointmentTableModel = new AppointmentPatientListTableModel();
	private LocalDate today;
	public DoctorPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 0;
		gbc_dateChooser.gridy = 1;
		add(dateChooser, gbc_dateChooser);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 today = LocalDate.now();
		formatter.format(today);

		dateChooser.setDate(java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		appointmentPatientTable.setModel(appointmentTableModel);
		scrollPane.setViewportView(appointmentPatientTable);
		
		getAppointmentListFromService();
	}
	
	private void getAppointmentListFromService() {
		AppointmentService appointmentService = new AppointmentService();
		ArrayList<AppointmentDTO> appointmentList = appointmentService.getAllAppointmentList();
		ArrayList<AppointmentDTO> appointmentTableList = new ArrayList<AppointmentDTO>();
		for(AppointmentDTO appointment : appointmentList) {
			if(appointment.getAppointmentCreate().compareTo(java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) == 0) {
				appointmentTableList.add(appointment);
			}
			}
		appointmentTableModel.setAppointmentList(appointmentTableList);
		appointmentPatientTable.setModel(appointmentTableModel);
		appointmentTableModel.fireTableDataChanged();
	}

}
