package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class ViewEngine extends JFrame{
    private JPanel panel = new JPanel();
    private JButton button = new JButton("Mon bouton");

    public ViewEngine(){
        super();
        this.setTitle("Gestion De Stock");
        this.setSize(800, 620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        

        Object[][] data = {
          {"héroine", "Booba", "USA","2045","566666666"},
          {"cocaine", "Karis", "st denis","9300","55555"},
          {"mary", "PNL", "terter","9100","666666"}
        };
    
        //Les titres des colonnes
        String  title[] = {"Produit", "Nom", "Adresse","code postale","téléphone"};
        JTable tableau = new JTable(data, title);
        tableau.setPreferredSize(new Dimension(800,620));
        
        JButton btnNewButton = new JButton("");
        String iconfilePath = this.getClass().getClassLoader().getResource("../images/add.png").getFile();
        btnNewButton.setIcon(new ImageIcon(iconfilePath));
        btnNewButton.setBounds(10, 438, 39, 31);
        btnNewButton.setBorder(BorderFactory.createEmptyBorder());
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusable(false);

        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
    

        panel.add(new JScrollPane(tableau), gbc);
        panel.add(btnNewButton);
        
        
        this.setContentPane(panel);
        this.setVisible(true);
      
    }
         
}