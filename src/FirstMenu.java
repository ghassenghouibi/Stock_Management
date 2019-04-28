import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Detaillant;

public class FirstMenu extends JPanel implements ActionListener {
	
	private UserInterface gui;
	
	private JButton detaillant;
	private JButton caissier;
	/**
	 * 
	 */
	private static final long serialVersionUID = 988528974991105470L;
	
	public FirstMenu(UserInterface gui) {
		this.gui = gui;
		this.detaillant = new JButton("Détaillant");
		this.caissier = new JButton("Caissier");
	}
	
	public void paintComponent(Graphics g) {
		
//		g.setColor(Color.lightGray);
//	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		Font font = new Font("Courier", Font.BOLD, 40);
	    g.setFont(font);
	    g.setColor(Color.black);
		g.drawString("Stock Management", 300, 120);
		
//		font = new Font("Courier", Font.BOLD, 22);
//		g.setFont(font);
//		g.drawString("Vous êtes :", 90, this.getHeight() * 3 / 8 + 20);
		
		detaillant.setBounds(250, 270, 200, 200);
		detaillant.addActionListener(this);
		
		caissier.setBounds(550, 270, 200, 200);
		caissier.addActionListener(this);
		
		this.add(detaillant);
		this.add(caissier);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object  source = e.getSource();
		if(source == this.detaillant) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new ConnexionDetaillant(this.gui));
			this.gui.getMyFrame().revalidate();
		}
		if(source == this.caissier) {
			
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new ConnexionCaissier(this.gui));
			this.gui.getMyFrame().revalidate();
			
		}
	}
}
