package com.erc.view.appointment;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.erc.entities.AppointmentDTO;
import com.erc.entities.OrganizationDTO;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;
import com.erc.entities.StaffTypeDTO;
import com.erc.user.service.AppointmentService;
import com.erc.user.service.PatientService;
import com.erc.user.service.StaffService;
import com.erc.user.service.StaffTypeService;

public class AppointmentEditor extends JPanel {
	private JTextField notText;
	private AppointmentDoctorComboboxModel doctorComboboxModel = new AppointmentDoctorComboboxModel();
	private JComboBox doctorBox;
	private JComboBox patientBox;
	private AppointmentPatientComboboxModel patientComboboxModel = new AppointmentPatientComboboxModel();
	private AppointmentDTO appointment = new AppointmentDTO();
	private JDialog dialog = new JDialog();
	private AppointmentPanel panel = new AppointmentPanel();
	private OrganizationDTO organizationDTO;
	private JTextField txtOrganization;
	private ArrayList<AppointmentDTO> appointmentDTOList;
	private AppointmentRow appointmentRow;
	private SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
	private JTextField txtAppointmentDate;
	private PatientDTO patientDTO = new PatientDTO();
	private StaffDTO staffDTO = new StaffDTO();
	private AppointmentTableModel2 tableModel = new AppointmentTableModel2();

	public ArrayList<AppointmentDTO> getAppointmentDTOList() {
		return appointmentDTOList;
	}

	public void setAppointmentDTOList(ArrayList<AppointmentDTO> appointmentDTOList) {
		this.appointmentDTOList = appointmentDTOList;
	}

	public AppointmentRow getAppointmentRow() {
		return appointmentRow;
	}

	public void setAppointmentRow(AppointmentRow appointmentRow) {
		this.appointmentRow = appointmentRow;
		setAppointment(appointmentRow.getAppointment());
	}

	public AppointmentEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 0, 0, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblAppointmentDate = new JLabel("Randevu Tarihi");
		GridBagConstraints gbc_lblAppointmentDate = new GridBagConstraints();
		gbc_lblAppointmentDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblAppointmentDate.gridx = 1;
		gbc_lblAppointmentDate.gridy = 1;
		add(lblAppointmentDate, gbc_lblAppointmentDate);

		txtAppointmentDate = new JTextField();
		txtAppointmentDate.setEditable(false);
		txtAppointmentDate.setColumns(10);
		GridBagConstraints gbc_txtAppointmentDate = new GridBagConstraints();
		gbc_txtAppointmentDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtAppointmentDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAppointmentDate.gridx = 3;
		gbc_txtAppointmentDate.gridy = 1;
		add(txtAppointmentDate, gbc_txtAppointmentDate);

		JLabel lblHasta = new JLabel("Hasta:");
		GridBagConstraints gbc_lblHasta = new GridBagConstraints();
		gbc_lblHasta.anchor = GridBagConstraints.WEST;
		gbc_lblHasta.insets = new Insets(0, 0, 5, 5);
		gbc_lblHasta.gridx = 1;
		gbc_lblHasta.gridy = 2;
		add(lblHasta, gbc_lblHasta);

		patientBox = new JComboBox();
		GridBagConstraints gbc_patientBox = new GridBagConstraints();
		gbc_patientBox.insets = new Insets(0, 0, 5, 5);
		gbc_patientBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_patientBox.gridx = 3;
		gbc_patientBox.gridy = 2;
		add(patientBox, gbc_patientBox);

		PatientService patientService = new PatientService();
		ArrayList<PatientDTO> patientList = patientService.getAllPatients();
		patientComboboxModel.setPatientList(patientList);
		patientBox.setModel(patientComboboxModel);

		JLabel lblDoktor = new JLabel("Doktor:");
		GridBagConstraints gbc_lblDoktor = new GridBagConstraints();
		gbc_lblDoktor.anchor = GridBagConstraints.WEST;
		gbc_lblDoktor.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoktor.gridx = 1;
		gbc_lblDoktor.gridy = 3;
		add(lblDoktor, gbc_lblDoktor);

		doctorBox = new JComboBox();
		GridBagConstraints gbc_doctorBox = new GridBagConstraints();
		gbc_doctorBox.insets = new Insets(0, 0, 5, 5);
		gbc_doctorBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_doctorBox.gridx = 3;
		gbc_doctorBox.gridy = 3;
		add(doctorBox, gbc_doctorBox);

		StaffService StaffService = new StaffService();
		ArrayList<StaffDTO> staff = StaffService.getAllStaff();
		doctorComboboxModel.setStaffTypes(staff);
		doctorBox.setModel(doctorComboboxModel);

