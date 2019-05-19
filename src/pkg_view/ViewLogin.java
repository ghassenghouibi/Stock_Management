
package pkg_view;

import javax.swing.*;

import pkg_controller.ViewController;

import java.awt.event.*;

public class ViewLogin implements ActionListener{

    private JFrame frame;
	private JTextField identity;
    private JPasswordField password;
    private JLabel identityLabel,passwordLabel;
    private JRadioButton choiceRetailer,choiceCashier;
    private JButton login,signin,register;
    private JPanel panel;
    private ViewController viewController;

    public ViewLogin(JFrame myFrame){
        createGUI(myFrame);
        viewController=new ViewController();
    }

    public void createGUI(JFrame myFrame){

        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().repaint();    

        panel = new JPanel();
        identity=new JTextField(10);
        password=new JPasswordField();
        identityLabel=new JLabel("login    ");
        passwordLabel=new JLabel("password ");
        choiceRetailer=new JRadioButton("Login as retailer");
        choiceCashier=new JRadioButton("Login as cashier");

        panel.setLayout(null);
        identity.setBounds(350,250,150,25);
        password.setBounds(350,290,150,25);
        identityLabel.setBounds(260,250,120,25);
        passwordLabel.setBounds(260,290,120,25);

        choiceRetailer.setBounds(250,340,150,20);
        choiceCashier.setBounds(420,340,200,20);

        login = new JButton("");

        String iconfilePath = this.getClass().getClassLoader().getResource("images/signin.png").getFile();
        login.setIcon(new ImageIcon(iconfilePath));
        login.setBounds(300, 0, 250, 250);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setContentAreaFilled(false);
        login.setFocusable(false);

        signin=new JButton("Sign in");
        signin.setBounds(250,450,140,20);
        signin.addActionListener(this);

        register=new JButton("Register");
        register.setBounds(450,450,140,20);
        register.addActionListener(this);

        choiceCashier.addActionListener(this);
        choiceRetailer.addActionListener(this);

        panel.add(identity);
        panel.add(password);
        panel.add(identityLabel);
        panel.add(passwordLabel);
        panel.add(choiceRetailer);
        panel.add(choiceCashier);
        panel.add(login);
        panel.add(signin);
        panel.add(register);

        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
                System.out.println("LALALALA");
			}
		});
        myFrame.add(panel);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(800,620);
        myFrame.setVisible(true);
        frame=myFrame;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==choiceCashier){
            choiceRetailer.setSelected(false);
        }
        if(source==choiceRetailer){
            choiceCashier.setSelected(false);
        }
        if(source == register){
            viewController.loadRegisterFrame(frame);
        }
        if(source == signin){
            if(identity.getText()!="" && String.valueOf(password.getPassword())!="" && (choiceCashier.isSelected()|| choiceRetailer.isSelected())){
                viewController.checkLogin(frame,identity.getText(),String.valueOf(password.getPassword()));
            }
            else{
                JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}