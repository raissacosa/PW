package com.example.demo.service;

import com.example.demo.model.Joaca;
import com.example.demo.repository.JoacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoacaService {

    @Autowired
    private JoacaRepository joacaRepository;

    public List<Joaca> getJoaca(){
        return joacaRepository.getJoaca();}

    public Joaca addJoaca(Joaca j){return joacaRepository.addJoaca(j);}

    public List<Joaca> deleteJoacaById(int id){return joacaRepository.deleteJoacaById(id);}
}
