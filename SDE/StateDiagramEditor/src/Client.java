import Composite.StateDiagram;
import MVC.View;
import MVC.viewController;
import Memento.Caretaker;
import State.Init;
import State.StateController;

public class Client {
	public static void main(String[] args) {
		Caretaker caretaker = new Caretaker();
		/* Set View's background to white  */
		View v = new View("white");
		/* New a initial State */
		StateController cs = new Init();
		new viewController(v,cs,new StateDiagram("root"),caretaker);
		v.setVisible(true);
	}

}
