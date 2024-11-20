package org.example.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de la base de datos (el archivo de base de datos se crea en el directorio raíz del proyecto)
    private static final String URL = "jdbc:sqlite:PixelStore.db"; // Nombre de la base de datos

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL); // Obtener la conexión usando DriverManager
    }

    // Método para cerrar la conexión
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
