package com.erc.view.staff;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.erc.entities.StaffDTO;
import com.erc.entities.StaffTypeDTO;
import com.erc.user.service.StaffService;
import com.erc.user.service.StaffTypeService;
import com.erc.view.personel.StaffEditor;
import com.erc.view.personel.StaffTableModel;

public class StaffTypePanel extends JPanel {
	private JTable table;
	private StaffTypeTableModel tableModel = new StaffTypeTableModel();

	public StaffTypePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton addbtn = new JButton("ADD");
		GridBagConstraints gbc_addbtn = new GridBagConstraints();
		gbc_addbtn.insets = new Insets(0, 0, 5, 5);
		gbc_addbtn.gridx = 1;
		gbc_addbtn.gridy = 0;
		add(addbtn, gbc_addbtn);

		JButton updatebtn = new JButton("UPDATE");
		GridBagConstraints gbc_updatebtn = new GridBagConstraints();
		gbc_updatebtn.insets = new Insets(0, 0, 5, 5);
		gbc_updatebtn.gridx = 2;
		gbc_updatebtn.gridy = 0;
		add(updatebtn, gbc_updatebtn);

		JButton deletebtn = new JButton("DELETE");
		GridBagConstraints gbc_deletebtn = new GridBagConstraints();
		gbc_deletebtn.insets = new Insets(0, 0, 5, 5);
		gbc_deletebtn.gridx = 3;
		gbc_deletebtn.gridy = 0;
		add(deletebtn, gbc_deletebtn);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		Handler handler = new Handler();
		addbtn.addActionListener(handler);
		updatebtn.addActionListener(handler);
		deletebtn.addActionListener(handler);

		addbtn.setActionCommand("ADD");
		updatebtn.setActionCommand("UPDATE");
		deletebtn.setActionCommand("DELETE");

		getStaffListFromService();

	}

	private void getStaffListFromService() {
		StaffTypeService service = new StaffTypeService();
		ArrayList<StaffTypeDTO> staffList = service.getAllStaffTypes();
		tableModel.setDataList(staffList);
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();

	}

	public class Handler implements ActionListener {
		StaffTypeDTO staff = new StaffTypeDTO();

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			if (cmd.equals("ADD")) {
				System.out.println("add is clicked");

				StaffTypeEditor staffEditor = new StaffTypeEditor();
				staff = staffEditor.showDialog();
				if (staff != null) {
					tableModel.getDataList().add(staff);
					tableModel.fireTableDataChanged();
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Kullanýcý eklendi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
				} else {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Kullanýcý eklenemedi", "Mesaj", JOptionPane.PLAIN_MESSAGE);

				}

			} else if (cmd.equals("UPDATE")) {
				System.out.println("update is clicked");
				int selectedRow = table.getSelectedRow();

				if (selectedRow == -1) {

					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Kullanýcý seçin", "Uyarý", JOptionPane.WARNING_MESSAGE);

					return;
				} else {

					StaffTypeDTO staff = tableModel.getDataList().get(selectedRow);
					StaffTypeEditor editor = new StaffTypeEditor();
					editor.setStaff(staff);
					staff = editor.showDialog();

					if (staff != null) {
						tableModel.getDataList().set(selectedRow, staff);
						tableModel.fireTableDataChanged();
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Kullanýcý düzenlendi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
					} else {
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Kullanýcý düzenlenemedi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
					}

				}

			} else if (cmd.equals("DELETE")) {

				System.out.println("delete is clicked");
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Kullanýcý seçin", "Uyarý", JOptionPane.WARNING_MESSAGE);
					return;

				} else {
					int input = JOptionPane.showConfirmDialog(null, "Silmek istediðinize emin misiniz?", "UYARI",
							JOptionPane.YES_NO_CANCEL_OPTION);

					// 0=yes, 1=no, 2=cancel
					System.out.println(input);
					if (input == 0) {
						StaffTypeDTO staff = tableModel.getDataList().get(selectedRow);
						StaffTypeService service = new StaffTypeService();
						boolean isDeleted = service.deleteStaffType(staff);
						if (isDeleted) {
							tableModel.getDataList().remove(selectedRow);
							tableModel.fireTableDataChanged();
							JFrame f;
							f = new JFrame();
							JOptionPane.showMessageDialog(f, "Kullanýcý silindi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
						}
					} else if (input == 1) {
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Kullanýcý silinmedi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
						return;
					} else if (input == 2) {
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Vazgeçtiniz", "Mesaj", JOptionPane.PLAIN_MESSAGE);
						return;
					}
				}

			}
		}

	}
}
