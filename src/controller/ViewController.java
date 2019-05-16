package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.BaseDeDonnes;
import view.*;

public class ViewController {

    private BaseDeDonnes dataBase;

    public ViewController(){
        dataBase=new BaseDeDonnes();
    }
    
    public void checkLogin(JFrame frame,String login,String password){
        int res=dataBase.checkLogin(login,password);
        if(res==1){
            new ViewRetailer(frame);
        }
        else{
            JOptionPane.showMessageDialog(null, "Login or password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    
    public void loadRegisterFrame(JFrame frame){
        new ViewRegister(frame);
    }

    public void loadLoginFrame(JFrame frame){
        new ViewLogin(frame);
    }

    public void registerNewRetailer(JFrame frame,String name,String password){
        dataBase.registerNewRetailer(name, password);
        new ViewRetailer(frame);
    }

    public void registerCancel(JFrame frame){
        new ViewLogin(frame);
    }

    public void menuEngine(int dice,JFrame frame){
        switch (dice){
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


}