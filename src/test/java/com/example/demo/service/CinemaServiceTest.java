package com.example.demo.service;


import com.example.demo.model.Cinema;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.utils.ObjectException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CinemaServiceTest {

    @InjectMocks
    private CinemaService cinemaService;

    @Mock
    private CinemaRepository cinemaRepository;

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
    @DisplayName("Afisarea cinemaurilor")
    public void getCinemaTest(){
        when(cinemaRepository.getCinema()).thenReturn(
                Arrays.asList(new Cinema(1,"CinemaTest","OrasTest","AdresaTest",2005))
        );

        List<Cinema> result = cinemaService.getCinema();

        Cinema cinema = result.get(0);
        assertEquals(result.size(),1);
        assertEquals(cinema.getIdCinema(),1);
        assertEquals(cinema.getNumeCinema(),"CinemaTest");
        assertEquals(cinema.getOras(),"OrasTest");
        assertEquals(cinema.getAdresa(),"AdresaTest");
        assertEquals(cinema.getAnConstructie(),2005);

    }

    @Test
    @DisplayName("Adaugarea unui cinema")
    public void addCinemaTest(){
        Cinema cinema = new Cinema(1,"CinemaTest","OrasTest","AdresaTest",2005);
        Cinema savedCinema = new Cinema(1,"CinemaTest","OrasTest","AdresaTest",2005);
        when(cinemaRepository.addCinema(cinema)).thenReturn(savedCinema);

        Cinema result = cinemaService.addCinema(cinema);

        assertEquals(cinema.getNumeCinema(),result.getNumeCinema());
        assertEquals(cinema.getOras(),result.getOras());
        assertEquals(cinema.getAdresa(),result.getAdresa());
        assertEquals(cinema.getAnConstructie(),result.getAnConstructie());

        verify(cinemaRepository,times(1)).addCinema(cinema);

    }

    @Test
    @DisplayName("Stergerea unui cinema")
    public void deleteCinemaTest(){
        Cinema cinema = new Cinema(1,"CinemaTest","OrasTest","AdresaTest",2005);

        when(cinemaRepository.deleteCinemaById(cinema.getIdCinema())).thenReturn(List.of(cinema));

        List<Cinema> result = cinemaService.deleteCinemaById(cinema.getIdCinema());

        assertEquals(cinema.getIdCinema(),1);
        assertEquals(cinema.getNumeCinema(),result.get(0).getNumeCinema());
        assertEquals(cinema.getOras(),result.get(0).getOras());
        assertEquals(cinema.getAdresa(),result.get(0).getAdresa());
        assertEquals(cinema.getAnConstructie(),result.get(0).getAnConstructie());

        verify(cinemaRepository,times(1)).deleteCinemaById(cinema.getIdCinema());

    }

    @Test
    @DisplayName("Afisarea cinemaurilor construite dupa anul..")
    public void getCinemaBuidAfterTest() {

        when(cinemaRepository.getCinemaBuildAfter(2000)).thenReturn(
                Arrays.asList(new Cinema(1,"CinemaTest","OrasTest","AdresaTest",2005),
                        new Cinema(1,"CinemaTest","OrasTest","AdresaTest",2001))
        );

        List<Cinema> result = cinemaService.getCinemaBuildAfter(2000);

        assertEquals(result.size(),2);

    }

    @Test
    @DisplayName("Afisarea cinemaurilor dintr-un oras")
    public void getCinemaByOras(){
        when(cinemaRepository.getCinemaByOras("Bucuresti")).thenReturn(
                Arrays.asList(new Cinema(1,"CinemaTest","Bucuresti","AdresaTest",2005),
                new Cinema(1,"CinemaTest","Bucuresti","AdresaTest",2001))
        );

        List<Cinema> result = cinemaService.getCinemaByOras("Bucuresti");

        assertEquals(result.size(),2);

    }




}
