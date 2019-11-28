package mynetflix.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mynetflix.modele.Plateforme;

public class PlateformeDao extends ConnectionDAO {
	
	public PlateformeDao() {
		super();
	}
	
	public List<Plateforme> selectPlateforme(){
		try(Connection c = getConnection(); Statement stmt = c.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, libelle FROM plateforme");
			List<Plateforme> pltfrm = new ArrayList<Plateforme>();
			while (rs.next()) {
				pltfrm.add(new Plateforme(rs.getInt("id"), rs.getString("libelle"),rs.getString("fqdn"),rs.getInt("idpays")));
			}
			return pltfrm;
		} catch (SQLException e) {
			throw new ErreurDAOException("");
		}
	}

}
