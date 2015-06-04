package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import modele.FigureColoree;

public class ManipulateurFormes implements MouseListener, MouseMotionListener {

	private int indice, last_x, last_y;
	private boolean trans;
	private ArrayList<FigureColoree> lfg;
	
	public ManipulateurFormes(ArrayList<FigureColoree> fc) {
		lfg = fc;
		trans = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(MouseEvent.BUTTON1 == e.getButton()) {
			last_x = e.getX();
			last_y = e.getY();
			for(int i=0; i<lfg.size(); i++) {
				if(lfg.get(i).estDedans(last_x, last_y)) {
					lfg.get(i).selectionne();
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(MouseEvent.BUTTON1 == e.getButton()) {
			last_x = e.getX();
			last_y = e.getY();
			for(int i=0; i<lfg.size(); i++) {
				if(lfg.get(i))
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
