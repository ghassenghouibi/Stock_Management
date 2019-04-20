package controller;

import java.util.*;

/**
* 
*/

public class Fournisseur {
    
    private  String 			 nom;
    private  Integer 			 numeroDeTelephone;
    private  String 			 adresse;
    private  Integer 			 codePostal;

    private  int 			     quantite;
    private  StringBuilder       commandeReference;
    private  String 			 adresseDetaillant;
    private  ArrayList <Article> commande;
    
    /**
    * Default constructor
    */
    
    public Fournisseur(String nom,int numeroDeTelephone,String adresse,int codePostal){
        this.nom                =nom;
        this.numeroDeTelephone  =numeroDeTelephone;
        this.adresse            =adresse;
        this.codePostal         =codePostal;
        this.commande           =new ArrayList <Article>();
    }
    
    public Fournisseur(){
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
    /**
    * 
    */
    public String envoyerUneCommande(String commandeReference,int quantite,String adresseDetaillant){
        return  "Commande Reference: "  +this.commandeReference+"\n"+
                "Quantité: "            +this.quantite+"\n"+
                "Adresse: "             +this.adresseDetaillant+"\n";
    }

}