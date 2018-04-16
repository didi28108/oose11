package Composite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.JComponent;



public class Transition extends JComponent implements DiagramElement{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private DiagramElement startPoint;		//point one
	private DiagramElement endPoint;		//point two
	private Rectangle r = new Rectangle();  //set boundary
	private boolean selected = false;		
	private static int barb = 20;           // barb length
    private static double phi = Math.PI/6;  //pi/6 =30 degree
	
	public Transition(String name,DiagramElement p1,DiagramElement p2){
		
		this.name = name;
		this.startPoint = p1;
		this.endPoint = p2;
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
		Point n1 = startPoint.getLocation();
		Point n2 = endPoint.getLocation();
		Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        double theta;
        theta = Math.atan2(n1.y - n2.y, n1.x - n2.x);
        g2.setPaint(Color.blue);
        if(n1.x>n2.x){
        	g2.draw(new Line2D.Double(n2.x+30, n2.y, n1.x-30, n1.y));
        	drawArrow(g2, theta, n1.x-30, n1.y);
        }else if(n2.x>n1.x){
        	g2.draw(new Line2D.Double(n2.x-30, n2.y, n1.x+30, n1.y));
        	drawArrow(g2, theta, n1.x+30, n1.y);
        	
        }else if((n1.y<n2.y)&&(n2.x>n1.x)){
        	g2.draw(new Line2D.Double(n2.x, n2.y-30, n1.x, n1.y+30));
        	drawArrow(g2, theta, n1.x, n1.y);
        }else if((n1.y<n2.y)&&(n2.x<n1.x)){
        	g2.draw(new Line2D.Double(n2.x, n2.y-30, n1.x+30, n1.y+30));
        	drawArrow(g2, theta, n1.x, n1.y);
        }
        
        
        int xm = (n1.x + n2.x) / 2;
        int ym = (n1.y + n2.y) / 2;
        g2.drawString(name, xm, ym);
        
        if (selected) {
            g.setColor(Color.darkGray);
            g.drawRect(r.x, r.y, r.width, r.height);
        }
        
		System.out.println("draw line");
		
	}
	
	private void setBoundary(Rectangle r) {
		
		@SuppressWarnings("unused")
		Point n1 = startPoint.getLocation();
		@SuppressWarnings("unused")
		Point n2 = endPoint.getLocation();
    }
	
	public Iterator createIterator() {return null;}

	public void add(DiagramElement de) {}

	public void remove(DiagramElement de) {}
	
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
	
	//The method for draw arrow line
	private void drawArrow(Graphics2D g2, double theta, double x0, double y0){
        double x = x0 - barb * Math.cos(theta + phi);
        double y = y0 - barb * Math.sin(theta + phi);
        g2.draw(new Line2D.Double(x0, y0, x, y));
        x = x0 - barb * Math.cos(theta - phi);
        y = y0 - barb * Math.sin(theta - phi);
        g2.draw(new Line2D.Double(x0, y0, x, y));
    }

	@Override
	public void updatePosition(Point p) {}
	
	@Override
	public void setName(String name) {}

}
