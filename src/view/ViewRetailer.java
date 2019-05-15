package view;

import javax.swing.*;
import java.awt.event.*;



public class ViewRetailer implements ActionListener{

    private JPanel panel;
    private JFrame frame;
    
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

    private JButton money,cashier,alert,document;
    private JLabel solde,numberOfCashier,alerts,documents;


    public ViewRetailer(JFrame frame){
        createGUI(frame);
    }

    public void createGUI(JFrame myFrame){
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().repaint();    
        
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
        openProviderViewhere.addActionListener(this);
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
        solde.setBounds(75,220,100,100);
        panel.add(solde);

        money=new JButton("");
        String iconfilePath = this.getClass().getClassLoader().getResource("images/money.png").getFile();
        money.setIcon(new ImageIcon(iconfilePath));
        money.setBounds(50, 0, 250, 250);
        money.setBorder(BorderFactory.createEmptyBorder());
        money.setContentAreaFilled(false);
        money.setFocusable(false);
        panel.add(money);

        numberOfCashier=new JLabel("4 cashier");
        numberOfCashier.setBounds(75,500,100,100);
        panel.add(numberOfCashier);

        cashier=new JButton("");
        iconfilePath = this.getClass().getClassLoader().getResource("images/cashier.png").getFile();
        cashier.setIcon(new ImageIcon(iconfilePath));
        cashier.setBounds(50, 300, 250, 250);
        cashier.setBorder(BorderFactory.createEmptyBorder());
        cashier.setContentAreaFilled(false);
        cashier.setFocusable(false);
        panel.add(cashier);



        alerts=new JLabel("0 alerts", JLabel.LEFT);
        alerts.setBounds(600,500,100,100);
        panel.add(alerts);
        alert=new JButton("");
        iconfilePath = this.getClass().getClassLoader().getResource("images/alert.png").getFile();
        alert.setIcon(new ImageIcon(iconfilePath));
        alert.setBounds(500, 300, 250, 250);
        alert.setBorder(BorderFactory.createEmptyBorder());
        alert.setContentAreaFilled(false);
        alert.setFocusable(false);
        panel.add(alert);

        documents=new JLabel("2 documents", JLabel.LEFT);
        documents.setBounds(600,220,100,100);
        panel.add(documents);
        document=new JButton("");
        iconfilePath = this.getClass().getClassLoader().getResource("images/document.png").getFile();
        document.setIcon(new ImageIcon(iconfilePath));
        document.setBounds(500, 0, 250, 250);
        document.setBorder(BorderFactory.createEmptyBorder());
        document.setContentAreaFilled(false);
        document.setFocusable(false);
        panel.add(document);

        
        myFrame.add(panel);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(800,620);
        myFrame.setVisible(true);
        frame=myFrame;
        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
    }




    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==openProviderView){
            new ViewProvider(frame);
        }
    }

}