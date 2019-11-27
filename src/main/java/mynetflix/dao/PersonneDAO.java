package mynetflix.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import mynetflix.modele.Personne;

public class PersonneDAO extends ConnectionDAO {
	
	public PersonneDAO() {
		super ();
	}
	
	public void insertPersonne(Personne p) {
		
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			stmt.executeUpdate("INSERT INTO personne(nom, prenom, idcivilite) VALUES ('" + p.getNom() + "', '" + p.getPrenom() + "', " + p.getIdcivilite() + ")");
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
