package MVC;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InitView {
	public JFrame frame;
	public JPanel mainPanel;
	private JButton btn_v1;
	private JButton btn_v2;
	private JLabel lab_show;
	
	public InitView() {
		/*
		 * Set frame show Position and width and height and Title
		 */
		this.frame = new JFrame("StateDiagramEditorG7");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 400, 200);
		
		/*
		 * Set mainPanel
		 */
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(mainPanel);
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		/*
		 * Set Show Welcome!
		 */
		lab_show = new JLabel("Welcome!");
		lab_show.setBounds(0, 0, 100, 30);
		mainPanel.add(lab_show);
		/*
		 * Set Buttons
		 */
		btn_v1 = new JButton("Style1");
		btn_v1.setBounds(0,0,100,30);
		mainPanel.add(btn_v1);
		btn_v2 = new JButton("Style2");
		btn_v2.setBounds(0,0,100,30);
		mainPanel.add(btn_v2);
	}
	
	public void addv1Listener(ActionListener e) {
		btn_v1.addActionListener(e);
	}
	public void addv2Listener(ActionListener e) {
		btn_v2.addActionListener(e);
	}
}
