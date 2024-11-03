import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            Concesionario nuevoConcesionario = new Concesionario(tamanyoMaximo);
            grupo.put(nombreSede, nuevoConcesionario);
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
                System.out.println("-------------------------------------------------------------------------------------");
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
                System.out.println("-------------------------------------------------------------------------------------");
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
                System.out.println("-------------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("No se encontró la sede especificada.");
        }
    }

    public static void cargarDatosIniciales(Empresa empresa) {
        Random random = new Random();
        String[] marcas = {"Toyota", "Audi", "Ford", "BMW", "Honda"};
        String[] modelos = {"Auris", "A3", "Focus", "X5", "Civic"};
        String[] matrículas = {"2465JHN", "4386TGH", "1234ABC", "5678DEF", "9876XYZ"};
        int[] años = {2019, 2020, 2021, 2022, 2023};
        double[] precios = {12000, 16000, 20000, 18000, 15000};
        int[] kms = {50000, 60000, 70000, 80000, 90000};

        empresa.crearSede(new Scanner(System.in));
        empresa.crearSede(new Scanner(System.in));
        empresa.crearSede(new Scanner(System.in));

        for (Map.Entry<String, Concesionario> entry : empresa.grupo.entrySet()) {
            Concesionario concesionario = entry.getValue();
            for (int i = 0; i < 5; i++) {
                String marca = marcas[random.nextInt(marcas.length)];
                String modelo = modelos[random.nextInt(modelos.length)];
                String matricula = matrículas[random.nextInt(matrículas.length)];
                int año = años[random.nextInt(años.length)];
                double precio = precios[random.nextInt(precios.length)];
                int km = kms[random.nextInt(kms.length)];
                concesionario.adquirirCoche(new Coche(marca, modelo, matricula, año, precio, km));
            }
        }
    }
}
