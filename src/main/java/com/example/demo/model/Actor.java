package com.example.demo.model;

public class Actor {

    private int idActor;
    private String numeActor;
    private String prenumeActor;

    public Actor(){}

    public Actor(int idActor, String numeActor, String prenumeActor) {
        this.idActor = idActor;
        this.numeActor = numeActor;
        this.prenumeActor = prenumeActor;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNumeActor() {
        return numeActor;
    }

    public void setNumeActor(String numeActor) {
        this.numeActor = numeActor;
    }

    public String getPrenumeActor() {
        return prenumeActor;
    }

    public void setPrenumeActor(String prenumeActor) {
        this.prenumeActor = prenumeActor;
    }
}
