package tp3;

/**
 * Classe abstraite Ustensile,
 * dont on derive tout ustensile concret (assiette, verre, etc.)
 */
public abstract class Ustensile {

	protected int Resistance;
	protected boolean casse;
	protected String nom;
	
	public static final String[] replic = new String[20];
			
	static{
		replic[0]=", ça ne manquera à personne...";
		replic[1]=", décidémment vous n'êtes pas très doué...";
		replic[2]=" et un couvert en moins!";
		replic[3]=", bravo vous avez réussi à laisser une marque derrière vous!";
		replic[4]=", un ustensile en moins, une coupure en plus pour vous.";
		replic[5]="...Vous saviez que les ustensiles ont une conscience...Monstre!";
		replic[6]=", allez vous coucher, ça ira mieux demain...";
		replic[7]=", c'est archi-dégueulasse...";
		replic[8]=", au moins désormais vous savez que votre talent est ailleurs...";
		replic[9]=", vous savez pas jongler vous non?";
		replic[10]=", une bonne chose de faite!";
		replic[11]=", à quoi ça sert de toute façon elle sera à nouveau sale demain...";
		replic[12]=", faut croire que vous aviez plus confiance en vous que ce couvert n'en avait.";
		replic[13]=", c'était limite, heureusement que vous avez quelques réflexes";
		replic[14]=", il semblerait que ces deux mains ne soient pas juste là pour la décoration finalement!";
		replic[15]=", vous devriez peut-être recommencer, non?";
		replic[16]=", c'est un miracle!";
		replic[17]=", on vous a jamais dit que le savon n'est pas un produit vaisselle? Enfin je suppose que ça fera l'affaire...";
		replic[18]=", certains diraient que c'est toujours sale... Pas vous apparemment...";
		replic[19]=", au moins vous aurez réussi quelque chose dans la journée!";
	}
	public Ustensile(String n) {
		Resistance = 0;
		casse = false;
		nom = n;
	}
	public int Random(int Min, int Max){
		return(Min + (int)(Math.random() * ((Max - Min) + 1)));
	}
	/** 
	 * Methode pour laver un ustensile, specifique a chaque cas concret.
	 * Par exemple, suivant sa nature il resistera plus ou moins longtemps avant de casser.
	 */
	public abstract void laver();
	// Pas vraiment utile de le garder en abstract...
	
	public String toString() { 
		// erased
		return "ustensile";
	}
	public void LavageReussi(){
		int rnd = Random(10,19);
		System.out.println(this.toString()+ " semble avoir survécu" + replic[rnd] + "\n");
	}
	
	public void casser(){
		casse = true;
		int rnd = Random(0,9);
		System.out.println(this.toString()+ " a rendu l'âme" + replic[rnd] + "\n");
		
	}
}

