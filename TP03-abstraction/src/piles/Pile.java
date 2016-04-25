package piles;

public interface Pile {
	Object depiler();
	void empiler(Object object);
	boolean pileVide();
	Object sommetPile();
	void viderPile();
	String toString();
	int Random(int min, int max);
}
