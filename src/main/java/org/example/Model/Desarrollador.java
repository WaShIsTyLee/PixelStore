package org.example.Model;

import java.util.ArrayList;
import java.util.Objects;

public class Desarrollador {
    private int id_Desarrollador;
    private String nombre;
    private String pais;
    private ArrayList <Videojuego> videojuegos ;

    public Desarrollador(int id_Desarrollador, String nombre, String pais, ArrayList<Videojuego> videojuegos) {
        this.id_Desarrollador = id_Desarrollador;
        this.nombre = nombre;
        this.pais = pais;
        this.videojuegos = videojuegos;
    }

    public Desarrollador() {}

    public int getId_Desarrollador() {
        return id_Desarrollador;
    }

    public void setId_Desarrollador(int id_Desarrollador) {
        this.id_Desarrollador = id_Desarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desarrollador that = (Desarrollador) o;
        return id_Desarrollador == that.id_Desarrollador;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_Desarrollador);
    }

    @Override
    public String toString() {
        return "Desarrollador{" +
                "id_Desarrollador=" + id_Desarrollador +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", videojuegos=" + videojuegos +
                '}';
    }
}
