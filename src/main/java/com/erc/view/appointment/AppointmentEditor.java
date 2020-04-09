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
import com.erc.entities.OptionsDTO;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;
import com.erc.user.service.AppointmentService;
import com.erc.user.service.PatientService;
import com.erc.user.service.StaffService;

public class AppointmentEditor extends JPanel {
	private JTextField notText;
	private AppointmentDoctorComboboxModel doctorComboboxModel = new AppointmentDoctorComboboxModel();
	private JComboBox doctorBox;
	private JComboBox patientBox;
	private AppointmentPatientComboboxModel patientComboboxModel = new AppointmentPatientComboboxModel();
	private AppointmentDTO appointment;
	private JDialog dialog = new JDialog();
	private AppointmentPanel panel = new AppointmentPanel();
	private OptionsDTO organizationDTO;
	private JTextField txtOrganization;
	private ArrayList<AppointmentDTO> appointmentDTOList ;
	private AppointmentDTO appointmentDTO;

	public ArrayList<AppointmentDTO> getAppointmentDTOList() {
		return appointmentDTOList;
	}

	public void setAppointmentDTOList(ArrayList<AppointmentDTO> appointmentDTOList) {
		this.appointmentDTOList = appointmentDTOList;
	}
	

	public AppointmentDTO getAppointmentDTO() {
		return appointmentDTO;
	}

	public void setAppointmentDTO(AppointmentDTO appointmentDTO) {
		this.appointmentDTO = appointmentDTO;
	}

	public AppointmentEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 0, 0, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblHasta = new JLabel("Hasta:");
		GridBagConstraints gbc_lblHasta = new GridBagConstraints();
		gbc_lblHasta.anchor = GridBagConstraints.WEST;
		gbc_lblHasta.insets = new Insets(0, 0, 5, 5);
		gbc_lblHasta.gridx = 1;
		gbc_lblHasta.gridy = 1;
		add(lblHasta, gbc_lblHasta);

		patientBox = new JComboBox();
		GridBagConstraints gbc_patientBox = new GridBagConstraints();
		gbc_patientBox.insets = new Insets(0, 0, 5, 5);
		gbc_patientBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_patientBox.gridx = 3;
		gbc_patientBox.gridy = 1;
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
		gbc_lblDoktor.gridy = 2;
		add(lblDoktor, gbc_lblDoktor);

		doctorBox = new JComboBox();
		GridBagConstraints gbc_doctorBox = new GridBagConstraints();
		gbc_doctorBox.insets = new Insets(0, 0, 5, 5);
		gbc_doctorBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_doctorBox.gridx = 3;
		gbc_doctorBox.gridy = 2;
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
		gbc_lblNot.gridy = 3;
		add(lblNot, gbc_lblNot);

		notText = new JTextField();
		GridBagConstraints gbc_notText = new GridBagConstraints();
		gbc_notText.insets = new Insets(0, 0, 5, 5);
		gbc_notText.fill = GridBagConstraints.HORIZONTAL;
		gbc_notText.gridx = 3;
		gbc_notText.gridy = 3;
		add(notText, gbc_notText);
		notText.setColumns(10);

		EditorHandler editorHandler = new EditorHandler();
		
		JLabel lblNewLabel = new JLabel("Organizasyon:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtOrganization = new JTextField();
		txtOrganization.setEditable(false);
		GridBagConstraints gbc_txtOrganization = new GridBagConstraints();
		gbc_txtOrganization.insets = new Insets(0, 0, 5, 5);
		gbc_txtOrganization.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrganization.gridx = 3;
		gbc_txtOrganization.gridy = 4;
		add(txtOrganization, gbc_txtOrganization);
		txtOrganization.setColumns(10);

		JButton btnSave = new JButton("KAYDET");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 6;
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
//				AppointmentService appointmentService = new AppointmentService();
//				ArrayList<AppointmentDTO> appointmentList = appointmentService.getAllAppointmentList();
//				for(AppointmentDTO appointments : appointmentList) {
//					if(appointments.getAppointmentID() == panel.getName()) {
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
//				if (appointment == null) {
//					appointment = new AppointmentDTO();
//				}
				for(AppointmentDTO appointment : appointmentDTOList) {
					if(appointment.getStringSaat() == appointmentDTO.getStringSaat()) {
						appointment.setNote(not);
						if (appointment.getAppointmentCreate() == null) {
							appointment.setAppointmentCreate(createDate);
						} else {
							appointment.setAppointmentUpdate(updateDate);
						}
						appointment.setPatientName(patientBox.getSelectedItem().toString());
						appointment.setDoctorName(doctorBox.getSelectedItem().toString());
						appointment.setOrganizationName(organizationDTO.getoptionsName());
						AppointmentService appointmentService = new AppointmentService();
						appointment = appointmentService.saveAppointment(appointment);
						dialog.dispose();						
					}
		
				}
				
					
				
//				appointment.setNote(not);
//				if (appointment.getAppointmentCreate() == null) {
//					appointment.setAppointmentCreate(createDate);
//				} else {
//					appointment.setAppointmentUpdate(updateDate);
//				}
//				appointment.setPatientName(patientBox.getSelectedItem().toString());
//				appointment.setDoctorName(doctorBox.getSelectedItem().toString());
//				appointment.setOrganizationName(organizationDTO.getoptionsName());
//				AppointmentService appointmentService = new AppointmentService();
//				appointment = appointmentService.saveAppointment(appointment);
//				dialog.dispose();
			}
		}

	}

	public AppointmentDTO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentDTO appointment) {
		this.appointment = appointment;
	}

	public AppointmentDTO showDialog() {
		dialog.getContentPane().add(this);
		dialog.setModal(true);
		dialog.setSize(480, 230);
		dialog.setLocationRelativeTo(this);
		fillScreen();
		dialog.setVisible(true);
		return appointment;
	}

	private void fillScreen() {
		if (appointment != null) {
			txtOrganization.setText(organizationDTO.getoptionsName());
			notText.setText(appointment.getNote());
			patientBox.setSelectedItem(appointment.getPatientName());
			doctorBox.setSelectedItem(appointment.getDoctorName());
		}
	}

	public void setAppointmentOrganization(OptionsDTO organizationDTO) {
		this.organizationDTO = organizationDTO;
	}
	

}
