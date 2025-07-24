package juego;

import personajes.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jugador {
    private String nombre;
    private List<Personaje> personajes;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.personajes = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public boolean tienePersonajesVivos() {
        return personajes.stream().anyMatch(Personaje::estaVivo);
    }

    public Personaje obtenerPersonajeVivoRandom() {
        List<Personaje> vivos = personajes.stream()
                .filter(Personaje::estaVivo)
                .toList();

        if (vivos.isEmpty()) return null;

        Random random = new Random();
        return vivos.get(random.nextInt(vivos.size()));
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarEstadoPersonajes() {
        System.out.println("----- Personajes de " + nombre + " -----");
        for (Personaje p : personajes) {
            System.out.println(p + (p.estaVivo() ? " (VIVO)" : " (MUERTO)"));
        }
    }
}

