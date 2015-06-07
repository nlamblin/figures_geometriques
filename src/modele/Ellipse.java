package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Ellipse extends ConiqueCentree {

	private double hauteur;
	private double largeur;
	
	public Ellipse() {
		super();
	}
	
	@Override
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean estDedans(int x, int y) {
		// TODO Auto-generated method stub
		boolean res = false;
		if(rendreCentre().rendreX() + largeur > x) {
			if(rendreCentre().rendreY() + hauteur > y) {
				if(rendreCentre().rendreX() - largeur < x) {
					if(rendreCentre().rendreY() - hauteur < y) {
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
		ArrayList<Point> tmp = new ArrayList<Point>(3);
		if (tab_saisie.size()==3){
			tmp.add(tab_saisie.get(0));
			tmp.add(tab_saisie.get(1));
			largeur = tab_saisie.get(1).distance(tab_saisie.get(0));
			tmp.add(tab_saisie.get(2));
			hauteur = tab_saisie.get(2).distance(tab_saisie.get(0));
		}
		tab_mem = tmp;
	}
	
	public void affiche(Graphics g) {
		g.setColor(this.couleur);
		g.fillOval(rendreCentre().rendreX()-(int)largeur, rendreCentre().rendreY()-(int)hauteur, (int)largeur*2, (int)hauteur*2);
	}
	
}
