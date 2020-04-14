package com.erc.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.OrganizationDTO;


public class OptionsService {
	private OrganizationDTO options;

	public ArrayList<OrganizationDTO> getAllOptions() {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			ArrayList<OrganizationDTO> options = new ArrayList<OrganizationDTO>();
			options = (ArrayList<OrganizationDTO>) session.createQuery("from OrganizationDTO", OrganizationDTO.class).list();
			
			return options;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}
	public OrganizationDTO saveOptions(OrganizationDTO options) {
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
	public OrganizationDTO updateOptions(OrganizationDTO options) {
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
	
	public boolean deleteOptions (OrganizationDTO option) {
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
