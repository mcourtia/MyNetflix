package mynetflix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class RequestCivilite {
	
	public static Map<Integer, String> getCivilites() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:8889/myNetflix", "root", "root")) {
			try(Statement stmt = c.createStatement()) {
				ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM civilite");
				Map<Integer, String> civ = new HashMap<>();
				while (rs.next()) {
					civ.put(rs.getInt("id"), rs.getString("libelle"));
				}
				return civ;
			}
		}
	}
}
