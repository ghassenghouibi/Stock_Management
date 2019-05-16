package view;

import javax.swing.*;

import controller.ViewController;

import java.awt.event.*;

/**
* Add Article is a small Frame allow the user to add new articles 
*/

public class Articles implements ActionListener{

    private JTextField nom,codeBarre,quantiteEnStock,seuilDeReassortiment,prixDeVente,typeDeVente;
    private JLabel textNom,textCodeBarre,textQuantiteEnStock,textSeuilDeReassortiment,textPrixDeVente,textTypeDeVente;
    private JRadioButton oui, non;
    private JButton save,cancel;
    private JPanel panel;
    private JFrame myFrame;
    private ViewArticlesTable parent;
    private ViewController viewController;
    
    public Articles(ViewArticlesTable parent){
        createGUI();
        this.parent = parent;
        this.viewController = new ViewController();
    }

    public void createGUI(){
        myFrame =new JFrame("Add Article");
        panel = new JPanel();
        
        panel.setLayout(null);

        textNom=new JLabel("Nom");
        textNom.setBounds(20,0,200,50);
        panel.add(textNom);
        nom=new JTextField();
        nom.setBounds(200,20,100,20);
        panel.add(nom);

        textCodeBarre=new JLabel("Code barre");
        textCodeBarre.setBounds(20,30,200,50);
        panel.add(textCodeBarre);
        codeBarre=new JTextField();
        codeBarre.setBounds(200,50,100,20);
        panel.add(codeBarre);

        textQuantiteEnStock=new JLabel("QuantitÃ© en stock");
        textQuantiteEnStock.setBounds(20,60,200,50);
        panel.add(textQuantiteEnStock);
        quantiteEnStock=new JTextField();
        quantiteEnStock.setBounds(200,80,100,20);
        panel.add(quantiteEnStock);

        textSeuilDeReassortiment=new JLabel("Seuil de reassortiment");
        textSeuilDeReassortiment.setBounds(20,90,200,50);
        panel.add(textSeuilDeReassortiment);
        seuilDeReassortiment=new JTextField();
        seuilDeReassortiment.setBounds(200,110,100,20);
        panel.add(seuilDeReassortiment);

        textPrixDeVente=new JLabel("Prix de vente");
        textPrixDeVente.setBounds(20,120,200,50);
        panel.add(textPrixDeVente);
        prixDeVente=new JTextField();
        prixDeVente.setBounds(200,140,100,20);
        panel.add(prixDeVente);

        textTypeDeVente=new JLabel("Type de vente");
        textTypeDeVente.setBounds(20,160,200,50);
        panel.add(textTypeDeVente);
        
        ButtonGroup choice = new ButtonGroup();
        oui = new JRadioButton("Oui");
	    oui.setSelected(true);
	    oui.setBounds(200, 180, 60, 20);
	    choice.add(oui);
	    panel.add(oui);
	    
	    non = new JRadioButton("Non");
	    non.setBounds(280, 180, 60, 20);
	    choice.add(non);
	    panel.add(non);
        
        save=new JButton("Save");
        save.setBounds(210,250,100,20);
        save.addActionListener(this);
        panel.add(save);

        cancel=new JButton("Cancel");
        cancel.setBounds(80,250,100,20);
        cancel.addActionListener(this);
        panel.add(cancel);
        myFrame.add(panel);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(400,320);
        myFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == cancel){
            myFrame.setVisible(false);
        }
        if(source == save){
        	if(!nom.getText().equals("")) {
    			int codeBarreInt;
    			try {
    				codeBarreInt = Integer.parseInt(codeBarre.getText());
    			} catch (NumberFormatException e2) {
    				// TODO: handle exception
    				JOptionPane.showMessageDialog(null, "Vous devez saisir un code barre correct", "Attention", JOptionPane.WARNING_MESSAGE);
    				codeBarreInt = 0;
    			}

    			if(codeBarreInt > 0) {
    				int quantiteEnStockInt;
    				try {
    					quantiteEnStockInt = Integer.parseInt(quantiteEnStock.getText());
    				} catch (NumberFormatException e2) {
    					// TODO: handle exception
    					JOptionPane.showMessageDialog(null, "Vous devez saisir une quantite de stock correct", "Attention", JOptionPane.WARNING_MESSAGE);
    					quantiteEnStockInt = -1;
    				}
    				
    				if(quantiteEnStockInt >= 0) {
    					int seuilDeReassortimentInt;
    					try {
    						seuilDeReassortimentInt = Integer.parseInt(seuilDeReassortiment.getText());
    					} catch (NumberFormatException e2) {
    						// TODO: handle exception
    						seuilDeReassortimentInt = 0;
    					}
    					if(seuilDeReassortimentInt > 0) {
    						int prixDeVenteInt;
    						try {
    							prixDeVenteInt = Integer.parseInt(prixDeVente.getText());
    						} catch (NumberFormatException e2) {
    							// TODO: handle exception
    							prixDeVenteInt = 0;
    						}
    						if(prixDeVenteInt > 0) {
    							if(oui.isSelected()) {
    								this.viewController.addArticle(parent, nom.getText(), codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, true);
    								myFrame.setVisible(false);
//    								Article article = new Article(nom, codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, typeDeVente);
//    								this.detaillant.ajouterUnNouveauArticle(article);
//    								this.articles = updateListeArticles();
//    								gs.setArticles(this.articles);
//    								gs.addArticle(nom, codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, typeDeVente);
//    								source.articleOk();
    							}else {
    								this.viewController.addArticle(parent, nom.getText(), codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, false);
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
    			JOptionPane.showMessageDialog(null, "Vous devez saisir un nom", "Attention", JOptionPane.WARNING_MESSAGE);
    		}
    	}
    }
}
