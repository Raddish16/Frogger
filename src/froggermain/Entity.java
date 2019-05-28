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

public abstract class Entity {

    protected float x,y;

    public Entity (float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
