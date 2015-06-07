package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Carre extends Rectangle{
	
	/**
	 * constructeur
	 */
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
		ArrayList<Point> tmp = new ArrayList<Point>(2);
		if (tab_saisie.size()>1){
			tmp.add(tab_saisie.get(0));
			tmp.add(new Point(tab_saisie.get(0).rendreX(), tab_saisie.get(1).rendreY()));
			tab_saisie.get(1).modifierX(tmp.get(0).rendreX()+(int)tmp.get(0).distance(tmp.get(1)));
		}
		super.modifierPoints(tab_saisie);
	}
	

}
