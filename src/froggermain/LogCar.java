/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froggermain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author 770771
 */
public class LogCar extends Entity{
    private Game game;
    private BufferedImage image;
    private int counter;
    
    
    
    public boolean isLog;
    public int length;
    public int every;
    public boolean moveRight;
    public boolean isAlive;
    
    public LogCar(Game game, float x, float y){
        super(x,y);
        image = imageLoader.loadImage("/textures/New Piskel-2.png");
        every = 10000;
        moveRight = true;
        counter = 0;
        
        if(Math.random()>=.5){
            isLog = true;
            
        }else{
            isLog = false;
        }
        
        if(isLog){
            length = (int)(Math.random()*3) + 3;
        }else{
            length = (int)(Math.random()*2) + 1;
        }
        
        
    }    
    
    public LogCar(Game game, float x, float y, boolean log){
        super(x,y);
        isLog = log;
        if(isLog){
            length = (int)(Math.random()*3) + 3;
        }else{
            length = (int)(Math.random()*2) + 1;
        }
    }
    
    public int getLength() {
        return length;
    }

    public void spawnTime(int y) {
        every = y;
    }
    
    public void setDirection(boolean isR) {
        moveRight = isR;
    }
    
    public boolean getDirection(){
        return moveRight;
    }

    public void setAlive(boolean live){
       isAlive = live;
    }
   
    public boolean getAlive() {
        return isAlive;
    }
    
    public boolean getLog(){
        return isLog;
    }
    
    public void tick(){
        counter++;
        
        if(getDirection()){
            x+=3;
        }
        else
            x-=3;
        
    }
    @Override
    public void render(Graphics graph){
        graph.drawImage(image,(int)x,(int)y, null);
    }
}
