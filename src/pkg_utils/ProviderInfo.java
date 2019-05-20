/**
* This class contains informations about Provider will be use by the retailer 
* To command or add or remove or modify some informations about provider
* @author : groupe 5
* @version: 0.0.1
*/

package pkg_utils;

public class ProviderInfo {

    private  int         idProvider;
    private  String 	 nom;
    private  String      product;
    private  Integer     numeroDeTelephone;
    private  String      adresse;
    private  Integer     codePostal;

    /**
    * Default constructor
    */
    public ProviderInfo(int idProvider,String nom, String product, String adresse, int codePostal, int numeroDeTelephone) {
        this.idProvider=idProvider;
        this.nom = nom;
        this.product=product;
        this.numeroDeTelephone = numeroDeTelephone;
        this.adresse = adresse;
        this.codePostal = codePostal;
    }

    /*------Getter------*/
    public int getId(){
        return this.idProvider;
    }

    public String getProduct() {
        return product;
    }

    public String getNomProvider(){
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

    /*------Setter------*/
    public void setId(int id){
        this.idProvider=id;
    }

    public void setProduct(String product) {
        this.product = product;
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

}