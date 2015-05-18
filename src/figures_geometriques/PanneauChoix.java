package figures_geometriques;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanneauChoix extends JPanel{

	private FigureColoree fc;
	private DessinFigures dessin;
	
	private Color c;
	
	public PanneauChoix(DessinFigures df) {
		dessin = df;
		
		final JComboBox jcbType= new JComboBox( new String [] { "Rectangle","Triangle" });
		jcbType.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				switch (jcbType.getSelectedIndex ()) {
				case 0 :
					c= Color.RED ;
					break ;
				case 1 :
					c = Color.GREEN ;
					break ;
				case 2 :
					c = Color.BLUE ;
					break ;
				case 3 :
					c = Color.YELLOW ;
					break ;
				case 4 :
					c = Color.GRAY;
					break;
				case 5 :
					c = Color.MAGENTA;
					break;
				case 6 :
					c = Color.PINK;
					break;
				case 7 :
					c = Color.BLACK;
					break;
				case 8 :
					c = Color.WHITE;
					break;
				}
			}
		});
		jcbType.setVisible(false);
		add(jcbType);
		final JComboBox jcb= new JComboBox( new String [] { "rouge" ,"vert" ,"bleu","jaune","gris","violet","rose","noir","blanc" });
		jcb.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				switch (jcb.getSelectedIndex ()) {
				case 0 :
					c= Color.RED ;
					break ;
				case 1 :
					c = Color.GREEN ;
					break ;
				case 2 :
					c = Color.BLUE ;
					break ;
				case 3 :
					c = Color.YELLOW ;
					break ;
				case 4 :
					c = Color.GRAY;
					break;
				case 5 :
					c = Color.MAGENTA;
					break;
				case 6 :
					c = Color.PINK;
					break;
				case 7 :
					c = Color.BLACK;
					break;
				case 8 :
					c = Color.WHITE;
					break;
				}
			}
		});
		jcb.setVisible(false);
		add(jcb);
		final JRadioButton jrb = new JRadioButton("Nouvelle figure");
		add(jrb);
		final JRadioButton jrb2 = new JRadioButton("Tracé à main levée");
		add(jrb2);
		jrb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED){
					jrb2.setSelected(false);
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
					jcb.setVisible(true);
				}
				else{
					jcb.setVisible(false);
				}
			}
		});
	}
	
	public FigureColoree creeFigure(int i) {
		return null;
	}
	
	public Color determineCouleur(int i) {
		return null;
	}
	
}
