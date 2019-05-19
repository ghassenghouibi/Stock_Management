package pkg_utils;

import java.util.*;
/**
* 
*/
public class Detaillant {
	
	private String nom;
	private String nomDeMagasin;
	private ArrayList <Article>  listOfArticle;
    private ArrayList <ProviderInfo>  listOfProviders;
    /**
    * Default constructor
    */
    public Detaillant(String nom,String nomDeMagasin) {
    	this.nom=nom;
        this.setNomDeMagasin(nomDeMagasin);
        this.listOfArticle=new ArrayList<Article>();
        this.listOfProviders = new ArrayList<ProviderInfo>();
    }

    public Detaillant() {
        this.listOfArticle=new ArrayList<Article>();
        this.listOfProviders = new ArrayList<ProviderInfo>();
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

	public ArrayList<ProviderInfo> getListOfProviders() {
		return listOfProviders;
	}

	public void setListOfProviders(ArrayList<ProviderInfo> listOfProviders) {
		this.listOfProviders = listOfProviders;
	}

}