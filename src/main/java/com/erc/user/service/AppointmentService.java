package com.erc.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.AdmissionDTO;
import com.erc.entities.AppointmentDTO;

public class AppointmentService {
	private AppointmentDTO appointmentDTO;

	public ArrayList<AppointmentDTO> getAllAppointmentList() {
		Transaction transaction = null;
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			ArrayList<AppointmentDTO> appointmentList = new ArrayList<AppointmentDTO>();

			appointmentList = (ArrayList<AppointmentDTO>) session
					.createQuery("from AppointmentDTO", AppointmentDTO.class).list();

			return appointmentList;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return null;
	}

	public AppointmentDTO saveAppointment(AppointmentDTO appointment) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		if(appointment.getAppointmentID()==null) {
			appointment.setAppointmentID(getNewId());
		}	
		session.save(appointment);
		session.getTransaction().commit();
		session.persist(appointment);
		return appointment;

	}

	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}
