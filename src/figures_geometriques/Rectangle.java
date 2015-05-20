package figures_geometriques;

public class Rectangle extends Quadrilatere {

	public Rectangle() {
		super();
	}
	
	public int nbClics() {
		return 2;
	}
	
	public void modifierPoint(Point[] tab_saisie) {
		
		super.modifierPoints(tab_saisie);
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
}
