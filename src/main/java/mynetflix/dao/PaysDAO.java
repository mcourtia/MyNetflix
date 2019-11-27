package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Pays;

public class PaysDAO extends ConnectionDAO {
	
	public PaysDAO() {
		super();
	}
	
	public List<Pays> selectPays() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, nom, code FROM pays");
			List<Pays> pays = new ArrayList<Pays>();
			while (rs.next()) {
				pays.add(new Pays(rs.getInt("id"), rs.getString("nom"), rs.getString("code")));
			}
			return pays;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
