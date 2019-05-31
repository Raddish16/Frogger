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
public class Handler {
    private Game game;
    
    public Handler(Game g){
        game = g;
        
    }
    
    public Game getGame(){
        return game;
        
    }
    public void setGame(Game s){
        game = s;
        
    }
}
