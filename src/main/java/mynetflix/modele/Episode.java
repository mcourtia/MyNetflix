package mynetflix.modele;

import java.util.Date;

public class Episode {
	
	private String serie;
	private String saison;
	private String titreEpisode;
	private String titreEpisodeOriginal;
	private int duree;
	private String resume;
	private Date dateReal;
	private Date dateDiff;
	private String publicLimiteAge; // impossible d'appeler juste "public" cette variable
	private String statut;
	
	public Episode(String serie, String saison, String titreEpisode, String titreEpisodeOriginal, int duree,
			String resume, Date dateReal, Date dateDiff, String publicLimiteAge, String statut) throws FormulaireInvalide {
		
		if (isBlank(serie)) {
			throw new FormulaireInvalide("Veuillez indiquer la série de l'épisode !");
		}
		if (isBlank(saison)) {
			throw new FormulaireInvalide("Veuillez indiquer la saison de l'épisode !");
		}
		if (isBlank(titreEpisode)) {
			throw new FormulaireInvalide("Veuillez indiquer le titre de votre épisode !");
		}
		if (isBlank(publicLimiteAge)) {
			throw new FormulaireInvalide("Veuillez indiquer la limite d'age de l'épisode de votre épisode !");
		}
		if (isBlank(statut)) {
			throw new FormulaireInvalide("Veuillez indiquer le statut de votre épisode !");
		}
		
		this.serie = serie;
		this.saison = saison;
		this.titreEpisode = titreEpisode;
		this.titreEpisodeOriginal = titreEpisodeOriginal;
		this.duree = duree;
		this.resume = resume;
		this.dateReal = dateReal;
		this.dateDiff = dateDiff;
		this.publicLimiteAge = publicLimiteAge;
		this.statut = statut;
	}

	private static boolean isBlank(String valeur) {
		return valeur == null || "".equals(valeur);
	}

	public String getSerie() {
		return serie;
	}


	public String getSaison() {
		return saison;
	}


	public String getTitreEpisode() {
		return titreEpisode;
	}


	public String getTitreEpisodeOriginal() {
		return titreEpisodeOriginal;
	}


	public int getDuree() {
		return duree;
	}


	public String getResume() {
		return resume;
	}


	public Date getDateReal() {
		return dateReal;
	}


	public Date getDateDiff() {
		return dateDiff;
	}


	public String getPublicLimiteAge() {
		return publicLimiteAge;
	}


	public String getStatut() {
		return statut;
	}

}
