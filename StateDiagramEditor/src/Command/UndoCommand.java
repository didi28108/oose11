package Command;

import Composite.StateDiagram;
import Memento.Caretaker;

public class UndoCommand implements Command{

	private StateDiagram sd;
	private Caretaker ct;
	
	public UndoCommand(StateDiagram sd,Caretaker ct) {
		this.sd = sd;
		this.ct = ct;
	}

	@Override
	public void execute() {
		/* Call the StateDigram to do setMemento() & minusCurrentVersion() */
		System.out.println("undo execute");
		this.sd.SetMemento(ct.getMemento(sd.getCurrentVersion()-1));
		sd.minusCurrentVersion();
	}
	
}
