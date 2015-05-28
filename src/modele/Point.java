package modele;

import java.util.Observable;


public class Point extends Observable{
	
	private int x, y;
	
	public Point(int x2, int y2) {
		x = x2;
		y = y2;
	}
	
	public double distance(Point p2) {
		return Math.sqrt((Math.pow(p2.rendreX()-this.rendreX(),2) + (Math.pow(p2.rendreY()-this.rendreY(),2))));
	}
	
	public int rendreX() {
		return x;
	}
	
	public int rendreY() {
		return y;
	}
	
	public void incrementerX(int incx) {
		x += incx;
		setChanged();
		notifyObservers();
	}
	
	public void incrementerY(int incy) {
		y += incy;
		setChanged();
		notifyObservers();
	}
	
	public void modifierX(int x) {
		this.x = x;
		setChanged();
		notifyObservers();
	}

	public void modifierY(int y) {
		this.y = y;
		setChanged();
		notifyObservers();
	}
	
	public void translation(int dx, int dy) {
		x += dx;
		y += dy;
		setChanged();
		notifyObservers();
	}

}
