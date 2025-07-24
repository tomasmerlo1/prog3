package juego;

import personajes.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batalla {
    private Jugador jugador1;
    private Jugador jugador2;
    private List<String> log;
    private Random random;
    private boolean jugador1Empieza;

    public Batalla(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.log = new ArrayList<>();
        this.random = new Random();
        this.jugador1Empieza = random.nextBoolean(); // sorteo inicial
    }

    public void iniciar() {
        log.add("----- INICIA LA BATALLA POR EL TRONO -----");
        log.add("Sorteo inicial: empieza atacando " + (jugador1Empieza ? jugador1.getNombre() : jugador2.getNombre()));

        while (jugador1.tienePersonajesVivos() && jugador2.tienePersonajesVivos()) {
            Personaje p1 = jugador1.obtenerPersonajeVivoRandom();
            Personaje p2 = jugador2.obtenerPersonajeVivoRandom();

            if (p1 == null || p2 == null) break; // por seguridad

            log.add("\nNueva ronda: " + p1.getApodo() + " (J1) vs " + p2.getApodo() + " (J2)");

            boolean ganadorFueJugador1 = ejecutarRonda(p1, p2, jugador1Empieza);

            // Cambia el que empieza si perdió
            jugador1Empieza = !ganadorFueJugador1;
        }

        declararGanador();
    }

    private boolean ejecutarRonda(Personaje p1, Personaje p2, boolean turnoJugador1) {
        int ataquesPorJugador = 7;
        int totalTurnos = ataquesPorJugador * 2;
        boolean turno = turnoJugador1;

        for (int i = 0; i < totalTurnos; i++) {
            if (!p1.estaVivo() || !p2.estaVivo()) break;

            if (turno) {
                double danio = p1.calcularDanio(p2);
                p2.recibirDanio(danio);
                log.add(p1.getApodo() + " ataca a " + p2.getApodo() + " y le quita " + (int) danio + " de salud. Salud restante: " + p2.getSalud());
            } else {
                double danio = p2.calcularDanio(p1);
                p1.recibirDanio(danio);
                log.add(p2.getApodo() + " ataca a " + p1.getApodo() + " y le quita " + (int) danio + " de salud. Salud restante: " + p1.getSalud());
            }

            turno = !turno;
        }

        if (!p1.estaVivo() && !p2.estaVivo()) {
            log.add("Ambos personajes murieron en esta ronda!");
            return turnoJugador1; // quien empezó gana el derecho a empezar la próxima
        } else if (!p1.estaVivo()) {
            log.add(p1.getApodo() + " ha muerto. " + p2.getApodo() + " gana la ronda.");
            bonificarGanador(p2);
            return false; // ganó jugador 2
        } else if (!p2.estaVivo()) {
            log.add(p2.getApodo() + " ha muerto. " + p1.getApodo() + " gana la ronda.");
            bonificarGanador(p1);
            return true; // ganó jugador 1
        } else {
            log.add("Nadie murió en esta ronda. Ambos personajes siguen en juego.");
            return turnoJugador1;
        }
    }

    private void bonificarGanador(Personaje p) {
        p.setSalud(Math.min(p.getSalud() + 10, 100)); // máximo 100
        p.setNivel(p.getNivel() + 1);
        log.add(p.getApodo() + " gana 10 de salud y sube a nivel " + p.getNivel());
    }

    private void declararGanador() {
        log.add("\n----- FIN DE LA BATALLA -----");
        if (jugador1.tienePersonajesVivos()) {
            log.add("🎉 " + jugador1.getNombre() + " gana el trono de hierro!");
            jugador1.mostrarEstadoPersonajes();
        } else {
            log.add("🎉 " + jugador2.getNombre() + " gana el trono de hierro!");
            jugador2.mostrarEstadoPersonajes();
        }
    }

    public List<String> getLog() {
        return log;
    }
}
