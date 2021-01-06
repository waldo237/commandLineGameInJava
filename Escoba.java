package edu.itla.waldo.proyecto;

import java.lang.ProcessBuilder;
import java.lang.InterruptedException;
import java.io.IOException;

/**
 * Esta clase contiene metodos relacionados con la pantalla del juego The At
 * Dungeon by Edwin Quijada
 *
 * @author Waldo Milanes
 * @version 2.0
 */
class Escoba {

    public static void clearScreen() throws IOException, InterruptedException {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");

            }
        } catch (IOException e) {
        } catch (InterruptedException e) {
        }
    }
}
