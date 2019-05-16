package view;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;




public class Dialog{

    private static JDialog d;  
    
    public Dialog(JFrame myframe) {  

        d = new JDialog(myframe , "Dialog Example", true);  
        d.setLayout( new FlowLayout() );  
        JButton b = new JButton ("OK");  
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                Dialog.d.setVisible(false);  
            }  
        });  
        d.add( new JLabel ("Click button to continue."));  
        d.add(b);   
        d.setSize(300,300);    
        d.setVisible(true);  
    } 

}