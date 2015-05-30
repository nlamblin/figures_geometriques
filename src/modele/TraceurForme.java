package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TraceurForme implements MouseListener, MouseMotionListener{

	private Graphics g;
	private int last_x, last_y;
	
	public TraceurForme(Graphics gr) {
		g = gr;
		last_x = 0;
		last_y = 0;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(MouseEvent.BUTTON1 == e.getButton()) {
			g.drawLine(last_x, last_y, e.getX(), e.getY());
			last_x = e.getX();
			last_y = e.getY();
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
		// TODO Auto-generated method stub
		if(MouseEvent.BUTTON1 == e.getButton()) {
			last_x = e.getX();
			last_y = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
