package mynetflix.modele;

import java.sql.SQLException;

import mynetflix.modele.FormulaireInvalide;
import mynetflix.dao.RequestPersonne;

public class Personne {

	private String nom;
	private String prenom;
	private int idcivilite;

	public Personne(String nom, String prenom, String idcivilite) throws FormulaireInvalide {
		if (isBlank(nom)) {
			throw new FormulaireInvalide("Veuillez indiquer le nom !");
		}
		if (isBlank(prenom)) {
			throw new FormulaireInvalide("Veuillez indiquer le prénom !");
		}
		if (isBlank(idcivilite) || idcivilite.equals("0")) {
			throw new FormulaireInvalide("Veuillez choisir une civilité !");
		}
		this.nom = nom;
		this.prenom = prenom;
		this.idcivilite = Integer.valueOf(idcivilite);
	}
	
	private static boolean isBlank(String valeur) {
		return valeur == null || "".equals(valeur);
	}

	public void addPersonne() throws SQLException {
		RequestPersonne.setPersonne(this.nom, this.prenom, this.idcivilite);
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public int getIdcivilite() {
		return idcivilite;
	}

}
