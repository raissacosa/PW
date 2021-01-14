package com.example.demo.service;


import com.example.demo.model.Film;
import com.example.demo.model.Gen;
import com.example.demo.repository.FilmRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {

    @InjectMocks
    private FilmService filmService;

    @Mock
    private FilmRepository filmRepository;

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
    @DisplayName("Afisare filme")
    public void getFilmTest(){

        when(filmRepository.getFilm()).thenReturn(
                Arrays.asList(new Film(1,"NumeTest",100,2005,1,1))
        );

        List<Film> result = filmService.getFilm();

        Film film = result.get(0);
        assertEquals(result.size(),1);
        assertEquals(film.getIdFilm(),1);
        assertEquals(film.getNumeFilm(),"NumeTest");
        assertEquals(film.getDurata(),100);
        assertEquals(film.getAnLansare(),2005);
        assertEquals(film.getIdSala(),1);
        assertEquals(film.getIdGen(),1);
    }

    @Test
    @DisplayName("Adaugarea unui film")
    public void addFilmTest(){

        Film film = new Film(1,"NumeTest",100,2005,1,1);
        Film savedFilm = new Film(1,"NumeTest",100,2005,1,1);
        when(filmRepository.addFilm(film)).thenReturn(savedFilm);

        Film result = filmService.addFilm(film);

        assertEquals(film.getNumeFilm(),result.getNumeFilm());
        assertEquals(film.getDurata(),result.getDurata());
        assertEquals(film.getAnLansare(),result.getAnLansare());
        assertEquals(film.getIdSala(),result.getIdSala());
        assertEquals(film.getIdGen(),result.getIdGen());

        verify(filmRepository,times(1)).addFilm(film);

    }

    @Test
    @DisplayName("Stergerea unui film")
    public void deleteFilmTest(){
        Film film = new Film(1,"NumeTest",100,2005,1,1);

        when(filmRepository.deleteFilmById(film.getIdFilm())).thenReturn(List.of(film));

        List<Film> result = filmService.deleteFilmById(film.getIdFilm());

        assertEquals(film.getIdFilm(),1);
        assertEquals(film.getNumeFilm(),result.get(0).getNumeFilm());
        assertEquals(film.getDurata(),result.get(0).getDurata());
        assertEquals(film.getAnLansare(),result.get(0).getAnLansare());
        assertEquals(film.getIdSala(),result.get(0).getIdSala());
        assertEquals(film.getIdGen(),result.get(0).getIdGen());

        verify(filmRepository,times(1)).deleteFilmById(film.getIdFilm());

    }

    @Test
    @DisplayName("Afisarea filmelor care au un anumit nume")
    public void getFilmByName(){

        when(filmRepository.getFilmByName("Wonder")).thenReturn(
                Arrays.asList(new Film(1,"Wonder",100,2005,1,1),
                              new Film(1,"Wonder",200,2000,3,2)  )
        );

        List<Film> result = filmService.getFilmByName("Wonder");

        assertEquals(result.size(),2);
        assertEquals(result.get(0).getDurata(),100);
        assertEquals(result.get(1).getAnLansare(),2000);

    }

    @Test
    @DisplayName("Afisarea filmelor care au un anumit nume")
    public void getFilmByGen(){

        Gen gen = new Gen(1,"Actiune");
        when(filmRepository.getFilmByGen("Actiune")).thenReturn(
                Arrays.asList(new Film(1,"Wonder",100,2005,1,1),
                        new Film(1,"Wonder",200,2000,3,1)  )
        );

        List<Film> result = filmService.getFilmByGen(gen.getNumeGen());

        assertEquals(result.size(),2);
        assertEquals(result.get(0).getIdGen(),gen.getIdGen());
        assertEquals(result.get(1).getIdGen(),gen.getIdGen());

    }

}
