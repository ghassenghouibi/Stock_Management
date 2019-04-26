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
