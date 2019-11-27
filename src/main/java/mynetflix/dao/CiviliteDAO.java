package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Civilite;

public class CiviliteDAO extends ConnectionDAO {
	
	public CiviliteDAO() {
		super();
	}
	
	public List<Civilite> selectCivilite() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle, abbr FROM civilite");
			List<Civilite> civ = new ArrayList<Civilite>();
			while (rs.next()) {
				civ.add(new Civilite(rs.getInt("id"), rs.getString("libelle"), rs.getString("abbr")));
			}
			return civ;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
