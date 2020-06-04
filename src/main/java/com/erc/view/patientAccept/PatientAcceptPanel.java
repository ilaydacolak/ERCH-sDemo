package com.erc.view.patientAccept;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.erc.entities.AdmissionDTO;
import com.erc.entities.OrganizationDTO;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;
import com.erc.entities.StaffTypeDTO;
import com.erc.user.service.AdmissionService;
import com.erc.user.service.OptionsService;
import com.erc.user.service.PatientService;
import com.erc.user.service.StaffService;
import com.erc.user.service.StaffTypeService;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.TextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class PatientAcceptPanel extends JPanel {
	public JTextField txtAccept;
	public JTextField textPatient;
	private AcceptOrganizationsComboboxModel orgCombobox = new AcceptOrganizationsComboboxModel();
	public JComboBox OrganizationCombobox;
	private JTable table = new JTable();
	public JComboBox DoctorCombobox;
	private DoctorComboboxModel drCombobox = new DoctorComboboxModel();
	private JLabel lblNameSurname;
	private String patientNo;
	public JRadioButton ayaktaradio;
	private JRadioButton yatanradio;
	private JRadioButton dayradio;
	private ButtonGroup btngrp = new ButtonGroup();;
	public JDateChooser dateChooser;
	public AdmissionDTO admission;
	private JDialog dialog = new JDialog();
	private JCalendar calendar;
	private AcceptTableModel tableModel = new AcceptTableModel();
	private JScrollPane scrollPane;
	public JButton btnClear;
	public JButton btnSave;

	public PatientAcceptPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 10, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		btnSave = new JButton("Kaydet");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 1;
		add(btnSave, gbc_btnSave);

		btnClear = new JButton("Temizle");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 3;
		gbc_btnClear.gridy = 1;
		add(btnClear, gbc_btnClear);
		EditorHandler editorHandler = new EditorHandler();
		btnClear.addActionListener(editorHandler);
		btnClear.setActionCommand("TEMÝZLE");

		JLabel lblAcceptNo = new JLabel("Kabul No:");
		GridBagConstraints gbc_lblAcceptNo = new GridBagConstraints();
		gbc_lblAcceptNo.gridwidth = 2;
		gbc_lblAcceptNo.anchor = GridBagConstraints.WEST;
		gbc_lblAcceptNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcceptNo.gridx = 2;
		gbc_lblAcceptNo.gridy = 3;
		add(lblAcceptNo, gbc_lblAcceptNo);

		txtAccept = new JTextField();
		GridBagConstraints gbc_txtAccept = new GridBagConstraints();
		gbc_txtAccept.gridwidth = 2;
		gbc_txtAccept.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAccept.insets = new Insets(0, 0, 5, 5);
		gbc_txtAccept.gridx = 4;
		gbc_txtAccept.gridy = 3;
		add(txtAccept, gbc_txtAccept);
		txtAccept.setColumns(10);

		JLabel lblPatient = new JLabel("Patient:");
		GridBagConstraints gbc_lblPatient = new GridBagConstraints();
		gbc_lblPatient.gridwidth = 2;
		gbc_lblPatient.anchor = GridBagConstraints.WEST;
		gbc_lblPatient.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatient.gridx = 2;
		gbc_lblPatient.gridy = 5;
		add(lblPatient, gbc_lblPatient);

		textPatient = new JTextField();
		GridBagConstraints gbc_textPatient = new GridBagConstraints();
		gbc_textPatient.gridwidth = 2;
		gbc_textPatient.insets = new Insets(0, 0, 5, 5);
		gbc_textPatient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPatient.gridx = 4;
		gbc_textPatient.gridy = 5;
		add(textPatient, gbc_textPatient);
		textPatient.setColumns(10);

		lblNameSurname = new JLabel("New label");
		GridBagConstraints gbc_lblNameSurname = new GridBagConstraints();
		gbc_lblNameSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNameSurname.gridx = 6;
		gbc_lblNameSurname.gridy = 5;
		add(lblNameSurname, gbc_lblNameSurname);
		lblNameSurname.setText(null);

		JLabel lblAcceptType = new JLabel("Kabul Tipi:");
		GridBagConstraints gbc_lblAcceptType = new GridBagConstraints();
		gbc_lblAcceptType.gridwidth = 2;
		gbc_lblAcceptType.anchor = GridBagConstraints.WEST;
		gbc_lblAcceptType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcceptType.gridx = 2;
		gbc_lblAcceptType.gridy = 7;
		add(lblAcceptType, gbc_lblAcceptType);

		ayaktaradio = new JRadioButton("Ayakta");
		GridBagConstraints gbc_ayaktaradio = new GridBagConstraints();
		gbc_ayaktaradio.anchor = GridBagConstraints.WEST;
		gbc_ayaktaradio.insets = new Insets(0, 0, 5, 5);
		gbc_ayaktaradio.gridx = 4;
		gbc_ayaktaradio.gridy = 7;
		add(ayaktaradio, gbc_ayaktaradio);
		btngrp.add(ayaktaradio);

		yatanradio = new JRadioButton("Yatan");
		GridBagConstraints gbc_yatanradio = new GridBagConstraints();
		gbc_yatanradio.insets = new Insets(0, 0, 5, 5);
		gbc_yatanradio.gridx = 5;
		gbc_yatanradio.gridy = 7;
		add(yatanradio, gbc_yatanradio);
		btngrp.add(yatanradio);

		dayradio = new JRadioButton("G\u00FCn\u00FCbirlik");
		GridBagConstraints gbc_dayradio = new GridBagConstraints();
		gbc_dayradio.insets = new Insets(0, 0, 5, 5);
		gbc_dayradio.gridx = 6;
		gbc_dayradio.gridy = 7;
		add(dayradio, gbc_dayradio);
		btngrp.add(dayradio);

		JLabel lblAcceptOrganization = new JLabel("Kabul Organizasyonu");
		GridBagConstraints gbc_lblAcceptOrganization = new GridBagConstraints();
		gbc_lblAcceptOrganization.gridwidth = 2;
		gbc_lblAcceptOrganization.anchor = GridBagConstraints.WEST;
		gbc_lblAcceptOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcceptOrganization.gridx = 2;
		gbc_lblAcceptOrganization.gridy = 9;
		add(lblAcceptOrganization, gbc_lblAcceptOrganization);

		OrganizationCombobox = new JComboBox();
		GridBagConstraints gbc_OrganizationCombobox = new GridBagConstraints();
		gbc_OrganizationCombobox.gridwidth = 3;
		gbc_OrganizationCombobox.insets = new Insets(0, 0, 5, 5);
		gbc_OrganizationCombobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_OrganizationCombobox.gridx = 4;
		gbc_OrganizationCombobox.gridy = 9;
		add(OrganizationCombobox, gbc_OrganizationCombobox);

		OptionsService service = new OptionsService();
		ArrayList<OrganizationDTO> options = service.getAllOptions();
		orgCombobox.setOptions(options);
		OrganizationCombobox.setModel(orgCombobox);

		JLabel lblAcceptDoctor = new JLabel("Kabul Doktoru:");
		GridBagConstraints gbc_lblAcceptDoctor = new GridBagConstraints();
		gbc_lblAcceptDoctor.gridwidth = 2;
		gbc_lblAcceptDoctor.anchor = GridBagConstraints.WEST;
		gbc_lblAcceptDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcceptDoctor.gridx = 2;
		gbc_lblAcceptDoctor.gridy = 11;
		add(lblAcceptDoctor, gbc_lblAcceptDoctor);

		DoctorCombobox = new JComboBox();
		GridBagConstraints gbc_DoctorCombobox = new GridBagConstraints();
		gbc_DoctorCombobox.gridwidth = 3;
		gbc_DoctorCombobox.insets = new Insets(0, 0, 5, 5);
		gbc_DoctorCombobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_DoctorCombobox.gridx = 4;
		gbc_DoctorCombobox.gridy = 11;
		add(DoctorCombobox, gbc_DoctorCombobox);

		StaffService StaffService = new StaffService();
		ArrayList<StaffDTO> staff = StaffService.getAllStaff();
		drCombobox.setStaffTypes(staff);
		DoctorCombobox.setModel(drCombobox);

		JLabel lblDate = new JLabel("Kabul Tarihi");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.gridwidth = 2;
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 2;
		gbc_lblDate.gridy = 13;
		add(lblDate, gbc_lblDate);

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 4;
		gbc_dateChooser.gridy = 13;
		add(dateChooser, gbc_dateChooser);

		final String DATE_FORMAT = "dd/MM/yyyy hh:mm:ss.SSS";
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

		Calendar currentTime = Calendar.getInstance();

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		formatter2.format(today);
		dateChooser.setMinSelectableDate(
				java.util.Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		LocalDate tomorrow = today.plusDays(14);
		dateChooser.setMaxSelectableDate(
				java.util.Date.from(tomorrow.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		btnSave.addActionListener(editorHandler);
		btnSave.setActionCommand("SAVE");
		
				JButton btnOk = new JButton("TAMAM");
				GridBagConstraints gbc_btnOk = new GridBagConstraints();
				gbc_btnOk.insets = new Insets(0, 0, 5, 5);
				gbc_btnOk.gridx = 6;
				gbc_btnOk.gridy = 16;
				add(btnOk, gbc_btnOk);
				btnOk.addActionListener(editorHandler);
				btnOk.setActionCommand("OK");

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 18;
		add(scrollPane, gbc_scrollPane);

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

	}

	public class EditorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			if (cmd.equals("OK")) {
				System.out.println("ok clicked");
				patientNo = textPatient.getText();
				boolean isExist = false;

				if (patientNo.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter PatientNo", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (ayaktaradio.isSelected()) {
					yatanradio.setSelected(false);
					dayradio.setSelected(false);
				} else if (yatanradio.isSelected()) {
					ayaktaradio.setSelected(false);
					dayradio.setSelected(false);
				} else if (dayradio.isSelected()) {
					ayaktaradio.setSelected(false);
					yatanradio.setSelected(false);
				}
				

				PatientService patientService = new PatientService();
				PatientDTO patient = patientService.getPatientByPatientNo(patientNo);
				if (patient == null) {
					JOptionPane.showMessageDialog(new JFrame(), "Hasta yok ", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					lblNameSurname.setText(patient.getName() + " " + patient.getSurname());
					if (admission == null) {
						admission = new AdmissionDTO();
					}
					admission.setPatientID(patientNo);
					getPastAdmissionListFromDB();
				}
				
				textPatient.disable();
				System.out.println("fördü");

			} else if (cmd.equals("TEMÝZLE")) {
				txtAccept.setText("");
				textPatient.setText("");
				lblNameSurname.setText("");
				textPatient.enable();
				btngrp.clearSelection();
				dateChooser.setDate(null);
				drCombobox.setSelectedItem(null);
				orgCombobox.setSelectedItem(null);
				tableModel.setRowCount(null);
				tableModel.fireTableDataChanged();

				// DoctorCombobox.removeAllItems();

			} else if (cmd.equals("SAVE")) {

				String patientNum = textPatient.getText();
				// String admissionOrg = OrganizationCombobox.getSelectedItem().toString();
				// String admissionDoctor = DoctorCombobox.getSelectedItem().toString();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date createDate = new Date(System.currentTimeMillis());
				formatter.format(createDate);
				Date updateDate = new Date(System.currentTimeMillis());
				formatter.format(updateDate);
				Date admissionDate = dateChooser.getDate();

				if (patientNum.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter PatientNo", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (OrganizationCombobox.getSelectedItem() == null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,select organization", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else if (DoctorCombobox.getSelectedItem() == null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,select doctor", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (btngrp.getSelection() == null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,select admission type", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				} else if (dateChooser.getDate() == null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,select date", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (admission == null) {
					admission = new AdmissionDTO();
				}

				ThreadLocalRandom random = ThreadLocalRandom.current();
				int randomInt = random.nextInt(100000, 999999);

				admission.setAdmissionNo(Integer.toString(randomInt));
				txtAccept.setText(admission.getAdmissionNo());

				admission.setPatientID(patientNum);
				if (ayaktaradio.isSelected()) {
					admission.setAdmissionType("O");
				} else if (yatanradio.isSelected()) {
					admission.setAdmissionType("I");
				} else if (dayradio.isSelected()) {
					admission.setAdmissionType("D");
				}
				OrganizationDTO organization = orgCombobox.getOptions().get(OrganizationCombobox.getSelectedIndex());				
				admission.setOrganizationID(OrganizationCombobox.getSelectedItem().toString());
	//			admission.setOrganizationID(organization.getoptionsID());
				
				StaffDTO staff = drCombobox.getStaffTypes().get(DoctorCombobox.getSelectedIndex());
	//			admission.setDoctorID(staff.getPersonid());
				admission.setDoctorID(DoctorCombobox.getSelectedItem().toString());
				admission.setAdmissionDate(admissionDate);
				if (admission.getAdmissionCreate() == null) {
					admission.setAdmissionCreate(createDate);
				} else {
					admission.setAdmissionUpdate(updateDate);
				}

				AdmissionService service = new AdmissionService();
				admission = service.saveAdmission(admission);
				JFrame f;
				f = new JFrame();
				JOptionPane.showMessageDialog(f, "Kayýt iþlemi baþarýlý", "Alert", JOptionPane.WARNING_MESSAGE);
				dialog.dispose();
				getAdmissionListFromDB();

			}
		}

	}

	private void getAdmissionListFromDB() {
		AdmissionService service = new AdmissionService();
		String admissionID = admission.getPatientID();
		ArrayList<AdmissionDTO> admissionListTable = new ArrayList<AdmissionDTO>();
		ArrayList<AdmissionDTO> admissonDTO = service.getAllAdmissionPatients();
		for (AdmissionDTO admissionList : admissonDTO) {
			if (admissionList.getPatientID().equals(admissionID)) {
				admissionListTable.add(admissionList);
			}
		}
		tableModel.setAdmissionList(admissionListTable);
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	private void getPastAdmissionListFromDB() {
		AdmissionService service = new AdmissionService();
		String admissionID = admission.getPatientID();
		ArrayList<AdmissionDTO> admissionListTable = new ArrayList<AdmissionDTO>();
		ArrayList<AdmissionDTO> admissonDTO = service.getAllAdmissionPatients();
		for (AdmissionDTO admissionList : admissonDTO) {
			if (admissionList.getPatientID() == admissionID) {
				admissionListTable.add(admissionList);
			}
		}
		tableModel.setAdmissionList(admissionListTable);
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	public AdmissionDTO getAdmission() {
		return admission;

	}

	public void setAdmission(AdmissionDTO admission) {
		this.admission = admission;
	}

	public AdmissionDTO showDialog() {
		// TODO Auto-generated method stub
		dialog.getContentPane().add(this);
		dialog.setModal(true);
		dialog.setSize(450, 380);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);

		return admission;

	}

}
