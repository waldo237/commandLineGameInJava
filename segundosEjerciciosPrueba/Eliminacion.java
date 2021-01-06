
package edu.itla.waldo.proyecto.segundosEjerciciosPrueba;

import java.util.Scanner;

/**
 * Escriba una clase que permita eliminar un substring substr de un string str,
 * si no está devuelve el mismo string sin alterar.
 * @author Waldo Milanes
 * @version 1.0
 * @serial ejercicio 3, segundos ejercicios, cuarta fase
 */
public class Eliminacion {
    private String content = "";
    private String subString = "";
    
//    constructores

    public Eliminacion() {
    }
// setters and getters

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubString() {
        return subString;
    }

    public void setSubString(String subString) {
        this.subString = subString;
    }
    
    /**
     * Este metodo lee el contenido que desea eliminar
     */
    public void inputs() {
        Scanner inputC = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca una cadena de caracteres. Ejemplo, una oracion,etc.:");
        content = inputC.nextLine();
        System.out.println("\n"+"Escriba el Substring que quiere eliminar");
        subString = input.next();
    }
    public String eliminar(){
        String s = content.replace(subString,"");
        return s;
    }
    
    public String toString(){
        String s = "";
        s = "El character que decidio elimilar fue "+ getSubString()+"\n"
                +"Aqui esta su nuevo texto: "+"\n"+ eliminar();
        return s;
    }
}
