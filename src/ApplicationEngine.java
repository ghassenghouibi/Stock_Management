

public class ApplicationEngine {

    private UserInterface gui;
	
	public ApplicationEngine() {
		
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
	
}
