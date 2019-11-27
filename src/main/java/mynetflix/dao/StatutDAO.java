package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Statut;

public class StatutDAO extends ConnectionDAO {
	
	public StatutDAO() {
		super();
	}
	
	public List<Statut> selectStatut() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle, idaffectation FROM statut");
			List<Statut> statut = new ArrayList<Statut>();
			while (rs.next()) {
				statut.add(new Statut(rs.getInt("id"), rs.getString("libelle"), rs.getInt("idaffectation")));
			}
			return statut;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
	
	public List<Statut> selectStatut(int idaffectation) {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM statut WHERE idaffectation=" + idaffectation);
			List<Statut> statut = new ArrayList<Statut>();
			while (rs.next()) {
				statut.add(new Statut(rs.getInt("id"), rs.getString("libelle"), idaffectation));
			}
			return statut;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
