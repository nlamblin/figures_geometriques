package figures_geometriques;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	private DessinFigures dessin;

	public Fenetre(String s, int w, int h) {
		setTitle(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		dessin = new DessinFigures();
		jp.setPreferredSize(new Dimension(w,h));
		setContentPane(jp);
		pack();
		jp.add(new PanneauChoix(dessin));
		jp.add(dessin);
		setVisible(true);
		requestFocusInWindow();
	}
	
	public static void main(String [] args) {
		Fenetre f = new Fenetre("Figure Géométrique", 1000, 1000);
	}
}
