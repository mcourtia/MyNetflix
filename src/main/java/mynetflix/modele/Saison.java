package mynetflix.modele;

public class Saison{
    
	private int id;
    private String resume;
    private int annee_diffusion;
    private int numero;
    private int idstatut;
    private int idserie;

    public Saison(String numero, String resume, String annee_diffusion, String idstatut, String idserie) throws FormulaireInvalide {
        
    	if (isBlank(numero)) {
            throw new FormulaireInvalide("Veuillez indiquer le numéro de la saison !");
        }
        if (isBlank(idstatut) || idstatut.equals("0")) {
            throw new FormulaireInvalide("Veuillez choisir un statut !");
        }
        if (isBlank(idserie) || idserie.equals("0")) {
            throw new FormulaireInvalide("Veuillez choisir une série !");
        }
        if (!isBlank(annee_diffusion)) {
	        try {
	        	this.annee_diffusion = Integer.valueOf(annee_diffusion);
	        } catch(NumberFormatException e) {
				throw new FormulaireInvalide("L'année est invalide !");
	        }
        }
        try {
        	this.numero = Integer.valueOf(numero);
        } catch(NumberFormatException e) {
			throw new FormulaireInvalide("Le numéro n'est pas un nombre !");
        }
        
        this.resume = (resume == "") ? null:resume;
        this.idstatut = Integer.valueOf(idstatut);
        this.idserie = Integer.valueOf(idserie);
    }
    
    public Saison(int id, int numero) {
    	this.id = id;
    	this.numero = numero;
    }
    
    private static boolean isBlank(String valeur) {
        return valeur == null || "".equals(valeur);
    }

    public int getId() {
		return id;
	}
    public String getResume() {
        return resume;
    }
    public int getAnnee_diffusion() {
        return annee_diffusion;
    }
    public int getNumero() {
        return numero;
    }
    public int getIdstatut() {
        return idstatut;
    }
    public int getIdserie() {
        return idserie;
    }
    
}