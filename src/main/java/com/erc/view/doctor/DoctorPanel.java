package com.erc.view.doctor;

import javax.swing.JPanel;
import javax.swing.JFrame;
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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.erc.entities.AppointmentDTO;
import com.erc.entities.MedicalOrderDTO;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;
import com.erc.login.AuthService;
import com.erc.login.LoginPanel;
import com.erc.user.service.AppointmentService;
import com.erc.user.service.MedicalOrderService;
import com.erc.user.service.PatientService;
import com.erc.user.service.StaffService;
import com.toedter.calendar.JDateChooser;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	private AdmissionPanel admissionPanel = new AdmissionPanel();
	public static StaffDTO staffDTO;
	private InformationsPanel informationsPanel = new InformationsPanel();

	public DoctorPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 130, 0, 150, 150, 150, 100, 150, 150, 150, 100 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		today = LocalDate.now();
		formatter.format(today);

		Handler handler = new Handler();

		PatientService patientService = new PatientService();
		ArrayList<PatientDTO> patientList = patientService.getAllPatients();
		patientComboboxModel.setPatientList(patientList);
		scrollPanePatient = new JScrollPane();

		patientPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					patientTable();
				}
			}
		});

		patientPanel.setVisible(true);

		GridBagConstraints gbc_scrollPanePatient = new GridBagConstraints();
		gbc_scrollPanePatient.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPanePatient.gridwidth = 4;
		gbc_scrollPanePatient.gridheight = 4;
		gbc_scrollPanePatient.fill = GridBagConstraints.BOTH;
		gbc_scrollPanePatient.gridx = 3;
		gbc_scrollPanePatient.gridy = 1;
		add(patientPanel, gbc_scrollPanePatient);

		GridBagConstraints gbc_scrollPaneAdmission = new GridBagConstraints();
		gbc_scrollPaneAdmission.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneAdmission.gridwidth = 4;
		gbc_scrollPaneAdmission.gridheight = 4;
		gbc_scrollPaneAdmission.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAdmission.gridx = 7;
		gbc_scrollPaneAdmission.gridy = 1;
		add(admissionPanel, gbc_scrollPaneAdmission);

		// scrollPanePatient.setViewportView(patientTable);

		patientCMBX = new JComboBox();
		GridBagConstraints gbc_patientCMBX = new GridBagConstraints();
		gbc_patientCMBX.insets = new Insets(0, 0, 5, 5);
		gbc_patientCMBX.fill = GridBagConstraints.HORIZONTAL;
		gbc_patientCMBX.gridx = 1;
		gbc_patientCMBX.gridy = 2;
		add(patientCMBX, gbc_patientCMBX);
		patientCMBX.setModel(patientComboboxModel);

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
		gbc_dateChooser.gridy = 3;
		add(dateChooser, gbc_dateChooser);

		dateChooser.setDate(java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

		JButton btnUpdate = new JButton("Listeyi Yenile");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 1;
		gbc_btnUpdate.gridy = 4;
		add(btnUpdate, gbc_btnUpdate);
		btnUpdate.addActionListener(handler);
		btnUpdate.setActionCommand("UPDATE");

		ArrayList<AppointmentDTO> appointmentDTO = new ArrayList<AppointmentDTO>();

		appointmentTableModel.setAppointmentList(appointmentDTO);

		scrollPane = new JScrollPane();

		appointmentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				if (SwingUtilities.isRightMouseButton(event)) {
					if (appointmentTable.getSelectedRow() != -1) {
						AppointmentDTO appointmentDTO = appointmentTableModel.getAppointmentList()
								.get(appointmentTable.getSelectedRow());
						MedicalOrderDTO medicalOrderDTO = new MedicalOrderDTO();

						boolean protocol = false;
						MedicalOrderService medicalOrderService = new MedicalOrderService();
						ArrayList<MedicalOrderDTO> medicalOrderList = medicalOrderService.gelMedicalOrderList();
						for (MedicalOrderDTO medicalOrder : medicalOrderList) {
							if (appointmentDTO.getAdmissionDTO().getAdmissionID()
									.equals(medicalOrder.getAdmissionDTO().getAdmissionID())) {
								protocol = true;
								break;
							}
						}
						if (protocol == false) {
							JDialog.setDefaultLookAndFeelDecorated(true);
							int response = JOptionPane.showConfirmDialog(null,
									"Protokol oluþturmak zorunludur.Devam edilsin mi?", "Onay",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (response == JOptionPane.NO_OPTION) {
								System.out.println("No button clicked");
							} else if (response == JOptionPane.YES_OPTION) {
								System.out.println("Yes button clicked");

								medicalOrderDTO.setAdmissionDTO(appointmentDTO.getAdmissionDTO());
								if (appointmentDTO.getAdmissionDTO().getAdmissionType().equals("I")) {
									medicalOrderDTO.setModule("OPM");
								} else {
									medicalOrderDTO.setModule("IPM");
								}
								medicalOrderDTO.setOrganizationDTO(appointmentDTO.getOrganizationDTO());
								if (medicalOrderDTO.getDateCreated() == null) {
									ZoneId defaultZoneId = ZoneId.systemDefault();
									medicalOrderDTO.setDateCreated(
											Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant()));
								} else {
									ZoneId defaultZoneId = ZoneId.systemDefault();
									medicalOrderDTO.setDateUpdated(
											Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant()));
								}
								Random rand = new Random();

								// Generate random integers in range 0 to 999
								medicalOrderDTO.setOrderNo(String.valueOf(rand.nextInt(1000)));
								LoginPanel loginPanel = new LoginPanel();

								if (medicalOrderDTO.getUserCreated() == null) {
									medicalOrderDTO.setUserCreated(staffDTO);
								} else {
									medicalOrderDTO.setUserUpdated(staffDTO);
								}

								medicalOrderService.saveMedicalOrder(medicalOrderDTO);

							} else if (response == JOptionPane.CLOSED_OPTION) {
								System.out.println("JOptionPane closed");
							}

						}
					}
				}
			}
		});

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);

		appointmentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					if (appointmentTable.getSelectedRow() != -1) {
						AppointmentDTO appointment = appointmentTableModel.getAppointmentList()
								.get(appointmentTable.getSelectedRow());
						fillAppointmentPatient(appointment.getPatientDTO());
						admissionPanel.fillAdmissionPatient(appointment.getAdmissionDTO());

					} else {
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Please select patient", "Alert", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}

			}
		});
		appointmentTable.setModel(appointmentTableModel);
		scrollPane.setViewportView(appointmentTable);
		
		GridBagConstraints gbc_scrollPaneInformations = new GridBagConstraints();
		gbc_scrollPaneInformations.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneInformations.gridwidth = 8;
		gbc_scrollPaneInformations.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneInformations.gridx = 3;
		gbc_scrollPaneInformations.gridy = 6;
		add(informationsPanel, gbc_scrollPaneInformations);

		patientTableModel.fireTableDataChanged();

		getAppointmentListFromService();
	}

	public static void setStaffDTO(StaffDTO staffDTO) {
		DoctorPanel.staffDTO = staffDTO;
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
						// scrollPanePatient.setViewportView(patientPanel);

//
					}
				}
			}
		}

	}

	private void fillAppointmentPatient(PatientDTO patient) {
		patientPanel.fillScreen(patient);
	}

	private void getAppointmentListFromService() {
		AppointmentService appointmentService = new AppointmentService();
		ArrayList<AppointmentDTO> appointmentList = appointmentService.getAllAppointmentList();
		ArrayList<AppointmentDTO> appointmentTableList = new ArrayList<AppointmentDTO>();

		for (AppointmentDTO appointment : appointmentList) {

			AuthService authService = new AuthService();

			if (!(appointment.getOrganizationID().equals(null))) {
				if (appointment.getAppointmentCreate().compareTo(dateChooser.getDate()) == 0
						&& appointment.getDoctorID().equals(authService.getStaffDTO().getPersonid())
						&& appointment.getAdmissionDTO() != null) {
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
