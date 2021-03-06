package modele;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Trait extends FigureColoree{
	
	/**
	 * constructeur
	 * @param point, point de d�part du trait
	 * @param point2, point d'arriv�e du trait
	 * @param c2, couleur du trait
	 */
	public Trait(Point point, Point point2, Color c2) {
		tab_mem.add(point);
		tab_mem.add(point2);
		changeCouleur(c2);
	}
	
	/**
	 * accesseur du point 1
	 * @return le point de depart
	 */
	public Point getP1() {
		return tab_mem.get(0);
	}
	
	/**
	 * accesseur du point 2
	 * @return le point d'arriv�
	 */
	public Point getP2() {
		return tab_mem.get(1);
	}
	
	@Override
	public void affiche(Graphics g){
		g.setColor(couleur);
		g.drawLine(tab_mem.get(0).rendreX(), tab_mem.get(0).rendreY(), tab_mem.get(1).rendreX(), tab_mem.get(1).rendreY());
	}
	
	@Override
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean estDedans(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void modifierPoints(ArrayList<Point> tab_saisie) {
		tab_mem=tab_saisie;
	}

	public void changeCouleur(Color c) {
		couleur = c;
	}
}
