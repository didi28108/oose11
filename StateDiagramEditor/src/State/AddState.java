package State;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import Composite.DiagramElement;
import Composite.State;
import Composite.StateDiagram;
import Memento.Caretaker;

/* If you Click the State button, change to this state */ 

public class AddState extends StateController {
	
	private static AddState instance = null;

	public AddState() {}
	
	/* lazy Singleton */
	public static AddState getInstance() {
		
		if (instance == null) {
			return new AddState();
		}
		return instance;
	}

	public StateController selectBtnClicked() {
		return null;
	}

	public StateController stateBtnClicked(ActionEvent e) {
		return this;
	}

	public StateController transBtnClicked(ActionEvent e) {
		return null;
	}

	public StateController mouseClicked(MouseEvent e, StateDiagram de, Caretaker ct) {
		System.out.println(e.getPoint());
		System.out.println("State Clicked Work");
		/* New a State And put it in a ArrayList */
		DiagramElement s = new State("state", e.getPoint(), 35);
		de.add(s);
		
		/* When StateDiagram add a new component the memento would be created */
		ct.addMemento(de.CreateMemento());
		de.addVersion();
		de.addCurrentVersion();
		
		/* Back to InitState */
		return Init.getInstance();
	}

	public StateController mouseDragged(MouseEvent e, StateDiagram sd) {
		return this;
	}

	public StateController mousePressed(MouseEvent e, StateDiagram de,Caretaker ct) {
		return this;
	}

	public StateController mouseReleased(MouseEvent e, StateDiagram sd, Caretaker ct) {
		return this;
	}

	@Override
	public StateController deleteBtnClicked(ActionEvent e) {
		return null;
	}

}
