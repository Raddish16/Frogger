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
public class Lines {
    LogCar LC;
    boolean[] arry;
    boolean isBlank;
    int position;
    int width;
    
    public Lines(int w){
        width = w;
        arry = new boolean[w];
        
        if(Math.random() > .2){
            LC = new LogCar();
            isBlank = false;
            
        }else{
            for(int x = 0; x < arry.length; x++){
                arry[x] = true;  
            }
            isBlank = true;
        }
        
    }
    
    public void run(){
        if(LC.getDirection()){
            position = 0;
        }else{
            position = width - 1;
        }
        
    }
    
    
}
