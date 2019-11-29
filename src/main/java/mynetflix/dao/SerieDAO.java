package mynetflix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Serie;

public class SerieDAO extends ConnectionDAO {
	
	public SerieDAO() {
		super();
	}
	
	public void insertSerie(Serie serie) {
		String request = "INSERT INTO serie(nom, nomoriginal, anneeparution, synopsys, idstatut, idpaysorigine) VALUES (?, ?, ?, ?, ?, ?)";

		try(Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(request)) {
			pstmt.setString(1, serie.getNom());
			pstmt.setString(2, serie.getNomoriginal());
			pstmt.setInt(3, serie.getAnneeparution());
			pstmt.setString(4, serie.getSynopsys());
			pstmt.setInt(5, serie.getIdstatut());
			pstmt.setInt(6, serie.getIdpaysorigine());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
	
	public List<Serie> selectSerie() {
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
	
	public Serie selectSerie(int idserie) {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, nom FROM serie WHERE id=" + idserie);
			Serie serie = null; 
			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), rs.getString("nom"));
			}
			return serie;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
