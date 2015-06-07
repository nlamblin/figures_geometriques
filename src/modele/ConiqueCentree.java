package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class ConiqueCentree extends FigureColoree {

	/**
	 * constructeur
	 */
	public ConiqueCentree() {
		super();
	}
	
	@Override
	public abstract int nbPoints();

	@Override
	public abstract int nbClics();

	@Override
	public abstract boolean estDedans(int x, int y);

	@Override
	public abstract void modifierPoints(ArrayList<Point> tab_saisie);

	/**
	 * retourne le centre de la figure (le premier poitn cliqué)
	 * @return le centre
	 */
	public Point rendreCentre() {
		return tab_mem.get(0);
	}

}
