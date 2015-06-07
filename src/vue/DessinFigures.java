package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import modele.FigureColoree;
import modele.Point;
import controleur.FabricantFigures;
import controleur.ManipulateurFormes;

public class DessinFigures extends JPanel{

	/**
	 * attributs
	 */
	private ArrayList<FigureColoree> lfg;
	
	/**
	 * constructeur
	 */
	public DessinFigures() {
		super();
		lfg = new ArrayList<FigureColoree>();
		setLayout(new BorderLayout());
		final JButton boutonEffacer = new JButton("Effacer Tout");
		boutonEffacer.setToolTipText("Cliquez pour effacer tout le dessin.");
		boutonEffacer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lfg = new ArrayList<FigureColoree>();
				repaint();
			}
		});
		
		final JButton boutonEffacerFigureSelect = new JButton("Effacer la figure");
		boutonEffacerFigureSelect.setToolTipText("Cliquez pour effacer la figure");
		boutonEffacerFigureSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0; i<lfg.size(); i++) {
					if(lfg.get(i).getSelected()){
						lfg.remove(lfg.get(i));
						repaint();
					}
				}
			}
		});
		
		add(boutonEffacer,BorderLayout.SOUTH);
		add(boutonEffacerFigureSelect, BorderLayout.NORTH);
	}
	
	/**
	 * methode qui redessine toutes les figures du dessin
	 */
	public void paintComponent(Graphics g) {
		g.clearRect(0,0,getWidth(), getHeight());
		for (FigureColoree fg : lfg){
			fg.affiche(g);
			afficherCarreSelection(g);
		}
	}
	
	/**
	 * methode qui ajoute une figure coloree
	 * @param fg, nouvelle figure
	 */
	public void ajoute(FigureColoree fg) {
		lfg.add(fg);
		for (MouseListener ml : getMouseListeners()){
			removeMouseListener(ml);
		}
		repaint();
	}
	
	/**
	 * methode qui construit une figure
	 * @param fg, figure à construire
	 */
	public void construit(FigureColoree fg) {
		FabricantFigures ff = new FabricantFigures(fg);
		this.addMouseListener(ff);
		
	}
	
	/**
	 * methode qui active les manipulations
	 */
	public void activeManipulationsSouris(){
		enleverTousLesListeners();
		ManipulateurFormes mf=new ManipulateurFormes(lfg);
		addMouseListener(mf);
		addMouseMotionListener(mf);
	}
	
	/**
	 * methode qui desactive les manipulations
	 */
	public void desactiverManipulationsSouris(){
		enleverTousLesListeners();
		for (FigureColoree fg : lfg){
			fg.deSelectionne();
		}
		repaint();
	}
	
	/**
	 * accesseur de l'attributs lfg
	 * @return lfg
	 */
	public ArrayList<FigureColoree> getFigures(){
		return lfg;
	}
	
	/**
	 * mehtode qui affiche les carres de selection
	 * @param g, environnement graphique
	 */
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
	
	/**
	 * methode qui permet de retirer tous les listeners
	 */
	public void enleverTousLesListeners(){
		for (MouseListener ml : getMouseListeners()){
			removeMouseListener(ml);
		}
		for (MouseMotionListener mml : getMouseMotionListeners()){
			removeMouseMotionListener(mml);
		}
	}
	
	/**
	 * methode qui modifie la liste
	 * @param l, nouvelle liste
	 */
	public void setLFG(ArrayList<FigureColoree> l) {
		lfg = l;
	}
}