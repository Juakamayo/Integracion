import java.util.Random;
import java.util.Scanner;

public class Ruleta {

    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos =
            {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};


    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        mostrarMenu();
        Scanner respuesta = new Scanner(System.in);
        int opcion = leerOpcion(respuesta);
        ejecutarOpcion(opcion, respuesta);


    }


    public static void mostrarMenu() {

        System.out.println("¿Quieres empezar a jugar?: \n");
        System.out.println("1. SI");
        System.out.println("2. NO");

    }


    public static int leerOpcion(Scanner in) {
        int opcion = in.nextInt();
        return opcion;
    }


    public static void ejecutarOpcion(int opcion, Scanner in) {
        switch (opcion) {
            case 1:
                iniciarRonda(in);
            case 2:
                System.out.println("Saliendo");
            default:
                System.out.println("Opcion invalida");
        }
    }

    public static void iniciarRonda(Scanner in) {
        char estilo = leerTipoApuesta(in);
        System.out.print("Monto a apostar: ");
        int monto = in.nextInt();
        in.nextLine();

        int numero = girarRuleta();
        boolean correcto = evaluarResultado(numero, estilo);

        registrarResultado(numero, monto);

    }


    public static String leerTipoApuesta(Scanner in) {

    }

    public static int girarRuleta() {
        return 0;
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        return false;
    }

    public static boolean esRojo(int n) {
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {}

    public static void mostrarResultado(int numero, char tipo, int monto, boolean
            acierto) {}

    public static void mostrarEstadisticas() {}
}