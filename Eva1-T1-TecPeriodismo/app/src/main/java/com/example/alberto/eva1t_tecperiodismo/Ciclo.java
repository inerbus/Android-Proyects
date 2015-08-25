package com.example.alberto.eva1t_tecperiodismo;

/**
 * Created by alberto on 24/08/2015.
 */
public class Ciclo {

    String name;
    int img;
    public Ciclo(String name,int img){
        this.name=name;
        this.img=img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
