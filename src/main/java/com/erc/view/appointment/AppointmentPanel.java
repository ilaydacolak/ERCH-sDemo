package com.erc.view.appointment;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import com.toedter.calendar.JDayChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import com.toedter.components.JLocaleChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.erc.entities.AdmissionDTO;
import com.erc.entities.AppointmentDTO;
import com.erc.entities.OrganizationDTO;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;
import com.erc.user.service.AdmissionService;
import com.erc.user.service.AppointmentService;
import com.erc.user.service.OptionsService;
import com.erc.user.service.PatientService;
import com.erc.user.service.StaffService;
import com.erc.view.appointment.AppointmentTableModel2.MyTableCellRenderer;
import com.erc.view.patientAccept.PatientAcceptPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import java.util.ArrayList;
import java.util.List;
import java.time.ZoneId;
import com.toedter.calendar.JCalendar;

public class AppointmentPanel extends JPanel {
	public AppointmentOrganizationTableModel organizationTableModel = new AppointmentOrganizationTableModel();
	public JTable organizationTable = new JTable();
	private AppointmentTableModel2 appointmentTableModel = new AppointmentTableModel2();
	private JTable appointmentTable = new JTable();
	private JDateChooser dateChooser = new JDateChooser();
	private MyTableCellRenderer myTableCellRenderer;

	public AppointmentPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 10, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		Handler handler = new Handler();

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 1;
		add(dateChooser, gbc_dateChooser);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		formatter.format(today);

		dateChooser.setDate(java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

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
		gbc_randevuUpdBtn.insets = new Insets(0, 0, 5, 5);
		gbc_randevuUpdBtn.gridx = 5;
		gbc_randevuUpdBtn.gridy = 1;
		add(randevuUpdBtn, gbc_randevuUpdBtn);

		randevuUpdBtn.addActionListener(handler);
		randevuUpdBtn.setActionCommand("UPDATE");

		JButton btnDelete = new JButton("Randevu Sil");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 7;
		gbc_btnDelete.gridy = 1;
		add(btnDelete, gbc_btnDelete);

		btnDelete.addActionListener(handler);
		btnDelete.setActionCommand("DELETE");

		JButton btnAdmission = new JButton("Kabul Et");
		GridBagConstraints gbc_btnAdmission = new GridBagConstraints();
		gbc_btnAdmission.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdmission.gridx = 9;
		gbc_btnAdmission.gridy = 1;
		add(btnAdmission, gbc_btnAdmission);

		btnAdmission.addActionListener(handler);
		btnAdmission.setActionCommand("Kaydet");

		JScrollPane OrganizationPane = new JScrollPane();
		GridBagConstraints gbc_OrganizationPane = new GridBagConstraints();
		gbc_OrganizationPane.insets = new Insets(0, 0, 5, 5);
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
		gbc_RandevuPane.insets = new Insets(0, 0, 5, 5);
		gbc_RandevuPane.gridwidth = 8;
		gbc_RandevuPane.fill = GridBagConstraints.BOTH;
		gbc_RandevuPane.gridx = 3;
		gbc_RandevuPane.gridy = 3;
		add(RandevuPane, gbc_RandevuPane);

		appointmentTable.setModel(appointmentTableModel);
		RandevuPane.setViewportView(appointmentTable);

		appointmentTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				AppointmentTableModel2 modelRef = (AppointmentTableModel2) table.getModel();
				AppointmentRow appRow = modelRef.getAppointmentList().get(row);
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);

