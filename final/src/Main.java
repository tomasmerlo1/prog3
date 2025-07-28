import juego.Batalla;
import juego.Jugador;

import util.LogManager;
import util.PersonajeFactory;

import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            System.out.println("\nBIENVENIDO A LA BATALLA DEL TRONO DE HIERRO");
            System.out.println("1. Iniciar partida (personajes aleatorios)");
            System.out.println("2. Iniciar partida (personajes manuales)");
            System.out.println("3. Ver logs de partidas anteriores");
            System.out.println("4. Borrar logs");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> iniciarPartidaAleatoria(sc);
                case "2" -> iniciarPartidaManual(sc);
                case "3" -> LogManager.leerLog();
                case "4" -> LogManager.borrarLog();
                case "5" -> {
                    seguir = false;
                    System.out.println("Hasta la próxima batalla!");
                }
                default -> System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }

    private static void iniciarPartidaAleatoria(Scanner sc) {
        Jugador j1 = new Jugador("Jugador 1");
        Jugador j2 = new Jugador("Jugador 2");

        for (int i = 0; i < 3; i++) {
            j1.agregarPersonaje(PersonajeFactory.generarAleatorio());
            j2.agregarPersonaje(PersonajeFactory.generarAleatorio());
        }

        System.out.println("\nPersonajes generados aleatoriamente.\n");


        j1.mostrarEstadoPersonajes();


        Batalla batalla = new Batalla(j1, j2);
        batalla.iniciar();


        List<String> log = batalla.getLog();
        System.out.println("\n===== LOG DE BATALLA =====");
        for (String linea : log) {
            System.out.println(linea);
        }


        LogManager.guardarLog(log);
    }


    private static void iniciarPartidaManual(Scanner sc) {
        Jugador j1 = new Jugador("Jugador 1");
        Jugador j2 = new Jugador("Jugador 2");

        System.out.println("\nJugador 1 - Crear 3 personajes:");
        for (int i = 0; i < 3; i++) {
            j1.agregarPersonaje(PersonajeFactory.generarManual(sc));
        }

        System.out.println("\nJugador 2 - Crear 3 personajes:");
        for (int i = 0; i < 3; i++) {
            j2.agregarPersonaje(PersonajeFactory.generarManual(sc));
        }

        System.out.println("Personajes ingresados manualmente.");
        j1.mostrarEstadoPersonajes();
        j2.mostrarEstadoPersonajes();

        Batalla batalla = new Batalla(j1, j2);
        batalla.iniciar();
        LogManager.guardarLog(batalla.getLog());
    }
}
