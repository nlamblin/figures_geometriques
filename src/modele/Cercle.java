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
		g.fillOval(rendreCentre().rendreX()-(int)rayon, rendreCentre().rendreY()-(int)rayon, (int)rayon*2, (int)rayon*2);
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
	
	public void setRayon(double r) {
		rayon = r;
	}
	
}
