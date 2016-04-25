/**
 Classe representant une personne associee a son numero de telephone.

 @author Departement informatique
 @version 16.0128
 */
public class Personne {
	protected int tel;
	protected Mot nom;
	protected Mot prenom;
	
	public Personne(String p, String n){
		nom = new Mot(n);
		prenom = new Mot(p);
	}
	/** Associe le numero de telephone. */
	public void setTel(int t) {
		tel=t;
	}

	/** Fournit le numero de telephone. */
	public int getTel() {
		return tel;
	}
	
	/** Teste l'égalite du nom et du prenom */
	public boolean equals(Object o){
		Personne p = (Personne)o;
		return(nom.equals(p.nom)&&prenom.equals(p.prenom));
	}

	/**
     Produit une chaine indiquant la personne. 
     (Par exemple Jules CESAR)
	 */
	public String toString() {
		return prenom.toString().substring(0, 1).toUpperCase()+prenom.toString().substring(1).toLowerCase() +" "+ nom.toString().toUpperCase();
	}
	

	public boolean estAvant(Personne p){
		int a= nom.toString().toLowerCase().compareTo(p.nom.toString().toLowerCase());
		if (a <0) return true;
			else if (a>0) return false;
				else {
					int b = prenom.toString().toLowerCase().compareTo(p.prenom.toString().toLowerCase());
					if ((a==0)&(b<0)) return true;
					else return false;
				}
	}
	

	/**
     Tests.
	 */
	public static void main (String[] args) {

		Personne toto = new Personne("Jean-Claude","Dusse");
		System.out.println(toto+"  Expected:Nothing \n");
		System.out.println(toto.toString()+"  Expected:jean-claude DUSSE \n");
		toto.setTel(4321);
		System.out.println(toto.getTel()+"  Expected:4321 \n");
		System.out.println(toto.equals(new Personne("Jean-Claude","DUSSE"))+"  Expected:True \n");
		System.out.println(toto.equals(new Personne("Jean-Claude","Musse"))+"  Expected:False \n");
		Personne a = new Personne("Dan","Ver");
		Personne b = new Personne("Don","Cran");
		Personne c = new Personne("Jules","Bernes");
		Personne d = new Personne("Dan","Deu");
		Personne e = new Personne("Jean-Michel","De Gen�ve");
		Personne f = new Personne("Zeurel","Dessinateur");
		Personne g = new Personne("un","passant");
		System.out.println(a.estAvant(b)+"  Expected:False \n");
		System.out.println(b.estAvant(c)+"  Expected:False \n");
		System.out.println(toto.estAvant(a)+"  Expected:True \n");
		EnsembleTriéP ensemble1 = new EnsembleTriéP();
		EnsembleTriéP ensemble2 = new EnsembleTriéP();
		a.setTel(2939);
		b.setTel(1525);
		c.setTel(5885);
		ensemble1.ajouter(a);
//		System.out.println(ensemble1.toString()+"  Expected: 1 personne");
		ensemble1.ajouter(b);
//		System.out.println(ensemble1.toString()+"  Expected: 2 personnes");
		ensemble2.ajouter(a);
//		System.out.println(ensemble2.toString()+"  Expected: 1 personne");
		ensemble2.ajouter(c);
//		System.out.println(ensemble2.toString()+"  Expected: 2 personnes");
		ensemble2.ajouter(toto);
//		System.out.println(ensemble2.toString()+"  Expected: 3 personnes");
		ensemble2.ajouter(c);
		ensemble2.ajouter(d);
//		System.out.println(ensemble2.toString()+"  Expected: 4 personnes");
		ensemble2.ajouter(e);
		ensemble2.ajouter(f);
		ensemble2.ajouter(g);
//		System.out.println(d.estAvant(toto)+"  Expected:True");
//		System.out.println(ensemble2.toString()+" \n");
//		System.out.println(ensemble1.inter(ensemble2).toString()+"  Expected: 1 personne: dan VER");
//		System.out.println(ensemble1.union(ensemble2).toString()+"  Expected: 8 personnes...");
		Annuaire annu = new Annuaire();
		annu.ajouter(c);
		annu.ajouter(b);
		annu.ajouter(a);
		annu.ajouter(d);
		annu.ajouter(e);
		annu.ajouter(f);
		annu.ajouter(g);
		System.out.println(annu.toString()+"  Expected: 7 personnes \n");
		System.out.println(annu.tel("Dan", "VER")+"  Expected:2939 \n");
		System.out.println(annu.tel("Jules", "Vernes")+"  Expected:Nothing \n");
		System.out.println(annu.telInverse(2939)+"  Expected: dan VER \n");
		System.out.println(annu.telInverse(5648)+"  Expected:Nothing \n");
		
	}
}