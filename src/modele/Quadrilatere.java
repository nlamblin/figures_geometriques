package modele;

import java.awt.Graphics;
import java.util.ArrayList;


public class Quadrilatere extends Polygone {

	public Quadrilatere() {
		super();
	}
	
	@Override
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int nbClics() {
		// TODO Auto-generated method stub
		return 4;
	}
	@Override
	public void modifierPoints(ArrayList<Point>  tab_saisie) {
		ArrayList<Point> tmp = new ArrayList<Point>(4);
		if (tab_saisie.size()>=1)tmp.add(tab_saisie.get(0));
		if (tab_saisie.size()>=2)tmp.add(tab_saisie.get(1));
		if (tab_saisie.size()>=3)tmp.add(tab_saisie.get(2));
		if (tab_saisie.size()==4)tmp.add(tab_saisie.get(3));
		super.modifierPoints(tmp);
	}
	public void affiche(Graphics g){
		super.affiche(g);
	}
}
