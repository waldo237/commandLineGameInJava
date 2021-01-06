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
public class Reservacion {
    private final int DIAS=7;
    private final int RES=6; // cantidad de reservaciones en un dia
    private EstudianteReserva[][] mat;

    public Reservacion() {
        mat = new EstudianteReserva[DIAS][RES];
    }
    
    public int diaReservacion(String carnet) {
        for (int i=0;i<DIAS;i++)
            for (int j=0;j<RES;j++)
            {
                if (mat[i][j].getCarnet().equals(carnet))
                    return i;
            }
        return -1;
    }
    
    public int canEstReserva(int hora) {
        int cantidad=0;
          for (int i=0;i<DIAS;i++)
            for (int j=0;j<RES;j++)
            {
                if ((mat[i][j]!=null) && (mat[i][j].getHora() == hora))
                    cantidad++;
            }
        return cantidad;      
    }
  
    public float promedioReserva(){
        int cantidad=0, k=0;
         for (int i=0;i<DIAS;i++)
            for (int j=0;j<RES;j++)
            {
                if ((mat[i][j]!=null) )
                    cantidad++;
            } 
         return  cantidad/7;
    }
    
    public int promedioReserva(String carnet){
        int cantidad=0;
         for (int i=0;i<DIAS;i++)
            for (int j=0;j<RES;j++)
            {
                if ((mat[i][j]!=null) && (mat[i][j].getCarnet().equals(carnet)) )
                    cantidad++;
            } 
         return  cantidad;
    } 
    
    public boolean agregarReserva(EstudianteReserva ob, int dia)
    {
      
            for (int j=0;j<RES;j++)
            {
                if ((mat[dia][j]==null) )
                {
                  mat[dia][j] = ob; 
                  return true;
                }     
            }
    return false;   
  }

    @Override
    public String toString() {
        String s = "";
      String diaSemana[] = {"Lunes", "Martes", "Miercoles", "Jueves","Viernes","Sabado", "Domingo"};
        for(int i = 0; i<DIAS; i++)
           for(int j = 0; i<RES; j++){
              if(mat[i][j] != null){
                  System.out.println(diaSemana[i]+ "\t"+mat[i][j]+mat[i][j].getHora());
              }
           }
        return "Reservacion{" + "mat=" + mat + '}';
    }
    
    
}


