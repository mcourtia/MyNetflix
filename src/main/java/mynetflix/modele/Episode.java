package mynetflix.modele;

import java.util.Date;

public class Episode {
	
	private int id;
	private int numero;
	private String titre;
	private String titreoriginal;
	private int duree;
	private String resume;
	private String dateReal;
	private String dateDiff;
	private int idpublicAge; // impossible d'appeler juste "public" cette variable
	private int idstatut;
	private int idsaison;
	
	public Episode(String numero, String titre, String titreoriginal, String duree,
			String resume, String dateReal, String dateDiff, String idpublicAge, String idstatut, String idsaison) throws FormulaireInvalide {
		
		if (isBlank(numero)) {
			throw new FormulaireInvalide("Veuillez indiquer le numéro de l'épisode !");
		}
		try {
			this.numero = Integer.valueOf(numero);
		} catch (NumberFormatException e) {
			throw new FormulaireInvalide("Numéro d'épisode invalide !");
		}
		if (isBlank(titre)) {
			throw new FormulaireInvalide("Veuillez indiquer le titre de l'épisode !");
		}
		if (isBlank(idpublicAge)) {
			throw new FormulaireInvalide("Veuillez indiquer la limite d'age de l'épisode !");
		}
		if (isBlank(idstatut)) {
			throw new FormulaireInvalide("Veuillez indiquer le statut de l'épisode !");
		}
		if (!isBlank(dateReal) && !matchDate(dateReal)) {
			throw new FormulaireInvalide("Date de réalisation invalide !");
		}
		if (!isBlank(dateDiff) && !matchDate(dateDiff)) {
			throw new FormulaireInvalide("Date de diffusion invalide !");
		}
		if (!isBlank(duree)) {
	        try {
	        	this.duree = Integer.valueOf(duree);
	        } catch(NumberFormatException e) {
				throw new FormulaireInvalide("L'année est invalide !");
	        }
        }
		
		this.titre = titre;
		this.titreoriginal = titreoriginal;
        this.resume = (resume == "") ? null:resume;
		this.dateReal = dateReal;
		this.dateDiff = dateDiff;
		this.idpublicAge = Integer.valueOf(idpublicAge);
		this.idstatut = Integer.valueOf(idstatut);
		this.idsaison = Integer.valueOf(idsaison);
	}
	
	public Episode(int id, int numero) {
		this.id = id;
		this.numero = numero;
	}

	private static boolean isBlank(String valeur) {
		return valeur == null || "".equals(valeur);
	}
	
	//Méthode qui vérifie le format de la date à l'aide d'une regex
	private static boolean matchDate(String valeur) {
		return valeur.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
	}

	public int getId() {
		return id;
	}

	public int getNumero() {
		return numero;
	}

	public String getTitre() {
		return titre;
	}


	public String getTitreoriginal() {
		return titreoriginal;
	}


	public int getDuree() {
		return duree;
	}


	public String getResume() {
		return resume;
	}


	public String getDateReal() {
		return dateReal;
	}


	public String getDateDiff() {
		return dateDiff;
	}

	public int getIdpublicAge() {
		return idpublicAge;
	}

	public int getIdstatut() {
		return idstatut;
	}

	public int getIdsaison() {
		return idsaison;
	}

}
