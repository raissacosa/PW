package com.example.demo.controller;


import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/get")
    public List<Actor> getActori() {
        return actorService.getActori();
    }

    @PostMapping("/add")
    public Actor addActor(@RequestBody Actor a) {
        return actorService.addActor(a);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteActorById(@RequestParam int id) {
        try{
        return ResponseEntity.ok().body(actorService.deleteActorById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/getbynume")
    public ResponseEntity<?> getActorByName(@RequestParam String numeActor){
        try{
            return ResponseEntity.ok().body(actorService.getActorByName(numeActor));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getjoacafilm")
    public ResponseEntity<?> getActoriJoacaFilm(@RequestParam String numeFilm){
        try{
            return ResponseEntity.ok().body(actorService.getActoriJoacaFilm(numeFilm));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
