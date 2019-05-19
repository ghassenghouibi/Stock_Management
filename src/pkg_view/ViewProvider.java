package pkg_view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import pkg_controller.ViewController;
import pkg_model.BaseDeDonnes;
import pkg_utils.ProviderInfo;

import java.awt.event.*;
import java.util.ArrayList;


public class ViewProvider implements ActionListener{

    private JButton add,edit,order,delete;

    private JPanel    panel;
    private JFrame    frame;

    private JMenuBar  menuBar;
    private JMenu     file;
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
    
    private ArrayList<ProviderInfo> listOfProvider;
    private DefaultTableModel tableModel;
    private BaseDeDonnes dataBase;

    private ViewController viewController;

    public ViewProvider(JFrame Frame){
        listOfProvider=new ArrayList<ProviderInfo>();
        dataBase=new BaseDeDonnes();
        listOfProvider=dataBase.loadProvider();
        viewController=new ViewController();
        this.frame=Frame;
        createGUI(Frame);
        
    }

    /**
     * this method configure the frame according to the menu provider view
     * 
     * @param myFrame 
     */
    public void createGUI(JFrame myFrame){
        //empty the frame
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().repaint();    
        
        //Creation of the provider array model
        String  title[] = {"id","Produit", "Nom", "Adresse","code postale","téléphone"};
        tableModel= new DefaultTableModel(title, 0);
        
        //Fill it out
        for(ProviderInfo x :listOfProvider){
            Object[] obj={x.getId(),x.getProduct(),x.getNomProvider(),x.getAdresse(),x.getCodePostal(),x.getNumeroDeTelephone()};
            tableModel.addRow(obj);
        }
        table = new JTable(tableModel);
        
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
        edit.setBounds(230, 0, 100, 50);
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.setContentAreaFilled(false);
        edit.setFocusable(false);
        edit.addActionListener(this);

        delete = new JButton("");
        
        String iconfilePathdelete = this.getClass().getClassLoader().getResource("images/delete.png").getFile();
        delete.setIcon(new ImageIcon(iconfilePathdelete));
        delete.setBounds(460, 0, 100, 50);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setContentAreaFilled(false);
        delete.setFocusable(false);
        delete.addActionListener(this);

        order = new JButton("");
        
        String iconfilePathorder = this.getClass().getClassLoader().getResource("images/order.png").getFile();
        order.setIcon(new ImageIcon(iconfilePathorder));
        order.setBounds(690, 0, 100, 50);
        order.setBorder(BorderFactory.createEmptyBorder());
        order.setContentAreaFilled(false);
        order.setFocusable(false);
        order.addActionListener(this);

        panel.add(listScroller);
		
        panel.add(add);
        panel.add(edit);
        panel.add(delete);
        panel.add(order);

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

    /**
     * This method create and initialize the menu and then add it to the frame
     * 
     * @param myFrame
     */
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
     * This method responds to the call of the addActionListener and dicide method of the action to be done
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == add){
            viewController.addProvider("Add Provider",frame);
        }
        if(source==delete){
            if(table.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(null, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
            }
            int selectedRow=table.getSelectedRow();
            int idOfProvider= (int) table.getValueAt(selectedRow, 0);

            viewController.deleteProvider(frame,idOfProvider);
            tableModel.removeRow(selectedRow);
        }
        if(source== edit){
            if(table.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(null, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                int row = table.getSelectedRow();
                viewController.modifyProvider(frame,listOfProvider.get(table.getSelectedRow()).getId(),table.getModel().getValueAt(row, 1).toString(), table.getModel().getValueAt(row, 2).toString(), table.getModel().getValueAt(row, 3).toString(), table.getModel().getValueAt(row, 4).toString(),table.getModel().getValueAt(row, 5).toString());
            }
        }
        if(source == order){
            if(table.getSelectedRow()==-1){
                JOptionPane.showMessageDialog(null, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
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