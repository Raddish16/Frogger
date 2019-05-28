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
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class FroggerFrame {
    
    private JFrame frame;
    private Canvas frogCanvas;
    
    private String title;
    private int width, height;
    
    public FroggerFrame(String t, int w, int h){
        title = t;
        width = w;
        height = h;
        
        //creates frame
        frame= new JFrame(title);	
	frame.setTitle("Frogger");
	frame.setSize(width, height);
	frame.setLocation(0,0);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //canvas for drawing graphics
        frogCanvas = new Canvas();
        frogCanvas.setPreferredSize(new Dimension(width, height));
        frogCanvas.setMaximumSize(new Dimension(width, height));
        frogCanvas.setMinimumSize(new Dimension(width, height));
        frame.add(frogCanvas);
        
        //resize window to see canvas fully
        frame.pack();
    }
    
   
    
    
}
