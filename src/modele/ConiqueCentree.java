package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class ConiqueCentree extends FigureColoree {

	
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

	public Point rendreCentre() {
		return tab_mem.get(0);
	}

}
