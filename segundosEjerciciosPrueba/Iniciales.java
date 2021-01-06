/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itla.waldo.proyecto.segundosEjerciciosPrueba;

import java.util.Scanner;
/**
 *
 * @author Waldo Milanes
 * @version 1.0
 * @serial ejercicio 1, segundos ejercicios, cuarta fase
 */
public class Iniciales {
    private String nombre = "";
    private String apellido = "";
//  Constructores

    public Iniciales() {
    }
    public Iniciales(String n, String a) {
        nombre = n;
        apellido = a;
    }
    
    
//  setters and getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Este metodo devolvera las iniciales del nombre y el apellido mas
     * @return devuelve un String
     */
    public String initials(){
       char n[],a[];
       String s = "";
       n = nombre.toCharArray();
       a = apellido.toCharArray();    
       s = ""+n[0]+ a[0]+".";
       return s.toUpperCase();
    }
    /**
     * input este metodo recibe por el teclado el nombre y el apellido para ser
     * procesado
     */
    public void inputNames(){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Escriba su nombre");
        setNombre(input.nextLine());
        System.out.println("Escriba su apellido");
        setApellido(input.nextLine());
    }
    /**
     * Este metodo sobreescribe el metodo toString
     * @return devuelve un String
     */
    @Override
    public String toString(){
        String s = "";
        s = "Su nombre es: " + getNombre()+" "+ getApellido()+"\n"
                +"Sus iniciales son: "+ initials();
        return s;
    }
}
