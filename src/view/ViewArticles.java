package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xml.internal.dtm.Axis;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


public class ViewArticles{

	private JTextField identity;
    private JPasswordField password;
    private JLabel identityLabel,passwordLabel;
    private JRadioButton choiceRetailer,choiceCashier;
    private JButton add,edit,order,delete;
    private JPanel panel;
    private JFrame myFrame;


    public ViewArticles(){
        createGUI();
    }

    public void createGUI(){
        myFrame =new JFrame();
        //myFrame.setPreferredSize(new Dimension(800,620));
        panel = new JPanel();
       

        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        myFrame.add(panel);
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(800,620);
        myFrame.setVisible(true);
    }
}