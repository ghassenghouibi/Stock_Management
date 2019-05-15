
import javax.swing.JFrame;

import view.ViewEngine;

class Main{
    public static void main(String arg[]){
        JFrame myFrame = new JFrame("Stock-management");
        new ViewEngine(myFrame);
    } 
}