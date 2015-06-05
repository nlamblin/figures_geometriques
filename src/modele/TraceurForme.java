package modele;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import vue.DessinFigures;

public class TraceurForme implements MouseListener, MouseMotionListener{
	private Color c = Color.BLACK;
	private int lastX,lastY,x1,y1;
	private boolean dessiner = false;
	private ArrayList<Trait> lTraits;
	private DessinFigures ds;
	public TraceurForme(DessinFigures ds) {
		this.ds=ds;
		ds.addMouseListener(this);
		ds.addMouseMotionListener(this);
	}
	public void setColor(Color c){
		this.c = c;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if (dessiner){
			ds.getFigures().add(new Trait(new Point(e.getX(),e.getY()),new Point(x1,y1),c));
			lastX=x1;
			lastY=y1;
			x1 = e.getX();
			y1 = e.getY();
			ds.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton()==MouseEvent.BUTTON1){
			x1=e.getX();
			y1=e.getY();
			lastX = x1;
			lastY = y1;
			dessiner = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton()==MouseEvent.BUTTON1)dessiner = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
