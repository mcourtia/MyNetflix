package mynetflix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Saison;

public class SaisonDAO extends ConnectionDAO {
	
	public SaisonDAO() {
		super();
	}
	
	public void insertSaison(Saison saison) {
		String request = "INSERT INTO saison(numero, resume, annee_diffusion, idstatut, idserie) VALUES (?, ?, ?, ?, ?)";
		
		try(Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(request)) {
			pstmt.setInt(1, saison.getNumero());
			pstmt.setString(2, saison.getResume());
			if (saison.getAnnee_diffusion() == 0) {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(3, saison.getAnnee_diffusion());
			}
			pstmt.setInt(4, saison.getIdstatut());
			pstmt.setInt(5, saison.getIdserie());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
	
	public List<Saison> selectSaison() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, numero FROM saison");
			List<Saison> saison = new ArrayList<Saison>();
			while (rs.next()) {
				saison.add(new Saison(rs.getInt("id"), rs.getInt("numero")));
			}
			return saison;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
	
	public List<Saison> selectSaison(int idserie) {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, numero FROM saison WHERE idserie =" + idserie);
			List<Saison> saison = new ArrayList<Saison>();
			while (rs.next()) {
				saison.add(new Saison(rs.getInt("id"), rs.getInt("numero")));
			}
			return saison;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}