package com.erc.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.DBConnection;
import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;
import com.erc.entities.StaffTypeDTO;
import com.fasterxml.classmate.AnnotationConfiguration;
import com.erc.dbconnection.HibernateConnection;

public class PersonelService {

	private PersonnelDTO personel;
	private StaffTypeDTO staff;

	public ArrayList<PersonnelDTO> getAllPersonels() {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			ArrayList<PersonnelDTO> personel = new ArrayList<PersonnelDTO>();
			personel = (ArrayList<PersonnelDTO>) session.createQuery("from PersonnelDTO", PersonnelDTO.class).list();
			/*
			 * for(PersonnelDTO personels : personel) {
			 * System.out.println(personels.getName());
			 * System.out.println(personels.getLastname());
			 * System.out.println(personels.getIdentificationno());
			 * 
			 * }
			 */
			return personel;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public PersonnelDTO savePersonel(PersonnelDTO personel) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
//		identifier = sessionFactory.getClassMetadata.getIdentifier(object);
//        if (identifier == null)
//            return null;
		// List lstResult =
//		ArrayList < PersonnelDTO > personelTC = new ArrayList<PersonnelDTO>();
//		personelTC = (ArrayList<PersonnelDTO>)session.get("select tcno from PersonnelDTO", PersonnelDTO.class);
//		boolean result = alreadyExists(personel);

		if (personel.getPersonid() == null) {
			personel.setPersonid(getNewId());
			personel.setPersonelTypeNumber(staff);
//			personel.setPersonelTypeID(staff);
//			if (result == false) {

//			personel.setPersonelTypeNumber(staff);	
			
//			}else {
//				JFrame f; 
//				f=new JFrame(); 
//				JOptionPane.showMessageDialog(f,"Kullanýcý zaten kayýtlý","Alert",JOptionPane.WARNING_MESSAGE); 
//				return personel;
//			}
			session.save(personel);
			session.getTransaction().commit();
			session.persist(personel);
			
			return personel;
		} else {
			personel = updatePersonel(personel);
			return personel;
		}

	}

//	public boolean alreadyExists(PersonnelDTO personel) {
//		Session hibernateSession = HibernateConnection.getSessionFactory().getCurrentSession();
//		hibernateSession.beginTransaction();
//
//		if (hibernateSession.find(PersonnelDTO.class, "from PersonnelDTO")
//				.equals(personel.getIdentificationno())) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	 private UUID id;
//	public String getNewId() {
//		id = UUID.randomUUID();
//		return id;
//	}

	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public PersonnelDTO updatePersonel(PersonnelDTO personel) {
		// Session session = HibernateConnection.getSessionFactory().openSession();

		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(personel);
			session.getTransaction().commit();
			return personel;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deletePersonel(PersonnelDTO personel) {
		if (personel != null) {
			try (Session session = HibernateConnection.getSessionFactory().openSession()) {
				session.beginTransaction();
				session.remove(personel);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
