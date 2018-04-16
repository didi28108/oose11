package Composite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;


public class State extends JComponent implements DiagramElement{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Point p;
	private int range;
	private Rectangle r = new Rectangle();
	private boolean selected = false;
	
	public State(String name,Point p,int ran){
		this.name = name;
		this.p = p;
		this.range= ran;
		setBoundary(r);
	}
	
	public void printStruct(String preStr) {
		System.out.println(" " + preStr + " - " + getName());
	}
	
	
	public void draw(Graphics g){
		 g.drawOval(r.x, r.y, r.width, r.height);
		 g.drawString(name, p.x-11, p.y+5);
		 
		 //If the state be selected, display a selection 
		 if (selected) {
             g.setColor(Color.darkGray);
             g.drawRect(r.x, r.y, r.width, r.height);
         }
	}
	
	public boolean intersect(Point p){return true;}
	
	private void setBoundary(Rectangle r) {
		//Set the selection boundary
        r.setBounds(p.x - range, p.y - range, 2 * range, 2 * range);
    }
	
	@Override
	public void updatePosition(Point p){
		this.p.x = p.x;
		this.p.y = p.y;
		this.setBoundary(this.r);
	}
	
	public Point getLocation() {return p;}
	
	@Override
	public boolean contains(Point p) {
        return r.contains(p);
    }

    /**
     * Return true if this node is selected.
     */
    public boolean isSelected() {
    	return selected;
    }
    
    public void setSelected(boolean selected) {
    	this.selected = selected;
    }

	public Iterator createIterator() {
		return null;
	}

	public void add(DiagramElement de) {}
	
	public void remove(DiagramElement de) {}

	public String getName(){
		return this.name;
	}

	@Override
	public Object getComponent() {
		return null;
	}
	
	public Rectangle getRect(){
		return r;
	}
	
	@Override
	public void setName(String name) {
		this.name=name;
	}

}
