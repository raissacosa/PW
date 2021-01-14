package com.example.demo.service;

import com.example.demo.model.Cinema;
import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;
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
public class SalaServiceTest {

    @InjectMocks
    private SalaService salaService;

    @Mock
    private SalaRepository salaRepository;

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
    @DisplayName("Afisarea salilor")
    public void getSalaTest(){
        when(salaRepository.getSala()).thenReturn(Arrays.asList(new Sala(1,2,200,2)));

        List<Sala> result = salaService.getSala();

        Sala sala = result.get(0);
        assertEquals(result.size(),1);
        assertEquals(sala.getIdSala(),1);
        assertEquals(sala.getNumarSala(),2);
        assertEquals(sala.getCapacitate(),200);
        assertEquals(sala.getIdCinema(),2);
    }

    @Test
    @DisplayName("Adaugarea unei sali")
    public void addSalaTest(){
        Sala sala = new Sala(1,2,200,2);
        Sala savedSala = new Sala(1,2,200,2);
        when(salaRepository.addSala(sala)).thenReturn(savedSala);

        Sala result = salaService.addSala(sala);

        assertEquals(sala.getNumarSala(),result.getNumarSala());
        assertEquals(sala.getCapacitate(),result.getCapacitate());
        assertEquals(sala.getIdCinema(),result.getIdCinema());

        verify(salaRepository,times(1)).addSala(sala);

    }

    @Test
    @DisplayName("Stergerea unei sali")
    public void deleteSalaTest(){
        Sala sala = new Sala(1,2,200,2);

        when(salaRepository.deleteSalaById(sala.getIdSala())).thenReturn(List.of(sala));

        List<Sala> result = salaService.deleteSalaById(sala.getIdSala());

        assertEquals(sala.getIdSala(),1);
        assertEquals(sala.getNumarSala(),2);
        assertEquals(sala.getCapacitate(),200);
        assertEquals(sala.getIdCinema(),2);

        verify(salaRepository,times(1)).deleteSalaById(sala.getIdSala());

    }

    @Test
    @DisplayName("Numarul de sali pe care le are un cinema")
    public void getNumarSaliCinemaTest(){

        Cinema cinema = new Cinema(1,"CinemaCity","Bucuresti","Strada Revolutiei Nr 3",2003);

        when(salaService.getNumarSaliCinema(1)).thenReturn(3);

        Integer nr = salaService.getNumarSaliCinema(cinema.getIdCinema());
        assertEquals(nr,3);

    }

}
