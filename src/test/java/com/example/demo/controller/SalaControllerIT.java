package com.example.demo.controller;

import com.example.demo.model.Sala;
import com.example.demo.service.SalaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SalaController.class)
public class SalaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalaService salaService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getSalaHappyFlow() throws Exception{

        Sala sala = new Sala(1,1,100,1);

        when(salaService.getSala()).thenReturn(
                Arrays.asList(new Sala(1,1,100,1))
        );

        mockMvc.perform(get("/sala/get")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(Arrays.asList(new Sala(1,1,100,1)))))
                .andExpect(status().isOk());

    }

    @Test
    public void addSalaHappyFlow() throws Exception{

        Sala sala = new Sala(1,1,100,1);

        when(salaService.addSala(any())).thenReturn(sala);

        mockMvc.perform(
                post("/sala/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(sala))
        ).andExpect(jsonPath("$.numarSala").value(sala.getNumarSala()));
    }

    @Test
    public void deleteSalaHappyFlow() throws Exception{

        Sala sala = new Sala(1,1,100,1);
        List<Sala> result = List.of(sala);

        when(salaService.deleteSalaById(1)).thenReturn(List.of());

        mockMvc.perform(delete("/sala/delete?id=" + sala.getIdSala())
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(sala)))
                .andExpect(status().isOk());

    }

}
