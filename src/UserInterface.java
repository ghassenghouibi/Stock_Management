
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class UserInterface implements ActionListener {

    private JFrame myFrame;
    private JPanel panel;
    private ApplicationEngine engine;
	
    public UserInterface(ApplicationEngine engine) {
		// TODO Auto-generated constructor stub

    	this.setEngine(engine);
    	openWindow();
	}
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		Object  source = e.getSource();
//		if(source == this.detaillant) {
//			
//		}
//		if(source == this.caissier) {
//			
//		}
	}
	
	
	public void openWindow() {
    	this.myFrame = new JFrame("Stock Management");
		this.myFrame.setTitle("Stock Management");
        this.myFrame.setSize(new Dimension(800, 600));
        this.myFrame.setLocationRelativeTo(null);
        this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new FirstMenu(this);
        this.myFrame.setContentPane(panel);               

        
//        this.myFrame.setVisible(true);
	}
	
	/**
     * Print out some text into the text area, followed by a line break.
     */
    public void println(String text, JTextArea log)
    {
        log.append(text + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }
	
//	
//	public class FirstMenu extends JPanel {
//	
//		
//		private JButton detaillant = new JButton("Détaillant");
//		private JButton caissier = new JButton("Caissier");
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 988528974991105470L;
//		
//		
//		public void paintComponent(Graphics g) {
//			
//			g.setColor(Color.lightGray);
//		    g.fillRect(0, 0, this.getWidth(), this.getHeight());
//			
//			Font font = new Font("Courier", Font.BOLD, 40);
//		    g.setFont(font);
//		    g.setColor(Color.black);
//			g.drawString("Stock Management", this.getWidth() / 2 - 175, this.getHeight() / 8);
//			
//			font = new Font("Courier", Font.BOLD, 22);
//			g.setFont(font);
//			g.drawString("Vous êtes :", 90, this.getHeight() * 3 / 8 + 20);
//			
//			detaillant.setBounds(this.getWidth() * 2 / 5, this.getHeight() * 3 / 8, this.getHeight() / 3, 50);
//			detaillant.addActionListener(Application.gui);
//			
//			caissier.setBounds(this.getWidth() * 2 / 5, this.getHeight() * 4 / 8, this.getHeight() / 3, 50);
//			caissier.addActionListener(Application.gui);
//			
//			this.add(detaillant);
//			this.add(caissier);
//		}
//	}


	public JFrame getMyFrame() {
		return myFrame;
	}


	public void setMyFrame(JFrame myFrame) {
		this.myFrame = myFrame;
	}


	public ApplicationEngine getEngine() {
		return engine;
	}


	public void setEngine(ApplicationEngine engine) {
		this.engine = engine;
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


}
