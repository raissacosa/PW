package com.example.demo.controller;

import com.example.demo.model.Sala;
import com.example.demo.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping("/get")
    public List<Sala> getSala(){
        return salaService.getSala();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSala(@RequestBody Sala s)
    {
        try{
        return ResponseEntity.ok().body(salaService.addSala(s));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSalaById(@RequestParam int id){
        try {
            return ResponseEntity.ok().body(salaService.deleteSalaById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/getnumarsali")
    public ResponseEntity<?> getNumarSaliCinema(@RequestParam int idCinema){
        try {
            return ResponseEntity.ok().body(salaService.getNumarSaliCinema(idCinema));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

    }
}
