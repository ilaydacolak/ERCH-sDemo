package com.erc.view.doctor;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.erc.entities.PatientDTO;

public class PatientTableModel extends AbstractTableModel {

	private PatientDTO patient = new PatientDTO();	
	private String columnNames[]= {"Hasta No:","Ad Soyad","TC Kimlik No","Telefon","Yaþ","Öncelik","Cinsiyet","Kan Grubu"};
	
	public PatientDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}
	@Override
	public String getColumnName(int index) {
		return columnNames[index];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		
		case 0 :
			return patient.getPatientNo();
		case 1 :
			return patient.getName() +" " + patient.getSurname() ;
		case 2 :
			return patient.getTc();
		case 3 :
			return patient.getPhone();
		case 4 :
			return patient.getAge();
		case 5 :
			return patient.getPriority();
		case 6 :
			return patient.getGender();
		case 7 :
			return patient.getBloodGroup();
		}
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 1;
	}

}
