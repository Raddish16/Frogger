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
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;

    public int width, height;
    public String title;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bStrat; //way for computer to draw to screen
    private Graphics graph;

    private BufferedImage image;

    private State gameState;

    private KeyManager km;

    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;
        km = new KeyManager();

    }

    private void init()
    {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(km);
        image = imageLoader.loadImage("/textures/New Piskel-2.png"); //temp code to show graphics
        gameState = new GameState(this);
        State.setState(gameState);//current state(tick and render) set to gameState
        
    }


    int x; //temp code
    private void tick()
    {
        
        km.tick();
        x+=1; //temp code
        if (State.getState() != null)
        {
            State.getState().tick();
        }

    }

    private void render()
    {
        bStrat = display.getCanvas().getBufferStrategy();
        if( bStrat == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graph = bStrat.getDrawGraphics();//Draws stuff to screen

        graph.clearRect(0,0,width,height);
        
        //temp code to show graphics
        graph.drawImage(image,450 ,20 , null);
        graph.drawImage(image,450 ,120 , null);
        graph.drawImage(image,450 ,220 , null);
        graph.drawImage(image,450 ,320 , null);
        graph.drawImage(image,x ,123 , null);
        graph.drawImage(image,x ,221 , null);
        graph.drawImage(image,x ,23 , null);
        graph.drawImage(image,x ,345 , null);
        
        if (State.getState() != null)
        {
            State.getState().render(graph);
        }



        bStrat.show();
        graph.dispose();

    }

    public void run()
    {
        init();

        int fps = 40;  //Times running tick and render every second
        double tickTime = 1000000000/ fps; // time in nano seconds to execute tick and render
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();//current time of computer in nanoseconds
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / tickTime;//adds amount of time since line last ran, div by max time allowed
            timer += now - lastTime;//adds amount of time passed since lina above last ran
            lastTime = now;

            //if the time accumulates to over 1, need to tick and render to maintain framerate
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta --;
            }
            if (timer >= 1000000000) //when timer == 1 billion nanoseconds or 1 second, display ticks per second
            {
                System.out.println("Ticks: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }


        stop();

    }
    public KeyManager getKeyManager() {

        return km;
    }


    public synchronized void start()
    {
        if(running)
        {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop()
    {
        if(!running)
        {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
