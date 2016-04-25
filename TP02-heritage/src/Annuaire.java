

/**
 Classe 
 
 @author Departement informatique
 @version 16.0128
 */


public class Annuaire extends EnsembleP{
	public Annuaire(){
		super();
	}
	
	public int tel(String p, String n){
		Personne per = new Personne(p,n);
		for (int i=0; i<card; i++){
			if (per.equals(Annu[i])){
				return Annu[i].getTel();
			}
		}
		return -1;
	}
	
	public Personne telInverse(int tel){
		for (int i=0; i<card; i++){
			if (tel==(Annu[i].getTel())){
				return Annu[i];
			}
		}
		return null;
	}
	
	public String toString(){
		String ret = "Nombre de personnes :"+card ;
		for(int i = 0; i<card; i++){
			ret = ret+ "\n" + Annu[i].toString() +" : "+ Annu[i].getTel();
		}
		return ret;
	}
	
}
