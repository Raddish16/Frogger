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
import java.util.ArrayList;

public class GameState extends State {

    private Player player;
    private Game gam;
    ArrayList<LogCar> carlog = new ArrayList<LogCar>();
    private int tickCount;
    private float deathX,deathY;
    private boolean deathOccured;
    private BufferedImage i;
    
    public GameState(Game game) {
        
        super(game);
        player = new Player(game, game.width / 2, game.height-16);
        tickCount = 0;
        gam = game;
        for(int x = 0; x < 7; x++){
            addLC(100 + x*100);
            
        }
        deathOccured = false;
    }

    @Override//not neccesary but informs compiler of overidden method, may prevent error
    public void tick() {

        for (int x = 0; x < carlog.size(); x++) {
            carlog.get(x).tick();
        }
        player.tick();
        for(LogCar l:carlog){
            float xHolder;
            float yHolder;
            if (l.getBounds().intersects(player.getBounds())){
                System.out.println("collide");
                player.setInMove(false);
                player.setCountZero();
                deathOccured = true;
                
                i = imageLoader.loadImage("/textures/FrogDead.png.png");
                xHolder = player.x;
                yHolder = player.y;
                deathX = xHolder;
                deathY = yHolder;
                xHolder = 0;
                yHolder = 0;
               
                
                player.y = game.height-16;
                player.x = game.width/2;
            }
            
        }
        //for spawing logcar, may need to move code to another class
        tickCount++;
        for (int x = 0; x < carlog.size(); x++) {
            if(carlog.get(x).getX() > game.width && carlog.get(x).getDirection()){
                carlog.get(x).setX(0);
            }else if(carlog.get(x).getX() < 0 && !carlog.get(x).getDirection()){
                carlog.get(x).setX(game.width);
            }
        }
        if(Math.random() > .5){
            spawn();
        }
        
    }

    @Override
    public void render(Graphics graph) {
        if(deathOccured){
            graph.drawImage(i,(int)deathX,(int)deathY,null);
        }
        for (int x = 0; x < carlog.size(); x++) {
            carlog.get(x).render(graph);
        }
        
        player.render(graph);
        
    }

    public void addLC(int pos) {
        int position = pos;

        if (Math.random() >= .5) {
            carlog.add(new LogCar(game, 0, position));
            carlog.get(carlog.size() - 1).setDirection(true);
            
        } else {
            carlog.add(new LogCar(game, game.width, position));
            carlog.get(carlog.size() - 1).setDirection(false);
        }
       
    }
    
    public void spawn(){
        
        for (int x = 0; x < carlog.size(); x++) {
            if(Math.random() > .3 && carlog.get(x).getX() > 128 && carlog.get(x).getDirection()){
                LogCar saki = carlog.get(x).getLC();
                if(saki.getDirection()){
                    saki.setX(0);
                }else{
                    saki.setX(game.width);
                }
                carlog.add(saki);
            }
        }
        
    }
}
