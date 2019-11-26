package mynetflix.modele;

import java.sql.SQLException;
import java.util.Map;

import mynetflix.dao.RequestStatut;

public class Statut {

	private Map<Integer, String> status;
	
	public Statut() throws SQLException {
		this.status = RequestStatut.getStatuts();
	}
	
	public Map<Integer, String> getStatuts() {
		return this.status;
	}
}
