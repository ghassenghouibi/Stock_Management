package pkg_view;

import javax.swing.*;

import pkg_controller.ViewController;

import java.awt.event.*;

/**
* Add Article is a small Frame allow the user to add new articles 
*/

public class Articles implements ActionListener{

    private JTextField nom,codeBarre,quantiteEnStock,seuilDeReassortiment,prixDeVente;
    private JLabel textNom,textCodeBarre,textQuantiteEnStock,textSeuilDeReassortiment,textPrixDeVente,textTypeDeVente;
    private JRadioButton oui, non;
    private JButton save,cancel;
    private JPanel panel;
    private JFrame myFrame;
    private ViewArticlesTable parent;
    private ViewController viewController;
    private int modify;
    private String modifyNomL;
    private String modifyCodeBarreL;
//    private String modifyQuantiteEnStockL;
//    private String modifySeuilDeReassortimentL;
//    private String modifyPrixDeVenteL;
//    private String modifyTypeDeVenteL;
    
    public Articles(ViewArticlesTable parent){
        createGUI(null, null, null, null, null, null);
        this.parent = parent;
        this.viewController = new ViewController();
        this.modify = -1;
    }
    
    public Articles(ViewArticlesTable parent, String modifyNom, String modifyCodeBarre, String modifyQuantiteEnStock, String modifySeuilDeReassortiment, String modifyPrixDeVente, String modifyTypeDeVente, int row){
        createGUI(modifyNom, modifyCodeBarre, modifyQuantiteEnStock, modifySeuilDeReassortiment, modifyPrixDeVente, modifyTypeDeVente);
        this.parent = parent;
        this.viewController = new ViewController();
        this.modify = row;
        this.modifyNomL = modifyNom;
        this.modifyCodeBarreL = modifyCodeBarre;
//        this.modifyQuantiteEnStockL = modifyQuantiteEnStock;
//        this.modifySeuilDeReassortimentL = modifySeuilDeReassortiment;
//        this.modifyPrixDeVenteL = modifyPrixDeVente;
//        this.modifyTypeDeVenteL = modifyTypeDeVente;
    }

    public void createGUI(String modifyNom,String modifyCodeBarre,String modifyQuantiteEnStock,String modifySeuilDeReassortiment, String modifyPrixDeVente, String modifyTypeDeVente){
        myFrame =new JFrame("Add Article");
        panel = new JPanel();
        
        
        panel.setLayout(null);

        textNom=new JLabel("Nom");
        textNom.setBounds(20,0,200,50);
        panel.add(textNom);
        nom=new JTextField(modifyNom);
        nom.setBounds(200,20,100,20);
        panel.add(nom);

        textCodeBarre=new JLabel("Code barre");
        textCodeBarre.setBounds(20,30,200,50);
        panel.add(textCodeBarre);
        codeBarre=new JTextField(modifyCodeBarre);
        codeBarre.setBounds(200,50,100,20);
        panel.add(codeBarre);

        textQuantiteEnStock=new JLabel("Quantité en stock");
        textQuantiteEnStock.setBounds(20,60,200,50);
        panel.add(textQuantiteEnStock);
        quantiteEnStock=new JTextField(modifyQuantiteEnStock);
        quantiteEnStock.setBounds(200,80,100,20);
        panel.add(quantiteEnStock);

        textSeuilDeReassortiment=new JLabel("Seuil de reassortiment");
        textSeuilDeReassortiment.setBounds(20,90,200,50);
        panel.add(textSeuilDeReassortiment);
        seuilDeReassortiment=new JTextField(modifySeuilDeReassortiment);
        seuilDeReassortiment.setBounds(200,110,100,20);
        panel.add(seuilDeReassortiment);

        textPrixDeVente=new JLabel("Prix de vente");
        textPrixDeVente.setBounds(20,120,200,50);
        panel.add(textPrixDeVente);
        prixDeVente=new JTextField(modifyPrixDeVente);
        prixDeVente.setBounds(200,140,100,20);
        panel.add(prixDeVente);

        textTypeDeVente=new JLabel("Type de vente");
        textTypeDeVente.setBounds(20,160,200,50);
        panel.add(textTypeDeVente);
        
        ButtonGroup choice = new ButtonGroup();
        oui = new JRadioButton("KG");
	    oui.setBounds(200, 180, 60, 20);
	    choice.add(oui);
	    panel.add(oui);
	    
	    non = new JRadioButton("DD");
	    non.setBounds(280, 180, 60, 20);
	    choice.add(non);
	    panel.add(non);
	    if(modifyTypeDeVente == null || modifyTypeDeVente.equals("true")) {
	    	oui.setSelected(true);
	    }else
	    	non.setSelected(true);
        
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
    								if(this.modify == -1) {
    									this.viewController.addArticle(parent, nom.getText(), codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, true);
    								}else {
    									this.viewController.removeArticle(parent, modify, modifyNomL, modifyCodeBarreL);
    									this.viewController.addArticle(parent, nom.getText(), codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, true);
    								}
    								myFrame.setVisible(false);
    							}else {
    								if(this.modify == -1) {
    									this.viewController.addArticle(parent, nom.getText(), codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, false);
    								}else {
    									this.viewController.removeArticle(parent, modify, modifyNomL, modifyCodeBarreL);
    									this.viewController.addArticle(parent, nom.getText(), codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, false);
    								}
    								myFrame.setVisible(false);
    							}
    						}else {
    							JOptionPane.showMessageDialog(null, "Vous devez saisir un prix de vente correct et > � 0", "Attention", JOptionPane.WARNING_MESSAGE);
    						}
    					}else {
    						JOptionPane.showMessageDialog(null, "Vous devez saisir un seuil de reassortiment correct et > � 0", "Attention", JOptionPane.WARNING_MESSAGE);
    					}
    				}
    			}
    		}else {
    			JOptionPane.showMessageDialog(null, "Vous devez saisir un nom", "Attention", JOptionPane.WARNING_MESSAGE);
    		}
    	}
    }
}
