package util;

import personajes.Elfo;
import personajes.Humano;
import personajes.Orco;
import personajes.Personaje;

import java.util.Random;
import java.util.Scanner;

public class PersonajeFactory {
    private static final String[] nombres = {
            "Zeus", "Atenea", "Hades",
            "Hera","Poseidón", "Aquiles",
            "El Minotauro", "Ciclope"
    };

    private static final String[] apodos = {
            "El Dios del trueno", "La Diosa de la sabiduria", "El Dios de los muertos y el inframundo",
            "La Reina de los dioses", "El Dios de los mares", "El de los pies ligeros",
            "El toro de Minos", "Gigante tuerto"
    };

    private static final Random random = new Random();

    public static Personaje generarAleatorio() {
        String nombre = nombres[random.nextInt(nombres.length)];
        String apodo = apodos[random.nextInt(apodos.length)];
        String fechaNacimiento = "900 a.c.";
        int edad = 100 + random.nextInt(201); // entre 100 y 300
        int salud = 100;
        int velocidad = random.nextInt(10) + 1;
        int destreza = random.nextInt(5) + 1;
        int fuerza = random.nextInt(10) + 1;
        int nivel = random.nextInt(10) + 1;
        int armadura = random.nextInt(10) + 1;

        int tipo = random.nextInt(3); // 0 = Humano, 1 = Elfo, 2 = Orco

        switch (tipo) {
            case 0: return new Humano(nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
            case 1: return new Elfo(nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
            default: return new Orco(nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
        }
    }

    public static Personaje generarManual(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apodo: ");
        String apodo = sc.nextLine();
        System.out.print("Fecha de nacimiento (ej: 900 a.C.): ");
        String fechaNacimiento = sc.nextLine();
        System.out.print("Edad (0-300): ");
        int edad = Integer.parseInt(sc.nextLine());
        int salud = 100;

        System.out.print("Velocidad (1-10): ");
        int velocidad = Integer.parseInt(sc.nextLine());
        System.out.print("Destreza (1-5): ");
        int destreza = Integer.parseInt(sc.nextLine());
        System.out.print("Fuerza (1-10): ");
        int fuerza = Integer.parseInt(sc.nextLine());
        System.out.print("Nivel (1-10): ");
        int nivel = Integer.parseInt(sc.nextLine());
        System.out.print("Armadura (1-10): ");
        int armadura = Integer.parseInt(sc.nextLine());

        System.out.print("Raza (1 = Humano, 2 = Elfo, 3 = Orco): ");
        int tipo = Integer.parseInt(sc.nextLine());

        switch (tipo) {
            case 1: return new Humano(nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
            case 2: return new Elfo(nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
            case 3: return new Orco(nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
            default: System.out.println("Raza no válida. Se generará un Humano por defecto.");
                return new Humano(nombre, apodo, fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
        }
    }
}
