package figures_geometriques;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	private DessinFigures dessin;

	public Fenetre(String s, int w, int h) {
		setTitle(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dessin = new DessinFigures();
		dessin.setSize(w,h);
		setContentPane(dessin);
		pack();
		setVisible(true);
		requestFocusInWindow();
	}
	
	public static void main(String [] args) {
		
	}
}
