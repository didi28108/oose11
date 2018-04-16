package Composite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import Flyweight.FlyweightFactory;
import Strategy.DrawStrategy;



public class Transition extends JComponent implements DiagramElement{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private DiagramElement startPoint;		//point one
	private DiagramElement endPoint;		//point two
	private Rectangle r = new Rectangle();  //set boundary
	private boolean selected = false;		
	//private static int barb = 10;           // barb length
    //private static double phi = Math.PI/6;  //pi/6 =30 degree
	DrawStrategy ds;
    
	public Transition(String name,DiagramElement p1,DiagramElement p2){
		this.name = name;
		this.startPoint = p1;
		this.endPoint = p2;
		ds = FlyweightFactory.getInstance().getStrategy("transition");
		setBoundary(r);
	}
	
	public void printStruct(String preStr) {
		System.out.println(" " + preStr + " - " + getName());
	}
	
	public boolean intersect(Point p){
		return true;
	}
	/*
	 * Get the point to calculate the theda
	 * When state drag, control the transition
	 * Send the theta and a point to draw an arrow
	 * Draw the string on middle point
	 */
	public void draw(Graphics g) {
		ds.draw(g, name, selected, startPoint, endPoint, r);
	}
	
	private void setBoundary(Rectangle r) {
		
		@SuppressWarnings("unused")
		Point n1 = startPoint.getLocation();
		@SuppressWarnings("unused")
		Point n2 = endPoint.getLocation();
    }
	
	public Iterator createIterator() {return null;}

	public void add(DiagramElement de) {
		de.add(this);
	}

	public void remove(DiagramElement de) {
		de.remove(de);
	}
	
	public String getName(){
		return this.name;	
	}

	@Override
	public Object getComponent() {return null;}

	@Override
	public boolean isSelected() {
		return selected;
	}
	
	@Override
	public void setSelected(boolean b) {
		this.selected = true;
	}

	@Override
	public Rectangle getRect() {
		return null;
	}
	
	@Override
	public void updatePosition(Point p) {}
	
	@Override
	public void setName(String name) {}

}
