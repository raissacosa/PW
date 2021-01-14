package com.example.demo.repository;



import com.example.demo.model.Sala;
import com.example.demo.querys.Querys;
import com.example.demo.utils.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Sala> getSala(){
        return jdbcTemplate.query(Querys.GET_SALA_SQL, new BeanPropertyRowMapper<>(Sala.class));
    }

    public Sala addSala(Sala s)
    {
        try {
            jdbcTemplate.update(Querys.ADD_SALA_SQL, s.getNumarSala(), s.getCapacitate(), s.getIdCinema());
            return s;
        }catch (Exception e)
        {
            throw new ObjectException("Datele pe care vrei sa le adaugi nu sunt corecte");
        }
    }

    public List<Sala> deleteSalaById(int id){
        try {
        jdbcTemplate.update(Querys.DELETE_SALA_SQL,id);
        return jdbcTemplate.query(Querys.GET_SALA_SQL, new BeanPropertyRowMapper<>(Sala.class));
        }catch (Exception e){
            throw new ObjectException("Sala nu poate fi stearsa");
        }
    }

    public int getNumarSaliCinema(int idCinema) throws ObjectException{

        List<Sala> cinemas = jdbcTemplate.query("select * from sala where idCinema = ?",
                new Object[] {idCinema},
                new BeanPropertyRowMapper<>(Sala.class));

        if (cinemas.size()!=0)
        {return cinemas.size();}
        else {
            throw new ObjectException("Cinemaul dat nu are sali!");
        }

    }

}
