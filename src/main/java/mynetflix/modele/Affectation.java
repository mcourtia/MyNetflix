package mynetflix.modele;

public class Affectation {
	
	private int id;
	private String libelle;
	
	public Affectation(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}
	
}
