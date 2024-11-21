package org.example.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL para MySQL (ajusta el host, puerto, nombre de la base de datos, etc.)
    private static final String URL = "jdbc:mysql://localhost:3306/PixelStore"; // Cambia 'localhost:3306' y 'PixelStore' según corresponda
    private static final String USER = "root";  // Tu usuario de MySQL
    private static final String PASSWORD = "";  // Tu contraseña de MySQL

    private static Connection connection;

    // Constructor privado
    private DatabaseConnection() {
    }

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            // Cargar el driver de MySQL (en versiones más nuevas, esto puede no ser necesario si el JAR está correctamente incluido)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver no encontrado.", e);
            }
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos MySQL establecida.");
        }
        return connection;
    }

    // Método para cerrar la conexión
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
