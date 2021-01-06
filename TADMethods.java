package edu.itla.waldo.proyecto;

import java.util.Scanner;
import java.lang.Math;

/**
 * Esta clase contiene metodos para el juego "The At Dungeon"
 *
 * @author Waldo Milanes
 * @version 1.0
 * @since 12/06/2018
 */
public class TADMethods {

    private static int multiplica = 1;
    private static int numDemonios = 0;
    private static int cantPared = 0;
    private static int pasos = 0;
    private static int aumen = 0;
    private boolean dead = false;
    private boolean ganaste = false;

//    metodos de accion
    /**
     * Este metodo crea las paredes (*) y las hace diez porciento del tablero
     *
     * @param m m es una matriz que contiene el tablero
     */
    public void fillParedes(char[][] m) {
        int fila = 0, col = 0;
        int porciento = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length * 0.10; j++) {
                fila = randomizer(0, m.length - 1);
                col = randomizer(0, m[i].length - 1);
                if ((m[fila][col] == '*') || (m[fila][col] == '@'|| (m[fila][col] == '#'))) {
                    j -= 1;
                } else {
                    m[fila][col] = '*';
                    porciento += 1;

                }
            }
        }
        cantPared = porciento;
    }

    /**
     * fillPuntos() este metodo llena el tablero de puntos en las pociciones que
     * vacias.
     *
     * @param m m es una matriz
     */
    public void fillPuntos(char[][] m) {

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
     * Este metodo privado recibe dos numeros y crea numeros aleatorios entre
     * entre ellos.
     *
     * @param minimo Este parametro es el numero minimo aleatorio
     * @param maximo Este parametro es el numero maximo aleatorio
     */
    private int randomizer(int minimo, int maximo) {
        int num = 0;
        num = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

    /**
     * print () Este metodo Recibe un tablero y lo imprime en pantalla.
     *
     * @param m m es un una matriz con el tamaño del tablero.
     */
    public void print(char[][] m) {
        if (dead) {
            gameOver(m);
        } else if (ganaste) {
            celebracion(m);
        } else {
            System.out.println(informacion());
        }
        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[i].length; j++) {
                System.out.print("|");
                System.out.print(m[i][j]);
            }
            System.out.print("|");
            System.out.print("\n");
        }
    }

    /**
     * El metodo movimiento multiplica el numero de demonios cada vez que es
     * efectuado e imprime una nueva pantalla. Cada vez que se ejecuta aumenta
     * la variable (pasos).
     *
     * @param m es la matriz del tablero
     */
    public void movimiento(char[][] m) {

        if (multiplica == 5) {
            multiplica = 1;
            multiplicaDemonios(m, multiplica);
        } else {
            multiplica += 1;
            multiplicaDemonios(m, multiplica);
        }
        pasos += 1;
        this.print(m);
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
    public void input(char[][] m) {
        int joyStick = 0;
        Scanner input = new Scanner(System.in);
        while (!dead || !ganaste) {
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
                this.movimiento(m);

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
                this.movimiento(m);
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
                    preguntaHazGanado(m);
                }
                this.movimiento(m);
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
                this.movimiento(m);
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
                this.movimiento(m);
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
                this.movimiento(m);
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
                    preguntaHazGanado(m);
                }
                this.movimiento(m);
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
                    preguntaHazGanado(m);
                }
                this.movimiento(m);
            }
            if (joyStick == 0) {
                System.exit(0);
            }
        }
    }

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
    private void multiplicaDemonios(char[][] m, int veces) {
        this.resetear(m);
        for (int i = 0; i < 4 * veces; i++) {
            int fila = randomizer(0, m.length - 1);
            int col = randomizer(0, m[0].length - 1);
            preguntaPerdiste(m, fila, col);
            if ((m[fila][col] != '*') || (m[fila][col] != '#')) {
                m[fila][col] = '#';
            }
        }
        numDemonios = 4 * veces;
    }

    /**
     * salidaDemonios(char[][] m) hace que salgan los demonios en su pocicion
     * inicial del lado derecho de la matriz. Incrementa la variable
     * (numDemonios) para la impresion en pantalla.
     *
     * @param m m es la matriz del tablero.
     */
    public void salidaDemonios(char[][] m) {

        for (int i = 0; i < 4; i++) {
            int fila = randomizer(1, m.length -1);
            if ((m[fila][m[i].length - 1] != '#')) {
                m[fila][m[i].length - 1] = '#';
            } else {
                i -= 1;
            }
        }
        numDemonios = 4;
    }

    /**
     * Este metodo borra los demonios y deja el avatar en su pocicion original
     *
     * @param m
     */
    public void resetear(char[][] m) {
        for (char[] m1 : m) {
            for (int j = 0; j < m1.length; j++) {
                if (m1[j] == '@') {
                    m1[j] = '@';
                } else {
                    m1[j] = '.';
                }
            }
        }
        this.fillParedes(m);
    }

    /**
     * Este metodo comienza el juego, llamado asi,todos los elementos del juego.
     *
     * @param tablero tablero es la matriz del tablero requerida para todos los
     * metodos.
     */
    public void start(char[][] tablero) {
        this.salidaDemonios(tablero);
        this.fillParedes(tablero);
        this.fillPuntos(tablero);
        this.avatar(tablero);
        this.print(tablero);
        this.input(tablero);
    }

    /**
     * Este es un metodo privado que crea un string con informacion sobre el
     * juego para ser invocado por el metodo print.
     *
     * @return retorna un String con la informacion general
     */
    private String informacion() {
        String s = "";
        s = "Numero de monstruos:" + numDemonios + "\t" + " Cantidad de paredes:" + cantPared
                + "\t" + "\t" + "Cantidad de pasos dados: " + pasos;
        return s;
    }

    /**
     * avatar(char[][] m) este metodo crea el avatar(@) con el cual se jugara
     *
     * @param m m esta es la matriz del tablero
     */
    private void avatar(char[][] m) {

        int fila = randomizer(1, m.length - 2);
        m[fila][m[0].length - m[0].length] = '@';
    }

    /**
     * Este metodo evalua si has llegado a la meta, de ser asi, cambia la
     * variable ganaste a true.
     *
     * @param m m esta es la matriz del tablero
     */
    private void preguntaHazGanado(char[][] m) {
        int numj = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == '@') {
                    numj = j;
                    if (numj == m[0].length - 1) {
                        ganaste = true;
                    }
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
    private void celebracion(char[][] m) {
        String g = "";
        g = "         FELICIDADES HAS GANADO        ";
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
                System.out.print("");
                System.out.print(m[i][j]);
            }
            System.out.print("");
            System.out.print("\n");
        }
        System.exit(0);
    }

    /**
     * gameOver(char[][]m) es un metodo que sera invocado por print para
     * imprimir la lamentacion si se ha perdido
     *
     * @param m m esta es la matriz del tablero
     */
    private void gameOver(char[][] m) {
        String g = "";
        g = "GAME OVER ";
        char o;
        int index = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (index == g.length()) {
                    index = 0;
                } else {
                    o = g.charAt(index);
                    index += 1;
                    m[0][j] = o;
                }
                System.out.print("!");
                System.out.print(m[i][j]);
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.exit(0);
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
    private void preguntaPerdiste(char[][] m, int fila, int col) {
//        si los demonios te caen encima
        if (m[fila][col] == '@') {
            m[fila][col] = '&';
            this.print(m);
            dead = true;
            System.out.println("\t"+"\t"+"Tu haz sido aplastado por un demonio");
        }
//        si los demonios caen adyacentes
        try {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == '@') {
                    if (m[i - 1][j] == '#' || m[i + 1][j] == '#' || m[i][j - 1] == '#' || m[i][j + 1] == '#') {
//                       ESTA EVALUACION SE SALE DEL ARRAY PORQUE ESTA HECHA EN BASE A @. ENCONTRAR OTRO RANGO.
                        this.print(m);
                        dead = true;
                        System.out.println("\t"+"\t"+"Cayo un demonio adjacente a ti.");
                    }
                }
            }
        }
    } catch (Exception e) {
        
        }
}
}
