package controller;

import java.util.*;


/**
 * 
 */
public class Caisse {

    private ArrayList<Double>   historiqueDeCaisse    ;
    private ArrayList<Article>  ticketDeCaisse        ;
    
    /**
    * Default constructor
    */
    
    public Caisse(){
        this.ticketDeCaisse=new ArrayList<Article>();
        this.historiqueDeCaisse=new ArrayList<Double>();
    }
    /**
    * 
    */
    protected void solder() {
        this.historiqueDeCaisse=new ArrayList<Double>();
    }
    /**
     * 
     */
    protected void connexion(int cleId){
        //cleId existe dans la base de données
    }

    public void passageDarticle(Article article){
       ticketDeCaisse.add(article);
    }
    /**
    * 
    */
    protected void listerLesTransactions() {
        for (double i : historiqueDeCaisse){
            System.out.println(">"+i);
        }
    }
    /**
     * 
     */
    public double calculerLeTotal() {
        double total=0.0;
        for(Article i:ticketDeCaisse){
            total+=i.getPrixDeVente();
        }
        System.out.println("Total de :"+total);
        return total;
    }
    /**
     * 
     */
    protected double paiment(double montant){
        double encaisser=calculerLeTotal();
        if( montant>encaisser){
            historiqueDeCaisse.add(encaisser);
            miseAjourDuStock();

        }
        return (montant-encaisser);
    }
    protected void miseAjourDuStock() {
        for(Article i:ticketDeCaisse){
            //Connexion à la base de données
        }
    }

}