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

public class GameState extends State {

    private Player player;
    private LogCar logcar,logcar2;


    public GameState(Game game)
    {
        
        super(game);
        player = new Player(game,game.width/2,game.height - 20);
        logcar = new LogCar(game,0,300);
        logcar2 = new LogCar(game,game.width,150);
        logcar2.setDirection(false);

    }

    @Override//not neccesary but informs compiler of overidden method, may prevent error
    public void tick() {
        player.tick();
        logcar.tick();
        logcar2.tick();

    }

    @Override
    public void render(Graphics graph) {
        player.render(graph);
        logcar.render(graph);
        logcar2.render(graph);

    }
}
