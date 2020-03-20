package com.erc.view.patient;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTextField;

import com.erc.entities.PatientDTO;
import com.erc.user.service.PatientService;
import com.erc.user.service.PersonelService;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

public class PatientEditor extends JPanel{
	private JTextField textTC;
	private JTextField textName;
	private JTextField textSurname;
	private JDateChooser CreatedateChooser;
	private JDateChooser UpdateDateChooser;
	
	
	
	private PatientDTO patient;
	private JDialog dialog = new JDialog();
	private JTextField textUsername;
	
	public PatientEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTC = new JLabel("TC:");
		GridBagConstraints gbc_lblTC = new GridBagConstraints();
		gbc_lblTC.insets = new Insets(0, 0, 5, 5);
		gbc_lblTC.gridx = 2;
		gbc_lblTC.gridy = 2;
		add(lblTC, gbc_lblTC);
		
		textTC = new JTextField();
		GridBagConstraints gbc_textTC = new GridBagConstraints();
		gbc_textTC.insets = new Insets(0, 0, 5, 5);
		gbc_textTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTC.gridx = 5;
		gbc_textTC.gridy = 2;
		add(textTC, gbc_textTC);
		textTC.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 4;
		add(lblName, gbc_lblName);
		
		textName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 5;
		gbc_textName.gridy = 4;
		add(textName, gbc_textName);
		textName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 2;
		gbc_lblSurname.gridy = 6;
		add(lblSurname, gbc_lblSurname);
		
		textSurname = new JTextField();
		GridBagConstraints gbc_textSurname = new GridBagConstraints();
		gbc_textSurname.insets = new Insets(0, 0, 5, 5);
		gbc_textSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSurname.gridx = 5;
		gbc_textSurname.gridy = 6;
		add(textSurname, gbc_textSurname);
		textSurname.setColumns(10);
		
		EditorHandler editorHandler = new EditorHandler();
		
		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 8;
		add(lblUsername, gbc_lblUsername);
		
		textUsername = new JTextField();
		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.gridx = 5;
		gbc_textUsername.gridy = 8;
		add(textUsername, gbc_textUsername);
		textUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Created Date:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 10;
		add(lblNewLabel, gbc_lblNewLabel);
		
		CreatedateChooser = new JDateChooser();
		GridBagConstraints gbc_CreatedateChooser = new GridBagConstraints();
		gbc_CreatedateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_CreatedateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_CreatedateChooser.gridx = 5;
		gbc_CreatedateChooser.gridy = 10;
		add(CreatedateChooser, gbc_CreatedateChooser);
		
		JLabel lblNewLabel_1 = new JLabel("Updated Date:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 12;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		UpdateDateChooser = new JDateChooser();
		GridBagConstraints gbc_UpdateDateChooser = new GridBagConstraints();
		gbc_UpdateDateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_UpdateDateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_UpdateDateChooser.gridx = 5;
		gbc_UpdateDateChooser.gridy = 12;
		add(UpdateDateChooser, gbc_UpdateDateChooser);
		
		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 5;
		gbc_btnSave.gridy = 14;
		add(btnSave, gbc_btnSave);
		

		btnSave.addActionListener(editorHandler);
		
		btnSave.setActionCommand("Save");	
	}
	
public class EditorHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			String cmd = event.getActionCommand();
			
			if(cmd.equals ("Save")) {
				System.out.println("Save is clicked");
				String tc = textTC.getText();
				String name = textName.getText();
				String surname = textSurname.getText();
				String username =textUsername.getText();
				Date createDate = CreatedateChooser.getDate();
				Date updateDate = UpdateDateChooser.getDate();
				
				if (tc.length()== 0) {
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Please,enter TC","Alert",JOptionPane.WARNING_MESSAGE); 
					return;
							
				}
				else if(name.length() == 0) {
					
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Please,enter name","Alert",JOptionPane.WARNING_MESSAGE); 
					return;
					
				}
				else if(surname.length() == 0) {
					
				
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Please,enter Surname","Alert",JOptionPane.WARNING_MESSAGE); 
					return;
				}else if (username.length()==0) {

					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Please,enter Username","Alert",JOptionPane.WARNING_MESSAGE); 
					return;
				}
	
				if(patient == null) {			
					patient = new PatientDTO();
				}
				
				patient.setTc(tc);
				patient.setName(name);
				patient.setSurname(surname);
				patient.setUsername(username);
				patient.setCreatedDate(createDate);
				patient.setUpdatedDate(updateDate);

				PatientService service = new PatientService();
//				if (patient.getPatientId() == null) {
//					if (service.isTCExist(patient)) {
//						return;
//					}
//
//				}
				
				patient= service.savePatient(patient);
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
				dialog.setSize(500, 200);
				dialog.setLocationRelativeTo(this);	
				fillScreen();
				dialog.setVisible(true);
			
				return patient;
			}

			private void fillScreen() {
				if(patient!=null) {
					textTC.setText(patient.getTc());
					textName.setText(patient.getName());
					textSurname.setText(patient.getSurname());
					textUsername.setText(patient.getUsername());
					
				}
	
}


	

}
