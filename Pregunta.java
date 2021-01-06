
package edu.itla.waldo.proyecto;

import java.io.IOException;

/**
 * Esta clase contiene metodos relacionados con procedimientos de decision
 * del juego The AtDungeon by Edwin Quijada
 * @author Waldo Milanes
 * @version 2.0
 */
public class Pregunta {
    /**
     * Este metodo evalua si has llegado a la meta, de ser asi, cambia la
     * variable ganaste a true.
     *
     * @param m m esta es la matriz del tablero
     */
    public static void hazGanado(char[][] m) {
        int numj = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == '@') {
                    numj = j;
                    if (numj == m[0].length - 1) {
                        Variables.setGanaste(true);
                    }
                }
            }
        }
    }
     /**
     * preguntaPerdiste(char[][] m, int fila, int col)Es un metodo privado
     * llamado por el metodo multiplicaDemonios(m, veces). Este metodo matara el
     * avatar si el demonio generado aleatoriamente le cae encima y si los
     * demonios caen adjacentes a el.
     * @param m m esta es la matriz del tablero
     * @param fila fila es un numero aleatorio generado en el metodo
     * multiplicaDemonios(m, veces);
     * @param col col es un numero aleatorio generado en el metodo
     * multiplicaDemonios(m, veces);
     */
       public static void perdiste(char[][] m, int fila, int col) throws IOException, InterruptedException {
//        si los demonios te caen encima
        if (m[fila][col] == '@') {
            m[fila][col] = '&';
            Variables.setDead(true);
            Variables.setAplastado(true);   
            Pantalla.print(m);
            
        }
//        si los demonios caen adyacentes
        try {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == '@') {
                    if ((m[i-1][j] == '#') || (m[i+1][j] == '#') || (m[i][j-1] == '#') || (m[i][j+1] == '#')&&
                       (m[i-1][j+1] == '#') || (m[i+1][j-1] == '#') || (m[i-1][j - 1] == '#') || (m[i+1][j+1] == '#')) {
//                       ESTA EVALUACION SE SALE DEL ARRAY PORQUE ESTA HECHA EN BASE A @. ENCONTRAR OTRO RANGO.
                        Pantalla.print(m);
                        Variables.setDead(true);
                        Variables.setAdyacente(true);
                        
                    }
                }
            }
        }
    } catch (Exception e) {
        }
}
}
