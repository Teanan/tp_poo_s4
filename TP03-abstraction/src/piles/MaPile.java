package piles;


public class MaPile{

	private int taille;
	private Object[] tab;
	private static final int TAILLEMAX = 100;
	
	public MaPile(){
		viderPile();
	}

	public void viderPile(){
		tab = new Object[TAILLEMAX];
		taille = 0;
	}

	public void empiler(Object it){
		if (taille<TAILLEMAX){ 
			tab[taille]= it;
			taille++;
		}
	}
	
	public Object depiler(){
		Object tmp = tab[taille-1];
		tab[taille-1]= null;
		taille--;
		return tmp;
	}
	
	public Object sommetPile(){
		return tab[taille-1];
		
	}
	
	public boolean pileVide(){
		return (taille==0);
	}
	
	public String ToString(){
		String str = new String();
		str ="";
		for (int i = 0; i<taille; i++ ){
			str+= tab[i].toString();
		}
		return str;
	}
	
	public int Random(int Min, int Max){
		return(Min + (int)(Math.random() * ((Max - Min) + 1)));
	}
}
