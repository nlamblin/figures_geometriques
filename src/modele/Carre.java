package modele;

import java.awt.Graphics;
import java.util.ArrayList;

public class Carre extends Quadrilatere {
	
	public Carre() {
		super();
	}
	
	public int nbClics() {
		return 2;
	}
	
	public int nbPoints(){
		return 4;
	}
	
	@Override
	public void affiche(Graphics g){
		super.affiche(g);
	}
	
	@Override
	public void modifierPoints(ArrayList<Point>  tab_saisie) {
		ArrayList<Point> tmp = new ArrayList<Point>(4);
		System.out.println("Passe ici 1");
		if (tab_saisie.size() > 1){
			System.out.println("Passe ici 2");
			tmp.add(tab_saisie.get(0));
			tmp.add(tab_saisie.get(1));
			System.out.println("Passe ici 3");
			int distanceEntrePointHautGaucheHautDroite = (int)tab_saisie.get(0).distance(tab_saisie.get(1));
			System.out.println("Passe ici 4");
			tmp.add(new Point(tab_saisie.get(1).rendreX(), tab_saisie.get(1).rendreY()+distanceEntrePointHautGaucheHautDroite));
			System.out.println("Passe ici 5");
			tmp.add(new Point(tab_saisie.get(0).rendreX(), tab_saisie.get(2).rendreY()));
			System.out.println("Passe ici 6");
		}
		super.modifierPoints(tmp);
	}
	

}
