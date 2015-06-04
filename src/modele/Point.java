package modele;

import java.util.Observable;


public class Point{
	
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
	}
	
	public void incrementerY(int incy) {
		y += incy;
	}
	
	public void modifierX(int x) {
		this.x = x;
	}

	public void modifierY(int y) {
		this.y = y;
	}
	
	public void translation(int dx, int dy) {
		x += dx;
		y += dy;
	}

}
