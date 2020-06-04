package com.erc.view.Staff;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import java.time.LocalDate;

import com.erc.entities.OrganizationDTO;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;
import com.erc.entities.StaffTypeDTO;
import com.erc.user.service.OptionsService;
import com.erc.user.service.StaffService;
import com.erc.user.service.StaffTypeService;

import com.erc.user.service.StaffService;

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
import javax.swing.ComboBoxModel;

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
import javax.swing.JComboBox;

public class StaffEditor extends JPanel {
	private JTextField textTC;
	private JTextField textName;
	private JTextField textSurname;
	private JCheckBox bxActive;
	private JDateChooser dateChooser;

	private StaffDTO personel;
	private JDialog dialog = new JDialog();
	private JTextField textUsername;
	private Stage stage;
	private DatePicker checkInDatePicker;
	private JTextField textPassword;
	private JComboBox personelTypeCombobox;
	private JLabel lblNewLabel_1;
	private JLabel lblGender;
	private JComboBox genderCombobox;
	private GenderComboboxModel comboboxModel = new GenderComboboxModel();
	private StaffTypeComboboxModel personelCombobox = new StaffTypeComboboxModel();
	private JTextField txtAktif;
	String personelType;
	private JLabel lblOrganization;
	private JComboBox organizationCmbbx;
	private OrganizationComboboxModel organizationComboboxModel = new OrganizationComboboxModel();

	public StaffEditor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 5, 0, 10, 0, 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		lblNewLabel_1 = new JLabel("Staff Type:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 14;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		personelTypeCombobox = new JComboBox();
		GridBagConstraints gbc_personelTypeCombobox = new GridBagConstraints();
		gbc_personelTypeCombobox.gridwidth = 2;
		gbc_personelTypeCombobox.insets = new Insets(0, 0, 5, 5);
		gbc_personelTypeCombobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_personelTypeCombobox.gridx = 3;
		gbc_personelTypeCombobox.gridy = 14;
		add(personelTypeCombobox, gbc_personelTypeCombobox);


		StaffTypeService service = new StaffTypeService();
		ArrayList<StaffTypeDTO> staffTypes = service.getAllStaffTypes();
	
	

		personelCombobox.setStaffTypes(staffTypes);
		personelTypeCombobox.setModel(personelCombobox);

		lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.WEST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 1;
		gbc_lblGender.gridy = 16;
		add(lblGender, gbc_lblGender);

		genderCombobox = new JComboBox();
		GridBagConstraints gbc_genderCombobox = new GridBagConstraints();
		gbc_genderCombobox.gridwidth = 2;
		gbc_genderCombobox.insets = new Insets(0, 0, 5, 5);
		gbc_genderCombobox.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderCombobox.gridx = 3;
		gbc_genderCombobox.gridy = 16;
		add(genderCombobox, gbc_genderCombobox);

		genderCombobox.setModel(comboboxModel);
								
								lblOrganization = new JLabel("Organization:");
								GridBagConstraints gbc_lblOrganization = new GridBagConstraints();
								gbc_lblOrganization.insets = new Insets(0, 0, 5, 5);
								gbc_lblOrganization.gridx = 1;
								gbc_lblOrganization.gridy = 18;
								add(lblOrganization, gbc_lblOrganization);
								
								organizationCmbbx = new JComboBox();
								GridBagConstraints gbc_organizationCmbbx = new GridBagConstraints();
								gbc_organizationCmbbx.gridwidth = 2;
								gbc_organizationCmbbx.insets = new Insets(0, 0, 5, 5);
								gbc_organizationCmbbx.fill = GridBagConstraints.HORIZONTAL;
								gbc_organizationCmbbx.gridx = 3;
								gbc_organizationCmbbx.gridy = 18;
								add(organizationCmbbx, gbc_organizationCmbbx);
								
								OptionsService organizationService = new OptionsService();
								ArrayList<OrganizationDTO> organizationList = organizationService.getAllOptions();
								organizationComboboxModel.setOrganizationList(organizationList);
								organizationCmbbx.setModel(organizationComboboxModel);
						
								bxActive = new JCheckBox("\u0130s Active ?");
								GridBagConstraints gbc_bxActive = new GridBagConstraints();
								gbc_bxActive.insets = new Insets(0, 0, 5, 5);
								gbc_bxActive.gridx = 1;
								gbc_bxActive.gridy = 20;
								add(bxActive, gbc_bxActive);
						
								JButton btnSave = new JButton("Save");
								GridBagConstraints gbc_btnSave = new GridBagConstraints();
								gbc_btnSave.insets = new Insets(0, 0, 5, 5);
								gbc_btnSave.gridx = 4;
								gbc_btnSave.gridy = 20;
								add(btnSave, gbc_btnSave);
								
										btnSave.addActionListener(editorHandler);
										btnSave.setActionCommand("Save");
				
						txtAktif = new JTextField();
						GridBagConstraints gbc_txtAktif = new GridBagConstraints();
						gbc_txtAktif.insets = new Insets(0, 0, 5, 5);
						gbc_txtAktif.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtAktif.gridx = 3;
						gbc_txtAktif.gridy = 21;
						add(txtAktif, gbc_txtAktif);
						txtAktif.setColumns(10);
		txtAktif.setVisible(false);

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
				boolean isActive = bxActive.isSelected();
				Date bDate = dateChooser.getDate();

	//			String personelType = personelCombobox.getSelectedItem().toString();
	

				String gender = null;
				if(genderCombobox.getSelectedItem()!=null) {
					 gender=genderCombobox.getSelectedItem().toString();
				}
				String personelType = personelTypeCombobox.getSelectedItem().toString();
				
				OrganizationDTO organizationDTO = new OrganizationDTO();
				if(organizationCmbbx.getSelectedItem() != null) {
					organizationDTO= organizationComboboxModel.getOrganizationList().get(organizationCmbbx.getSelectedIndex());
				}
						
				StaffTypeDTO staff ;


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
				} else if (password.length() == 0) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter Password", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (bDate == null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter Date", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (genderCombobox.getSelectedItem()==null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please,enter Gender", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}else if(personelTypeCombobox.getSelectedItem()==null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please select  the staff type", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}else if(personelTypeCombobox.getSelectedItem()==null) {
					JFrame f;
					f = new JFrame();
					JOptionPane.showMessageDialog(f, "Please select  the staff type", "Alert", JOptionPane.WARNING_MESSAGE);
					return;
				}else if(organizationCmbbx.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(new JFrame(), "Please select  the organization", "Alert", JOptionPane.WARNING_MESSAGE);
				}
				


