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

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private JTextField textUsername;
	private JPasswordField passwordField;

	public Login() {
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
			int tmp = 0;
			if (cmd.equals("Login")) {
				StaffService staffService = new StaffService();
				ArrayList<StaffDTO> staffList = staffService.getAllStaff();
				for (StaffDTO staff : staffList) {
					if (staff.getUsername().equals(textUsername.getText())
							&& staff.getPassword().equals(passwordField.getText())) {
						tmp = 1;
						MainApp mainFrame = new MainApp();
						mainFrame.setVisible(true);

						JOptionPane.showMessageDialog(new JFrame(), "Login is success", "Alert",
								JOptionPane.WARNING_MESSAGE);
						return;
						
					}
				}
				if(tmp == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Login is fail", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}

		}

	}

}
