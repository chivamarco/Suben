package com.example.extermination.suben;

/**
 * Created by EXtermination on 21/11/2017.
 */

public class Rutas {
    private int rIDruta;
    private String rName;
    private int rActivo;

    public Rutas(int rIDruta, String rName, int rActivo){
        this.rIDruta = rIDruta;
        this.rName   = rName;
        this.rActivo = rActivo;
    }
    public int getrIDruta() {
        return rIDruta;
    }

    public String getrName() {
        return rName;
    }

    public int isrActivo() {
        return rActivo;
    }
}
