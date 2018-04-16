package ListenerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MVC.viewController;

public class DelBtnListener implements ActionListener{
	private viewController vc;
	public DelBtnListener(viewController c){
		this.vc = c;
	}
	
	public void actionPerformed(ActionEvent e){
		vc.deleteBtnClicked(e);
	}
}
