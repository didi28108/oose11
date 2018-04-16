package Strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class StateDrawStrategy2 extends DrawStrategy{
public void draw(Graphics g ,String name,Point p,Rectangle r,boolean selected) {
		
		//Graphics2D g2d = (Graphics2D)g;
		//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRoundRect(r.x, r.y, r.width, r.height, 30,30);
		 g.drawString(name, p.x-11, p.y+5);
		 //If the state be selected, display a selection 
		 if (selected) {
            g.setColor(Color.darkGray);
            g.drawRect(r.x, r.y, r.width, r.height);
        }
	}
}
