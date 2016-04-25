/** 
     * La classe point 
     * @author Tom Spreters Xavier Salard
     * @version TP1 S4 0.01
	 */

public class Point {

	private double x;
	private double y;

	/** 
     * M�thode d'acc�s � l'abscisse du point.
     * Indispensable pour acc�der � l'attribut x.
     * @return l'abscisse du point.
	 */
	public double x() { return x; } 

	/** 
     * M�thode d'acc�s � l'ordonn�e du point.
     * Indispensable pour acc�der � l'attribut y.
     * @return l'ordonnee du point
	 */
	public double y() { return y; }

	/** 
    * Constructeur de Point par d�faut aux coordonn�es (1,1).
	 */
	
	public Point() {
		this.x = 1;
		this.y = 1;
	}

	/** 
     * Constructeur de Point � partir de coordonn�es x et y.
     * @param dx abscisse du point
     * @param dy ordonnee du point
	 */
	public Point(double dx, double dy) {
		this.x = dx;
		this.y = dy;
	}
	
	/** 
   * Constructeur de Point � partir d'un autre point.
   * @param p Point source
	 */
	
	public Point(Point p){
		this.x=p.x();
		this.y=p.y();
	}

	/** 
     * D�placement du point selon une translation.
     * @param dx abscisse du vecteur translation
     * @param dy ordonn�e du vecteur translation       
	 */
	public void deplace(double dx, double dy) {
		this.x+=dx;
		this.y+=dy;
	}

	/** 
   * Convertit le Point en une chaine de charact�res comportant notemment ses coordonn�es
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
   * Fonction permettant de v�rifier si deux points sont identiques
   * @param p le second point
   * @return boolean true si les points sont identiques
	 */
	
	public boolean estEgal(Point p){
		return (this.x==p.x & this.y==p.y);
	}
	/** 
   * Construit un nouveau point aux m�mes coordonn�es.
	 */
	public Point copie(){
		return new Point(this.x, this.y);
	}
	/** 
   * Fonction returnant le barycentre de deux points
   * @param a coefficient du point courant
   * @param b coefficient du point y
   * @param y second point de calcul du barycentre
   * @return le point barycentre calcul�
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



