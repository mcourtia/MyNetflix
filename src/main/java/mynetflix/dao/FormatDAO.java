package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Format;

public class FormatDAO extends ConnectionDAO{
	
	public FormatDAO() {
		super();
	}
	
	public List<Format> selectFormat(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle, description, idtypeformat FROM format");
			List<Format> frt = new ArrayList<Format>();
			while (rs.next()) {
				frt.add(new Format(rs.getInt("id"), rs.getString("libelle"),rs.getString("description"),rs.getInt("idtypeformat")));
			}
			return frt;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}

}
