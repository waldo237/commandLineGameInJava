
package edu.itla.waldo.proyecto;

import java.io.IOException;

/**
 * Esta clase contiene metodos relacionados con la pantalla del juego The At
 * Dungeon by Edwin Quijada
 * @author Waldo Milanes
 * @version 2.0
 */
class Pantalla {

       /**
     * print () Este metodo Recibe un tablero y lo imprime en pantalla.
     *
     * @param m m es un una matriz con el tamaño del tablero.
     */
    public static void print(char[][] m) throws IOException, InterruptedException {

        if (Variables.isDead()) {
            Escoba.clearScreen();
            Pantalla.gameOver(m);
        } else if (Variables.isGanaste()) {
            Escoba.clearScreen();
            Pantalla.celebracion(m);
        } else {
            Escoba.clearScreen();
            System.out.println(Pantalla.informacion());

            for (int i = 0; i < m.length; i++) {

                for (int j = 0; j < m[i].length; j++) {
                    System.out.print("");
                    System.out.print(m[i][j]);
                }
                System.out.print("");
                System.out.print("\n");
            }
        }
    }
      /**
     * Este metodo borra los demonios y deja el avatar en su pocicion original
     *
     * @param m
     */
    public static void resetear(char[][] m) {
        for (char[] m1 : m) {
            for (int j = 0; j < m1.length; j++) {
                if (m1[j] == '@') {
                    m1[j] = '@';
                }else if (m1[j] == '&'){
                    m1[j] = '&';
                }
                else {
                    m1[j] = '.';
                }
            }
        }
        Pantalla.fillParedes(m);
    }

    //    metodos de accion
    /**
     * Este metodo crea las paredes (*) y las hace diez porciento del tablero
     *
     * @param m m es una matriz que contiene el tablero
     */
    public static void fillParedes(char[][] m) {
        int fila = 0, col = 0;
        int porciento = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length * 0.10; j++) {
                fila = Randomizer.uno(0, m.length - 1);
                col = Randomizer.uno(0, m[i].length - 1);
                if ((m[fila][col] == '*') || (m[fila][col] == '@'|| (m[fila][col] == '#'))) {
                    j -= 1;
                } else {
                    m[fila][col] = '*';
                    porciento += 1;

                }
            }
        }
        Variables.setCantPared(porciento);
    }

    /**
     * fillPuntos() este metodo llena el tablero de puntos en las pociciones que
     * vacias.
     *
     * @param m m es una matriz
     */
    public static void fillPuntos(char[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                char mat = m[i][j];
                if (mat == '*' || mat == '#' || mat == '@') {

                } else {
                    m[i][j] = '.';
                }

            }

        }
    }
     /**
     * celebracion(char[][]m) es un metodo que sera invocado por print para
     * imprimir la celebracion si se ha ganado
     *
     * @param m m esta es la matriz del tablero
     */
    private static void celebracion(char[][] m) {
        String g = "";
        g = "FELICIDADES HAS GANADO       ";
        char o;
        int index = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (index == g.length()) {
                    index = 0;
                } else {
                    o = g.charAt(index);
                    index += 1;
                    m[i][j] = o;
                }
                System.out.print(m[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("LLEGASTE A LA META CON "+Variables.getPasos()+" MOVIMIENTOS."+
                    "\n ERES UN VERDADERO CAMPEON!!");
        System.exit(0);
    }

    /**
     * gameOver(char[][]m) es un metodo que sera invocado por print para
     * imprimir la lamentacion si se ha perdido
     *
     * @param m m esta es la matriz del tablero
     */
    private static void gameOver(char[][] m) {
        String g = "";
        g = "GAME OVER";
        char o;
        int index = 0;
        System.out.println(g);
        if(Variables.isAplastado()){
            System.out.println("\t"+"\t"+"Tu haz sido aplastado por un demonio");
        } else if (Variables.isAdyacente()){
            System.out.println("\t"+"\t"+"Cayo un demonio adjacente a ti.");
        }
       char rotuloGO[] = new char[m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (index == g.length()) {
                    index = 0;
                } else {
                    o = g.charAt(index);
                    index += 1;
                    rotuloGO[j] = o;
                }
                
                System.out.print(m[i][j]);
            }
            System.out.print(rotuloGO[i]);
            System.out.print("\n");
            
            
        }
        System.out.print("Solo pudiste dar "+Variables.getPasos()+" pasos."+
                    "\n Intentalo una vez mas. TU PUEDES!!");
        System.exit(0);
    }
 /**
     * Este es un metodo privado que crea un string con informacion sobre el
     * juego para ser invocado por el metodo print.
     *
     * @return retorna un String con la informacion general
     */
    private static String informacion() {
        int numDemonios,  pasos, cantPared;
        numDemonios = Variables.getNumDemonios();  
        pasos = Variables.getPasos(); 
        cantPared = Variables.getCantPared();
        String s = "";
        s = "Numero de monstruos:" + numDemonios + "\t" + " Cantidad de paredes:" + cantPared
                + "\t" + "Cantidad de pasos dados: " + pasos;
        return s;
    }
}
