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

        gameState = new GameState(this);
        State.setState(gameState);
    }



    private void tick()
    {
        km.tick();
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
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / tickTime;
            timer += now - lastTime;
            lastTime = now;

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
