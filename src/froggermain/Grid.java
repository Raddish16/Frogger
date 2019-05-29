package froggermain;

import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yasuki Wu
 */
public class Grid {
    private int[][]locations;
    private int rowSize, colSize;
    public Grid(Game game){
        rowSize = game.width/10;
        colSize = game.width/10;
        
    }
    
    
}
