package State;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Composite.DiagramElement;
import Composite.StateDiagram;
import Memento.Caretaker;

/* Initial State */

public class Init extends StateController {
	
	private static Init instance = null;

	public Init() {}
	
	/* lazy Singleton */
	public static Init getInstance() {
		if (instance == null) {
			return new Init();
		}
		return instance;
	}

	public StateController stateBtnClicked(ActionEvent e) {
		System.out.println("ControllerState stateBtnClicked");
		return AddState.getInstance();
	}

	public StateController transBtnClicked(ActionEvent e) {
		return AddTransition.getInstance();
	}

	public StateController selectBtnClicked() {
		return this;
	}

	public StateController mouseClicked(MouseEvent e, StateDiagram de, Caretaker ct) {
		System.out.println("Init mouse clicked");
		for (DiagramElement d : de.getComponent()) {
			/* When state be clicked, open a dialog to change name for state */
			if (d.contains(e.getPoint())) {
				JFrame setSn = new JFrame();
				String name = JOptionPane.showInputDialog(setSn, "Input the State name: ");

				if (name == null) {
					d.setName("");
				} else {
					d.setName(name);
				}

			}
		}
		return this;
	}

	public StateController mouseDragged(MouseEvent e, StateDiagram de) {
		
		//When state be dragged, update the position for state
		for (DiagramElement d : de.getComponent()) {
			if (d.contains(e.getPoint()) && d.isSelected() == true) {
				d.updatePosition(e.getPoint());
				e.getComponent().repaint();
			}
		}

		return this;
	}

	public StateController mousePressed(MouseEvent e, StateDiagram de, Caretaker ct) {
		for (DiagramElement d : de.getComponent()) {
			//If state be pressed, display the selection
			System.out.println("init mp");
			if (d.contains(e.getPoint())) {
				d.setSelected(true);
			} else {
				d.setSelected(false);
			}
		}
		return this;
	}

	public StateController mouseReleased(MouseEvent e, StateDiagram de, Caretaker ct) {
		System.out.println("controllerstate mouse released");
		return this;
	}

	@Override
	public StateController deleteBtnClicked(ActionEvent e) {
		System.out.println("Init DeleteBtn Clicked.");
		return TransSourceSelected.getInstance();
	}

}
