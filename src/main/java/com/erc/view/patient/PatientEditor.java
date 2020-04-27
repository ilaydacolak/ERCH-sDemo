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
import javax.swing.JComboBox;

public class PatientEditor extends JPanel {
	private JTextField textTC;
	private JTextField textName;
	private JTextField textSurname;

	private PatientDTO patient;
	private JDialog dialog = new JDialog();
	private JTextField txtPatientNo;
	private JTextField txtPhone;
	private JTextField txtAge;
	private JComboBox genderCMBX = new JComboBox();
	private JComboBox bloodCMBX = new JComboBox();
	private JComboBox priorityCMBX = new JComboBox();
	public PatientEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 575, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		JLabel lblPatientNo = new JLabel("Patient No:");
		GridBagConstraints gbc_lblPatientNo = new GridBagConstraints();
		gbc_lblPatientNo.anchor = GridBagConstraints.WEST;
		gbc_lblPatientNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientNo.gridx = 1;
		gbc_lblPatientNo.gridy = 8;
		add(lblPatientNo, gbc_lblPatientNo);

		txtPatientNo = new JTextField();
		GridBagConstraints gbc_txtPatientNo = new GridBagConstraints();
		gbc_txtPatientNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtPatientNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPatientNo.gridx = 3;
		gbc_txtPatientNo.gridy = 8;
		add(txtPatientNo, gbc_txtPatientNo);
		txtPatientNo.setColumns(10);

		JLabel lblPhone = new JLabel("Phone:");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 10;
		add(lblPhone, gbc_lblPhone);

		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.gridx = 3;
		gbc_txtPhone.gridy = 10;
		add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);

		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.WEST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 1;
		gbc_lblAge.gridy = 12;
		add(lblAge, gbc_lblAge);

		txtAge = new JTextField();
		GridBagConstraints gbc_txtAge = new GridBagConstraints();
		gbc_txtAge.insets = new Insets(0, 0, 5, 5);
		gbc_txtAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAge.gridx = 3;
		gbc_txtAge.gridy = 12;
		add(txtAge, gbc_txtAge);
		txtAge.setColumns(10);

		JLabel lblPriority = new JLabel("Priority:");
		GridBagConstraints gbc_lblPriority = new GridBagConstraints();
		gbc_lblPriority.anchor = GridBagConstraints.WEST;
		gbc_lblPriority.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriority.gridx = 1;
		gbc_lblPriority.gridy = 14;
		add(lblPriority, gbc_lblPriority);

		priorityCMBX = new JComboBox();
		GridBagConstraints gbc_priorityCMBX = new GridBagConstraints();
		gbc_priorityCMBX.insets = new Insets(0, 0, 5, 5);
		gbc_priorityCMBX.fill = GridBagConstraints.HORIZONTAL;
		gbc_priorityCMBX.gridx = 3;
		gbc_priorityCMBX.gridy = 14;
		add(priorityCMBX, gbc_priorityCMBX);
		
		PriorityComboboxModel priorityCmbModel = new PriorityComboboxModel ();
		priorityCMBX.setModel(priorityCmbModel);

		JLabel lblBlood = new JLabel("Blood Group:");
		GridBagConstraints gbc_lblBlood = new GridBagConstraints();
		gbc_lblBlood.anchor = GridBagConstraints.WEST;
		gbc_lblBlood.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlood.gridx = 1;
		gbc_lblBlood.gridy = 16;
		add(lblBlood, gbc_lblBlood);

		bloodCMBX = new JComboBox();
		GridBagConstraints gbc_bloodCMBX = new GridBagConstraints();
		gbc_bloodCMBX.insets = new Insets(0, 0, 5, 5);
		gbc_bloodCMBX.fill = GridBagConstraints.HORIZONTAL;
		gbc_bloodCMBX.gridx = 3;
		gbc_bloodCMBX.gridy = 16;
		add(bloodCMBX, gbc_bloodCMBX);
		
		BloodComboboxModel bloodcmbModel = new BloodComboboxModel();
		bloodCMBX.setModel(bloodcmbModel);

		JLabel lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 1;
		gbc_lblGender.gridy = 18;
		add(lblGender, gbc_lblGender);

		genderCMBX = new JComboBox();
		GridBagConstraints gbc_genderCMBX = new GridBagConstraints();
		gbc_genderCMBX.insets = new Insets(0, 0, 5, 5);
		gbc_genderCMBX.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderCMBX.gridx = 3;
		gbc_genderCMBX.gridy = 18;
		add(genderCMBX, gbc_genderCMBX);
		
		GenderComboboxModel genderComboboxModel = new GenderComboboxModel();
		genderCMBX.setModel(genderComboboxModel);

		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 20;
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
				String age = txtAge.getText();
				String phone = txtPhone.getText();

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
				} else if (patientNo.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter patient number", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (patient == null) {
					patient = new PatientDTO();
				}

				patient.setTc(tc);
				patient.setName(name);
				patient.setSurname(surname);
				patient.setPatientNo(patientNo);
				patient.setAge(age);
				patient.setPhone(phone);
				if(genderCMBX.getSelectedItem() != null) {
					patient.setGender(genderCMBX.getSelectedItem().toString());
				}if(bloodCMBX.getSelectedItem() != null) {
					patient.setBloodGroup(bloodCMBX.getSelectedItem().toString());
				}if(priorityCMBX.getSelectedItem() != null) {
					patient.setPriority(priorityCMBX.getSelectedItem().toString());			
				}
				
				if (patient.getCreatedDate() == null) {
					patient.setCreatedDate(createDate);
				} else {
					patient.setUpdatedDate(updateDate);
				}
				PatientService service = new PatientService();

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
			txtPatientNo.setText(patient.getPatientNo());

		}

	}

}
