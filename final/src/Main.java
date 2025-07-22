import personajes.*;

public class Main {
    public static void main(String[] args) {
        // Creamos dos personajes
        Humano humano = new Humano("Arthas", "El Valiente", "1990-01-01", 35,
                100, 5, 3, 8, 2, 6);
        Orco orco = new Orco("Grom", "El Destructor", "1800-07-22", 120,
                100, 4, 2, 10, 3, 7);

        System.out.println("Salud inicial del Orco: " + orco.getSalud());

        // El humano ataca al orco
        double danio = humano.calcularDanio(orco);
        System.out.printf("El Humano %s atacó al Orco %s y le hizo %s de daño.\n",
                humano.getNombre(), orco.getNombre(), danio);

        orco.setSalud((int)(orco.getSalud() - danio));
        System.out.printf("Salud restante del Orco: %d\n", orco.getSalud());



        // Ahora el orco contraataca
        double danioOrco = orco.calcularDanio(humano);
        System.out.printf("El Orco %s atacó al Humano %s y le hizo %s de daño.\n",
                orco.getNombre(), humano.getNombre(), danioOrco);

        humano.setSalud((int)(humano.getSalud() - danioOrco));
        System.out.printf("Salud restante del Humano: %d\n", humano.getSalud());

    }
}
