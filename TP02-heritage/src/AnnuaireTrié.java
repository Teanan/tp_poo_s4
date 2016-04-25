
public class AnnuaireTrié extends EnsembleTriéP{
	public AnnuaireTrié(){
		super();
	}
	
	public int tel(String p, String n){
		Personne per = new Personne(p,n);
		int a = position(per);
		if (a==-1) return -1;
		else return Annu[a].getTel();
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
