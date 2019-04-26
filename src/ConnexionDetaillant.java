import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ConnexionDetaillant extends JPanel implements ActionListener {

	private UserInterface gui;
	
	private JTextField id;
	private JTextField pass;
	private JLabel idLabel;
	private JLabel passLabel;
	private JButton connexion;
	private JButton retour;
	
	
	public ConnexionDetaillant(UserInterface gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
		this.id = new JTextField("Entrer votre identifiant");
		this.pass = new JTextField("Entrer votre mot de passe");
		this.idLabel = new JLabel("Identifiant : ");
		this.passLabel = new JLabel("Mot de passe : ");
		this.connexion = new JButton("Connexion");
		this.retour = new JButton(new ImageIcon("src/retour1.png"));
	}
	
	
	public void paintComponent(Graphics g) {
		
//		this.setLayout(null);
		
		g.setColor(Color.lightGray);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
	    g.setFont(font);
	    g.setColor(Color.black);
		g.drawString("Connexion Détaillant", 100, 100);
		
		idLabel.setLayout(null);
		idLabel.setBounds(200, 210, 100, 30);
		
		passLabel.setLayout(null);
		passLabel.setBounds(200, 270, 100, 30);
		
		id.setBounds(330, 200, 200, 50);
		pass.setBounds(330, 260, 200, 50);
		
		connexion.setBounds(370, 330, 150, 30);
		connexion.addActionListener(this);

		
		retour.setBounds(30, 30, 30, 30);
		retour.addActionListener(this);
		
		this.add(idLabel);
		this.add(id);
		this.add(passLabel);
		this.add(pass);
		this.add(connexion);
		this.add(retour);
		
		
	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JTextField getPass() {
		return pass;
	}

	public void setPass(JTextField pass) {
		this.pass = pass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object  source = e.getSource();
		if(source == retour) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new FirstMenu(this.gui));
			this.gui.getMyFrame().revalidate();
		}
		if(source == this.connexion) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new MenuDetaillant(this.gui));
			this.gui.getMyFrame().revalidate();
			
		}
	}
}
