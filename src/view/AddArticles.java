package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class AddArticles implements ActionListener{

    private JTextField nom,codeBarre,quantiteEnStock,seuilDeReassortiment,prixDeVente,typeDeVente;
    private JLabel textNom,textCodeBarre,textQuantiteEnStock,textSeuilDeReassortiment,textPrixDeVente,textTypeDeVente;
    private JButton save,cancel;
    private JPanel panel;
    private JFrame myFrame;


    public AddArticles(){
        createGUI();
    }

    public void createGUI(){
        myFrame =new JFrame("Add Article");
        //myFrame.setPreferredSize(new Dimension(800,620));
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

        textQuantiteEnStock=new JLabel("Quantité en stock");
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
        textTypeDeVente.setBounds(20,150,200,50);
        panel.add(textTypeDeVente);
        typeDeVente=new JTextField();
        typeDeVente.setBounds(200,170,100,20);
        panel.add(typeDeVente);

        save=new JButton("Save");
        save.setBounds(210,250,100,20);
        save.addActionListener(this);
        panel.add(save);

        cancel=new JButton("Cancel");
        cancel.setBounds(80,250,100,20);
        cancel.addActionListener(this);
        panel.add(cancel);

        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("closed");
			}
        });
        myFrame.add(panel);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(400,320);
        myFrame.setVisible(true);
    }






    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == cancel){
            System.out.println("Cancel ..");
            myFrame.setVisible(false);
        }
        if(source == save){
            System.out.println("Save ..");
        }
        
    }





}