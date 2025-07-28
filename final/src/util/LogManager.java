package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LogManager {
    private static final String LOG_PATH = "log_partidas.txt";

    public static void guardarLog(List<String> log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_PATH, true))) {
            writer.write("===== NUEVA PARTIDA =====\n");
            for (String linea : log) {
                writer.write(linea + "\n");
            }
            writer.write("===== FIN PARTIDA =====\n\n");
            System.out.println("Log guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el log: " + e.getMessage());
        }
    }

    public static void leerLog() {
        System.out.println("LOG DE PARTIDAS:");
        try {
            Files.lines(Paths.get(LOG_PATH)).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error al leer el log o el archivo no existe.");
        }
    }

    public static void borrarLog() {
        try {
            Files.deleteIfExists(Paths.get(LOG_PATH));
            System.out.println("🗑️ Log borrado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al borrar el log: " + e.getMessage());
        }
    }
}
