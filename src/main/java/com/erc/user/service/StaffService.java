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
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.erc.dbconnection.DBConnection;
import com.erc.entities.PatientDTO;
import com.erc.entities.StaffDTO;

import com.erc.dbconnection.HibernateConnection;


import com.erc.entities.StaffTypeDTO;
import com.fasterxml.classmate.AnnotationConfiguration;
import com.erc.dbconnection.HibernateConnection;

public class StaffService {


	private StaffDTO staff;

	public ArrayList<StaffDTO> getAllStaff() {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			ArrayList<StaffDTO> staffList = new ArrayList<StaffDTO>();
			
			staffList = (ArrayList<StaffDTO>) session.createQuery("from StaffDTO", StaffDTO.class).list();
			
			return staffList;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}


	
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

	public StaffDTO saveStaff(StaffDTO staff) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		
		if (staff.getPersonid() == null) {
			staff.setPersonid(getNewId());
			session.save(staff);
			session.getTransaction().commit();
			session.persist(staff);
			
			return staff;
		} else {
			staff = updatePersonel(staff);
			return staff;
		}

	}

	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public StaffDTO updatePersonel(StaffDTO staff) {
		// Session session = HibernateConnection.getSessionFactory().openSession();

		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(staff);
			session.getTransaction().commit();
			return staff;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deletePersonel(StaffDTO staff) {
		if (staff != null) {
			try (Session session = HibernateConnection.getSessionFactory().openSession()) {
				session.beginTransaction();
				session.remove(staff);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
