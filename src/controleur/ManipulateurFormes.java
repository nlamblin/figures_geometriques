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
		last_x = 0;
		last_y = 0;
		trans = false;
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
			int indiceFigureProche = lfg.get(0).carreDeSelection(last_x, last_y);
			int i = 1;
			while(i < lfg.size()) {
				int nouvelIndice = lfg.get(i).carreDeSelection(last_x, last_y);
				if(nouvelIndice < indiceFigureProche) {
					indiceFigureProche = nouvelIndice;
				}
				i++;
			}
			
			int j = 0;
			while(j < lfg.get(indiceFigureProche).getTab_Mem().size()) {
				// dessiner les carrés dans les coins ( lfg.get(indiceFigureProche).getTab_Mem().get(j) );
				j++;
			}
			lfg.get(indiceFigureProche).selectionne();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(MouseEvent.BUTTON1 == e.getButton()) {
			
			
			trans = false;
		}
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
			
			
			trans = true;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
