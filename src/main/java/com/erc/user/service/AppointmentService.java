package com.erc.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erc.dbconnection.HibernateConnection;
import com.erc.entities.AdmissionDTO;
import com.erc.entities.AppointmentDTO;
import com.erc.entities.StaffDTO;

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
		if(appointment.getAppointmentID() == null) {
			appointment.setAppointmentID(getNewId());
			session.save(appointment);
			session.getTransaction().commit();
			session.persist(appointment);
			return appointment;

		}else {
			appointment = updateAppointment(appointment);
			return appointment;
		}		
	}
	private AppointmentDTO updateAppointment(AppointmentDTO appointment) {
		// TODO Auto-generated method stub
		try (Session session = HibernateConnection.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(appointment);
			session.getTransaction().commit();
			return appointment;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public boolean deleteAppointment(AppointmentDTO appointment) {
		if (appointment != null) {
			try (Session session = HibernateConnection.getSessionFactory().openSession()) {
				session.beginTransaction();
				session.remove(appointment);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	

}
