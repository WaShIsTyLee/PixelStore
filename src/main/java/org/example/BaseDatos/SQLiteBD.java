package org.example.BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteBD {

    public static void main(String[] args) {
        // Establecer la conexión usando DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection()) {  // Usamos la clase DatabaseConnection
            // Verificar si la conexión es exitosa
            if (conn != null) {
                System.out.println("Conexión a la base de datos establecida.");

                // Crear la tabla si no existe
                createTableUsuario(conn);
                createTableVideojuego(conn);
                createTableDesarrollador(conn);
                createTableTienda(conn);
                createTableTiendaVideojuego(conn);
                createTableUsuarioVideojuego(conn);

                // Insertar datos en la tabla
            }

        } catch (SQLException e) {
            System.out.println("Error en la conexión o en la ejecución de SQL: " + e.getMessage());
        }
    }

    // Crear la tabla 'Usuario' si no existe
    private static void createTableUsuario(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Usuario (" +
                "id_usuario INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) UNIQUE NOT NULL, " +
                "contraseña VARCHAR(100) NOT NULL, " +
                "administrador BOOLEAN DEFAULT FALSE" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'Usuario' creada o ya existe.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
    private static void createTableVideojuego(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Videojuego (" +
                "id_videojuego INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "precio DECIMAL(10, 2) NOT NULL, " +
                "descripcion VARCHAR(255) NOT NULL, " +
                "id_desarrollador INT NOT NULL, " +  // Clave foránea
                "FOREIGN KEY (id_desarrollador) REFERENCES Desarrollador(id_desarrollador)" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'Videojuego' creada o ya existe.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
    private static void createTableDesarrollador(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Desarrollador (" +
                "id_desarrollador INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "pais VARCHAR(100)" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'Desarrollador' creada o ya existe.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
    private static void createTableTienda(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Tienda (" +
                "id_tienda INT AUTO_INCREMENT PRIMARY KEY, " +
                "ubicacion VARCHAR(255), " +
                "telefono VARCHAR(20)" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'Tienda' creada o ya existe.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }

        private static void createTableUsuarioVideojuego(Connection conn) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Usuario_Videojuego (" +
                    "id_usuario INT, " +
                    "id_videojuego INT, " +
                    "fecha_compra DATE NOT NULL, " +  // Agregar fecha de compra (puedes agregar más atributos si es necesario)
                    "PRIMARY KEY (id_usuario, id_videojuego), " +  // Clave primaria compuesta por ambas claves foráneas
                    "FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario), " +
                    "FOREIGN KEY (id_videojuego) REFERENCES Videojuego(id_videojuego)" +
                    ");";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Tabla 'Usuario_Videojuego' creada o ya existe.");
            } catch (SQLException e) {
                System.out.println("Error al crear la tabla 'Usuario_Videojuego': " + e.getMessage());
            }
        }


    private static void createTableTiendaVideojuego(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Tienda_Videojuego (" +
                "id_tienda INT, " +
                "id_videojuego INT, " +
                "stock INT NOT NULL, " +  // Cantidad de videojuegos disponibles en la tienda
                "precio DECIMAL(10, 2) NOT NULL, " +  // El precio de ese videojuego en la tienda
                "PRIMARY KEY (id_tienda, id_videojuego), " +  // Clave primaria compuesta
                "FOREIGN KEY (id_tienda) REFERENCES Tienda(id_tienda), " +
                "FOREIGN KEY (id_videojuego) REFERENCES Videojuego(id_videojuego)" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'Tienda_Videojuego' creada o ya existe.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla 'Tienda_Videojuego': " + e.getMessage());
        }
    }



}
