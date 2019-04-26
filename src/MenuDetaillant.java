import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuDetaillant extends JPanel implements ActionListener {


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
		
		this.deconnexion = new JButton("D�connexion");
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
		
		g.setColor(Color.lightGray);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
	    g.setFont(font);
	    g.setColor(Color.black);
		g.drawString("Menu", 360, 50);
		
		
		deconnexion.setBounds(450, 460, 150, 30);
		deconnexion.addActionListener(this);
		
		retour.setBounds(30, 30, 30, 30);
		retour.addActionListener(this);
		
		listerLesElementsEnDessousDuSeuil.setBounds(150, 100, 200, 50);
		listerLesElementsEnDessousDuSeuil.addActionListener(this);
		
		listerTousLesArticles.setBounds(450, 100, 200, 50);
		listerTousLesArticles.addActionListener(this);
		
		listerTousLesFournisseurs.setBounds(150, 160, 200, 50);
		listerTousLesFournisseurs.addActionListener(this);
		
		imprimerLaliste.setBounds(450, 160, 200, 50);
		imprimerLaliste.addActionListener(this);
		
		modifierLesInformationsConcernantLesArticles.setBounds(150, 220, 200, 50);
		modifierLesInformationsConcernantLesArticles.addActionListener(this);
		
		modifierLesInformationsConcernantLesFournisseurs.setBounds(450, 220, 200, 50);
		modifierLesInformationsConcernantLesFournisseurs.addActionListener(this);
		
		ajouterUnNouveauArticle.setBounds(150, 280, 200, 50);
		ajouterUnNouveauArticle.addActionListener(this);
		
		ajouterUnNouveauFournisseur.setBounds(450, 280, 200, 50);
		ajouterUnNouveauFournisseur.addActionListener(this);
		
		supprimerUnArticle.setBounds(150, 340, 200, 50);
		supprimerUnArticle.addActionListener(this);
		
		supprimerUnFournisseur.setBounds(450, 340, 200, 50);
		supprimerUnFournisseur.addActionListener(this);
		
		annulerLaCommande.setBounds(150, 400, 200, 50);
		annulerLaCommande.addActionListener(this);
		
		passerUneCommande.setBounds(450, 400, 200, 50);
		passerUneCommande.addActionListener(this);
		
		
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
		}else if(source == this.listerLesElementsEnDessousDuSeuil) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new ListerLesElementsEnDessousDuSeuil(this.gui));
			this.gui.getMyFrame().revalidate();
		}else if(source == this.listerTousLesArticles) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new ListerTousLesArticles(this.gui));
			this.gui.getMyFrame().revalidate();
		}else if(source == this.listerTousLesFournisseurs) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new ListerTousLesFournisseurs(this.gui));
			this.gui.getMyFrame().revalidate();
		}else if(source == this.ajouterUnNouveauArticle) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new AjouterUnNouveauArticle(this.gui));
			this.gui.getMyFrame().revalidate();
		}else if(source == this.deconnexion) {
			this.gui.getMyFrame().repaint();
//			this.gui.getMyFrame().setContentPane(new ConnexionCaissier());
			this.gui.getMyFrame().revalidate();
		}
	}
}
