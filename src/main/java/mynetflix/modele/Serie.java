package mynetflix.modele;

public class Serie {
	private int id;
    private String nom;
    private String nomoriginal;
    private String synopsys;
    private int anneeparution;
    private int idstatut;
    private int idpaysorigine;

    public Serie(int id, String nom, String nomoriginal, String synopsys, int anneeparution, int idstatut, int idpaysorigine) throws FormulaireInvalide {
    	this.id = id;
    	this.nom = nom;
        this.nomoriginal = nomoriginal;
        this.synopsys = synopsys;
        this.anneeparution = anneeparution;
        this.idstatut = idstatut;
        this.idpaysorigine = idpaysorigine;
    }
    
    public Serie(String nom, String nomoriginal, String synopsys, String anneeparution, String idstatut, String idpaysorigine) throws FormulaireInvalide {
        if (isBlank(nom)) {
            throw new FormulaireInvalide("Veuillez indiquer le nom de la série !");
        }
        if (isBlank(anneeparution)) {
            throw new FormulaireInvalide("Veuillez indiquer l'année de parution de la série !");
        }
        if (isBlank(idstatut) || idstatut.equals("0")) {
            throw new FormulaireInvalide("Veuillez choisir un statut !");
        }
        if (isBlank(idpaysorigine) || idpaysorigine.equals("0")) {
            throw new FormulaireInvalide("Veuillez choisir un pays d'origine !");
        }
        this.nom = nom;
        this.nomoriginal = nomoriginal;
        this.synopsys = synopsys;
        this.anneeparution = Integer.valueOf(anneeparution);
        this.idstatut = Integer.valueOf(idstatut);
        this.idpaysorigine = Integer.valueOf(idpaysorigine);
    }
    
    public Serie(int id, String nom) {
    	this.id = id;
    	this.nom = nom;
    }
    
    private static boolean isBlank(String valeur) {
        return valeur == null || "".equals(valeur);
    }

    public int getId() {
		return id;
	}
    public String getNom() {
        return nom;
    }
    public String getNomoriginal() {
        return nomoriginal;
    }
    public String getSynopsys() {
        return synopsys;
    }
    public int getAnneeparution() {
        return anneeparution;
    }
    public int getIdstatut() {
        return idstatut;
    }
    public int getIdpaysorigine() {
        return idpaysorigine;
    }

}