		JLabel lblNot = new JLabel("Randevu Notu:");
		GridBagConstraints gbc_lblNot = new GridBagConstraints();
		gbc_lblNot.anchor = GridBagConstraints.WEST;
		gbc_lblNot.insets = new Insets(0, 0, 5, 5);
		gbc_lblNot.gridx = 1;
		gbc_lblNot.gridy = 4;
		add(lblNot, gbc_lblNot);

		notText = new JTextField();
		GridBagConstraints gbc_notText = new GridBagConstraints();
		gbc_notText.insets = new Insets(0, 0, 5, 5);
		gbc_notText.fill = GridBagConstraints.HORIZONTAL;
		gbc_notText.gridx = 3;
		gbc_notText.gridy = 4;
		add(notText, gbc_notText);
		notText.setColumns(10);

		EditorHandler editorHandler = new EditorHandler();

		JLabel lblNewLabel = new JLabel("Organizasyon:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		add(lblNewLabel, gbc_lblNewLabel);

		txtOrganization = new JTextField();
		txtOrganization.setEditable(false);
		GridBagConstraints gbc_txtOrganization = new GridBagConstraints();
		gbc_txtOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_txtOrganization.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrganization.gridx = 3;
		gbc_txtOrganization.gridy = 5;
		add(txtOrganization, gbc_txtOrganization);
		txtOrganization.setColumns(10);

		JButton btnSave = new JButton("KAYDET");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 7;
		add(btnSave, gbc_btnSave);

		btnSave.addActionListener(editorHandler);
		btnSave.setActionCommand("SAVE");

	}

	public class EditorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();

			if (cmd.equals("SAVE")) {
				System.out.println("save is clicked");
				String not = notText.getText();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date createDate = new Date(System.currentTimeMillis());
				formatter.format(createDate);
				Date updateDate = new Date(System.currentTimeMillis());
				formatter.format(updateDate);

				if (patientBox.getSelectedItem() == null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,select patient", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (doctorBox.getSelectedItem() == null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,select doctor", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}

				appointment.setNote(not);

				if (appointment.getAppointmentCreate() == null) {
					appointment.setAppointmentCreate(createDate);
				} else {
					appointment.setAppointmentUpdate(updateDate);
				}

				patientDTO = patientComboboxModel.getPatientList().get(patientBox.getSelectedIndex());
				appointment.setPatientID(patientDTO.getPatientId());
		//		appointment.setPatientName(patientDTO);
				String patientName;
				if (patientBox.getSelectedItem() != null) {
					patientName = patientBox.getSelectedItem().toString();
				}
				staffDTO = doctorComboboxModel.getStaffTypes().get(doctorBox.getSelectedIndex());
				
				appointment.setDoctorID(staffDTO.getPersonid());
		//		appointment.setDoctorName(staffDTO);

				tableModel.setStaffDTO(staffDTO);

				appointment.setOrganizationName(organizationDTO.getoptionsName());
				appointment.setOrganizationID(organizationDTO.getoptionsID());

				appointment.setDate(appointmentRow.getDate());
				String hour = hourFormat.format(appointmentRow.getDate());
				appointment.setStringSaat(hour);
				appointment.setDate(appointmentRow.getDate());
				appointment.setPatientDTO(patientDTO);
				appointment.setStaffDTO(staffDTO);

				AppointmentService appointmentService = new AppointmentService();
				appointment = appointmentService.saveAppointment(appointment);
				appointmentRow.setAppointment(appointment);
				dialog.dispose();
			}

		}

	}

	public AppointmentDTO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentDTO appointment) {
		this.appointment = appointment;
	}

	public AppointmentRow showDialog() {
		dialog.getContentPane().add(this);
		dialog.setModal(true);
		dialog.setSize(480, 230);
		dialog.setLocationRelativeTo(this);
		fillScreen();
		dialog.setVisible(true);
		return appointmentRow;
	}

	private void fillScreen() {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
		txtAppointmentDate.setText(dateFormatter.format(appointmentRow.getDate()));
		if (appointment != null) {
			txtOrganization.setText(organizationDTO.getoptionsName());
			notText.setText(appointment.getNote());
			if (appointment.getStaffDTO() != null) {
				doctorBox.setSelectedItem(
						appointment.getStaffDTO().getName() + " " + appointment.getStaffDTO().getLastname());
			}
			if (appointment.getPatientDTO() != null) {
				patientBox.setSelectedItem(
						appointment.getPatientDTO().getName() + " " + appointment.getPatientDTO().getSurname());
			}
		}
	}

	public void setAppointmentOrganization(OrganizationDTO organizationDTO) {
		this.organizationDTO = organizationDTO;
	}

}
