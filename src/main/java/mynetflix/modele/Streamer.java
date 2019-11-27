package mynetflix.modele;

public class Streamer {
	
	private int id;
	private int idEpisode;
	private int idPlateforme;
	private int idQualite;
	private String url;
	
	
	public Streamer(int id, int idEpisode, int idPlateforme, int idQualite, String url) {
		
		this.id = id;
		this.idEpisode = idEpisode;
		this.idPlateforme = idPlateforme;
		this.idQualite = idQualite;
		this.url = url;
	}


	public int getId() {
		return id;
	}


	public int getIdEpisode() {
		return idEpisode;
	}


	public int getIdPlateforme() {
		return idPlateforme;
	}


	public int getIdQualite() {
		return idQualite;
	}


	public String getUrl() {
		return url;
	}
	
	

}
