import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class GestionStock extends JPanel implements ActionListener {

	private UserInterface gui;

	private Object[][] articles;
	
	private JTable tab;
	private JScrollPane listScroller;
	
	private JButton add;
	private JButton remove;
	private JButton edit;
	private JButton retour;

	
	public GestionStock(UserInterface gui) {
		this.gui = gui;
		this.add = new JButton(new ImageIcon("src/addArticle.png"));
		this.remove = new JButton(new ImageIcon("src/removeArticle.png"));
		this.edit = new JButton(new ImageIcon("src/editArticle.png"));
		this.retour = new JButton(new ImageIcon("src/retour1.png"));
	}
	
	public void paintComponent(Graphics g) {
		
        String  title[] = {"Produit", "Nom", "Code barre", "Quantite en stock", "Seuil de reassortiment", "Prix de vente", "En vente"};
        this.articles = this.gui.getEngine().getArticles();
        this.tab = new JTable(new DefaultTableModel(this.articles, title));
        

		this.listScroller = new JScrollPane(tab);
		this.listScroller.setBounds(20, 140, 946, 500);
		this.add(listScroller);
		
		add.setBounds(585, 10, 120, 120);
		add.addActionListener(this);
		this.add(add);
		
		remove.setBounds(715, 10, 120, 120);
		remove.addActionListener(this);
		this.add(remove);
		
		edit.setBounds(845, 10, 120, 120);
		edit.addActionListener(this);
		this.add(edit);
		
		retour.setBounds(30, 30, 60, 60);
		retour.addActionListener(this);
		this.add(retour);
		
		
		
		
		

		        //Les titres des colonnes

//		        JTable tableau = new JTable(data, title);
//		        tableau.setPreferredSize(new Dimension(800,620));
//		        
//		        JButton btnNewButton = new JButton("");
//		        String iconfilePath = this.getClass().getClassLoader().getResource("../images/add.png").getFile();
//		        btnNewButton.setIcon(new ImageIcon(iconfilePath));
//		        btnNewButton.setBounds(10, 438, 39, 31);
//		        btnNewButton.setBorder(BorderFactory.createEmptyBorder());
//		        btnNewButton.setContentAreaFilled(false);
//		        btnNewButton.setFocusable(false);
//
//		        panel.setLayout(new GridBagLayout());
//
//		        GridBagConstraints gbc = new GridBagConstraints();
//		    
//
//		        panel.add(new JScrollPane(tableau), gbc);
//		        panel.add(btnNewButton);
//		        
//		        
//		        this.setContentPane(panel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object  source = e.getSource();
		if(source == this.add) {
			new AddArticle(this.gui.getMyFrame(), "Ajouter un article", true, this.gui, this);
			System.out.println("coucou");
		}else if(source == this.retour) {
			int option = JOptionPane.showConfirmDialog(null, "Vous aller vous déconnecté, voulez-vous continuer ?", "Déconnection", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(option == JOptionPane.OK_OPTION){
				this.gui.getMyFrame().repaint();
				this.gui.getMyFrame().setContentPane(new FirstMenu(this.gui));
				this.gui.getMyFrame().revalidate();		
			}
		}
	}
	
	public void addArticle(String nom, int codeBarre, int quantiteEnStock, int seuilDeReassortiment, int prixDevente, boolean typeDeVente) {
		Object[] article = {this.articles.length - 1, nom, codeBarre, quantiteEnStock, seuilDeReassortiment, prixDevente, typeDeVente};
		((DefaultTableModel)this.tab.getModel()).addRow(article);
	}
	
	
	public Object[][] getArticles() {
		return articles;
	}

	public void setArticles(Object[][] articles) {
		this.articles = articles;
	}

}
