package controller;

import java.util.*;

/**
* 
*/

public class Fournisseur {
    
    private  String 			 nom;
    private  String product;
    private Integer numeroDeTelephone;
    private String adresse;
    private Integer codePostal;

    private int quantite;
    private StringBuilder commandeReference;
    private String adresseDetaillant;
    private ArrayList<Article> commande;

    /**
     * Default constructor
     */

    public Fournisseur(String nom, String product, String adresse, int codePostal, int numeroDeTelephone) {
        this.nom = nom;
        this.product=product;
        this.numeroDeTelephone = numeroDeTelephone;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.commande = new ArrayList<Article>();
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    public Fournisseur() {
        this.commande           =new ArrayList <Article>();
    }
    
    public void receptionDuneCommande(Article article,int quantite,String fournisseur,String adresse){
        commande.add(article);
        this.quantite=quantite;
        StringBuilder referenceString=new StringBuilder(fournisseur+quantite+adresse);
        this.commandeReference=referenceString;
    }

    public String getNomFournisseur(){
        return this.nom;
    }
    public int getNumeroDeTelephone(){
        return this.numeroDeTelephone;
    }
    public String getAdresse(){
        return this.adresse;
    }
    public int getCodePostal(){
        return this.codePostal;
    }
    public void setNomFournisseur(String nom){
        this.nom=nom;
    }
    public void setNumeroDeTelephone(int numeroDeTelephone){
        this.numeroDeTelephone=numeroDeTelephone;
    }
    public void setAdresse(String adresse){
        this.adresse=adresse;
    }
    public void setCodePostal(int codePostal){
        this.codePostal=codePostal;
    }


    public void showProvider(Fournisseur a){
        System.out.println(a.getNomFournisseur()+" "+a.getAdresse()+" "+a.getCodePostal());
    }
    /**
    * 
    */
    public String envoyerUneCommande(String commandeReference,int quantite,String adresseDetaillant){
        return  "Commande Reference: "  +this.commandeReference+"\n"+
                "Quantité: "            +this.quantite+"\n"+
                "Adresse: "             +this.adresseDetaillant+"\n";
    }

}