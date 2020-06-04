package com.erc.view.doctor;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;

public class PolyclinicPanel extends JPanel{
	private JTextField txtProtocolNo;
	private JTextField txtStatus;
	private PriorityComboboxModel priorityComboboxModel = new PriorityComboboxModel();
	private AdmissionTypeComboboxModel admissionTypeComboboxModel = new AdmissionTypeComboboxModel();
	public PolyclinicPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblProtocolNo = new JLabel("Protocol No");
		GridBagConstraints gbc_lblProtocolNo = new GridBagConstraints();
		gbc_lblProtocolNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblProtocolNo.gridx = 1;
		gbc_lblProtocolNo.gridy = 2;
		add(lblProtocolNo, gbc_lblProtocolNo);
		
		txtProtocolNo = new JTextField();
		GridBagConstraints gbc_txtProtocolNo = new GridBagConstraints();
		gbc_txtProtocolNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtProtocolNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProtocolNo.gridx = 3;
		gbc_txtProtocolNo.gridy = 2;
		add(txtProtocolNo, gbc_txtProtocolNo);
		txtProtocolNo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Aciliyet");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox priorityCmbx = new JComboBox();
		GridBagConstraints gbc_priorityCmbx = new GridBagConstraints();
		gbc_priorityCmbx.fill = GridBagConstraints.HORIZONTAL;
		gbc_priorityCmbx.insets = new Insets(0, 0, 5, 0);
		gbc_priorityCmbx.gridx = 7;
		gbc_priorityCmbx.gridy = 2;
		add(priorityCmbx, gbc_priorityCmbx);
		
		priorityCmbx.setModel(priorityComboboxModel);
		
		
		JLabel lblDurum = new JLabel("Durum");
		GridBagConstraints gbc_lblDurum = new GridBagConstraints();
		gbc_lblDurum.insets = new Insets(0, 0, 0, 5);
		gbc_lblDurum.gridx = 1;
		gbc_lblDurum.gridy = 4;
		add(lblDurum, gbc_lblDurum);
		
		txtStatus = new JTextField();
		GridBagConstraints gbc_txtStatus = new GridBagConstraints();
		gbc_txtStatus.insets = new Insets(0, 0, 0, 5);
		gbc_txtStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStatus.gridx = 3;
		gbc_txtStatus.gridy = 4;
		add(txtStatus, gbc_txtStatus);
		txtStatus.setColumns(10);
		
		JLabel lblAdmissionType = new JLabel("Kabul Tipi");
		GridBagConstraints gbc_lblAdmissionType = new GridBagConstraints();
		gbc_lblAdmissionType.insets = new Insets(0, 0, 0, 5);
		gbc_lblAdmissionType.gridx = 5;
		gbc_lblAdmissionType.gridy = 4;
		add(lblAdmissionType, gbc_lblAdmissionType);
		
		JComboBox admissionTypeCmbx = new JComboBox();
		GridBagConstraints gbc_admissionTypeCmbx = new GridBagConstraints();
		gbc_admissionTypeCmbx.fill = GridBagConstraints.HORIZONTAL;
		gbc_admissionTypeCmbx.gridx = 7;
		gbc_admissionTypeCmbx.gridy = 4;
		add(admissionTypeCmbx, gbc_admissionTypeCmbx);
		admissionTypeCmbx.setModel(admissionTypeComboboxModel);
	}

}
