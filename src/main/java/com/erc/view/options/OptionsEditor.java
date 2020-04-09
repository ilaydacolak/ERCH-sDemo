package com.erc.view.options;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.erc.entities.OptionsDTO;
import com.erc.entities.StaffDTO;
import com.erc.user.service.OptionsService;
import com.erc.user.service.StaffService;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;

public class OptionsEditor extends JPanel {
	private JTextField txtName;
	private JCheckBox chckbxNewCheckBox;
	private OptionsDTO options;
	private JDialog dialog = new JDialog();

	public OptionsEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel OrgNameLlbl = new JLabel("Organization Name:");
		GridBagConstraints gbc_OrgNameLlbl = new GridBagConstraints();
		gbc_OrgNameLlbl.insets = new Insets(0, 0, 5, 5);
		gbc_OrgNameLlbl.gridx = 1;
		gbc_OrgNameLlbl.gridy = 1;
		add(OrgNameLlbl, gbc_OrgNameLlbl);

		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.gridwidth = 2;
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 1;
		add(txtName, gbc_txtName);
		txtName.setColumns(10);

		chckbxNewCheckBox = new JCheckBox("Is Active?");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 3;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		EditorHandler editorHandler = new EditorHandler();

		JButton btnSave = new JButton("SAVE");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 5;
		add(btnSave, gbc_btnSave);

		btnSave.addActionListener(editorHandler);
		btnSave.setActionCommand("SAVE");

	}

	public class EditorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			if (cmd.equals("SAVE")) {
				System.out.println("save clicked");
				String optionName = txtName.getText();
				boolean active = chckbxNewCheckBox.isSelected();

				if (optionName.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter organization name", "Alert",
							JOptionPane.WARNING_MESSAGE);
					return;

				}
				if (options == null) {
					options = new OptionsDTO();
				}
				options.setoptionsName(optionName);
				options.setIsActive(active);

				OptionsService service = new OptionsService();
				options = service.saveOptions(options);
				dialog.dispose();

			}

		}

	}

	public OptionsDTO getOptions() {
		return options;
	}

	public void setOptions(OptionsDTO options) {
		this.options = options;
	}

	public OptionsDTO showDialog() {
		dialog.getContentPane().add(this);
		dialog.setModal(true);
		dialog.setSize(250, 200);
		dialog.setLocationRelativeTo(this);
		fillScreen();
		dialog.setVisible(true);

		return options;
	}

	private void fillScreen() {
		if (options != null) {
			txtName.setText(options.getoptionsName());

		}

	}

}
