package controller;

<<<<<<< HEAD
=======
import java.awt.Dialog;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
>>>>>>> cf4498a1e395b2b457f035ead3954b766abf0f25
import javax.swing.JFrame;
import javax.swing.JOptionPane;
<<<<<<< HEAD
=======
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
>>>>>>> cf4498a1e395b2b457f035ead3954b766abf0f25

import model.BaseDeDonnes;
import view.*;

public class ViewController{

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

    public void addNewProvider(JFrame myFrame,Fournisseur fournisseur) {
       
        dataBase.insertProvider(fournisseur);
        JOptionPane.showMessageDialog(null, "Provider added with success ! ", "Added", JOptionPane.PLAIN_MESSAGE);
        new ViewProvider(myFrame);
    }

    public void addProvider(String title, JFrame myFrame) {
        new ProviderDialog(myFrame);
    }

    public void modifyProvider(JFrame myFrame,String modifyproduit,String modifynom,String modifyadresse,String modifycodePostale,String modifytelephone){
        new ProviderDialog(myFrame,modifyproduit,modifynom,modifyadresse,modifycodePostale,modifytelephone);
    }


    public void deleteProvider(JFrame myFrame,String product,String name,String adress,int postalCode,int phoneNumber){
        dataBase.deleteProvider(name,product,adress,postalCode,phoneNumber);
        JOptionPane.showMessageDialog(null, "Provider Deleted with success ! ", "Deleted", JOptionPane.PLAIN_MESSAGE);
        myFrame.repaint();
    }



}