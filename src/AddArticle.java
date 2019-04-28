import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddArticle extends JDialog implements ActionListener{
	
	private UserInterface gui;
	private GestionStock gs;
//	  private ZDialogInfo zInfo = new ZDialogInfo();
	private boolean sendData;
	private JLabel nomLabel, codeBarreLabel, quantiteEnStockLabel, seuilDeReassortimentLabel, prixDeVenteLabel, typeDeVenteLabel;
	private JRadioButton oui, non;
	private JTextField nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDeVente;
	private JButton okBouton;
	  


	public AddArticle(JFrame parent, String title, boolean modal, UserInterface gui, GestionStock gs){
		super(parent, title, modal);
		this.gui = gui;
		this.gs = gs;
	    this.setSize(500, 365);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	    this.initComponent();
	    this.setVisible(true);
	}

//	  public ZDialogInfo showZDialog(){
//	    this.sendData = false;
//	    this.setVisible(true);      
//	    return this.zInfo;      
//	  }

	private void initComponent(){

	    JPanel panel = new JPanel();
	    panel.setBackground(Color.white);
	    panel.setLayout(null);
	    panel.setPreferredSize(new Dimension(360, 280));
	    panel.setBorder(BorderFactory.createTitledBorder("Saisi des information"));
	    
	    nom = new JTextField();
	    nom.setBounds(200, 40, 150, 25);
	    panel.add(nom);
	    

	    nomLabel = new JLabel("Saisir le nom de l'article :");
	    nomLabel.setBounds(5, 40, 200, 25);
	    panel.add(nomLabel);
	    
	    codeBarre = new JTextField();
	    codeBarre.setBounds(200, 80, 150, 25);
	    panel.add(codeBarre);
	    
	    codeBarreLabel = new JLabel("Saisir un code barre :");
	    codeBarreLabel.setBounds(5, 80, 200, 25);
	    panel.add(codeBarreLabel);
	    
	    quantiteEnStock = new JTextField();
	    quantiteEnStock.setBounds(200, 120, 150, 25);
	    panel.add(quantiteEnStock);
	    
	    quantiteEnStockLabel = new JLabel("Saisir une quantité :");
	    quantiteEnStockLabel.setBounds(5, 120, 200, 25);
	    panel.add(quantiteEnStockLabel);
	    
	    seuilDeReassortiment = new JTextField();
	    seuilDeReassortiment.setBounds(200, 160, 150, 25);
	    panel.add(seuilDeReassortiment);
	    
	    seuilDeReassortimentLabel = new JLabel("Saisir un seuil de reassortiment :");
	    seuilDeReassortimentLabel.setBounds(5, 160, 200, 25);
	    panel.add(seuilDeReassortimentLabel);
	    
	    prixDeVente = new JTextField();
	    prixDeVente.setBounds(200, 200, 150, 25);
	    panel.add(prixDeVente);
	    
	    prixDeVenteLabel = new JLabel("Saisir un prix :");
	    prixDeVenteLabel.setBounds(5, 200, 200, 25);
	    panel.add(prixDeVenteLabel);
	    
	    typeDeVenteLabel = new JLabel("Mettre en vente :");
	    typeDeVenteLabel.setBounds(5, 240, 200, 25);
	    panel.add(typeDeVenteLabel);
	    
	    ButtonGroup vendable = new ButtonGroup();
	    
	    oui = new JRadioButton("Oui");
	    oui.setSelected(true);
	    oui.setBounds(210, 240, 60, 20);
	    vendable.add(oui);
	    panel.add(oui);
	    
	    non = new JRadioButton("Non");
	    non.setBounds(280, 240, 60, 20);
	    vendable.add(non);
	    panel.add(non);
	    

//	    //Le sexe
//	    JPanel panSexe = new JPanel();
//	    panSexe.setBackground(Color.white);
//	    panSexe.setPreferredSize(new Dimension(220, 60));
//	    panSexe.setBorder(BorderFactory.createTitledBorder("Sexe du personnage"));
//	    sexe = new JComboBox();
//	    sexe.addItem("Masculin");
//	    sexe.addItem("Féminin");
//	    sexe.addItem("Indéterminé");
//	    sexeLabel = new JLabel("Sexe : ");
//	    panSexe.add(sexeLabel);
//	    panSexe.add(sexe);
//
//	    //L'âge 
//	    JPanel panAge = new JPanel();
//	    panAge.setBackground(Color.white);
//	    panAge.setBorder(BorderFactory.createTitledBorder("Age du personnage"));
//	    panAge.setPreferredSize(new Dimension(440, 60));
//	    tranche1 = new JRadioButton("15 - 25 ans");
//	    tranche1.setSelected(true);
//	    tranche2 = new JRadioButton("26 - 35 ans");
//	    tranche3 = new JRadioButton("36 - 50 ans");
//	    tranche4 = new JRadioButton("+ de 50 ans");
//	    ButtonGroup bg = new ButtonGroup();
//	    bg.add(tranche1);
//	    bg.add(tranche2);
//	    bg.add(tranche3);
//	    bg.add(tranche4);
//	    panAge.add(tranche1);
//	    panAge.add(tranche2);
//	    panAge.add(tranche3);
//	    panAge.add(tranche4);
//
//	    //La taille
//	    JPanel panTaille = new JPanel();
//	    panTaille.setBackground(Color.white);
//	    panTaille.setPreferredSize(new Dimension(220, 60));
//	    panTaille.setBorder(BorderFactory.createTitledBorder("Taille du personnage"));
//	    tailleLabel = new JLabel("Taille : ");
//	    taille2Label = new JLabel(" cm");
//	    taille = new JTextField("180");
//	    taille.setPreferredSize(new Dimension(90, 25));
//	    panTaille.add(tailleLabel);
//	    panTaille.add(taille);
//	    panTaille.add(taille2Label);
//
//	    //La couleur des cheveux
//	    JPanel panCheveux = new JPanel();
//	    panCheveux.setBackground(Color.white);
//	    panCheveux.setPreferredSize(new Dimension(220, 60));
//	    panCheveux.setBorder(BorderFactory.createTitledBorder("Couleur de cheveux du personnage"));
//	    cheveux = new JComboBox();
//	    cheveux.addItem("Blond");
//	    cheveux.addItem("Brun");
//	    cheveux.addItem("Roux");
//	    cheveux.addItem("Blanc");
//	    cheveuxLabel = new JLabel("Cheveux");
//	    panCheveux.add(cheveuxLabel);
//	    panCheveux.add(cheveux);

	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panel);


	    JPanel control = new JPanel();
	    this.okBouton = new JButton("OK");
	    
	    this.okBouton.addActionListener(this);//new ActionListener(){
//	    	public void actionPerformed(ActionEvent arg0) {
//	    		this.
////	        zInfo = new ZDialogInfo(nom.getText(), (String)sexe.getSelectedItem(), getAge(), (String)cheveux.getSelectedItem() ,getTaille());
////	        setVisible(false);
//	    	}
//
////	      public String getAge(){
////	        return (tranche1.isSelected()) ? tranche1.getText() : 
////	               (tranche2.isSelected()) ? tranche2.getText() : 
////	               (tranche3.isSelected()) ? tranche3.getText() : 
////	               (tranche4.isSelected()) ? tranche4.getText() : 
////	                tranche1.getText();  
////	      }
//
////	      public String getTaille(){
////	        return (taille.getText().equals("")) ? "180" : taille.getText();
////	      }      
//	    });

	    JButton cancelBouton = new JButton("Annuler");
	    cancelBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        setVisible(false);
	      }      
	    });

	    control.add(this.okBouton);
	    control.add(cancelBouton);

//	    this.getContentPane().add(panIcon, BorderLayout.WEST);
	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	}
	
	public void articleOk() {
		this.setVisible(false);
		JOptionPane.showMessageDialog(null, "L'article " + nom.getText() + " a était ajouté avec succé", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		Object  source = e.getSource();
		if(source == this.okBouton) {
			this.gui.getEngine().addArticle(nom.getText(), codeBarre.getText(), quantiteEnStock.getText(), seuilDeReassortiment.getText(), prixDeVente.getText(), (oui.isSelected()? true : false), this.gs, this);
		}
	}  
}