package com.erc.view.doctor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.erc.login.MenuFrame.MenuBarEventListener;
import com.erc.view.Staff.StaffPanel;
import java.awt.GridBagLayout;
import javax.swing.JToolBar;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;

public class InformationsPanel extends JPanel {
	
	
	public InformationsPanel() {
		PolyclinicPanel polyclinicPanel = new PolyclinicPanel();
		
		JTabbedPane tp=new JTabbedPane();  
		tp.setBounds(50,50,200,200);  
		tp.addTab("Poliklinik Bilgileri",polyclinicPanel);
		
		PatientRegistrationInformationPanel patientRegistrationInformationPanel = new PatientRegistrationInformationPanel();	
		tp.addTab("Hasta Sicil Bilgileri",patientRegistrationInformationPanel);
		
		AnamnezPanel anamnezPanel = new AnamnezPanel();
		tp.addTab("Anamnez",anamnezPanel);
		
		DemandResultPanel demandResultPanel = new DemandResultPanel();
		tp.addTab("Talep Sonuç", demandResultPanel);
		
		CaseRegistrationPanel caseRegistration = new CaseRegistrationPanel();
		tp.addTab("Vaka Kaydý", caseRegistration);
		
		AddServicePanel addServicePanel = new AddServicePanel();
		tp.addTab("Hizmet Ekleme", addServicePanel);
		
		EvaluationPanel evaluationPanel = new EvaluationPanel();
		tp.addTab("Deðerlendirmeler", evaluationPanel);
		
		ComplaintsPanel complaintsPanel = new ComplaintsPanel();
		tp.addTab("Þikayetler", complaintsPanel);
		
	
		
		this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(800, 200));
        this.add(tp, BorderLayout.CENTER);
	}


}
