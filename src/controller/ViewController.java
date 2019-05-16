package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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