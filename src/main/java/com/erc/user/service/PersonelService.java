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
	         
	          //  personel.forEach(s - > System.out.println(s.getFirstName()));
	            for(PersonnelDTO  personels : personel) {
	            	System.out.println(personels.getName());
           	
	            }
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		
		
		
		return null;
	}
}




