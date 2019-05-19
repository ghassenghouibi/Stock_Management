package pkg_view;

import javax.swing.*;

import pkg_controller.ViewController;

import java.awt.event.*;



public class ViewRetailer implements ActionListener{

    private JPanel    panel;
    private JFrame    frame;
    
    private JMenuBar  menuBar;
    private JMenu     file;
    private JMenuItem open;
    private JMenuItem print;
    private JMenuItem saveAs;
    private JMenuItem close;

    private JMenu     home;
    private JMenuItem homeView;
    private JMenuItem addCashier;
    private JMenuItem checkDocument;
    private JMenuItem checkAlert;
    private JMenuItem deconnexion;
    private JMenu     article;
    private JMenuItem articleViewChartBar;
    private JMenuItem articleViewTable;

    private JMenu     provider;
    private JMenuItem providerView;
    
    private ViewController viewController;
    

    private JButton money,cashier,alert,document;
    private JLabel solde,numberOfCashier,alerts,documents;


    public ViewRetailer(JFrame frame){
        createGUI(frame);
        viewController=new ViewController();
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

        //file
        file=new JMenu("file");
        open=new JMenuItem("open");
        print=new JMenuItem("print");
        saveAs=new JMenuItem("save as");
        close=new JMenuItem("close");
        file.add(open);
        file.add(print);
        file.add(saveAs);
        file.add(close);


        //home
        home=new JMenu("home");
        homeView=new JMenuItem("home view");
        addCashier=new JMenuItem("add cashier");
        checkDocument=new JMenuItem("check document");
        checkAlert=new JMenuItem("check alert");
        deconnexion=new JMenuItem("deconnexion");
        homeView.addActionListener(this);
        addCashier.addActionListener(this);
        checkDocument.addActionListener(this);
        checkAlert.addActionListener(this);
        deconnexion.addActionListener(this);

        home.add(homeView);
        home.add(addCashier);
        home.add(checkDocument);
        home.add(checkAlert);
        home.add(deconnexion);

        //Article
        article=new JMenu("article");
        articleViewChartBar=new JMenuItem("article view chartBar");
        articleViewTable=new JMenuItem("article view table ");
        articleViewChartBar.addActionListener(this);
        articleViewTable.addActionListener(this);
        article.add(articleViewChartBar);
        article.add(articleViewTable);
          
        provider=new JMenu("provider");
        providerView=new JMenuItem("provider view");
        providerView.addActionListener(this);
        provider.add(providerView);


        menuBar.add(file);
        menuBar.add(home);
        menuBar.add(article);
        menuBar.add(provider);

        myFrame.setJMenuBar(menuBar);
    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source==homeView){
            viewController.menuEngine(1, frame);
        }
        if (source==providerView){
            viewController.menuEngine(2, frame);
        }
        if (source==articleViewTable){
            viewController.menuEngine(3, frame);
        }
        if (source==articleViewChartBar){
            viewController.menuEngine(4, frame);
        }
        if (source==deconnexion){
            viewController.menuEngine(5, frame);
        }

        if (source==checkAlert || source==checkDocument){
            //TODO send mail
        }
        if(source==addCashier){
            //TODO add cashier
        }

    }

}