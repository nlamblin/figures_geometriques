package figures_geometriques;

import java.awt.Graphics;

public abstract class Polygone extends FigureColoree {

	private Polygone p;
	
	public Polygone() {
		
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean estDedans(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifierPoints(Point[] tab_saisie) {
		// TODO Auto-generated method stub
		tab_saisie = tab_saisie;
	}
	
	public void affiche(Graphics g) {
	
	}
	
}
