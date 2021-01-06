
package edu.itla.waldo.proyecto;

import java.io.IOException;

/**
 * Esta clase contiene metodos relacionados con los demonios del juego The At
 * Dungeon by Edwin Quijada
 * @author Waldo Milanes
 * @version 2.0
 */
public class Demonios {

    /**
     * multiplicaDemonios(char[][] m, int veces) es un metodo privado llamado
     * por (movimiento()) para multiplicar los demonios. Si un demonio(#) cae
     * sobre el avatar(@), lo declara muerto (dead) llama la parte GAMEOVER del
     * metodo print(). si el espacio esta ocupado por una pared(*) o otro
     * demonio(#), se escoge otro espacio aleatorio para el proximo demonio.
     * Incrementa la variable (numDemonios) para la impresion en pantalla.
     *
     * @param m m es la matriz que representa el tablero.
     * @param veces veces es el numero de veces que se quiere multiplicar los
     * demonios.
     */
    public static void multiplicaDemonios(char[][] m) throws IOException, InterruptedException {
        Pantalla.resetear(m);
      /*  int veces = Variables.getMultiplica();
        for (int i = 0; i < 4 * veces; i++) {
            int fila = Randomizer.uno(0, m.length - 1);
            int col = Randomizer.uno(0, m[0].length - 1);
            Pregunta.perdiste(m, fila, col);

            if ((m[fila][col] != '*') || (m[fila][col] != '#')) {
                m[fila][col] = '#';
            }
        }
        Variables.setNumDemonios(4 * veces); */
    }

    /**
     * salidaDemonios(char[][] m) hace que salgan los demonios en su pocicion
     * inicial del lado derecho de la matriz. Incrementa la variable
     * (numDemonios) para la impresion en pantalla.
     *
     * @param m m es la matriz del tablero.
     */
    public static void salidaDemonios(char[][] m) {

        for (int i = 0; i < 4; i++) {
            int fila = Randomizer.uno(1, m.length - 1);
            if ((m[fila][m[i].length - 1] != '#')) {
                m[fila][m[i].length - 1] = '#';
            } else {
                i -= 1;
            }
        }
        Variables.setNumDemonios(4);
    }

}
