package com.erc.user.service;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.erc.dbconnection.DBConnection;
import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;

public class PatientService {
	private PatientDTO patient;

	public ArrayList<PatientDTO> getAllPatients() {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			ArrayList<PatientDTO> patient = new ArrayList<PatientDTO>();
			patient = (ArrayList<PatientDTO>) session.createQuery("from PatientDTO", PatientDTO.class).list();

			return patient;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public PatientDTO savePatient(PatientDTO patient) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		if (patient.getPatientId() == null) {
			patient.setPatientId(getNewId());
			session.save(patient);
			session.getTransaction().commit();
			return patient;

		} else {
			patient = updatePatient(patient);
			return patient;
		}

	}	

	public boolean deletePatient(PatientDTO patient) {
	// TODO Auto-generated method stub
//		Connection connection = DBConnection.getConnection();
//		try {
//			String sqlDelete = "delete from patient where patientid=?";
//			System.out.println(sqlDelete);
//			PreparedStatement statement = connection.prepareStatement(sqlDelete);
//			statement.setString(1, patient.getPatientId());
//			int rows = statement.executeUpdate();
//			if (rows == 1) {
//				// deleted
//				return true;
//			} else {
//				// not deleted
//				return false;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return false;
		if(patient != null) {
			try (Session session = HibernateConnection.getSessionFactory().openSession()){
				session.beginTransaction();
				session.remove(patient);
				session.getTransaction().commit();	
				return true;
			}catch (Exception e) {
	        e.printStackTrace();
		    }	
			}
			return false;

	}

	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

//	public boolean isTCExist(PatientDTO patient) {
////		Connection connection = DBConnection.getConnection();
////		PreparedStatement statement = null;
////		try {
////			statement = connection.prepareStatement("select tcno from patient where tcno=?");
////			statement.setString(1, patientDTO.getTc());
////			ResultSet rs = statement.executeQuery();
////			if (rs.next()) {
////				JFrame f;
////				f = new JFrame();
////				JOptionPane.showMessageDialog(f, "Bu kimlik numarasý ile sistemde kayýtlý hasta var!", "Uyarý",
////						JOptionPane.WARNING_MESSAGE);
////				return true;
////			}
////		} catch (SQLException e1) {
////			e1.printStackTrace();
////		}
////		return false;
//		Session session = HibernateConnection.getSessionFactory().openSession();
//		session.beginTransaction();
//	    Query query = session.createQuery("SELECT tc FROM PatientDTO");
//	    
//		if(query.equals(patient.getTc())) {
//			JFrame f;
//		f = new JFrame();
//			JOptionPane.showMessageDialog(f, "Bu kimlik numarasý ile sistemde kayýtlý hasta var!", "Uyarý",
//					JOptionPane.WARNING_MESSAGE);
//			return true;
//		}else {
//			return false;
//		}
//	}

	public PatientDTO updatePatient(PatientDTO patient) {
		// TODO Auto-generated method stub
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(patient);
			session.getTransaction().commit();
			return patient;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
