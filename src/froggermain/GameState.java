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



    public GameState(Game game)
    {
        super(game);
        player = new Player(game,game.width/2,game.height - 20);

    }

    @Override
    public void tick() {
        player.tick();

    }

    @Override
    public void render(Graphics graph) {
        player.render(graph);


    }
}
