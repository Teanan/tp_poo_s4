/**
 Classe representant un ensemble de personnes.
 
 @author Departement informatique
 @version 16.0128
 */
public class EnsembleP {
	protected static final int CAPACITE = 100;
	protected int card;
	protected Personne[] Annu;
	
	public EnsembleP(){
		Annu = new Personne[CAPACITE];
		card = 0;
	}
	
	public int card(){
		return card;
	}
	
	public void ajouter(Personne p){
		if (card < CAPACITE){
			Annu[card]= p;
			card++;
		}
	}
	
	public void oter(Personne p){
		for( int i=0; i<card; i++){
			if (Annu[i].equals(p)){
				Annu[i]= Annu[card-1];
				return;
			}
		}
	}
	
	public boolean contient(Personne p){
		for( int i=0; i<card; i++){
			if (Annu[i].equals(p)){
				return true;
			}
		}
		return false;
	}
	
	public EnsembleP union(EnsembleP p){
		EnsembleP ret = new EnsembleP();
		for(int i=0; i<card; i++){
			ret.ajouter(Annu[i]);
		}
		for(int i=0; i<p.card; i++){
			if (!(ret.contient(p.Annu[i]))){
				ret.ajouter(p.Annu[i]);
			}
		}
		return ret;
	}
	
	public EnsembleP inter(EnsembleP p){
		EnsembleP ret = new EnsembleP();
		for(int i=0; i<card; i++){
			if(p.contient(Annu[i])){
				ret.ajouter(Annu[i]);
			}
		}
		return ret;
	}
	
	public String toString(){
		String ret = "Nombre de personnes :"+card ;
		for(int i = 0; i<card; i++){
			ret = ret+ "\n" + Annu[i].toString();
		}
		return ret;
	}
	
}
