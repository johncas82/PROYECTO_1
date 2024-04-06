import java.util.Scanner;

// Clase principal que contiene el método main
public class MatriculaEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrando el menú de carreras
        System.out.println("-----------------------------------");
        System.out.println("Seleccione la carrera:");
        System.out.println("1. Ingeniería de Sistemas");
        System.out.println("2. Administración de Empresas");
        System.out.println("3. Derecho");
        System.out.print("Ingrese el número de la carrera: ");
        int opcionCarrera = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Crear un objeto de la clase correspondiente a la carrera seleccionada
        Carrera carrera;
        switch (opcionCarrera) {
            case 1:
                carrera = new IngenieriaDeSistemas();
                break;
            case 2:
                carrera = new AdministracionDeEmpresas();
                break;
            case 3:
                carrera = new Derecho();
                break;
            default:
                System.out.println("Opción de carrera no válida. Saliendo del programa.");
                scanner.close();
                return;
        }

        // Pedir los datos del estudiante
        System.out.println("-----------------------------------");
        System.out.println("Ingrese los datos del estudiante:");
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        // Crear un objeto Estudiante con los datos ingresados
        Estudiante estudiante = new Estudiante(nombres, apellidos, documento, direccion, telefono);

        // Pedir los datos del semestre
        System.out.println("-----------------------------------");
        System.out.println("Ingrese los datos del semestre:");
        System.out.print("Número de semestre: ");
        int semestre = scanner.nextInt();
        scanner.nextLine();
        boolean cursoEnLina = false;
        System.out.print("Realiza su curso en línea? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            cursoEnLina = true;
        }
        System.out.print("Cantidad de materias perdidas: ");
        int materiasPerdidas = scanner.nextInt();
        scanner.nextLine();

        // Calcular y mostrar el recibo de matrícula
        carrera.calcularMatricula(estudiante, semestre, cursoEnLina, materiasPerdidas);

        scanner.close();
    }
}

// Clase para representar a un estudiante
class Estudiante {
    private String nombres;
    private String apellidos;
    private String documento;
    private String direccion;
    private String telefono;

    // Constructor
    public Estudiante(String nombres, String apellidos, String documento, String direccion, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters
    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
}

// Clase abstracta para representar una carrera
abstract class Carrera {
    // Método abstracto para calcular la matrícula
    public abstract void calcularMatricula(Estudiante estudiante, int semestre, boolean cursoEnLinea,
            int materiasPerdidas);

    public double calcularCostoMaterias(int semestre) {
        if (semestre <= 3) {
            return 20.0; // $20 por crédito
        } else if (semestre <= 6) {
            return 25.0; // $25 por crédito
        } else {
            return 30.0; // $30 por crédito
        }
    }
};

// Clase para representar la carrera de Ingeniería de Sistemas
class IngenieriaDeSistemas extends Carrera {
    @Override
    public void calcularMatricula(Estudiante estudiantee, int semestre, boolean cursoEnLinea, int materiasPerdidas) {
        double costoMatricula = 1500.0; // Precio base

        if (cursoEnLinea) {
            if (semestre >= 5) {
                costoMatricula *= 1.05;
            }

            System.out.println(
                    "R=/ Matrícula calculada para Ingeniería de Sistemas con curso en línea es: $" + costoMatricula);
        } else {
            costoMatricula += calcularCostoMaterias(semestre) * materiasPerdidas;
            System.out.println(
                    "R=/ Matrícula calculada para Ingeniería de Sistemas sin curso en línea es: $" + costoMatricula);
        }
    }
}

// Clase para representar la carrera de Administración de Empresas
class AdministracionDeEmpresas extends Carrera {
    @Override
    public void calcularMatricula(Estudiante estudiantee, int semestre, boolean cursoEnLinea, int materiasPerdidas) {
        double costoMatricula = 1500.0; // Precio base

        if (cursoEnLinea) {
            if (semestre >= 5) {
                costoMatricula *= 1.05;
            }

            System.out.println("R=/ Matrícula calculada para Administración de Empresas con curso en línea es: $"
                    + costoMatricula);
        } else {
            costoMatricula += calcularCostoMaterias(semestre) * materiasPerdidas;
            System.out.println("R=/ Matrícula calculada para Administración de Empresas sin curso en línea es: $"
                    + costoMatricula);
        }
    }
}

// Clase para representar la carrera de Derecho
class Derecho extends Carrera {
    @Override
    public void calcularMatricula(Estudiante estudiantee, int semestre, boolean cursoEnLinea, int materiasPerdidas) {
        double costoMatricula = 1500.0; // Precio base

        if (cursoEnLinea) {
            if (semestre >= 5) {
                costoMatricula *= 1.05;
            }

            System.out.println("R=/ Matrícula calculada para Derecho con curso en línea es: $" + costoMatricula);
        } else {
            costoMatricula += calcularCostoMaterias(semestre) * materiasPerdidas;
            System.out.println("R=/ Matrícula calculada para Derecho sin curso en línea es: $" + costoMatricula);
        }
    }
}
