package mynetflix.modele;

public class Pays {
	
	private int id;
	private String nom;
	private String code;
	
	public Pays(int id, String nom, String code) {
		this.id = id;
		this.nom = nom;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getCode() {
		return code;
	}
	
	

}
