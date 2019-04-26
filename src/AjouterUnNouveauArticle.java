import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AjouterUnNouveauArticle extends JPanel implements ActionListener {
	
	private UserInterface gui;
	
	private JTextField nom;
	private JTextField codeBarre;
	
	private JLabel nomLabel;
	private JLabel codeBarreLabel;
	private JButton ajouter;
	private JButton retour;
	
	
	public AjouterUnNouveauArticle(UserInterface gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
		
		this.nom = new JTextField();
		this.codeBarre = new JFormattedTextField (NumberFormat.getIntegerInstance());
		
		this.nomLabel = new JLabel("Nom de l'article : ");
		this.codeBarreLabel = new JLabel("Code barre : ");
		this.ajouter = new JButton("Ajouter");
		this.retour = new JButton(new ImageIcon("src/retour1.png"));
	}
	
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.lightGray);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
	    g.setFont(font);
	    g.setColor(Color.black);
		g.drawString("Ajouter un nouveau article", 190, 50);
		

		nomLabel.setBounds(170, 150, 100, 30);

		codeBarreLabel.setBounds(170, 210, 100, 30);
		
		nom.setBounds(300, 150, 200, 40);
		codeBarre.setBounds(300, 210, 200, 40);
		
		ajouter.setBounds(340, 330, 150, 30);
		
		retour.setBounds(30, 30, 30, 30);
		retour.addActionListener(this);
		
		
		this.add(nom);
		this.add(codeBarre);
		this.add(nomLabel);
		this.add(codeBarreLabel);
		this.add(ajouter);
		this.add(retour);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object  source = e.getSource();
		if(source == this.retour) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new MenuDetaillant(this.gui));
			this.gui.getMyFrame().revalidate();
		}
	}

}
