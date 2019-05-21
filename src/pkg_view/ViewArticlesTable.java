package pkg_view;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import pkg_controller.ViewController;
import pkg_model.BaseDeDonnes;
import pkg_utils.Article;

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
        viewController=new ViewController();
    }

    /**
     * this method configure the frame according to the menu article view table
     * 
     * @param myFrame 
     */
    public void createGUI(JFrame myFrame){
    	//empty the frame
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().repaint();
        
        //retrieve the article table from the database
        this.bdd = new BaseDeDonnes();
        this.articlesList = bdd.loadArticles();

        //Creation of the provider array model
        String  title[] = {"nom", "code barre", "quantite en stock","seuil de reassortiment","prix de vente","type de vente"};
        table = new JTable(new DefaultTableModel(title, 0));
        
        //Fill it out
        for(Article a : this.articlesList) {
        	 Object[] obj = { a.getNom(), a.getCodeBarre(), a.getQuantiteEnStock(), a.getSeuilDeReassortiment(), a.getPrixDeVente(), a.getTypeDeVente() };
        	 ((DefaultTableModel)this.table.getModel()).addRow(obj);
        }
        
        //Here we create the panel and we add and configure it in one needs (JScrollPane, JButton, ...)
        panel = new JPanel();
        panel.setLayout(null);
        
		JScrollPane listScroller = new JScrollPane(table);
		listScroller.setBounds(0, 100, 800, 600);
		
        
        add = new JButton("");
        String iconfilePath = this.getClass().getClassLoader().getResource("images/add.png").getFile();
        add.setIcon(new ImageIcon(iconfilePath));
        add.setBounds(0, 0, 100, 50);
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setContentAreaFilled(false);
        add.setFocusable(false);
        add.addActionListener(this);

        edit = new JButton("");
        
        String iconfilePathedit = this.getClass().getClassLoader().getResource("images/edit.png").getFile();
        edit.setIcon(new ImageIcon(iconfilePathedit));
        edit.setBounds(300, 0, 100, 50);
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.setContentAreaFilled(false);
        edit.setFocusable(false);
        edit.addActionListener(this);

        delete = new JButton("");
        
        String iconfilePathdelete = this.getClass().getClassLoader().getResource("images/delete.png").getFile();
        delete.setIcon(new ImageIcon(iconfilePathdelete));
        delete.setBounds(600, 0, 100, 50);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setContentAreaFilled(false);
        delete.setFocusable(false);
        delete.addActionListener(this);  

        panel.add(listScroller);
		
        panel.add(add);
        panel.add(edit);
        panel.add(delete);

        
        //setting up the frame and adding him to the panel
        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myFrame.dispose();
			}
		});
        myFrame.add(panel);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(800,620);
        myFrame.setVisible(true);
        frame=myFrame;
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
	
	/**
	 * This method opens a warning dialog with a custom message
	 * 
	 * @param text message
	 */
    private void msgbox(String text){
        JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog

    }    

    /**
     * This method responds to the call of the addActionListener and decide method of the action to be done
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == add){
            new Articles(this);

        }
        if(source==delete){
            if(table.getSelectedRow()==-1){
                msgbox("Please select a row");
            }else{
                int row = table.getSelectedRow();
                ArrayList<String> x =new ArrayList<String>();
                for(int i = 0 ; i < 2 ; i++){
                    String value = table.getModel().getValueAt(row, i).toString();
                    x.add(value);
                }
                this.viewController.removeArticle(this, row, x.get(0), x.get(1));
            }

        }
        if(source == edit){
            if(table.getSelectedRow()==-1){
                msgbox("Please select a row");
            }else{
                int row = table.getSelectedRow();
                ArrayList<String> x =new ArrayList<String>();
                for(int i = 0 ; i < 6 ; i++){
                    String value = table.getModel().getValueAt(row, i).toString();
                    x.add(value);
                }
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

}