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

    private JMenu home;
    private JMenuItem homeView;
    private JMenuItem addCashier;
    private JMenuItem checkDocument;
    private JMenuItem checkAlert;
    
    private JMenu articleView;
    private JMenuItem openArticleView;
    private JMenuItem openArticleViewhere;
    private JMenuItem listAllArticles;

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
        createMenu(myFrame);
        panel.setLayout(null);
        
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
                System.out.println("Herre");
			}
		});
    }

    public void createMenu(JFrame myFrame){
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

        home=new JMenu("home");
        homeView=new JMenuItem("home view");
        addCashier=new JMenuItem("add cashier");
        checkDocument=new JMenuItem("check document");
        checkAlert=new JMenuItem("check alert");

        home.add(homeView);
        home.add(addCashier);
        home.add(checkDocument);
        home.add(checkAlert);

        articleView=new JMenu("article view");
        openArticleView=new JMenuItem("open article view");
        listAllArticles=new JMenuItem("list of all articles ");
        openArticleViewhere=new JMenuItem("open article view here");
        openArticleView.addActionListener(this);
        articleView.add(openArticleView);
        articleView.add(openArticleViewhere);
        articleView.add(listAllArticles);
          
        providerView=new JMenu("provider view");
        openProviderView=new JMenuItem("open provider view");
        openProviderViewhere=new JMenuItem("open provider view here");
        openProviderView.addActionListener(this);
        openProviderViewhere.addActionListener(this);
        providerView.add(openProviderView);
        providerView.add(openProviderViewhere);

        about=new JMenu("about");
        aboutus=new JMenuItem("about us");
        about.add(aboutus);
        menuBar.add(file);
        menuBar.add(home);
        menuBar.add(articleView);
        menuBar.add(providerView);
        menuBar.add(about);
        myFrame.setJMenuBar(menuBar);
    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==openProviderView){
            new ViewProvider(frame);
        }
        if (source==openArticleView){
            System.out.println("hahahahah");
            new ViewArticles();
        }
    }

}