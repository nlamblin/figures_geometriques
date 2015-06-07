package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		jp.setLayout(new BorderLayout());
		PanneauChoix pn = new PanneauChoix(dessin);
		pack();
		jp.add(pn,BorderLayout.NORTH);
		jp.add(dessin,BorderLayout.CENTER);
		setVisible(true);
		requestFocusInWindow();
	}
	
	public static void main(String [] args) {
		Fenetre f = new Fenetre("Figure Géométrique", 1000, 1000);
	}
}
