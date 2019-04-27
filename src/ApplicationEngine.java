import java.util.HashMap;

import controller.*;

public class ApplicationEngine {

    private UserInterface gui;
    private Detaillant detaillant;
	
	public ApplicationEngine() {
		this.detaillant = new Detaillant();
	}
	
	
	/**
	 * @param gui
	 */
	public void start(UserInterface gui) {
        setGui(gui);
        
        

        this.gui.getMyFrame().setVisible(true);
	}
	
	public void AjouterUnNouveauArticle(HashMap<String, Object> param) {
		Article article = new Article((String)param.get("nom"), (int)param.get("codeBarre"), (int)param.get("quantiteEnStock"), (int)param.get("seuilDeReassortiment"), (int)param.get("prixDeVente"), (boolean)param.get("typeDeVente"));
		this.detaillant.ajouterUnNouveauArticle(article);
	}
	
	public void AjouterUnNouveauFournisseur(HashMap<String, Object> param) {
		Fournisseur fournisseur = new Fournisseur((String)param.get("nom"), (int)param.get("numeroTel"), (String)param.get("adresse"), (int)param.get("codePostale"));
		this.detaillant.ajouterUnNouveauFournisseur(fournisseur);
	}


	public UserInterface getGui() {
		return gui;
	}

	public void setGui(UserInterface gui) {
		this.gui = gui;
	}


	public Detaillant getDetaillant() {
		return detaillant;
	}


	public void setDetaillant(Detaillant detaillant) {
		this.detaillant = detaillant;
	}
	
}
