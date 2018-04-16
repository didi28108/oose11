package Adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MVC.viewController;

public class TransBtnListener implements ActionListener{

	private viewController vc;
	
	public TransBtnListener(viewController c){
		vc = c;
	}
	
	public void actionPerformed(ActionEvent e){
		vc.transBtnClicked(e);
	}
}