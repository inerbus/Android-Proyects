package com.example.alberto.eva1t_tecperiodismo;

/**
 * Created by alberto on 24/08/2015.
 */
public class Materias {
    String codigo;
    String materia;
    String prer;
    int img;

    public Materias(String materia, String prer,String codigo, int img) {
        this.materia = materia;
        this.prer = prer;
        this.codigo=codigo;
        this.img = img;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getPrer() {
        return prer;
    }

    public void setPrer(String prer) {
        this.prer = prer;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
