package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class ConiqueCentree extends FigureColoree {

	protected Point centre;
	
	public ConiqueCentree() {
		// TODO Auto-generated constructor stub
		centre = new Point(0,0);
	}
	
	@Override
	public abstract int nbPoints();

	@Override
	public abstract int nbClics();

	@Override
	public abstract boolean estDedans(int x, int y);

	@Override
	public void modifierPoints(ArrayList<Point> tab_saisie) {
		
	}

	public Point rendreCentre() {
		return centre;
	}

}
