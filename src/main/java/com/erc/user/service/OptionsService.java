package com.erc.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.OptionsDTO;


public class OptionsService {
	private OptionsDTO options;

	public ArrayList<OptionsDTO> getAllOptions() {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			ArrayList<OptionsDTO> options = new ArrayList<OptionsDTO>();
			options = (ArrayList<OptionsDTO>) session.createQuery("from OptionsDTO", OptionsDTO.class).list();
			
			return options;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}
	public OptionsDTO saveOptions(OptionsDTO options) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		if(options.getoptionsID()== null) {
			options.setoptionsID(getNewId());			
			session.save(options);	
			session.getTransaction().commit();
			return options;		
		}else {
			options = updateOptions(options);
			return options;
		}
		
	}	
	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public OptionsDTO updateOptions(OptionsDTO options) {
		//Session session = HibernateConnection.getSessionFactory().openSession();
		
		try (Session session = HibernateConnection.getSessionFactory().openSession()){
			session.beginTransaction();
			session.update(options);
			session.getTransaction().commit();	
			return options;
		}catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	public boolean deleteOptions (OptionsDTO option) {
		if(option != null) {
		try (Session session = HibernateConnection.getSessionFactory().openSession()){
			session.beginTransaction();
			session.remove(option);
			session.getTransaction().commit();	
			return true;
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
		}
		return false;
	}
	
}
