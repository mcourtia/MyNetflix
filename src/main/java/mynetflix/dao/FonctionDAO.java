package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Fonction;

public class FonctionDAO extends ConnectionDAO{

	public FonctionDAO() {
		super();
	}
	
	public List<Fonction> selectFonction(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM fonction");
			List<Fonction> fct = new ArrayList<Fonction>();
			while (rs.next()) {
				fct.add(new Fonction(rs.getInt("id"), rs.getString("libelle")));
			}
			return fct;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
