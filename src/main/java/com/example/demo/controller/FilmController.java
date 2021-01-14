package com.example.demo.controller;

import com.example.demo.model.Film;
import com.example.demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/get")
    public List<Film> getFilm(){
        return filmService.getFilm();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFilm(@RequestBody Film f){
        try {
            return ResponseEntity.ok().body(filmService.addFilm(f));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFilmById(@RequestParam int id){
        try {
            return ResponseEntity.ok().body(filmService.deleteFilmById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

    }

    @GetMapping("/getbyname")
    public ResponseEntity<?> getFilmByName(@RequestParam String numeFilm){
        try{
        return ResponseEntity.ok().body(filmService.getFilmByName(numeFilm));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getbygen")
    public ResponseEntity<?> getFilmByGen(@RequestParam String numeGen) {
        try {
            return ResponseEntity.ok().body(filmService.getFilmByGen(numeGen));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
