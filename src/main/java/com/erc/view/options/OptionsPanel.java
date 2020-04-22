package com.erc.view.options;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import com.erc.entities.OrganizationDTO;
import com.erc.entities.StaffDTO;
import com.erc.user.service.OptionsService;
import com.erc.user.service.StaffService;
import com.erc.view.Staff.StaffEditor;
import com.erc.view.Staff.StaffTableModel;
import com.erc.view.Staff.StaffPanel.Handler;

import javax.swing.JScrollPane;

public class OptionsPanel extends JPanel {
	private JTable table = new JTable();
	private OptionsTableModel tableModel = new OptionsTableModel();
	private OrganizationDTO options;

	public OptionsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 52, 0, 272, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnAdd = new JButton("ADD");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 0;
		add(btnAdd, gbc_btnAdd);

		JButton btnUpdate = new JButton("UPDATE");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 3;
		gbc_btnUpdate.gridy = 0;
		add(btnUpdate, gbc_btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 0;
		add(btnDelete, gbc_btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		Handler handler = new Handler();
		btnAdd.addActionListener(handler);
		btnUpdate.addActionListener(handler);
		btnDelete.addActionListener(handler);

		btnAdd.setActionCommand("ADD");
		btnUpdate.setActionCommand("UPDATE");
		btnDelete.setActionCommand("DELETE");
		
		getOptionsListFromService();

	}
	private void getOptionsListFromService() {
		 OptionsService service = new OptionsService();
		 ArrayList<OrganizationDTO> optionList = service.getAllOptions();
		 tableModel.setDataList(optionList);
		 table.setModel(tableModel);
		 tableModel.fireTableDataChanged();	
	}

	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String cmd = event.getActionCommand();
			if (cmd.equals("ADD")) {
				
				System.out.println("add is clicked");
				OptionsEditor optionsEditor = new OptionsEditor();
				options = optionsEditor.showDialog();
				if (options != null) {

					tableModel.getDataList().add(options);
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
				System.out.println("Update is clicked");
				int selectedRow = table.getSelectedRow();

				if (selectedRow == -1) {

					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Option seçiniz", "Uyarý", JOptionPane.WARNING_MESSAGE);

					return;
				} else {

					OrganizationDTO options = tableModel.getDataList().get(selectedRow);
					OptionsEditor editor = new OptionsEditor();
					editor.setOptions(options);
					options = editor.showDialog();

					if (options != null) {
						tableModel.getDataList().set(selectedRow, options);
						tableModel.fireTableDataChanged();
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Option düzenlendi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
					} else {
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Option düzenlenemedi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
					}
				}
			} else if (cmd.equals("DELETE")) {
				System.out.println("Delete is clicked");

				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Option seçin", "Uyarý", JOptionPane.WARNING_MESSAGE);
					return;

				} else {
					int input = JOptionPane.showConfirmDialog(null, "Silmek istediðinize emin misiniz?", "UYARI",
							JOptionPane.YES_NO_CANCEL_OPTION);

					// 0=yes, 1=no, 2=cancel
					System.out.println(input);
					if (input == 0) {
						OrganizationDTO options = tableModel.getDataList().get(selectedRow);
						OptionsService service = new OptionsService();

						boolean isDeleted = service.deleteOptions(options);
						if (isDeleted) {
							tableModel.getDataList().remove(selectedRow);
							tableModel.fireTableDataChanged();
							JFrame f;
							f = new JFrame();
							JOptionPane.showMessageDialog(f, "Option silindi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
						}
					} else if (input == 1) {
						JFrame f;
						f = new JFrame();
						JOptionPane.showMessageDialog(f, "Option silinmedi", "Mesaj", JOptionPane.PLAIN_MESSAGE);
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