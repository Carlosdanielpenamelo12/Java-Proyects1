import java.util.*;

public class Hangman{
    private static final int MAX_INTENTOS = 6;
    private static final String PALABRA_SECRETA = "programacion";
    private static final String SALIR = "salir";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] palabraOculta = new char[PALABRA_SECRETA.length()];
        Arrays.fill(palabraOculta, '_');
        int intentos = 0;
        Set<Character> letrasIncorrectas = new HashSet<>();

        while (intentos < MAX_INTENTOS) {
            System.out.println("\nPalabra: " + new String(palabraOculta));
            System.out.println("Letras incorrectas: " + letrasIncorrectas);
            System.out.println("Intentos restantes: " + (MAX_INTENTOS - intentos));
            System.out.print("Adivina una letra, o escribe '" + SALIR + "' para salir: ");
            String entrada = scanner.nextLine().toLowerCase();

            if (entrada.equals(SALIR)) {
                System.out.println("Saliendo del juego...");
                break;
            }

            if (entrada.length() == 1 && Character.isLetter(entrada.charAt(0))) {
                char letra = entrada.charAt(0);

                if (PALABRA_SECRETA.indexOf(letra) >= 0) {
                    actualizarPalabraOculta(palabraOculta, letra);
                } else {
                    if (letrasIncorrectas.add(letra)) {
                        intentos++;
                    }
                }
            } else {
                System.out.println("Entrada inválida. Por favor, introduce solo una letra.");
            }

            if (esPalabraCompleta(palabraOculta)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + PALABRA_SECRETA);
                break;
            }
        }

        if (!esPalabraCompleta(palabraOculta)) {
            System.out.println("Has perdido. La palabra era: " + PALABRA_SECRETA);
        }

        scanner.close();
    }

    private static void actualizarPalabraOculta(char[] palabraOculta, char letra) {
        for (int i = 0; i < PALABRA_SECRETA.length(); i++) {
            if (PALABRA_SECRETA.charAt(i) == letra) {
                palabraOculta[i] = letra;
            }
        }
    }

    private static boolean esPalabraCompleta(char[] palabraOculta) {
        for (char letra : palabraOculta) {
            if (letra == '_') {
                return false;
            }
        }
        return true;
    }
}
