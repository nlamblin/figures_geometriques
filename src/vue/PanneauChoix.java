package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.Carre;
import modele.Cercle;
import modele.FigureColoree;
import modele.LigneDroite;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.TraceurForme;
import modele.Triangle;

public class PanneauChoix extends JPanel{

	/**
	 * attributs
	 */
	private FigureColoree fc;
	private DessinFigures dessin;
	private TraceurForme tf;
	
	/**
	 * constructeur de PanneauxChoix
	 * @param df, repr�sente la zone de dessin associ�e au PanneauChoix
	 */
	public PanneauChoix(DessinFigures df) {
		dessin = df;
		setBackground(Color.WHITE);
		GridLayout gl =new GridLayout(2,4,100,10);
		setLayout(gl);
		
		final JComboBox jcb= new JComboBox( new String [] {"rouge" ,"vert" ,"bleu","jaune","gris","violet","rose","noir","blanc" });
		jcb.setToolTipText("Choisissez la couleur de la figure");
		
		final JPanel jp = new JPanel();
		jp.setBackground(determineCouleur(jcb.getSelectedIndex()));
		jp.setPreferredSize(new Dimension(25,25));
		jcb.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				fc.changeCouleur(determineCouleur(jcb.getSelectedIndex()));
				jp.setBackground(determineCouleur(jcb.getSelectedIndex()));
				if (tf!=null){
					tf.setColor(determineCouleur(jcb.getSelectedIndex()));
				}
				dessin.repaint();
			}
		});
		
		final JComboBox jcbType= new JComboBox( new String [] { "Rectangle","Triangle","Quadrilataire","Carr�","Cercle", "Ligne droite" });
		jcbType.setToolTipText("Choisissez la figure � r�aliser");
		fc= creeFigure(jcbType.getSelectedIndex());
		jcbType.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				if (e.getModifiers()!=0){
					fc= creeFigure(jcbType.getSelectedIndex());
					fc.changeCouleur(determineCouleur(jcb.getSelectedIndex()));
				}
			}
		});
		
		jcbType.setEnabled(false);
		jcb.setEnabled(false);
		
		final JRadioButton jrb = new JRadioButton("Nouvelle figure");
		jrb.setBackground(Color.WHITE);
		add(jrb);
		
		final JRadioButton jrb2 = new JRadioButton("Trac� � main lev�e");
		jrb2.setBackground(Color.WHITE);
		add(jrb2);
		
		final JRadioButton jrb3 = new JRadioButton("Manipulations");
		jrb3.setBackground(Color.WHITE);
		
		final JButton jb = new JButton("Construire");
		jb.setToolTipText("Cliquez pour construire puis tracez vos points.");
		jb.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				if (e.getModifiers()!=0){
					fc= creeFigure(jcbType.getSelectedIndex());
					fc.changeCouleur(determineCouleur(jcb.getSelectedIndex()));
					dessin.construit(fc);
					dessin.repaint();
				}
			}
		});
		
		add(jrb3);
		
		JPanel p = new JPanel();
		p.setVisible(false);
		
		add(p);
		add(jcbType);
		add(jcb);
		
		jb.setEnabled(false);
		
		jrb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED){
					jrb2.setSelected(false);
					jrb3.setSelected(false);
					jcbType.setEnabled(true);
					jcb.setEnabled(true);
					jb.setEnabled(true);
				}
				else{
					jb.setEnabled(false);
					jcbType.setEnabled(false);
					jcb.setEnabled(false);
				}
			}
		});
		
		jrb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED){
					jrb.setSelected(false);
					jrb3.setSelected(false);
					jcb.setEnabled(true);
					tf = new TraceurForme(dessin);
					tf.setColor(determineCouleur(jcb.getSelectedIndex()));
					fc= creeFigure(jcbType.getSelectedIndex());
					
				}
				else{
					jcb.setEnabled(false);
					tf=null;
					dessin.enleverTousLesListeners();
				}
			}
		});
		
		jrb3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED){
					jrb.setSelected(false);
					jrb2.setSelected(false);
					jcb.setEnabled(false);
					dessin.activeManipulationsSouris();
				}
				else{
					jcb.setEnabled(false);
					dessin.desactiverManipulationsSouris();
				}
			}
		});
		
		add(jp);
		add(jb);
	}
	
	/**
	 * Methode qui permet de cr�er une figure
	 * @param i, indice de la figure choisie dans la liste
	 * @return, cr�� la figure
	 */
	private FigureColoree creeFigure(int i) {
		switch(i){
		case 0 :
			return new Rectangle();
		case 1 : 
			return new Triangle();
		case 2 :
			return new Quadrilatere();
		case 3 :
			return new Carre();
		case 4 :
			return new Cercle();
		case 5 :
			return new LigneDroite();
		default :
			return null;
		}
	}
	
	/**
	 * Methode qui permet de determiner la couleur d'une figure
	 * @param i, indice de la couleur choisie dans la liste
	 * @return la couleur choisie
	 */
	private Color determineCouleur(int i) {
		switch (i) {
		case 0 :
			return Color.RED ;
		case 1 :
			return Color.GREEN ;
		case 2 :
			return Color.BLUE ;
		case 3 :
			return Color.YELLOW ;
		case 4 :
			return Color.GRAY;
		case 5 :
			return Color.MAGENTA;
		case 6 :
			return Color.PINK;
		case 7 :
			return Color.BLACK;
		case 8 :
			return Color.WHITE;
		default :
			return null;
		}
	}

}
