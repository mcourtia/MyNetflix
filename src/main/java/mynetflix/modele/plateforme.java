package mynetflix.modele;

public class Plateforme {
	
	private int id;
	private String libelle;
	private String fqdn;
	private int idPays;
	
	public Plateforme(int id, String libelle, String fqdn, int idPays) {
		this.id = id;
		this.libelle = libelle;
		this.fqdn = fqdn;
		this.idPays = idPays;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getFqdn() {
		return fqdn;
	}

	public int getIdPays() {
		return idPays;
	}
	
	
	

}
