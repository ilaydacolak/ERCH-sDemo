package com.erc.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import com.erc.dbconnection.DBConnection;
import com.erc.entities.PersonnelDTO;

public class PersonelService {
	
	private PersonnelDTO personel;

	public ArrayList<PersonnelDTO> getAllPersonels() {

		Connection connection = DBConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from personel");

			ArrayList<PersonnelDTO> personelList = new ArrayList<PersonnelDTO>();
			while (rs.next()) {
				System.out
						.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(6));

				PersonnelDTO personel = new PersonnelDTO();
				personel.setPersonid(rs.getString(1));
				personel.setIdentificationno(rs.getString(2));
				personel.setName(rs.getString(3));
				personel.setLastname(rs.getString(4));
				personel.setUsername(rs.getString(6));

				personelList.add(personel);
				
			}

			return personelList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public PersonnelDTO savePesonel(PersonnelDTO personel) {

		Connection connection = DBConnection.getConnection();
		
		
		if(personel.getPersonid()==null) {
			
			//username 
			//tc kontrolü

			personel.setPersonid(getNewId());
			
			try {
				String SQL = "INSERT INTO personel(personelid, tcno,name,surname,username) " + "VALUES(?,?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(SQL);
				statement.setString(1, personel.getPersonid());
				statement.setString(2, personel.getIdentificationno());
				statement.setString(3, personel.getName());
				statement.setString(4, personel.getLastname());
				statement.setString(5, personel.getUsername());
				
				statement.addBatch();
				statement.execute();
				return personel;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			personel = updatePersonel(personel);
			return personel;
		}
		
		return null;
	}

	public String getNewId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public PersonnelDTO updatePersonel(PersonnelDTO personel) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		try {
			String sqlUpdate = "UPDATE personel SET tcno=?, name =? ,surname =? ,username=?"
					+ "WHERE personelid =?";
			System.out.println(sqlUpdate);
			PreparedStatement statement = connection.prepareStatement(sqlUpdate);
			statement.setString(1, personel.getIdentificationno());
			statement.setString(2, personel.getName());
			statement.setString(3, personel.getLastname());
			statement.setString(4, personel.getPersonid());
			statement.setString(5, personel.getUsername());
			 
			statement.executeUpdate();
			return personel;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean deletePersonel(PersonnelDTO personel) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		try {
			String sqlDelete = "delete from personel where personelid=?";
			System.out.println(sqlDelete);
			PreparedStatement statement = connection.prepareStatement(sqlDelete);
			statement.setString(1, personel.getPersonid());
			int rows = statement.executeUpdate();
			if (rows == 1) {
				// deleted
				return true;
			} else {
				// not deleted
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}
