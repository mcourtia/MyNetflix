package mynetflix.modele;

public class Participer {
	
	private int id;
	private int idPersonne;
	private int idEpisode;
	private int idFonction;
	private String roleAlias;
	
	public Participer(int id, int idPersonne, int idEpisode, int idFonction, String roleAlias) {
		super();
		this.id = id;
		this.idPersonne = idPersonne;
		this.idEpisode = idEpisode;
		this.idFonction = idFonction;
		this.roleAlias = roleAlias;
	}

	public int getId() {
		return id;
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public int getIdEpisode() {
		return idEpisode;
	}

	public int getIdFonction() {
		return idFonction;
	}

	public String getRoleAlias() {
		return roleAlias;
	}
	
	
	
	
}
