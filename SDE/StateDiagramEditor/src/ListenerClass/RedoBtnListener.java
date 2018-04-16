package ListenerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MVC.viewController;

public class RedoBtnListener implements ActionListener{

	private viewController vc;
	
	public RedoBtnListener(viewController c){
		vc = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		vc.redoBtnClicked(e);
	}
}
