package gestiondestock;

import java.util.*;

/**
* 
*/
public class Fournisseur {

    public int numeroDeTelephone;
    public String nom;
    public String adresse;
    public int codePostal;
    
    private int quantite;
    private String commandeReference;
    private String adresseDetaillant;
    /**
    * Default constructor
    */
    public Fournisseur(String nom,int numeroDeTelephone,String adresse,int codePostal){
        this.nom=nom;
        this.numeroDeTelephone=numeroDeTelephone;
        this.adresse=adresse;
        this.codePostal=codePostal;
    }
    
    public void receptionDuneCommande(String article,int quantite,String fournisseur,String adresse){
        //Save order in data base
        String commandeReference="XRFE1826564";
        //Generate a reference
        //Send order
        envoyerUneCommande(commandeReference,quantite,adresseDetaillant);
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