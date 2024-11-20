package org.example.BaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteBD {

    public static void main(String[] args) {
        // Establecer la conexión usando DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Habilitar las restricciones de claves foráneas en SQLite
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("PRAGMA foreign_keys = ON;");
            }

            // Verificar si la conexión es exitosa
            if (conn != null) {
                System.out.println("Conexión a la base de datos establecida.");

                // Crear las tablas si no existen
                createTableDesarrollador(conn);
                createTableUsuario(conn);
                createTableVideojuego(conn);
                createTableTienda(conn);
                createTableUsuarioVideojuego(conn);
                createTableTiendaVideojuego(conn);
            }

        } catch (SQLException e) {
            System.out.println("Error en la conexión o en la ejecución de SQL: " + e.getMessage());
        }
    }

    // Crear la tabla 'Usuario'
    private static void createTableUsuario(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Usuario (" +
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, " +  // Cambié 'INT' por 'INTEGER'
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

    // Crear la tabla 'Desarrollador'
    private static void createTableDesarrollador(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Desarrollador (" +
                "id_desarrollador INTEGER PRIMARY KEY AUTOINCREMENT, " +  // Cambié 'INT' por 'INTEGER'
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

    // Crear la tabla 'Videojuego'
    private static void createTableVideojuego(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Videojuego (" +
                "id_videojuego INTEGER PRIMARY KEY AUTOINCREMENT, " +  // Cambié 'INT' por 'INTEGER'
                "nombre VARCHAR(100) NOT NULL, " +
                "precio DECIMAL(10, 2) NOT NULL, " +
                "descripcion VARCHAR(255) NOT NULL, " +
                "id_desarrollador INTEGER NOT NULL, " +
                "FOREIGN KEY (id_desarrollador) REFERENCES Desarrollador(id_desarrollador)" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'Videojuego' creada o ya existe.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    // Crear la tabla 'Tienda'
    private static void createTableTienda(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Tienda (" +
                "id_tienda INTEGER PRIMARY KEY AUTOINCREMENT, " +  // Cambié 'INT' por 'INTEGER'
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

    // Crear la tabla 'Usuario_Videojuego'
    private static void createTableUsuarioVideojuego(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Usuario_Videojuego (" +
                "id_usuario INTEGER, " +  // Cambié 'INT' por 'INTEGER'
                "id_videojuego INTEGER, " +  // Cambié 'INT' por 'INTEGER'
                "fecha_compra DATE NOT NULL, " +
                "PRIMARY KEY (id_usuario, id_videojuego), " +
                "FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario), " +
                "FOREIGN KEY (id_videojuego) REFERENCES Videojuego(id_videojuego)" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'Usuario_Videojuego' creada o ya existe.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    // Crear la tabla 'Tienda_Videojuego'
    private static void createTableTiendaVideojuego(Connection conn) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Tienda_Videojuego (" +
                "id_tienda INTEGER, " +  // Cambié 'INT' por 'INTEGER'
                "id_videojuego INTEGER, " +  // Cambié 'INT' por 'INTEGER'
                "stock INTEGER NOT NULL, " +  // Cantidad de videojuegos disponibles en la tienda
                "precio DECIMAL(10, 2) NOT NULL, " +  // El precio de ese videojuego en la tienda
                "PRIMARY KEY (id_tienda, id_videojuego), " +
                "FOREIGN KEY (id_tienda) REFERENCES Tienda(id_tienda), " +
                "FOREIGN KEY (id_videojuego) REFERENCES Videojuego(id_videojuego)" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'Tienda_Videojuego' creada o ya existe.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}
