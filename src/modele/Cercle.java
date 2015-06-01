package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cercle extends FigureColoree {
	
	private Cercle c;
	
	public Cercle() {
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
		return false;
	}

	@Override
	public void modifierPoints(ArrayList<Point> tab_saisie) {
		// TODO Auto-generated method stub
		
		// a completer !!!!
	}
	
	public void affiche(Graphics g) {
		g.setColor(this.couleur);
		g.drawOval(tab_mem.get(0).rendreX(), tab_mem.get(0).rendreY(), 50, 50);
	}

}
