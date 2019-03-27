package controller;

import java.util.*;
/**
* 
*/
public class Detaillant {
	
	public String 			   	nom;
	public String 			   	nomDeMagasin;
	public ArrayList <Article>  listOfArticle;
    public ArrayList <Fournisseur>  listOfFournisseurs;
    /**
    * Default constructor
    */
    public Detaillant(String nom,String nomDeMagasin) {
    	this.nom=nom;
        this.nomDeMagasin=nomDeMagasin;
        this.listOfArticle=new ArrayList<Article>();
    }

    /**
    * 
    */
    public void listerLesElementsEnDessousDuSeuil() {
        for(Article x : listOfArticle){
            if( x.getQuantiteEnStock()<=x.getSeuilDeReassortiment() ){
                System.out.println((x).informationArticle());
            }
        }
    }

    /**
    * 
    */
    public void listerTousLesArticles() {
        for(Article x : listOfArticle){
        	System.out.println(x.informationArticle());
        }
    }

    /**
    * 
    */
    public void listerTousLesFournisseurs() {
        for(Fournisseur x : listOfFournisseurs){
            System.out.println(x);
        }
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
    public void modifierLesInformationsConcernantLesArticles(String name,int prixDevente,int quantiteEnStock,int seuilDeReassortiment) {
            for(Article x : listOfArticle){
                if(x.getNom()==name){
                    x.setPrixDeVente(prixDevente);
                    x.setQuantiteEnStock(quantiteEnStock);
                    x.setSeuilDeReassortiment(seuilDeReassortiment);
                }
            }
    }
    /**
    * 
    */
    public void modifierLesInformationsConcernantLesFournisseurs(String nom,int numeroDeTelephone,int codePostal,String adresse) {
        for(Fournisseur x : listOfFournisseurs){
            if(nom == x.getNomFournisseur()){
                x.setNomFournisseur(nom);
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
    public void supprimerUnFournisseur() {
        for(Fournisseur x : listOfFournisseurs){
            if(nom==x.getNomFournisseur()){
                listOfFournisseurs.remove(x);
            }
        } 
    }

    /**
     * 
     */
    public void annulerLaCommande(){
        //TODO   
    }

    /**
     * 
     */
    public void passerUneCommande() {
        //TODO
    }

}