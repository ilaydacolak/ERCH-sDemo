package com.erc.view.personel;

import javax.swing.JPanel;
import javafx.scene.control.DatePicker;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import java.time.LocalDate;

import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;
import com.erc.user.service.PersonelService;
import com.erc.view.patient.PatientEditor.EditorHandler;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Checkbox;
import javafx.scene.control.DatePicker;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.Canvas;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javafx.stage.Stage;
import javax.swing.Box;
import javafx.scene.layout.FlowPane;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.TilePane;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import net.sourceforge.jdatepicker.util.JDatePickerUtil;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JYearChooser;

public class PersonelEditor extends JPanel {
	private JTextField textTC;
	private JTextField textName;
	private JTextField textSurname;
	private JCheckBox chckbxBdate;
	private JDateChooser dateChooser;

	private PersonnelDTO personel;
	private JDialog dialog = new JDialog();
	private JTextField textUsername;
	private Stage stage;
	private DatePicker checkInDatePicker;
	private JTextField textPassword;

	public PersonelEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 0, 10, 0, 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 22, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblTC = new JLabel("TC:");
		GridBagConstraints gbc_lblTC = new GridBagConstraints();
		gbc_lblTC.anchor = GridBagConstraints.WEST;
		gbc_lblTC.insets = new Insets(0, 0, 5, 5);
		gbc_lblTC.gridx = 1;
		gbc_lblTC.gridy = 2;
		add(lblTC, gbc_lblTC);

		textTC = new JTextField();
		GridBagConstraints gbc_textTC = new GridBagConstraints();
		gbc_textTC.gridwidth = 2;
		gbc_textTC.insets = new Insets(0, 0, 5, 5);
		gbc_textTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTC.gridx = 3;
		gbc_textTC.gridy = 2;
		add(textTC, gbc_textTC);
		textTC.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 4;
		add(lblName, gbc_lblName);

		textName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.gridwidth = 2;
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 3;
		gbc_textName.gridy = 4;
		add(textName, gbc_textName);
		textName.setColumns(10);

		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.WEST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 1;
		gbc_lblSurname.gridy = 6;
		add(lblSurname, gbc_lblSurname);

		textSurname = new JTextField();
		GridBagConstraints gbc_textSurname = new GridBagConstraints();
		gbc_textSurname.gridwidth = 2;
		gbc_textSurname.insets = new Insets(0, 0, 5, 5);
		gbc_textSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSurname.gridx = 3;
		gbc_textSurname.gridy = 6;
		add(textSurname, gbc_textSurname);
		textSurname.setColumns(10);

		EditorHandler editorHandler = new EditorHandler();

		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 8;
		add(lblUsername, gbc_lblUsername);

		/*
		 * date = new DatePicker(); date.setPromptText("Date of Birth");
		 * date.setMaxWidth(300);
		 */
		/*
		 * UtilDateModel model = new UtilDateModel(); JDatePanelImpl datePanel = new
		 * JDatePanelImpl(model); JDatePickerImpl datePicker = new
		 * JDatePickerImpl(datePanel);
		 * 
		 * frame.add(datePicker);
		 */

		textUsername = new JTextField();
		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.gridwidth = 2;
		gbc_textUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.gridx = 3;
		gbc_textUsername.gridy = 8;
		add(textUsername, gbc_textUsername);
		textUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 10;
		add(lblPassword, gbc_lblPassword);

		textPassword = new JTextField();
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.gridwidth = 2;
		gbc_textPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.gridx = 3;
		gbc_textPassword.gridy = 10;
		add(textPassword, gbc_textPassword);
		textPassword.setColumns(10);

		JLabel lblNewLabel = new JLabel("Birth Date:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 12;
		add(lblNewLabel, gbc_lblNewLabel);

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 12;
		add(dateChooser, gbc_dateChooser);

		chckbxBdate = new JCheckBox("\u0130s Active ?");
		GridBagConstraints gbc_chckbxBdate = new GridBagConstraints();
		gbc_chckbxBdate.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxBdate.gridx = 1;
		gbc_chckbxBdate.gridy = 14;
		add(chckbxBdate, gbc_chckbxBdate);

		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 4;
		gbc_btnSave.gridy = 14;
		add(btnSave, gbc_btnSave);

		btnSave.addActionListener(editorHandler);
		btnSave.setActionCommand("Save");

	}

	public class EditorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			String cmd = event.getActionCommand();

			if (cmd.equals("Save")) {
				System.out.println("Save is clicked");
				String tc = textTC.getText();
				String name = textName.getText();
				String surname = textSurname.getText();
				String username = textUsername.getText();
				String password = textPassword.getText();
				boolean isActive = chckbxBdate.isSelected();
				Date bDate = dateChooser.getDate();

				if (tc.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter TC", "Alert", JOptionPane.WARNING_MESSAGE);
					return;

				} else if (name.length() == 0) {

					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter name", "Alert", JOptionPane.WARNING_MESSAGE);
					return;

				} else if (surname.length() == 0) {

					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter Surname", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (username.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter Username", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (personel == null) {
					personel = new PersonnelDTO();
				}

				personel.setIdentificationno(tc);
				personel.setName(name);
				personel.setLastname(surname);
				personel.setUsername(username);
				personel.setPassword(password);
				personel.setbDate(bDate);
				if (isActive == true) {
					personel.setActive(true);
				} else {
					personel.setActive(false);
				}

				PersonelService service = new PersonelService();
				personel = service.savePersonel(personel);
				dialog.dispose();

			}
		}
	}

	public PersonnelDTO getPersonel() {
		return personel;
	}

	public void setPersonel(PersonnelDTO personel) {
		this.personel = personel;
	}

	public PersonnelDTO showDialog() {
		dialog.getContentPane().add(this);
		dialog.setModal(true);
		dialog.setSize(350, 280);
		dialog.setLocationRelativeTo(this);
		fillScreen();
		dialog.setVisible(true);

		return personel;
	}

	private void fillScreen() {
		if (personel != null) {
			textTC.setText(personel.getIdentificationno());
			textName.setText(personel.getName());
			textSurname.setText(personel.getLastname());
			textUsername.setText(personel.getUsername());
			textPassword.setText(personel.getPassword());

		}

	}
}
