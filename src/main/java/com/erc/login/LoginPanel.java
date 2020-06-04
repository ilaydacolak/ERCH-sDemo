package com.erc.login;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.erc.entities.StaffDTO;
import com.erc.user.service.StaffService;
import com.erc.view.MainApp;
import com.erc.view.doctor.DoctorPanel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	public JTextField textUsername;
	private JPasswordField passwordField;
	private AuthService authService;
	// yani hem event hem panel paylasmasin. Cok garib buglar cikiyor bulmasý zor
	// oluyor

//	private MenuFrame menuFrame = new MenuFrame();
	public LoginPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 2;
		add(lblUsername, gbc_lblUsername);

		textUsername = new JTextField();
		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.insets = new Insets(0, 0, 5, 0);
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.gridx = 4;
		gbc_textUsername.gridy = 2;
		add(textUsername, gbc_textUsername);
		textUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 4;
		add(lblPassword, gbc_lblPassword);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);

		EditorHandler editorHandler = new EditorHandler();

		JButton btnLogin = new JButton("Login");

		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin.gridx = 4;
		gbc_btnLogin.gridy = 6;
		add(btnLogin, gbc_btnLogin);

		btnLogin.addActionListener(editorHandler);
		btnLogin.setActionCommand("Login");

	}

	public class EditorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			boolean login = false ;
			int tmp = 0;
			if (cmd.equals("Login")) {
				StaffService staffService = new StaffService();

				ArrayList<StaffDTO> staffList = staffService.getAllStaff();
				for (StaffDTO staffDTO : staffList) {
					if (staffDTO.getUsername().equals(textUsername.getText())
							&& staffDTO.getPassword().equals(passwordField.getText())) {
						AuthService.setStaffDTO(staffDTO);
						DoctorPanel.setStaffDTO(staffDTO);
				

						MenuFrame menuFrame = new MenuFrame();
						menuFrame.startApplication();
						login = true;
						JOptionPane.showMessageDialog(new JFrame(), "Login is success", "Alert",
								JOptionPane.WARNING_MESSAGE);

						return;

					} else if(!(staffDTO.getUsername().equals(textUsername.getText())
							&& staffDTO.getPassword().equals(passwordField.getText()))) {
						JOptionPane.showMessageDialog(new JFrame(), "Login is fail", "Alert",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
				}

		
			}

		}

	}



	public Object MenuFrame() {
		// TODO Auto-generated method stub
		return null;
	}

}
