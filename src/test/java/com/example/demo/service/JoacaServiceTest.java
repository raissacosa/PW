package com.example.demo.service;


import com.example.demo.model.Joaca;
import com.example.demo.repository.JoacaRepository;
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
public class JoacaServiceTest {

    @InjectMocks
    private JoacaService joacaService;

    @Mock
    private JoacaRepository joacaRepository;

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
    @DisplayName("Afisarea listei joaca")
    public void getJoacaTest(){
        when(joacaRepository.getJoaca()).thenReturn(
                Arrays.asList(new Joaca(1,1500,1,1))
        );

        List<Joaca> result = joacaService.getJoaca();

        Joaca joaca = result.get(0);
        assertEquals(result.size(),1);
        assertEquals(joaca.getIdJoaca(),result.get(0).getIdJoaca());
        assertEquals(joaca.getSalariu(),result.get(0).getSalariu());
        assertEquals(joaca.getIdActor(),result.get(0).getIdActor());
        assertEquals(joaca.getIdFilm(),result.get(0).getIdFilm());

    }

    @Test
    @DisplayName("Adaugare joaca")
    public void addJoacaTest(){

        Joaca joaca = new Joaca(1,1500,1,1);
        Joaca savedJoaca = new Joaca(1,1500,1,1);
        when(joacaRepository.addJoaca(joaca)).thenReturn(savedJoaca);

        Joaca result = joacaService.addJoaca(joaca);

        assertEquals(joaca.getSalariu(),result.getSalariu());
        assertEquals(joaca.getIdActor(),result.getIdActor());
        assertEquals(joaca.getIdFilm(),result.getIdFilm());

        verify(joacaRepository,times(1)).addJoaca(joaca);
    }

    @Test
    @DisplayName("Stergere joaca")
    public void deleteJoacaTest(){
        Joaca joaca = new Joaca(1,1500,1,1);
        when(joacaRepository.deleteJoacaById(joaca.getIdJoaca())).thenReturn(List.of(joaca));

        List<Joaca> result = joacaService.deleteJoacaById(joaca.getIdJoaca());

        assertEquals(joaca.getIdJoaca(),result.get(0).getIdJoaca());
        assertEquals(joaca.getSalariu(),result.get(0).getSalariu());
        assertEquals(joaca.getIdActor(),result.get(0).getIdActor());
        assertEquals(joaca.getIdFilm(),result.get(0).getIdFilm());

        verify(joacaRepository,times(1)).deleteJoacaById(joaca.getIdJoaca());
    }

}
