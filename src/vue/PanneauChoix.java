package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.FigureColoree;
import modele.Rectangle;
import modele.Triangle;

public class PanneauChoix extends JPanel implements Observer{

	private FigureColoree fc;
	private DessinFigures dessin;
	
	public PanneauChoix(DessinFigures df) {
		dessin = df;
		
		final JComboBox jcbType= new JComboBox( new String [] { "Rectangle","Triangle" });
		jcbType.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				fc= creeFigure(jcbType.getSelectedIndex());
				dessin.construit(fc);
			}
		});
		jcbType.setVisible(false);
		
		final JComboBox jcb= new JComboBox( new String [] { "rouge" ,"vert" ,"bleu","jaune","gris","violet","rose","noir","blanc" });
		jcb.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				fc.changeCouleur(determineCouleur(jcb.getSelectedIndex()));
			}
		});
		jcb.setVisible(false);
		final JRadioButton jrb = new JRadioButton("Nouvelle figure");
		add(jrb);
		final JRadioButton jrb2 = new JRadioButton("Tracé à main levée");
		add(jrb2);
		final JRadioButton jrb3 = new JRadioButton("Manipulations");
		add(jrb3);
		add(jcbType);
		add(jcb);
		jrb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED){
					jrb2.setSelected(false);
					jrb3.setSelected(false);
					jcbType.setVisible(true);
					jcb.setVisible(true);
				}
				else{
					jcbType.setVisible(false);
					jcb.setVisible(false);
				}
			}
		});
		jrb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED){
					jrb.setSelected(false);
					jrb3.setSelected(false);
					jcb.setVisible(true);
				}
				else{
					jcb.setVisible(false);
				}
			}
		});
		jrb3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED){
					jrb.setSelected(false);
					jrb2.setSelected(false);
					jcb.setVisible(false);
				}
				else{
					jcb.setVisible(false);
				}
			}
		});
	}
	
	private FigureColoree creeFigure(int i) {
		switch(i){
		case 0 :
			return new Rectangle();
		case 1 : 
			return new Triangle();
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
