package com.example.demo.repository;

import com.example.demo.model.Joaca;
import com.example.demo.querys.Querys;
import com.example.demo.utils.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoacaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Joaca> getJoaca(){return jdbcTemplate.query(Querys.GET_JOACA_SQL,new BeanPropertyRowMapper<>(Joaca.class));}

    public Joaca addJoaca(Joaca j){
        try{
        jdbcTemplate.update(Querys.ADD_JOACA_SQL, j.getSalariu(),j.getIdActor(),j.getIdFilm());
        return j;
        }catch (Exception e){
            throw new ObjectException("Datele pe care vrei sa le adaugi nu sunt corecte");
        }
    }

    public List<Joaca> deleteJoacaById(int id){
        jdbcTemplate.update(Querys.DELETE_JOACA_SQL,id);
        return jdbcTemplate.query(Querys.GET_JOACA_SQL,new BeanPropertyRowMapper<>(Joaca.class));}

}
