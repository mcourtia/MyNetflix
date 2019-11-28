package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Langue;

public class LangueDAO extends ConnectionDAO {
	
	public LangueDAO() {
		super();
	}
	
	public List<Langue> selectLangue(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM langue");
			List<Langue> lg = new ArrayList<Langue>();
			while (rs.next()) {
				lg.add(new Langue(rs.getInt("id"), rs.getString("libelle")));
			}
			return lg;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}

}
