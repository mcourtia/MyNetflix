package mynetflix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Episode;

public class EpisodeDAO extends ConnectionDAO {
	
	public EpisodeDAO() {
		super();
	}
	
	public void insertEpisode(Episode ep) {
		String request = "INSERT INTO episode(numero, titre, titreoriginal, duree, resume, daterealisation, date_premiere_diffusion, idpublic, idstatut, idsaison) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection c = getConnection(); PreparedStatement pstmt = c.prepareStatement(request)) {
			pstmt.setInt(1, ep.getNumero());
			pstmt.setString(2, ep.getTitre());
			pstmt.setString(3, ep.getTitreoriginal());
			if (ep.getDuree() == 0) {
				pstmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				pstmt.setInt(4, ep.getDuree());
			}
			pstmt.setString(5, ep.getResume());
			pstmt.setString(6, ep.getDateReal());
			pstmt.setString(7, ep.getDateDiff());
			pstmt.setInt(8, ep.getIdpublicAge());
			pstmt.setInt(9, ep.getIdstatut());
			pstmt.setInt(10, ep.getIdsaison());

			pstmt.executeUpdate();
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
	
	public List<Episode> selectEpisode() {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, numero FROM episode");
			List<Episode> episode = new ArrayList<Episode>();
			while (rs.next()) {
				episode.add(new Episode(rs.getInt("id"), rs.getInt("numero")));
			}
			return episode;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
	
	public List<Episode> selectEpisode(int idsaison) {
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, numero FROM episode WHERE idsaison=" + idsaison);
			List<Episode> episode = new ArrayList<Episode>();
			while (rs.next()) {
				episode.add(new Episode(rs.getInt("id"), rs.getInt("numero")));
			}
			return episode;
		} catch(SQLException e) {
			throw new ErreurDAOException("");
		}
	}
}