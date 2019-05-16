package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Article;
import model.BaseDeDonnes;

import java.awt.event.*;
import java.util.ArrayList;


public class ViewArticlesTable implements ActionListener{

    private JButton add,edit,delete;

    private JPanel panel;
    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu    file;
    private JTable    table;
    private JMenuItem open;
    private JMenuItem print;
    private JMenuItem saveAs;
    private JMenuItem close;

    private JMenu     home;
    private JMenuItem homeView;
    private JMenuItem addCashier;
    private JMenuItem checkDocument;
    private JMenuItem checkAlert;
    
    private JMenu     article;
    private JMenuItem articleViewChartBar;
    private JMenuItem articleViewTable;

    private JMenu     provider;
    private JMenuItem providerView;
    
    private ArrayList<Article> articlesList;
    
    private BaseDeDonnes bdd;

    public ViewArticlesTable(JFrame Frame){
        createGUI(Frame);
        this.articlesList = new ArrayList<Article>();
        this.bdd = new BaseDeDonnes();
    }

    public void createGUI(JFrame myFrame){
        
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().repaint();    
         

        panel = new JPanel();

        panel.setLayout(null);
        //TODO call controller
        this.bdd = new BaseDeDonnes();
        this.articlesList = bdd.loadArticles();
        
        Object[][] data = tabArticle(articlesList);
//        	{
//            {"Apple", "0784745184", "12","150","20$","piece"},
//            {"Banane", "0784745184", "12","150","20$","piece"}
//          };

        //Les titres des colonnes
        String  title[] = {"nom", "code barre", "quantite en stock","seuil de reassortiment","prix de vente","type de vente"};
        table = new JTable(new DefaultTableModel(data, title));
        
        
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

     

        panel.add(listScroller);
		
        panel.add(add);
        panel.add(edit);
        panel.add(delete);

        frame=myFrame;
        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myFrame.dispose();
			}
		});
        myFrame.add(panel);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(800,620);
        myFrame.setVisible(true);
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
        homeView.addActionListener(this);
        addCashier.addActionListener(this);
        checkDocument.addActionListener(this);
        checkAlert.addActionListener(this);

        home.add(homeView);
        home.add(addCashier);
        home.add(checkDocument);
        home.add(checkAlert);

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

    private void msgbox(String text){
        JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog

    }
    
    public Object[][] tabArticle(ArrayList<Article> articles){
    	Object[][] tabArticles;
		int i = 0;
		if(!articles.isEmpty()) {
			tabArticles = new Object[articles.size()][7];
			for(Article a : articles) {
				//tabArticles[i][0] = new Integer(i);
				tabArticles[i][0] = new String(a.getNom());
				tabArticles[i][1] = new Integer(a.getCodeBarre());
				tabArticles[i][2] = new Integer(a.getQuantiteEnStock());
				tabArticles[i][3] = new Integer(a.getSeuilDeReassortiment());
				tabArticles[i][4] = new Integer(a.getPrixDeVente());
				tabArticles[i][5] = new Boolean(a.getTypeDeVente());
				i++;
			}
		}else {
			tabArticles = new Object[1][7];
		}
		return tabArticles;
    }
    
    public void addArticle(String nom, int codeBarre, int quantiteEnStock, int seuilDeReassortiment, int prixDevente, boolean typeDeVente) {
		Object[] article = {nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDevente, typeDeVente};
		ArrayList<Article> articles = new ArrayList<Article>();
		articles.add(new Article(nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDevente, typeDeVente));
		this.bdd.insertArticles(articles);
		((DefaultTableModel)this.table.getModel()).addRow(article);
	}

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == add){
            System.out.println("Adding ...");
            new Articles(this);
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
     

        if (source==homeView){
            new ViewRetailer(frame);
        }
        if (source==providerView){
            new ViewProvider(frame);
        }
        if (source==articleViewTable){
            new ViewArticlesTable(frame);
        }
        if (source==articleViewChartBar){
            new ViewArticlesChartBar(frame);
        }
    }

}