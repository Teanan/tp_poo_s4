package tp3;

import piles.*; // importe toutes les definitions du package piles

/**
 * Plonge.java
 *
 * Classe representant quelqu'un qui fait "la plonge",
 * utilisant une pile de vaisselle sale et une pile de vaisselle propre.
 *
 * @author Departement informatique
 * @version 16.0202
 */
public class Plonge  {
	/* REMARQUE : attributs de type general Pile (!!!) */
	protected Pile sale;   // les ustensiles sales
	protected Pile propre; // les ustensiles propres

	public Plonge(Pile a, Pile b) {
		// on se met a la plonge sur les piles fournies
		sale=a;
		propre=b;
	}

	public void ajouterUnUstensile(Object u) {
		sale.empiler(u); // empile un ustensile a laver
	}

	public void laverUnSale() {
		Object u = sale.depiler();
		System.out.println("Lavage de "+u);
		
		// pour la question 4.
		// (en principe il faudrait plutôt modifier Pile/MaPile/SimplePile
		//  pour imposer Ustensile au lieu de Object; le code suivant
		//  est proposé pour simplifier le TP)
		if(u instanceof Ustensile)
		{
			((Ustensile)u).laver();
		} else {
			//eventuellement afficher un message d'erreur
		}
		
		propre.empiler(u);
	}

	public Object retirerUnPropre() {
		Object u = propre.depiler(); // sort un ustensile
		return u;
	}

	public void toutVider() {
		sale.viderPile();
		propre.viderPile();
	}

	public String toString() {
		return "Situation de la plonge :\n"+sale+propre;
	}

	public static void main(String[] args) {
		Plonge p = new Plonge( new SimplePile(), new SimplePile() );
		
//		p.ajouterUnUstensile("G�rard");
//		p.ajouterUnUstensile("Juliette");
//		p.ajouterUnUstensile("Bob");
//		p.laverUnSale();
//		p.laverUnSale();
//		p.ajouterUnUstensile("Averell");
//		Object u = p.retirerUnPropre();
//		System.out.println(p + "ustensile retire propre : "+u);
		
		Assiete Gerard = new Assiete("Gerard");
		Verre Jean = new Verre("Jean-Claude");
		Assiete Luc = new Assiete("Luc");
		Verre Benoit = new Verre("Benoit");
		Assiete Juliette = new Assiete("Juliette");
		Verre Bertrand = new Verre("Bertrand");
		p.ajouterUnUstensile(Luc);
		p.ajouterUnUstensile(Jean);
		p.ajouterUnUstensile(Gerard);
		p.ajouterUnUstensile(Juliette);
		p.ajouterUnUstensile(Benoit);
		p.ajouterUnUstensile(Bertrand);
		p.laverUnSale();
		p.laverUnSale();
		p.laverUnSale();
		p.laverUnSale();
		
		
	}
}
