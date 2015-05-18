package figures_geometriques;

public class Point {
	
	private int x, y;
	
	public Point(int x, int y) {
		
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
	
	public void translation(int i, int j) {
		
	}
}
