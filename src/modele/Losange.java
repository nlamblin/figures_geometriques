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
		ArrayList<Point> tmp = new ArrayList<Point>(4);
		if(tab_saisie.size() == 3) {
			tmp.add(tab_saisie.get(1));
		}
		
		
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
