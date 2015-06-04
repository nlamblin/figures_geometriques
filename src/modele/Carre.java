package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Carre extends Quadrilatere {
	
	public Carre() {
		super();
	}
	
	public int nbClics() {
		return 2;
	}
	
	public int nbPoints(){
		return 4;
	}
	
	@Override
	public void affiche(Graphics g){
		super.affiche(g);
	}
	
	@Override
	public void modifierPoints(ArrayList<Point>  tab_saisie) {
		ArrayList<Point> tmp = new ArrayList<Point>(4);
		if (tab_saisie.size() > 1){
			tmp.add(tab_saisie.get(0));
			
		}
		super.modifierPoints(tmp);
	}
	

}
