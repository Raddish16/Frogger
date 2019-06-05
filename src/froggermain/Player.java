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
    private boolean onLeft, onRight;
    private int logSpeed,score;
    
    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
        playerImage = imageLoader.loadImage("/textures/New Piskel-1.png.png");
        tickCountMove = 40;
        inMove = false;
        inMoveCount = 0;
        thisKey = null;
        jumpDistance =0;
        score = 0;
        
    }
    
    @Override
    public void tick() {
        tickCountMove++;
        
        if(inMove){
            
            if(thisKey.equals("u")){
                playerImage = imageLoader.loadImage("/textures/FrogJumping.png");
                y-=10;
            }if(thisKey.equals("d")){
                playerImage = imageLoader.loadImage("/textures/FrogJumpDown.png.png");
                y+=10;
            }if(thisKey.equals("l")){
                playerImage = imageLoader.loadImage("/textures/FrogJumpLeft.png.png");
                x-=10;
            }if(thisKey.equals("r")){
                playerImage = imageLoader.loadImage("/textures/FrogJumpRight.png.png");
                x+=10;
            }
            
            inMoveCount++;
            
            if(inMoveCount>=5){
                
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
        if(game.getKeyManager().u&&!inMove&&tickCountMove>10)//keep in mind that the graph is inverted
        {
            score++;
            thisKey = "u";
            inMove = true;
            tickCountMove = 0;
            onRight = false;
            onLeft = false;
            
        }
        if(game.getKeyManager().d&&!inMove&&tickCountMove>10)
        {
            score--;
            thisKey = "d";
            inMove = true;
            tickCountMove = 0;
            onRight = false;
            onLeft = false;
        }
        if(game.getKeyManager().l&&!inMove&&tickCountMove>10)
        {
            thisKey = "l";
            inMove = true;
            tickCountMove = 0;
            onRight = false;
            onLeft = false;
        }
        if(game.getKeyManager().r&&!inMove&&tickCountMove>10)
        {
            thisKey = "r";
            inMove = true;
            tickCountMove = 0;
            onRight = false;
            onLeft = false;
        }
        if(onLeft){
            x-=logSpeed;
        }
        if(onRight){
            x+=logSpeed;
        }

    }

    @Override
    public void render(Graphics graph) {
        graph.drawImage(playerImage,(int)x,(int)y,null);
        graph.drawRect((int)(x),(int)(y),32,32);

    }
    public Rectangle getBounds(){
        return new Rectangle((int)(x),(int)(y),32,32);
    }
    public boolean getInMove(){
        return inMove;
    }
    public void setInMove(boolean setter){
        inMove = setter;
    }
    public void setCountZero(){
        inMoveCount = 0;
    }
    public void setOnLeft(boolean l){
        onLeft = l;
    }
    public void setOnLogSpeed(LogCar l){
        logSpeed = l.getSpeed();
    }
    public void setOnRight(boolean r){
        onRight = r;
    }
    public String getKey(){
        return thisKey;
    }
    public boolean getOnLog(){
        if(onLeft || onRight){
            return true;
        }return false;
        
    }
    public BufferedImage loadDeath(){
        if(thisKey.equals("u")){
            return imageLoader.loadImage("/textures/FrogDead.png.png");
        }if(thisKey.equals("d")){
            return imageLoader.loadImage("/textures/FrogDeadDown.png");    
        }if(thisKey.equals("l")){
            return imageLoader.loadImage("/textures/FrogDeadLeft.png");    
        }if(thisKey.equals("r")){
            return imageLoader.loadImage("/textures/FrogDeadRight.png");    
        }return imageLoader.loadImage("/textures/FrogDead.png.png");
        
    }
    public int getScore(){
        return score;
    }
    public void resetScore(){
        score = 0;
        
    }
}
