package com.example.demo.controller;

import com.example.demo.model.Cinema;
import com.example.demo.service.CinemaService;
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

@WebMvcTest(controllers = CinemaController.class)
public class CinemaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CinemaService cinemaService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addCinemaHappyFlow() throws Exception{
        Cinema cinema = new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005);

        when(cinemaService.addCinema(any())).thenReturn(cinema);

        mockMvc.perform(
                post("/cinema/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(cinema))
        ).andExpect(jsonPath("$.numeCinema").value(cinema.getNumeCinema()))
                .andExpect(jsonPath("$.oras").value(cinema.getOras()));
    }

    @Test
    public void GetCinemaHappyFlow() throws Exception{

        Cinema cinema = new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005);
        when(cinemaService.getCinema()).thenReturn(
                Arrays.asList(new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005)));

        mockMvc.perform(
                get("/cinema/get")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(Arrays.asList(new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005)))))
                .andExpect(jsonPath("$[0].numeCinema").value(cinema.getNumeCinema()));
    }

    @Test
    public void deleteCinemaHappyFlow() throws Exception{
        Cinema cinema = new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005);
        List<Cinema> result = List.of(cinema);

        when(cinemaService.deleteCinemaById(1)).thenReturn(List.of());

        mockMvc.perform(delete("/cinema/delete?id=" + cinema.getIdCinema())
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(cinema)))
                .andExpect(status().isOk());
    }

    @Test
    public void GetCinemaByOrasHappyFlow() throws Exception{

        Cinema cinema = new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005);
        when(cinemaService.getCinema()).thenReturn(
                Arrays.asList(new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005)));

        mockMvc.perform(
                get("/cinema/getbyoras?numeOras=" + cinema.getOras())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Arrays.asList(new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005)))))
                .andExpect(status().isOk());
    }

    @Test
    public void GetCinemaByAnHappyFlow() throws Exception{

        Cinema cinema = new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005);
        when(cinemaService.getCinemaBuildAfter(2000)).thenReturn(
                Arrays.asList(new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005)));

        mockMvc.perform(
                get("/cinema/afteryear?an=" + cinema.getAnConstructie())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(Arrays.asList(new Cinema(1,"Cinema City","Bacau","Starada Republicii Nr 123",2005)))))
                .andExpect(status().isOk());
    }

}
