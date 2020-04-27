package com.erc.view.doctor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.erc.entities.AppointmentDTO;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;
import com.erc.login.AuthService;
import com.erc.login.LoginPanel;
import com.erc.user.service.AppointmentService;
import com.erc.user.service.PatientService;
import com.toedter.calendar.JDateChooser;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DoctorPanel extends JPanel {
	private AppointmentPatientListTableModel appointmentTableModel = new AppointmentPatientListTableModel();
	private LocalDate today;
	private JDateChooser dateChooser;
	private JTable patientTable = new JTable();
	private JTable appointmentTable = new JTable();
	private PatientComboboxModel patientComboboxModel = new PatientComboboxModel();
	private JComboBox patientCMBX;
	private PatientTableModel patientTableModel = new PatientTableModel();
	private JScrollPane scrollPanePatient = new JScrollPane();
	private JScrollPane scrollPane;
	private PatientPanel patientPanel = new PatientPanel();
	public DoctorPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 130, 0, 150, 150, 0, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		today = LocalDate.now();
		formatter.format(today);

		Handler handler = new Handler();

		PatientService patientService = new PatientService();
		ArrayList<PatientDTO> patientList = patientService.getAllPatients();
		patientComboboxModel.setPatientList(patientList);

	
		patientPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
				 patientTable();
			}		
			}
		});

		// patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.PAGE_AXIS)); //Patient panel yapmission diger ekranda onun bir layout bilgisi var
		// burda tekrar eklemissin burda bi þey denemiþtim sonra bunu görmemiþim
		patientPanel.setVisible(true);
		scrollPanePatient = new JScrollPane();
//		scrollPanePatient.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent event) {
//				if (event.getClickCount() == 2) {
//					 patientTable();
//				}
//			}
//		});
		
		//		PatientService service = new PatientService();
		//		ArrayList<PatientDTO> patientLists = service.getAllPatients();		
		//			if (patientCMBX != null) {
		//				for (PatientDTO patient : patientLists) {
		//				PatientDTO cmbPatient = patientComboboxModel.getPatientList().get(patientCMBX.getSelectedIndex());
		//				if (cmbPatient != null) {
		//					if (patient.getPatientId() == patientComboboxModel.getPatientList().get(patientCMBX.getSelectedIndex()).getPatientId()) {
		//						patientTableModel.setPatient(patient);
		//					
		//
		//					}
		//				}
		//			}
		//		}
		//			patientTable.setModel(patientTableModel);
		//			scrollPanePatient.setViewportView(patientTable);
				
		
				patientCMBX = new JComboBox();
				GridBagConstraints gbc_patientCMBX = new GridBagConstraints();
				gbc_patientCMBX.insets = new Insets(0, 0, 5, 5);
				gbc_patientCMBX.fill = GridBagConstraints.HORIZONTAL;
				gbc_patientCMBX.gridx = 1;
				gbc_patientCMBX.gridy = 1;
				add(patientCMBX, gbc_patientCMBX);
				patientCMBX.setModel(patientComboboxModel);
		
		GridBagConstraints gbc_scrollPanePatient = new GridBagConstraints();
		gbc_scrollPanePatient.gridwidth = 4;
		gbc_scrollPanePatient.gridheight = 4;
		gbc_scrollPanePatient.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPanePatient.fill = GridBagConstraints.BOTH;
		gbc_scrollPanePatient.gridx = 3;
		gbc_scrollPanePatient.gridy = 1;
		add(patientPanel, gbc_scrollPanePatient);
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setAge(" ");
		patientDTO.setName(" ");
		patientDTO.setSurname(" ");
		patientDTO.setGender(" ");
//		patientTableModel.setPatient(patientDTO);
//		patientTable.setModel(patientTableModel);
//		scrollPanePatient.setViewportView(patientTable);
		
		
//		patientTableModel.fireTableDataChanged();
		
				dateChooser = new JDateChooser();
				GridBagConstraints gbc_dateChooser = new GridBagConstraints();
				gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
				gbc_dateChooser.fill = GridBagConstraints.BOTH;
				gbc_dateChooser.gridx = 1;
				gbc_dateChooser.gridy = 2;
				add(dateChooser, gbc_dateChooser);
				
						dateChooser.setDate(java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		
				JButton btnUpdate = new JButton("Listeyi Yenile");
				GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
				gbc_btnUpdate.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
				gbc_btnUpdate.gridx = 1;
				gbc_btnUpdate.gridy = 3;
				add(btnUpdate, gbc_btnUpdate);
				btnUpdate.addActionListener(handler);
				btnUpdate.setActionCommand("UPDATE");
		
		ArrayList<AppointmentDTO> appointmentDTO = new ArrayList<AppointmentDTO>();
		
		appointmentTableModel.setAppointmentList(appointmentDTO);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		appointmentTable.setModel(appointmentTableModel);
		scrollPane.setViewportView(appointmentTable);
		patientTableModel.fireTableDataChanged();
		
		getAppointmentListFromService();
	}
	private void patientTable() {
		PatientService service = new PatientService();
		ArrayList<PatientDTO> patientLists = service.getAllPatients();		
			if (patientCMBX != null) {
				for (PatientDTO patient : patientLists) {
				PatientDTO cmbPatient = patientComboboxModel.getPatientList().get(patientCMBX.getSelectedIndex());
				if (cmbPatient != null) {
					if (patient.getPatientId().equals(cmbPatient.getPatientId())) {
//						patientTableModel.setPatient(patient);
//						System.out.println(patient.getName());
//						patientTable.setModel(patientTableModel);
//						scrollPanePatient.setViewportView(patientTable);
//						patientTableModel.fireTableDataChanged();					
						patientPanel.fillScreen(patient);
		//				scrollPanePatient.setViewportView(patientPanel);
						
//
					}
				}
			}
		}
					
	}

	private void getAppointmentListFromService() {
		AppointmentService appointmentService = new AppointmentService();
		ArrayList<AppointmentDTO> appointmentList = appointmentService.getAllAppointmentList();
		ArrayList<AppointmentDTO> appointmentTableList = new ArrayList<AppointmentDTO>();

		for (AppointmentDTO appointment : appointmentList) {

			AuthService authService = new AuthService();

			if (!(appointment.getOrganizationID().equals(null))) {
				if (appointment.getAppointmentCreate().compareTo(dateChooser.getDate()) == 0
						&& appointment.getDoctorID().equals(authService.getStaffDTO().getPersonid())) {
					appointmentTableList.add(appointment);
				}
				appointmentTableModel.setAppointmentList(appointmentTableList);
				appointmentTable.setModel(appointmentTableModel);
				appointmentTableModel.fireTableDataChanged();
			}

		}

	}

	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			if (cmd.equals("UPDATE")) {
				getAppointmentListFromService();
			}

		}

	}

}
