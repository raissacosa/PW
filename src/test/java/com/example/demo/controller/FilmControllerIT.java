package com.example.demo.controller;

import com.example.demo.model.Film;
import com.example.demo.model.Gen;
import com.example.demo.service.FilmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FilmController.class)
public class FilmControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService filmService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getFilmHappyFlow() throws Exception{

        Film film = new Film(1,"Wonder",200,2010,3,2);

        when(filmService.getFilm()).thenReturn(
                Arrays.asList(new Film(1,"Wonder",200,2010,3,2))
        );

        mockMvc.perform(get("/film/get")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(Arrays.asList(new Film(1,"Wonder",200,2010,3,2)))))
        .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeFilm").value(film.getNumeFilm()));
    }

    @Test
    public void addFilmHappyFlow() throws Exception{
        Film film = new Film(1,"Wonder",200,2010,3,2);
        when(filmService.addFilm(any())).thenReturn(film);

        mockMvc.perform(
                post("/film/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(film))
        ).andExpect(jsonPath("$.numeFilm").value(film.getNumeFilm()));
    }

    @Test
    public void deleteFilmHappyFlow() throws Exception{
        Film film = new Film(1,"Wonder",200,2010,3,2);

        when(filmService.deleteFilmById(1)).thenReturn(List.of());

        mockMvc.perform(delete("/film/delete?id=" + film.getIdFilm())
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(film)))
                .andExpect(status().isOk());
    }

    @Test
    public void getFilmByNameHappyFlow() throws Exception{

        Film film = new Film(1,"Wonder",200,2010,3,2);

        when(filmService.getFilmByName("Wonder")).thenReturn(
                Arrays.asList(new Film(1,"Wonder",200,2010,3,2))
        );

        mockMvc.perform(get("/film/getbyname?numeFilm=" + film.getNumeFilm())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(Arrays.asList(new Film(1,"Wonder",200,2010,3,2)))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeFilm").value(film.getNumeFilm()));
    }

    @Test
    public void getFilmByGenHappyFlow() throws Exception{

        Gen gen = new Gen(1,"Actiune");
        Film film = new Film(1,"Wonder",200,2010,3,2);

        when(filmService.getFilmByGen(gen.getNumeGen())).thenReturn(
                Arrays.asList(new Film(1,"Wonder",200,2010,3,2))
        );

        mockMvc.perform(get("/film/getbygen?numeGen=" + gen.getNumeGen())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(Arrays.asList(new Film(1,"Wonder",200,2010,3,2)))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeFilm").value(film.getNumeFilm()));
    }
}
