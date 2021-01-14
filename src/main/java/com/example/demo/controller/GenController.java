package com.example.demo.controller;

import com.example.demo.model.Gen;
import com.example.demo.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gen")
public class GenController {

    @Autowired
    private GenService genService;

    @GetMapping("/get")
    public List<Gen> getGen()
    {
        return genService.getGen();
    }

    @PostMapping("/add")
    public Gen addGen(@RequestBody Gen g) {
        return genService.addGen(g);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteGen(@RequestParam int id) {
        try{
        return ResponseEntity.ok().body(genService.deleteGen(id));
        }catch (Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

}
