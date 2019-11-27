package mynetflix.modele;

public class plateforme {
	
	private int id;
	private String libelle;
	private String fqdn;
	private int idPays;
	
	public plateforme(int id, String libelle, String fqdn, int idPays) {
		super();
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
