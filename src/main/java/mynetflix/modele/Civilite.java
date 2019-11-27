package mynetflix.modele;

public class Civilite {

	private int id;
	private String libelle;
	private String abbr;
	
	public Civilite(int id, String libelle, String abbr) {
		this.id = id;
		this.libelle = libelle;
		this.abbr = abbr;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getAbbr() {
		return abbr;
	}
}
