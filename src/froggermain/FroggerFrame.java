/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froggermain;

/**
 *
 * @author Yasuki
 */
import javax.swing.JFrame;

public class FroggerFrame {
    private JFrame frame;
    private String title;
    private int width, height;
    public FroggerFrame(String t, int w, int h){
        title = t;
        width = w;
        height = h;
        
        JFrame frame= new JFrame(title);	
	frame.setTitle("Frogger");
	frame.setSize(width, height);
	frame.setLocation(0,0);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
}
