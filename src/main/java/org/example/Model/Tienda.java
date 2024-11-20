package org.example.Model;

import java.util.ArrayList;
import java.util.Objects;

public class Tienda {
    private int id_Tienda;
    private String ubicacion;
    private String telefono;
    private ArrayList<Videojuego> videojuegosTienda;

    public Tienda(int id_Tienda, String ubicacion, String telefono, ArrayList<Videojuego> videojuegosTienda) {
        this.id_Tienda = id_Tienda;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.videojuegosTienda = videojuegosTienda;
    }

    public Tienda(){}

    public int getId_Tienda() {
        return id_Tienda;
    }

    public void setId_Tienda(int id_Tienda) {
        this.id_Tienda = id_Tienda;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Videojuego> getVideojuegosTienda() {
        return videojuegosTienda;
    }

    public void setVideojuegosTienda(ArrayList<Videojuego> videojuegosTienda) {
        this.videojuegosTienda = videojuegosTienda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tienda tienda = (Tienda) o;
        return id_Tienda == tienda.id_Tienda;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_Tienda);
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "id_Tienda=" + id_Tienda +
                ", ubicacion='" + ubicacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", videojuegosTienda=" + videojuegosTienda +
                '}';
    }
}
