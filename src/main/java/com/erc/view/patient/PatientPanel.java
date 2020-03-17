package com.erc.view.patient;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;
import com.erc.user.service.PatientService;
import com.erc.user.service.PersonelService;
import com.erc.view.personel.PersonelEditor;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PatientPanel extends JPanel{
	

	private JButton btnAdd = new JButton("ADD");
	private JButton btnUpdate = new JButton("UPDATE");
	private JButton btnDelete = new JButton("DELETE");
	
	
	private PatientTableModel tableModel = new PatientTableModel();
	private JTable table = new JTable();
	
	public PatientPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 0, 0, 0, 0, 5, 0};
		gridBagLayout.rowHeights = new int[]{5, 0, 0, 5, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 1;
		add(btnAdd, gbc_btnAdd);
		
		
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 3;
		gbc_btnUpdate.gridy = 1;
		add(btnUpdate, gbc_btnUpdate);
		
		
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 1;
		add(btnDelete, gbc_btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		 
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		Handler handler = new Handler();
		
		btnAdd.addActionListener(handler);
		btnDelete.addActionListener(handler);
		btnUpdate.addActionListener(handler);
		
		
		btnAdd.setActionCommand("add");
		btnDelete.setActionCommand("delete");
		btnUpdate.setActionCommand("update");
		
		getPatientListFromDB();
	
	}
	
	
	private void getPatientListFromDB() {
		// TODO Auto-generated method stub
		 PatientService service = new PatientService();
		 ArrayList<PatientDTO> patientList = service.getAllPatients();
		 tableModel.setDataList(patientList);
		 table.setModel(tableModel);
		 tableModel.fireTableDataChanged();	
	}


	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			String cmd = event.getActionCommand();
			
			if(cmd.equals("add")) {
				PatientDTO patient = new PatientDTO();
				System.out.println("add is clicked");
				
				PatientEditor patientEditor = new PatientEditor();
				patient = patientEditor.showDialog();
				
				if (patient != null) {
					
					tableModel.getDataList().add(patient);
					tableModel.fireTableDataChanged();		
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Kullanýcý eklendi","Mesaj",JOptionPane.PLAIN_MESSAGE); 
				}else {
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Kullanýcý eklenemedi","Mesaj",JOptionPane.PLAIN_MESSAGE); 
				
				}
							
			}
			
			
			if (cmd.equals("delete")) {
							
				System.out.println("delete is clicked");
				int selectedRow = table.getSelectedRow();
				if(selectedRow == -1) {
					JFrame f;
					f=new JFrame();
					JOptionPane.showMessageDialog(f,"Kullanýcý seçin","Uyarý",JOptionPane.WARNING_MESSAGE); 					
					return;
					
				}else {
					//PatientDTO patient = tableModel.getDataList().remove(selectedRow);
					int input = JOptionPane.showConfirmDialog(null, 
			                "Silmek istediðinize emin misiniz?", "UYARI",JOptionPane.YES_NO_CANCEL_OPTION);

				// 0=yes, 1=no, 2=cancel
				System.out.println(input);
				if (input == 0) {
				PatientDTO patient = tableModel.getDataList().get(selectedRow);
				PatientService service = new PatientService();
				boolean isDeleted = service.deletePatient(patient);		
				if(isDeleted) {
					tableModel.getDataList().remove(selectedRow);	
					tableModel.fireTableDataChanged();
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Kullanýcý silindi","Mesaj",JOptionPane.PLAIN_MESSAGE); 
				}
				}else if(input == 1){
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Kullanýcý silinmedi","Mesaj",JOptionPane.PLAIN_MESSAGE); 
					return;
				}else if(input == 2) {
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Vazgeçtiniz","Mesaj",JOptionPane.PLAIN_MESSAGE); 
					return;
				}
					
				}
									
			}
			if(cmd.equals("update")) {
				
				System.out.println("update is clicked");
				
				int selectedRow = table.getSelectedRow();
				
				if (selectedRow == -1) {
					
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Kullanýcý seçin","Uyarý",JOptionPane.WARNING_MESSAGE); 
					
					return;
				}else {
					
					PatientDTO patient = tableModel.getDataList().get(selectedRow);
					PatientEditor editor = new PatientEditor();
					editor.setPersonel(patient);
					patient = editor.showDialog();
					if(patient != null) {
					
					tableModel.getDataList().set(selectedRow, patient);
					tableModel.fireTableDataChanged();
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Kullanýcý düzenlendi","Mesaj",JOptionPane.PLAIN_MESSAGE); 
					}else {
					JFrame f; 
					f=new JFrame(); 
					JOptionPane.showMessageDialog(f,"Kullanýcý düzenlenemedi","Mesaj",JOptionPane.PLAIN_MESSAGE); 
					}
				
					}
				}		
			
				
			}
		
		}
						
	}



