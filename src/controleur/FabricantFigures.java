package controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.event.MouseInputAdapter;

import vue.DessinFigures;
import modele.FigureColoree;
import modele.Point;

public class FabricantFigures extends MouseInputAdapter{

	private FigureColoree figure_encours_de_fabrication;
	private int nb_cliques;
	private ArrayList<Point> point_cliques;
	
	public FabricantFigures(FigureColoree fc) {
		figure_encours_de_fabrication = fc;
		nb_cliques = 0;
		point_cliques = new ArrayList<Point>(fc.nbClics());
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e){
		if (nb_cliques == figure_encours_de_fabrication.nbClics()){
			((DessinFigures) e.getSource()).ajoute(figure_encours_de_fabrication);
		}
		((DessinFigures) e.getSource()).repaint();
		
	}
	@Override
	public void mousePressed(MouseEvent e){
		if(nb_cliques < figure_encours_de_fabrication.nbClics()){
			point_cliques.add(new Point(e.getX(),e.getY()));
			figure_encours_de_fabrication.modifierPoints(point_cliques);
			nb_cliques++;
		}
		((DessinFigures) e.getSource()).repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e){
		point_cliques.get(point_cliques.size()-1).modifierX(e.getX());
		point_cliques.get(point_cliques.size()-1).modifierY(e.getY());
	}
}
