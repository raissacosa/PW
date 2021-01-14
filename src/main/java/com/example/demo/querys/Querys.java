package com.example.demo.querys;

public class Querys {

    public final static String GET_ACTORI_SQL = "select * from actor";
    public final static String ADD_ACTOR_SQL = "insert into actor(idActor,numeActor,prenumeActor) values (null,?,?)";
    public final static String DELETE_ACTOR_SQL = "delete from actor where idActor = ?";

    public final static String GET_GEN_SQL = " select * from gen";
    public final static String ADD_GEN_SQL = "insert into gen(idGen,numeGen) values (null,?)";
    public final static String DELETE_GEN_SQL = "delete from gen where idGen = ?";

    public final static String GET_CINEMA_SQL = "select * from cinema";
    public final static String ADD_CINEMA_SQL = "insert into cinema(idCinema,numeCinema,oras,adresa,anConstructie) values (null,?,?,?,?)";
    public final static String DELETE_CINEMA_SQL = "delete from cinema where idCinema = ?";

    public final static String GET_SALA_SQL = " select * from sala";
    public final static String ADD_SALA_SQL = "insert into sala(idSala,numarSala,capacitate,idCinema) values (null,?,?,?)";
    public final static String DELETE_SALA_SQL = "delete from sala where idSala = ?";

    public final static String GET_FILM_SQL = "select * from film";
    public final static String ADD_FILM_SQL ="insert into film(idFilm,numeFilm,durata,anLansare,idSala,idGen) values (null,?,?,?,?,?)";
    public final static String DELETE_FILM_SQL ="delete from film where idFilm = ?";

    public final static String GET_JOACA_SQL = "select * from joaca";
    public final static String ADD_JOACA_SQL = "insert into joaca(idJoaca,salariu, idActor,idFilm) values (null,?,?,?)";
    public final static String DELETE_JOACA_SQL ="delete from joaca where idJoaca = ?";

    public final static String ACTORIJOACAFILM_SQL ="select distinct a.idActor, a.numeActor, a.prenumeActor from actor a join joaca j on(a.idActor=j.idActor) \n" +
            "join (select * from film where numeFilm = ? ) f on(j.idFilm=f.idFilm);";

    public final static String CAPACITATEMAIMARE = "select * from cinema c where ? <= (select sum(capacitate) from sala where idCinema=c.idCinema)";
    public final static String GETFILMGEN_SQL ="select * from film where idGen = (select idGen from gen where numeGen= ? ) ";

}
