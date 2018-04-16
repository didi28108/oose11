package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Composite.StateDiagram;
import Memento.Caretaker;
import State.StateController;
import State.Init;



public class InitViewController {
	private InitView initview;
	
	public InitViewController(InitView iv){
		initview = iv;
		
		this.initview.addv1Listener(new V1Listener());
		this.initview.addv2Listener(new V2Listener());
	}
	
	class V1Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("Style1 Btn Clicked!");
			/* New a Memento Caretaker */
			Caretaker caretaker = new Caretaker();
			/* Set View's background to white  */
			View v = new View("white");
			/* New a initial State */
			StateController cs = new Init();
			new viewController(v,cs,new StateDiagram("root"),caretaker);
			initview.frame.setVisible(false);
			v.setVisible(true);
		}
	}
	class V2Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("Style2 Btn Clicked!");
			/* New a Memento Caretaker */
			Caretaker caretaker = new Caretaker();
			/* Set View's background to gray  */
			View v = new View("gray");
			/* New a initial State */
			StateController cs = new Init();//new a initial state for state diagram editor
			new viewController(v,cs,new StateDiagram("root"),caretaker);
			initview.frame.setVisible(false);
			v.setVisible(true);
		}
	}

}
