package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.effect.Lighting;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controleur.ManipulateurFormes;
import modele.Carre;
import modele.Cercle;
import modele.Ellipse;
import modele.FigureColoree;
import modele.LigneDroite;
import modele.Losange;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.TraceurForme;
import modele.Triangle;

public class PanneauChoix extends JPanel{

	private FigureColoree fc;
	private DessinFigures dessin;
	private TraceurForme tf;
	
	public PanneauChoix(DessinFigures df) {
		dessin = df;
		setBackground(Color.WHITE);
		GridLayout gl =new GridLayout(2,4,100,10);
		setLayout(gl);
		
		final JComboBox jcb= new JComboBox( new String [] {"rouge" ,"vert" ,"bleu","jaune","gris","violet","rose","noir","blanc" });
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
		final JComboBox jcbType= new JComboBox( new String [] { "Rectangle","Triangle","Quadrilataire","Carré","Losange","Cercle", "Ellipse", "Ligne Droite" });
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
		final JRadioButton jrb2 = new JRadioButton("Tracé à main levée");
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
		final JButton boutonEffacer = new JButton("Effacer Tout");
		boutonEffacer.setToolTipText("Cliquez pour effacer tout le dessin.");
		boutonEffacer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<FigureColoree> l = new ArrayList<>();
				dessin.setLFG(l);
				dessin.repaint();
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
		add(boutonEffacer);
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
		case 6 :
			return new Ellipse();
		case 7 :
			return new LigneDroite();
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
