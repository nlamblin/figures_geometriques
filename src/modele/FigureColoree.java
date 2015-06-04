package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;


public abstract class FigureColoree extends Observable{

	public static final int TAILLE_CARRE_SELECTION = 15;
	public static final int PERIPHERIE_CARRE_SELECTION = 15;
	private boolean selected;
	protected Color couleur;
	protected ArrayList<Point> tab_mem;
	
	
	public FigureColoree() {
		selected = false;
		couleur = Color.BLACK;
		tab_mem = new ArrayList<Point>();
	}
	
	public abstract int nbPoints();
	
	public abstract int nbClics();
	
	public abstract boolean estDedans(int x, int y);
	
	public abstract void modifierPoints(ArrayList<Point> tab_saisie);
	
	public void affiche(Graphics g) {
		int i = 0;
		while (i< tab_mem.size()&& tab_mem.get(i+1)!=null){
			g.drawLine(tab_mem.get(i).rendreX(), tab_mem.get(i).rendreY(), tab_mem.get(i+1).rendreX(), tab_mem.get(i+1).rendreY());
			i++;
		}
	}
	
	public void translation (int dx, int dy) {
		for(Point pt : tab_mem) {
			pt.modifierX(dx);
			pt.modifierY(dy);
		}
	}
	
	public void transformation(int dx, int dy, int indice) {
		tab_mem.get(indice).modifierX(dx);
		tab_mem.get(indice).modifierY(dy);
	}
	
	public int carreDeSelection(int x, int y) {
		int i = 0;
		boolean arret = false;
		boolean fin = false;
		while(i <= tab_mem.size() && arret == false) {
			if(!(x + tab_mem.get(i).rendreX() <= PERIPHERIE_CARRE_SELECTION) && !(x + tab_mem.get(i).rendreX() >=PERIPHERIE_CARRE_SELECTION)) {
				if(!(y + tab_mem.get(i).rendreY() <= PERIPHERIE_CARRE_SELECTION)&&!(y + tab_mem.get(i).rendreY() >= PERIPHERIE_CARRE_SELECTION))
					fin = true;
			}
			else i++;
		}
		return i;
	}
	
	public void selectionne() {
		selected = true;
	}
	
	public void deSelectionne() {
		selected = false;
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	public void changeCouleur(Color c) {
		if (tab_mem.size()!= nbPoints())couleur = c;
	}
	
	public ArrayList<Point> getTab_Mem() {
		return tab_mem;
	}
}
