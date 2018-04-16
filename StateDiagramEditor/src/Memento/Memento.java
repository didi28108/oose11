package Memento;

import Composite.DiagramElement;
import Composite.StateDiagram;

public class Memento {
	
	private StateDiagram sd;
	
	public Memento(StateDiagram sd){
		this.sd = sd;
		System.out.println("new memento");
		printMemento();
	}
	//get memento
	public StateDiagram getState() {
		return sd;
	}
	
	public void printMemento(){
		System.out.println("printmmt:");
		for(DiagramElement d:sd.getComponent()){
			System.out.println(d.getName());
		}
		System.out.println("");
	}

}
