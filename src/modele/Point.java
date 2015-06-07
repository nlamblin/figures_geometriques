package modele;

import java.util.Observable;


public class Point{
	
	/**
	 * attributs
	 */
	private int x, y;
	
	/**
	 * constructeur
	 * @param x2, coordonnees de l'abcisse
	 * @param y2, coordonnees de l'ordonées
	 */
	public Point(int x2, int y2) {
		x = x2;
		y = y2;
	}
	
	/**
	 * methode qui permet de calculer la distance entre deux points
	 * @param p2, deuxieme point
	 * @return la distance
	 */
	public double distance(Point p2) {
		return Math.sqrt((Math.pow(p2.rendreX()-this.rendreX(),2) + (Math.pow(p2.rendreY()-this.rendreY(),2))));
	}
	
	/**
	 * accesseur de x
	 * @return x
	 */
	public int rendreX() {
		return x;
	}
	
	/**
	 * accesseur de y
	 * @return y
	 */
	public int rendreY() {
		return y;
	}
	
	/**
	 * methode qui incremente x
	 * @param incx, valeur ajoutée à x
	 */
	public void incrementerX(int incx) {
		x += incx;
	}
	
	/**
	 * methode qui incremente y
	 * @param incy, valeur ajoutée à y
	 */
	public void incrementerY(int incy) {
		y += incy;
	}
	
	/**
	 * methode qui modifie x
	 * @param x, nouvel x
	 */
	public void modifierX(int x) {
		this.x = x;
	}

	/**
	 * methode qui modifie y
	 * @param y, nouvel y
	 */
	public void modifierY(int y) {
		this.y = y;
	}
	
	/**
	 * methode qui incremente x et y
	 * @param dx, valeur ajoutée à x
	 * @param dy, valeur ajoutée à y
	 */
	public void translation(int dx, int dy) {
		x += dx;
		y += dy;
	}

}
