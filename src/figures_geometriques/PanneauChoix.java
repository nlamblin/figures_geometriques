package figures_geometriques;

import java.awt.Color;

import javax.swing.JPanel;

public class PanneauChoix extends JPanel{

	private FigureColoree fc;
	private DessinFigures dessin;
	
	public PanneauChoix(DessinFigures df) {
		dessin = df;
	}
	
	public FigureColoree creeFigure(int i) {
		return null;
	}
	
	public Color determineCouleur(int i) {
		return null;
	}
	
}
