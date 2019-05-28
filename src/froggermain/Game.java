/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froggermain;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasuki
 */
public class Game implements Runnable{
    
    private FroggerFrame frame1;
    public int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    public Game(String t, int w, int h){
        title = t;
        width = w;
        height = h;
    }
    
    //initialize graphics of game
    private void init(){
        frame1 = new FroggerFrame(title, width, height);
   
    }
    
    //updates all variables, positions, etc
    private void tick(){
        
    }
    
    //render(draw) everything on screen
    private void render(){
        
        
    }
    
    //called by start
    public void run(){
        init();
        //game loop
        while(running){
            tick();
            render(); 
        }
        stop();
    }
    
    public synchronized void start(){
        //prevents starting thread if thread already started
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        //prevents stopping thread if thread already stopped
        if(!running)
            return;
        running = false;
        //prevents error, idk what it really does 
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
