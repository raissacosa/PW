package com.example.demo.service;

import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> getSala(){
        return salaRepository.getSala();
    }

    public Sala addSala(Sala s)
    {
        return salaRepository.addSala(s);
    }

    public List<Sala> deleteSalaById(int id){return salaRepository.deleteSalaById(id);}

    public int getNumarSaliCinema(int idCinema){return salaRepository.getNumarSaliCinema(idCinema);}
}
