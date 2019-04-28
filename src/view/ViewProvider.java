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
import java.util.ArrayList;


public class ViewProvider implements ActionListener{

    private JButton add,edit,order,delete;
    private JPanel panel;
    private JFrame myFrame;
    private JTable table ;
    
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem open;
    private JMenuItem print;
    private JMenuItem saveAs;
    private JMenuItem close;

    private JMenu homeView;
    private JMenuItem openHomeView;
    private JMenuItem openHomeViewhere;
    
    private JMenu articleView;
    private JMenuItem openArticleView;
    private JMenuItem openArticleViewhere;

    private JMenu providerView;
    private JMenuItem openProviderView;
    private JMenuItem openProviderViewhere;

    private JMenu about;
    private JMenuItem aboutus;


    public ViewProvider(){
        createGUI();
    }

    public void createGUI(){
        myFrame =new JFrame();
        //myFrame.setPreferredSize(new Dimension(800,620));
        panel = new JPanel();

        panel.setLayout(null);
        Object[][] data = {
            {"héroine", "Booba", "USA","2045","566666666"},
            {"cocaine", "Karis", "st denis","9300","55555"},
            {"mary", "PNL", "terter","9100","666666"},
            {"héroine", "Booba", "USA","2045","566666666"},
            {"cocaine", "Karis", "st denis","9300","55555"},
            {"mary", "PNL", "terter","9100","666666"},
            {"héroine", "Booba", "USA","2045","566666666"},
            {"cocaine", "Karis", "st denis","9300","55555"},
            {"mary", "PNL", "terter","9100","666666"},
            {"héroine", "Booba", "USA","2045","566666666"},
            {"cocaine", "Karis", "st denis","9300","55555"},
            {"mary", "PNL", "terter","9100","666666"},
            {"héroine", "Booba", "USA","2045","566666666"},
            {"cocaine", "Karis", "st denis","9300","55555"},
            {"mary", "PNL", "terter","9100","666666"},
            {"héroine", "Booba", "USA","2045","566666666"},
            {"cocaine", "Karis", "st denis","9300","55555"},
            {"mary", "PNL", "terter","9100","666666"},
            {"héroine", "Booba", "USA","2045","566666666"},
            {"cocaine", "Karis", "st denis","9300","55555"},
            {"mary", "PNL", "terter","9100","666666"},
            {"héroine", "Booba", "USA","2045","566666666"},
            {"cocaine", "Karis", "st denis","9300","55555"},
            {"mary", "PNL", "terter","9100","666666"}
          };
      
        //Les titres des colonnes
        String  title[] = {"Produit", "Nom", "Adresse","code postale","téléphone"};
        table= new JTable(data, title);
        
        menuBar=new JMenuBar();

        file=new JMenu("file");
        open=new JMenuItem("open");
        print=new JMenuItem("print");
        saveAs=new JMenuItem("save as");
        close=new JMenuItem("close");

        file.add(open);
        file.add(print);
        file.add(saveAs);
        file.add(close);
        
        homeView=new JMenu("home view");
        openHomeView=new JMenuItem("open home view");
        openHomeViewhere=new JMenuItem("open home view here");
        homeView.add(openHomeView);
        homeView.add(openHomeViewhere);
        
        articleView=new JMenu("article view");
        openArticleView=new JMenuItem("open article view");
        openArticleViewhere=new JMenuItem("open article view here");
        articleView.add(openArticleView);
        articleView.add(openArticleViewhere);
          
        providerView=new JMenu("provider view");
        openProviderView=new JMenuItem("open provider view");
        openProviderViewhere=new JMenuItem("open provider view here");
        providerView.add(openProviderView);
        providerView.add(openProviderViewhere);

        about=new JMenu("about");
        aboutus=new JMenuItem("about us");
        about.add(aboutus);

        menuBar.add(file);
        menuBar.add(homeView);
        menuBar.add(articleView);
        menuBar.add(providerView);
        menuBar.add(about);

        myFrame.setJMenuBar(menuBar);
        
		JScrollPane listScroller = new JScrollPane(table);
		listScroller.setBounds(0, 100, 800, 600);
		
        
        add = new JButton("");
        String iconfilePath = this.getClass().getClassLoader().getResource("images/add.png").getFile();
        add.setIcon(new ImageIcon(iconfilePath));
        add.setBounds(550, 0, 100, 50);
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setContentAreaFilled(false);
        add.setFocusable(false);
        add.addActionListener(this);

        edit = new JButton("");
        
        String iconfilePathedit = this.getClass().getClassLoader().getResource("images/edit.png").getFile();
        edit.setIcon(new ImageIcon(iconfilePathedit));
        edit.setBounds(600, 0, 100, 50);
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.setContentAreaFilled(false);
        edit.setFocusable(false);
        edit.addActionListener(this);

        delete = new JButton("");
        
        String iconfilePathdelete = this.getClass().getClassLoader().getResource("images/delete.png").getFile();
        delete.setIcon(new ImageIcon(iconfilePathdelete));
        delete.setBounds(650, 0, 100, 50);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setContentAreaFilled(false);
        delete.setFocusable(false);
        delete.addActionListener(this);

        order = new JButton("");
        
        String iconfilePathorder = this.getClass().getClassLoader().getResource("images/order.png").getFile();
        order.setIcon(new ImageIcon(iconfilePathorder));
        order.setBounds(700, 0, 100, 50);
        order.setBorder(BorderFactory.createEmptyBorder());
        order.setContentAreaFilled(false);
        order.setFocusable(false);
        order.addActionListener(this);

        panel.add(listScroller);
		
        panel.add(add);
        panel.add(edit);
        panel.add(delete);
        panel.add(order);

        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        myFrame.add(panel);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(800,620);
        myFrame.setVisible(true);
    }




    private void msgbox(String text){
        JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog

     }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == add){
            System.out.println("Adding ...");
            new Provider("Add Provider",null,null,null,null,null);

        }
        if(source==delete){
            if(table.getSelectedRow()==-1){
                msgbox("Please select a row");
            }

        }
        if(source== edit){
            if(table.getSelectedRow()==-1){
                msgbox("Please select a row");
            }else{
                int column = 0;
                int row = table.getSelectedRow();
                ArrayList<String> x =new ArrayList<String>();
                for(int i=0;i<5;i++){
                    String value = table.getModel().getValueAt(row, i).toString();
                    System.out.println(value);
                    x.add(value);
                }
                new Provider("Modify Provider",x.get(0),x.get(1),x.get(2),x.get(3),x.get(4));
            }
        }
        if(source == order){
            if(table.getSelectedRow()==-1){
                msgbox("Please select a row");
            }
        }
    }

}