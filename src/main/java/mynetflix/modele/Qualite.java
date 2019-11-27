package mynetflix.modele;

public class Qualite {
	
	private int id;
	private String libelle;
	private int idFormatAudio;
	private int idFormatVideo;
	
	public Qualite(int id, String libelle, int idFormatAudio, int idFormatVideo) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.idFormatAudio = idFormatAudio;
		this.idFormatVideo = idFormatVideo;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public int getIdFormatAudio() {
		return idFormatAudio;
	}

	public int getIdFormatVideo() {
		return idFormatVideo;
	}
	
	
	

}
