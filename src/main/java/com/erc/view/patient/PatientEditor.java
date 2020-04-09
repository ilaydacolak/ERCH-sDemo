package com.erc.view.patient;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

import com.erc.entities.PatientDTO;
import com.erc.user.service.PatientService;
import com.erc.user.service.StaffService;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

public class PatientEditor extends JPanel {
	private JTextField textTC;
	private JTextField textName;
	private JTextField textSurname;

	private PatientDTO patient;
	private JDialog dialog = new JDialog();
	private JTextField textUsername;
	private JTextField txtPatientNo;

	public PatientEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 575, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblTC = new JLabel("TC:");
		GridBagConstraints gbc_lblTC = new GridBagConstraints();
		gbc_lblTC.anchor = GridBagConstraints.WEST;
		gbc_lblTC.insets = new Insets(0, 0, 5, 5);
		gbc_lblTC.gridx = 1;
		gbc_lblTC.gridy = 2;
		add(lblTC, gbc_lblTC);

		textTC = new JTextField();
		GridBagConstraints gbc_textTC = new GridBagConstraints();
		gbc_textTC.insets = new Insets(0, 0, 5, 5);
		gbc_textTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTC.gridx = 3;
		gbc_textTC.gridy = 2;
		add(textTC, gbc_textTC);
		textTC.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 4;
		add(lblName, gbc_lblName);

		textName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 3;
		gbc_textName.gridy = 4;
		add(textName, gbc_textName);
		textName.setColumns(10);

		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.WEST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 1;
		gbc_lblSurname.gridy = 6;
		add(lblSurname, gbc_lblSurname);

		textSurname = new JTextField();
		GridBagConstraints gbc_textSurname = new GridBagConstraints();
		gbc_textSurname.insets = new Insets(0, 0, 5, 5);
		gbc_textSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSurname.gridx = 3;
		gbc_textSurname.gridy = 6;
		add(textSurname, gbc_textSurname);
		textSurname.setColumns(10);

		EditorHandler editorHandler = new EditorHandler();

		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 8;
		add(lblUsername, gbc_lblUsername);

		textUsername = new JTextField();
		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.gridx = 3;
		gbc_textUsername.gridy = 8;
		add(textUsername, gbc_textUsername);
		textUsername.setColumns(10);

		JLabel lblPatientNo = new JLabel("Patient No:");
		GridBagConstraints gbc_lblPatientNo = new GridBagConstraints();
		gbc_lblPatientNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientNo.gridx = 1;
		gbc_lblPatientNo.gridy = 10;
		add(lblPatientNo, gbc_lblPatientNo);

		txtPatientNo = new JTextField();
		GridBagConstraints gbc_txtPatientNo = new GridBagConstraints();
		gbc_txtPatientNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtPatientNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPatientNo.gridx = 3;
		gbc_txtPatientNo.gridy = 10;
		add(txtPatientNo, gbc_txtPatientNo);
		txtPatientNo.setColumns(10);

		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 12;
		add(btnSave, gbc_btnSave);

		btnSave.addActionListener(editorHandler);

		btnSave.setActionCommand("Save");
	}

	public class EditorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			String cmd = event.getActionCommand();

			if (cmd.equals("Save")) {
				System.out.println("Save is clicked");
				String tc = textTC.getText();
				String name = textName.getText();
				String surname = textSurname.getText();
				String username = textUsername.getText();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date createDate = new Date(System.currentTimeMillis());
				formatter.format(createDate);
				Date updateDate = new Date(System.currentTimeMillis());
				formatter.format(updateDate);
				String patientNo = txtPatientNo.getText();

				if (tc.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter TC", "Alert", JOptionPane.WARNING_MESSAGE);
					return;

				} else if (name.length() == 0) {

					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter name", "Alert", JOptionPane.WARNING_MESSAGE);
					return;

				} else if (surname.length() == 0) {

					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter Surname", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (username.length() == 0) {

					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter Username", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}else if(patientNo.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter patient number", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (patient == null) {
					patient = new PatientDTO();
				}

				patient.setTc(tc);
				patient.setName(name);
				patient.setSurname(surname);
				patient.setUsername(username);
				patient.setPatientNo(patientNo);
				if (patient.getCreatedDate() == null) {
					patient.setCreatedDate(createDate);
				} else {
					patient.setUpdatedDate(updateDate);
				}
				PatientService service = new PatientService();
//				if (patient.getPatientId() == null) {
//					if (service.isTCExist(patient)) {
//						return;
//					}
//
//				}

				patient = service.savePatient(patient);
				dialog.dispose();

			}
		}
	}

	public PatientDTO getPersonel() {
		return patient;
	}

	public void setPersonel(PatientDTO patient) {
		this.patient = patient;
	}

	public PatientDTO showDialog() {
		dialog.getContentPane().add(this);
		dialog.setModal(true);
		dialog.setSize(690, 200);
		dialog.setLocationRelativeTo(this);
		fillScreen();
		dialog.setVisible(true);

		return patient;
	}

	private void fillScreen() {
		if (patient != null) {
			textTC.setText(patient.getTc());
			textName.setText(patient.getName());
			textSurname.setText(patient.getSurname());
			textUsername.setText(patient.getUsername());
			txtPatientNo.setText(patient.getPatientNo());

		}

	}

}
