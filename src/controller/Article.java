package controller;

/**
* 
*/
public class Article {

    protected String  nom;
    protected int     codeBarre;
    protected int     quantiteEnStock;
    protected int     seuilDeReassortiment;
    protected int     prixDevente;
    protected boolean typeDeVente;
    /**
    * Default constructor
    */
    public Article(String nom,int codeBarre,int quantiteEnStock,int seuilDeReassortiment,int prixDevente,boolean typeDeVente) {
        this.nom=nom;
        this.codeBarre=codeBarre;
        this.quantiteEnStock=quantiteEnStock;
        this.seuilDeReassortiment=seuilDeReassortiment;
        this.prixDevente=prixDevente;
        this.typeDeVente=typeDeVente;
    }
    
    public Article() {
    }
    
    /*---------------------GETTER-----------------*/
    public String   getNom(){
        return this.nom;
    }
    public int      getCodeBarre(){
        return this.codeBarre;
    }
    public int      getQuantiteEnStock(){
        return this.quantiteEnStock;
    }
    public int      getSeuilDeReassortiment(){
        return this.seuilDeReassortiment;
    }
    public int      getPrixDeVente(){
        return this.prixDevente;
    }
    public boolean  getTypeDeVente(){
        return this.typeDeVente;
    }
    /*---------------------SETTER-----------------*/
    public void     setNom(String nom){
        this.nom=nom;
    }
    public void     setCodeBarre(int codeBarre){
        this.codeBarre=codeBarre;
    }
    public void     setQuantiteEnStock(int quantiteEnStock){
        this.quantiteEnStock=quantiteEnStock;
    }
    public void     setSeuilDeReassortiment(int seuilDeReassortiment){
        this.seuilDeReassortiment=seuilDeReassortiment;
    }
    public void     setPrixDeVente(int prixDevente){
        this.prixDevente=prixDevente;
    }
    public void     setTypeDeVente(boolean typeDeVente){
        this.typeDeVente=typeDeVente;
    }

    public String   informationArticle(){
        return  "Nom: "+                    this.nom+"\n"+
                "Code Barre: "+             this.codeBarre+"\n"+
                "Quantite En Stock: "+      this.quantiteEnStock+"\n"+
                "Seuil De Reassortiment: "+ this.seuilDeReassortiment+"\n"+
                "Prix De Vente: "+          this.prixDevente+"€\n"+
                "Type De Vente: "+          this.typeDeVente+"\n";
    }

}