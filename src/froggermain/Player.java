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
    private int jumpDistance;
    private Rectangle r;
    
    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
        playerImage = imageLoader.loadImage("/textures/New Piskel-1.png.png");
        tickCountMove = 40;
        inMove = false;
        inMoveCount = 0;
        thisKey = null;
        jumpDistance =0;
        r = new Rectangle((int)(x),(int)(y),32,32);
        
    }
    
    @Override
    public void tick() {
        tickCountMove++;
        
        if(inMove){
            
            if(thisKey.equals("u")){
                playerImage = imageLoader.loadImage("/textures/FrogJumping.png");
                y-=5;
                jumpDistance+=5;
            }if(thisKey.equals("d")){
                playerImage = imageLoader.loadImage("/textures/FrogJumpDown.png.png");
                y+=5;
            }if(thisKey.equals("l")){
                playerImage = imageLoader.loadImage("/textures/FrogJumpLeft.png.png");
                x-=5;
            }if(thisKey.equals("r")){
                playerImage = imageLoader.loadImage("/textures/FrogJumpRight.png.png");
                x+=5;
            }
            
            inMoveCount++;
            
            if(inMoveCount>=20){
                
                if(thisKey.equals("u")){
                    playerImage = imageLoader.loadImage("/textures/New Piskel-1.png.png");
                }if(thisKey.equals("d")){
                    playerImage = imageLoader.loadImage("/textures/FrogDown.png.png");
                }if(thisKey.equals("l")){
                    playerImage = imageLoader.loadImage("/textures/FrogLeft.png.png");
                }if(thisKey.equals("r")){
                    playerImage = imageLoader.loadImage("/textures/FrogRight.png.png");
                }
                
                inMove = false;
                inMoveCount = 0;
            }
        }
        if(game.getKeyManager().u&&!inMove&&tickCountMove>30)//keep in mind that the graph is inverted
        {
            thisKey = "u";
            inMove = true;
            tickCountMove = 0;
            
        }
        if(game.getKeyManager().d&&!inMove&&tickCountMove>30)
        {
            thisKey = "d";
            inMove = true;
            tickCountMove = 0;
        }
        if(game.getKeyManager().l&&!inMove&&tickCountMove>30)
        {
            thisKey = "l";
            inMove = true;
            tickCountMove = 0;
        }
        if(game.getKeyManager().r&&!inMove&&tickCountMove>30)
        {
            thisKey = "r";
            inMove = true;
            tickCountMove = 0;
        }
       

    }

    @Override
    public void render(Graphics graph) {
        graph.drawImage(playerImage,(int)x,(int)y,null);
        graph.drawRect((int)(x),(int)(y),32,32);
      //graph.setColor(Color.cyan);
      //graph.fillRect((int)x,(int)y,20,20);

    }
    public Rectangle getBounds(){
        return new Rectangle((int)(x),(int)(y),32,32);
    }
}
