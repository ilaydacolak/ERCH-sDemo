package com.erc.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.MedicalOrderDTO;
import com.erc.entities.StaffDTO;


public class MedicalOrderService {
	private static final ArrayList<MedicalOrderDTO> medicalOrderDTO = null;
	private MedicalOrderDTO medicalOrder;

	public ArrayList<MedicalOrderDTO> gelMedicalOrderList() {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			ArrayList<MedicalOrderDTO> medicalOrderList = new ArrayList<MedicalOrderDTO>();
			
			medicalOrderList = (ArrayList<MedicalOrderDTO>) session.createQuery("from MedicalOrderDTO", MedicalOrderDTO.class).list();
			
			return medicalOrderList;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}
	public MedicalOrderDTO saveMedicalOrder(MedicalOrderDTO medicalOrderDTO) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		
		if (medicalOrderDTO.getMedicalOrderID() == null) {
			medicalOrderDTO.setMedicalOrderID(getNewId());
			session.save(medicalOrderDTO);
			session.getTransaction().commit();
			session.persist(medicalOrderDTO);
			
			return medicalOrderDTO;
		} else {
			medicalOrderDTO = updateMedicalOrder(medicalOrderDTO);
			return medicalOrderDTO;
		}

	}
	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public MedicalOrderDTO updateMedicalOrder(MedicalOrderDTO medicalOrderDTO) {
		// Session session = HibernateConnection.getSessionFactory().openSession();

		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(medicalOrderDTO);
			session.getTransaction().commit();
			return medicalOrderDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
