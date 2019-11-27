package mynetflix.modele;

public class Statut {
	
	private int id;
	private String libelle;
	private int idaffectation;
	
	public Statut(int id, String libelle, int idaffectation) {
		this.id = id;
		this.libelle = libelle;
		this.idaffectation = idaffectation;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public int getIdaffectation() {
		return idaffectation;
	}
}
