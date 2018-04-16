package Command;

import Composite.StateDiagram;
import Memento.Caretaker;

public class RedoCommand implements Command{
	
	private StateDiagram sd;
	private Caretaker ct;
	
	public RedoCommand(StateDiagram sd,Caretaker ct) {

		this.sd = sd;
		this.ct = ct;
	}

	@Override
	public void execute() {
		/* Call the StateDigram to do setMemento() & addCurrentVersion() */
		System.out.println("redo execute");
		sd.SetMemento(ct.getMemento(sd.getCurrentVersion()+1));
		sd.addCurrentVersion();
	}

}
