package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;


public class FenetreDetaillant extends JFrame{

  private JMenuBar menuBar=new JMenuBar();
  
  private JMenu affichage = new JMenu("Affichage");
  private JMenu impression = new JMenu("Imprimer");
  private JMenu edition = new JMenu("Edition");


  private JMenuItem listerLesElementsEnDessousDuSeuil = new JMenuItem("Lister Les Elements En Dessous Du Seuil");
  private JMenuItem listerTousLesArticles = new JMenuItem("Lister Tous Les Articles");
  private JMenuItem listerTousLesFournisseurs = new JMenuItem("Lister Tous Les Fournisseurs");
  //private JMenuItem imprimerLaliste = new JMenuItem("Imprimer La Liste");
  private JMenuItem modifierLesInformationsConcernantLesArticles= new JMenuItem("Modifier Les Informations Concernant Les Articles");
  private JMenuItem modifierLesInformationsConcernantLesFournisseurs= new JMenuItem("Modifier Les Informations Concernant Les Fournisseurs");
  //private JMenuItem ajouterUnNouveauArticle= new JMenuItem("Ajouter Un Nouveau Article");
  public static void main(String arg[]){
    FenetreDetaillant x=new FenetreDetaillant();
  }
  public FenetreDetaillant(){
    
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setTitle("Gestion De Stock");

    this.affichage.add(listerLesElementsEnDessousDuSeuil);
    this.affichage.add(listerTousLesArticles);
    this.affichage.add(listerTousLesFournisseurs);

    
    this.edition.add(modifierLesInformationsConcernantLesArticles);
    this.edition.add(modifierLesInformationsConcernantLesFournisseurs);

    this.menuBar.add(affichage);
    this.menuBar.add(impression);
    this.menuBar.add(edition);
    this.setJMenuBar(menuBar);
    this.setVisible(true);
  }
}
