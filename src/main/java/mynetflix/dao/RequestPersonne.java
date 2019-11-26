package mynetflix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestPersonne {
	
	public static void setPersonne(String nom, String prenom, int idcivilite) throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:8889/myNetflix", "root", "root")) {
			try(Statement stmt = c.createStatement()) {
				stmt.executeUpdate("INSERT INTO personne(nom, prenom, idcivilite) VALUES ('" + nom + "', '" + prenom + "', " + idcivilite + ")");
			}
		}
	}
}
