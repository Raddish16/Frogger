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
public class FroggerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game game = new Game("Frogger",1400,800);
        game.start();
    }
    
}
