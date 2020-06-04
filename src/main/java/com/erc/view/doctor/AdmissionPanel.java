package com.erc.view.doctor;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import com.erc.entities.AdmissionDTO;

import java.awt.Insets;

public class AdmissionPanel extends JPanel{
	private JTextField txtAdmissionNo;
	private JTextField txtProvizyonNo;
	private JTextField txtAdmissionStatus;
	private JTextField txtAdmissionType;
	private JTextField txtAdmissionDate;
	private JTextField txtDischarged;
	private JTextField txtProtocolType;
	private JTextField txtAdmissionDoctor;
	private JTextField txtAdmissionPlace;
	private JTextField txtEndAdmissionDate;
	private JTextField txtKurum;
	private JLabel lblNewLabel;
	public AdmissionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("KABUL B\u0130LG\u0130LER\u0130");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 16;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblAdmissionNo = new JLabel("Kabul No");
		GridBagConstraints gbc_lblAdmissionNo = new GridBagConstraints();
		gbc_lblAdmissionNo.anchor = GridBagConstraints.WEST;
		gbc_lblAdmissionNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmissionNo.gridx = 1;
		gbc_lblAdmissionNo.gridy = 2;
		add(lblAdmissionNo, gbc_lblAdmissionNo);
		
		txtAdmissionNo = new JTextField();
		GridBagConstraints gbc_txtAdmissionNo = new GridBagConstraints();
		gbc_txtAdmissionNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmissionNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmissionNo.gridx = 3;
		gbc_txtAdmissionNo.gridy = 2;
		add(txtAdmissionNo, gbc_txtAdmissionNo);
		txtAdmissionNo.setColumns(10);
		
		JLabel lblProvizyonNo = new JLabel("Provizyon No");
		GridBagConstraints gbc_lblProvizyonNo = new GridBagConstraints();
		gbc_lblProvizyonNo.anchor = GridBagConstraints.WEST;
		gbc_lblProvizyonNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvizyonNo.gridx = 5;
		gbc_lblProvizyonNo.gridy = 2;
		add(lblProvizyonNo, gbc_lblProvizyonNo);
		
		txtProvizyonNo = new JTextField();
		GridBagConstraints gbc_txtProvizyonNo = new GridBagConstraints();
		gbc_txtProvizyonNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtProvizyonNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProvizyonNo.gridx = 7;
		gbc_txtProvizyonNo.gridy = 2;
		add(txtProvizyonNo, gbc_txtProvizyonNo);
		txtProvizyonNo.setColumns(10);
		
		JLabel lblAdmissionStatus = new JLabel("Kabul Durumu");
		GridBagConstraints gbc_lblAdmissionStatus = new GridBagConstraints();
		gbc_lblAdmissionStatus.anchor = GridBagConstraints.WEST;
		gbc_lblAdmissionStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmissionStatus.gridx = 9;
		gbc_lblAdmissionStatus.gridy = 2;
		add(lblAdmissionStatus, gbc_lblAdmissionStatus);
		
		txtAdmissionStatus = new JTextField();
		GridBagConstraints gbc_txtAdmissionStatus = new GridBagConstraints();
		gbc_txtAdmissionStatus.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmissionStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmissionStatus.gridx = 11;
		gbc_txtAdmissionStatus.gridy = 2;
		add(txtAdmissionStatus, gbc_txtAdmissionStatus);
		txtAdmissionStatus.setColumns(10);
		
		JLabel lblAdmissionType = new JLabel("Kabul Tipi");
		GridBagConstraints gbc_lblAdmissionType = new GridBagConstraints();
		gbc_lblAdmissionType.anchor = GridBagConstraints.WEST;
		gbc_lblAdmissionType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmissionType.gridx = 1;
		gbc_lblAdmissionType.gridy = 4;
		add(lblAdmissionType, gbc_lblAdmissionType);
		
		txtAdmissionType = new JTextField();
		GridBagConstraints gbc_txtAdmissionType = new GridBagConstraints();
		gbc_txtAdmissionType.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmissionType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmissionType.gridx = 3;
		gbc_txtAdmissionType.gridy = 4;
		add(txtAdmissionType, gbc_txtAdmissionType);
		txtAdmissionType.setColumns(10);
		
		JLabel lblAdmissionDate = new JLabel("Kabul Tarihi");
		GridBagConstraints gbc_lblAdmissionDate = new GridBagConstraints();
		gbc_lblAdmissionDate.anchor = GridBagConstraints.WEST;
		gbc_lblAdmissionDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmissionDate.gridx = 5;
		gbc_lblAdmissionDate.gridy = 4;
		add(lblAdmissionDate, gbc_lblAdmissionDate);
		
		txtAdmissionDate = new JTextField();
		GridBagConstraints gbc_txtAdmissionDate = new GridBagConstraints();
		gbc_txtAdmissionDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmissionDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmissionDate.gridx = 7;
		gbc_txtAdmissionDate.gridy = 4;
		add(txtAdmissionDate, gbc_txtAdmissionDate);
		txtAdmissionDate.setColumns(10);
		
		JLabel lblDischarged = new JLabel("Taburcu Tarihi");
		GridBagConstraints gbc_lblDischarged = new GridBagConstraints();
		gbc_lblDischarged.anchor = GridBagConstraints.WEST;
		gbc_lblDischarged.insets = new Insets(0, 0, 5, 5);
		gbc_lblDischarged.gridx = 9;
		gbc_lblDischarged.gridy = 4;
		add(lblDischarged, gbc_lblDischarged);
		
