package figures_geometriques;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sun.java2d.loops.DrawLine;

public class FabricantFigures implements MouseListener{

	private FigureColoree figure_encours_de_fabrication;
	private int nb_points;
	private Point[] point_cliques;
	
	public FabricantFigures(FigureColoree fc) {
		figure_encours_de_fabrication = fc;
		nb_points = 0;
		point_cliques = new Point[100];
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
		if(nb_points < 4) {
			// ajoute le clic dans le tableau
			nb_points++;
		}
		
		if(nb_points == 4) {
			// dessiner la figure
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
