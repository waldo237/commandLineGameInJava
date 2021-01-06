
package edu.itla.waldo.proyecto;

import java.io.IOException;
import java.util.Scanner;

/**
 * Esta clase contiene metodos relacionados con el jugador del juego The At
 * Dungeon by Edwin Quijada
 * @author Waldo Milanes
 * @version 2.0
 */
public class Player {
    private static int pasarNum =1;
    private static int pasos =0;
     /**
     * avatar(char[][] m) este metodo crea el avatar(@) con el cual se jugara
     *
     * @param m m esta es la matriz del tablero
     */
    public static void avatar(char[][] m) {
        int fila = Randomizer.uno(1, m.length - 2);
        m[fila][m[0].length - m[0].length] = '@';
    }
      /**
     * El metodo input lee numeros por el teclado y mueve el avatar a la
     * posicion deseada contiene: mover arriba 8, mover abajo 2, mover al frente
     * 6, mover al atras 4, mover al perpendicular izquierdo arriba 7, mover al
     * perpendicular izquierdo abajo 1, mover al perpendicular derecho arriba 9,
     * mover al perpendicular derecho arriba 3. llama al metodo
     * preguntaHazGanado() para confirmar si ganaste.
     *
     * @param m m es la matriz del tablero
     */
    public static void input(char[][] m) throws IOException, InterruptedException {
        int joyStick = 0;
        Scanner input = new Scanner(System.in);
        while (!Variables.isDead() || !Variables.isGanaste()) {
            try {
                joyStick = input.nextInt();
            } catch (Exception e) {
                System.out.print("Solo se pueden introducir numeros");
            }
            

//       mover arriba (8)
            if (joyStick == 8) {
                int numi = 0, numj = 0;
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if (m[i][j] == '@') {
                            numi = i;
                            numj = j;
                        }
                    }
                }
                if (((numi - 1) >= 0) && (m[numi - 1][numj] == '.')) {
                    m[numi][numj] = '.';
                    m[numi - 1][numj] = '@';
                }
                Player.movimiento(m);

            }
//       mover abajo (2)
            if (joyStick == 2) {
                int numi = 0, numj = 0;
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if (m[i][j] == '@') {
                            numi = i;
                            numj = j;
                        }
                    }
                }
                if (((numi + 1) < m.length) && (m[numi + 1][numj] == '.')) {
                    m[numi][numj] = '.';
                    m[numi + 1][numj] = '@';
                }
                Player.movimiento(m);
            }

//       mover al frente (6)
            if (joyStick == 6) {
                int numi = 0, numj = 0;
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if (m[i][j] == '@') {
                            numi = i;
                            numj = j;
                        }
                    }
                }
                if (((numj + 1) < m[0].length) && (m[numi][numj + 1] == '.')) {
                    m[numi][numj] = '.';
                    m[numi][numj + 1] = '@';
                    Pregunta.hazGanado(m);
                }
                Player.movimiento(m);
            }
//       mover al atras (4)
            if (joyStick == 4) {
                int numi = 0, numj = 0;
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if (m[i][j] == '@') {
                            numi = i;
                            numj = j;
                        }
                    }
                }
                if (((numj - 1) >= 0) && (m[numi][numj - 1] == '.')) {
                    m[numi][numj] = '.';
                    m[numi][numj - 1] = '@';
                }
                Player.movimiento(m);
            }
//       mover al perpendicular izquierdo arriba (7)
            if (joyStick == 7) {
                int numi = 0, numj = 0;
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if (m[i][j] == '@') {
                            numi = i;
                            numj = j;
                        }
                    }
                }
                if ((((numj - 1) >= 0) && ((numi - 1) >= 0)) && (m[numi - 1][numj - 1] == '.')) {
                    m[numi][numj] = '.';
                    m[numi - 1][numj - 1] = '@';
                }
                Player.movimiento(m);
            }
//       mover al perpendicular izquierdo abajo (1)
            if (joyStick == 1) {
                int numi = 0, numj = 0;
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if (m[i][j] == '@') {
                            numi = i;
                            numj = j;
                        }
                    }
                }
                if (((numi + 1 < m.length) && ((numj - 1) >= 0)) && (m[numi + 1][numj - 1] == '.')) {
                    m[numi][numj] = '.';
                    m[numi + 1][numj - 1] = '@';
                }
                Player.movimiento(m);
            }
//       mover al perpendicular derecho arriba (9)
            if (joyStick == 9) {
                int numi = 0, numj = 0;
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if (m[i][j] == '@') {
                            numi = i;
                            numj = j;
                        }
                    }
                }
                if ((((numi - 1) >= 0) && (numj + 1) < m[0].length) && (m[numi - 1][numj + 1] == '.')) {
                    m[numi][numj] = '.';
                    m[numi - 1][numj + 1] = '@';
                    Pregunta.hazGanado(m);
                }
                Player.movimiento(m);
            }
//       mover al perpendicular derecho abajo (3)
            if (joyStick == 3) {
                int numi = 0, numj = 0;
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[i].length; j++) {
                        if (m[i][j] == '@') {
                            numi = i;
                            numj = j;
                        }
                    }
                }
                if ((((numi + 1) < m.length) && (numj + 1) < m[0].length) && (m[numi + 1][numj + 1] == '.')) {
                    m[numi][numj] = '.';
                    m[numi + 1][numj + 1] = '@';
                    Pregunta.hazGanado(m);
                }
                Player.movimiento(m);
            }
            if (joyStick == 0) {
                System.exit(0);
            }
        }
    }
 
   /**
     * El metodo movimiento multiplica el numero de demonios cada vez que es
     * efectuado e imprime una nueva pantalla. Cada vez que se ejecuta aumenta
     * la variable (pasos).
     *
     * @param m es la matriz del tablero
     */
    public static void movimiento(char[][] m) throws IOException, InterruptedException {
       
        if (Variables.getMultiplica() == 5) {
            Variables.setMultiplica(1);
            pasarNum = 1;
            Demonios.multiplicaDemonios(m);
        } else {
            pasarNum += 1;
            Variables.setMultiplica(pasarNum);
            Demonios.multiplicaDemonios(m);
        }
        pasos += 1;
        Variables.setPasos(pasos);
        Pantalla.print(m);
    }
}
