package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Triangle extends Polygone {
	
	public Triangle() {
		super();
	}

	@Override
	public int nbPoints() {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	public int nbClics(){
		return 3;
	}
	
	public void affiche(Graphics g){
		super.affiche(g);
	}
	
	public void modifierPoint(ArrayList<Point>  tab_saisie) {
		ArrayList<Point> tmp = new ArrayList<Point>(3);
		tmp.add(tab_saisie.get(0));
		tmp.add(tab_saisie.get(1));
		tmp.add(tab_saisie.get(2));
		super.modifierPoints(tmp);
	}
}
