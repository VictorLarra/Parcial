import java.util.ArrayList;

public class Nivel{
        String nombre;
        int edadMinima;
        int edadMaxima;
        double matricula;
        ArrayList<Niño> niños = new ArrayList<>();
    
        final double VALOR_TRANSPORTE = 400000;
    
        public Nivel(String nombre, int edadMinima, int edadMaxima, double matricula) {
    
            this.nombre = nombre;
            this.edadMinima = edadMinima;
            this.edadMaxima = edadMaxima;
            this.matricula = matricula;
            this.niños = new ArrayList<>();
    
        }
    
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public int getEdadMinima() {
            return edadMinima;
        }
    
        public void setEdadMinima(int edadMinima) {
            this.edadMinima = edadMinima;
        }
    
        public int getEdadMaxima() {
            return edadMaxima;
        }
    
        public void setEdadMaxima(int edadMaxima) {
            this.edadMaxima = edadMaxima;
        }
    
        public double getMatricula() {
            return matricula;
        }
    
        public void setMatricula(double matricula) {
            this.matricula = matricula;
        }

    
        public ArrayList<Niño> obtenerNinos() {
            return this.niños;
        }
    
    }





   