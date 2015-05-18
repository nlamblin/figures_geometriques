package figures_geometriques;

import java.awt.Color;
import java.awt.Graphics;

public abstract class FigureColoree {

	private int TAILLE_CARRE_SELECTION;
	private int PERIPHERIE_CARRE_SELECTION;
	private boolean selected;
	private Color couleur;
	private Point tab_mem;
	
	public FigureColoree() {
		
	}
	
	public abstract int nbPoints();
	
	public abstract int nbClics();
	
	public abstract boolean estDedans(int x, int y);
	
	public abstract void modifierPoints(Point [] ps);
	
	public void affiche(Graphics g) {
		
	}
	
	public 
}
