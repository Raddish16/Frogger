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
public class Game {
    
    private FroggerFrame frame1;
    
    public int width, height;
    
    public Game(String t, int w, int h){
        width = w;
        height = h;
        frame1 = new FroggerFrame(t, w, h);
    }
}
