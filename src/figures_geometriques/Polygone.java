package figures_geometriques;

import java.awt.Graphics;

public abstract class Polygone extends FigureColoree {

	private Polygone p;
	
	public Polygone() {
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean estDedans(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifierPoints(Point[] tab_saisie) {
		// TODO Auto-generated method stub
		tab_mem = tab_saisie;
	}
	
	public void affiche(Graphics g) {
		int i = 0;
		while (i< tab_mem.length&& tab_mem[i+1]!=null){
			g.drawLine(tab_mem[i].rendreX(), tab_mem[i].rendreY(), tab_mem[i+1].rendreX(), tab_mem[i+1].rendreX());
			i++;
		}
		g.drawLine(tab_mem[i].rendreX(),tab_mem[i].rendreY(),tab_mem[0].rendreX(),tab_mem[0].rendreY());
	}
	
}
