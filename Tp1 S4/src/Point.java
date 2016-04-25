/** 
     * La classe point 
     * @author Tom Spreters Xavier Salard
     * @version TP1 S4 0.01
	 */

public class Point {

	private double x;
	private double y;

	/** 
     * Méthode d'accès à l'abscisse du point.
     * Indispensable pour accéder à l'attribut x.
     * @return l'abscisse du point.
	 */
	public double x() { return x; } 

	/** 
     * Méthode d'accès à l'ordonnée du point.
     * Indispensable pour accéder à l'attribut y.
     * @return l'ordonnee du point
	 */
	public double y() { return y; }

	/** 
    * Constructeur de Point par défaut aux coordonnées (1,1).
	 */
	
	public Point() {
		this.x = 1;
		this.y = 1;
	}

	/** 
     * Constructeur de Point à partir de coordonnées x et y.
     * @param dx abscisse du point
     * @param dy ordonnee du point
	 */
	public Point(double dx, double dy) {
		this.x = dx;
		this.y = dy;
	}
	
	/** 
   * Constructeur de Point à partir d'un autre point.
   * @param p Point source
	 */
	
	public Point(Point p){
		this.x=p.x();
		this.y=p.y();
	}

	/** 
     * Déplacement du point selon une translation.
     * @param dx abscisse du vecteur translation
     * @param dy ordonnée du vecteur translation       
	 */
	public void deplace(double dx, double dy) {
		this.x+=dx;
		this.y+=dy;
	}

	/** 
   * Convertit le Point en une chaine de charactères comportant notemment ses coordonnées
   * Ex : (x,y)
	 */
	public void affiche(){
		System.out.println("("+this.x+","+this.y+")");
	}
	/** 
   * Permet de calculer le point milieu de deux points
   * @param p second point 
   * @return le point milieu
	 */
	public Point milieu(Point p){
		return new Point((this.x+p.x)/2,(this.y+p.x)/2);
	}
	/** 
   * Fonction permettant de vérifier si deux points sont identiques
   * @param p le second point
   * @return boolean true si les points sont identiques
	 */
	
	public boolean estEgal(Point p){
		return (this.x==p.x & this.y==p.y);
	}
	/** 
   * Construit un nouveau point aux mêmes coordonnées.
	 */
	public Point copie(){
		return new Point(this.x, this.y);
	}
	/** 
   * Fonction returnant le barycentre de deux points
   * @param a coefficient du point courant
   * @param b coefficient du point y
   * @param y second point de calcul du barycentre
   * @return le point barycentre calculé
	 */
	
	public Point barycentre(double a, double b, Point y){
		return new Point((a*this.x() + b*y.x())/(a+b),(a*this.y() + b*y.y())/(a+b));
	}
	
	/** 
   * Fonction principale
	 */
	public static void main(String[] args) {
		Point p1 = new Point(10, 10);
		System.out.println(p1);
		p1.affiche();
		Point p2 = p1.copie();
		p1 = p2;
	}
}



