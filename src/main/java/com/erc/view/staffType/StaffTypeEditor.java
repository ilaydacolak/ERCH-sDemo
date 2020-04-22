package com.erc.view.staffType;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.erc.entities.StaffDTO;
import com.erc.entities.StaffTypeDTO;
import com.erc.user.service.StaffService;
import com.erc.user.service.StaffTypeService;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class StaffTypeEditor extends JPanel {
	StaffTypeDTO staff = new StaffTypeDTO();
	private JTextField txtStaffName;
	private JTextField txtStaffCode;

	private StaffDTO personel;

	private JDialog dialog = new JDialog();

	public StaffTypeEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel staffName = new JLabel("Staff Type:");
		GridBagConstraints gbc_staffName = new GridBagConstraints();
		gbc_staffName.insets = new Insets(0, 0, 5, 5);
		gbc_staffName.gridx = 2;
		gbc_staffName.gridy = 2;
		add(staffName, gbc_staffName);

		txtStaffName = new JTextField();
		GridBagConstraints gbc_txtStaffName = new GridBagConstraints();
		gbc_txtStaffName.insets = new Insets(0, 0, 5, 0);
		gbc_txtStaffName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStaffName.gridx = 4;
		gbc_txtStaffName.gridy = 2;
		add(txtStaffName, gbc_txtStaffName);
		txtStaffName.setColumns(10);

		JLabel staffCode = new JLabel("Staff Code:");
		GridBagConstraints gbc_staffCode = new GridBagConstraints();
		gbc_staffCode.insets = new Insets(0, 0, 5, 5);
		gbc_staffCode.gridx = 2;
		gbc_staffCode.gridy = 4;
		add(staffCode, gbc_staffCode);

		txtStaffCode = new JTextField();
		GridBagConstraints gbc_txtStaffCode = new GridBagConstraints();
		gbc_txtStaffCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtStaffCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStaffCode.gridx = 4;
		gbc_txtStaffCode.gridy = 4;
		add(txtStaffCode, gbc_txtStaffCode);
		txtStaffCode.setColumns(10);

		JButton btnSave = new JButton("SAVE");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridx = 4;
		gbc_btnSave.gridy = 6;
		add(btnSave, gbc_btnSave);

		EditorHandler editorHandler = new EditorHandler();
		btnSave.addActionListener(editorHandler);
		btnSave.setActionCommand("save");
	}

	public class EditorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			if (cmd.equals("save")) {
				String name = txtStaffName.getText();
				String code = txtStaffCode.getText();
				if (name.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter name", "Alert", JOptionPane.WARNING_MESSAGE);
					return;

				} else if (code.length() == 0) {

					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter code", "Alert", JOptionPane.WARNING_MESSAGE);
					return;

				}
				staff.setName(name);
				staff.setCode(code);

				StaffTypeService service = new StaffTypeService();
				//personel.setPersonelTypeNumber(staff);
				service.saveStaffType(staff);
//
//				StaffService service = new StaffService();
//				//personel.setPersonelTypeNumber(staff);
//				service.saveStaff(staff);

				dialog.dispose();
				

			}

		}
	}

	public StaffTypeDTO getPersonel() {
		return staff;
	}

	public void setStaff(StaffTypeDTO staff) {
		this.staff = staff;
	}

	public StaffTypeDTO showDialog() {
		dialog.getContentPane().add(this);
		dialog.setModal(true);
		dialog.setSize(350, 280);
		dialog.setLocationRelativeTo(this);
		fillScreen();
		dialog.setVisible(true);

		return staff;
	}

	private void fillScreen() {
		if (staff != null) {
			txtStaffCode.setText(staff.getCode());
			txtStaffName.setText(staff.getName());

		}

	}
}
