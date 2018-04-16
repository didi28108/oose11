package ListenerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MVC.viewController;

public class UndoBtnListener implements ActionListener{

	private viewController vc;
	
	public UndoBtnListener(viewController c){
		this.vc = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		vc.undoBtnClicked(e);
	}
}
