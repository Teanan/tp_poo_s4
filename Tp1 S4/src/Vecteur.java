	/**
	* @author Tom Spreters Xavier Salard
     * @version TP1 S4 0.01
	*/

public class Vecteur {

	private double dx;
	private double dy;
	
	/**
	 * Fonction constructeur à partir de deux réels
	 * @param a réel d'abscisse du vecteur
	 * @param b réel d'ordonnée du vecteur
	 */
	public Vecteur(double a, double b){
		this.dx= a;
		this.dy = b;
	}
	
	/**
	 * Fonction constructeur à partir de deux Points
	 * @param a Point d'origine du vecteur
	 * @param b Point d'arrivée du vecteur
	 */
	public Vecteur(Point a, Point b){
		this.dx = b.x()-a.x();
		this.dy = b.y()-a.y();
	}
	/**
	 * Calcule le produit scalaire de deux vecteurs
	 * @param v le second vecteur
	 * @return réel résultat du produit scalaire
	 */
	public double produitScalaire(Vecteur v){
		return(this.dx*v.dx+this.dy*v.dy);
	}
	
	/**
	* Fonction permettant de calculer le déterminant de deux vecteurs
	* @param v Second vecteur nécessaire au calcul
	* @return réel résultat du calcul du déterminant
	*/
	public double determinant(Vecteur v){
		return(this.dx*v.dy-this.dy*v.dx);
	}
	
	/**
	* Fonction indiquant si deux vecteurs sont colinéaires
	* @param v Second vecteur 
	* @return boolean dont la valeur est true lorsque les vecteurs sont parallèles
	*/
	public boolean parallele(Vecteur v){
		if(this.determinant(v)==0){return true;}
		else {return false;}
	}
	
	/**
	* Fonction indiquant si deux vecteurs sont orthogonaux
	* @param v Second vecteur 
	* @return boolean dont la valeur est true lorsque les vecteurs sont orthogonaux
	*/
	public boolean orthogonal(Vecteur v){
		if(this.produitScalaire(v)==0){return true;}
		else {return false;}
	}
	

}
