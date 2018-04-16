package State;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Composite.DiagramElement;
import Composite.StateDiagram;
import Composite.Transition;
import Memento.Caretaker;

/*If you Click the Transition button, change to this state */ 


public class AddTransition extends StateController {
	private static AddTransition instance = null;
	
	private DiagramElement p1; //First Object
	private DiagramElement p2; //Second Object
	private int count = 0;

	public AddTransition() {}
	
	/* lazy Singleton */
	public static AddTransition getInstance() {
		if (instance == null) {
			return new AddTransition();
		}
		return instance;

	}

	public StateController selectBtnClicked() {
		return null;
	}

	public StateController stateBtnClicked(ActionEvent e) {
		return null;
	}

	public StateController transBtnClicked(ActionEvent e) {
		return this;
	}

	public StateController mouseClicked(MouseEvent e, StateDiagram de, Caretaker ct) {
		return this;
	}

	public StateController mouseDragged(MouseEvent e, StateDiagram de) {
		return this;
	}

	public StateController mousePressed(MouseEvent e, StateDiagram de,Caretaker ct) {

		count += 1;
		//When mouse press, get the object  
		System.out.println("trans mouse pressed");

		for (DiagramElement d : de.getComponent()) {
			if (d.contains(e.getPoint())) {
				p1 = d;
				System.out.println("trans:" + p1.getLocation());
				if (p2 == null) {
					p2 = d;
					System.out.println("trans:" + p2.getLocation());
				}
			}
		}
		return this;
	}

	public StateController mouseReleased(MouseEvent e, StateDiagram de, Caretaker ct) {
		
		 /* When the count is 2, add a transition between two state */
		 if (count == 2) {

			System.out.println("trans mouse Released");
			
			/* create a dialog to gather name for transition */
			JFrame setTn = new JFrame();
			String name = JOptionPane.showInputDialog(setTn, "Input the Transition's name: ");
			
			DiagramElement t = new Transition(name, p1, p2);
			
			de.add(t);
			/* When StateDiagram add a component the memento would be created */
			ct.addMemento(de.CreateMemento());
			
			/* Version count */
			de.addVersion();
			de.addCurrentVersion();

			e.getComponent().repaint();
			
			/* Reset the count */
			count = 0;
			
			/* Back to InitState */ 
			return Init.getInstance();
		}
		return this;
	}

	@Override
	public StateController deleteBtnClicked(ActionEvent e) {
		return null;
	}

}
