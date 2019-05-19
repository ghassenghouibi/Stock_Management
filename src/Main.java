
import javax.swing.JFrame;

import pkg_view.ViewLogin;

class Main{
    public static void main(String arg[]){
        JFrame myFrame = new JFrame("Stock-management");
        new ViewLogin(myFrame);
    } 
}