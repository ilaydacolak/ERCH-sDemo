package com.erc.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.DBConnection;
import com.erc.entities.PatientDTO;
import com.erc.entities.PersonnelDTO;
import com.erc.dbconnection.HibernateConnection;

public class PersonelService {
	
	private PersonnelDTO personel;
	
	public ArrayList<PersonnelDTO> getAllPersonels() {		
		Transaction transaction = null;		
		 try (Session session = HibernateConnection.getSessionFactory().openSession()) {
	            ArrayList < PersonnelDTO > personel = new ArrayList<PersonnelDTO>();
	            personel = (ArrayList<PersonnelDTO>) session.createQuery("from PersonnelDTO", PersonnelDTO.class).list();
	            for(PersonnelDTO  personels : personel) {
	            	System.out.println(personels.getName());
	            	System.out.println(personels.getLastname());
	            	System.out.println(personels.getIdentificationno());       	
	            }
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
		if(personel.getPersonid()== null) {
			personel.setPersonid(getNewId());
			
			session.save(personel);	
			session.getTransaction().commit();
			return personel;		
		}else {
			return personel;
		}
	}	
	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public PersonnelDTO updatePatient(PersonnelDTO personel) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(personel);
		session.getTransaction().commit();
	
		return personel;
	}
	
	
	
}




