/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itla.waldo.proyecto.segundosEjerciciosPrueba;

/**
 * Esta es la clas ejecutable de iniciales
 * @author Waldo Milanes
 */
public class RunIniciales {
    
    public static void main (String [] args){
        Iniciales iniciales = new Iniciales();
        iniciales.inputNames();
        iniciales.initials();
        System.out.println(iniciales);
    }
   
}