		txtDischarged = new JTextField();
		GridBagConstraints gbc_txtDischarged = new GridBagConstraints();
		gbc_txtDischarged.insets = new Insets(0, 0, 5, 5);
		gbc_txtDischarged.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDischarged.gridx = 11;
		gbc_txtDischarged.gridy = 4;
		add(txtDischarged, gbc_txtDischarged);
		txtDischarged.setColumns(10);
		
		JLabel lblProtokolType = new JLabel("Protokol Tipi");
		GridBagConstraints gbc_lblProtokolType = new GridBagConstraints();
		gbc_lblProtokolType.anchor = GridBagConstraints.WEST;
		gbc_lblProtokolType.insets = new Insets(0, 0, 5, 5);
		gbc_lblProtokolType.gridx = 13;
		gbc_lblProtokolType.gridy = 4;
		add(lblProtokolType, gbc_lblProtokolType);
		
		txtProtocolType = new JTextField();
		GridBagConstraints gbc_txtProtocolType = new GridBagConstraints();
		gbc_txtProtocolType.insets = new Insets(0, 0, 5, 0);
		gbc_txtProtocolType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProtocolType.gridx = 15;
		gbc_txtProtocolType.gridy = 4;
		add(txtProtocolType, gbc_txtProtocolType);
		txtProtocolType.setColumns(10);
		
		JLabel lblAdmissionDoctor = new JLabel("Kabul Doktoru");
		GridBagConstraints gbc_lblAdmissionDoctor = new GridBagConstraints();
		gbc_lblAdmissionDoctor.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblAdmissionDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmissionDoctor.gridx = 1;
		gbc_lblAdmissionDoctor.gridy = 6;
		add(lblAdmissionDoctor, gbc_lblAdmissionDoctor);
		
		txtAdmissionDoctor = new JTextField();
		GridBagConstraints gbc_txtAdmissionDoctor = new GridBagConstraints();
		gbc_txtAdmissionDoctor.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmissionDoctor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmissionDoctor.gridx = 3;
		gbc_txtAdmissionDoctor.gridy = 6;
		add(txtAdmissionDoctor, gbc_txtAdmissionDoctor);
		txtAdmissionDoctor.setColumns(10);
		
		JLabel lblAdmissionPlace = new JLabel("Kabul Yeri");
		GridBagConstraints gbc_lblAdmissionPlace = new GridBagConstraints();
		gbc_lblAdmissionPlace.anchor = GridBagConstraints.WEST;
		gbc_lblAdmissionPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmissionPlace.gridx = 5;
		gbc_lblAdmissionPlace.gridy = 6;
		add(lblAdmissionPlace, gbc_lblAdmissionPlace);
		
		txtAdmissionPlace = new JTextField();
		GridBagConstraints gbc_txtAdmissionPlace = new GridBagConstraints();
		gbc_txtAdmissionPlace.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmissionPlace.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmissionPlace.gridx = 7;
		gbc_txtAdmissionPlace.gridy = 6;
		add(txtAdmissionPlace, gbc_txtAdmissionPlace);
		txtAdmissionPlace.setColumns(10);
		
		JLabel lblEndAdmissionDate = new JLabel("Kabul Kapatma Tarihi");
		GridBagConstraints gbc_lblEndAdmissionDate = new GridBagConstraints();
		gbc_lblEndAdmissionDate.anchor = GridBagConstraints.WEST;
		gbc_lblEndAdmissionDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndAdmissionDate.gridx = 9;
		gbc_lblEndAdmissionDate.gridy = 6;
		add(lblEndAdmissionDate, gbc_lblEndAdmissionDate);
		
		txtEndAdmissionDate = new JTextField();
		GridBagConstraints gbc_txtEndAdmissionDate = new GridBagConstraints();
		gbc_txtEndAdmissionDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndAdmissionDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndAdmissionDate.gridx = 11;
		gbc_txtEndAdmissionDate.gridy = 6;
		add(txtEndAdmissionDate, gbc_txtEndAdmissionDate);
		txtEndAdmissionDate.setColumns(10);
		
		JLabel lblKurum = new JLabel("Kurum");
		GridBagConstraints gbc_lblKurum = new GridBagConstraints();
		gbc_lblKurum.anchor = GridBagConstraints.WEST;
		gbc_lblKurum.insets = new Insets(0, 0, 0, 5);
		gbc_lblKurum.gridx = 1;
		gbc_lblKurum.gridy = 8;
		add(lblKurum, gbc_lblKurum);
		
		txtKurum = new JTextField();
		GridBagConstraints gbc_txtKurum = new GridBagConstraints();
		gbc_txtKurum.gridwidth = 4;
		gbc_txtKurum.insets = new Insets(0, 0, 0, 5);
		gbc_txtKurum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKurum.gridx = 3;
		gbc_txtKurum.gridy = 8;
		add(txtKurum, gbc_txtKurum);
		txtKurum.setColumns(10);
	}
	
	public void fillAdmissionPatient (AdmissionDTO admissionDTO) {
		txtAdmissionNo.setText(admissionDTO.getAdmissionNo());
		if(admissionDTO.getAdmissionType().toString() == "O" ) {
			txtAdmissionType.setText("Yatan");
		}else {
			txtAdmissionType.setText("Ayakta");
		}
		txtAdmissionStatus.setText(admissionDTO.getStatus());
		txtAdmissionDate.setText(admissionDTO.getAdmissionCreate().toString());
		txtAdmissionDoctor.setText(admissionDTO.getDoctorID());	
	}

}
