package mynetflix.modele;

public class Trailer {
	
	private int id;
	private int idEpisode;
	private int idPlateforme;
	private String url;
	
	public Trailer(int id, int idEpisode, int idPlateforme, String url) {
		super();
		this.id = id;
		this.idEpisode = idEpisode;
		this.idPlateforme = idPlateforme;
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

	public String getUrl() {
		return url;
	}
	
	
	

}
