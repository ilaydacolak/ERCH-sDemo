package com.erc.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.StaffTypeDTO;

public class StaffService {
	private StaffTypeDTO staff;
	
	public ArrayList<StaffTypeDTO> getAllStaffs() {		
		Transaction transaction = null;		
		 try (Session session = HibernateConnection.getSessionFactory().openSession()) {
	            ArrayList < StaffTypeDTO > personel = new ArrayList<StaffTypeDTO>();
	            personel = (ArrayList<StaffTypeDTO>) session.createQuery("from StaffTypeDTO", StaffTypeDTO.class).list();
	            return personel;            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return null;
	}

	public StaffTypeDTO saveStaff(StaffTypeDTO staff) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		
		if(staff.getStaffTypeID()== null) {
			staff.setStaffTypeID(getNewId());			
			session.save(staff);	
			session.getTransaction().commit();
			return staff;		
		}else {
			staff = updateStaff(staff);
			return staff;
		}
		
	}	
	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public StaffTypeDTO updateStaff(StaffTypeDTO staff) {
		//Session session = HibernateConnection.getSessionFactory().openSession();
		
		try (Session session = HibernateConnection.getSessionFactory().openSession()){
			session.beginTransaction();
			session.update(staff);
			session.getTransaction().commit();	
			return staff;
		}catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	public boolean deleteStaff (StaffTypeDTO staff) {
		if(staff != null) {
		try (Session session = HibernateConnection.getSessionFactory().openSession()){
			session.beginTransaction();
			session.remove(staff);
			session.getTransaction().commit();	
			return true;
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
		}
		return false;
	}
}
