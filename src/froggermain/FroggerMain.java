/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froggermain;



/**
 *
 * @author Yasuki Wu
 */
import javax.swing.JFrame;
import java.awt.GraphicsConfiguration;
public class FroggerMain {

    /**
     * @param args the command line arguments
     */
    static GraphicsConfiguration gc;
    public static void main(String[] args) {
        // TODO code application logic here
         JFrame frame= new JFrame(gc);	
	 frame.setTitle("Frogger");
	 frame.setSize(600, 400);
	 frame.setLocation(200, 200);
	 frame.setVisible(true);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
