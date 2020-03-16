package com.erc.view.personel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;
import com.erc.user.service.PersonelService;
import com.erc.view.patient.PatientEditor.EditorHandler;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class PersonelEditor extends JPanel{
	private JTextField textTC;
	private JTextField textName;
	private JTextField textSurname;
	
	private PersonnelDTO personel;
	private JDialog dialog = new JDialog();
	private JTextField textUsername;
	
	public PersonelEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTC = new JLabel("TC:");
		GridBagConstraints gbc_lblTC = new GridBagConstraints();
		gbc_lblTC.insets = new Insets(0, 0, 5, 5);
		gbc_lblTC.gridx = 2;
		gbc_lblTC.gridy = 2;
		add(lblTC, gbc_lblTC);
		
		textTC = new JTextField();
		GridBagConstraints gbc_textTC = new GridBagConstraints();
		gbc_textTC.insets = new Insets(0, 0, 5, 0);
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
		gbc_textName.insets = new Insets(0, 0, 5, 0);
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
		gbc_textSurname.insets = new Insets(0, 0, 5, 0);
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
		gbc_textUsername.insets = new Insets(0, 0, 5, 0);
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.gridx = 5;
		gbc_textUsername.gridy = 8;
		add(textUsername, gbc_textUsername);
		textUsername.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnSave.gridx = 5;
		gbc_btnSave.gridy = 10;
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
				String username = textUsername.getText();
				
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
				}
				else if (username.length() == 0) {
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Please,enter Username","Alert",JOptionPane.WARNING_MESSAGE); 
					return;
				}
				
				
				if(personel == null) {			
					personel = new PersonnelDTO();
				}
				
				personel.setIdentificationno(tc);
				personel.setName(name);
				personel.setLastname(surname);
				personel.setUsername(username);
			
				
				PersonelService service = new PersonelService();
				personel= service.savePesonel(personel);
				dialog.dispose();			

			}
			
	
		}
}
			public PersonnelDTO getPersonel() {
				return personel;
			}

			public void setPersonel(PersonnelDTO personel) {
					this.personel = personel;
			}

			public PersonnelDTO showDialog() {
				dialog.getContentPane().add(this);
				dialog.setModal(true);
				dialog.setSize(500, 200);
				dialog.setLocationRelativeTo(this);	
				fillScreen();
				dialog.setVisible(true);
			
				return personel;
			}

			private void fillScreen() {
				if(personel!=null) {
					textTC.setText(personel.getIdentificationno());
					textName.setText(personel.getName());
					textSurname.setText(personel.getLastname());
					textUsername.setText(personel.getUsername());
				}
	

	

			}
}
