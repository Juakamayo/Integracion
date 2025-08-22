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
        System.out.println("Respuesta:");
        int respuesta = in.nextInt();

        return respuesta;
    }


    public static void ejecutarOpcion(int opcion, Scanner in) {

        if (opcion == 1) {
            System.out.println("Vamos alla");
            iniciarRonda(in);
        } else {
            System.exit(0);
        }

    }

    public static void iniciarRonda(Scanner in) {}


    public static String leerTipoApuesta(Scanner in) {
        return " ";
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