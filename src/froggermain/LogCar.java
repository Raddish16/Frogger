/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froggermain;

/**
 *
 * @author 770771
 */
public class LogCar{
    public boolean isLog;
    public int length;
    public int every;
    public boolean moveRight;
    public boolean isAlive;
    
    public LogCar(){
        
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
    
    public LogCar( boolean log){
        
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
}
