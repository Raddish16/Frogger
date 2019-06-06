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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyManager implements KeyListener {

    public boolean u,d,l,r,w,a,s,dLet;

    private boolean[] keys;

    public KeyManager()
    {
        keys = new boolean[256];
    }

    public void tick()
    {
        u = keys[KeyEvent.VK_UP];
        d = keys[KeyEvent.VK_DOWN];
        l = keys[KeyEvent.VK_LEFT];
        r = keys[KeyEvent.VK_RIGHT];
        w = keys[KeyEvent.VK_W];
        a = keys[KeyEvent.VK_A];
        s = keys[KeyEvent.VK_S];
        dLet = keys[KeyEvent.VK_D];
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //not important right now

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }
}
