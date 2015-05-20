package figures_geometriques;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DessinFigures extends JPanel{

	private ArrayList<FigureColoree> lfg;
	FabricantFigures ff;
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
		removeMouseListener(ff);
		ff = null;
	}
	
	public void construit(FigureColoree fg) {
		ff = new FabricantFigures(fg);
		addMouseListener(ff);
	}
}
