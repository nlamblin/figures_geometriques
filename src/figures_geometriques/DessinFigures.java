package figures_geometriques;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DessinFigures extends JPanel{

	private ArrayList<FigureColoree> lfg;
	
	public DessinFigures() {
		lfg = new ArrayList<FigureColoree>();
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	public void ajoute(FigureColoree fg) {
		lfg.add(fg);
	}
	
	public void construit(FigureColoree fg) {
		
	}
}
