	/**
	* @author Tom Spreters Xavier Salard
     * @version TP1 S4 0.01
	*/

public class Droite {
	private Point p1;
	private Point p2;
	
	/**
	* Constructeur permettant de créer une droite à partir de deux points
	* @param dp1 un premier point de la droite
	* @param dp2 un second point de la droite
	*/
	public Droite(Point dp1, Point dp2){
		if(dp1.equals(dp2)){
			Point dp3 = new Point(dp2.x(), dp2.y());
			dp3.deplace(1, 1);
			this.p1=dp1;
			this.p2=dp3;
		}
		else{
			this.p1=dp1;
			this.p2=dp2;
		}
	}
	
	/**
	* Fonction permettant de vérifier si deux droites sont parallèles
	* @param d seconde droite 
	* @return boolean true si les droites sont parallèles, false sinon
	*/
	
	public boolean parallele(Droite d){
		Vecteur v1 = new Vecteur(this.p1, this.p2);
		Vecteur v2 = new Vecteur(d.p1, d.p2);
		return(v1.parallele(v2));
	}
	
	/**
	* Fonction permettant de vérifier si deux droites sont parallèles
	* @param d seconde droite 
	* @return boolean true si les droites sont orthogonales, false sinon
	*/
	public boolean orthogonale(Droite d){
		Vecteur v1 = new Vecteur(this.p1, this.p2);
		Vecteur v2 = new Vecteur(d.p1, d.p2);
		return(v1.orthogonal(v2));
	}
	/**
	* Fonction permettant de vérifier qu'un point appartient à une droite infinie
	* @param p Point dont on veut vérifier la présence dans la droite
	* @return boolean true si le point est contenue dans la droite, false sinon
	*/
	public boolean contient(Point p){
		Vecteur v1 = new Vecteur(this.p1, this.p2);
		Vecteur v2 = new Vecteur(this.p1, p);
		return(v1.parallele(v2));
	}
	
}
