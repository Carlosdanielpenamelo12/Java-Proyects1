import java.util.Random;
import java.util.Scanner;

public class JuegoPiedraPapelTijeras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int puntajeJugador = 0;
        int puntajeComputadora = 0;
        String input;

        System.out.println("Escribe 'piedra', 'papel', 'tijeras' para jugar, o 'me rindo' para terminar.");

        while (true) {
            System.out.print("Tu turno: ");
            input = scanner.nextLine().toLowerCase();

            if ("me rindo".equals(input)) {
                break;
            }

            int eleccionJugador = -1;
            switch (input) {
                case "piedra":
                    eleccionJugador = 0;
                    break;
                case "papel":
                    eleccionJugador = 1;
                    break;
                case "tijeras":
                    eleccionJugador = 2;
                    break;
                default:
                    System.out.println("Eso no se puede juga mio");
                    continue;
            }

            int eleccionComputadora = random.nextInt(3);
            System.out.println("La computadora eligio: " + numeroAEleccion(eleccionComputadora));

            if (eleccionJugador == eleccionComputadora) {
                System.out.println("Es un empate");
            } else if ((eleccionJugador == 0 && eleccionComputadora == 2) ||
                       (eleccionJugador == 1 && eleccionComputadora == 0) ||
                       (eleccionJugador == 2 && eleccionComputadora == 1)) {
                System.out.println("Ganaste");
                puntajeJugador++;
            } else {
                System.out.println("Perdiste contra la computadora.");
                puntajeComputadora++;
            }

            System.out.println("Puntuación - Jugador: " + puntajeJugador + " | Computadora: " + puntajeComputadora);
        }

        System.out.println("Puntuación Final - Jugador: " + puntajeJugador + " | Computadora: " + puntajeComputadora);
        System.out.println("Gracias por jugar!");
        scanner.close();
    }

    private static String numeroAEleccion(int numero) {
        switch (numero) {
            case 0: return "piedra";
            case 1: return "papel";
            case 2: return "tijeras";
            default: return "desconocido";
        }
    }
}
