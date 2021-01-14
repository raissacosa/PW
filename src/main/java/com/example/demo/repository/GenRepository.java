package com.example.demo.repository;

import com.example.demo.model.Gen;
import com.example.demo.querys.Querys;
import com.example.demo.utils.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Gen> getGen()
    {
        return jdbcTemplate.query(Querys.GET_GEN_SQL, new BeanPropertyRowMapper<>(Gen.class));
    }

    public Gen addGen(Gen g) {
        jdbcTemplate.update(Querys.ADD_GEN_SQL,g.getNumeGen());
        return g;
    }

    public List<Gen> deleteGen(int id) {
        try {
            jdbcTemplate.update(Querys.DELETE_GEN_SQL, id);
            return jdbcTemplate.query(Querys.GET_GEN_SQL, new BeanPropertyRowMapper<>(Gen.class));
        } catch (Exception e){
            throw new ObjectException("Nu se poate sterge genul");
        }
    }


}
