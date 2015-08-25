package com.example.alberto.eva1t_tecperiodismo;

/**
 * Created by alberto on 25/08/2015.
 */
public class Alumnos {
    String nombre;
    String carnet;
    int image;

    public Alumnos(String nombre, String carnet, int image) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
