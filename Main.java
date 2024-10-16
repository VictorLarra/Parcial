import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Main {

    public static double calcularValorMatricula(int edad, int hermanos) {

        double descuento = 0;
        double valorBase = 0;
        if (edad == 1 || edad == 2) {
            valorBase = 4300000;
        } else if (edad == 3 || edad == 4) {
            valorBase = 3900000;
        } else if (edad == 5) {
            valorBase = 3500000;
        }

        if (hermanos == 1) {
            descuento = 0.15;
        } else if (hermanos > 1) {
            descuento = 0.15 + (hermanos - 1) * 0.05;
        }

    }
}

public static void main(String[] args) {
    DecimalFormat formater = new DecimalFormat("###,###.##");

    ArrayList<Nivel> niveles = new ArrayList<>();

    Nivel nivel1 = new Nivel("Nivel 1", 4300000, 1, 2);
    Nivel nivel2 = new Nivel("Nivel 2", 3900000, 3, 4);
    Nivel nivel3 = new Nivel("Nivel 3", 3500000, 5, 5);

    niveles.add(nivel1);
    niveles.add(nivel2);
    niveles.add(nivel3);

    int respuestaAñadirNino = JOptionPane.YES_OPTION;

        while (respuestaAñadirNino == JOptionPane.YES_OPTION) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del niño");
            String edadTxt = JOptionPane.showInputDialog("Ingrese la edad de " + nombre);
     int edad = Integer.parseInt(edadTxt);

            Nivel nivelAplicado = null;
            for (Nivel nivel : niveles) {
                if (edad >= nivel.getEdadMinima() && edad <= nivel.getEdadMaxima()) {
                    nivelAplicado = nivel;
                    break;
                }

            }
            if (nivelAplicado == null) {
                JOptionPane.showMessageDialog(null, "No hay niveles disponibles para la edad de " + edad);
            } else {
                JOptionPane.showMessageDialog(null,
                        nombre + " aplica para el " + nivelAplicado.getNombre() + " con un costo de $"
     + formater.format(nivelAplicado.getMatricula())
                   + (". \nEl costo de la matricula aún no cuenta con los descuentos."));

           int respuestaAceptaNivel = JOptionPane.showConfirmDialog(null,
                        "Desea matricular a " + nombre + " en el nivel de " + nivelAplicado.getNombre() + "?",
                        "Acepta nivel", JOptionPane.YES_NO_OPTION);
                if (respuestaAceptaNivel == JOptionPane.YES_OPTION) {
                    double valorPagar = nivelAplicado.getMatricula();

           Niño nino = new Niño(nombre, edad, 0);
           nivelAplicado.obtenerNinos().add(nino);

         int tieneHermanos = JOptionPane.showConfirmDialog(null,
                       nombre + " tiene hermanos estudiando en el jardin?", "Hermanos",
                       JOptionPane.YES_NO_OPTION);

         if (tieneHermanos == JOptionPane.YES_OPTION) {

                String nmroHermanosTxt = JOptionPane.showInputDialog("Cuántos hermanos de " + nombre + " están estudiando en el jardin?");
                        int nmroHermanos = Integer.parseInt(nmroHermanosTxt);
                  nino.setNumeroHermanos(nmroHermanos);
                    double descuento = (nino.calcularDescuento() * 100);
                        valorPagar = (valorPagar * (1 - nino.calcularDescuento())) + nivelAplicado.VALOR_TRANSPORTE;
    
                JOptionPane.showMessageDialog(null,
                                "El descuento aplicado para  " + nombre + " es de " + descuento
                                        + "%. \nEl total a pagar de matricula + descuentos, y cargo por transporte ($"
                   + formater.format(nivelAplicado.VALOR_TRANSPORTE) + ")  es de: $"
                            
                         + formater.format(valorPagar));
                    } else {
                        valorPagar += nivelAplicado.VALOR_TRANSPORTE;
                       
             JOptionPane.showMessageDialog(null, "Para " + nombre

                                + " no aplica ningún descuento. \nEl total a pagar de matricula más el cargo por transoporte ($"
                                + formater.format(nivelAplicado.VALOR_TRANSPORTE) + ")  es de: $"
                                + formater.format(valorPagar));
                    }
                }
            }
        }}