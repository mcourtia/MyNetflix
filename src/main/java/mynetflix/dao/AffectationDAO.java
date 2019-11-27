package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Affectation;

public class AffectationDAO extends ConnectionDAO {
	
	public AffectationDAO() {
		super();
	}
	
	public List<Affectation> selectAffectation() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM affectation");
			List<Affectation> a = new ArrayList<Affectation>();
			while(rs.next()) {
				a.add(new Affectation(rs.getInt("id"), rs.getString("libelle")));
			}
			return a;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
	
	public int selectIdAffectation(String libelle) {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id FROM affectation WHERE libelle='" + libelle + "'");
			int id = 0;
			while(rs.next()) {
				id = rs.getInt("id");
			}
			return id;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
