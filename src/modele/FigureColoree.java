package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;


public abstract class FigureColoree extends Observable{

	/**
	 * attributs
	 */
	public static final int TAILLE_CARRE_SELECTION = 15;
	public static final int PERIPHERIE_CARRE_SELECTION = 15;
	private boolean selected;
	protected Color couleur;
	protected ArrayList<Point> tab_mem;
	
	/**
	 * constructeur
	 */
	public FigureColoree() {
		selected = false;
		couleur = Color.BLACK;
		tab_mem = new ArrayList<Point>();
	}
	
	/**
	 * Mehtode abstraite donnant le nombre de point necessaire à la conception d'une figure
	 * @return le nombre de points necessaire à la construction
	 */
	public abstract int nbPoints();
	
	/**
	 * methode abstraite donnant le nombre de clics necessaie à la conception d'une figure
	 * @return le nombre de clics necessaire pour la construction
	 */
	public abstract int nbClics();
	
	/**
	 * Cette methode qui dit si les coordonnees sont passees en parametre se trouve à l'interieur de la figure.
	 * @param x, abcisse
	 * @param y, ordonnées
	 * @return vrai si les coordonnes en parametres sont dans la figure
	 */
	public abstract boolean estDedans(int x, int y);
	
	/**
	 * methode qui permet de modifier les points d'une figure
	 * @param tab_saisie, Point de la figure
	 */
	public abstract void modifierPoints(ArrayList<Point> tab_saisie);
	
	/**
	 * methode qui permet de dessiner la figure
	 * @param g, environnement graphique
	 */
	public void affiche(Graphics g) {
		int i = 0;
		while (i< tab_mem.size()&& tab_mem.get(i+1)!=null){
			g.drawLine(tab_mem.get(i).rendreX(), tab_mem.get(i).rendreY(), tab_mem.get(i+1).rendreX(), tab_mem.get(i+1).rendreY());
			i++;
		}
	}
	
	/**
	 * methode qui permet à aux points de se déplacer
	 * @param dx, nouvelle coordonée abcisse
	 * @param dy, nouvelle coordonée ordonnée
	 */
	public void translation (int dx, int dy) {
		for(Point pt : tab_mem) {
			pt.incrementerX(dx);
			pt.incrementerY(dy);
		}
	}
	
	/**
	 * methode qui permet à un point de se déplacer
	 * @param dx, nouvelle coordonnées abcisse
	 * @param dy, nouvelle coordonées ordonée
	 * @param indice, indice du point dans le tableau de memorisation des points
	 */
	public void transformation(int dx, int dy, int indice) {
		tab_mem.get(indice).modifierX(dx);
		tab_mem.get(indice).modifierY(dy);
	}
	
	/**
	 * Methode qui detecte un point se trouvant à proximité d'un carré de selection
	 * @param x, abcisse d'un clic
	 * @param y, ordonée d'un clic
	 * @return le point
	 */
	public int carreDeSelection(int x, int y) {
		int i = 0, j = -1;
		boolean arret = false;
		boolean fin = false;
		while(i <= tab_mem.size() && arret == false) {
			if(!(x + tab_mem.get(i).rendreX() <= PERIPHERIE_CARRE_SELECTION) && !(x + tab_mem.get(i).rendreX() >=PERIPHERIE_CARRE_SELECTION)) {
				if(!(y + tab_mem.get(i).rendreY() <= PERIPHERIE_CARRE_SELECTION)&&!(y + tab_mem.get(i).rendreY() >= PERIPHERIE_CARRE_SELECTION)) {
					fin = true;
					j = i;
				}
			}
			else i++;
		}
		return j;
	}
	
	/**
	 * methode qui selectionne une figure
	 */
	public void selectionne() {
		selected = true;
	}
	
	/**
	 * une methode qui deselectionne une figure
	 */
	public void deSelectionne() {
		selected = false;
	}
	
	/**
	 * accesseur de selected qui dit si une figure est selectionnée
	 * @return
	 */
	public boolean getSelected() {
		return selected;
	}
	
	/**
	 * methode qui chage la couleur de la figure
	 * @param c, nouvelle couleur
	 */
	public void changeCouleur(Color c) {
		if (tab_mem.size()!= nbPoints())couleur = c;
	}
	
	/**
	 * accesseur de l'attribut tab_mem
	 * @return, la liste
	 */
	public ArrayList<Point> getTab_Mem() {
		return tab_mem;
	}
}
