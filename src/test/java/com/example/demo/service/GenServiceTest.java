package com.example.demo.service;

import com.example.demo.model.Gen;
import com.example.demo.repository.GenRepository;
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
public class GenServiceTest {
    @InjectMocks
    private GenService genService;

    @Mock
    private GenRepository genRepository;

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
    @DisplayName("Afisare genuri")
    public void getGenTest(){
        when(genRepository.getGen()).thenReturn(
                Arrays.asList(new Gen(1,"GenTest"))
        );

        List<Gen> result = genService.getGen();

        Gen gen = result.get(0);
        assertEquals(result.size(),1);
        assertEquals(gen.getIdGen(),1);
        assertEquals(gen.getNumeGen(),"GenTest");
    }

    @Test
    @DisplayName("Adaugarea unui gen")
    public void addGenTest(){
        Gen gen = new Gen(1,"GenTest");
        Gen savedGen = new Gen(1,"GenTest");
        when(genRepository.addGen(gen)).thenReturn(savedGen);

        Gen result = genService.addGen(gen);

        assertEquals(gen.getNumeGen(),result.getNumeGen());

        verify(genRepository,times(1)).addGen(gen);
    }

    @Test
    @DisplayName("Stergerea unui gen")
    public void deleteGenTest(){

        Gen gen = new Gen(1,"GenTest");

        when(genRepository.deleteGen(gen.getIdGen())).thenReturn(List.of(gen));

        List<Gen> result = genService.deleteGen(gen.getIdGen());

        assertEquals(gen.getIdGen(),1);
        assertEquals(gen.getNumeGen(),result.get(0).getNumeGen());

        verify(genRepository,times(1)).deleteGen(gen.getIdGen());

    }
}
