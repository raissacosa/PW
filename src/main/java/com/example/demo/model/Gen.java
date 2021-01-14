package com.example.demo.model;


public class Gen {

    private int idGen;
    private String numeGen;

    public Gen(){}

    public Gen(int idGen, String numeGen) {
        this.idGen = idGen;
        this.numeGen = numeGen;
    }

    public int getIdGen() {
        return idGen;
    }

    public void setIdGen(int idGen) {
        this.idGen = idGen;
    }

    public String getNumeGen() {
        return numeGen;
    }

    public void setNumeGen(String numeGen) {
        this.numeGen = numeGen;
    }
}
