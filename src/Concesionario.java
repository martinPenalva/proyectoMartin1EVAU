import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private final int tamanyo;
    private double facturacionLocal;
    private List<Coche> listadoCoches;

    public Concesionario(int tamanyo) {
        this.tamanyo = tamanyo;
        this.facturacionLocal = 0;
        this.listadoCoches = new ArrayList<>(tamanyo);
    }

    public void adquirirCoche(Coche coche) {
        if (listadoCoches.size() < tamanyo) {
            listadoCoches.add(coche);
            System.out.println("Coche adquirido y añadido al concesionario.");
        } else {
            System.out.println("Concesionario lleno, no se puede introducir el coche.");
        }
    }
   //modificar bucle
    public void venderCoche(String matricula) {
        Coche cocheAVender = null;
        for (Coche coche : listadoCoches) {
            if (coche.getMatricula().equals(matricula)) {
                cocheAVender = coche;
                break;
            }
        }

        if (cocheAVender != null) {
            listadoCoches.remove(cocheAVender);
            facturacionLocal += cocheAVender.getPrecio();
            System.out.println("Coche con matrícula " + matricula + " vendido por " + cocheAVender.getPrecio());
        } else {
            System.out.println("No se encontró un coche con la matrícula: " + matricula);
        }
    }

    public double getFacturacionLocal() {
        return facturacionLocal;
    }

}
