package mynetflix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class RequestSerie {
	
	public static void setSerie(String nom, String nomoriginal, int anneeparution, String synopsys, int idstatut, int idpaysorigine) throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:8889/myNetflix", "root", "root")) {
			try(Statement stmt = c.createStatement()) {
				stmt.executeUpdate("INSERT INTO serie(nom, nomoriginal, anneeparution, synopsys, idstatut, idpaysorigine)" +
									"VALUES ('" + nom + "', '" + nomoriginal + "', " + anneeparution + ", '" + synopsys + "', " + idstatut + ", " + idpaysorigine + ")");
			}
		}
	}
	
	public static Map<Integer, String> getSeries() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:8889/myNetflix", "root", "root")) {
			try(Statement stmt = c.createStatement()) {
				ResultSet rs = stmt.executeQuery("SELECT id, nom FROM serie");
				Map<Integer, String> series = new HashMap<>();
				while (rs.next()) {
					series.put(rs.getInt("id"), rs.getString("nom"));
				}
				return series;
			}
		}
	}
}
