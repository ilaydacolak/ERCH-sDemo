package com.erc.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.erc.view.Staff.StaffPanel;
import com.erc.view.appointment.AppointmentPanel;
import com.erc.view.doctor.DoctorPanel;
import com.erc.view.options.OptionsPanel;
import com.erc.view.patient.PatientPanel;
import com.erc.view.patientAccept.PatientAcceptPanel;
import com.erc.view.staffType.StaffTypePanel;

public class MenuFrame extends JFrame {
	private JPanel toolbarPanel = new JPanel();
	private JPanel contentPanel = new JPanel();

	public MenuFrame() {
		toolbarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPanel.setLayout(new BorderLayout());

		getContentPane().add(toolbarPanel, BorderLayout.NORTH);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

	}

	private static final long serialVersionUID = 1L;
	

	public static void main(String[] args) {
		MenuFrame menuFrame = new MenuFrame();
		menuFrame.startApplication();
		
	}

	public void startApplication() {
		MenuFrame frame = new MenuFrame();
		frame.addMenuBar();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 560);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	private void addMenuBar() {
		JMenuBar toolbar = new JMenuBar();
		JMenu personnelMenu = new JMenu("Staff");
		JMenu patientMenu = new JMenu("Patient");
		JMenu admissionMenu = new JMenu("Admission");
		JMenu optionsMenu = new JMenu("Organizations");
		JMenu settingsMenu = new JMenu("Settings");
		JMenu patientAcceptMenu = new JMenu("Hasta Kabul");
		JMenu appointmentMenu = new JMenu("Randevu");
		JMenu doctorMenu = new JMenu("Doctor");
		

		toolbar.add(personnelMenu);
		toolbar.add(patientMenu);
		toolbar.add(admissionMenu);
		toolbar.add(optionsMenu);
		toolbar.add(settingsMenu);
		toolbar.add(patientAcceptMenu);
		toolbar.add(appointmentMenu);
		toolbar.add(doctorMenu);

		MenuBarEventListener eventListener = new MenuBarEventListener();

		// ???

		JMenuItem personnels = new JMenuItem("Staffs");
		personnelMenu.add(personnels);
		personnels.addActionListener(eventListener);
		personnels.setActionCommand("STAFF_LIST");

		JMenuItem patients = new JMenuItem("Patients");
		patientMenu.add(patients);
		patients.addActionListener(eventListener);
		patients.setActionCommand("PATIENT_LIST");

		JMenuItem options = new JMenuItem("Options");
		optionsMenu.add(options);
		options.addActionListener(eventListener);
		options.setActionCommand("OPTIONS_LIST");

		JMenuItem settings = new JMenuItem("StaffType");
		settingsMenu.add(settings);
		settings.addActionListener(eventListener);
		settings.setActionCommand("SETTINGS_LIST");

		JMenuItem patientAccept = new JMenuItem("Hasta Kabul");
		patientAcceptMenu.add(patientAccept);
		patientAccept.addActionListener(eventListener);
		patientAccept.setActionCommand("PATIENTACCEPT_LIST");

		JMenuItem appointment = new JMenuItem("Randevu");
		appointmentMenu.add(appointment);
		appointment.addActionListener(eventListener);
		appointment.setActionCommand("APPOINTMENT_LIST");

		JMenuItem doctorPage = new JMenuItem("Doctor");
		doctorMenu.add(doctorPage);
		doctorPage.addActionListener(eventListener);
		doctorPage.setActionCommand("DOCTOR_LIST");

		toolbarPanel.add(toolbar);
	}

	public class MenuBarEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("STAFF_LIST")) {
				StaffPanel panel = new StaffPanel();
				contentPanel.removeAll();
				contentPanel.setLayout(new BorderLayout());
				contentPanel.add(panel, BorderLayout.CENTER);
				contentPanel.revalidate();
			} else if (cmd.equals("PATIENT_LIST")) {
				PatientPanel panel = new PatientPanel();
				contentPanel.removeAll();
				contentPanel.setLayout(new BorderLayout());
				contentPanel.add(panel, BorderLayout.CENTER);
				contentPanel.revalidate();
			} else if (cmd.equals("OPTIONS_LIST")) {
				OptionsPanel panel = new OptionsPanel();
				contentPanel.removeAll();
				contentPanel.setLayout(new BorderLayout());
				contentPanel.add(panel, BorderLayout.CENTER);
				;
				contentPanel.revalidate();
			} else if (cmd.equals("SETTINGS_LIST")) {
				StaffTypePanel panel = new StaffTypePanel();
				contentPanel.removeAll();
				contentPanel.setLayout(new BorderLayout());
				contentPanel.add(panel, BorderLayout.CENTER);
				;
				contentPanel.revalidate();
			} else if (cmd.equals("PATIENTACCEPT_LIST")) {
				PatientAcceptPanel panel = new PatientAcceptPanel();
				contentPanel.removeAll();
				contentPanel.setLayout(new BorderLayout());
				contentPanel.add(panel, BorderLayout.CENTER);
				;
				contentPanel.revalidate();
			} else if (cmd.equals("APPOINTMENT_LIST")) {
				AppointmentPanel panel = new AppointmentPanel();
				contentPanel.removeAll();
				contentPanel.setLayout(new BorderLayout());
				contentPanel.add(panel, BorderLayout.CENTER);
				;
				contentPanel.revalidate();
			} else if (cmd.equals("DOCTOR_LIST")) {
				DoctorPanel panel = new DoctorPanel();
				contentPanel.removeAll();
				contentPanel.setLayout(new BorderLayout());
				contentPanel.add(panel, BorderLayout.CENTER);
				;
				contentPanel.revalidate();
			}
		}

	}

}
