package State;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import Composite.StateDiagram;
import Memento.Caretaker;

public abstract class StateController{
	
	public StateController(){}
	
	public StateController selectBtnClicked(){
		return Init.getInstance();
	}
	
	public abstract StateController stateBtnClicked(ActionEvent e);
	public abstract StateController transBtnClicked(ActionEvent e);
	public abstract StateController deleteBtnClicked(ActionEvent e);
	public abstract StateController mouseClicked(MouseEvent e,StateDiagram de,Caretaker ct);
	public abstract StateController mouseDragged(MouseEvent e,StateDiagram de);
	public abstract StateController mousePressed(MouseEvent e,StateDiagram de,Caretaker ct);
	public abstract StateController mouseReleased(MouseEvent e,StateDiagram de,Caretaker ct);
	

}
