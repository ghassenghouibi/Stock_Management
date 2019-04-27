import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class AjouterUnNouveauArticle extends JPanel implements ActionListener {
	
	private UserInterface gui;
	
	private JTextField nom;
	private JFormattedTextField codeBarre;
	private JFormattedTextField quantiteEnStock;
	private JFormattedTextField seuilDeReassortiment;
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
			if(!nom.equals("")) {
				int codeBarre;
				try {
					codeBarre = Integer.parseInt(this.codeBarre.getText());
				} catch (NumberFormatException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Vous devez saisir un code barre correct", "Attention", JOptionPane.WARNING_MESSAGE);
					codeBarre = 0;
				}

				if(codeBarre > 0) {
					int quantiteEnStock;
					try {
						quantiteEnStock = Integer.parseInt(this.quantiteEnStock.getText());
					} catch (NumberFormatException e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Vous devez saisir une quantite de stock correct", "Attention", JOptionPane.WARNING_MESSAGE);
						quantiteEnStock = -1;
					}
					
					if(quantiteEnStock >= 0) {
						int seuilDeReassortiment;
						try {
							seuilDeReassortiment = Integer.parseInt(this.seuilDeReassortiment.getText());
						} catch (NumberFormatException e2) {
							// TODO: handle exception
							seuilDeReassortiment = 0;
						}
						if(seuilDeReassortiment > 0) {
							int prixDeVente;
							try {
								prixDeVente = Integer.parseInt(this.prixDeVente.getText());
							} catch (NumberFormatException e2) {
								// TODO: handle exception
								prixDeVente = 0;
							}
							if(prixDeVente > 0) {
								HashMap<String, Object> param = new HashMap<String, Object>();
								param.put("nom", nom);
								param.put("codeBarre", codeBarre);
								param.put("quantiteEnStock", quantiteEnStock);
								param.put("seuilDeReassortiment", seuilDeReassortiment);
								param.put("prixDeVente", prixDeVente);
								if(vrai.isSelected()) {
//									Article article = new Article(nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDeVente, true);
									param.put("typeDeVente", true);
//									this.gui.getEngine().getDetaillant().ajouterUnNouveauArticle(article);
									this.gui.getEngine().AjouterUnNouveauArticle(param);
									
									JOptionPane.showMessageDialog(null, "L'article " + nom + " a était ajouté avec succé", "Information", JOptionPane.INFORMATION_MESSAGE);

									this.gui.getMyFrame().repaint();
									this.gui.getMyFrame().setContentPane(new AjouterUnNouveauArticle(this.gui));
									this.gui.getMyFrame().revalidate();
								}else if(faux.isSelected()) {
//									Article article = new Article(nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDeVente, false);
//									this.gui.getEngine().getDetaillant().ajouterUnNouveauArticle(article);
									
									param.put("typeDeVente", false);
									this.gui.getEngine().AjouterUnNouveauArticle(param);
									
									JOptionPane.showMessageDialog(null, "L'article " + nom + " a était ajouté avec succé", "Information", JOptionPane.INFORMATION_MESSAGE);

									this.gui.getMyFrame().repaint();
									this.gui.getMyFrame().setContentPane(new AjouterUnNouveauArticle(this.gui));
									this.gui.getMyFrame().revalidate();
								}else {
									JOptionPane.showMessageDialog(null, "Vous devez selectionner si l'article c'est vendable ou pas!!", "Attention", JOptionPane.WARNING_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Vous devez saisir un prix de vente correct et > à 0", "Attention", JOptionPane.WARNING_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Vous devez saisir un seuil de reassortiment correct et > à 0", "Attention", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vous devez saisir un nom correct", "Attention", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
