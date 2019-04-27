package controller;

import java.util.*;
/**
* 
*/
public class Detaillant {
	
	private String nom;
	private String nomDeMagasin;
	private ArrayList <Article>  listOfArticle;
    private ArrayList <Fournisseur>  listOfFournisseurs;
    /**
    * Default constructor
    */
    public Detaillant(String nom,String nomDeMagasin) {
    	this.nom=nom;
        this.setNomDeMagasin(nomDeMagasin);
        this.listOfArticle=new ArrayList<Article>();
        this.listOfFournisseurs = new ArrayList<Fournisseur>();
    }

    public Detaillant() {
        this.listOfArticle=new ArrayList<Article>();
        this.listOfFournisseurs = new ArrayList<Fournisseur>();
    }


	/**
    * 
    */
    public String listerLesElementsEnDessousDuSeuil() {
    	String lister = "";
        for(Article x : listOfArticle){
            if( x.getQuantiteEnStock() <= x.getSeuilDeReassortiment() ){
                System.out.println((x).informationArticle());
                lister += x.informationArticle() + "\n";
            }
        }
        return lister;
    }

    /**
    * 
    */
    public String listerTousLesArticles() {
    	String lister = "";
        for(Article x : listOfArticle){
        	System.out.println(x.informationArticle());
        	lister += x.informationArticle() + "\n";
        }
        return lister;
    }

    /**
    * 
    */
    public String listerTousLesFournisseurs() {
    	String lister = "";
        for(Fournisseur x : listOfFournisseurs){
            System.out.println(x);
            lister += x + "\n";
        }
        return lister;
    }
    /**
    * 
    */
    public void imprimerLaliste() {
        //Generate PDF
    }

    /**
    * 
    */
    public void modifierLesInformationsConcernantLesArticles(String name, String newName, int prixDevente,int quantiteEnStock,int seuilDeReassortiment) {
            for(Article x : listOfArticle){
                if(x.getNom()==name){
                	x.setNom(newName);
                    x.setPrixDeVente(prixDevente);
                    x.setQuantiteEnStock(quantiteEnStock);
                    x.setSeuilDeReassortiment(seuilDeReassortiment);
                }
            }
    }
    /**
    * 
    */
    public void modifierLesInformationsConcernantLesFournisseurs(String nom, String newName, int numeroDeTelephone,int codePostal,String adresse) {
        for(Fournisseur x : listOfFournisseurs){
            if(nom == x.getNomFournisseur()){
                x.setNomFournisseur(newName);
                x.setNumeroDeTelephone(numeroDeTelephone);
                x.setCodePostal(codePostal);
                x.setAdresse(adresse);
            }
        }
    }
    /**
     * 
     */
    public void ajouterUnNouveauArticle(Article article) {
        listOfArticle.add(article);
    }

    /**
     * 
     */
    public void ajouterUnNouveauFournisseur(Fournisseur fournisseur) {
        listOfFournisseurs.add(fournisseur);

    }
    /**
     * 
     */
    public void supprimerUnArticle(String nom) {
        for(Article x : listOfArticle){
            if(nom==x.getNom()){
                listOfArticle.remove(x);
            }
        }   
    }
    /**
     * 
     */
    public void supprimerUnFournisseur(String nom) {
        for(Fournisseur x : listOfFournisseurs){
            if(nom == x.getNomFournisseur()){
                listOfFournisseurs.remove(x);
            }
        } 
    }

    /**
     * 
     */
    public void annulerLaCommande(){
    }

    /**
     * 
     */
    public void passerUneCommande() {
    }

	public String getNomDeMagasin() {
		return nomDeMagasin;
	}

	public void setNomDeMagasin(String nomDeMagasin) {
		this.nomDeMagasin = nomDeMagasin;
	}
	
    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Article> getListOfArticle() {
		return listOfArticle;
	}

	public void setListOfArticle(ArrayList<Article> listOfArticle) {
		this.listOfArticle = listOfArticle;
	}

	public ArrayList<Fournisseur> getListOfFournisseurs() {
		return listOfFournisseurs;
	}

	public void setListOfFournisseurs(ArrayList<Fournisseur> listOfFournisseurs) {
		this.listOfFournisseurs = listOfFournisseurs;
	}

}