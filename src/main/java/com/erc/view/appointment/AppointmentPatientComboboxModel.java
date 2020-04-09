package com.erc.view.appointment;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.erc.entities.PatientDTO;

public class AppointmentPatientComboboxModel extends AbstractListModel implements ComboBoxModel{
	private ArrayList<PatientDTO> patientList = new ArrayList<PatientDTO>();
	private Object selection = null;
	private ArrayList<String> patients = new ArrayList<String>();
	
	public ArrayList<String> patients (ArrayList<PatientDTO> patientList){
		for (PatientDTO patient :patientList) {
			patients.add(patient.getName()+" "+ patient.getSurname());			
		}
		return patients;
	}
	
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return patients.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return patients.size();
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selection;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		selection = anItem;
	}

	public ArrayList<PatientDTO> getPatientList() {
		return patientList;
	}

	public void setPatientList(ArrayList<PatientDTO> patientList) {
		patients(patientList);
		this.patientList = patientList;
	}
	

}
