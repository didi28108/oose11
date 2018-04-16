package Strategy;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import Composite.DiagramElement;

public abstract class DrawStrategy {
	public void draw(Graphics g ,String name,Point p,Rectangle r,boolean selected) {
		System.out.println("not work draw");
	}
	public void draw(Graphics g,String name,boolean selected,DiagramElement startPoint,DiagramElement endPoint , Rectangle r) {
		System.out.println("not work draw2");
	}
}
