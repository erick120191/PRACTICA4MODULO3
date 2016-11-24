package com.example.gaby.petagram;

/**
 * Created by gaby on 26/10/2016.
 */
public class Mascota {
    String nombre;
    int imagen;
    private int raiting;

    public Mascota(String nombre,  int imagen) {
        this.nombre = nombre;
        this.imagen=imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }


}
