package com.example.demo.service;

import com.example.demo.model.Cinema;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.utils.ObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getCinema(){return cinemaRepository.getCinema();}

    public Cinema addCinema(Cinema c){return cinemaRepository.addCinema(c);}

    public List<Cinema> deleteCinemaById(int id){return cinemaRepository.deleteCinemaById(id);}

    public List<Cinema> getCinemaByOras(String numeOras){

        List<Cinema> cinemas= cinemaRepository.getCinemaByOras(numeOras);
        if (cinemas.isEmpty())
        {
            throw new ObjectException("Nu exista cinemauri in acest oras");
        }
        else{
            return cinemas;
        }

    }

    public List<Cinema> getCinemaBuildAfter(int an){ List<Cinema> cinemas= cinemaRepository.getCinemaBuildAfter(an);
            return cinemas;
    }

    public List<Cinema> getCinemaCapacitateMaiMare(int capacitate){ return cinemaRepository.getCinemaCapacitateMaiMare(capacitate);}

}
