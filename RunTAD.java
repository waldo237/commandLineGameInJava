package edu.itla.waldo.proyecto;

import java.io.IOException;

/**
 *
 * @author Waldo Milanes
 */
public class RunTAD {

    public static void main(String[] args) throws IOException, InterruptedException {
        char[][] tablero = new char[15][60];
        TAD tad = new TAD();
        tad.start(tablero);
    }
}
