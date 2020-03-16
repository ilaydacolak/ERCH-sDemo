package com.erc.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.erc.dbconnection.DBConnection;
import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;

public class PatientService {
	private PatientDTO patient;

	public ArrayList<PatientDTO> getAllPatients() {

		Connection connection = DBConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from patient");

			ArrayList<PatientDTO> patientList = new ArrayList<PatientDTO>();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(6));

				PatientDTO patient = new PatientDTO();
				patient.setPatientId(rs.getString(1));
				patient.setTc(rs.getString(2));
				patient.setName(rs.getString(3));
				patient.setSurname(rs.getString(4));
				patient.setUsername(rs.getString(6));

				patientList.add(patient);

			}

			return patientList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean deletePatient(PatientDTO patient) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		try {
			String sqlDelete = "delete from patient where patientid=?";
			System.out.println(sqlDelete);
			PreparedStatement statement = connection.prepareStatement(sqlDelete);
			statement.setString(1, patient.getPatientId());
			int rows = statement.executeUpdate();
			if (rows == 1) {
				// deleted
				return true;
			} else {
				// not deleted
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public PatientDTO savePesonel(PatientDTO patient) {
		Connection connection = DBConnection.getConnection();

		if (patient.getPatientId() == null) {
			PreparedStatement statement;
			patient.setPatientId(getNewId());
			patient.setPatientNo(patientNumber(patient));
			
			try {
				String SQL = "INSERT INTO patient(tcno,name,surname) " + "VALUES(?,?,?)";
				statement = connection.prepareStatement(SQL);
				statement.setString(1, patient.getTc());
				statement.setString(2, patient.getName());
				statement.setString(3, patient.getSurname());
				statement.addBatch();
				statement.execute();
				
				//String patientNo = getPatientNo(patient.getPatientId());
				return patient;
			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			patient = updatePatient(patient);
			return patient;
		}

		return null;
	}

	public boolean isTCExist(PatientDTO patientDTO) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select tcno from patient where tcno=?");
			statement.setString(1, patientDTO.getTc());
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				JFrame f;
				f = new JFrame();
				JOptionPane.showMessageDialog(f, "Bu kimlik numarasý ile sistemde kayýtlý hasta var!", "Uyarý",
						JOptionPane.WARNING_MESSAGE);
				return true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	public String patientNumber (PatientDTO patient) {
		//Connection connection = DBConnection.getConnection();		
		//try {
			//Statement stmt = connection.createStatement();
			//ResultSet rs = stmt.executeQuery("select patientno from patient where patientno=?");
			//patient.setPatientId(rs.getString(1));			
	//	}catch(SQLException e1) {
		//	e1.printStackTrace();
		//}
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("SELECT patientnumber FROM patientno ORDER BY patientnumber DESC LIMIT 1");
//			statement = connection.prepareStatement("SELECT LAST_INSERT_ID()");
//			statement.setString(1, patient.getPatientNo());
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	

	public PatientDTO updatePatient(PatientDTO patient) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		try {
			String sqlUpdate = "UPDATE patient SET tcno=?, name =? ,surname =? ,username=?" + "WHERE patientid =?";
			System.out.println(sqlUpdate);
			PreparedStatement statement = connection.prepareStatement(sqlUpdate);
			statement.setString(1, patient.getTc());
			statement.setString(2, patient.getName());
			statement.setString(3, patient.getSurname());
			statement.setString(4, patient.getPatientId());
			statement.setString(5, patient.getUsername());

			statement.executeUpdate();
			return patient;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
