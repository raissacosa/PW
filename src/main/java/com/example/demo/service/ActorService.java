package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getActori() {
        return actorRepository.getActori();
    }

    public Actor addActor(Actor a) {
        return actorRepository.addActor(a);
    }

    public List<Actor> deleteActorById(int id) {
        return actorRepository.deleteActorById(id);
    }

    public List<Actor> getActorByName(String numeActor){ return actorRepository.getActorByName(numeActor);}

    public List<Actor> getActoriJoacaFilm(String numeFilm){ return actorRepository.getActoriJoacaFilm(numeFilm);}
}
