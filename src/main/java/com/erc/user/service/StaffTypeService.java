package com.erc.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.StaffDTO;
import com.erc.entities.StaffTypeDTO;

public class StaffTypeService {
	private StaffTypeDTO staffType;

	
	public ArrayList<StaffTypeDTO> getAllStaffTypes() {		
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

	public StaffTypeDTO saveStaffType(StaffTypeDTO staffType) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		
		if(staffType.getStaffTypeID()== null) {
			staffType.setStaffTypeID(getNewId());	
//			StaffDTO staff = new StaffDTO();
//			staff.setStaffTypeDTO(staffType);
			session.save(staffType);	
			session.getTransaction().commit();
			session.persist(staffType);
		
			return staffType;		
		}else {
			staffType = updateStaffType(staffType);
			return staffType;
		}
		
	}	
	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public StaffTypeDTO updateStaffType(StaffTypeDTO staffType) {
		//Session session = HibernateConnection.getSessionFactory().openSession();
		
		try (Session session = HibernateConnection.getSessionFactory().openSession()){
			session.beginTransaction();
			session.update(staffType);
			session.getTransaction().commit();	
	
			return staffType;
		}catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	public boolean deleteStaffType (StaffTypeDTO staffType) {
		if(staffType != null) {
		try (Session session = HibernateConnection.getSessionFactory().openSession()){
			session.beginTransaction();
			session.remove(staffType);
			session.getTransaction().commit();	
		
			return true;
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
		}
		return false;
	}
}
