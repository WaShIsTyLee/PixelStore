module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    // Abre el paquete org.example para la reflexión (si se necesita en el FXML)
    opens org.example.BaseDatos to javafx.fxml;  // Para permitir reflexión en BaseDatos si es necesario
    opens org.example.view to javafx.fxml;      // Para la vista de FXML

    // Exporta los paquetes que contienen las clases públicas
    exports org.example.view;  // Para que el paquete 'view' sea accesible desde otros módulos
    exports org.example.BaseDatos;  // Asegúrate de exportar también BaseDatos si lo usas desde otro módulo
}
