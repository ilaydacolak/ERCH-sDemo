package com.erc.view.doctor;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.erc.entities.PatientDTO;

public class PatientComboboxModel extends AbstractListModel implements ComboBoxModel {
	private ArrayList<PatientDTO> patientList = new ArrayList<PatientDTO>();
	private Object selection = "Hasta Listesi";
	private ArrayList<String> patientInf = new ArrayList<String>();
	public ArrayList<String> getPatient (ArrayList<PatientDTO> patientList){
	
		for(PatientDTO patient : patientList) {
			patientInf.add(patient.getName() + " " + patient.getSurname());
		}
		return patientInf;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return patientInf.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return patientInf.size();
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
		getPatient(patientList);
		this.patientList = patientList;
	}

}
