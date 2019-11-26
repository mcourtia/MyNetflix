package mynetflix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class RequestStatut {
	
	public static Map<Integer, String> getStatuts() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:8889/myNetflix", "root", "root")) {
			try(Statement stmt = c.createStatement()) {
				ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM statut WHERE idaffectation=3");
				Map<Integer, String> statut = new HashMap<>();
				while (rs.next()) {
					statut.put(rs.getInt("id"), rs.getString("libelle"));
				}
				return statut;
			}
		}
	}
}
