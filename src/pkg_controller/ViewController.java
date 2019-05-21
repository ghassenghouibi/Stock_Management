/**
* This class contain the controller of views in application, controller function 
* access to data base and allow modification done by the user also this class assures
* connection of users  
* @author:groupe 5
* @version:0.2
*/

package pkg_controller;



import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import pkg_model.BaseDeDonnes;
import pkg_utils.Article;
import pkg_utils.ProviderInfo;
import pkg_view.ProviderDialog;
import pkg_view.ViewArticlesChartBar;
import pkg_view.ViewArticlesTable;
import pkg_view.ViewLogin;
import pkg_view.ViewProvider;
import pkg_view.ViewRegister;
import pkg_view.ViewRetailer;

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
		Article article = new Article(nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDevente, typeDeVente);
		dataBase.insertArticles(article);
		((DefaultTableModel)parent.getTable().getModel()).addRow(articleObj);

    }
    
    
    public void removeArticle(ViewArticlesTable parent, int row, String nom, String codeBarre) {
    	dataBase.deleteArticle(nom, codeBarre);
    	((DefaultTableModel)parent.getTable().getModel()).removeRow(row);
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

    public void addNewProvider(JFrame myFrame,ProviderInfo fournisseur) {
       
        dataBase.insertProvider(fournisseur);
        JOptionPane.showMessageDialog(null, "Provider added with success ! ", "Added", JOptionPane.PLAIN_MESSAGE);
        new ViewProvider(myFrame);
    }

    public void addProvider(String title, JFrame myFrame) {
        new ProviderDialog(myFrame);
    }


    public void modifyThisProvider(JFrame myFrame,ProviderInfo provider){
        dataBase.modifyProvider(provider.getId(),provider.getProduct(),provider.getNomProvider(),provider.getAdresse(),provider.getCodePostal(),provider.getNumeroDeTelephone());
        JOptionPane.showMessageDialog(null, "Provider modification done with success ! ", "Modification", JOptionPane.PLAIN_MESSAGE);
        new ViewProvider(myFrame);
    }
    public void modifyProvider(JFrame myFrame,int id,String modifyproduit,String modifynom,String modifyadresse,String modifycodePostale,String modifytelephone){
        new ProviderDialog(myFrame,id,modifyproduit,modifynom,modifyadresse,modifycodePostale,modifytelephone);
    }


    public void deleteProvider(JFrame myFrame,int id){
        dataBase.deleteProvider(id);
        JOptionPane.showMessageDialog(null, "Provider Deleted with success ! ", "Deleted", JOptionPane.PLAIN_MESSAGE);
        myFrame.repaint();
    }

    public void orderFromProvider(JFrame myFrame,String product) {
    	JOptionPane.showInputDialog(null, "Quantité ?");
        myFrame.repaint();
    	
    }

}