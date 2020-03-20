package com.erc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.erc.view.options.OptionsPanel;
import com.erc.view.patient.PatientPanel;
import com.erc.view.personel.PersonnelPanel;

public class MainApp extends JFrame {
	private JPanel toolbarPanel = new JPanel();
	private JPanel contentPanel = new JPanel();
	
	public MainApp() {
		
		toolbarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel.setLayout(new BorderLayout());
		
		getContentPane().add(toolbarPanel, BorderLayout.NORTH);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}
	private static final long serialVersionUID = 1L;
 
	public static void main(String[] args) {
		
		MainApp frame = new MainApp();
		frame.addMenuBar();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 360);
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	private void addMenuBar() {
		JMenuBar toolbar = new JMenuBar();
		JMenu personnelMenu = new JMenu("Personnel");
		JMenu patientMenu = new JMenu("Patient");
	    JMenu admissionMenu = new JMenu("Admission");
	    JMenu optionsMenu = new JMenu("Options");

		toolbar.add(personnelMenu);
		toolbar.add(patientMenu);
		toolbar.add(admissionMenu);
		toolbar.add(optionsMenu);
		
		MenuBarEventListener eventListener = new MenuBarEventListener();
		
		
		//???
		
		JMenuItem personnels = new JMenuItem("Personnels");
		personnelMenu.add(personnels);
		personnels.addActionListener(eventListener);
		personnels.setActionCommand("PERSONNEL_LIST");
		
		
		JMenuItem patients = new JMenuItem("Patients");
		patientMenu.add(patients);
		patients.addActionListener(eventListener);
		patients.setActionCommand("PATIENT_LIST");
		
		JMenuItem options = new JMenuItem("Options");
		optionsMenu.add(options);
		options.addActionListener(eventListener);
		options.setActionCommand("OPTIONS_LIST");
		
		//???
		
		toolbarPanel.add(toolbar);
	}

	
	public class MenuBarEventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
 			if(cmd.equals("PERSONNEL_LIST")) {
 				PersonnelPanel panel = new PersonnelPanel();
 				contentPanel.removeAll();
 				contentPanel.setLayout(new BorderLayout());
 				contentPanel.add(panel, BorderLayout.CENTER);
 				contentPanel.revalidate();
 			}else if(cmd.equals("PATIENT_LIST")) {
 				PatientPanel panel = new PatientPanel();
 				contentPanel.removeAll();
 				contentPanel.setLayout(new BorderLayout());
 				contentPanel.add(panel, BorderLayout.CENTER);
 				contentPanel.revalidate();
 			}else if(cmd.equals("OPTIONS_LIST")) {
 				OptionsPanel panel = new OptionsPanel();
 				contentPanel.removeAll();
 				contentPanel.setLayout(new BorderLayout());
 				contentPanel.add(panel, BorderLayout.CENTER);;
 				contentPanel.revalidate();
 			}
			
		}
		
	}
	
}
