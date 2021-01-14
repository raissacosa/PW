package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.model.Film;
import com.example.demo.repository.ActorRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ActorServiceTest {

    @InjectMocks
    private ActorService actorService;

    @Mock
    private ActorRepository actorRepository;

    @BeforeEach
    public void beforeEach(){
        System.out.println("Hello from before each!");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Hello from before all!");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Hello from after each!");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Hello from after all!");
    }

    @Test
    @DisplayName("Afisarea actorilor")
    public void getActoriTest(){
        when(actorRepository.getActori()).thenReturn(
                Arrays.asList(new Actor(1,"NumeTest","prenumeTest"))
        );

        List<Actor> result = actorService.getActori();

        Actor actor = result.get(0);
        assertEquals(result.size(),1);
        assertEquals(actor.getIdActor(),1);
        assertEquals(actor.getNumeActor(),"NumeTest");
        assertEquals(actor.getPrenumeActor(),"prenumeTest");
    }

    @Test
    @DisplayName("Adaugarea unui actor")
    public void addActorTest(){

        Actor actor = new Actor(1,"NumeTest","PrenumeTest");
        Actor savedActor = new Actor(1,"NumeTest","PrenumeTest");
        when(actorRepository.addActor(actor)).thenReturn(savedActor);

        Actor result = actorService.addActor(actor);

        assertEquals(actor.getNumeActor(),result.getNumeActor());
        assertEquals(actor.getPrenumeActor(),result.getPrenumeActor());

        verify(actorRepository,times(1)).addActor(actor);
    }

    @Test
    @DisplayName("Stergerea unui actor")
    public void deleteActorTest(){
        Actor actor = new Actor(1,"NumeTest","PrenumeTest");

        when(actorRepository.deleteActorById(actor.getIdActor())).thenReturn(List.of(actor));

        List<Actor> result = actorService.deleteActorById(actor.getIdActor());

        assertEquals(actor.getIdActor(),1);
        assertEquals(actor.getNumeActor(),result.get(0).getNumeActor());
        assertEquals(actor.getPrenumeActor(),result.get(0).getPrenumeActor());

        verify(actorRepository,times(1)).deleteActorById(actor.getIdActor());
    }

    @Test
    @DisplayName("Afisare actori cu nume dat")
    public void getActorByNameTest(){

        when(actorRepository.getActorByName("Roberts")).thenReturn(
                Arrays.asList(new Actor(1,"Roberts","Julia"),
                        new Actor(1,"Roberts","Emma"))
        );

        List<Actor> result = actorService.getActorByName("Roberts");

        assertEquals(result.size(),2);
        assertEquals(result.get(0).getPrenumeActor(),"Julia");
        assertEquals(result.get(1).getPrenumeActor(),"Emma");

    }

    @Test
    @DisplayName("Afisare actori care joaca intr-un film dat")
    public void getActoriJoacaFilmTest(){

        Film film = new Film(1,"Wonder",200,2000,3,1);

        when(actorRepository.getActoriJoacaFilm(film.getNumeFilm())).thenReturn(
                Arrays.asList(new Actor(1,"Roberts","Julia"),
                        new Actor(1,"Roberts","Emma"))
        );

        List<Actor> result = actorService.getActoriJoacaFilm(film.getNumeFilm());

        assertEquals(result.size(),2);
        assertEquals(result.get(0).getPrenumeActor(),"Julia");
        assertEquals(result.get(1).getPrenumeActor(),"Emma");

    }

}
