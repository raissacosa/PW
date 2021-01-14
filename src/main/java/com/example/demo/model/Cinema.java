package com.example.demo.model;

public class Cinema {
    private int idCinema;
    private String numeCinema;
    private String oras;
    private String adresa;
    private int anConstructie;

    public Cinema(){}

    public Cinema(int idCinema, String numeCinema, String oras, String adresa, int anConstructie) {
        this.idCinema = idCinema;
        this.numeCinema = numeCinema;
        this.oras = oras;
        this.adresa = adresa;
        this.anConstructie = anConstructie;
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public String getNumeCinema() {
        return numeCinema;
    }

    public void setNumeCinema(String numeCinema) {
        this.numeCinema = numeCinema;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getAnConstructie() {
        return anConstructie;
    }

    public void setAnConstructie(int anConstructie) {
        this.anConstructie = anConstructie;
    }
}
