import java.util.HashMap;
import java.util.Map;

public class Empresa {
    private String nombre;
    private double facturacionEmpresa;
    private Map<String, Concesionario> grupo;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.facturacionEmpresa = 0;
        this.grupo = new HashMap<>();
    }
 // con dudas;
    public void crearSede(String nombreSede, int tamanyoMaximo) {
        if (!grupo.containsKey(nombreSede)) {
            Concesionario nuevoConcesionario = new Concesionario(tamanyoMaximo);
            grupo.put(nombreSede, nuevoConcesionario);
            System.out.println("Sede " + nombreSede + " creada con éxito.");
        } else {
            System.out.println("La sede " + nombreSede + " ya existe.");
        }
    }

    public void facturacionTotal() {
        double total = 0;
        for (Concesionario concesionario : grupo.values()) {
            total += concesionario.getFacturacionLocal();
        }
        this.facturacionEmpresa = total;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFacturacionEmpresa() {
        return facturacionEmpresa;
    }

    public Map<String, Concesionario> getGrupo() {
        return grupo;
    }
}
