package com.example.demo.service;

import com.example.demo.model.Gen;
import com.example.demo.repository.GenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenService {

    @Autowired
    private GenRepository genRepository;

    public List<Gen> getGen()
    {
        return genRepository.getGen();
    }

    public Gen addGen(Gen g) {
        return genRepository.addGen(g);
    }

    public List<Gen> deleteGen(int id) {

        return genRepository.deleteGen(id);
    }
}
