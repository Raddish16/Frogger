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
import java.util.ArrayList;

public class GameState extends State {

    private Player player;
    
    ArrayList<LogCar> carlog = new ArrayList<LogCar>();


    public GameState(Game game)
    {
        
        super(game);
        player = new Player(game,game.width/2,game.height - 20);
        
        addLC();
        addLC();
        addLC();
        
        
    }

    @Override//not neccesary but informs compiler of overidden method, may prevent error
    public void tick() {
       
        for(int x = 0; x< carlog.size(); x++){
            carlog.get(x).tick();
        }
        player.tick();
        

    }

    @Override
    public void render(Graphics graph) {
        for(int x = 0; x< carlog.size(); x++){
            carlog.get(x).render(graph);
        }
        
        player.render(graph);
        
    }
    
    public void addLC(){
        int position = 50*(int)((Math.random()*10)+1);
        
        if(Math.random() >= .5){
            carlog.add(new LogCar(game, 0, position));
            carlog.get(carlog.size() -1).setDirection(true);
        }else{
            carlog.add(new LogCar(game, game.width, position));
            carlog.get(carlog.size() - 1).setDirection(false);
        }
        
    }
}
