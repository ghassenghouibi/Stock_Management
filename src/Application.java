

public class Application {

    private UserInterface gui;
    private ApplicationEngine engine;
    
    
    public Application() {
    	this.engine = new ApplicationEngine();
    	this.gui = new UserInterface(engine);
    	this.engine.start(this.gui);
    }
	
	
}
