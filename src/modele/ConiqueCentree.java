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
	public void modifierPoints(ArrayList<Point> tab_saisie) {
		ArrayList<Point> tmp = new ArrayList<Point>(1);
		if(tab_saisie.size()==1) {
			tmp.add(tab_saisie.get(0));
			tmp.add(new Point(tab_saisie.get(0).rendreX(), tab_saisie.get(0).rendreY()));
		}
		tab_mem=tmp;
	}

	public Point rendreCentre() {
		return tab_mem.get(0);
	}

}
