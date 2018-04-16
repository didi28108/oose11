package State;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import Composite.DiagramElement;
import Composite.StateDiagram;
import Memento.Caretaker;

/* If you click the delete button, change to this state */ 

public class TransSourceSelected extends StateController{

	private static TransSourceSelected instance = null;
    
	public TransSourceSelected() {}
	
	/* lazy Singleton */
	public static TransSourceSelected getInstance(){
		if (instance == null) {
			return new TransSourceSelected();
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
		return null;
	}

	@Override
	public StateController deleteBtnClicked(ActionEvent e) {
		return this;
	}

	public StateController mouseClicked(MouseEvent e, StateDiagram de, Caretaker ct) {
		return Init.getInstance();
	}

	public StateController mouseDragged(MouseEvent e, StateDiagram de) {
		return this;
	}

	public StateController mousePressed(MouseEvent e, StateDiagram de,Caretaker ct) {
		System.out.println("TranSourceSelected Mouse Clicked!!!");
		for (DiagramElement d : de.getComponent()) {
			if(d.contains(e.getPoint())){
				de.remove(d);
				/* When StateDiagram add a component the memento would be created */
				ct.addMemento(de.CreateMemento()); 
				/* Version count */
				de.addVersion();
				de.addCurrentVersion();
				
			}
		}
		return this;
	}

	public StateController mouseReleased(MouseEvent e, StateDiagram de, Caretaker ct) {
		return this;
	}

}
