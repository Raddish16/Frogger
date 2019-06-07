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
    private Player_1 player2;
    private Game gam;
    ArrayList<LogCar> carlog = new ArrayList<LogCar>();
    private int tickCount;
    private float deathX,deathY,deathX2,deathY2;
    private boolean deathOccured, deathOccured2,win,win2;
    private BufferedImage i;
    private BufferedImage i2;
    private Color road, water, end;
    private ArrayList<Rectangle>rep;
    
    public GameState(Game game) {
        
        super(game);
        player = new Player(game, game.width / 2+100, game.height-38);
        player2 = new Player_1(game, game.width / 2-100, game.height-38);
        tickCount = 0;
        gam = game;
        for(int x = 0; x < 14; x++){
            addLC(44 + x*50);
            
        }
        rep = new ArrayList<Rectangle>();
        for(int y = 0;y<14;y+=1){
            if(carlog.get(y).getLog()){
                rep.add(new Rectangle(0, y*50+50, 1400, 50));
            
            }
         }
        deathOccured = false;
        i = imageLoader.loadImage("/textures/FrogDead.png.png");
        i2 = imageLoader.loadImage("/textures/PurpFrogDead.png");
        road = new Color(32,32,32);
        water = new Color(0,0,204);
        end = new Color(0,204,0);
        win = false;
        win2 = false;
        
    }

    @Override//not neccesary but informs compiler of overidden method, may prevent error
    public void tick() {
        
        for (int x = 0; x < carlog.size(); x++) {
            carlog.get(x).tick();
        }
        player.tick();
        player2.tick();
        //does player1 hit log
        for(LogCar l:carlog){
            float xHolder;
            float yHolder;
            if (l.getBounds().intersects(player.getBounds()) || player.x == 0 || player.x == game.width -30 ){
                if(!l.getLog()){    
                    player.setInMove(false);
                    player.setCountZero();
                    deathOccured = true;
                    i = player.loadDeath();

                    xHolder = player.x;
                    yHolder = player.y;
                    deathX = xHolder;
                    deathY = yHolder;
                    xHolder = 0;
                    yHolder = 0;


                    player.y = game.height-38;
                    player.x = game.width/2+100;
                    player.resetScore();
                }
                else{
                    if(!player.getInMove()){
                        if (l.moveRight){
                            player.setOnLogSpeed(l);
                            player.setOnRight(true);
                        }
                        else{
                            player.setOnLogSpeed(l);
                            player.setOnLeft(true);
                        }
                    }
                    
                }
            }
            
        }
        //does player2 hit log
        for(LogCar l:carlog){
            float xHolder;
            float yHolder;
            if (l.getBounds().intersects(player2.getBounds()) || player2.x == 0 || player2.x == game.width -30 ){
                if(!l.getLog()){    
                    player2.setInMove(false);
                    player2.setCountZero();
                    deathOccured2 = true;
                    i2 = player2.loadDeath();

                    xHolder = player2.x;
                    yHolder = player2.y;
                    deathX2 = xHolder;
                    deathY2 = yHolder;
                    xHolder = 0;
                    yHolder = 0;


                    player2.y = game.height-38;
                    player2.x = game.width/2-100;
                    player2.resetScore();
                }
                else{
                    if(!player2.getInMove()){
                        if (l.moveRight){
                            player2.setOnLogSpeed(l);
                            player2.setOnRight(true);
                        }
                        else{
                            player2.setOnLogSpeed(l);
                            player2.setOnLeft(true);
                        }
                    }
                    
                }
            }
            
        }
        //does player1 hit water
        for(Rectangle r:rep){
            float xHolder;
            float yHolder;
            if(player.getBounds().intersects(r)&&!player.getInMove()&&!player.getOnLog()){
                deathOccured = true;
                i = player.loadDeath();

                xHolder = player.x;
                yHolder = player.y;
                deathX = xHolder;
                deathY = yHolder;
                xHolder = 0;
                yHolder = 0;

                player.y = game.height-38;
                player.x = game.width/2+100;
                player.resetScore();
            }
        }
        //does player2 hit water
        for(Rectangle r:rep){
            float xHolder;
            float yHolder;
            if(player2.getBounds().intersects(r)&&!player2.getInMove()&&!player2.getOnLog()){
                deathOccured2 = true;
                i2 = player2.loadDeath();

                xHolder = player2.x;
                yHolder = player2.y;
                deathX2 = xHolder;
                deathY2 = yHolder;
                xHolder = 0;
                yHolder = 0;

                player2.y = game.height-38;
                player2.x = game.width/2-100;
                player2.resetScore();
            }
        }
        
        Rectangle end = new Rectangle(0,0,1400,50);
        if(player.getBounds().intersects(end)&&!player.getInMove())
            win = true;
        if(player2.getBounds().intersects(end)&&!player2.getInMove())
            win2 = true;
        
        tickCount++;
        for (int x = 0; x < carlog.size(); x++) {
            if(carlog.get(x).getX() > game.width && carlog.get(x).getDirection()){
                carlog.get(x).setX(0);
            }else if(carlog.get(x).getX() < 0 && !carlog.get(x).getDirection()){
                carlog.get(x).setX(game.width);
            }
        }
        spawn();
        
        
    }

    @Override
    public void render(Graphics graph) {

         for(int y = 0;y<14;y+=1){
            if(carlog.get(y).getLog()){
                graph.setColor(water);
                graph.fillRect(0, y*50+50, 1400, 50);
            
            }else if(!carlog.get(y).getLog()){
                graph.setColor(road);
                graph.fillRect(0, y*50+50, 1400, 50);
            
            }
         }
        graph.setColor(end);
        graph.fillRect(0, 0, 1400, 50);
        graph.fillRect(0, 750, 1400, 50);
        
        if(deathOccured){
            graph.drawImage(i,(int)deathX,(int)deathY,null);
            
           
        }
        if(deathOccured2){
            graph.drawImage(i2,(int)deathX2,(int)deathY2,null);
            
            
        }
        for (int x = 0; x < carlog.size(); x++) {
            carlog.get(x).render(graph);
            
        }
        player.render(graph);
        player2.render(graph);
        graph.setColor(Color.white);
        graph.drawString("Green Score: "+player.getScore(), 1300, 25);
        graph.drawString("Purple Score: "+player2.getScore(), 50, 25);
        if(getWin()){
            graph.drawString("Green Wins", 700, 400);
        }
        if(getWin2()){
            graph.drawString("Purple Wins", 700, 400);
        }
        
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
            if(Math.random() > .995){
            if(carlog.get(x).getDirection() && carlog.get(x).getPAr() < 4 && carlog.get(x).getX() > 300){
                LogCar saki = new LogCar(game, 0, carlog.get(x).getPosition(), carlog.get(x).getLog(), carlog.get(x).speed, carlog.get(x).getDirection());
                saki.setX(0);
                carlog.add(saki);
                
            }else if(!carlog.get(x).getDirection() && carlog.get(x).getPAr() < 4 && carlog.get(x).getX() < 1100){
                LogCar saki = new LogCar(game, game.width, carlog.get(x).getPosition(), carlog.get(x).getLog(), carlog.get(x).speed, carlog.get(x).getDirection());
                saki.setX(game.width);
                carlog.add(saki);
            }}
        }
        
    }
    public boolean getWin(){
        if(win&&!win2)
            return win;
        else
            return false;
    }
    public boolean getWin2(){
        if(win2&&!win)
            return win2;
        else
            return false;
    }
}
