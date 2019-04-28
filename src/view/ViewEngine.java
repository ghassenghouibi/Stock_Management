package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewEngine extends JFrame{

    private JPanel panel = new JPanel();
    private JButton button = new JButton("Mon bouton");

      private JPanel monPanel = new JPanel();
      private GridBagConstraints gbc = new GridBagConstraints();
   
   
     //Déclaration des JLabel
     //private JLabel label_bienvenue = new JLabel ("BIENVENUE SUR xxxxxx, Lxxxxx de xxxx xxxx xxxx !");
   
   
      //Déclaration des JButton
      private JButton bouton_ajout = new JButton ("Ajouter...");
      private JButton bouton_modif = new JButton ("Modifier...");
      private JButton bouton_supp = new JButton ("Supprimer...");
      private JButton bouton_rech = new JButton ("Rechercher...");
   
   
     // private JScrollPane maScrollPanefilm;
   
     // private JTable table_liste_film;
   
   
     //**************************************************************************
     //Création de la Barre du Menu de la fenetre principale
     JMenuBar br=new JMenuBar();
   
   
     //Les Onglets du Menu
     JMenu P=new JMenu("Fichier");
     JMenu V=new JMenu("Affichage");
     JMenu R=new JMenu("Recherche");
     JMenu A=new JMenu("Aide");
   
   
     //Sous Onglets de l'onglet Fichier
     JMenuItem Ajout=new JMenuItem("Nouveau");
     JMenuItem Modif=new JMenuItem("Modifier...");
     JMenuItem Supp=new JMenuItem("Supprimer...");
     JMenuItem Quitter=new JMenuItem("Quitter");
   
   
     //Sous Onglets de l'onglet Affichage
     JMenuItem Actu=new JMenuItem("Actualiser la liste des films");
   
   
     //Sous Onglets de l'onglet Recherche
     JMenuItem Rec_titre=new JMenuItem("Recherche par Titre");
     JMenuItem Rec_realisateur=new JMenuItem("Recherche par Réalisateur");
     JMenuItem Rec_acteur=new JMenuItem("Recherche par Acteur");
   
   
     //Sous Onglets de l'onglet Aide
     JMenuItem About=new JMenuItem("A propos de xxxxx");
   
   
   
      public ViewEngine(){
          super();   
          build();
          this.setVisible(true);
      }
      //**************************************************************************
   
   
      //******************************************************************************
      private void build(){
   
   
          setTitle("Gestion De Stock");
          setSize(1000,768);
          setLocationRelativeTo(null);
          setResizable(false);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
          //On définit le Grid
          monPanel.setLayout (new GridBagLayout());
   
   
          //On place les label
          gbc.fill = GridBagConstraints.BOTH;
         // gbc.insets = new Insets (10,10,10,10);
   
         // gbc.gridx = 3;
          //gbc.gridy = 0;
          //monPanel.add(label_bienvenue,gbc);
   
   
   
          //On place les boutons
          gbc.gridx = 0;
          gbc.gridy = 0;
          gbc.gridwidth = 2;
          gbc.fill = GridBagConstraints.NONE;
          monPanel.add(bouton_ajout,gbc); //bouton ajouter
   
          gbc.gridx = 2;
          gbc.gridy = 0;
          gbc.gridwidth = 2;
          gbc.fill = GridBagConstraints.NONE;
          monPanel.add(bouton_modif,gbc); //bouton modifier
   
          gbc.gridx = 4;
          gbc.gridy = 0;
          gbc.gridwidth = 2;
          gbc.fill = GridBagConstraints.NONE;
          monPanel.add(bouton_supp,gbc); //bouton supprimer
   
          gbc.gridx = 6;
          gbc.gridy = 0;
          gbc.gridwidth = 2;
          gbc.fill = GridBagConstraints.NONE;
          monPanel.add(bouton_rech,gbc); //bouton recherche
   
          //On place le JTable
         // gbc.gridx = 0;
          //gbc.gridy = 1;
          //gbc.gridwidth = 8;
          //gbc.weightx=100;
          //gbc.weighty=100;
         // monPanel.add(maScrollPanefilm,gbc);
   
   
   
          //On attache monPanel
          this.getContentPane().add(monPanel);
   
   
          //On integre Les Onglets dans le Menu
          br.add(P);
          br.add(V);
          br.add(R);
          br.add(A);
   
   
          //On ajoute Les Sous-onglets dans leur onglets respectives ds barre de menu "Fichier"
          P.add(Ajout);
          P.add(Modif);
          P.add(Supp);
          P.add(Quitter);
          V.add(Actu);
          R.add(Rec_titre);
          R.add(Rec_realisateur);
          R.add(Rec_acteur);
          A.add(About);
   
          this.setJMenuBar(br);
        //panel.add(new JScrollPane(tableau), gbc);
        
        
        this.setContentPane(panel);
        this.setVisible(true);
      
    }
         
}