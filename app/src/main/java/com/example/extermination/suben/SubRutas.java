package com.example.extermination.suben;

/**
 * Created by EXtermination on 21/11/2017.
 */

public class SubRutas {
    public int getrIDSubrutas() {
        return rIDSubrutas;
    }

    public int getrIDRuta() {
        return rIDRuta;
    }

    public double getRorden() {
        return rorden;
    }

    public double getRlat() {
        return rlat;
    }

    public double getRlon() {
        return rlon;
    }

    private int rIDSubrutas;
    private int rIDRuta;
    private double rorden;
    private double rlat;
    private double rlon;

    public SubRutas(int rIDSubrutas, int rIDruta, double rorden, double rlat, double rlon){
        this.rIDSubrutas = rIDSubrutas;
        this.rIDRuta=rIDruta;
        this.rorden=rorden;
        this.rlat=rlat;
        this.rlon=rlon;
    }

}
