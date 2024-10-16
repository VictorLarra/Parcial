import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Niño {
    
    String nombre;
    int edad;
    int numeroHermanos;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getNumeroHermanos() {
        return numeroHermanos;
    }
    public void setNumeroHermanos(int numeroHermanos) {
        this.numeroHermanos = numeroHermanos;
    }

    public double calcularDescuento(){

        double descuento = 0;
        if(numeroHermanos == 1){
            descuento = 0.15;
        }else if(numeroHermanos == 2){
            descuento = 0.2;
        }else if(numeroHermanos >= 3 && numeroHermanos<=4){
            descuento = 0.25;
        }
        return descuento;
    }

    //Constructor

    public Niño(String nombre, int edad, int numeroHermanos) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroHermanos = numeroHermanos;
    }

  
}

 
  
