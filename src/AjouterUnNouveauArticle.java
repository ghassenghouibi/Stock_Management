import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.Article;

@SuppressWarnings("serial")
public class AjouterUnNouveauArticle extends JPanel implements ActionListener {
	
	private UserInterface gui;
	
	private JTextField nom;
	private JFormattedTextField codeBarre;
	private JFormattedTextField quantiteEnStock;
	private JFormattedTextField seuilDeReassortiment;
	private JFormattedTextField codeprixDeventeBarre;
	private JFormattedTextField prixDeVente;
	
	private ButtonGroup radio;
	private JRadioButton vrai;
	private JRadioButton faux;
	
	private JLabel nomLabel;
	private JLabel codeBarreLabel;
	private JLabel quantiteEnStockLabel;
	private JLabel seuilDeReassortimentLabel;
	private JLabel prixDeventeLabel;
	private JLabel typeDeVenteLabel;
	
	private JButton ajouter;
	private JButton retour;
	
	JOptionPane erreur;
	
	
	public AjouterUnNouveauArticle(UserInterface gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
		
		this.nom = new JTextField();
		this.codeBarre = new JFormattedTextField (NumberFormat.getIntegerInstance());
		this.quantiteEnStock = new JFormattedTextField (NumberFormat.getIntegerInstance());
		this.seuilDeReassortiment = new JFormattedTextField (NumberFormat.getIntegerInstance());
		this.prixDeVente = new JFormattedTextField (NumberFormat.getIntegerInstance());
		
		this.radio = new ButtonGroup();
		this.vrai = new JRadioButton("Oui");
		this.faux = new JRadioButton("Non");
		
		this.nomLabel = new JLabel("Nom de l'article : ");
		this.codeBarreLabel = new JLabel("Code barre : ");
		this.quantiteEnStockLabel = new JLabel("Quantité en stock : ");
		this.seuilDeReassortimentLabel = new JLabel("Seuil de reassortiment : ");
		this.prixDeventeLabel = new JLabel("Prix de vente : ");
		this.typeDeVenteLabel = new JLabel("Type de vente : ");
		
		this.ajouter = new JButton("Ajouter");
		this.retour = new JButton(new ImageIcon("src/retour1.png"));
		
		this.erreur = new JOptionPane();
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
		
		codeBarreLabel.setBounds(180, 180, 200, 30);
		codeBarre.setBounds(400, 180, 200, 40);
		
		quantiteEnStockLabel.setBounds(180, 240, 200, 30);
		quantiteEnStock.setBounds(400, 240, 200, 40);
		
		seuilDeReassortimentLabel.setBounds(180, 300, 200, 30);
		seuilDeReassortiment.setBounds(400, 300, 200, 40);
		
		prixDeventeLabel.setBounds(180, 360, 200, 30);
		prixDeVente.setBounds(400, 360, 200, 40);
		
		typeDeVenteLabel.setBounds(180, 420, 100, 30);
		vrai.setBounds(450, 425, 50, 30);
		faux.setBounds(520, 425, 50, 30);
		vrai.setBackground(Color.lightGray);
		faux.setBackground(Color.lightGray);
		radio.add(vrai);
		radio.add(faux);
		
//		codeBarreLabel.setBounds(170, 210, 100, 30);
//		codeBarre.setBounds(300, 210, 200, 40);
		
		ajouter.setBounds(350, 470, 150, 30);
		ajouter.addActionListener(this);
		
		retour.setBounds(30, 30, 30, 30);
		retour.addActionListener(this);
		
		
		this.add(nom);
		this.add(codeBarre);
		this.add(nomLabel);
		this.add(codeBarreLabel);
		this.add(quantiteEnStockLabel);
		this.add(quantiteEnStock);
		this.add(seuilDeReassortimentLabel);
		this.add(seuilDeReassortiment);
		this.add(prixDeventeLabel);
		this.add(prixDeVente);
		this.add(typeDeVenteLabel);
		this.add(vrai);
		this.add(faux);
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
			System.out.println(nom);
			if(nom != null) {
				int codeBarre;
				codeBarre = Integer.parseInt(this.codeBarre.getText());

				if(codeBarre > 0) {
					int quantiteEnStock = Integer.parseInt(this.quantiteEnStock.getText());
					if(quantiteEnStock > 0) {
						int seuilDeReassortiment = Integer.parseInt(this.seuilDeReassortiment.getText());
						if(seuilDeReassortiment > 0) {
							int prixDeVente = Integer.parseInt(this.prixDeVente.getText());
							if(prixDeVente > 0) {
								if(vrai.isSelected()) {
									Article article = new Article(nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDeVente, true);
									this.gui.getEngine().getDetaillant().ajouterUnNouveauArticle(article);
								}else if(faux.isSelected()) {
									Article article = new Article(nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDeVente, false);
									this.gui.getEngine().getDetaillant().ajouterUnNouveauArticle(article);
								}else {
									JOptionPane.showMessageDialog(null, "Vous devez selectionner si l'article c'est vendable ou pas!!", "Information", JOptionPane.INFORMATION_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Vous devez saisir un prix de vente correct", "Information", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Vous devez saisir un seuil de reassortiment correct", "Information", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Vous devez saisir une quantite de stock correct", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vous devez saisir un code barre correct", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vous devez saisir un nom correct", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

}
