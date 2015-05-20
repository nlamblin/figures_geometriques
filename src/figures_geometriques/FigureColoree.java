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
		int i = 0;
		while (i< tab_mem.length&& tab_mem[i+1]!=null){
			g.drawLine(tab_mem[i].rendreX(), tab_mem[i].rendreY(), tab_mem[i+1].rendreX(), tab_mem[i+1].rendreY());
			i++;
		}
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
		boolean fin = false;
		while(i <= tab_mem.length && arret == false) {
			if(!(x + tab_mem[i].rendreX() <= PERIPHERIE_CARRE_SELECTION) && !(x + tab_mem[i].rendreX() >=PERIPHERIE_CARRE_SELECTION)) {
				if(!(y + tab_mem[i].rendreY() <= PERIPHERIE_CARRE_SELECTION)&&!(y + tab_mem[i].rendreY() >= PERIPHERIE_CARRE_SELECTION))
					fin = true;
			}
			i++;
			if(fin == true) 
				arret = true;
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
