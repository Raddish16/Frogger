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

public abstract class State {

    private static State current = null;

    public static void setState(State state)
    {
        current = state;
    }

    public static State getState()
    {
        return current;
    }

    protected Game game;

    public State(Game game)
    {
        this.game = game;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
