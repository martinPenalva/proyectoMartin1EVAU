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
}