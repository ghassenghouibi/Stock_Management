package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.BarChart;


public class ViewArticles{

    public ViewArticles(){
        createGUI();
    }

    public void createGUI(){
        JFrame frame = new JFrame("Bar Chart");
        BarChart chart = new BarChart();
        chart.addBar(Color.red, 100);
        chart.addBar(Color.green, 8);
        chart.addBar(Color.blue, 54);
        chart.addBar(Color.white, 60);
        chart.addBar(Color.yellow, 24);
        chart.addBar(Color.cyan, 70);
        chart.addBar(Color.gray, 6);
        chart.addBar(Color.lightGray, 77);
        chart.addBar(Color.magenta, 90);
        chart.addBar(Color.pink, 12);
        chart.addBar(Color.orange, 65);

        frame.getContentPane().add(chart);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,620);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});

    }
}