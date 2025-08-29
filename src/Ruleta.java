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

        Scanner respuesta = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(respuesta);
            ejecutarOpcion(opcion, respuesta);
        } while (opcion != 3);



    }


    public static void mostrarMenu() {

        System.out.println("¿Quieres empezar a jugar?: \n");
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Estadisticas");
        System.out.println("3. Salir");
        System.out.println("Elige una opcion: ");

    }


    public static int leerOpcion(Scanner in) {
        int opcion = in.nextInt();
        return opcion;
    }


    public static void ejecutarOpcion(int opcion, Scanner in) {
        switch (opcion) {
            case 1:
                iniciarRonda(in);
                break;
            case 2:
                mostrarEstadisticas();
                break;
            case 3:
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }

    public static void iniciarRonda(Scanner in) {
        char estilo = leerTipoApuesta(in);
        System.out.print("Monto a apostar: ");
        int monto = in.nextInt();
        in.nextLine();

        int numero = girarRuleta();
        boolean correcto = evaluarResultado(numero, estilo);

        registrarResultado(numero, monto, correcto);
        mostrarResultado(numero, estilo, monto, correcto);
    }


    public static char leerTipoApuesta(Scanner in) {
        char estilo;
        do {
            System.out.println("Elige un tipo de apuesta (R/N/P/I): ");
            estilo = Character.toUpperCase(in.next().charAt(0));

        } while (estilo != 'R' && estilo != 'N' && estilo != 'P' && estilo != 'I'); //repasar
        return estilo;
    }

    public static int girarRuleta() {
        return rng.nextInt(37);
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) return false;
        switch (tipo) {
            case 'R':
                return esRojo(numero);
            case 'N':
                return !esRojo(numero);
            case 'P':
                return numero % 2 == 0;
            case 'I':
                return numero % 2 != 0;
            default:
                return false;
        }
    }

    public static boolean esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (rojo == n) return true;
        }
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) { //repasar
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
        }
    }





    public static void mostrarResultado(int numero, char tipo, int monto, boolean
            acierto) {
        System.out.println("Resultado \n");
        System.out.println("Numero conseguido: " + numero);
        System.out.println("Tu apuesta: " + tipo + " por $" + monto);
        if (acierto) {
            System.out.println("Haz ganado +$" + monto);
        } else {
            System.out.println("Acabas de perder -$" + monto);
        }
    }

    public static void mostrarEstadisticas() {

        int totalRondas = historialSize;
        int totalPlata = 0;
        int aciertos = 0;
        int ganancia = 0;

        for (int i = 0; i < historialSize; i++) {
            totalPlata += historialApuestas[i];
            if (historialAciertos[i]) {
                aciertos++;
                ganancia += historialApuestas[i];
            } else {
                ganancia -= historialApuestas[i];
            }
        }

        System.out.println("Estadisticas: \n"); //repasar este resto
        System.out.println("Cantidad de rondas jugadas: "+ totalRondas);
        System.out.println("Total apostado: $" +totalPlata);
        System.out.println("Total aciertos: " + aciertos);
        if (totalRondas > 0) {
            System.out.printf("%% de acierto: %.2f%%\n", (aciertos * 100.0 / totalRondas));
        }
        System.out.println("Ganancia/Perdida neta: $" + ganancia);


    }
}