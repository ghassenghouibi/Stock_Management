import java.util.Scanner;

import controller.*;


public class Main {
	
//	View view;
//	
//	public Main() {
//		view = new View();
//	}
//	
//	public Article newArticle() {
//		Article article;
//		int newPrice, newQuantity, newSeuilDeReassortiment, newCodeBarre;
//		String newName;
//		boolean typeOfSale;
//		
//		newName = view.newInfoString("what is the name of the article?");
//		newCodeBarre = view.newInfoInt("what is his bar code?");
//		newQuantity = view.newInfoInt("what is his quantity of stock?");
//		newSeuilDeReassortiment = view.newInfoInt("what is his re-order threshold");
//		newPrice = view.newInfoInt("what is his price?");
//		typeOfSale = view.newInfoBoolean("what is its type of sale?\n1 - true\t2 - false\nEnter your choice (1 - 2) : ");
//		
//		article = new Article(newName, newCodeBarre, newQuantity, newSeuilDeReassortiment, newPrice, typeOfSale);
//		
//		return article;
//	}
//	
//	public Fournisseur  newFournisseur() {
//		Fournisseur fournisseur;
//		String nomDetaillant, magasinDetaillant, name, newName, newAdress;
//    	int newPrice, newQuantity, newSeuilDeReassortiment, newTel, newCodePostal, newCodeBarre;
//    	
//    	newName = view.newInfoString("what is the name of the Fournisseur?");
//    	newTel = view.newInfoInt("what is his phone number?");
//		newCodePostal = view.newInfoInt("what is his postal code?");
//		newAdress = view.newInfoString("what is his address?");
//		
//		return fournisseur;
//	}
	
	
    @SuppressWarnings("incomplete-switch")
	public static void main(String args[]){
    	Choice choice = Choice.Start;
    	boolean loop = true;
    	View view = new View();
//    	Main rac = new Main();
    	
    	Detaillant detaillant = new Detaillant();
    	Caissier caissier = new Caissier();
    	Article article = new Article();
    	Fournisseur fournisseur = new Fournisseur();
    	
    	
    	String nomDetaillant, magasinDetaillant, name, newName, newAdress;
    	int newPrice, newQuantity, newSeuilDeReassortiment, newTel, newCodePostal, newCodeBarre;
    	boolean typeOfSale;
    	
        
        
        while(loop) {
        	switch(choice) {
        	case Start:
        		choice = view.accountChoice();
        		continue;
        	case Detaillant:
        		nomDetaillant = view.newInfoString("What is your name?");
        		magasinDetaillant = view.newInfoString("What is the name of your store?");
        		detaillant.setNom(nomDetaillant);
        		detaillant.setNomDeMagasin(magasinDetaillant);
        		choice = Choice.MenuDetaillant;
        	case MenuDetaillant:
        		choice = view.menuDetaillant(detaillant.getNom());
        		continue;
        	case ListerLesElementsEnDessousDuSeuil:
        		detaillant.listerLesElementsEnDessousDuSeuil();
        		choice = view.sousMenuDetaillant();
        		continue;
        	case ListerTousLesArticles:
        		detaillant.listerTousLesArticles();
        		choice = view.sousMenuDetaillant();
        		continue;
        	case ListerTousLesFournisseurs:
        		detaillant.listerTousLesFournisseurs();
        		choice = view.sousMenuDetaillant();
        		continue;
        	case ImprimerLaliste:
        		detaillant.imprimerLaliste();
        		choice = view.sousMenuDetaillant();
        		continue;
        	case ModifierLesInformationsConcernantLesArticles:
        		
        		name = view.newInfoString("what is the name of the item to edit?");
        		newName = view.newInfoString("what is the new name of the article?");
        		newPrice = view.newInfoInt("what is the new price?");
        		newQuantity = view.newInfoInt("what is the new quantity of stock?");
        		newSeuilDeReassortiment = view.newInfoInt("what is the new re-order threshold");
        		
        		detaillant.modifierLesInformationsConcernantLesArticles(name, newName, newPrice, newQuantity, newSeuilDeReassortiment);
        		choice = view.sousMenuDetaillant();
        		continue;
        	case ModifierLesInformationsConcernantLesFournisseurs:
        		
        		name = view.newInfoString("what is the name of the supplier to edit?");
        		newName = view.newInfoString("what is the new name of the provider?");
        		newTel = view.newInfoInt("what is his new phone number?");
        		newCodePostal = view.newInfoInt("what is his new postal code?");
        		newAdress = view.newInfoString("what is his new address?");
        		
        		detaillant.modifierLesInformationsConcernantLesFournisseurs(name, newName, newTel, newCodePostal, newAdress);
        		choice = view.sousMenuDetaillant();
        		continue;
        	case AjouterUnNouveauArticle:
        		
        		newName = view.newInfoString("what is the new name of the article?");
        		newCodeBarre = view.newInfoInt("what is his bar code?");
        		newQuantity = view.newInfoInt("what is his quantity of stock?");
        		newSeuilDeReassortiment = view.newInfoInt("what is his re-order threshold");
        		newPrice = view.newInfoInt("what is his price?");
        		typeOfSale = view.newInfoBoolean("what is its type of sale?\n1 - true\t2 - false\nEnter your choice (1 - 2) : ");
        		
        		article = new Article(newName, newCodeBarre, newQuantity, newSeuilDeReassortiment, newPrice, typeOfSale);
        		detaillant.ajouterUnNouveauArticle(article);
//        		article = rac.newArticle();
        		choice = view.sousMenuDetaillant();
        		continue;
        	case AjouterUnNouveauFournisseur:
        		
        		newName = view.newInfoString("what is the name of the Fournisseur?");
            	newTel = view.newInfoInt("what is his phone number?");
        		newCodePostal = view.newInfoInt("what is his postal code?");
        		newAdress = view.newInfoString("what is his address?");
        		
        		fournisseur = new Fournisseur(newName, newTel, newAdress, newCodePostal);
        		detaillant.ajouterUnNouveauFournisseur(fournisseur);
        		choice = view.sousMenuDetaillant();
        		continue;
        	case SupprimerUnArticle:
        		name = view.newInfoString("what is the name of the item you want to delete?");
        		detaillant.supprimerUnArticle(name);
        		choice = view.sousMenuDetaillant();
        		continue;
        	case SupprimerUnFournisseur:
        		name = view.newInfoString("what is the name of the item you want to delete?");
        		detaillant.supprimerUnFournisseur(name);
        		choice = view.sousMenuDetaillant();
        		continue;
        	case AnnulerLaCommande:
        		detaillant.annulerLaCommande();
        		choice = view.sousMenuDetaillant();
        		continue;
        	case PasserUneCommande:
        		detaillant.passerUneCommande();
        		choice = view.sousMenuDetaillant();
        		continue;
        	case ChangerLeNomDuMagasin:
        		newName = view.newInfoString("what is the new name of the store?");
        		detaillant.setNomDeMagasin(newName);
        		choice = view.sousMenuDetaillant();
        		continue;
        	case ChangerMonNom:
        		newName = view.newInfoString("what is your new name?");
        		detaillant.setNom(newName);
        		choice = view.sousMenuDetaillant();
        		continue;
        	case Caissier:
        		int cleId = view.newInfoInt("Enter your Id : ");
        		caissier = new Caissier(cleId);
        		choice = Choice.MenuCaissier;
        	case MenuCaissier:
        		continue;
        	case Client:
        		continue;
        	case Fournisseur:
        		continue;
        	case Quit:
        		break;
        	}
        }
        
    }

}