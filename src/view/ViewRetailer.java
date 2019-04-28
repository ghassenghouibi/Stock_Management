package view;

import javax.swing.*;
import java.awt.event.*;



public class ViewRetailer implements ActionListener{

    private JPanel panel;
    private JFrame myFrame;
    
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

    private JLabel solde,numberOfCashier,time,alerts,documents;


    public ViewRetailer(){
        createGUI();
    }

    public void createGUI(){
        myFrame =new JFrame();
        panel = new JPanel();

        panel.setLayout(null);
        
        
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
        openProviderView.addActionListener(this);
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

        solde= new JLabel("Solde 10000$");
        solde.setBounds(400,0,100,100);
        panel.add(solde);

        numberOfCashier=new JLabel("4 cashier");
        numberOfCashier.setBounds(400,100,100,100);
        panel.add(numberOfCashier);

        time=new JLabel("20/20/2020", JLabel.LEFT);
        time.setBounds(400,200,100,100);
        panel.add(time);

        alerts=new JLabel("0 alerts", JLabel.LEFT);
        alerts.setBounds(400,300,100,100);
        panel.add(alerts);

        documents=new JLabel("2 documents", JLabel.LEFT);
        documents.setBounds(400,400,100,100);
        panel.add(documents);

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
        if (source==openProviderView){
            new ViewProvider();
        }
    }

}