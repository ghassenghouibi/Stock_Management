package controller;

import java.awt.Dialog;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.BaseDeDonnes;
import view.*;

public class ViewController {

    private BaseDeDonnes dataBase;

    public ViewController() {
        dataBase = new BaseDeDonnes();
    }

    public void checkLogin(JFrame frame, String login, String password) {
        int res = dataBase.checkLogin(login, password);
        if (res == 1) {
            new ViewRetailer(frame);
        } else {
            JOptionPane.showMessageDialog(null, "Login or password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void addArticle(ViewArticlesTable parent, String nom, int codeBarre, int quantiteEnStock, int seuilDeReassortiment, int prixDevente, boolean typeDeVente) {
		Object[] articleObj = {nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDevente, typeDeVente};
		ArrayList<Article> articles = new ArrayList<Article>();
		Article article = new Article(nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDevente, typeDeVente);
		articles.add(article);
		dataBase.insertArticles(articles);
		if(parent.getArticlesList().isEmpty()) {
			((DefaultTableModel)parent.getTable().getModel()).removeRow(0);
			parent.getArticlesList().add(article);
			((DefaultTableModel)parent.getTable().getModel()).addRow(articleObj);
		}else {
			parent.getArticlesList().add(article);
			((DefaultTableModel)parent.getTable().getModel()).addRow(articleObj);
		}
	}
    
   

    public void loadRegisterFrame(JFrame frame) {
        new ViewRegister(frame);
    }

    public void loadLoginFrame(JFrame frame) {
        new ViewLogin(frame);
    }

    public void registerNewRetailer(JFrame frame, String name, String password) {
        dataBase.registerNewRetailer(name, password);
        new ViewRetailer(frame);
    }

    public void registerCancel(JFrame frame) {
        new ViewLogin(frame);
    }

    public void menuEngine(int dice, JFrame frame) {
        switch (dice) {
        case 1:
            new ViewRetailer(frame);
            break;
        case 2:
            new ViewProvider(frame);
            break;
        case 3:
            new ViewArticlesTable(frame);
            break;
        case 4:
            new ViewArticlesChartBar(frame);
            break;
        case 5:
            new ViewLogin(frame);
            break;
        }
    }

    public int getProviderValue(JFrame myFrame, Fournisseur fournisseur) {
        if (fournisseur == null)
            return 0;
        
        dataBase.insertProvider(fournisseur);
        JOptionPane.showMessageDialog(null, "Provider added with success ! ", "Added", JOptionPane.PLAIN_MESSAGE);
        myFrame.setVisible(false);
        myFrame.dispose();
        
        return 1;
    }

    public void addProvider(String title,JFrame myFrame){
        //new ProviderDialog(title);
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
  
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        

       JPanel panel = new JPanel();
                

        JTextField produit,nom,adresse,codePostale,telephone;
        JLabel textNom,textAdresse,textCodePostale,textTelephone,textProduit;
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        textNom=new JLabel("Nom");
        panel.add(textNom);
        nom=new JTextField(10);
        panel.add(nom);
        panel.add(Box.createHorizontalStrut(15)); // a spacer
        textProduit=new JLabel("Produit");
        panel.add(textProduit);
        produit=new JTextField("");
        panel.add(produit);

        textAdresse=new JLabel("Adresse");
        textAdresse.setBounds(20,60,200,50);
        panel.add(textAdresse);
        adresse=new JTextField("");
        adresse.setBounds(200,80,100,20);
        panel.add(adresse);

        textCodePostale=new JLabel("Code postale");
        textCodePostale.setBounds(20,90,200,50);
        panel.add(textCodePostale);
        codePostale=new JTextField("");
        codePostale.setBounds(200,110,100,20);
        panel.add(codePostale);

        textTelephone=new JLabel("Téléphone");
        textTelephone.setBounds(20,120,200,50);
        panel.add(textTelephone);
        telephone=new JTextField("");
        telephone.setBounds(200,140,100,20);
        panel.add(telephone);

        int result = JOptionPane.showConfirmDialog(null, panel,"Add Article", JOptionPane.OK_CANCEL_OPTION);

    }


}