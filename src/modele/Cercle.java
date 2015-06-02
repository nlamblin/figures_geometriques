package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cercle extends ConiqueCentree {
	
	private double rayon;
	
	public Cercle() {
		super();
		rayon = 150;
	}
	
	public void affiche(Graphics g){
		g.setColor(this.couleur);
		g.fillOval(centre.rendreX(), centre.rendreY(), (int)rayon, (int)rayon);
	}

	@Override
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean estDedans(int x, int y) {
		// TODO Auto-generated method stub
		boolean res = false;
		if(centre.rendreX() + rayon > x) {
			if(centre.rendreY() + rayon > y) {
				if(centre.rendreX() - rayon < x) {
					if(centre.rendreY() - rayon < y) {
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
		if(tab_saisie.size()>1) {
			tmp.add(tab_saisie.get(0));
			tmp.add(new Point(tab_saisie.get(0).rendreX(), tab_saisie.get(0).rendreY()));
		}
		super.modifierPoints(tmp);
	}
	
	public void setRayon(double r) {
		rayon = r;
	}
	
}
