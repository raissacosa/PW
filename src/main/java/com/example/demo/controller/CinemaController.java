package com.example.demo.controller;

import com.example.demo.model.Cinema;
import com.example.demo.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/get")
    public List<Cinema> getCinema(){return cinemaService.getCinema();}

    @PostMapping("/add")
    public Cinema addCinema(@RequestBody Cinema c){return cinemaService.addCinema(c);}

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCinemaById(@RequestParam int id){
        try{
        return ResponseEntity.ok().body(cinemaService.deleteCinemaById(id));}
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/getbyoras")
    public ResponseEntity<?> getCinemaByOras(String numeOras){
        try {
            return ResponseEntity.ok().body(cinemaService.getCinemaByOras(numeOras));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/afteryear")
    public ResponseEntity<?> getCinemaBuildAfter(@RequestParam int an){
        try {
            return ResponseEntity.ok().body(cinemaService.getCinemaBuildAfter(an));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/getcapacitate")
    public ResponseEntity<?> getCinemaCapacitateMaiMare(@RequestParam int capacitate){
        try {
            return ResponseEntity.ok().body(cinemaService.getCinemaCapacitateMaiMare(capacitate));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}

