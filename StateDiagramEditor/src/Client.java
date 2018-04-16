import MVC.InitView;
import MVC.InitViewController;

public class Client {
	public static void main(String[] args) {
		/*
		 * New a IninView to display a form that has two button 
		 * So that You can use different color of background
		 */
		InitView iv = new InitView();
		new InitViewController(iv);
		iv.frame.setVisible(true);
	}

}
