package mynetflix.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mynetflix.modele.Serie;

public class SerieDAO extends ConnectionDAO {
	
	public SerieDAO() {
		super();
	}
	
	public void insertSerie(Serie serie) {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			stmt.executeUpdate("INSERT INTO serie(nom, nomoriginal, anneeparution, synopsys, idstatut, idpaysorigine)" +
			"VALUES ('" + serie.getNom() + "', '" + serie.getNomoriginal() + "', " + serie.getAnneeparution() + ", '" + serie.getSynopsys() + "', " + serie.getIdstatut() + ", " + serie.getIdpaysorigine() + ")");
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
	
	public List<Serie> selectSeries() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, nom FROM serie");
			List<Serie> series = new ArrayList<Serie>();
			while (rs.next()) {
				series.add(new Serie(rs.getInt("id"), rs.getString("nom")));
			}
			return series;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
