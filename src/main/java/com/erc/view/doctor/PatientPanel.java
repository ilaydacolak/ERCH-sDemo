package com.erc.view.doctor;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import com.erc.entities.AppointmentDTO;
import com.erc.entities.PatientDTO;

import java.awt.Insets;

public class PatientPanel extends JPanel{
	private JTextField txtPatientNo;
	private JTextField txtPatientName;
	private JTextField txtTc;
	private JTextField txtAge;
	private JTextField txtPhone;
	private JTextField txtPriority;
	private JTextField txtBlood;
	private JTextField txtGender;

	public PatientPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("HASTA B\u0130LG\u0130LER\u0130");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 15;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblPatientNo = new JLabel("Hasta No");
		GridBagConstraints gbc_lblPatientNo = new GridBagConstraints();
		gbc_lblPatientNo.anchor = GridBagConstraints.WEST;
		gbc_lblPatientNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientNo.gridx = 1;
		gbc_lblPatientNo.gridy = 2;
		add(lblPatientNo, gbc_lblPatientNo);
		
		txtPatientNo = new JTextField();
		GridBagConstraints gbc_txtPatientNo = new GridBagConstraints();
		gbc_txtPatientNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtPatientNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPatientNo.gridx = 3;
		gbc_txtPatientNo.gridy = 2;
		add(txtPatientNo, gbc_txtPatientNo);
		txtPatientNo.setColumns(10);
		
		JLabel lblName = new JLabel("Ad Soyad");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 4;
		add(lblName, gbc_lblName);
		
		txtPatientName = new JTextField();
		GridBagConstraints gbc_txtPatientName = new GridBagConstraints();
		gbc_txtPatientName.gridwidth = 12;
		gbc_txtPatientName.insets = new Insets(0, 0, 5, 0);
		gbc_txtPatientName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPatientName.gridx = 3;
		gbc_txtPatientName.gridy = 4;
		add(txtPatientName, gbc_txtPatientName);
		txtPatientName.setColumns(10);
		
		JLabel lblTC = new JLabel("TC Kimlik No");
		GridBagConstraints gbc_lblTC = new GridBagConstraints();
		gbc_lblTC.anchor = GridBagConstraints.WEST;
		gbc_lblTC.insets = new Insets(0, 0, 5, 5);
		gbc_lblTC.gridx = 1;
		gbc_lblTC.gridy = 6;
		add(lblTC, gbc_lblTC);
		
		txtTc = new JTextField();
		GridBagConstraints gbc_txtTc = new GridBagConstraints();
		gbc_txtTc.insets = new Insets(0, 0, 5, 5);
		gbc_txtTc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTc.gridx = 3;
		gbc_txtTc.gridy = 6;
		add(txtTc, gbc_txtTc);
		txtTc.setColumns(10);
		
		JLabel lblPatientAge = new JLabel("Ya\u015F");
		GridBagConstraints gbc_lblPatientAge = new GridBagConstraints();
		gbc_lblPatientAge.anchor = GridBagConstraints.WEST;
		gbc_lblPatientAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientAge.gridx = 6;
		gbc_lblPatientAge.gridy = 6;
		add(lblPatientAge, gbc_lblPatientAge);
		
		txtAge = new JTextField();
		GridBagConstraints gbc_txtAge = new GridBagConstraints();
		gbc_txtAge.insets = new Insets(0, 0, 5, 5);
		gbc_txtAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAge.gridx = 8;
		gbc_txtAge.gridy = 6;
		add(txtAge, gbc_txtAge);
		txtAge.setColumns(10);
		
		JLabel lblGender = new JLabel("Cinsiyet");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 11;
		gbc_lblGender.gridy = 6;
		add(lblGender, gbc_lblGender);
		
		txtGender = new JTextField();
		GridBagConstraints gbc_txtGender = new GridBagConstraints();
		gbc_txtGender.insets = new Insets(0, 0, 5, 5);
		gbc_txtGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGender.gridx = 13;
		gbc_txtGender.gridy = 6;
		add(txtGender, gbc_txtGender);
		txtGender.setColumns(10);
		
		JLabel lblPhone = new JLabel("Telefon");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 8;
		add(lblPhone, gbc_lblPhone);
		
		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.insets = new Insets(0, 0, 0, 5);
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.gridx = 3;
		gbc_txtPhone.gridy = 8;
		add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblPriority = new JLabel("\u00D6ncelik");
		GridBagConstraints gbc_lblPriority = new GridBagConstraints();
		gbc_lblPriority.anchor = GridBagConstraints.WEST;
		gbc_lblPriority.insets = new Insets(0, 0, 0, 5);
		gbc_lblPriority.gridx = 6;
		gbc_lblPriority.gridy = 8;
		add(lblPriority, gbc_lblPriority);
		
		txtPriority = new JTextField();
		GridBagConstraints gbc_txtPriority = new GridBagConstraints();
		gbc_txtPriority.insets = new Insets(0, 0, 0, 5);
		gbc_txtPriority.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPriority.gridx = 8;
		gbc_txtPriority.gridy = 8;
		add(txtPriority, gbc_txtPriority);
		txtPriority.setColumns(10);
		
		JLabel lblBlood = new JLabel("Kan Grubu");
		GridBagConstraints gbc_lblBlood = new GridBagConstraints();
		gbc_lblBlood.anchor = GridBagConstraints.WEST;
		gbc_lblBlood.insets = new Insets(0, 0, 0, 5);
		gbc_lblBlood.gridx = 11;
		gbc_lblBlood.gridy = 8;
		add(lblBlood, gbc_lblBlood);
		
		txtBlood = new JTextField();
		GridBagConstraints gbc_txtBlood = new GridBagConstraints();
		gbc_txtBlood.insets = new Insets(0, 0, 0, 5);
		gbc_txtBlood.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBlood.gridx = 13;
		gbc_txtBlood.gridy = 8;
		add(txtBlood, gbc_txtBlood);
		txtBlood.setColumns(10);
	}
	public void fillScreen (PatientDTO patient) {
	if(patient != null) {
		txtBlood.setText(patient.getBloodGroup());
		txtPriority.setText(patient.getPriority());
		txtPhone.setText(patient.getPhone());
		txtGender.setText(patient.getGender());
		txtAge.setText(patient.getAge());
		txtTc.setText(patient.getTc());
		txtPatientName.setText(patient.getName() + " " + patient.getSurname());
		txtPatientNo.setText(patient.getPatientNo());
	}
	}
	

}
