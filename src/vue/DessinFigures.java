package vue;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.FigureColoree;
import controleur.FabricantFigures;
import controleur.ManipulateurFormes;

public class DessinFigures extends JPanel{

	private ArrayList<FigureColoree> lfg;
	private ManipulateurFormes mf;
	
	public DessinFigures() {
		super();
		lfg = new ArrayList<FigureColoree>();
	}
	
	public void paintComponent(Graphics g) {
		g.clearRect(0,0,getWidth(), getHeight());
		for (FigureColoree fg : lfg){
			fg.affiche(g);
		}
	}
	
	public void ajoute(FigureColoree fg) {
		lfg.add(fg);
		repaint();
	}
	
	public void construit(FigureColoree fg) {
		FabricantFigures ff = new FabricantFigures(fg);
		this.addMouseListener(ff);
	}
	public void activeManipulationsSouris(){
		mf = new ManipulateurFormes(lfg);
	}
}