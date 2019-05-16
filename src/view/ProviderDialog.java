package view;

import javax.swing.*;

import java.awt.event.*;
import controller.*;

public class ProviderDialog implements ActionListener{

    private JTextField      produit,nom,adresse,codePostale,telephone;
    private JLabel          textNom,textAdresse,textCodePostale,textTelephone,textProduit;
    private JButton         save,cancel;
    private JPanel          panel;
    private JDialog         dialog;
    private ViewController  viewController;
    private JFrame          myFrame;
    private boolean         option;
    private int             id;

    public ProviderDialog(JFrame myFrame,int id,String modifyproduit,String modifynom,String modifyadresse,String modifycodePostale,String modifytelephone){
        createGUI(myFrame,modifynom,modifyproduit,modifyadresse,modifycodePostale,modifytelephone);
        viewController=new ViewController();
        this.myFrame=myFrame;
        this.option=false;
        this.id=id;
    }
    public ProviderDialog(JFrame myFrame){
        createGUI(myFrame,null,null,null,null,null);
        viewController=new ViewController();
        this.myFrame=myFrame;
        this.option=true;

    }
    public void createGUI(JFrame myFrame,String modifynom,String modifyproduit,String modifyadresse,String modifycodePostale,String modifytelephone){
        
        panel = new JPanel();
        panel.setLayout(null);

        textNom=new JLabel("Nom");
        textNom.setBounds(20,0,200,50);
        panel.add(textNom);
        nom=new JTextField(modifynom);
        nom.setBounds(200,20,100,20);
        panel.add(nom);

        textProduit=new JLabel("Produit");
        textProduit.setBounds(20,30,200,50);
        panel.add(textProduit);
        produit=new JTextField(modifyproduit);
        produit.setBounds(200,50,100,20);
        panel.add(produit);


        textAdresse = new JLabel("Adresse");
        textAdresse.setBounds(20, 60, 200, 50);
        panel.add(textAdresse);
        adresse = new JTextField(modifyadresse);
        adresse.setBounds(200, 80, 100, 20);
        panel.add(adresse);

        textCodePostale = new JLabel("Code postale");
        textCodePostale.setBounds(20, 90, 200, 50);
        panel.add(textCodePostale);
        codePostale = new JTextField(modifycodePostale);
        codePostale.setBounds(200, 110, 100, 20);
        panel.add(codePostale);

        textTelephone = new JLabel("Téléphone");
        textTelephone.setBounds(20, 120, 200, 50);
        panel.add(textTelephone);
        telephone = new JTextField(modifytelephone);
        telephone.setBounds(200, 140, 100, 20);
        panel.add(telephone);
        
        save = new JButton("Save");
        save.setBounds(210, 250, 100, 20);
        save.addActionListener(this);
        panel.add(save);

        cancel = new JButton("Cancel");
        cancel.setBounds(80, 250, 100, 20);
        cancel.addActionListener(this);
        panel.add(cancel);

        dialog=new JDialog();

        dialog.add(panel);
        dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dialog.setVisible(false);
			}
        });
        dialog.setSize(400,320);
        dialog.setVisible(true);
        
    }
  
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == cancel){
            dialog.setVisible(false);
        }
        if(source == save){
            String newTabNom,newTabProduit,newTabAdresse;
            int newTabCodePostale,newTabTelephone;
            try {
                
                newTabNom =nom.getText();
                newTabProduit=produit.getText();
                newTabAdresse=adresse.getText();
                newTabCodePostale=Integer.parseInt(codePostale.getText());
                newTabTelephone=Integer.parseInt(telephone.getText());
                if(newTabNom !="" && newTabProduit !="" && newTabAdresse!=""){
                    if(option){
                        viewController.addNewProvider(myFrame,new ProviderInfo(0,newTabNom,newTabProduit,newTabAdresse,newTabCodePostale,newTabTelephone));
                        dialog.setVisible(false);
                    }
                    else{
                        viewController.modifyThisProvider(myFrame,new ProviderInfo(id,newTabNom,newTabProduit,newTabAdresse,newTabCodePostale,newTabTelephone));
                        dialog.setVisible(false);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please fill all fileds", "Error", JOptionPane.ERROR_MESSAGE);
                }
                         
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "You have to fill correctly fields below", "Attention", JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }

}