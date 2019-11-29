package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.PublicAge;

public class PublicDAO extends ConnectionDAO {

	public PublicDAO() {
		super();
	}
	
	public List<PublicAge> selectPublic(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle, limiteage FROM public");
			List<PublicAge> publicAge = new ArrayList<PublicAge>();
			while (rs.next()) {
				publicAge.add(new PublicAge(rs.getInt("id"), rs.getString("libelle"),rs.getInt("limiteage")));
			}
			return publicAge;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
