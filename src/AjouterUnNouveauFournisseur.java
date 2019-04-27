import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class AjouterUnNouveauFournisseur extends JPanel implements ActionListener {
	
	private UserInterface gui;
	
	private JTextField nom;
	private JFormattedTextField numeroTel;
	private JTextField adresse;
	private JFormattedTextField codePostale;
	
	private JLabel nomLabel;
	private JLabel numeroTelLabel;
	private JLabel adresseLabel;
	private JLabel codePostaleLabel;
	
	private JButton ajouter;
	private JButton retour;
	
	
	public AjouterUnNouveauFournisseur(UserInterface gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
		
		this.nom = new JTextField();
		this.numeroTel = new JFormattedTextField (NumberFormat.getIntegerInstance());
		this.adresse = new JFormattedTextField (NumberFormat.getIntegerInstance());
		this.codePostale = new JFormattedTextField (NumberFormat.getIntegerInstance());
		
		this.nomLabel = new JLabel("Nom du fournisseur : ");
		this.numeroTelLabel = new JLabel("Numéro de téléphone : ");
		this.adresseLabel = new JLabel("Adresse : ");
		this.codePostaleLabel = new JLabel("Code postale : ");
		
		this.ajouter = new JButton("Ajouter");
		this.retour = new JButton(new ImageIcon("src/retour1.png"));
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.lightGray);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
	    g.setFont(font);
	    g.setColor(Color.black);
		g.drawString("Ajouter un nouveau article", 210, 50);
		

		nomLabel.setBounds(180, 120, 200, 30);
		nom.setBounds(400, 120, 200, 40);
		
		numeroTelLabel.setBounds(180, 180, 200, 30);
		numeroTel.setBounds(400, 180, 200, 40);
		
		adresseLabel.setBounds(180, 240, 200, 30);
		adresse.setBounds(400, 240, 200, 40);
		
		codePostaleLabel.setBounds(180, 300, 200, 30);
		codePostale.setBounds(400, 300, 200, 40);
		
		ajouter.setBounds(350, 370, 150, 30);
		ajouter.addActionListener(this);
		
		retour.setBounds(30, 30, 30, 30);
		retour.addActionListener(this);
		
		
		this.add(nom);
		this.add(numeroTel);
		this.add(nomLabel);
		this.add(numeroTelLabel);
		this.add(adresseLabel);
		this.add(adresse);
		this.add(codePostaleLabel);
		this.add(codePostale);
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
		}else if(source == this.ajouter) {
			String nom = this.nom.getText();
			if(!nom.equals("")) {
				int numeroTel;
				try {
					numeroTel = Integer.parseInt(this.numeroTel.getText());
				} catch (NumberFormatException e2) {
					// TODO: handle exception
					numeroTel = 0;
				}

				if(numeroTel > 0) {
					String adresse = this.adresse.getText();					
					if(!adresse.equals("")) {
						int codePostale;
						try {
							codePostale = Integer.parseInt(this.codePostale.getText());
						} catch (NumberFormatException e2) {
							// TODO: handle exception
							codePostale = 0;
						}
						if(codePostale > 0) {
							HashMap<String, Object> param = new HashMap<String, Object>();
							param.put("nom", nom);
							param.put("codePostale", codePostale);
							param.put("numeroTel", numeroTel);
							param.put("adresse", adresse);
							
							this.gui.getEngine().AjouterUnNouveauFournisseur(param);
							JOptionPane.showMessageDialog(null, "Le fournisseur " + nom + " a était ajouté avec succé", "Information", JOptionPane.INFORMATION_MESSAGE);

							
							this.gui.getMyFrame().repaint();
							this.gui.getMyFrame().setContentPane(new AjouterUnNouveauFournisseur(this.gui));
							this.gui.getMyFrame().revalidate();
						}else {
							JOptionPane.showMessageDialog(null, "Vous devez saisir un code postale correct", "Attention", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Vous devez saisir une adresse correct", "Attention", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vous devez saisir un numéro de téléphone correct", "Attention", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vous devez saisir un nom correct", "Attention", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
