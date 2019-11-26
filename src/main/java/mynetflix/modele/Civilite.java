package mynetflix.modele;

import java.sql.SQLException;
import java.util.Map;

import mynetflix.dao.RequestCivilite;

public class Civilite {

	private Map<Integer, String> civilites;
	
	public Civilite() throws SQLException {
		this.civilites = RequestCivilite.getCivilites();
	}
	
	public Map<Integer, String> getCivilites() {
		return this.civilites;
	}
}
