package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controleur.ManipulateurFormes;
import modele.Carre;
import modele.Cercle;
import modele.FigureColoree;
import modele.Losange;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.TraceurForme;
import modele.Triangle;

public class PanneauChoix extends JPanel{

	private FigureColoree fc;
	private DessinFigures dessin;
	
	
	public PanneauChoix(DessinFigures df) {
		dessin = df;
		setBackground(Color.WHITE);
		GridLayout gl =new GridLayout(2,3,20,10);
		setLayout(gl);
		
		final JComboBox jcb= new JComboBox( new String [] {"rouge" ,"vert" ,"bleu","jaune","gris","violet","rose","noir","blanc" });
		jcb.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				fc.changeCouleur(determineCouleur(jcb.getSelectedIndex()));
				dessin.repaint();
			}
		});
		final JComboBox jcbType= new JComboBox( new String [] { "Rectangle","Triangle","Quadrilataire","Carr�","Losange","Cercle" });
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
		add(jcbType);
		add(jcb);
		jrb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED){
					jrb2.setSelected(false);
					jrb3.setSelected(false);
					jcbType.setEnabled(true);
					jcb.setEnabled(true);
				}
				else{
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
					
				}
				else{
					jcb.setEnabled(false);
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
		add(jb);
	}
	
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
			return new Losange();
		case 5 :
			return new Cercle();
		default :
			return null;
		}
	}
	
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
