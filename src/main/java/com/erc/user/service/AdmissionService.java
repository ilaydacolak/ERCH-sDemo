package com.erc.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.AdmissionDTO;
import com.erc.entities.StaffDTO;
import com.erc.entities.StaffTypeDTO;

public class AdmissionService {
	private AdmissionDTO admissionDTO;

	public ArrayList<AdmissionDTO> getAllAdmissionPatients() {
		Transaction transaction = null;
		
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			ArrayList<AdmissionDTO> admissionList = new ArrayList<AdmissionDTO>();

			admissionList = (ArrayList<AdmissionDTO>) session.createQuery("from AdmissionDTO", AdmissionDTO.class)
					.list();

			return admissionList;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public AdmissionDTO saveAdmission(AdmissionDTO admission) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
//		if (admission.getAdmissionID()== 0) {
			admission.setAdmissionID(getNewId());
			session.save(admission);
			session.getTransaction().commit();
			session.persist(admission);
			return admission;
//		}else {
//			admission = updateAdmission(admission);
//			return admission;
//		}
	}

	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
//	public AdmissionDTO updateAdmission(AdmissionDTO admission) {
//		// Session session = HibernateConnection.getSessionFactory().openSession();
//
//		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
//			session.beginTransaction();
//			session.update(admission);
//			session.getTransaction().commit();
//			return admission;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
