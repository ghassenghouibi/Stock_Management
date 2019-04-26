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

public class MenuDetaillant extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6550327962245546674L;

	private UserInterface gui;


	private JButton deconnexion;
	private JButton retour;
	
	private JButton listerLesElementsEnDessousDuSeuil;
	private JButton listerTousLesArticles;
	private JButton listerTousLesFournisseurs;
	private JButton imprimerLaliste;
	private JButton modifierLesInformationsConcernantLesArticles;
	private JButton modifierLesInformationsConcernantLesFournisseurs;
	private JButton ajouterUnNouveauArticle;
	private JButton ajouterUnNouveauFournisseur;
	private JButton supprimerUnArticle;
	private JButton supprimerUnFournisseur;
	private JButton annulerLaCommande;
	private JButton passerUneCommande;

	
	public MenuDetaillant(UserInterface gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
		
		this.deconnexion = new JButton("Déconnexion");
		this.retour = new JButton(new ImageIcon("src/retour1.png"));
		
		this.listerLesElementsEnDessousDuSeuil = new JButton("listerLesElementsEnDessousDuSeuil");
		this.listerTousLesArticles = new JButton("listerTousLesArticles");
		this.listerTousLesFournisseurs = new JButton("listerTousLesFournisseurs");
		this.imprimerLaliste = new JButton("imprimerLaliste");
		this.modifierLesInformationsConcernantLesArticles = new JButton("modifierLesInformationsConcernantLesArticles");
		this.modifierLesInformationsConcernantLesFournisseurs = new JButton("modifierLesInformationsConcernantLesFournisseurs");
		this.ajouterUnNouveauArticle = new JButton("ajouterUnNouveauArticle");
		this.ajouterUnNouveauFournisseur = new JButton("ajouterUnNouveauFournisseur");
		this.supprimerUnArticle = new JButton("supprimerUnArticle");
		this.supprimerUnFournisseur = new JButton("supprimerUnFournisseur");
		this.annulerLaCommande = new JButton("annulerLaCommande");
		this.passerUneCommande = new JButton("passerUneCommande");
	}
	
	
	public void paintComponent(Graphics g) {
		
//		this.setLayout(null);
		
		g.setColor(Color.lightGray);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
	    g.setFont(font);
	    g.setColor(Color.black);
		g.drawString("Menu", 360, 50);
		
		
		deconnexion.setBounds(450, 460, 150, 30);
		
		retour.setBounds(30, 30, 50, 50);
		retour.addActionListener(this);
		
		listerLesElementsEnDessousDuSeuil.setBounds(150, 100, 200, 50);
		
		listerTousLesArticles.setBounds(450, 100, 200, 50);
		
		listerTousLesFournisseurs.setBounds(150, 160, 200, 50);
		
		imprimerLaliste.setBounds(450, 160, 200, 50);
		
		modifierLesInformationsConcernantLesArticles.setBounds(150, 220, 200, 50);
		
		modifierLesInformationsConcernantLesFournisseurs.setBounds(450, 220, 200, 50);
		
		ajouterUnNouveauArticle.setBounds(150, 280, 200, 50);
		
		ajouterUnNouveauFournisseur.setBounds(450, 280, 200, 50);
		
		supprimerUnArticle.setBounds(150, 340, 200, 50);
		
		supprimerUnFournisseur.setBounds(450, 340, 200, 50);
		
		annulerLaCommande.setBounds(150, 400, 200, 50);
		
		passerUneCommande.setBounds(450, 400, 200, 50);
		
		
		this.add(listerLesElementsEnDessousDuSeuil);
		this.add(listerTousLesArticles);
		this.add(listerTousLesFournisseurs);
		this.add(imprimerLaliste);
		this.add(modifierLesInformationsConcernantLesArticles);
		this.add(modifierLesInformationsConcernantLesFournisseurs);
		this.add(ajouterUnNouveauArticle);
		this.add(ajouterUnNouveauFournisseur);
		this.add(supprimerUnArticle);
		this.add(supprimerUnFournisseur);
		this.add(annulerLaCommande);
		this.add(passerUneCommande);
		this.add(deconnexion);
		this.add(retour);
		
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
		if(source == this.deconnexion) {
			this.gui.getMyFrame().repaint();
//			this.gui.getMyFrame().setContentPane(new ConnexionCaissier());
			this.gui.getMyFrame().revalidate();
			
		}
	}
}
