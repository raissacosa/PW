package com.example.demo.model;

public class Film {

    private int idFilm;
    private String numeFilm;
    private int durata;
    private int anLansare;
    private int idSala;
    private int idGen;

    public Film(){}

    public Film(int idFilm, String numeFilm, int durata, int anLansare, int idSala, int idGen) {
        this.idFilm = idFilm;
        this.numeFilm = numeFilm;
        this.durata = durata;
        this.anLansare = anLansare;
        this.idSala = idSala;
        this.idGen = idGen;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getNumeFilm() {
        return numeFilm;
    }

    public void setNumeFilm(String numeFilm) {
        this.numeFilm = numeFilm;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getAnLansare() {
        return anLansare;
    }

    public void setAnLansare(int anLansare) {
        this.anLansare = anLansare;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdGen() {
        return idGen;
    }

    public void setIdGen(int idGen) {
        this.idGen = idGen;
    }
}
