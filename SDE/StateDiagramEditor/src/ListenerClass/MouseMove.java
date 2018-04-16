package ListenerClass;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import MVC.viewController;

public class MouseMove implements MouseMotionListener {

	viewController vc;
	
	public MouseMove(viewController c) {
		this.vc = c;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		vc.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
}
