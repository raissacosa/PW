package com.example.demo.repository;

import com.example.demo.model.Actor;
import com.example.demo.model.Cinema;
import com.example.demo.model.Film;
import com.example.demo.querys.Querys;
import com.example.demo.utils.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ActorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Actor> getActori() {

        return jdbcTemplate.query(Querys.GET_ACTORI_SQL, new BeanPropertyRowMapper<>(Actor.class));

    }

    public Actor addActor(Actor a) {

        jdbcTemplate.update(Querys.ADD_ACTOR_SQL,a.getNumeActor(),a.getPrenumeActor());
        return a;
    }

    public List<Actor> deleteActorById(int id) {
        try {
            jdbcTemplate.update(Querys.DELETE_ACTOR_SQL, id);
            return jdbcTemplate.query(Querys.GET_ACTORI_SQL, new BeanPropertyRowMapper<>(Actor.class));
        }catch (Exception e){
            throw new ObjectException("Nu se poate sterge actorul");
        }
    }



    public List<Actor> getActorByName(String numeActor) throws ObjectException{
        List<Actor> actori = getActori();
        if(actori.stream().filter(actor -> actor.getNumeActor().equals(numeActor)).collect(Collectors.toList()).size()!=0)
        {
            return actori.stream().filter(actor -> actor.getNumeActor().equals(numeActor)).collect(Collectors.toList());
        }
        else{
            throw new ObjectException("Nu exista actori cu numele dat");
        }
    }

    public List<Actor> getActoriJoacaFilm(String numeFilm) throws ObjectException{

        List<Actor> actors = jdbcTemplate.query(Querys.ACTORIJOACAFILM_SQL,
                new Object[] {numeFilm},
                new BeanPropertyRowMapper<>(Actor.class));
        if (actors.size()!=0)
        {
            return actors;
        }
        else{
            throw new ObjectException("Nu exista actori care sa joace in acest film");
        }


    }



}





