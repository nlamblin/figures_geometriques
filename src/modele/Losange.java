package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Losange extends Quadrilatere {
	
	public Losange(){
		super();
	}
	
	public int nbClics() {
		return 3;
	}
	
	@Override
	public void affiche(Graphics g){
		super.affiche(g);
	}
	
	@Override
	public void modifierPoints(ArrayList<Point>  tab_saisie) {
		ArrayList<Point> tmp = new ArrayList<Point>(5);
		if(tab_saisie.size() == 3) {
			tmp.add(tab_saisie.get(0));
			tmp.add(new Point(tab_saisie.get(0).rendreX(), tab_saisie.get(0).rendreY()));
			tmp.add(tab_saisie.get(1));
			tmp.add(new Point(tab_saisie.get(1).rendreX(), tab_saisie.get(1).rendreY()));
			tmp.add(tab_saisie.get(2));
			tmp.add(new Point(tab_saisie.get(2).rendreX(), tab_saisie.get(2).rendreY()));
		}
		double distanceEntrePointHautCentre = tab_saisie.get(0).distance(tab_saisie.get(1));
		double distanceEntrePointGaucheCentre = tab_saisie.get(2).distance(tab_saisie.get(0));
		
		tmp.add(new Point(tab_saisie.get(0).rendreX(), tab_saisie.get(1).rendreY()-(int)distanceEntrePointHautCentre*2));
		tmp.add(new Point(tab_saisie.get(2).rendreX()+(int)distanceEntrePointGaucheCentre*2, tab_saisie.get(0).rendreY()));
		
		super.modifierPoints(tmp);
	}
	
	public void transformation(int dx, int dy, int indice) {
		int i = 0;
		while(i <= tab_mem.size()) {
			if(i == indice) {
				tab_mem.get(i).modifierX(dx);
				tab_mem.get(i).modifierY(dy);
			}
			i++;
		}
	}

}
