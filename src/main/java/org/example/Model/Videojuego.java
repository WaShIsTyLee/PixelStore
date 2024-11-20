package org.example.Model;

import java.util.Objects;

public class Videojuego {
    private int id_Videojuego;
    private String nombre;
    private String descripcion;
    private float precio;
    private Desarrollador desarrollador;
    private Tienda tienda;

    public Videojuego(int id_Videojuego, String nombre, String descripcion, float precio, Desarrollador desarrollador, Tienda tienda) {
        this.id_Videojuego = id_Videojuego;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.desarrollador = desarrollador;
        this.tienda = tienda;
    }

    public Videojuego(){}


    public int getId_Videojuego() {
        return id_Videojuego;
    }

    public void setId_Videojuego(int id_Videojuego) {
        this.id_Videojuego = id_Videojuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return id_Videojuego == that.id_Videojuego;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_Videojuego);
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id_Videojuego=" + id_Videojuego +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", desarrollador=" + desarrollador +
                ", tienda=" + tienda +
                '}';
    }
}
