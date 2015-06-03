package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cercle extends ConiqueCentree {
	
	private double rayon=0;
	
	public Cercle() {
		super();
	}
	
	public void affiche(Graphics g){
		g.setColor(this.couleur);
		g.fillOval(rendreCentre().rendreX()-(int)rayon, rendreCentre().rendreY()-(int)rayon, (int)rayon*2, (int)rayon*2);
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
		if(rendreCentre().rendreX() + rayon > x) {
			if(rendreCentre().rendreY() + rayon > y) {
				if(rendreCentre().rendreX() - rayon < x) {
					if(rendreCentre().rendreY() - rayon < y) {
						res = true;
					}
				}
			}
		}
		return res;
	}
	
	 public void modifierPoints(ArrayList<Point> tab_saisie){
			ArrayList<Point> tmp = new ArrayList<Point>(2);
			if (tab_saisie.size()==2){
				tmp.add(tab_saisie.get(0));
				tmp.add(tab_saisie.get(1));
				setRayon(tab_saisie.get(1).distance(tab_saisie.get(0)));
			}
			tab_mem=tmp;
	}
	public void setRayon(double r) {
		rayon = r;
	}
	
}
