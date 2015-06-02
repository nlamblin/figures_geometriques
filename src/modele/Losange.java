package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Losange extends Quadrilatere {
	
	public Losange(){
		super();
	}
	
	public int nbClics() {
		return 3;
	}
	
	@Override
	public void affiche(Graphics g){
		super.affiche(g);
	}
	
	@Override
	public void modifierPoints(ArrayList<Point>  tab_saisie) {
		// à faire !!!
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
