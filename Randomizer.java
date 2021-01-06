
package edu.itla.waldo.proyecto;
/**
 * Esta clase contiene un metodo para crear numeros aleatorios para el juego The At
 * Dungeon by Edwin Quijada
 * @author Waldo Milanes
 * @version 2.0
 */
class Randomizer {
     /**
     * Este metodo recibe dos numeros y crea numeros aleatorios entre
     * entre ellos.
     *
     * @param minimo Este parametro es el numero minimo aleatorio
     * @param maximo Este parametro es el numero maximo aleatorio
     */
    public static int uno(int minimo, int maximo) {
        int num = 0;
        num = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
}
