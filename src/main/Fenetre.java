package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vue.DessinFigures;
import vue.PanneauChoix;

public class Fenetre extends JFrame{
	
	private DessinFigures dessin;

	public Fenetre(String s, int w, int h) {
		setTitle(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		dessin = new DessinFigures();
		jp.setPreferredSize(new Dimension(w,h));
		setContentPane(jp);
		dessin.setPreferredSize(new Dimension(1000,800));
		PanneauChoix pn = new PanneauChoix(dessin);
		pn.setPreferredSize(new Dimension(1000,200));
		pack();
		jp.add(pn);
		jp.add(dessin);
		setVisible(true);
		requestFocusInWindow();
	}
	
	public static void main(String [] args) {
		Fenetre f = new Fenetre("Figure Géométrique", 1000, 1000);
	}
}
