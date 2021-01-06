
package edu.itla.waldo.proyecto;
/**
 * Esta clase contiene las variables necesarias para el juego The At
 * Dungeon by Edwin Quijada
 * @author Waldo Milanes
 * @version 2.0
 */
public class Variables {
    private static int multiplica = 1;
    private static int numDemonios = 0;
    private static int cantPared = 0;
    private static int pasos = 0;
    private static int aumen = 0;
    private static boolean dead = false;
    private static boolean ganaste = false;
    private static boolean aplastado = false;
    private static boolean adyacente = false;
    public static boolean isAplastado() {
        return aplastado;
    }

    public static void setAplastado(boolean aplastado) {
        Variables.aplastado = aplastado;
    }

    public static boolean isAdyacente() {
        return adyacente;
    }

    public static void setAdyacente(boolean adyacente) {
        Variables.adyacente = adyacente;
    }
    

    public static int getMultiplica() {
        return multiplica;
    }

    public static void setMultiplica(int multiplica) {
        Variables.multiplica = multiplica;
    }

    public static int getNumDemonios() {
        return numDemonios;
    }

    public static void setNumDemonios(int numDemonios) {
        Variables.numDemonios = numDemonios;
    }

    public static int getCantPared() {
        return cantPared;
    }

    public static void setCantPared(int cantPared) {
        Variables.cantPared = cantPared;
    }

    public static int getPasos() {
        return pasos;
    }

    public static void setPasos(int pasos) {
        Variables.pasos = pasos;
    }

    public static int getAumen() {
        return aumen;
    }

    public static void setAumen(int aumen) {
        Variables.aumen = aumen;
    }

    public static boolean isDead() {
        return dead;
    }

    public static void setDead(boolean dead) {
        Variables.dead = dead;
    }

    public static boolean isGanaste() {
        return ganaste;
    }

    public static void setGanaste(boolean ganaste) {
        Variables.ganaste = ganaste;
    }
}
