package Adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MVC.viewController;

public class StateBtnListener implements ActionListener{

	private viewController vc;
	
	public StateBtnListener(viewController c){
		vc = c;
	}
	
	public void actionPerformed(ActionEvent e){
		vc.stateBtnClicked(e);
	}
}
