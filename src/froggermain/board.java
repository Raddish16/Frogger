/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froggermain;

/**
 *
 * @author 770771
 */
public class board {
    Lines[] gameBoard;
    public int width;
    public int height;
    public int start;
    
    public board(int w, int h){
        width = w;
        height = h;
        gameBoard = new Lines[height];
    }
    
    //public void run(){
        
   // }
    
    public void intitializeBoard(){
        for(int x = 0; x < height; x++){
            gameBoard[x] = new Lines(width);
        }
    }
    
   
}
