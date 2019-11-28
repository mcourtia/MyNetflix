package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.TypeFormat;

public class TypeformatDAO extends ConnectionDAO {
	
	public TypeformatDAO() {
		super();
	}
	
	public List<TypeFormat> selectTypeFormat(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM typeformat");
			List<TypeFormat> tfmt = new ArrayList<TypeFormat>();
			while (rs.next()) {
				tfmt.add(new TypeFormat(rs.getInt("id"), rs.getString("libelle")));
			}
			return tfmt;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
