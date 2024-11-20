package org.example.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de la base de datos
    private static final String URL = "jdbc:sqlite:PixelStore.db"; // Nombre de la base de datos

    // Variable estática para mantener la única instancia de la conexión
    private static Connection connection;

    // Constructor privado para evitar instanciación externa
    private DatabaseConnection() {
        // Constructor vacío
    }

    // Método para obtener la única instancia de la conexión (Singleton)
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            // Si la conexión es nula, crea una nueva
            connection = DriverManager.getConnection(URL);
            System.out.println("Conexión establecida.");
        }
        return connection;
    }

    // Método para cerrar la conexión (cerrar la instancia única)
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;  // Setear la conexión a null después de cerrarla
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
