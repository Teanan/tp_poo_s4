package tp3;

public class Assiete extends Ustensile{

	public Assiete(String n) {
		super(n);
		Resistance = 95;
	}
	
	public String toString(){
		return(nom);
	}

	public void laver() {
		int rnd = Random(0,100);
		if (rnd < Resistance) LavageReussi();
		else casser();
		Resistance = Math.round(Resistance*(1-(rnd/Resistance)));
		
	}

}
