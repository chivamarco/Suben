package com.example.extermination.suben;

/**
 * Created by EXtermination on 21/11/2017.
 */

public class Taxis {
    private int rIDtaxista;
    private String rNombre;
    private  String telefono;
    private int rActivo;

    public Taxis(int rIDtaxista, String rNombre, String telefono, int rActivo){
        this.rIDtaxista = rIDtaxista;
        this.rNombre  = rNombre;
        this.telefono = telefono;
        this.rActivo = rActivo;
    }

    public int getrIDtaxista() {
        return rIDtaxista;
    }

    public String getrNombre() {
        return rNombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getrActivo() {
        return rActivo;
    }

}
