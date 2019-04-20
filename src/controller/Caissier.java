package controller;

/**
 * 
 */
public class Caissier {

    private int cleId;
    /**
    * Default constructor
    */
    public Caissier(int cleId){
        this.cleId=cleId;
    }
    
    public Caissier(){
    }
    
    public int getCleId() {
		return cleId;
	}

	public void setCleId(int cleId) {
		this.cleId = cleId;
	}

	//Use thread to secure access to data
    /**
    * 
    */
    public void changementDePoste() {
       //check status
       //connection
    }
    /**
    * 
    */
    public void authentification() {
    
    }
    
}