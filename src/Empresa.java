import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private double facturacionEmpresa;
    private Map<String, Concesionario> grupo;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.facturacionEmpresa = 0;
        this.grupo = new HashMap<>();
    }

    public void crearSede(Scanner scanner) {
        System.out.print("Introduzca el nombre de la nueva sede: ");
        String nombreSede = scanner.nextLine();
        System.out.print("Introduzca el tamaño máximo de coches: ");
        int tamanyoMaximo = scanner.nextInt();
        scanner.nextLine();

        if (!grupo.containsKey(nombreSede)) {
            grupo.put(nombreSede, new Concesionario(tamanyoMaximo));
            System.out.println("Sede " + nombreSede + " creada con éxito.");
        } else {
            System.out.println("La sede " + nombreSede + " ya existe.");
        }
    }

    public void crearSede(String nombreSede, int tamanyoMaximo) {
        if (!grupo.containsKey(nombreSede)) {
            grupo.put(nombreSede, new Concesionario(tamanyoMaximo));
            System.out.println("Sede " + nombreSede + " creada con éxito.");
        } else {
            System.out.println("La sede " + nombreSede + " ya existe.");
        }
    }

    public void introducirCoche(Scanner scanner) {
        System.out.print("Introduzca los datos del vehículo:\nMarca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Año: ");
        int anyo = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Kms: ");
        int kms = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduzca la sede en la que creará el vehículo: ");
        String sede = scanner.nextLine();
        Concesionario concesionario = grupo.get(sede);
        if (concesionario != null) {
            concesionario.adquirirCoche(new Coche(marca, modelo, matricula, anyo, precio, kms));
        } else {
            System.out.println("No se encontró la sede especificada.");
        }
    }

    public void venderCoche(Scanner scanner) {
        System.out.print("Introduzca la matrícula del coche a vender: ");
        String matricula = scanner.nextLine();
        System.out.print("Introduzca la sede en la que se realizó la venta: ");
        String sede = scanner.nextLine();

        Concesionario concesionario = grupo.get(sede);
        if (concesionario != null) {
            concesionario.venderCoche(matricula);
        } else {
            System.out.println("No se encontró la sede especificada.");
        }
    }

    public void buscarCochesPorMarca(Scanner scanner) {
        System.out.print("Introduzca la marca a buscar: ");
        String marca = scanner.nextLine();

        for (Map.Entry<String, Concesionario> entry : grupo.entrySet()) {
            String nombreSede = entry.getKey();
            Concesionario concesionario = entry.getValue();
            List<Coche> cochesEncontrados = new ArrayList<>();

            for (Coche coche : concesionario.getListadoCoches()) {
                if (coche.getMarca().equalsIgnoreCase(marca)) {
                    cochesEncontrados.add(coche);
                }
            }

            System.out.println("******************************************");
            System.out.println("Resultados para la marca: " + marca + " en la sede " + nombreSede + ":");
            System.out.println(cochesEncontrados.size() + " coincidencias en " + nombreSede + ":");
            for (Coche coche : cochesEncontrados) {
                System.out.println(coche);
            }
        }
    }

    public void buscarCochesPorModelo(Scanner scanner) {
        System.out.print("Introduzca el modelo a buscar: ");
        String modelo = scanner.nextLine();

        for (Map.Entry<String, Concesionario> entry : grupo.entrySet()) {
            String nombreSede = entry.getKey();
            Concesionario concesionario = entry.getValue();
            List<Coche> cochesEncontrados = new ArrayList<>();

            for (Coche coche : concesionario.getListadoCoches()) {
                if (coche.getModelo().equalsIgnoreCase(modelo)) {
                    cochesEncontrados.add(coche);
                }
            }

            System.out.println("******************************************");
            System.out.println("Resultados para el modelo: " + modelo + " en la sede " + nombreSede + ":");
            System.out.println(cochesEncontrados.size() + " coincidencias en " + nombreSede + ":");
            for (Coche coche : cochesEncontrados) {
                System.out.println(coche);
            }
        }
    }

    public void mostrarListadoCochesPorConcesionario(Scanner scanner) {
        System.out.print("Introduzca el nombre del concesionario: ");
        String nombreSede = scanner.nextLine();
        Concesionario concesionario = grupo.get(nombreSede);

        if (concesionario != null) {
            System.out.println("Listado de coches en el concesionario " + nombreSede + ":");
            for (Coche coche : concesionario.getListadoCoches()) {
                System.out.println(coche);
            }
        } else {
            System.out.println("No se encontró la sede especificada.");
        }
    }

    public Concesionario getConcesionario(String nombreSede) {
        return grupo.get(nombreSede);
    }

    public void calcularFacturacionTotal() {
        facturacionEmpresa = 0;
        for (Concesionario concesionario : grupo.values()) {
            facturacionEmpresa += concesionario.getFacturacionLocal();
        }
        System.out.println("La facturación total de la empresa es: " + facturacionEmpresa);
    }

    public static void cargarDatosIniciales(Empresa empresa) {
        empresa.crearSede("Madrid", 7);
        empresa.crearSede("Barcelona", 6);
        empresa.crearSede("Valencia", 8);

        empresa.getConcesionario("Madrid").adquirirCoche(new Coche("Toyota", "Corolla", "1234ABC", 2015, 12000, 80000));
        empresa.getConcesionario("Madrid").adquirirCoche(new Coche("Honda", "Civic", "5678DEF", 2018, 14000, 60000));
        empresa.getConcesionario("Barcelona").adquirirCoche(new Coche("Ford", "Fiesta", "4321GHI", 2017, 10000, 50000));
        empresa.getConcesionario("Barcelona").adquirirCoche(new Coche("BMW", "Serie 3", "8765JKL", 2020, 25000, 30000));
        empresa.getConcesionario("Valencia").adquirirCoche(new Coche("Audi", "A4", "1122MNO", 2016, 22000, 70000));
        empresa.getConcesionario("Valencia").adquirirCoche(new Coche("Mercedes", "Clase C", "3344PQR", 2019, 27000, 45000));

        System.out.println("Datos iniciales cargados correctamente.");
    }
}
