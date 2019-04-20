import java.util.Scanner;



public class View {
	private Scanner in;
	
	public View() {
		this.in = new Scanner(System.in);
	}
	
	public Choice accountChoice() {
		int choice;
		System.out.println("Hello in the Stock Management");
		System.out.print("Are you?\n1 - Detaillant\n2 - Caissier\nEnter your choice (1 or 2) : ");
		while(true) {
			while(true) {
				if(this.in.hasNextInt()) {
					choice = this.in.nextInt();
					break;
				}
				System.out.println("\nI did not understand\n");
				System.out.print("Are you?\n1 - Detaillant\n2 - Caissier\nEnter your choice (1 or 2) : ");
				in.next();
			}
			
			switch(choice) {
			case 1:
				return Choice.Detaillant;
			case 2:
				return Choice.Caissier;
			default :
				System.out.println("\nI did not understand\n");
				System.out.print("Are you?\n1 - Detaillant\n2 - Caissier\nEnter your choice (1 or 2) : ");
			}
		}
		
	}
	
//	public String nameChoice() {
//		System.out.println("What is your name?");
//		while(!this.in.hasNext()) {
//			System.out.println("\nI did not understand\n");
//			System.out.println("What is your name?");
//		}
//		return this.in.next();
//	}
//	
//	public String magasinDetaillant() {
//		System.out.println("What is the name of your store?");
//		while(!this.in.hasNext()) {
//			System.out.println("\nI did not understand\n");
//			System.out.println("What is the name of your store?");
//		}
//		return this.in.next();
//	}
	
//	public int cleIdCaissier() {
//		int choice;
//		System.out.println("Enter your Id : ");
//		while(true) {
//			if(this.in.hasNextInt()) {
//				choice = this.in.nextInt();
//				break;
//			}
//			System.out.println("\nI did not understand\n");
//			System.out.print("Enter your Id : ");
//			in.next();
//		}
//		return choice;
//	}
	
	public Choice menuDetaillant(String nomDetaillant) {
		int choice;
		System.out.println("Sir " + nomDetaillant);
		System.out.println("What do you want to do?\n1 - lister lese elements en dessous du seuil\n2 - listerTousLesArticles\n3 - listerTousLesFournisseurs\n4 - imprimerLaliste\n5 - modifierLesInformationsConcernantLesArticles\n6 - modifierLesInformationsConcernantLesFournisseurs\n7 - ajouterUnNouveauArticle\n8 - ajouterUnNouveauFournisseur\n9 - supprimerUnArticle\n10 - supprimerUnFournisseur\n11 - annulerLaCommande\n12 - passerUneCommande\n13 - Changer le nom du magasin\n14 - Changer mon nom");
		System.out.println("Enter your choice (1 - 14) : ");
		while(true) {
			while(true) {
				if(this.in.hasNextInt()) {
					choice = this.in.nextInt();
					break;
				}
				System.out.println("\nI did not understand\n");
				System.out.println("What do you want to do?\n1 - lister lese elements en dessous du seuil\n2 - listerTousLesArticles\n3 - listerTousLesFournisseurs\n4 - imprimerLaliste\n5 - modifierLesInformationsConcernantLesArticles\n6 - modifierLesInformationsConcernantLesFournisseurs\n7 - ajouterUnNouveauArticle\n8 - ajouterUnNouveauFournisseur\n9 - supprimerUnArticle\n10 - supprimerUnFournisseur\n11 - annulerLaCommande\n12 - passerUneCommande\n13 - Changer le nom du magasin\n14 - Changer mon nom\n15 - disconnection\n16 - Quit");
				in.next();
			}
			
			switch(choice) {
			case 1:
				return Choice.ListerLesElementsEnDessousDuSeuil;
			case 2:
				return Choice.ListerTousLesArticles;
			case 3:
				return Choice.ListerTousLesFournisseurs;
			case 4:
				return Choice.ImprimerLaliste;
			case 5:
				return Choice.ModifierLesInformationsConcernantLesArticles;
			case 6:
				return Choice.ModifierLesInformationsConcernantLesFournisseurs;
			case 7:
				return Choice.AjouterUnNouveauArticle;
			case 8:
				return Choice.AjouterUnNouveauFournisseur;
			case 9:
				return Choice.SupprimerUnArticle;
			case 10:
				return Choice.SupprimerUnFournisseur;
			case 11:
				return Choice.AnnulerLaCommande;
			case 12:
				return Choice.PasserUneCommande;
			case 13:
				return Choice.ChangerLeNomDuMagasin;
			case 14:
				return Choice.ChangerMonNom;
			case 15:
				return Choice.Start;
			case 16:
				return Choice.Quit;
			default :
				System.out.println("\nI did not understand\n");
				System.out.print("What do you want to do?\n1 - lister lese elements en dessous du seuil\n2 - listerTousLesArticles\n3 - listerTousLesFournisseurs\n4 - imprimerLaliste\n5 - modifierLesInformationsConcernantLesArticles\n6 - modifierLesInformationsConcernantLesFournisseurs\n7 - ajouterUnNouveauArticle\n8 - ajouterUnNouveauFournisseur\n9 - supprimerUnArticle\n10 - supprimerUnFournisseur\n11 - annulerLaCommande\n12 - passerUneCommande\n13 - Changer le nom du magasin\n14 - Changer mon nom\n15 - disconnection\n16 - Quit");
			}
		}
	}
	
	public Choice sousMenuDetaillant() {
		int choice;
		System.out.println("What do you want to do?\n1 - return to the detaillant menu\n2 - disconnection\n3 - Quit");
		System.out.println("Enter your choice (1 - 3) : ");
		while(true) {
			while(true) {
				if(this.in.hasNextInt()) {
					choice = this.in.nextInt();
					break;
				}
				System.out.println("\nI did not understand\n");
				System.out.println("What do you want to do?\n1 - return to the detaillant menu\n2 - disconnection\n3 - Quit");
				System.out.println("Enter your choice (1 - 3) : ");
				in.next();
			}
			
			switch(choice) {
			case 1:
				return Choice.MenuDetaillant;
			case 2:
				return Choice.Start;
			case 3:
				return Choice.Quit;
			default :
				System.out.println("\nI did not understand\n");
				System.out.println("What do you want to do?\n1 - return to the detaillant menu\n2 - disconnection\n3 - Quit");
				System.out.println("Enter your choice (1 - 3) : ");
			}
		}
	}
	
	public String newInfoString(String demand) {
		System.out.println(demand);
		while(!this.in.hasNext()) {
			System.out.println("\nI did not understand\n");
			System.out.println(demand);
		}
		return this.in.next();
	}
	
	public int newInfoInt(String demand) {
		int choice;
		System.out.println(demand);
		while(true) {
			if(this.in.hasNextInt()) {
				choice = this.in.nextInt();
				break;
			}
			System.out.println("\nI did not understand\n");
			System.out.print(demand);
			in.next();
		}
		return choice;
	}
	
	public boolean newInfoBoolean(String demand) {
		int choice;
		System.out.println(demand);
		while(true) {
			while(true) {
				if(this.in.hasNextInt()) {
					choice = this.in.nextInt();
					break;
				}
				System.out.println("\nI did not understand\n");
				System.out.print(demand);
				in.next();
			}
			switch(choice) {
			case 1:
				return true;
			case 2:
				return false;
			default :
				System.out.println("\nI did not understand\n");
				System.out.print(demand);
			}
		}
	}
	
}
