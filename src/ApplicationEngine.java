import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controller.*;

public class ApplicationEngine {

    private UserInterface gui;
    private Detaillant detaillant;
	
    private Object[][] articles;
    
	public ApplicationEngine() {
		this.detaillant = new Detaillant();
		Article a = new Article("aaa", 012, 45, 78, 52, false);
		detaillant.ajouterUnNouveauArticle(a);
		this.articles = updateListeArticles();
	}
	
	public void addArticle(String nom, String codeBarre, String quantiteEnStock, String seuilDeReassortiment, String prixDeVente, boolean typeDeVente, GestionStock gs, AddArticle source) {
		if(!nom.equals("")) {
			int codeBarreInt;
			try {
				codeBarreInt = Integer.parseInt(codeBarre);
			} catch (NumberFormatException e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Vous devez saisir un code barre correct", "Attention", JOptionPane.WARNING_MESSAGE);
				codeBarreInt = 0;
			}

			if(codeBarreInt > 0) {
				int quantiteEnStockInt;
				try {
					quantiteEnStockInt = Integer.parseInt(quantiteEnStock);
				} catch (NumberFormatException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Vous devez saisir une quantite de stock correct", "Attention", JOptionPane.WARNING_MESSAGE);
					quantiteEnStockInt = -1;
				}
				
				if(quantiteEnStockInt >= 0) {
					int seuilDeReassortimentInt;
					try {
						seuilDeReassortimentInt = Integer.parseInt(seuilDeReassortiment);
					} catch (NumberFormatException e2) {
						// TODO: handle exception
						seuilDeReassortimentInt = 0;
					}
					if(seuilDeReassortimentInt > 0) {
						int prixDeVenteInt;
						try {
							prixDeVenteInt = Integer.parseInt(prixDeVente);
						} catch (NumberFormatException e2) {
							// TODO: handle exception
							prixDeVenteInt = 0;
						}
						if(prixDeVenteInt > 0) {
//							if(typeDeVente.equals("Oui")) {
								Article article = new Article(nom, codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, typeDeVente);
//								this.gui.getEngine().getDetaillant().ajouterUnNouveauArticle(article);
								this.detaillant.ajouterUnNouveauArticle(article);
								this.articles = updateListeArticles();
								gs.setArticles(this.articles);
								gs.addArticle(nom, codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, typeDeVente);
								source.articleOk();
//								JOptionPane.showMessageDialog(null, "L'article " + nom + " a était ajouté avec succé", "Information", JOptionPane.INFORMATION_MESSAGE);

//								this.gui.getMyFrame().repaint();
//								this.gui.getMyFrame().setContentPane(new AjouterUnNouveauArticle(this.gui));
//								this.gui.getMyFrame().revalidate();
//							}else if(typeDeVente.equals("Non")) {
//								Article article = new Article(nom, codeBarreInt, quantiteEnStockInt, seuilDeReassortimentInt, prixDeVenteInt, false);
////								this.gui.getEngine().getDetaillant().ajouterUnNouveauArticle(article);
//								
//								this.detaillant.ajouterUnNouveauArticle(article);
//								
//								JOptionPane.showMessageDialog(null, "L'article " + nom + " a était ajouté avec succé", "Information", JOptionPane.INFORMATION_MESSAGE);
////
////								this.gui.getMyFrame().repaint();
////								this.gui.getMyFrame().setContentPane(new AjouterUnNouveauArticle(this.gui));
////								this.gui.getMyFrame().revalidate();
//							}else {
//								JOptionPane.showMessageDialog(null, "Vous devez selectionner si l'article est à vendre ou pas!!", "Attention", JOptionPane.WARNING_MESSAGE);
//							}
						}else {
							JOptionPane.showMessageDialog(null, "Vous devez saisir un prix de vente correct et > à 0", "Attention", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Vous devez saisir un seuil de reassortiment correct et > à 0", "Attention", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Vous devez saisir un nom", "Attention", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public Object[][] updateListeArticles() {
		Object[][] articles;
		int i = 0;
		if(!this.detaillant.getListOfArticle().isEmpty()) {
			articles = new Object[this.detaillant.getListOfArticle().size()][7];
			for(Article a : this.detaillant.getListOfArticle()) {
				articles[i][0] = new Integer(i);
				articles[i][1] = new String(a.getNom());
				articles[i][2] = new Integer(a.getCodeBarre());
				articles[i][3] = new Integer(a.getQuantiteEnStock());
				articles[i][4] = new Integer(a.getSeuilDeReassortiment());
				articles[i][5] = new Integer(a.getPrixDeVente());
				articles[i][6] = new Boolean(a.getTypeDeVente());
			}
		}else {
			articles = new Object[1][7];
		}
		return articles;
	}
	
	public Object[][] getArticles() {
		return articles;
	}

	public void setArticles(Object[][] articles) {
		this.articles = articles;
	}

	/**
	 * @param gui
	 */
	public void start(UserInterface gui) {
        setGui(gui);
        
        

//        this.gui.getMyFrame().setVisible(true);
	}
	
	public void AjouterUnNouveauArticle(HashMap<String, Object> param) {
		Article article = new Article((String)param.get("nom"), (int)param.get("codeBarre"), (int)param.get("quantiteEnStock"), (int)param.get("seuilDeReassortiment"), (int)param.get("prixDeVente"), (boolean)param.get("typeDeVente"));
		this.detaillant.ajouterUnNouveauArticle(article);
	}
	
	public void AjouterUnNouveauFournisseur(HashMap<String, Object> param) {
		Fournisseur fournisseur = new Fournisseur((String)param.get("nom"), (int)param.get("numeroTel"), (String)param.get("adresse"), (int)param.get("codePostale"));
		this.detaillant.ajouterUnNouveauFournisseur(fournisseur);
	}


	public UserInterface getGui() {
		return gui;
	}

	public void setGui(UserInterface gui) {
		this.gui = gui;
	}


	public Detaillant getDetaillant() {
		return detaillant;
	}


	public void setDetaillant(Detaillant detaillant) {
		this.detaillant = detaillant;
	}
	
}
