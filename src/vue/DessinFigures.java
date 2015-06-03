package vue;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.FigureColoree;
import controleur.FabricantFigures;
import controleur.ManipulateurFormes;

public class DessinFigures extends JPanel{

	private ArrayList<FigureColoree> lfg;
	
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
		for (MouseListener ml : getMouseListeners()){
			removeMouseListener(ml);
		}
		repaint();
	}
	
	public void construit(FigureColoree fg) {
		FabricantFigures ff = new FabricantFigures(fg);
		this.addMouseListener(ff);
	}
	public void activeManipulationsSouris(){
		ManipulateurFormes mf=new ManipulateurFormes(lfg);
		addMouseListener(mf);
		addMouseMotionListener(mf);
	}
	public void desactiverManipulationsSouris(){
		for (MouseListener ml : getMouseListeners()){
			removeMouseListener(ml);
		}
		for (MouseMotionListener mml : getMouseMotionListeners()){
			removeMouseMotionListener(mml);
		}
	}
}