				AppointmentDTO appointment = appRow.getAppointment();
				if (appointment.getAppointmentID() != null) {
					c.setBackground(new Color(120, 255, 117));
				} else {
					c.setBackground(Color.white);
				}
				return c;
			}
		});
	}

	private void getAppointmentListFromService() {

		appointmentTableModel.getAppointmentList().clear();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 8);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		boolean finished = false;

		while (!finished) {

			AppointmentRow appointmentRow = new AppointmentRow();
			appointmentRow.setDate(cal.getTime());
			AppointmentDTO emptyAppointment = new AppointmentDTO();
			appointmentRow.setAppointment(emptyAppointment);
			appointmentTableModel.addAppointmentRow(appointmentRow);

			Calendar loopTime = Calendar.getInstance();

			cal.add(Calendar.MINUTE, 15);
			loopTime.setTime(cal.getTime());

			System.out.println(loopTime.getTime());
			if (loopTime.get(Calendar.HOUR_OF_DAY) == 17 && loopTime.get(Calendar.MINUTE) == 15) {
				finished = true;
			}
			appointmentTableModel.fireTableDataChanged();
		}
		getFilledAppointmentList();
	}

	private void getFilledAppointmentList() {
		AppointmentService service = new AppointmentService();
		ArrayList<AppointmentDTO> appList = service.getAllAppointmentList();
		OrganizationDTO organization = organizationTableModel.getDataList().get(organizationTable.getSelectedRow());

		Date appointmentDate = dateChooser.getDate();
		int row = 1;

		for (AppointmentDTO appointment : appList) {
			if (appointment.getOrganizationName().equals(organization.getoptionsName())) {
				SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
				ArrayList<AppointmentRow> appRowList = appointmentTableModel.getAppointmentList();
				for (AppointmentRow appRow : appRowList) {
					if (hourFormat.format(appointment.getDate()).equals(hourFormat.format(appRow.getDate()))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						if (dateFormat.format(appointment.getAppointmentCreate())
								.equals(dateFormat.format(appointmentDate))) {

							appRow.setAppointment(appointment);

						}
					}
				}
				appointmentTableModel.fireTableDataChanged();
			}
			row++;
		}

	}

	private void getOptionsListFromService() {
		OptionsService service = new OptionsService();
		ArrayList<OrganizationDTO> optionList = service.getAllOptions();
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
				Date appointmentDate = dateChooser.getDate();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate today = LocalDate.now();
				formatter.format(today);

				SimpleDateFormat currentDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				currentDateTime.format(date);

				SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
				int temp = 0;

				AppointmentRow appRow = appointmentTableModel.getAppointmentList()
						.get(appointmentTable.getSelectedRow());

				if (organizationTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please,select poliklinik", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else if (appointmentTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please,select a hour to create appointment", "Alert",
							JOptionPane.WARNING_MESSAGE);

				} else if (appointmentDate.compareTo(
						java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) < 0) {
					JOptionPane.showMessageDialog(new JFrame(), "You selected old date", "Alert",
							JOptionPane.WARNING_MESSAGE);

				} else if (appointmentDate.compareTo(
						java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) == 0
						&& hourFormat.format(date).compareTo(hourFormat.format(appRow.getDate())) > 0) {
					JOptionPane.showMessageDialog(new JFrame(), "You selected old hour", "Alert",
							JOptionPane.WARNING_MESSAGE);
				} else {
					OrganizationDTO organizationDTO = organizationTableModel.getDataList()
							.get(organizationTable.getSelectedRow());
					int selectedRow = appointmentTable.getSelectedRow();
					AppointmentRow appointmentRow = appointmentTableModel.getAppointmentList().get(selectedRow);
					AppointmentDTO appointment = appointmentRow.getAppointment();

					// appointment id varsa demekki orda hali hazirda bir randevu var demek
					if (appointment.getAppointmentID() != null) {
						JOptionPane.showMessageDialog(new JFrame(), "There is already an appointment at this hour",
								"Alert", JOptionPane.WARNING_MESSAGE);
						return;
					} else {
						// Þimdi dialog acip kayit yapacagiz
						AppointmentEditor appointmentEditor = new AppointmentEditor();
						appointmentEditor.setAppointmentOrganization(organizationDTO);
						appointmentEditor.setAppointmentRow(appointmentRow);
						AppointmentRow appointmentRowTemp = appointmentEditor.showDialog();
						if (appointmentRowTemp.getAppointment().getAppointmentID() != null) { // create edilmisse
							appointmentTableModel.getAppointmentList().set(selectedRow, appointmentRowTemp);
							appointmentTableModel.fireTableDataChanged();
						}
					}
				}

			} else if (cmd.equals("UPDATE")) {
				if (organizationTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please,select poliklinik", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else if (appointmentTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please,an appointment to update", "Alert",
							JOptionPane.WARNING_MESSAGE);

				}
				OrganizationDTO organizationDTO = organizationTableModel.getDataList()
						.get(organizationTable.getSelectedRow());
				int selectedRow = appointmentTable.getSelectedRow();
				AppointmentRow appointmentRow = appointmentTableModel.getAppointmentList().get(selectedRow);
				AppointmentDTO appointment = appointmentRow.getAppointment();
				if (appointment.getAppointmentID() == null) {
					JOptionPane.showMessageDialog(new JFrame(),
							"There is not an appointment.Please select exist an appointment to update", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					AppointmentEditor appointmentEditor = new AppointmentEditor();
					appointmentEditor.setAppointmentOrganization(organizationDTO);
					appointmentEditor.setAppointmentRow(appointmentRow);
					AppointmentRow appointmentRowTemp = appointmentEditor.showDialog();
					if (appointmentRowTemp.getAppointment().getAppointmentID() != null)
						appointmentTableModel.getAppointmentList().set(selectedRow, appointmentRowTemp);
					appointmentTableModel.fireTableDataChanged();
				}
			} else if (cmd.equals("DELETE")) {
				if (organizationTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please,select poliklinik", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else if (appointmentTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please,an appointment to update", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}
				OrganizationDTO organizationDTO = organizationTableModel.getDataList()
						.get(organizationTable.getSelectedRow());
				int selectedRow = appointmentTable.getSelectedRow();
				AppointmentRow appointmentRow = appointmentTableModel.getAppointmentList().get(selectedRow);
				AppointmentDTO appointment = appointmentRow.getAppointment();
				if (appointment.getAppointmentID() == null) {
					JOptionPane.showMessageDialog(new JFrame(), "There is no any appointment", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else {

					AppointmentService service = new AppointmentService();
					service.deleteAppointment(appointment);
					AppointmentRow appRow = new AppointmentRow();
					appRow.setDate(appointment.getDate());
					AppointmentDTO emptyAppointment = new AppointmentDTO();
					appRow.setAppointment(emptyAppointment);
					appointmentTableModel.addAppointmentRow(appRow);
					appointmentTableModel.getAppointmentList().set(selectedRow, appRow);
					appointmentTableModel.fireTableDataChanged();
				}

			} else if (cmd.equals("Kaydet")) {
				if (organizationTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please,select poliklinik", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else if (appointmentTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Please,an appointment for admission", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}
				int selectedRow = appointmentTable.getSelectedRow();
				AppointmentRow appointmentRow = appointmentTableModel.getAppointmentList().get(selectedRow);
				AppointmentDTO appointment = appointmentRow.getAppointment();
				if (appointment.getAppointmentID().equals(null)) {
					JOptionPane.showMessageDialog(new JFrame(), "There is no exist appointment", "Alert",
							JOptionPane.WARNING_MESSAGE);
				} else if (appointment.getAdmissionDTO()==null) {

					System.out.println("var");
					JDialog dialog = new JDialog();
					PatientAcceptPanel admissionPanel = fillScreen(appointment);

					appointment.setAdmissionDTO(admissionPanel.admission);

					AppointmentService appService = new AppointmentService();
					appService.saveAppointment(appointment);

					dialog.getContentPane().add(admissionPanel);
					dialog.setModal(true);
					dialog.setSize(520, 250);
					dialog.setLocationRelativeTo(admissionPanel);

					dialog.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "The patient is already accepted ", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}

			}

		}
	}

	private PatientAcceptPanel fillScreen(AppointmentDTO appointment) {
		PatientAcceptPanel admissionPanel = new PatientAcceptPanel();

		PatientService patientService = new PatientService();
		ArrayList<PatientDTO> patientList = patientService.getAllPatients();
		StaffService staffService = new StaffService();
		ArrayList<StaffDTO> staffList = staffService.getAllStaff();
		for (PatientDTO patient : patientList) {
			if (patient.getPatientId().toString().equals(appointment.getPatientDTO().getPatientId().toString())) {

				admissionPanel.textPatient.setText(patient.getPatientNo().toString());

				System.out.println(admissionPanel.textPatient.getText());

				admissionPanel.OrganizationCombobox.setSelectedItem(appointment.getOrganizationName());

				admissionPanel.dateChooser.setDate(appointment.getDate());

				for (StaffDTO staff : staffList) {
					if (staff.getPersonid().equals(appointment.getDoctorID())) {
						admissionPanel.DoctorCombobox.setSelectedItem(staff.getName() + " " + staff.getLastname());

					}
				}
				admissionPanel.ayaktaradio.doClick();

			}

		}
		admissionPanel.btnSave.doClick();
		admissionPanel.textPatient.enable();
		admissionPanel.btnClear.enable();
		admissionPanel.txtAccept.enable();

		return admissionPanel;
	}

}
