
package edu.itla.waldo.proyecto;

import java.io.IOException;

/**
 * Esta es la segunda version del juego The At Dungeon by Edwin Quijada
 * @author Waldo Milanes
 * @version 2.0
 */
public class TAD {
    /**
     * Este metodo comienza el juego, llamado asi,todos los elementos del juego.
     * @param tablero tablero es la matriz del tablero requerida para todos los
     * metodos.
     */
    public void start(char[][] tablero) throws IOException, InterruptedException {
        Demonios.salidaDemonios(tablero);
        Pantalla.fillParedes(tablero);
        Pantalla.fillPuntos(tablero);
        Player.avatar(tablero);
        Pantalla.print(tablero);
        Player.input(tablero);
    }
}
