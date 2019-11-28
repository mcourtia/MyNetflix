package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Genre;

public class GenreDAO extends ConnectionDAO {
	
	public GenreDAO() {
		super();
	}
	
	public List<Genre> selectGenre(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM genre");
			List<Genre> gr = new ArrayList<Genre>();
			while (rs.next()) {
				gr.add(new Genre(rs.getInt("id"), rs.getString("libelle")));
			}
			return gr;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}

}
