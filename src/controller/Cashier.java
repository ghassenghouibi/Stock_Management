package controller;

/**
* This class contains cashier informations this class we be used to sell and use Caisse class
*/
public class Cashier {

    private String name;
    private String cleId;
    /**
    * Default constructor
    */
    public Cashier(String cleId,String name){
        this.cleId=cleId;
        this.name=name;
    }
    
    /*-------Getter-----*/
    public String getCleId() {
		return this.cleId;
    }
    
    public String getName() {
		return this.name;
    }

    /*-------Setter-----*/
    public void setName(String name) {
		this.name=name;
	}

	public void setCleId(String cleId) {
		this.cleId = cleId;
	}

	    
}