				if (personel == null) {
					personel = new StaffDTO();
				}

				
				personel.setIdentificationno(tc);
				personel.setName(name);
				personel.setLastname(surname);
				personel.setUsername(username);
				personel.setPassword(password);
				personel.setbDate(bDate);
				personel.setGender(gender);
				personel.setorganizationID(organizationDTO.getoptionsID());

				personel.setPersonelType(personelType);
				StaffTypeDTO staffTypeDTO = (StaffTypeDTO)personelCombobox.getSelectedItem();
				personel.setStaffTypeDTO(staffTypeDTO);
				
//				personel.setPersonelType(personelCombobox.getSelectedItem().toString());


//			StaffTypeDTO staffType = new StaffTypeDTO();
//////				staffType.setStaffTypeID("53352e4f-5484-430d-9e80-c7e13f6e2f39");
//////				personel.setStaffTypeDTO(staffType);
////
//				personel.setStaffTypeDTO(staffType);
			// personel.setPersonelType(personelType);

				
				StaffTypeDTO staffType = new StaffTypeDTO();
				staffType.setStaffTypeID("085a587c-19d3-4484-b65b-71ae8b020682");
				personel.setStaffTypeDTO(staffType);
				
			//	personel.setPersonelType(personelType);
				
				
				

				if (isActive == true) {
					personel.setActive(true);
					personel.setAktif("YES");

				} else {
					personel.setActive(false);
					personel.setAktif("NO");
				}

				StaffService service = new StaffService();
				personel = service.saveStaff(personel);
				dialog.dispose();

			}
		}
	}

	public StaffDTO getPersonel() {
		return personel;
	}

	public void setPersonel(StaffDTO personel) {
		this.personel = personel;

	}

	public StaffDTO showDialog() {
		// TODO Auto-generated method stub
		dialog.getContentPane().add(this);
		dialog.setModal(true);
		dialog.setSize(450, 380);
		dialog.setLocationRelativeTo(this);
		fillScreen();
		dialog.setVisible(true);

		return personel;

	}

	private void fillScreen() {
		// TODO Auto-generated method stub
		if (personel != null) {
			
			textTC.setText(personel.getIdentificationno());
			textName.setText(personel.getName());
			textSurname.setText(personel.getLastname());
			textUsername.setText(personel.getUsername());
			textPassword.setText(personel.getPassword());
			dateChooser.setDate(personel.getbDate());
			txtAktif.setText(personel.getAktif());

			if (personel.getStaffTypeDTO() != null) {
				String staffTypeId = personel.getStaffTypeDTO().getStaffTypeID();
				ArrayList<StaffTypeDTO> staffTypes = personelCombobox.getStaffTypes();

				for (StaffTypeDTO staffTypeDTO : staffTypes) {
					if (staffTypeDTO.getStaffTypeID().equals(staffTypeId)) {
						personelCombobox.setSelectedItem(staffTypeDTO);
						break;
					}
				}
			}

			genderCombobox.setSelectedItem(personel.getGender());
			bxActive.setSelected(personel.isActive());

		}
	}
}
