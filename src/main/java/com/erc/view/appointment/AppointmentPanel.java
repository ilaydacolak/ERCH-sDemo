package com.erc.view.appointment;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import com.toedter.calendar.JDayChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import com.toedter.components.JLocaleChooser;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.erc.entities.AdmissionDTO;
import com.erc.entities.AppointmentDTO;
import com.erc.entities.OptionsDTO;
import com.erc.user.service.AdmissionService;
import com.erc.user.service.AppointmentService;
import com.erc.user.service.OptionsService;
import com.toedter.calendar.JDateChooser;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.ArrayList;
import java.util.List;
import java.time.ZoneId;

public class AppointmentPanel extends JPanel {
	public AppointmentOrganizationTableModel organizationTableModel = new AppointmentOrganizationTableModel();
	public JTable organizationTable = new JTable();
	private AppointmentTableModel appointmentTableModel = new AppointmentTableModel();
	private JTable appointmentTable = new JTable();
	private AppointmentDTO appointment = new AppointmentDTO();
	private JLabel lblDate;
	private LocalDate today;
	private OptionsDTO organizationDTO = new OptionsDTO();

	public AppointmentPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblDate = new JLabel("New label");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 1;
		add(lblDate, gbc_lblDate);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		today = LocalDate.now();
		formatter.format(today);
		lblDate.setText(today.toString());

		Handler handler = new Handler();

		JButton createRandevuBtn = new JButton("Randevu Olu\u015Ftur");
		GridBagConstraints gbc_createRandevuBtn = new GridBagConstraints();
		gbc_createRandevuBtn.insets = new Insets(0, 0, 5, 5);
		gbc_createRandevuBtn.gridx = 3;
		gbc_createRandevuBtn.gridy = 1;
		add(createRandevuBtn, gbc_createRandevuBtn);

		createRandevuBtn.addActionListener(handler);
		createRandevuBtn.setActionCommand("CREATE");

		JButton randevuUpdBtn = new JButton("Randevu G\u00FCncelle");
		GridBagConstraints gbc_randevuUpdBtn = new GridBagConstraints();
		gbc_randevuUpdBtn.insets = new Insets(0, 0, 5, 0);
		gbc_randevuUpdBtn.gridx = 5;
		gbc_randevuUpdBtn.gridy = 1;
		add(randevuUpdBtn, gbc_randevuUpdBtn);

		randevuUpdBtn.addActionListener(handler);
		randevuUpdBtn.setActionCommand("UPDATE");

		JScrollPane OrganizationPane = new JScrollPane();
		GridBagConstraints gbc_OrganizationPane = new GridBagConstraints();
		gbc_OrganizationPane.insets = new Insets(0, 0, 0, 5);
		gbc_OrganizationPane.fill = GridBagConstraints.BOTH;
		gbc_OrganizationPane.gridx = 1;
		gbc_OrganizationPane.gridy = 3;
		add(OrganizationPane, gbc_OrganizationPane);

		organizationTable.setModel(organizationTableModel);
		OrganizationPane.setViewportView(organizationTable);
		getOptionsListFromService();

		organizationTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (organizationTable.getSelectedRow() != -1) {
					getAppointmentListFromService();
				}
			}
		});

		JScrollPane RandevuPane = new JScrollPane();
		GridBagConstraints gbc_RandevuPane = new GridBagConstraints();
		gbc_RandevuPane.gridwidth = 3;
		gbc_RandevuPane.fill = GridBagConstraints.BOTH;
		gbc_RandevuPane.gridx = 3;
		gbc_RandevuPane.gridy = 3;
		add(RandevuPane, gbc_RandevuPane);

		appointmentTable.setModel(appointmentTableModel);
		RandevuPane.setViewportView(appointmentTable);
	}

	private void getAppointmentListFromService() {
		AdmissionService admissionService = new AdmissionService();
		ArrayList<AdmissionDTO> admissions = admissionService.getAllAdmissionPatients();
		ArrayList<AdmissionDTO> admission = new ArrayList<AdmissionDTO>();
		organizationDTO = organizationTableModel.getDataList().get(organizationTable.getSelectedRow());
		AppointmentService appService = new AppointmentService();
		ArrayList<AppointmentDTO> appointmentList = appService.getAllAppointmentList();
		ArrayList<AppointmentDTO> app = new ArrayList<AppointmentDTO>();

		for (AppointmentDTO appointment : appointmentList) {
			if (appointment.getOrganizationName().equals(organizationDTO.getoptionsName())) {
				for (AdmissionDTO admis : admissions) {
					System.out.println(admis.getAdmissionDate().toString());

					ZoneId defaultZoneId = ZoneId.systemDefault();
					System.out.println(Date.from(today.atStartOfDay(defaultZoneId).toInstant()));
					Timestamp ts = new Timestamp(admis.getAdmissionDate().getTime());
					if (today.equals(ts.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
						app.add(appointment);
					}

				}
			}
		}
		appointmentTableModel.setAppointmentList(app);
		appointmentTable.setModel(appointmentTableModel);
		appointmentTableModel.fireTableDataChanged();

	}

	private void getOptionsListFromService() {
		OptionsService service = new OptionsService();
		ArrayList<OptionsDTO> optionList = service.getAllOptions();
		organizationTableModel.setDataList(optionList);
		organizationTable.setModel(organizationTableModel);
		organizationTableModel.fireTableDataChanged();
	}

	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			if (cmd.equals("CREATE")) {
				if (organizationTable.getSelectedRow() == -1) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,select poliklinik", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else
					System.out.println("create is clicked");

				organizationDTO = organizationTableModel.getDataList().get(organizationTable.getSelectedRow());

				AppointmentService appService = new AppointmentService();
				ArrayList<AppointmentDTO> appointmentList = appService.getAllAppointmentList();
				
//				AppointmentDTO appointments = new AppointmentDTO();
//				appointmentTableModel.time.of(8, 00);
//				while(appointmentTableModel.time.equals(Time.valueOf(LocalTime.of(17, 00)))) {
//					for (AppointmentDTO appointment : appointmentList) {
//						appointment.setSaat(appointmentTableModel.time);
//						appointmentTableModel.time.plusMinutes(15);
//					}
//					}
//				}
				// AppointmentDTO appointment = new AppointmentDTO();
	
				while (appointmentTableModel.time.compareTo(appointmentTableModel.time2) < 0) {					
						appointment.setSaat(appointmentTableModel.time);
						appointmentList.add(appointment);
						appointmentTableModel.time = appointmentTableModel.time.plusMinutes(15);				
				}

				// ArrayList<AppointmentDTO> appointmentList = new ArrayList<AppointmentDTO>();
//				AppointmentDTO appointments = new AppointmentDTO();
//				boolean stp = false;
//				for (AppointmentDTO appointment : appointmentList) {
//					if (appointment.getStringSaat().equals("9:00")) {
//						stp = true;
//						appointmentTableModel.setRowColour(1, Color.RED);
//						break;
//					}		
//				}
//				if (stp == false) {
//					appointmentTableModel.setRowColour(1, Color.GREEN);
//					appointments.setStringSaat("9:00");
//					appointmentList.add(appointments);		
//				}
//
////				appService.saveAppointment(appointments);
//				AppointmentDTO appointments2 = new AppointmentDTO();
//				boolean stp2 = false;
//				for (AppointmentDTO appointment2 : appointmentList) {
//					if (appointment2.getStringSaat().equals("9:15")) {
//						stp2 = true;
//						break;
//					}
//				}
//				if (stp2== false) {
//					appointments2.setStringSaat("9:15");
//					appointmentList.add(appointments2);
//				}
//
//				
//				AppointmentDTO appointments3 = new AppointmentDTO();
//				boolean stp3 = false;
//				for (AppointmentDTO appointment2 : appointmentList) {
//					if (appointment2.getStringSaat().equals("9:30")) {
//						stp3 = true;
//						break;
//					}
//				}
//				if (stp3== false) {
//					appointments3.setStringSaat("9:30");
//					appointmentList.add(appointments3);
//				}
//		
//				AppointmentDTO appointments4 = new AppointmentDTO();
//		
//				boolean stp4 = false;
//				for (AppointmentDTO appointment2 : appointmentList) {
//					if (appointment2.getStringSaat().equals("9:45")) {
//						stp4 = true;
//						break;
//					}
//				}
//				if (stp4== false) {
//					appointments4.setStringSaat("9:45");
//					appointmentList.add(appointments4);
//				}
//
//				AppointmentDTO appointments5 = new AppointmentDTO();
//				boolean stp5 = false;
//				for (AppointmentDTO appointment2 : appointmentList) {
//					if (appointment2.getStringSaat().equals("10:00")) {
//						stp5 = true;
//						break;
//					}
//				}
//				if (stp5== false) {
//					appointments5.setStringSaat("10:00");
//					appointmentList.add(appointments5);
//				}
//
//				AppointmentDTO appointments6 = new AppointmentDTO();
//				boolean stp6 = false;
//				for (AppointmentDTO appointment2 : appointmentList) {
//					if (appointment2.getStringSaat().equals("10:15")) {
//						stp6 = true;
//						break;
//					}
//				}
//				if (stp6== false) {
//					appointments6.setStringSaat("10:15");
//					appointmentList.add(appointments6);
//				}
//
//				AppointmentDTO appointments7 = new AppointmentDTO();
//				boolean stp7 = false;
//				for (AppointmentDTO appointment2 : appointmentList) {
//					if (appointment2.getStringSaat().equals("10:30")) {
//						stp7 = true;
//						break;
//					}
//				}
//				if (stp7== false) {
//					appointments7.setStringSaat("10:30");
//					appointmentList.add(appointments7);
//				}

				appointmentTableModel.setAppointmentList(appointmentList);
				appointmentTable.setModel(appointmentTableModel);
				appointmentTableModel.fireTableDataChanged();

				JFrame f;
				f = new JFrame();
				JOptionPane.showMessageDialog(f, "Please,select a hour to create appointment", "Alert",
						JOptionPane.WARNING_MESSAGE);
//				if(appointmentTable.getSelectedRow()!=-1) {
//					AppointmentEditor appointmentEditor = new AppointmentEditor();
//					appointmentEditor.setAppointmentOrganization(organizationDTO);
//					appointment = appointmentEditor.showDialog();
//				}
				appointmentTable.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (appointmentTable.getSelectedRow() != -1) {
							AppointmentDTO appointmentDTO = appointmentTableModel.getAppointmentList()
									.get(appointmentTable.getSelectedRow());
							AppointmentEditor appointmentEditor = new AppointmentEditor();
							appointmentEditor.setAppointmentOrganization(organizationDTO);
							appointmentEditor.setAppointmentDTOList(appointmentList);
							appointmentEditor.setAppointmentDTO(appointmentDTO);
							appointment = appointmentEditor.showDialog();

						}
					}
				});

			} else if (cmd.contentEquals("UPDATE")) {
				if (appointmentTable.getSelectedRow() == -1) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,select poliklinik", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					System.out.println("update is clicked");
					AppointmentEditor appointmentEditor = new AppointmentEditor();
					appointment = appointmentEditor.showDialog();

				}
			}
		}

	}

}
