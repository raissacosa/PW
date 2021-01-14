package com.example.demo.controller;

import com.example.demo.model.Joaca;
import com.example.demo.service.JoacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joaca")
public class JoacaController {

    @Autowired
    private JoacaService joacaService;

    @GetMapping("/get")
    public List<Joaca> getJoaca(){return joacaService.getJoaca();}

    @PostMapping("/add")
    public ResponseEntity<?> addJoaca(@RequestBody Joaca j){
        try {
           return ResponseEntity.ok().body(joacaService.addJoaca(j));
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }

    }

    @DeleteMapping("/delete")
    public List<Joaca> deleteJoacaById(@RequestParam int id){return joacaService.deleteJoacaById(id);}
}
