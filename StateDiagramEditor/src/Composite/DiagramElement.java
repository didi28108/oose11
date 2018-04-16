package Composite;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract interface DiagramElement {
	
	public abstract void draw(Graphics g); 
	public abstract Iterator createIterator(); 
	public abstract void add(DiagramElement de);
	public abstract void remove(DiagramElement de);
	public abstract void printStruct(String preStr);
	public abstract String getName();
	public abstract void setName(String name);
	//Get object from StateDiagram's ArrayList 
	public abstract Object getComponent();
	
	//Methods check the component you clicked
	public abstract boolean contains(Point point);
	public abstract void setSelected(boolean b);
	
	//Update the state's position
	public abstract void updatePosition(Point p);
	public abstract Rectangle getRect();
	public abstract boolean isSelected();
	public abstract Point getLocation();
	
}
