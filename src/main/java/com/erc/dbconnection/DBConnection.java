package com.erc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection connection;

	public static Connection getConnection() {

		if (connection == null) {
			return connection = createConnection();
		}
		return connection;
	}

	private static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hastane?verifyServerCertificate=false&useSSL=true&requireSSL=true",
					"root", "ilayda");
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

}
}
