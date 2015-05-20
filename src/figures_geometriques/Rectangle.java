package figures_geometriques;

import java.util.ArrayList;

public class Rectangle extends Quadrilatere {

	public Rectangle() {
		super();
	}
	
	public int nbClics() {
		return 2;
	}
	
	public void modifierPoint(ArrayList<Point>  tab_saisie) {
		ArrayList<Point> tmp = new ArrayList<Point>(4);
		tmp.add(tab_saisie.get(0));
		tmp.add(new Point(tab_saisie.get(0).rendreX(), tab_saisie.get(1).rendreY()));
		tmp.add(tab_saisie.get(1));
		tmp.add(new Point(tab_saisie.get(1).rendreX(), tab_saisie.get(0).rendreY()));
		super.modifierPoints(tmp);
	}
	
	public void transformation(int dx, int dy, int indice) {
		int i = 0;
		while(i <= tab_mem.size()) {
			if(i == indice) {
				tab_mem.get(i).modifierX(dx);
				tab_mem.get(i).modifierY(dy);
			}
			i++;
		}
	}
}
