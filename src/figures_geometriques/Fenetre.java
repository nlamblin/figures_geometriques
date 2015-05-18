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
		jp.setSize(w,h);
		jp.add(new PanneauChoix(dessin));
		jp.add(dessin);
		setContentPane(jp);
		pack();
		setVisible(true);
		requestFocusInWindow();
	}
	
	public static void main(String [] args) {
		
	}
}
