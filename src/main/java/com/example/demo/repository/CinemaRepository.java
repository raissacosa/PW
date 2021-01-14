package com.example.demo.repository;

import com.example.demo.model.Cinema;
import com.example.demo.model.Sala;
import com.example.demo.querys.Querys;
import com.example.demo.utils.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CinemaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cinema> getCinema(){return jdbcTemplate.query(Querys.GET_CINEMA_SQL, new BeanPropertyRowMapper<>(Cinema.class));}

    public Cinema addCinema(Cinema c){
        jdbcTemplate.update(Querys.ADD_CINEMA_SQL, c.getNumeCinema(),c.getOras(),c.getAdresa(),c.getAnConstructie());
        return c;
    }

    public List<Cinema> deleteCinemaById(int id){
        try {
            jdbcTemplate.update(Querys.DELETE_CINEMA_SQL, id);
            return jdbcTemplate.query(Querys.GET_CINEMA_SQL, new BeanPropertyRowMapper<>(Cinema.class));
        }catch (Exception e){
            throw new ObjectException("Nu se poate sterge cinemaul!");
        }
        }

    public List<Cinema> getCinemaByOras(String numeOras){
        List<Cinema> cinemas = getCinema();

        return cinemas.stream().filter(film -> film.getOras().equals(numeOras)).collect(Collectors.toList());


    }

    public List<Cinema> getCinemaBuildAfter(int an){

        List<Cinema> cinemas = jdbcTemplate.query("select * from cinema where anConstructie > ?",
                new Object[] {an},
                new BeanPropertyRowMapper<>(Cinema.class));
        /*if(cinemas.size()!=0)
        {return cinemas;}
        else{
            throw new ObjectException("Nu exista cinemauri cu o capacitate mai mare decat cea data!");
        }*/
        return cinemas;
    }

    public List<Cinema> getCinemaCapacitateMaiMare(int capacitate) throws ObjectException{

        List<Cinema> cinemas = jdbcTemplate.query(Querys.CAPACITATEMAIMARE,
                new Object[] {capacitate},
                new BeanPropertyRowMapper<>(Cinema.class));
        if(cinemas.size()!=0)
        {return cinemas;}
        else{
            throw new ObjectException("Nu exista cinemauri cu o capacitate mai mare decat cea data!");
        }
    }


}
