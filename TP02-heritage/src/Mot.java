/**
 Classe representant un mot.
 
 @author Departement informatique
 @version 16.0128
 */
class Mot {
	protected String chaine;
	/** Constructeur */
	public Mot(String texte){
		chaine = texte;
	}
	
	/** Teste l'egalite, insensible a la casse */
	public boolean equals(Object o){
		return((chaine.toLowerCase()).equals(((Mot)o).toString().toLowerCase()));
	}

	/** Retourne une version String du mot */
	public String toString() {
        return chaine; 
	}

}
