package modele;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Observable;

public abstract class Polygone extends FigureColoree{

	private Polygon p;
	
	public Polygone() {
		p = new Polygon();
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return p.npoints;
	}

	@Override
	public boolean estDedans(int x, int y) {
		// TODO Auto-generated method stub
		return p.contains(x, y);
	}
	@Override
	public void modifierPoints(ArrayList<Point> tab_saisie) {
		// TODO Auto-generated method stub
		p.reset();
		for (Point pt : tab_saisie){
			p.addPoint(pt.rendreX(),pt.rendreY());
		}
	}
	
	public void affiche(Graphics g) {
		g.setColor(this.couleur);
		g.fillPolygon(p);
	}
	
}
