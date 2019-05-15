package view;

import javax.swing.*;
import java.awt.event.*;



public class ViewRegister implements ActionListener{

    private JTextField identity;
    private JPasswordField password;
    private JLabel identityLabel,passwordLabel;
    private JButton login,cancel,register;
    private JPanel panel;
    private JFrame frame;


    public ViewRegister(JFrame frame){
        createGUI(frame);
    }

    public void createGUI(JFrame myFrame){
        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().repaint();    

        panel = new JPanel();
        identity=new JTextField(10);
        password=new JPasswordField();
        identityLabel=new JLabel("login    ");
        passwordLabel=new JLabel("password ");

        panel.setLayout(null);
        identity.setBounds(350,250,150,25);
        password.setBounds(350,290,150,25);
        identityLabel.setBounds(260,250,120,25);
        passwordLabel.setBounds(260,290,120,25);


        login = new JButton("");

        String iconfilePath = this.getClass().getClassLoader().getResource("images/register.png").getFile();
        login.setIcon(new ImageIcon(iconfilePath));
        login.setBounds(300, 0, 250, 250);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setContentAreaFilled(false);
        login.setFocusable(false);


        register=new JButton("Register");
        register.setBounds(250,450,140,20);
        register.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(450,450,140,20);
        cancel.addActionListener(this);

        panel.add(identity);
        panel.add(password);
        panel.add(identityLabel);
        panel.add(passwordLabel);
        panel.add(login);
        panel.add(cancel);
        panel.add(register);

        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
                myFrame.dispose();
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
        if(source==register){
            System.out.println("Register");
        }
        if(source==cancel){
            System.out.println("Cancel");
            new ViewEngine(frame);
        }
    }

}