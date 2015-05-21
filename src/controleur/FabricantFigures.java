package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import modele.FigureColoree;
import modele.Point;

public class FabricantFigures implements MouseListener{

	private FigureColoree figure_encours_de_fabrication;
	private int nb_points;
	private ArrayList<Point> point_cliques;
	
	public FabricantFigures(FigureColoree fc) {
		figure_encours_de_fabrication = fc;
		nb_points = fc.nbClics();
		point_cliques = new ArrayList<Point>();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Passe ici");
		if(MouseEvent.BUTTON1 == arg0.getButton()) {
			System.out.println("passe à l'interrieur");
			if (nb_points > point_cliques.size()){
				point_cliques.add(new Point(arg0.getX(),arg0.getY()));
				figure_encours_de_fabrication.modifierPoints(point_cliques);
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
