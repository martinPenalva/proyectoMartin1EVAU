import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa("Mi Empresa de Coches");

        Empresa.cargarDatosIniciales(empresa);

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Crear nueva sede");
            System.out.println("2. Introducir coche en una sede");
            System.out.println("3. Vender coche");
            System.out.println("4. Buscar coches por marca");
            System.out.println("5. Buscar coches por modelo");
            System.out.println("6. Mostrar listado de coches por concesionario");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    empresa.crearSede(scanner);
                    break;
                case 2:
                    empresa.introducirCoche(scanner);
                    break;
                case 3:
                    empresa.venderCoche(scanner);
                    break;
                case 4:
                    empresa.buscarCochesPorMarca(scanner);
                    break;
                case 5:
                    empresa.buscarCochesPorModelo(scanner);
                    break;
                case 6:
                    empresa.mostrarListadoCochesPorConcesionario(scanner);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 7);}}

