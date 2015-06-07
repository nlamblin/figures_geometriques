package modele;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public abstract class Polygone extends FigureColoree{

	/**
	 * attribut
	 */
	protected Polygon p;
	
	/**
	 * constructeur
	 */
	public Polygone() {
		p = new Polygon();
	}

	@Override
	public abstract int nbClics();

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
		tab_mem = tab_saisie;
	}
	
	public void affiche(Graphics g) {
		g.setColor(this.couleur);
		g.fillPolygon(p);
	}
	
	public void translation (int dx, int dy) {
		super.translation(dx, dy);
		p.translate(dx, dy);
	}
}
