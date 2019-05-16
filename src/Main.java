
import javax.swing.JFrame;

import view.ViewLogin;

class Main{
    public static void main(String arg[]){
        JFrame myFrame = new JFrame("Stock-management");
        new ViewLogin(myFrame);
    } 
}