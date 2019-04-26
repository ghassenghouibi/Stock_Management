import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ListerTousLesFournisseurs extends Lister {

	public ListerTousLesFournisseurs(UserInterface gui) {
		super(gui);
		// TODO Auto-generated constructor stub
	}

	public void paintComponent(Graphics g) {
		
		g.setColor(Color.lightGray);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());

		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
	    g.setFont(font);
	    g.setColor(Color.black);
		g.drawString("La liste de tous les fournisseurs", 195, 50);
		
		retour.setBounds(30, 30, 30, 30);
		retour.addActionListener(this);
		
		listScroller.setBounds(100, 100, 600, 400);
		
		this.gui.println(this.gui.getEngine().getDetaillant().listerTousLesFournisseurs(), this.log);

		this.add(this.listScroller);
		this.add(retour);
		this.add(listScroller);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object  source = e.getSource();
		if(source == this.retour) {
			this.gui.getMyFrame().repaint();
			this.gui.getMyFrame().setContentPane(new MenuDetaillant(this.gui));
			this.gui.getMyFrame().revalidate();
		}
	}
}
