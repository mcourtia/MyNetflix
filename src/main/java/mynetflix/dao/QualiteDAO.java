package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Qualite;

public class QualiteDAO extends ConnectionDAO {

	public QualiteDAO() {
		super();
	}
	
	public List<Qualite> selectQualite(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM qualite");
			List<Qualite> qlt = new ArrayList<Qualite>();
			while (rs.next()) {
				qlt.add(new Qualite(rs.getInt("id"), rs.getString("libelle"),rs.getInt("idformataudio"),rs.getInt("idformatvideo")));
			}
			return qlt;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
