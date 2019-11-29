package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Streamer;

public class StreamerDAO extends ConnectionDAO{
	
	public StreamerDAO() {
		super();
	}
	
	public List<Streamer> selectStreamer(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, idepisode, idplateforme, idqualite, url FROM streamer");
			List<Streamer> trl = new ArrayList<Streamer>();
			while (rs.next()) {
				trl.add(new Streamer(rs.getInt("id"), rs.getInt("idepisode"), rs.getInt("idplateforme"), rs.getInt("idqualite"), rs.getString("url")));
			}
			return trl;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}

}
