package tp3;

public class Verre extends Ustensile{

	public Verre(String n) {
		super(n);
		Resistance = 80;
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
