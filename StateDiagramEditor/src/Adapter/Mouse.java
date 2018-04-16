package Adapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import MVC.viewController;

public class Mouse implements MouseListener{
	private viewController vc;
	
	public Mouse(viewController c){
		this.vc = c;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		vc.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		vc.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MouseReleased");
		vc.mouseReleased(e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
