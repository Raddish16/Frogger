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

public  class Player extends Creature{
    private Game game;
    private BufferedImage playerImage;
    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;
        playerImage = imageLoader.loadImage("/textures/New Piskel-1.png.png");
    }

    @Override
    public void tick() {
        if(game.getKeyManager().u)//keep in mind that the graph is inverted
        {
            y-=3;
        }
        if(game.getKeyManager().d)
        {
            y+=3;
        }
        if(game.getKeyManager().l)
        {
            x -= 3;
        }
        if(game.getKeyManager().r)
        {
            x+= 3;
        }


    }

    @Override
    public void render(Graphics graph) {
        graph.drawImage(playerImage,(int)x,(int)y,null);
      //graph.setColor(Color.cyan);
      //graph.fillRect((int)x,(int)y,20,20);

    }
}
