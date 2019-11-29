package mynetflix.modele;

public class PublicAge {
	
	private int id;
	private String libelle;
	private int limiteage;
	
	public PublicAge(int id, String libelle, int limiteage) {
		this.id = id;
		this.libelle = libelle;
		this.limiteage = limiteage;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public int getLimiteage() {
		return limiteage;
	}
}
