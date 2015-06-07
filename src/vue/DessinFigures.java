package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.FigureColoree;
import modele.Point;
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
			afficherCarreSelection(g);
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
		enleverTousLesListeners();
		ManipulateurFormes mf=new ManipulateurFormes(lfg);
		addMouseListener(mf);
		addMouseMotionListener(mf);
	}
	public void desactiverManipulationsSouris(){
		enleverTousLesListeners();
		for (FigureColoree fg : lfg){
			fg.deSelectionne();
		}
		repaint();
	}
	public ArrayList<FigureColoree> getFigures(){
		return lfg;
	}
	public void afficherCarreSelection(Graphics g){
		g.setColor(Color.black);
		for (FigureColoree fg : lfg){
			if (fg.getSelected()){
				for (Point p : fg.getTab_Mem()){
					g.fillRect(p.rendreX()-FigureColoree.TAILLE_CARRE_SELECTION/2, p.rendreY()-FigureColoree.TAILLE_CARRE_SELECTION/2,FigureColoree.TAILLE_CARRE_SELECTION, FigureColoree.TAILLE_CARRE_SELECTION);
				}
			}
		}
	}
	public void enleverTousLesListeners(){
		for (MouseListener ml : getMouseListeners()){
			removeMouseListener(ml);
		}
		for (MouseMotionListener mml : getMouseMotionListeners()){
			removeMouseMotionListener(mml);
		}
	}

	public ArrayList<FigureColoree> getLFG() {
		// TODO Auto-generated method stub
		return lfg;
	}
	
	public void setLFG(ArrayList<FigureColoree> l) {
		lfg = l;
	}
}