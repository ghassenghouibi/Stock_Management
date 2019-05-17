package view;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import controller.Article;
//import model.BaseDeDonnes;


import controller.ViewController;
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
    private JMenuItem deconnexion;

    private JMenu     article;
    private JMenuItem articleViewChartBar;
    private JMenuItem articleViewTable;

    private JMenu     provider;
    private JMenuItem providerView;
    
    

    private ViewController viewController;

    
    private BaseDeDonnes bdd;

	private ArrayList<Article> articlesList;

    public ViewArticlesTable(JFrame Frame){
        createGUI(Frame);
        
        this.articlesList = new ArrayList<Article>();
//        this.bdd = new BaseDeDonnes();

        viewController=new ViewController();

    }

    public void createGUI(JFrame myFrame){
        
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().repaint();    
         

        panel = new JPanel();

        panel.setLayout(null);
        //TODO call controller
        
        this.bdd = new BaseDeDonnes();
        this.articlesList = bdd.loadArticles();

        //Les titres des colonnes
        String  title[] = {"nom", "code barre", "quantite en stock","seuil de reassortiment","prix de vente","type de vente"};
        table = new JTable(new DefaultTableModel(title, 0));
        
        for(Article a : this.articlesList) {
        	 Object[] obj = { a.getNom(), a.getCodeBarre(), a.getQuantiteEnStock(), a.getSeuilDeReassortiment(), a.getPrixDeVente(), a.getTypeDeVente() };
        	 ((DefaultTableModel)this.table.getModel()).addRow(obj);
        }
        
        
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
    
    
    public BaseDeDonnes getBdd() {
		return bdd;
	}

	public void setBdd(BaseDeDonnes bdd) {
		this.bdd = bdd;
	}

    public ArrayList<Article> getArticlesList() {
		return articlesList;
	}

	public void setArticlesList(ArrayList<Article> articlesList) {
		this.articlesList = articlesList;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
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

    private void msgbox(String text){
        JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog

    }
    
//    public Object[][] tabArticle(ArrayList<Article> articles){
//    	Object[][] tabArticles;
//		int i = 0;
//		if(!articles.isEmpty()) {
//			tabArticles = new Object[articles.size()][7];
//			for(Article a : articles) {
//				//tabArticles[i][0] = new Integer(i);
//				tabArticles[i][0] = new String(a.getNom());
//				tabArticles[i][1] = new Integer(a.getCodeBarre());
//				tabArticles[i][2] = new Integer(a.getQuantiteEnStock());
//				tabArticles[i][3] = new Integer(a.getSeuilDeReassortiment());
//				tabArticles[i][4] = new Integer(a.getPrixDeVente());
//				tabArticles[i][5] = new Boolean(a.getTypeDeVente());
//				i++;
//			}
//		}else {
//			tabArticles = new Object[1][7];
//		}
//		return tabArticles;
//    }
    

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == add){
            System.out.println("Adding ...");
            new Articles(this);

        }
        if(source==delete){
            if(table.getSelectedRow()==-1){
                msgbox("Please select a row");
            }else{
                int row = table.getSelectedRow();
                ((DefaultTableModel)this.table.getModel()).removeRow(row);
                ArrayList<String> x =new ArrayList<String>();
                for(int i=0;i<6;i++){
                    String value = table.getModel().getValueAt(row, i).toString();
                    System.out.println(value);
                    x.add(value);
                }
                this.viewController.removeArticle(this, row, x.get(0), x.get(1), x.get(2), x.get(3), x.get(4), x.get(5));
            }

        }
        if(source == edit){
            if(table.getSelectedRow()==-1){
                msgbox("Please select a row");
            }else{
                int row = table.getSelectedRow();
                ArrayList<String> x =new ArrayList<String>();
                for(int i=0;i<6;i++){
                    String value = table.getModel().getValueAt(row, i).toString();
                    System.out.println(value);
                    x.add(value);
                }
                //new Provider("Modify Provider",x.get(0),x.get(1),x.get(2),x.get(3),x.get(4));
                new Articles(this, x.get(0), x.get(1), x.get(2), x.get(3), x.get(4), x.get(5), row);
            }
        }
     

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

    }

}