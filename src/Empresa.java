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
}