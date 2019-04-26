
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public abstract class Lister extends JPanel implements ActionListener {
	
	protected UserInterface gui;
	
	protected JButton retour;
	
	protected JTextArea log;
	protected JScrollPane listScroller;
	
	public Lister(UserInterface gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
		this.retour = new JButton(new ImageIcon("src/retour1.png"));
		this.log = new JTextArea();
		log.setEditable(false);
		this.listScroller = new JScrollPane(log);
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
