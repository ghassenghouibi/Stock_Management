package controller;

import java.util.*;
/**
 * 
 */
public class Client {
    public double               solde;
    public String               identifiant;
    public ArrayList<Article>   panier;
    
    /**
    * Default constructor
    */
    public Client(String identifiant,double solde) {
        this.identifiant=identifiant;
        this.solde=solde;
        this.panier = new ArrayList<Article>();
    }
    /**
    * 
    */
    public void acheterUnarticle(Article article){
        panier.add(article);
    }
    /** 
    * 
    */
    public void retournerUnarticle(Article article) {
        panier.remove(article);
    }
    /**
    * 
    */
    public void paiement(double total) {
        this.solde-=total;
    }
}