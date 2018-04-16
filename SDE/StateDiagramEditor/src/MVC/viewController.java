package MVC;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;


import Composite.DiagramElement;
import Composite.StateDiagram;
import Memento.Caretaker;
import State.StateController;

public class viewController extends JComponent {
	private static final long serialVersionUID = 1L;
	private View view;
	private StateDiagram sd;
	private StateController sc;
	private Caretaker caretaker;

	public viewController(View v, StateController sc, StateDiagram de, Caretaker ct) {
		this.view = v;
		this.sc = sc;
		this.sd = de;
		this.caretaker = ct;
		
		this.view.getDrawPanel().add(this);
		/* Add Buttons ActionListener */
		this.view.addStateListener(new ListenerClass.StateBtnListener(this));
		this.view.addTransListener(new ListenerClass.TransBtnListener(this));
		this.view.addDeleteListener(new ListenerClass.DelBtnListener(this));
		this.view.addundoListener(new ListenerClass.UndoBtnListener(this));
		this.view.addredoListener(new ListenerClass.RedoBtnListener(this));
		this.view.addMouseListener(new ListenerClass.Mouse(this));
		this.view.getDrawPanel().addMouseMotionListener(new ListenerClass.MouseMove(this));
		
		/* Initial memento */
		caretaker.addMemento(de.CreateMemento()); 

	}
	
	/* When this method be called, the draw panel will paint */ 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("Paint is work");
		for (DiagramElement d : sd.getComponent()) {
			d.draw(g);
		}
		/* Print message to check */ 
		sd.printStruct("");
		caretaker.printCaretaker();
	}

	@Override
	public Dimension getPreferredSize() {
		System.out.println("dimesion is work");
		return new Dimension(this.view.getDrawPanel().getWidth(), this.view.getDrawPanel().getHeight());
	}

	/* StateBtnClicked */
	public void stateBtnClicked(ActionEvent e) {
		System.out.println("state was clicked");
		sc = sc.stateBtnClicked(e);
		System.out.println(sc.getClass());

	}
	/* Transition button */
	public void transBtnClicked(ActionEvent e) {
		System.out.println("trans");
		sc = sc.transBtnClicked(e);
		System.out.println(sc.getClass());
	}
	/* Delete button */
	public void deleteBtnClicked(ActionEvent e) {
		sc = sc.deleteBtnClicked(e);
	}
	/* Undo button */
	public void undoBtnClicked(ActionEvent e) {
		//Control the range
		if (1 <= sd.getCurrentVersion()) {
			this.sd.SetMemento(caretaker.getMemento(sd.getCurrentVersion()-1));
			sd.minusCurrentVersion();
			repaint();
		}
		repaint();
	}
	/* Redo button */
	public void redoBtnClicked(ActionEvent e) {
		
		if (sd.getCurrentVersion() < (sd.getVersion())) {
			sd.SetMemento(caretaker.getMemento(sd.getCurrentVersion()+1));
		    sd.addCurrentVersion();
			repaint();
		}
		repaint(); // call repaint to paintComponent
	}
	/*
	 * Mouse Events
	 */
	public void mouseClicked(MouseEvent e) {
		sc = sc.mouseClicked(e, sd, caretaker);
		e.getComponent().repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		System.out.println("controller mouse dragged");
		sc = sc.mouseDragged(e, sd);
		e.getComponent().repaint();
	}
	public void mousePressed(MouseEvent e) {
		sc = sc.mousePressed(e, sd, caretaker);
		e.getComponent().repaint();
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("Controller mouse released");
		sc = sc.mouseReleased(e, sd, caretaker);
		System.out.println("How many components:" + sd.getComponent().size());
		System.out.println(sc.getClass());
		e.getComponent().repaint();
	}

	
}
