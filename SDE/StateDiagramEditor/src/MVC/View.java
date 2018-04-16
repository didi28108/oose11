package MVC;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ListenerClass.MouseMove;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;

	public JFrame frame;

	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel drawPanel;
	
	private JButton Btn_state;
	private JButton Btn_trans;
	private JButton Btn_undo;
	private JButton Btn_redo;
	private JButton Btn_del;
	
	

	public View(String c) {
		
		/*
		 * Set frame show Position and width and height and Title
		 */
		setTitle("StateDiagramEditor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 700, 520);
		/*
		 * Set mainPanel
		 */
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		/*
		 * Set topPanel
		 */
		topPanel = new JPanel();
		topPanel.setBounds(-1, 0, 700, 40);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.add(topPanel);
		/*
		 * Set drawPanel
		 */
		drawPanel = new JPanel();
		drawPanel.setBounds(-1, 39, 700, 460);
		drawPanel.setBackground(Color.white);
		
		/*
		 * Set Buttons
		 * State Button to Add State
		 */
		Btn_state = new JButton("State");
		Btn_state.setBounds(0,0,100,30);
		topPanel.add(Btn_state);

		/* Transition Button to Add Transition */
		Btn_trans = new JButton("Transition");
		Btn_trans.setBounds(0,0,100,30);
		topPanel.add(Btn_trans);

		/* Undo Button to Undo */
		Btn_undo = new JButton("Undo");
		Btn_undo.setBounds(0,0,100,30);
		topPanel.add(Btn_undo);

		/* Redo Button to Redo */
		Btn_redo = new JButton("Redo");
		Btn_redo.setBounds(0,0,100,30);
		topPanel.add(Btn_redo);

		/* Delete Button to Remove */
		Btn_del = new JButton("Delete");
		Btn_del.setBounds(0,0,100,30);
		topPanel.add(Btn_del);
		
		

	}

	public void addundoListener(ActionListener al) {
		Btn_undo.addActionListener(al);
	}

	public void addredoListener(ActionListener al) {
		Btn_redo.addActionListener(al);
	}

	public void addStateListener(ActionListener al) {
		Btn_state.addActionListener(al);
	}

	public void addTransListener(ActionListener al) {
		Btn_trans.addActionListener(al);
	}

	public void addDeleteListener(ActionListener al) {
		Btn_del.addActionListener(al);
	}

	public void addMouseListener(MouseListener listenForMouse) {
		drawPanel.addMouseListener(listenForMouse);
	}

	public void addMouseDraggedListener(MouseListener listenForMouse) {
		drawPanel.addMouseListener(listenForMouse);
	}

	public void addMousePressedListener(MouseListener listenForMouse) {
		drawPanel.addMouseListener(listenForMouse);
	}

	public void addMouseReleasedListener(MouseListener listenForMouse) {
		drawPanel.addMouseListener(listenForMouse);
	}
	

	public JPanel getDrawPanel() {
		return drawPanel;
	}

	

}
