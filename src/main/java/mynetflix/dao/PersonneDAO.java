package mynetflix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mynetflix.modele.Personne;

public class PersonneDAO extends ConnectionDAO {
	
	public PersonneDAO() {
		super ();
	}
	
	public void insertPersonne(Personne p) {
		String request = "INSERT INTO personne(nom, prenom, idcivilite) VALUES (?, ?, ?)";
		
		try(Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(request)) {
			pstmt.setString(1, p.getNom());
			pstmt.setString(2, p.getPrenom());
			pstmt.setInt(3, p.getIdcivilite());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}
