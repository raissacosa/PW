package com.example.demo.repository;

import com.example.demo.model.Film;
import com.example.demo.querys.Querys;
import com.example.demo.utils.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Film> getFilm(){
        return jdbcTemplate.query(Querys.GET_FILM_SQL, new BeanPropertyRowMapper<>(Film.class));
    }

    public Film addFilm(Film f){
        try {
            jdbcTemplate.update(Querys.ADD_FILM_SQL, f.getNumeFilm(), f.getDurata(), f.getAnLansare(), f.getIdSala(), f.getIdGen());
            return f;
        }catch (Exception e){
            throw new ObjectException("Datele pe care vrei sa le adaugi nu sunt corecte");
        }
    }

    public List<Film> deleteFilmById(int id){
        try {
            jdbcTemplate.update(Querys.DELETE_FILM_SQL, id);
            return jdbcTemplate.query(Querys.GET_FILM_SQL, new BeanPropertyRowMapper<>(Film.class));
        }catch (Exception e){
            throw new ObjectException("Filmul nu poate fi sters");
        }
    }

    public List<Film> getFilmByName(String numeFilm) throws ObjectException{
            List<Film> filme = getFilm();
            if(filme.stream().filter(film -> film.getNumeFilm().equals(numeFilm)).collect(Collectors.toList()).size() !=0)
            {return filme.stream().filter(film -> film.getNumeFilm().equals(numeFilm)).collect(Collectors.toList());}
            else{
            throw new ObjectException("Nu exista filme cu acest nume!");}
        }

    public List<Film> getFilmByGen(String numeGen) throws ObjectException{

        List<Film> films = jdbcTemplate.query(Querys.GETFILMGEN_SQL,
                new Object[] {numeGen},
                new BeanPropertyRowMapper<>(Film.class));
        if(films.size()!=0)
        {return films;}
        else{
            throw new ObjectException("Nu exista filme care apartin acestui gen!");}
        }


    }



