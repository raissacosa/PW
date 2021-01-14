package com.example.demo.model;

public class Sala {

    private int idSala;
    private int numarSala;
    private int capacitate;
    private int idCinema;

    private Sala(){}

    public Sala(int idSala, int numarSala, int capacitate, int idCinema) {
        this.idSala = idSala;
        this.numarSala = numarSala;
        this.capacitate = capacitate;
        this.idCinema = idCinema;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNumarSala() {
        return numarSala;
    }

    public void setNumarSala(int nrSala) {
        this.numarSala = nrSala;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }
}
