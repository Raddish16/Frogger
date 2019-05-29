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
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class Player extends Creature{
    private Game game;
    private BufferedImage playerImage;
    private int tickCountMove,inMoveCount;
    private boolean inMove;
    private String thisKey;
    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
        playerImage = imageLoader.loadImage("/textures/New Piskel-1.png.png");
        tickCountMove = 40;
        inMove = false;
        inMoveCount = 0;
        thisKey = null;
    }
    
    @Override
    public void tick() {
        tickCountMove++;
        
        if(inMove){
            playerImage = imageLoader.loadImage("/textures/FrogJumping.png");
            if(thisKey.equals("u"))
                y-=2;
            if(thisKey.equals("d"))
                y+=2;
            if(thisKey.equals("l"))
                x-=2;
            if(thisKey.equals("r"))
                x+=2;
            inMoveCount++;
            if(inMoveCount>20){
                playerImage = imageLoader.loadImage("/textures/New Piskel-1.png.png");
                inMove = false;
                inMoveCount = 0;
            }
        }
        
        if(game.getKeyManager().u&&tickCountMove>60)//keep in mind that the graph is inverted
        {
            thisKey = "u";
            inMove = true;
            tickCountMove = 0;
            
        }
        if(game.getKeyManager().d&&tickCountMove>80)
        {
            thisKey = "d";
            inMove = true;
            tickCountMove = 0;
        }
        if(game.getKeyManager().l&&tickCountMove>80)
        {
            thisKey = "l";
            inMove = true;
            tickCountMove = 0;
        }
        if(game.getKeyManager().r&&tickCountMove>80)
        {
            thisKey = "r";
            inMove = true;
            tickCountMove = 0;
        }
       

    }

    @Override
    public void render(Graphics graph) {
        graph.drawImage(playerImage,(int)x,(int)y,null);
      //graph.setColor(Color.cyan);
      //graph.fillRect((int)x,(int)y,20,20);

    }
}
