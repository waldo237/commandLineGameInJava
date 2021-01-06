
package edu.itla.waldo.proyecto.segundosEjerciciosPrueba;

import java.util.Scanner;

/**
 * Crear una clase donde dado un string de palabras sustituir cada ocurrencia de
 * un caracter dado por otro caracter. (por ejemplo: todas las s por *)
 * @author Waldo Milanes
 * @version 1.0
 * @serial ejercicio 2, segundos ejercicios, cuarta fase
 */
public class Sustitucion {
    private String content;
    private char character;
    private char charSustituido;
//  Constructores
    public Sustitucion(String content, char character, char charSustituido) {
        this.content = content;
        this.character = character;
        this.charSustituido = charSustituido;
    }
    
    public Sustitucion() {
    }
// Setters and getters

    public char getCharSustituido() {
        return charSustituido;
    }

    public void setCharSustituido(char charSustituido) {
        this.charSustituido = charSustituido;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
    /**
     * Este metodo lee el contenido sobre el cual se desea hacer la sustitucion
     * y el caracter que se quiere sustituir
     */
    public void inputs() {
        Scanner input = new Scanner(System.in);
        Scanner inputC = new Scanner(System.in);
        System.out.println("Introduzca una cadena de caracteres. Ejemplo, una oracion,etc.:");
        setContent(inputC.nextLine());
        System.out.println("\n"+"Escriba el character que quiere sustituir");
        setCharSustituido(input.next().charAt(0));
        System.out.println("\n"+"Escriba el nuevo character que tomara su lugar."+"\n");
        setCharacter(input.next().charAt(0)); 
    }
    /**
     * Este metodo cambia el character especificado por el deseado
     * @return devuelve un array de characteres
     */
    public String sustituir(){
        char nuevoContent[] = new char[content.length()];
        for(int i = 0;i < nuevoContent.length; i++){
            nuevoContent[i] = content.charAt(i);
            if(nuevoContent[i] == charSustituido){
               nuevoContent[i] = character;
            }   
        }
        String s = new String(nuevoContent);
        return s;
    }
    @Override
    /**
     * Este metodo sobre escribe el metodo to String
     */
    public String toString(){
        String s = "";
        s = "El character que decidio sustituir fue "+ getCharSustituido()+" que fue sustituido por: "+ getCharacter()+"\n"
                +"Aqui esta su nuevo texto: "+"\n"+ sustituir();
        return s;
    }
}
