package mynetflix.modele;

public class Format {
	
	private int id;
	private String libelle;
	private String description;
	private int idTypeFormat;
	
	public Format(int id, String libelle, String descriptionString, int idTypeFormat) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = descriptionString;
		this.idTypeFormat = idTypeFormat;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getDescription() {
		return description;
	}

	public int getIdTypeFormat() {
		return idTypeFormat;
	}
	
	

}
