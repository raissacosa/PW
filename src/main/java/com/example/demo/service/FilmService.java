package com.example.demo.service;

import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getFilm(){
        return filmRepository.getFilm();
    }

    public Film addFilm(Film f){
        return filmRepository.addFilm(f);
    }

    public List<Film> deleteFilmById(int id){
        return filmRepository.deleteFilmById(id);
    }

    public List<Film> getFilmByName(String numeFilm){return filmRepository.getFilmByName(numeFilm);}

    public List<Film> getFilmByGen(String numeGen){return filmRepository.getFilmByGen(numeGen);}
}
