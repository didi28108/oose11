package Composite;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import Memento.Memento;

public class StateDiagram implements DiagramElement, Cloneable {

	private ArrayList<DiagramElement> des = new ArrayList<DiagramElement>();
	private String name;
	/* It present how many memento version */
	private static int version = 0; 
	/* The End for redo & undo */
	private static int currentVersion = 0;
	/* Store the clone */
	@SuppressWarnings("unused")
	private StateDiagram sd;

	public StateDiagram(String name) {
		this.name = name;
	}

	public void printStruct(String preStr) {
		// Print the structure for state diagram
		System.out.println(preStr + " + " + this.getName());
		if (this.des != null) {
			preStr += " ";
			for (DiagramElement c : des) {
				c.printStruct(preStr);
			}
		}
	}

	public void add(DiagramElement de) {
		this.des.add(de);
	}

	public void remove(DiagramElement component) {
		this.des.remove(component);
	}

	public void draw(Graphics g) {
		// Use iterator to traversal the component of state diagram
		Iterator it = this.createIterator();
		while (it.hasNext()) {
			DiagramElement e = (DiagramElement) it.next();
			e.draw(g);
		}
	}


	// Get the component of StateDiagram
	public ArrayList<DiagramElement> getComponent() {
		return des;
	}

	// The method which lets StateDiagram set clone Arraylist
	public void setComponent(ArrayList<DiagramElement> deList) {
		this.des = deList;
	}

	public Iterator createIterator() {
		return new StateDiagramIterator(this.des);
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean contains(Point point) {
		return false;
	}

	@Override
	public void setSelected(boolean b) {}

	@Override
	public void updatePosition(Point p) {}

	@Override
	public Rectangle getRect() {
		return null;
	}

	@Override
	public boolean isSelected() {
		return false;
	}

	@Override
	public Point getLocation() {
		return null;
	}

	// Get the StateDiagram stored in Memento
	public void SetMemento(Memento sdm) {
		des = sdm.getState().getComponent();
	}

	// Create a new Memento with a new StateDiagram
	@SuppressWarnings("unchecked")
	public Memento CreateMemento() {
		System.out.println("store memento");
		// Create new StateDiagram to store clone copy
		// Create new ArrayList to store clone copy
		StateDiagram sd = new StateDiagram(name);
		ArrayList<DiagramElement> ade = new ArrayList<DiagramElement>();
		ade = (ArrayList<DiagramElement>) this.des.clone(); // clone
		sd.setComponent(ade);
		// New StateDiagram set clone copy
		return new Memento(sd); 
		// Create a memento to store clone StateDiagram
	}

	public void addVersion() {
		version += 1;
		System.out.println("version:" + version);
	}

	public int getVersion() {
		return version;
	}

	public void addCurrentVersion() {
		currentVersion += 1;
	}

	public void minusCurrentVersion() {
		currentVersion -= 1;
	}

	public int getCurrentVersion() {
		return currentVersion;
	}

	@Override
	public void setName(String name) {}

	public void addComponent(DiagramElement deList) {
		this.des.add(deList);
	}
	
}
