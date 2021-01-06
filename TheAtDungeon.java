
package edu.itla.waldo.proyecto;

/**
 * Esta clase es la interface del juego "The At Dungeon".
 * @author Waldo Milanes
 * @version 1.0
 * @since 12/06/2018
 */
public class TheAtDungeon {
    public static void main (String[] args){
        char[][] tablero = new char[15][60];
        TADMethods a = new TADMethods(); 
        
        for(int i=0;i<50;i++){
            a.start(tablero);
            
          
        }
        
        
       
    }
}
