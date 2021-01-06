

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itla.waldo.proyecto.segundosEjerciciosPrueba;

/**
 *
 * @author Programacion
 */
public class EstudianteReserva {
    private String carnet;
    private int hora;

    public EstudianteReserva() {
    }

    
    public EstudianteReserva(String carnet, int hora) {
        this.carnet = carnet;
        this.hora = hora;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

   
    
    
}

