package vue;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.FigureColoree;
import controleur.FabricantFigures;

public class DessinFigures extends JPanel implements Observer{

	private ArrayList<FigureColoree> lfg;
	
	public DessinFigures() {
		lfg = new ArrayList<FigureColoree>();
	}
	
	public void paintComponent(Graphics g) {
		for (FigureColoree fg : lfg){
			fg.affiche(g);
		}
	}
	
	public void ajoute(FigureColoree fg) {
		lfg.add(fg);
		removeMouseListener(getMouseListeners()[0]);
	}
	
	public void construit(FigureColoree fg) {
		FabricantFigures ff = new FabricantFigures(fg);
		addMouseListener(ff);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
