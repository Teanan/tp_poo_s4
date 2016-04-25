
public class EnsembleTriéP {
	protected static final int CAPACITE = 100;
	protected int card;
	protected Personne[] Annu;
	
	public EnsembleTriéP(){
		Annu = new Personne[CAPACITE];
		card = 0;
	}
	
	public int card(){
		return card;
	}
	
	public void ajouter(Personne p){
		if ((card < CAPACITE)&!(contient(p))){
			int a = card;
			for (int i =0; i<card; i++){
				if (p.estAvant(Annu[i])){
					a=i;
					i=card;
				}
			}
			if (!(a==card)){
				for (int i = card;  i>a; i--){
					Annu[i]=Annu[i-1];
				}
			}
			Annu[a]=p;
			card++;
		}
	}
	
	public void oter(Personne p){
		int a = card;
		for( int i=0; i<card; i++){
			if (Annu[i].equals(p)){
				a=i;
			}
		}
		for (int j = card-1;  j<=a; j--){
			Annu[j-1]=Annu[j];
		}
		return;
	}
	
	public int position(Personne per){
		if (card==0) return -1;
		if ((card==1)) if(per.equals(Annu[0])) return 0; else return -1;
		int a=0;
		int b=0;
		if (per.equals(Annu[Math.round(card/2)])) return Math.round(card/2);
		if (per.estAvant(Annu[Math.round(card/2)])){
			if (per.equals(Annu[Math.round(card/4)])) return Math.round(card/4);
			if (per.estAvant(Annu[Math.round(card/4)])){
				if (per.equals(Annu[Math.round(card/8)])) return Math.round(card/8);
				if (per.estAvant(Annu[Math.round(card/8)])){
					if (per.equals(Annu[Math.round(card/16)])) return Math.round(card/16);
					if (per.estAvant(Annu[Math.round(card/16)])){
						a = 0;
						b = Math.round(card/16);
					}
					else {
						a = Math.round(card/16);
						b = Math.round(2*card/16);
					}
				}
				else{ if (per.equals(Annu[Math.round(3*card/16)])) return Math.round(3*card/16);
					if (per.estAvant(Annu[Math.round(3*card/16)])){
						a = Math.round(card/8);
						b = Math.round(3*card/16);
					}
					else {
						a = Math.round(3*card/16);
						b = Math.round(4*card/16);
					}
				}
					
				}else {
					if (per.equals(Annu[Math.round(3*card/8)])) return Math.round(3*card/8);
					if (per.estAvant(Annu[Math.round(3*card/8)])){
						if (per.equals(Annu[Math.round(5*card/16)])) return Math.round(5*card/16);
						if (per.estAvant(Annu[Math.round(5*card/16)])){
							a = Math.round(4*card/16);
							b = Math.round(5*card/16);
						}
						else {
							a = Math.round(5*card/16);
							b = Math.round(6*card/16);
						}
					}
					else{ if (per.equals(Annu[Math.round(7*card/16)])) return Math.round(7*card/16);
						if (per.estAvant(Annu[Math.round(7*card/16)])){
							a = Math.round(6*card/16);
							b = Math.round(7*card/16);
						}
						else {
							a = Math.round(7*card/16);
							b = Math.round(8*card/16);
						}
					}
				}
			}else {
				if (per.equals(Annu[Math.round(3*card/4)])) return Math.round(3*card/4);
				if (per.estAvant(Annu[Math.round(3*card/4)])){
					if (per.equals(Annu[Math.round(5*card/8)])) return Math.round(5*card/8);
					if (per.estAvant(Annu[Math.round(5*card/8)])){
						if (per.equals(Annu[Math.round(9*card/16)])) return Math.round(9*card/16);
						if (per.estAvant(Annu[Math.round(9*card/16)])){
							a = Math.round(8*card/16);
							b = Math.round(9*card/16);
						}
						else {
							a = Math.round(9*card/16);
							b = Math.round(10*card/16);
						}
					}
					else{ if (per.equals(Annu[Math.round(11*card/16)])) return Math.round(11*card/16);
						if (per.estAvant(Annu[Math.round(11*card/16)])){
							a = Math.round(10*card/16);
							b = Math.round(11*card/16);
						}
						else {
							a = Math.round(11*card/16);
							b = Math.round(12*card/16);
						}
					}
				
				}else {
					if (per.equals(Annu[Math.round(7*card/8)])) return Math.round(7*card/8);
					if (per.estAvant(Annu[Math.round(7*card/8)])){
						if (per.equals(Annu[Math.round(13*card/16)])) return Math.round(13*card/16);
						if (per.estAvant(Annu[Math.round(13*card/16)])){
							a = Math.round(12*card/16);
							b = Math.round(13*card/16);
						}
						else {
							a = Math.round(13*card/16);
							b = Math.round(14*card/16);
						}
					}
					else{ if (per.equals(Annu[Math.round(15*card/16)])) return Math.round(15*card/16);
						if (per.estAvant(Annu[Math.round(15*card/16)])){
							a = Math.round(14*card/16);
							b = Math.round(15*card/16);
						}
						else {
							a = Math.round(15*card/16);
							b = Math.round((16*card/16));
						}
					}
				}
			}
		
		for (int i = a; i < b; i++ ){
			if (per.equals(Annu[i])) return i;
		}
		return -1;
	}
	
	
	public boolean contient(Personne per){
		if (position(per)==-1) return false;
		else return true;
	}
	
	
	public EnsembleTriéP union(EnsembleTriéP p){
		EnsembleTriéP ret = new EnsembleTriéP();
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
	
	public EnsembleTriéP inter(EnsembleTriéP p){
		EnsembleTriéP ret = new EnsembleTriéP();
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
