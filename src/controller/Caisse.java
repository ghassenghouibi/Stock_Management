package controller;

import java.util.*;

/**
 * 
 */
public class Caisse {

    private ArrayList<Double>   historiqueDeCaisse    = new ArrayList<Double>();
    private ArrayList<Double>   calcul                = new ArrayList<Double>();
    private ArrayList<String>   nomDesArticles        = new ArrayList<String>();
    /**
    * Default constructor
    */
    
    public Caisse(){
    }
    /**
    * 
    */
    protected void solder() {
    }

    /**
     * 
     */
    protected void connexion() {
    }

    protected void passageDarticle(String nom,double prix){
        nomDesArticles.add(nom);
        calcul.add(prix);
        nombreDesArticles.add(1);
    }
    /**
    * 
    */
    protected void listerLesTransactions() {
        
    }
    /**
     * 
     */
    protected double calculerLeTotal() {
        double total=0.0;
        for(double i:calcul){
            total+=i;
        }
        return total;
    }
    /**
     * 
     */
    protected void paiment(double montant){
        calcul.add(montant);
    }
    protected void miseAjourDuStock() {
        
    }

}