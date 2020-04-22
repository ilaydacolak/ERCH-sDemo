package com.erc.view.doctor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.erc.entities.AppointmentDTO;
import com.erc.entities.StaffDTO;
import com.erc.login.AuthService;
import com.erc.login.LoginPanel;
import com.erc.user.service.AppointmentService;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class DoctorPanel extends JPanel {
	private JTable appointmentPatientTable = new JTable();
	private AppointmentPatientListTableModel appointmentTableModel = new AppointmentPatientListTableModel();
	private LocalDate today;
	private JDateChooser dateChooser;

	public DoctorPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		dateChooser = new JDateChooser();
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
				
				JButton btnUpdate = new JButton("Listeyi Yenile");
				btnUpdate.setHorizontalAlignment(SwingConstants.RIGHT);
				GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
				gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
				gbc_btnUpdate.gridx = 0;
				gbc_btnUpdate.gridy = 2;
				add(btnUpdate, gbc_btnUpdate);
				
				Handler handler = new Handler();
				btnUpdate.addActionListener(handler);
				btnUpdate.setActionCommand("UPDATE");
		
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.anchor = GridBagConstraints.NORTH;
				gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 3;
				add(scrollPane, gbc_scrollPane);
				
						appointmentPatientTable.setModel(appointmentTableModel);
						scrollPane.setViewportView(appointmentPatientTable);

		getAppointmentListFromService();
	}

	private void getAppointmentListFromService() {
		AppointmentService appointmentService = new AppointmentService();
		ArrayList<AppointmentDTO> appointmentList = appointmentService.getAllAppointmentList();
		ArrayList<AppointmentDTO> appointmentTableList = new ArrayList<AppointmentDTO>();

		for (AppointmentDTO appointment : appointmentList) {
//			StaffDTO staff = AuthService.getStaffDTO();
//			System.out.println(staff.getorganizationID());
			AuthService authService = new AuthService();
			System.out.println(authService.getStaffDTO().getPersonid());
			System.out.println(appointment.getOrganizationID());

//			if (!(appointment.getOrganizationID().equals(null))) {
//				if (appointment.getAppointmentCreate().compareTo(
//						java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) == 0
//						&& appointment.getDoctorID().equals(authService.getStaffDTO().getPersonid())) {
//					appointmentTableList.add(appointment);
//
//				}
//			}
			
			if (!(appointment.getOrganizationID().equals(null))) {
				if (appointment.getAppointmentCreate().compareTo(dateChooser.getDate()) == 0
						&& appointment.getDoctorID().equals(authService.getStaffDTO().getPersonid())) {
					appointmentTableList.add(appointment);

				}
			}

			appointmentTableModel.setAppointmentList(appointmentTableList);
			appointmentPatientTable.setModel(appointmentTableModel);
			appointmentTableModel.fireTableDataChanged();
		}

	}
	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			if(cmd.equals("UPDATE")) {
				getAppointmentListFromService();
			}
			
		}
		
	}
}
