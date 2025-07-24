import personajes.*;
import juego.Batalla;
import juego.Jugador;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tus personajes
        Humano humano = new Humano("Arthas", "El Valiente", "1990-01-01", 35,
                100, 5, 3, 8, 2, 6);
        Orco orco = new Orco("Grom", "El Destructor", "1800-07-22", 120,
                100, 4, 2, 10, 3, 7);

        // Creamos jugadores y asignamos un solo personaje a cada uno
        Jugador jugador1 = new Jugador("Jugador 1");
        jugador1.agregarPersonaje(humano);

        Jugador jugador2 = new Jugador("Jugador 2");
        jugador2.agregarPersonaje(orco);

        // Ejecutamos batalla
        Batalla batalla = new Batalla(jugador1, jugador2);
        batalla.iniciar();

        // Mostramos el log de la batalla
        List<String> log = batalla.getLog();
        System.out.println("\n===== LOG DE BATALLA =====");
        for (String linea : log) {
            System.out.println(linea);
        }
    }
}

