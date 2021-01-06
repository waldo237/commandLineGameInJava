

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itla.waldo.proyecto.segundosEjerciciosPrueba;
import java.util.Scanner;

/**
 *
 * @author Programacion
 */
public class RunReserva {
    
    public static void main(String[] args) {
        Reservacion reserva = new Reservacion();
        EstudianteReserva temp;
        Scanner teclado = new Scanner(System.in);
        String c; int hora,dia;
        
        for (int i =0;i<5;i++)
        {        
            temp = new EstudianteReserva();      
            System.out.print("Digite hora:");     hora = teclado.nextInt();
            System.out.print("Digite el dia:");   dia =  teclado.nextInt();
            System.out.print("Digite el carnet:");c=teclado.nextLine();
            teclado.reset();
            
            temp.setCarnet(c);
            temp.setHora(hora);
            //
            if (reserva.agregarReserva(temp, dia)==false)
            {
                System.out.println("Lo sentimos en ese dia no se puede reservar");
            }
        }
        
    }
}