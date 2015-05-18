package figures_geometriques;

public class Point {
	
	private int x, y;
	
	public Point(int x2, int y2) {
		x = x2;
		y = y2;
	}
	
	public double distance(Point p) {
		return 0;
	}
	
	public int rendreX() {
		return x;
	}
	
	public int rendreY() {
		return y;
	}
	
	public void incrementerX(int x2) {
		x += x2;
	}
	
	public void incrementerY(int y2) {
		y += y2;
	}
	
	public void modifierX(int x2) {
		x = x2;
	}

	public void modifierY(int y2) {
		y = y2;
	}
	
	public void translation(int x2, int y2) {
		
	}
}
