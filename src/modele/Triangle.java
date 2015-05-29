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
	
	public int nbClics(){
		return 3;
	}
	
	public void affiche(Graphics g){
		g.setColor(Color.black);
		super.affiche(g);
	}
	public void modifierPoint(ArrayList<Point>  tab_saisie) {
		ArrayList<Point> tmp = new ArrayList<Point>(4);
		tmp.add(tab_saisie.get(0));
		tmp.add(new Point(tab_saisie.get(0).rendreX(), tab_saisie.get(1).rendreY()));
		tmp.add(tab_saisie.get(1));
		tmp.add(new Point(tab_saisie.get(1).rendreX(), tab_saisie.get(0).rendreY()));
		super.modifierPoints(tmp);
	}
}
