package com.example.demo.model;

public class Joaca {

    private int idJoaca;
    private int salariu;
    private int idActor;
    private int idFilm;

    public Joaca(){}

    public Joaca(int idJoaca, int salariu, int idActor, int idFilm) {
        this.idJoaca = idJoaca;
        this.salariu = salariu;
        this.idActor = idActor;
        this.idFilm = idFilm;
    }

    public int getIdJoaca() {
        return idJoaca;
    }

    public void setIdJoaca(int idJoaca) {
        this.idJoaca = idJoaca;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }
}
