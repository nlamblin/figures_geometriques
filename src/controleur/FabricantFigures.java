package controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.event.MouseInputAdapter;

import vue.DessinFigures;
import modele.FigureColoree;
import modele.Point;

public class FabricantFigures extends MouseInputAdapter{

	private FigureColoree figure_encours_de_fabrication;
	private int nb_points;
	private ArrayList<Point> point_cliques;
	
	public FabricantFigures(FigureColoree fc) {
		figure_encours_de_fabrication = fc;
		nb_points = 0;
		point_cliques = new ArrayList<Point>(fc.nbClics());
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e){
		if(nb_points < figure_encours_de_fabrication.nbClics()){
			point_cliques.add(new Point(e.getX(),e.getY()));
			figure_encours_de_fabrication.modifierPoints(point_cliques);
			nb_points++;
		}
		((DessinFigures) e.getSource()).repaint();
		if (nb_points == figure_encours_de_fabrication.nbClics()){
			((DessinFigures) e.getSource()).ajoute(figure_encours_de_fabrication);
			((DessinFigures) e.getSource()).removeMouseListener(this);
		}
		
	}
}
