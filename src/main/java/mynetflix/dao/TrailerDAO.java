package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Trailer;

public class TrailerDAO extends ConnectionDAO{
	
	public TrailerDAO() {
		super();
	}
	
	public List<Trailer> selectTrailer(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, idepisdoe, idplateforme, url FROM trailer");
			List<Trailer> trl = new ArrayList<Trailer>();
			while (rs.next()) {
				trl.add(new Trailer(rs.getInt("id"), rs.getInt("idepisode"), rs.getInt("idplateforme"), rs.getString("url")));
			}
			return trl;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}

}
