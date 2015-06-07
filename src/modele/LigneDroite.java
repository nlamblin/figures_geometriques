package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class LigneDroite extends FigureColoree {

	/**
	 * constructeur
	 */
	public LigneDroite() {
		super();
	}
	
	@Override
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean estDedans(int x, int y) {
		// TODO Auto-generated method stub
		boolean res = false;
		if(tab_mem.get(0).rendreX() > x) {
			if(tab_mem.get(0).rendreY() > y) {
				if(tab_mem.get(1).rendreX() < x) {
					if(tab_mem.get(1).rendreY() < y) {
						res = true;
					}
				}
			}
		}
		return res;
	}

	@Override
	public void modifierPoints(ArrayList<Point> tab_saisie) {
		// TODO Auto-generated method stub
		ArrayList<Point> tmp = new ArrayList<Point>(2);
		if(tab_saisie.size() > 1) {
			tmp.add(tab_saisie.get(0));
			tmp.add(tab_saisie.get(1));
		}
		tab_mem = tmp;
	}

	public void affiche(Graphics g){
		g.setColor(this.couleur);
		g.drawLine(tab_mem.get(0).rendreX(), tab_mem.get(0).rendreY(), tab_mem.get(1).rendreX(), tab_mem.get(1).rendreY());
	}

	
}
