package figures_geometriques;

import java.awt.Color;
import java.awt.Graphics;

public abstract class FigureColoree {

	private static final int TAILLE_CARRE_SELECTION = 50;
	private static final int PERIPHERIE_CARRE_SELECTION = 50;
	private boolean selected;
	protected Color couleur;
	protected Point[] tab_mem;
	
	public FigureColoree() {
		selected = false;
		couleur = Color.BLACK;
		tab_mem = new Point[nbPoints()];
	}
	
	public abstract int nbPoints();
	
	public abstract int nbClics();
	
	public abstract boolean estDedans(int x, int y);
	
	public abstract void modifierPoints(Point [] ps);
	
	public void affiche(Graphics g) {
		
	}
	
	public void translation (int dx, int dy) {
		for(int i = 0; i<=tab_mem.length; i++) {
			tab_mem[i].modifierX(dx);
			tab_mem[i].modifierY(dy);
		}
	}
	
	public void transformation(int dx, int dy, int indice) {
		int i = 0;
		while(i <= tab_mem.length) {
			if(i == indice) {
				tab_mem[i].modifierX(dx);
				tab_mem[i].modifierY(dy);
			}
			i++;
		}
	}
	
	public int carreDeSelection(int x, int y) {
		int i = 0;
		boolean arret = false;
		while(i <= tab_mem.length && arret == false) {
			
			
			
			i++;
		}
		return i;
	}
	
	public void selectionne() {
		selected = true;
	}
	
	public void deSelectionne() {
		selected = false;
	}
	
	public void changeCouleur(Color c) {
		couleur = c;
	}
}
